package com.matheus.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.matheus.core.data.repository.ProductsRepository
import com.matheus.core.domain.model.Product
import com.matheus.core.usecase.base.ResultStatus
import com.matheus.core.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetProductsUseCase {

    operator fun invoke(query: String): Flow<List<Product>>
    data class GetProductsParams(val query: String)
}


class GetProductsUseCaseImpl @Inject constructor(
    private val productsRepository: ProductsRepository
    ) : UseCase<GetProductsUseCase.GetProductsParams, Product>(),
        GetProductsUseCase {
            
    override suspend fun doWork(params: GetProductsUseCase.GetProductsParams): ResultStatus<Product> {
        TODO("Not yet implemented")
    }

    override fun invoke(query: String): Flow<List<Product>> {
        TODO("Not yet implemented")
    }


}
