package com.example.unsplash

import android.app.Application
import com.unsplash.pickerandroid.photopicker.UnsplashPhotoPicker

class Init : Application() {
    override fun onCreate() {
        super.onCreate()

        UnsplashPhotoPicker.init(
            this, "qv1dofP-Sn7hvmZTx3UDqzFk2YrM_rfOynokvMbeiMs", "YV0KiPKGeNYSxC-2FYJmWCM5cj3VTVmJg5bNqgazcGw", 20
        )
    }
}