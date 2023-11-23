package gb.com.educational_app.di

import gb.com.educational_app.model.repository.ClassesRepository
import gb.com.educational_app.model.repository.ClassesRepositoryImpl
import gb.com.educational_app.model.repository.ExamRepository
import gb.com.educational_app.model.repository.ExamRepositoryImpl
import gb.com.educational_app.model.repository.HomeworkRepository
import gb.com.educational_app.model.repository.HomeworkRepositoryImpl
import com.test.application.classes.view.ClassesViewModel
import com.test.application.home.view.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<ExamRepository> { ExamRepositoryImpl() }
    single<ClassesRepository> { ClassesRepositoryImpl() }
    single<HomeworkRepository> { HomeworkRepositoryImpl()  }
    viewModel { com.test.application.home.view.HomeViewModel(get(), get(), get()) }
    viewModel { com.test.application.classes.view.ClassesViewModel(get()) }
}