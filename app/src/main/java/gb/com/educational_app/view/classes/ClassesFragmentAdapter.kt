package gb.com.educational_app.view.classes

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import gb.com.educational_app.databinding.ItemClassesBinding
import gb.com.educational_app.databinding.ItemFirstClassesBinding
import gb.com.educational_app.databinding.ItemLastClassesBinding
import gb.com.educational_app.model.datasource.Classes
import gb.com.educational_app.utils.getIconBasedOnClassName

class ClassesFragmentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var classesList: List<Classes> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    companion object {
        const val VIEW_TYPE_FIRST = 0
        const val VIEW_TYPE_MIDDLE = 1
        const val VIEW_TYPE_LAST = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            0 -> VIEW_TYPE_FIRST
            classesList.size - 1 -> VIEW_TYPE_MIDDLE
            else -> VIEW_TYPE_LAST
        }
    }

    class FirstClassesViewHolder(
        private val binding: ItemFirstClassesBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(classes: Classes, adapter: ClassesFragmentAdapter) {
            adapter.bindGeneralInfo(
                binding.className, binding.teacherName, binding.classIconImage, classes
            )
        }
    }

    class MiddleClassesViewHolder(
        private val binding: ItemClassesBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(classes: Classes, adapter: ClassesFragmentAdapter) {
            adapter.bindGeneralInfo(
                binding.className, binding.teacherName, binding.classIconImage, classes
            )
        }
    }

    class LastClassesViewHolder(
        private val binding: ItemLastClassesBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(classes: Classes, adapter: ClassesFragmentAdapter) {
            adapter.bindGeneralInfo(
                binding.className, binding.teacherName, binding.classIconImage, classes
            )
        }
    }

    private fun bindGeneralInfo(
        classNameTextView: TextView,
        teacherNameTextView: TextView,
        classIconImageView: ImageView,
        classes: Classes
    ) {
        classNameTextView.text = classes.className
        teacherNameTextView.text = classes.teacher
        classIconImageView.setImageResource(getIconBasedOnClassName(classes.className))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            VIEW_TYPE_FIRST -> FirstClassesViewHolder(
                ItemFirstClassesBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false))
            VIEW_TYPE_MIDDLE -> MiddleClassesViewHolder(
                ItemClassesBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false))
            else -> LastClassesViewHolder(
                ItemLastClassesBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun getItemCount() = classesList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is FirstClassesViewHolder -> holder.bind(classesList[position], this)
            is MiddleClassesViewHolder -> holder.bind(classesList[position], this)
            is LastClassesViewHolder -> holder.bind(classesList[position], this)
        }
    }
}