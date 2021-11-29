package com.boyright

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.boyright.databinding.ItemPhotoBinding

class PhotoAdapter(var context: MainActivity, private var photoList: List<Image>) :
    RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {
   private var Clicked = true
   inner class ViewHolder(binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.imageView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPhotoBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(photoList[position].imageSrc)
        holder.itemView.setBackgroundResource(photoList[position].start)
        holder.itemView.setOnClickListener {
            Clicked = if(Clicked) {holder.itemView.setBackgroundResource(R.drawable.click_stat__1_)

                false
            } else { holder.itemView.setBackgroundResource(R.drawable.start)
                true
            }


        }
    }



    override fun getItemCount():Int  {
        return photoList.size
    }

    fun get(): List<Image> {
        return photoList
    }

}
// END