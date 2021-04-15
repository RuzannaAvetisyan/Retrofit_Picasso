package ruzanna.game.retrofit_glide_picasso

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row.view.*

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.ViewHolder> (){
    var photosList: List<Photo> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false))
    }


    override fun getItemCount(): Int {
        return photosList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.init(photosList[position])
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun init(photo: Photo){
            itemView.apply {
                photo_id.text = "ID: ${photo.id}"
                title.text = photo.title
                Picasso.get()
                        .load(photo.url)
                        .into(photoIV)
            }
        }
    }
}
