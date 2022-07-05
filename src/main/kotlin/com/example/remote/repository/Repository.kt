package com.example.remote.repository

import com.example.remote.RemoteInstance
import remote.model.Goods
import remote.model.GoodsItem
import retrofit2.Response

class Repository {
    suspend fun fetchGoods() : Response<Goods> {
        return RemoteInstance.getInstance().goods.getAllGoods()
    }
}