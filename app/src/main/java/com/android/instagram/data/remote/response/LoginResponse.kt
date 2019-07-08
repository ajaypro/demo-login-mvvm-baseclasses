package com.android.instagram.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Ajay Deepak on 05-07-2019.
 */


data class LoginResponse(

    @Expose
    @SerializedName("statusCode")
    val statusCode: String,

    @Expose
    @SerializedName("status")
    val status: Int,

    @Expose
    @SerializedName("message")
    val message: String,

    @Expose
    @SerializedName("accessToken")
    val accessToken: String,

    @Expose
    @SerializedName("userId")
    val userId: String,

    @Expose
    @SerializedName("userName")
    val userName: String,

    @Expose
    @SerializedName("userEmail")
    val userEmail: String,

    @Expose
    @SerializedName("profilePicUrl")
    val profilePicUrl: String? = null


)