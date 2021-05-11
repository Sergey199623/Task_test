package com.sv.izibook;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sv.izibook.interfaces.Api;
import com.sv.izibook.pojo.Anonim;
import com.sv.izibook.pojo.AnonimData;
import com.sv.izibook.pojo.CatList;
import com.sv.izibook.utils.ApiClient;
import com.sv.izibook.utils.SSLClient;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.sv.izibook.utils.Constants.API_URL_START_ANONIM;
import static com.sv.izibook.utils.Constants.API_URL_START_LIST;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAnonim();
    }

    private void getAnonim() {
        new ApiClient().getClient(API_URL_START_ANONIM).create(Api.class).anonymous().enqueue(new Callback<Anonim>() {
            @Override
            public void onResponse(Call<Anonim> call, Response<Anonim> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        getCatalog(response.body().getData());
                    } catch (CertificateException e) {
                        e.printStackTrace();
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    } catch (KeyStoreException e) {
                        e.printStackTrace();
                    } catch (KeyManagementException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (UnrecoverableKeyException e) {
                        e.printStackTrace();
                    }
                } else onFailure(call, new Throwable());
            }

            @Override
            public void onFailure(Call<Anonim> call, Throwable t) {
                Log.i("DEV", t.getMessage());
            }
        });
    }

    private void getCatalog(AnonimData data) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException, UnrecoverableKeyException {
        new Retrofit.Builder()
                .baseUrl(API_URL_START_LIST)
                .client(SSLClient.get(this,data))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api.class)
                .list()
                .enqueue(new Callback<CatList>() {
                    @Override
                    public void onResponse(Call<CatList> call, Response<CatList> response) {
                        Log.i("DEV", "Catalog response");
                    }

                    @Override
                    public void onFailure(Call<CatList> call, Throwable t) {
                        Log.i("DEV", "Catalog: " + t.getMessage());
                    }
                });
    }

    private void goMain() {
        overridePendingTransition(0, 0);
    }
}
