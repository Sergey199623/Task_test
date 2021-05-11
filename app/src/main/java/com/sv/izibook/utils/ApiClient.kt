package com.sv.izibook.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class  ApiClient {
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

//    private fun generateClient(certificate: String): OkHttpClient {
//        var httpClientBuilder = OkHttpClient.Builder()
//            .readTimeout(60, TimeUnit.SECONDS)
//            .connectTimeout(60, TimeUnit.SECONDS)
//
//        // We're going to put our certificates in a Keystore
//        val keyStore = KeyStore.getInstance("PKCS12")
//        keyStore.load(null, null)
//
//        // generate input stream for certificate factory
//        // generate input stream for certificate factory
//        val stream: InputStream = IOUtils.toInputStream(certificate)
//
//        val cf: CertificateFactory = CertificateFactory.getInstance("X.509")
//        val ca: Certificate = cf.generateCertificate(stream)
//        ca = try {
//            cf.generateCertificate(stream)
//        } finally {
//            `is`.close()
//        }
//
//        ks.setCertificateEntry("my-ca", ca)
//
//        //Finally set the sslSocketFactory to our builder and build it
//        return httpClientBuilder
//            .sslSocketFactory(sslContext.socketFactory)
//            .build()
//    }
}