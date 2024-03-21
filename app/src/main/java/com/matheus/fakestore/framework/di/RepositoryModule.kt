package com.matheus.fakestore.framework.di

import com.matheus.core.data.repository.ProductsRemoteDataSource
import com.matheus.core.data.repository.ProductsRepository
import com.matheus.fakestore.framework.network.response.DataWrapperResponse
import com.matheus.fakestore.framework.remote.ProductsRepositoryImpl
import com.matheus.fakestore.framework.remote.RetrofitProductsDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCharacterRepository(repository: ProductsRepositoryImpl ): ProductsRepository

    @Binds
    fun bindRemoteDataSource(
        dataSource: RetrofitProductsDataSource
    ): ProductsRemoteDataSource<DataWrapperResponse>

}