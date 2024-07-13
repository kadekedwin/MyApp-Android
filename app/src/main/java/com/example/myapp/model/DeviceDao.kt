package com.example.myapp.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DeviceDao {
    @Query("SELECT * FROM device")
    suspend fun getAll(): List<Device>

    @Insert
    suspend fun insert(device: Device)

    @Delete
    suspend fun delete(device: Device)
}
