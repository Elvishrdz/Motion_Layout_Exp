package com.eahm.motionlayoutexperiments.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.eahm.motionlayoutexperiments.R
import com.eahm.motionlayoutexperiments.models.MainElements

class MainAdapter(
    private val content : List<MainElements>
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

    private lateinit var rootView : View

    inner class MainViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val root : ConstraintLayout = view.findViewById(R.id.clMenu)
        private val title : TextView = view.findViewById(R.id.tvMenuTitle)
        private val description : TextView = view.findViewById(R.id.tvMenuDescription)

        fun bind(elements: MainElements) {
            title.text = elements.title
            description.text = elements.description
            root.setOnClickListener{
                rootView.context.startActivity(Intent(rootView.context, elements.activity))
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        rootView = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent,  false)
        return MainViewHolder(rootView)
    }

    override fun getItemCount(): Int = content.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(content[position])
    }
}