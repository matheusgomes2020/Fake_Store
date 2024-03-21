package com.matheus.fakestore.framework.di

import com.matheus.core.usecase.GetProductsUseCase
import com.matheus.core.usecase.GetProductsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindRecipesUseCase2(useCase: GetProductsUseCaseImpl): GetProductsUseCase

}