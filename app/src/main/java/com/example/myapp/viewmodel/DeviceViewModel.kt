package com.example.myapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myapp.model.Device
import com.example.myapp.model.DeviceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DeviceViewModel(private val repository: DeviceRepository) : ViewModel() {

    val _devices = MutableStateFlow<List<Device>>(emptyList())

    val devices = _devices.asStateFlow()

    init {
        getAllDevice()
    }

    fun getAllDevice() {
        viewModelScope.launch {
            _devices.value = repository.devices()
        }
    }

    fun insertDevice(device: Device) {
        viewModelScope.launch {
            repository.insert(device)
            getAllDevice()
        }
    }

    fun deleteDevice(device: Device) {
        viewModelScope.launch {
            repository.delete(device)
            getAllDevice()
        }
    }

}

class DeviceViewModelFactory(private val repository: DeviceRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DeviceViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DeviceViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}