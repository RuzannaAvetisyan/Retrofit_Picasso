package ruzanna.game.retrofit_glide_picasso

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private val gson = GsonBuilder().setLenient().create()

    private val _retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    val retrofit: Retrofit
        get() {return _retrofit}


}