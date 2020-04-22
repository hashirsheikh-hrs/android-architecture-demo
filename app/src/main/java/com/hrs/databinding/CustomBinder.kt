package com.hrs.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.hrs.R

class CustomBinder {
    companion object{
        @JvmStatic
        @BindingAdapter("loadFromUrl")
        fun loadFromUrl(iv: ImageView?, url: String?){
            iv?.let {
                Glide.with(it.context).load(url).
                error(R.mipmap.ic_launcher_round).
                placeholder(R.mipmap.ic_launcher).
                into(it);
            }
        }
    }
}