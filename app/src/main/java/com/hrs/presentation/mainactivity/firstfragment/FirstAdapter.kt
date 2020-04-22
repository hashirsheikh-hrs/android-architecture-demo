package com.hrs.presentation.mainactivity.firstfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hrs.R
import com.hrs.databinding.FirstItemBinding
import com.hrs.model.GitHubRepo

class FirstAdapter : RecyclerView.Adapter<FirstViewHolder>() {
    private var mList: List<GitHubRepo> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        return FirstViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.first_item, null, false)
        )
    }

    override fun getItemCount(): Int {
       return mList.size
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        holder.firstBinding?.model = mList[position]
    }

    internal fun setRepos(repoList: List<GitHubRepo>){
        this.mList = repoList
        notifyDataSetChanged()
    }
}

class FirstViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val firstBinding = DataBindingUtil.bind<FirstItemBinding>(itemView)
}