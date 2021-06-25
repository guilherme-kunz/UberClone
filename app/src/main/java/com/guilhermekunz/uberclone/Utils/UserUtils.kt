package com.guilhermekunz.uberclone.Utils

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.guilhermekunz.uberclone.Common
import com.guilhermekunz.uberclone.Model.TokenModel
import com.guilhermekunz.uberclone.Services.MyFirebaseMessagingService

object UserUtils {

    fun updateUser(
        view: View?,
        updateData:Map<String,Any>
    ){
        FirebaseDatabase.getInstance()
            .getReference(Common.DRIVER_INFO_REFERENCE)
            .child(FirebaseAuth.getInstance().currentUser!!.uid)
            .updateChildren(updateData)
            .addOnFailureListener{ e->
                Snackbar.make(view!!,e.message!!,Snackbar.LENGTH_LONG).show()
            }.addOnFailureListener {
                Snackbar.make(view!!,"Update information Success",Snackbar.LENGTH_LONG).show()
            }
    }

    fun updateToken(contex: Context, token: String) {
            val tokenModel = TokenModel()
        tokenModel.token = token

        FirebaseDatabase.getInstance()
            .getReference(Common.TOKEN_REFERENCE)
            .child(FirebaseAuth.getInstance().currentUser!!.uid)
            .setValue(token)
            .addOnFailureListener { e-> Toast.makeText(contex,e.message,Toast.LENGTH_LONG).show()}
            .addOnSuccessListener {  }

    }

}