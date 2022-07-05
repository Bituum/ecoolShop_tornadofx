package com.example.remote

import com.example.remote.api.GoodsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteInstance private constructor() {
    lateinit var goods: GoodsApi

    companion object {
        private var remote: RemoteInstance? = null

        fun getInstance(): RemoteInstance {
            if (remote == null) {
                remote = RemoteInstance()
            }

            remote?.createRetrofitInstances()
            return remote!!
        }
    }

    private fun createRetrofitInstances() {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val goodsRetrofit = createGoodsInstance(okHttpClient)

        goods = goodsRetrofit.create(GoodsApi::class.java)
        //TODO добавлять новые сущности сюда
    }

    private fun createGoodsInstance(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://127.0.0.1:8080/api/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}