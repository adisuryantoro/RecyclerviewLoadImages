package id.adisuryantoro.loadimage.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.adisuryantoro.loadimage.databinding.ItemPhotosBinding
import id.adisuryantoro.loadimage.model.PhotosModel

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var photos = mutableListOf<PhotosModel>()

    fun setMovieList(photos: List<PhotosModel>) {
        this.photos = photos.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPhotosBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val photo = photos[position]

        Picasso.get()
            .load(photo.url)
            .resize(200, 200)
            .centerCrop()
            .into(holder.binding.ivPhotos)

        //glide not load image
//        Glide
//            .with(holder.itemView.context)
//            .load(photo.url)
//            .centerCrop()
//            .override(100, 100)
//            .into(holder.binding.ivPhotos)

        holder.binding.tvTitlePhotos.text = photo.title
    }

    override fun getItemCount(): Int {
        return photos.size
    }
}

class MainViewHolder(val binding: ItemPhotosBinding) : RecyclerView.ViewHolder(binding.root) {

}