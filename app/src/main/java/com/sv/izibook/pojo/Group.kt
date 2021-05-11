package com.sv.izibook.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Это "элемент" каталога
 */

class Group {

    @SerializedName("icon")
    @Expose
    var icon: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("items")
    @Expose
    var items: List<Item>? = null

}