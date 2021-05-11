package com.sv.izibook.interfaces

import com.sv.izibook.pojo.Anonim
import com.sv.izibook.pojo.CatList
import com.sv.izibook.utils.Constants
import retrofit2.Call
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api {

    @Headers("x-lang:ru-RU")
    @POST("globcat/list")
    fun list(): Call<CatList>

    @POST("anonymous")
    fun anonymous(): Call<Anonim>

}