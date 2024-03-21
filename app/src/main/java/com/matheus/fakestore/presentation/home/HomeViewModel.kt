package com.matheus.fakestore.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheus.core.usecase.GetProductsUseCase
import com.matheus.core.usecase.GetProductsUseCase2
import com.matheus.core.usecase.base.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getProductsUseCase2: GetProductsUseCase2
): ViewModel() {

    private val _state = mutableStateOf(ProductsHitState())
    val state: State<ProductsHitState> = _state


    

    init {
        getProducts("")
    }

    private fun getProducts(query: String ) {
        getProductsUseCase2( query ).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ProductsHitState(products = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = ProductsHitState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = ProductsHitState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

//    suspend fun products(query: String) {
//        getProductsUseCase(
//            GetProductsUseCase.GetProductsParams(query))
//        ).cachedIn(viewModelScope).collect{
//            _recipesState.value = it
//        }
//    }

//    private fun onEvent(event: HomeEvent) {
//        viewModelScope.launch {
//            when (event) {
//                is HomeEvent.GetHome -> {
//                    products("tomato")
//                }
//            }
//        }
//    }


}


sealed class HomeEvent {
    object GetHome : HomeEvent()
}