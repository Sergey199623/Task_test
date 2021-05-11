package com.sv.izibook.interfaces

import com.sv.izibook.pojo.Group
import java.util.*

interface Presenter {

    fun loadData()
    fun showData(data: ArrayList<Group>)
    fun showError(msg: String?)
}