package com.example.daerah_indonesia_app.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {
    companion object {
        fun getRetrofit(): DaerahService {
            var retrofit = Retrofit.Builder()
                .baseUrl("https://ibnux.github.io/data-indonesia/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            var service: DaerahService = retrofit.create(DaerahService::class.java)
            return service
        }
    }
}



