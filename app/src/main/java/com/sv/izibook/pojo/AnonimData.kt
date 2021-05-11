package com.sv.izibook.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AnonimData {
    @SerializedName("public")
    @Expose
    var public: String? = null

    @SerializedName("private")
    @Expose
    var private: String? = null

    @SerializedName("expire")
    @Expose
    var expire: String? = null

    @SerializedName("pkcs12")
    @Expose
    var pkcs12: String? = null
}