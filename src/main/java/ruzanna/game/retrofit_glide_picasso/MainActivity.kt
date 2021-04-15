package ruzanna.game.retrofit_glide_picasso

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Waiting for data loading.")
        progressDialog.setMessage("Loading...")

        val adapter = PhotosAdapter()
        photoRecyclerView.adapter = adapter
        photoRecyclerView.layoutManager = LinearLayoutManager(this)

        val photoApi = ApiService.retrofit.create(PhotoApi::class.java)
        val call  = photoApi.getphotos()

        progressDialog.show()

        call.enqueue(object : Callback<List<Photo>> {

            override fun onResponse(
                    call: Call<List<Photo>>,
                    response: Response<List<Photo>>
            ) {
                photoRecyclerView.post {
                    adapter.photosList = response.body()!!.toList()
                }
                adapter.notifyDataSetChanged()
                progressDialog.dismiss()
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
            }

        })
    }
}
