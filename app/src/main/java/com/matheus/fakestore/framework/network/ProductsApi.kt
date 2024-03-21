package com.matheus.fakestore.framework.network

import com.matheus.fakestore.framework.network.response.DataWrapperResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ProductsApi {

    @GET("products")
    suspend fun getProducts(
    ): DataWrapperResponse

}