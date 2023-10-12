package gb.com.educational_app.view.home

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import gb.com.educational_app.R
import gb.com.educational_app.databinding.FragmentHomeBinding
import gb.com.educational_app.model.datasource.Classes
import gb.com.educational_app.model.datasource.ExamTime
import gb.com.educational_app.model.datasource.Homework
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Calendar


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModel()

    private var countDownTimer: CountDownTimer? = null

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadData()
    }

    private fun initObservers() {
        viewModel.examTime.observe(viewLifecycleOwner) { examTime ->
            initCountdownBlock(examTime)
        }
        viewModel.classes.observe(viewLifecycleOwner) {classes ->
            initClassesRecyclerView(classes)
        }
        viewModel.homework.observe(viewLifecycleOwner) { homeworks ->
            initHomeworksRecyclerView(homeworks)
        }
    }

    private fun initHomeworksRecyclerView(homeworks: List<Homework>) {
        val adapter = HomeworksAdapter()
        adapter.homeworkList = homeworks
        binding.homeworks.homeworkRecyclerView
        binding.homeworks.homeworkRecyclerView.adapter = adapter
    }

    private fun initClassesRecyclerView(classes: List<Classes>) {
        binding.classes.classesCount.text = getString(R.string.classes_count, classes.size)
        val adapter = ClassesAdapter()
        adapter.classesList = classes
        binding.classes.classesRecyclerView.adapter = adapter
    }

    private fun initCountdownBlock(examTime: ExamTime?) {
        examTime?.let {
            val currentTime = Calendar.getInstance()
            val diff = it.targetTime.timeInMillis - currentTime.timeInMillis

            countDownTimer = object : CountDownTimer(diff, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    val minutes = (millisUntilFinished / (60*1000)) % 60
                    val hours = (millisUntilFinished / (60*60*1000)) % 24
                    val days = (millisUntilFinished / (24*60*60*1000))

                    with(binding.examCountdown) {
                        tvDaySecond.text = (days / 10).toString()
                        tvDayFirst.text = (days % 10).toString()

                        tvHoursSecond.text = (hours / 10).toString()
                        tvHoursFirst.text = (hours % 10).toString()
                        
                        tvMinutesSecond.text = (minutes / 10).toString()
                        tvMinutesFirst.text= (minutes % 10).toString()
                    }
                }

                override fun onFinish() {
                }
            }.start()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        initObservers()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        countDownTimer?.cancel()
    }
}