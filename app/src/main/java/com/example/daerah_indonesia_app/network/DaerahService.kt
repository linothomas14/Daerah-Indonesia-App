package com.example.daerah_indonesia_app.network

import com.example.daerah_indonesia_app.model.Daerah
import com.example.daerah_indonesia_app.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface DaerahService {
    @GET("propinsi.json")
    fun getDataDaerah():Call<ArrayList<Daerah>>
}