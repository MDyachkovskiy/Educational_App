package gb.com.educational_app.view.classes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gb.com.educational_app.model.datasource.Classes
import gb.com.educational_app.model.repository.ClassesRepository
import kotlinx.coroutines.launch

class ClassesViewModel(
    private val classesRepository: ClassesRepository
) : ViewModel() {

    private val _classes = MutableLiveData<List<Classes>>()
    val classes: LiveData<List<Classes>> get() = _classes

    fun loadClasses() {
        viewModelScope.launch {
            _classes.postValue(classesRepository.getClasses())
        }
    }
}