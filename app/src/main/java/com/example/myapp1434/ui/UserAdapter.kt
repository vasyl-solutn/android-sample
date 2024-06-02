// File: app/src/main/java/com/example/myapp1434/ui/UserAdapter.kt
package com.example.myapp1434.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp1434.R
import com.example.myapp1434.model.User

class UserAdapter(private val users: List<User>, private val clickListener: (User) -> Unit) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.nameTextView.text = user.name
        holder.emailTextView.text = user.email
        holder.itemView.setOnClickListener { clickListener(user) }
    }

    override fun getItemCount(): Int {
        return users.size
    }
}
