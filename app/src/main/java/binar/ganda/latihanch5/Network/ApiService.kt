package binar.ganda.latihanch5.Network

import binar.ganda.latihanch5.Model.GetAllCountryResponseItem
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
        @GET("all")
        fun getAllCountry() : Call<List<GetAllCountryResponseItem>>
}
