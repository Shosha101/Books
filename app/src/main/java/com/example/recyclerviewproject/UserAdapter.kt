package com.example.recyclerviewproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val data: List<User>) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    class MyViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val tvName: TextView = row.findViewById(R.id.tv_name)
        val tvEmail: TextView = row.findViewById(R.id.tv_email)
        val img: ImageView = row.findViewById(R.id.userImageView)
        val wantToReadButton: Button = itemView.findViewById(R.id.button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return MyViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = data[position]
        holder.tvName.text = user.name
        holder.tvEmail.text = user.email
        holder.img.setImageResource(user.imageResId) // Set the image resource using the user object
        holder.wantToReadButton.setOnClickListener {
            Toast.makeText(holder.itemView.context, R.string.wantRead, Toast.LENGTH_SHORT).show()
        }
    }
}
