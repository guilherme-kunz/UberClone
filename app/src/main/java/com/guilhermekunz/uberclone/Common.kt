package com.guilhermekunz.uberclone

import com.guilhermekunz.uberclone.Model.DriverInfoModel
import java.lang.StringBuilder

object Common {
    fun buildWelcomeMessage(): String {
        return StringBuilder("Welcome, ")
            .append(currentUser!!.firstName)
            .append(" ")
            .append(currentUser!!.lastName)
            .toString()
    }

    val DRIVERS_LOCATION_REFERENCE: String="DriverLocation"
    var currentUser: DriverInfoModel?=null
    val DRIVER_INFO_REFERENCE: String = "DriveInfo"
}