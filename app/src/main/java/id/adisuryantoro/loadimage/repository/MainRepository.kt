package id.adisuryantoro.loadimage.repository

import id.adisuryantoro.loadimage.remote.WebService

class MainRepository constructor(private val webService: WebService) {

    fun getAllPhotos() = webService.getPhotos()
}
