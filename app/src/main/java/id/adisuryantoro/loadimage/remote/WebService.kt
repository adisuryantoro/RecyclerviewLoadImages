package id.betn2020.accordinnovations.remote

import id.betn2020.accordinnovations.BuildConfig
import id.betn2020.accordinnovations.model.PhotosModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WebService {
    @GET ("photos")
    fun getPhotos(): Call<List<PhotosModel>>

    companion object {

        var retrofitService: WebService? = null

        fun getInstance() : WebService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.API_KEY)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(WebService::class.java)
            }
            return retrofitService!!
        }
    }
}