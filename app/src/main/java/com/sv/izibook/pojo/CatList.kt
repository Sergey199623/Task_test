package com.sv.izibook.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CatList {

    @SerializedName("data")
    @Expose
    var data: List<Group>? = null

    @SerializedName("result")
    @Expose
    var result: String? = null

    @SerializedName("results")
    @Expose
    var results: Int? = null
}