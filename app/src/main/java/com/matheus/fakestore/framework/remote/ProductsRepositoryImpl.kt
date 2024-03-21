package com.matheus.fakestore.framework.remote

import com.matheus.core.data.repository.ProductsRemoteDataSource
import com.matheus.core.data.repository.ProductsRepository
import com.matheus.core.domain.model.Product
import com.matheus.fakestore.framework.network.response.DataWrapperResponse
import com.matheus.fakestore.framework.network.response.toProductModel
import com.matheus.fakestore.framework.paging.ProductsPagingSource
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val remoteDataSource: ProductsRemoteDataSource<DataWrapperResponse>
) : ProductsRepository{
    override suspend fun getProducts(query: String): List<Product> {
        val response = remoteDataSource.fetchProducts(query)
        return response.map { it.toProductModel() }
    }
}