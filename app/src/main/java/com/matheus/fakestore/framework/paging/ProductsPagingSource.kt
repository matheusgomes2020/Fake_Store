package com.matheus.fakestore.framework.paging

import com.matheus.core.data.repository.ProductsRemoteDataSource
import com.matheus.fakestore.framework.network.response.DataWrapperResponse

class ProductsPagingSource(
    private val remoteDataSource: ProductsRemoteDataSource<DataWrapperResponse>,
    private val query: String
) {

    suspend fun load(){
        val response = remoteDataSource.fetchProducts( query )
    }


}