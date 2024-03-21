package com.matheus.fakestore.presentation.home

import com.matheus.core.domain.model.Product

data class ProductsHitState (
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String = ""
)