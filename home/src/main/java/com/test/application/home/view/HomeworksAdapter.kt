package com.test.application.home.view

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.test.application.core.domain.Homework
import com.test.application.core.utils.getIconBasedOnClassName
import com.test.application.home.R
import com.test.application.home.databinding.ItemHomeworkBinding
import java.util.Calendar
import java.util.concurrent.TimeUnit

class HomeworksAdapter : RecyclerView.Adapter<HomeworksAdapter.HomeworkViewHolder>() {

    var homeworkList: List<Homework> = listOf()
        set(value) {
            field = value.sortedBy { it.dueTime.timeInMillis }
            notifyDataSetChanged()
        }

    class HomeworkViewHolder(
        private val binding: ItemHomeworkBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(homework: Homework) {
            with(binding) {
                className.text = homework.className
                homeworkDescription.text = homework.description
                classIconImage.setImageResource(getIconBasedOnClassName(homework.className))
                loadRemainDays(binding, homework)
            }
        }

        private fun loadRemainDays(binding: ItemHomeworkBinding, homework: Homework) {
            val now = Calendar.getInstance()
            val diff = homework.dueTime.timeInMillis - now.timeInMillis
            val daysLeft = TimeUnit.MILLISECONDS.toDays(diff)
            binding.remainTime.text =
                String.format(itemView.context.getString(R.string.remain_time, daysLeft))

            if(daysLeft <= 2) {
                binding.remainTime.setTextColor(
                    ContextCompat.getColor(itemView.context,
                        com.test.application.core.R.color.attention_red_color_text)
                )

                val redDrawable = ContextCompat
                    .getDrawable(itemView.context, R.drawable.ic_time)?.mutate()
                redDrawable?.colorFilter = PorterDuffColorFilter(
                    ContextCompat.getColor(itemView.context,
                        com.test.application.core.R.color.attention_red_color_text),
                        PorterDuff.Mode.SRC_IN
                    )
                binding
                    .remainTime
                    .setCompoundDrawablesWithIntrinsicBounds(redDrawable,
                        null, null, null)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeworkViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeworkBinding.inflate(layoutInflater, parent, false)
        return HomeworkViewHolder(binding)
    }

    override fun getItemCount(): Int = homeworkList.size

    override fun onBindViewHolder(holder: HomeworkViewHolder, position: Int) {
        holder.bind(homeworkList[position])
    }
}