package com.matheus.core.data.repository

import com.matheus.core.domain.model.Product

interface ProductsRepository {

    suspend fun getProducts(query: String) : List<Product>

}