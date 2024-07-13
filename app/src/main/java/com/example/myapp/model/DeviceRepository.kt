package com.example.myapp.model

class DeviceRepository(private val deviceDao: DeviceDao) {

    suspend fun devices(): List<Device> {
        return deviceDao.getAll()
    }

    suspend fun insert(device: Device) {
        deviceDao.insert(device)
    }

    suspend fun delete(device: Device) {
        deviceDao.delete(device)
    }
}