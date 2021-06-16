package id.adisuryantoro.loadimage.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.adisuryantoro.loadimage.model.PhotosModel
import id.adisuryantoro.loadimage.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val photosList = MutableLiveData<List<PhotosModel>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllPhotos() {

        val response = repository.getAllPhotos()
        response.enqueue(object : Callback<List<PhotosModel>> {
            override fun onResponse(call: Call<List<PhotosModel>>, response: Response<List<PhotosModel>>) {
                photosList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<PhotosModel>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}