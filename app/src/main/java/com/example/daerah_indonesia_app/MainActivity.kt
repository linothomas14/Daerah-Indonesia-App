package com.example.daerah_indonesia_app

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.daerah_indonesia_app.adapter.ProvinsiAdapter
import com.example.daerah_indonesia_app.model.Daerah
import com.example.daerah_indonesia_app.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(isConnect()){
            ConfigNetwork.getRetrofit().getDataDaerah().enqueue(object :Callback<ArrayList<Daerah>>{
                override fun onResponse(call: Call<ArrayList<Daerah>>, response: Response<ArrayList<Daerah>>) {
                    Log.d("success",response.message())
                    progress.visibility = View.GONE
                    if(response.isSuccessful){
                        val data = response.body()
                        showData(data)
                    }

                }

                override fun onFailure(call: Call<ArrayList<Daerah>>, t: Throwable) {
                    Log.d("error",t.message)
                    progress.visibility = View.GONE
                }
            })
        } else {
            progress.visibility = View.GONE
            Toast.makeText(this,"Tidak ada jaringan internet",Toast.LENGTH_LONG).show()
        }
        }


    fun isConnect():Boolean{
        val connect: ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connect.activeNetworkInfo != null && connect.activeNetworkInfo.isConnected
    }

    private fun showData(data: ArrayList<Daerah>?) {
       listProvinsi.adapter = ProvinsiAdapter(data)

    }
}
