package gb.com.educational_app.di

import gb.com.educational_app.model.repository.ClassesRepository
import gb.com.educational_app.model.repository.ClassesRepositoryImpl
import gb.com.educational_app.model.repository.ExamRepository
import gb.com.educational_app.model.repository.ExamRepositoryImpl
import gb.com.educational_app.view.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<ExamRepository> { ExamRepositoryImpl() }
    single<ClassesRepository> { ClassesRepositoryImpl() }
    viewModel { HomeViewModel(get(), get()) }
}