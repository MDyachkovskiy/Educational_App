package gb.com.educational_app.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gb.com.educational_app.databinding.ItemClassesBinding
import gb.com.educational_app.model.datasource.Classes

class ClassesAdapter() : RecyclerView.Adapter<ClassesAdapter.ClassesViewHolder>() {

    var classesList: List<Classes> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ClassesViewHolder(
        private val binding: ItemClassesBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(classes: Classes){
            with(binding) {
                className.text = classes.className
                classesTime.text = classes.classTime
                userAvatarImage.setImageResource()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemClassesBinding.inflate(layoutInflater, parent, false)
        return ClassesViewHolder(binding)
    }

    override fun getItemCount() = classesList.size

    override fun onBindViewHolder(holder: ClassesViewHolder, position: Int) {
        holder.bind(classesList[position])
    }

    private fun getIconBasedOnClassName(className: String): Int {
        return when(className) {
            "Math"
        }
    }
}