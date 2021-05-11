package com.sv.izibook.utils;

import android.content.Context;
import android.util.Log;

import com.sv.izibook.R;
import com.sv.izibook.SelfSigningClientBuilder;
import com.sv.izibook.pojo.AnonimData;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509TrustManager;

import nl.altindag.ssl.SSLFactory;
import nl.altindag.ssl.util.PemUtils;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class SSLClient {


    public static OkHttpClient get(Context ctx,AnonimData data) throws KeyManagementException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, CertificateException, IOException {

       return SelfSigningClientBuilder.createClient(ctx);
//
//        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
//                .readTimeout(60, TimeUnit.SECONDS)
//                .connectTimeout(60, TimeUnit.SECONDS);
//
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        return okHttpClient
//                .addInterceptor(interceptor)
//                .sslSocketFactory(createCertificate(ctx,data).getSslSocketFactory(),systemDefaultTrustManager())
//                .build();
    }

    private static SSLFactory createCertificate(Context ctx,AnonimData data) throws CertificateException, IOException, KeyStoreException, KeyManagementException, NoSuchAlgorithmException{
        Log.i("DEV",data.getPublic());
        Log.i("DEV","*************************");
        Log.i("DEV","*************************");
        Log.i("DEV","*************************");
        Log.i("DEV",data.getPrivate());
        InputStream certificate = ctx.getResources().openRawResource(R.raw.cert);
        InputStream privateKey = ctx.getResources().openRawResource(R.raw.key);

        X509ExtendedKeyManager keyManager = PemUtils.loadIdentityMaterial(certificate,privateKey);

        return SSLFactory.builder()
                .withIdentityMaterial(keyManager)
                .withTrustMaterial(systemDefaultTrustManager())
                .build();

    }

    private static X509TrustManager systemDefaultTrustManager() {

        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            }
            return (X509TrustManager) trustManagers[0];
        } catch (GeneralSecurityException e) {
            throw new AssertionError(); // The system has no TLS. Just give up.
        }

    }


}
