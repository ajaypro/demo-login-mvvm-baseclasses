package com.android.instagram.utils.common

import com.android.instagram.R
import java.util.regex.Pattern

/**
 * Created by Ajay Deepak on 03-07-2019.
 */

object Validator{

    private val EMAIL_ADDRESS = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    private const val MIN_PASSWORD_LENGTH = 6


    fun validationFields(email: String?, password: String?): List<Validation> =
        ArrayList<Validation>().apply {
            when {
                email.isNullOrBlank() ->
                    add(Validation(Validation.Field.EMAIL, Resource.error(R.string.email_blank)))
                !EMAIL_ADDRESS.matcher(email).matches() ->
                    add(Validation(Validation.Field.EMAIL, Resource.error(R.string.email_wrong)))
                else ->
                    add(Validation(Validation.Field.EMAIL, Resource.success(R.string.email_success)))
            }
            when {
                password.isNullOrBlank() ->
                    add(Validation(Validation.Field.PASSWORD, Resource.error(R.string.password_blank)))
                password.length < MIN_PASSWORD_LENGTH ->
                    add(Validation(Validation.Field.PASSWORD, Resource.error(R.string.password_wrong)))
                else ->
                    add(Validation(Validation.Field.PASSWORD, Resource.success(R.string.password_success)))
            }
        }

}


data class Validation(val field: Field, val resource: Resource<Int>) {

    enum class Field {
        EMAIL,
        PASSWORD
    }
}
