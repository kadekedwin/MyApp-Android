package com.example.myapp.model

import android.app.Application

class DeviceApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { DeviceRepository(database.deviceDao()) }
}