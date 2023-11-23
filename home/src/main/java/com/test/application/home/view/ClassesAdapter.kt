package com.test.application.home.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.application.core.domain.Classes
import com.test.application.core.utils.getIconBasedOnClassName
import com.test.application.core.utils.openSkype
import com.test.application.home.databinding.ItemHomeClassesBinding

class ClassesAdapter : RecyclerView.Adapter<ClassesAdapter.ClassesViewHolder>() {

    var classesList: List<Classes> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ClassesViewHolder(
        private val binding: ItemHomeClassesBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(classes: Classes){
            with(binding) {
                className.text = classes.className
                classTime.text = classes.classTime
                iconImage.setImageResource(getIconBasedOnClassName(classes.className))

                handleSkypeButton(classes, binding)
            }
        }

        private fun handleSkypeButton(classes: Classes, binding: ItemHomeClassesBinding) {
            with(binding) {
                if(classes.isOnline) {
                    skypeBtnBackground.visibility = View.VISIBLE
                    skypeBtnText.visibility = View.VISIBLE
                } else {
                    skypeBtnBackground.visibility = View.GONE
                    skypeBtnText.visibility = View.GONE
                }

                skypeBtnBackground.setOnClickListener {
                    openSkype(binding)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeClassesBinding.inflate(layoutInflater, parent, false)
        return ClassesViewHolder(binding)
    }

    override fun getItemCount(): Int = classesList.size

    override fun onBindViewHolder(holder: ClassesViewHolder, position: Int) {
        holder.bind(classesList[position])
    }
}