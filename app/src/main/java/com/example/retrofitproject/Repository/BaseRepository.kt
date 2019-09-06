package com.example.retrofitproject.Repository

import android.util.Log
import retrofit2.Response
import java.io.IOException

open class BaseRepository{

     fun <T : Any> safeApiCall(call:  () -> Response<T>, errorMessage: String): T? {


        val result : Result<T> = safeApiResult(call,errorMessage)
        var data : T? = null

        when(result) {
            is Result.Success ->
                data = result.data
            is Result.Error -> {
                Log.d("1.DataRepository", "$errorMessage & Exception - ${result.exception}")
            }
        }


        return data

    }

    private  fun <T: Any> safeApiResult(call:  ()-> Response<T>, errorMessage: String) : Result<T> {
        val response = call.invoke()
        if(response.isSuccessful) return Result.Success(response.body()!!)

        return Result.Error(IOException("Error Occurred during getting safe Api result, Custom ERROR - $errorMessage"))
    }
}