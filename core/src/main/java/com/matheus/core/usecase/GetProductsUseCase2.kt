package com.matheus.core.usecase

import com.matheus.core.data.repository.ProductsRepository
import com.matheus.core.domain.model.Product
import com.matheus.core.usecase.base.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetProductsUseCase2 @Inject constructor(
    private val repository: ProductsRepository
) {

    operator fun invoke( query: String ): Flow<Resource<List<Product>>> = flow {

        try {
            emit( Resource.Loading<List<Product>>() )
            val recipes = repository.getProducts( query )
            emit(Resource.Success<List<Product>>(recipes))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Product>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Product>>("Couldn't reach server. Check your internet connection."))
        }

    }
}