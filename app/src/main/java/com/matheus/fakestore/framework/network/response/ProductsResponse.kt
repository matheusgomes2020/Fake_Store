package com.matheus.fakestore.framework.network.response

import com.matheus.core.domain.model.Product

data class ProductsResponse (

    val id: String,
    val title: String,
    val price: String,
    val description: String,
    val category: String,
    val image: String,
    val rating: RatingResponse

)

fun ProductsResponse.toProductModel(): Product {
    return Product(
        id = this.id,
        image = this.image,
        category = this.category,
        description = this.description,
        price = this.price,
        title = this.title,
        rating = this.rating.rate,
        count = this.rating.count
    )
}