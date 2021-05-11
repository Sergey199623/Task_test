package com.sv.izibook.interfaces

import com.sv.izibook.pojo.Group
import java.util.ArrayList

interface InterfaceView {

    fun showErrorMsg(msg: String?)
    fun showGroup(data: ArrayList<Group>)
}