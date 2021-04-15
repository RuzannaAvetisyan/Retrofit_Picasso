package ruzanna.game.retrofit_glide_picasso

import retrofit2.Call
import retrofit2.http.GET

interface PhotoApi {
    @GET("photos")
    fun getphotos(): Call<List<Photo>>
}