package gb.com.educational_app.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gb.com.educational_app.databinding.ItemHomeClassesBinding
import gb.com.educational_app.model.datasource.Classes
import gb.com.educational_app.utils.getIconBasedOnClassName

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