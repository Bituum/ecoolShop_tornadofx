package com.example.remote.api

import remote.model.Goods
import retrofit2.Response
import retrofit2.http.GET

interface GoodsApi {
    @GET("./goods")
    suspend fun getAllGoods() : Response<Goods>
}