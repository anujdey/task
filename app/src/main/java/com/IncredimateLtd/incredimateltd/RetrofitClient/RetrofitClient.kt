package com.IncredimateLtd.incredimateltd.RetrofitClient

import com.IncredimateLtd.incredimateltd.Interface.ApiServices
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {

    const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    operator fun invoke(): ApiServices {

        val client = OkHttpClient.Builder()

            .connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS).build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build().create(ApiServices::class.java)
    }


}