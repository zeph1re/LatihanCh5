package binar.ganda.latihanch5

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import binar.ganda.latihanch5.Adapter.CountryAdapter
import binar.ganda.latihanch5.Model.GetAllCountryResponseItem
import binar.ganda.latihanch5.Network.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDataCountry()

    }

    private fun getDataCountry() {
        ApiClient.instance.getAllCountry()
            .enqueue(object: retrofit2.Callback<List<GetAllCountryResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllCountryResponseItem>>,
                    response: Response<List<GetAllCountryResponseItem>>
                ) {
                    if(response.isSuccessful) {
                        val dataCountry = response.body()
                        country_rv.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                        country_rv.adapter = CountryAdapter(dataCountry!!)
                    } else {
                        Toast.makeText(this@MainActivity, response.message() , Toast.LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<List<GetAllCountryResponseItem>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message , Toast.LENGTH_LONG).show()
                }
            })
    }

    override fun onResume() {
        super.onResume()
        getDataCountry()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}