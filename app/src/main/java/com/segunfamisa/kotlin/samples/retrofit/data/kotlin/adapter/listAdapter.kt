package com.segunfamisa.kotlin.samples.retrofit.data.kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.segunfamisa.kotlin.samples.retrofit.MainActivity
import com.segunfamisa.kotlin.samples.retrofit.R
import com.segunfamisa.kotlin.samples.retrofit.data.kotlin.notificationModel.VoiceActingRoleItem

/**
 * Created by Amirul on 12/6/17.
 */
class listAdapter(val userList: List<VoiceActingRoleItem>?, val mainActivity: MainActivity) : RecyclerView.Adapter<listAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: listAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList!![position],mainActivity)
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList!!.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: VoiceActingRoleItem, mainActivity: MainActivity) {
            val textViewName = itemView.findViewById(R.id.text) as TextView
            val Imageview = itemView.findViewById(R.id.image) as ImageView
//            val textViewAddress  = itemView.findViewById(R.id.textViewAddress) as TextView
            textViewName.text = user.anime!!.name

            Glide.with(mainActivity).load(user.anime.image).placeholder(R.mipmap.ic_launcher).fitCenter().error(R.mipmap.ic_launcher).into(Imageview)
//            textViewAddress.text = user.address
        }
    }
}