package com.matheus.fakestore.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheus.fakestore.data.PreferenceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val preferenceRepository: PreferenceRepository
): ViewModel(){

    private var _switchState = MutableStateFlow(SwitchState())
    val switchState = _switchState.asStateFlow()

    val isDarkModeEnabled = preferenceRepository.isDarkModeEnabled
    val isOnboardingEnabled = preferenceRepository.isOnboardingEnabled

    fun onCheckChange(isChecked: Boolean) {
        _switchState.update {
            switchState.value.copy(isChecked = isChecked)
        }
    }

    fun setDarkModel(isSet: Boolean) {
        viewModelScope.launch {
            preferenceRepository.setDarkMode(isSet)
        }
    }

    fun setIsOnboarding(isSet: Boolean) {
        viewModelScope.launch {
            preferenceRepository.setOnboarding(isSet)
        }
    }

}