package gb.com.educational_app.view.classes

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import gb.com.educational_app.R
import gb.com.educational_app.databinding.ItemClassesBinding
import gb.com.educational_app.databinding.ItemFirstClassesBinding
import gb.com.educational_app.databinding.ItemLastClassesBinding
import gb.com.educational_app.model.datasource.Classes
import gb.com.educational_app.utils.findCurrentClassPosition
import gb.com.educational_app.utils.getIconBasedOnClassName
import gb.com.educational_app.utils.openSkype

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
        return when (position) {
            0 -> VIEW_TYPE_FIRST
            classesList.size - 1 -> VIEW_TYPE_LAST
            else -> VIEW_TYPE_MIDDLE
        }
    }

    interface BindingSetup {
        val className: TextView
        val teacherName: TextView
        val classIconImage: ImageView
        val classesTime: TextView
        val classesDescription: TextView
        val gradientBackground: FrameLayout
        val outerCircle: View
        val innerCircle: View
        val teacherTitle: TextView
        val skypeBtnBackground: View
        val skypeBtnText: TextView
    }

    fun ItemFirstClassesBinding.toBindingSetup() = object : BindingSetup {
        override val className: TextView get() = this@toBindingSetup.className
        override val teacherName: TextView get() = this@toBindingSetup.teacherName
        override val classIconImage: ImageView get() = this@toBindingSetup.classIconImage
        override val classesTime: TextView get() = this@toBindingSetup.classesTime
        override val classesDescription: TextView get() = this@toBindingSetup.classesDescription
        override val gradientBackground: FrameLayout get() = this@toBindingSetup.gradientBackground
        override val outerCircle: View get() = this@toBindingSetup.outerCircle
        override val innerCircle: View get() = this@toBindingSetup.innerCircle
        override val teacherTitle: TextView get() = this@toBindingSetup.teacherTitle
        override val skypeBtnBackground: View get() = this@toBindingSetup.skypeBtnBackground
        override val skypeBtnText: TextView get() = this@toBindingSetup.skypeBtnText

    }

    fun ItemClassesBinding.toBindingSetup() = object : BindingSetup {
        override val className: TextView get() = this@toBindingSetup.className
        override val teacherName: TextView get() = this@toBindingSetup.teacherName
        override val classIconImage: ImageView get() = this@toBindingSetup.classIconImage
        override val classesTime: TextView get() = this@toBindingSetup.classesTime
        override val classesDescription: TextView get() = this@toBindingSetup.classesDescription
        override val gradientBackground: FrameLayout get() = this@toBindingSetup.gradientBackground
        override val outerCircle: View get() = this@toBindingSetup.outerCircle
        override val innerCircle: View get() = this@toBindingSetup.innerCircle
        override val teacherTitle: TextView get() = this@toBindingSetup.teacherTitle
        override val skypeBtnBackground: View get() = this@toBindingSetup.skypeBtnBackground
        override val skypeBtnText: TextView get() = this@toBindingSetup.skypeBtnText
    }

    fun ItemLastClassesBinding.toBindingSetup() = object : BindingSetup {
        override val className: TextView get() = this@toBindingSetup.className
        override val teacherName: TextView get() = this@toBindingSetup.teacherName
        override val classIconImage: ImageView get() = this@toBindingSetup.classIconImage
        override val classesTime: TextView get() = this@toBindingSetup.classesTime
        override val classesDescription: TextView get() = this@toBindingSetup.classesDescription
        override val gradientBackground: FrameLayout get() = this@toBindingSetup.gradientBackground
        override val outerCircle: View get() = this@toBindingSetup.outerCircle
        override val innerCircle: View get() = this@toBindingSetup.innerCircle
        override val teacherTitle: TextView get() = this@toBindingSetup.teacherTitle
        override val skypeBtnBackground: View get() = this@toBindingSetup.skypeBtnBackground
        override val skypeBtnText: TextView get() = this@toBindingSetup.skypeBtnText
    }

    class FirstClassesViewHolder(
        private val binding: ItemFirstClassesBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(classes: Classes, adapter: ClassesFragmentAdapter, isCurrentClass: Boolean) {
            adapter.bindGeneralInfo(binding, classes, isCurrentClass)
        }
    }

    class MiddleClassesViewHolder(
        private val binding: ItemClassesBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(classes: Classes, adapter: ClassesFragmentAdapter, isCurrentClass: Boolean) {
            adapter.bindGeneralInfo(binding, classes, isCurrentClass)
        }
    }

    class LastClassesViewHolder(
        private val binding: ItemLastClassesBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(classes: Classes, adapter: ClassesFragmentAdapter, isCurrentClass: Boolean) {
            adapter.bindGeneralInfo(binding, classes, isCurrentClass)
        }
    }

    private fun bindGeneralInfo(
        binding: ViewBinding,
        classes: Classes,
        isCurrentClass: Boolean
    ) {
        val setup = when (binding) {
            is ItemFirstClassesBinding -> binding.toBindingSetup()
            is ItemClassesBinding -> binding.toBindingSetup()
            is ItemLastClassesBinding -> binding.toBindingSetup()
            else -> throw IllegalArgumentException("Unknown binding class")
        }

        with(setup) {
            className.text = classes.className
            teacherName.text = classes.teacher
            classesTime.text = classes.classTime
            classIconImage.setImageResource(getIconBasedOnClassName(classes.className))

            handleUiDesign(outerCircle, innerCircle, isCurrentClass, binding.root)
            handleSkypeButton(skypeBtnBackground, skypeBtnText, classes, binding)

            if (classes.comments.isNullOrEmpty()) {
                classesDescription.visibility = View.GONE
            } else {
                classesDescription.visibility = View.VISIBLE
                classesDescription.text = classes.comments
            }

            updateUiForFacultativeClass(
                classes.isFacultative, gradientBackground, binding.root,
                teacherTitle, teacherName, classesDescription
            )
        }
    }

    private fun handleSkypeButton(
        skypeBtnBackground: View, skypeText: TextView, classes: Classes, binding: ViewBinding
    ) {
        if (classes.isOnline) {
            skypeBtnBackground.visibility = View.VISIBLE
            skypeText.visibility = View.VISIBLE
        } else {
            skypeBtnBackground.visibility = View.GONE
            skypeText.visibility = View.GONE
        }

        skypeBtnBackground.setOnClickListener {
            openSkype(binding)
        }
    }

    private fun handleUiDesign(
        outerCircle: View, innerCircle: View, isCurrentClass: Boolean, itemView: View
    ) {
        outerCircle.visibility = if (isCurrentClass) View.VISIBLE else View.GONE
        if (isCurrentClass) {
            innerCircle.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(itemView.context, R.color.white)
            )
        }
    }

    private fun updateUiForFacultativeClass(
        isFacultative: Boolean,
        gradientBackground: FrameLayout,
        itemView: View,
        vararg textViews: TextView
    ) {
        if (isFacultative) {
            gradientBackground.visibility = View.VISIBLE

            val color = ContextCompat.getColor(itemView.context, R.color.white)
            textViews.forEach { it.setTextColor(color) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_FIRST -> FirstClassesViewHolder(
                ItemFirstClassesBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
            )

            VIEW_TYPE_MIDDLE -> MiddleClassesViewHolder(
                ItemClassesBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
            )

            else -> LastClassesViewHolder(
                ItemLastClassesBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    override fun getItemCount() = classesList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val isCurrentClass = position == findCurrentClassPosition(classesList)
        when (holder) {
            is FirstClassesViewHolder -> holder.bind(classesList[position], this, isCurrentClass)
            is MiddleClassesViewHolder -> holder.bind(classesList[position], this, isCurrentClass)
            is LastClassesViewHolder -> holder.bind(classesList[position], this, isCurrentClass)
        }
    }
}