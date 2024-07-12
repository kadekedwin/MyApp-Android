package com.example.myapp.viewmodel

import com.example.myapp.R

class DeviceCardModel(title: String, count: Int, image: Int) {
    val title = title
    val count = count
    var image = image
}


class HomeViewModel {
    val deviceCards = arrayListOf(
        DeviceCardModel(title= "Smart Lights", count = 4, image = R.drawable.lamp),
        DeviceCardModel(title= "Smart AC", count = 2, image = R.drawable.ac),
        DeviceCardModel(title= "Smart TV", count = 3, image = R.drawable.tv),
        DeviceCardModel(title= "Smart Speaker", count = 2, image = R.drawable.speaker),

        DeviceCardModel(title= "Smart Lights", count = 4, image = R.drawable.lamp),
        DeviceCardModel(title= "Smart AC", count = 2, image = R.drawable.ac),
        DeviceCardModel(title= "Smart TV", count = 3, image = R.drawable.tv),
        DeviceCardModel(title= "Smart Speaker", count = 2, image = R.drawable.speaker)
    )
}

