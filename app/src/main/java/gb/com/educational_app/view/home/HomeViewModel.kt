package gb.com.educational_app.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gb.com.educational_app.model.datasource.ExamTime
import gb.com.educational_app.model.repository.ExamRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val examRepository: ExamRepository
) : ViewModel() {

    private val _examTime = MutableLiveData<ExamTime>()
    val examTime: LiveData<ExamTime> = _examTime

    fun getExamTime() {
        viewModelScope.launch {
            _examTime.postValue(examRepository.getExamTime())
        }
    }
}