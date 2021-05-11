package com.sv.izibook.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Это анонимный сертификат
 */

class Anonim {

    @SerializedName("result")
    @Expose
    var result: String? = null

    @SerializedName("data")
    @Expose
    var data: AnonimData? = null
}