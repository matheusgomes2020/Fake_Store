package com.matheus.fakestore.framework.remote

import com.matheus.core.data.repository.ProductsRemoteDataSource
import com.matheus.fakestore.framework.network.ProductsApi
import com.matheus.fakestore.framework.network.response.DataWrapperResponse
import javax.inject.Inject

class RetrofitProductsDataSource @Inject constructor(
    private val productsApi: ProductsApi
) : ProductsRemoteDataSource<DataWrapperResponse> {


    override suspend fun fetchProducts(queries: String): DataWrapperResponse {
        return productsApi.getProducts()
    }
}