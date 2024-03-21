package com.matheus.core.data.repository

interface ProductsRemoteDataSource<T> {
    suspend fun fetchProducts(queries: String) : T
}