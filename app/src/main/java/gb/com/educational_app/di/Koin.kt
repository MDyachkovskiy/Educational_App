package gb.com.educational_app.di

import com.test.application.data_provider.respository.ClassesRepository
import com.test.application.core.repository.ClassesRepositoryImpl
import com.test.application.data_provider.respository.ExamRepository
import com.test.application.core.repository.ExamRepositoryImpl
import com.test.application.data_provider.respository.HomeworkRepository
import com.test.application.core.repository.HomeworkRepositoryImpl
import com.test.application.classes.view.ClassesViewModel
import com.test.application.core.domain.Classes
import com.test.application.core.domain.ExamTime
import com.test.application.core.domain.Homework
import com.test.application.core.interactor.ClassesScreenInteractor
import com.test.application.core.interactor.ClassesScreenInteractorImpl
import com.test.application.core.interactor.HomeScreenInteractor
import com.test.application.core.interactor.HomeScreenInteractorImpl
import com.test.application.home.view.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<ExamRepository<ExamTime>> { ExamRepositoryImpl() }
    single<ClassesRepository<Classes>> { ClassesRepositoryImpl() }
    single<HomeworkRepository<Homework>> { HomeworkRepositoryImpl()  }
}

val interactorModule = module {
    single<HomeScreenInteractor> { HomeScreenInteractorImpl(get(), get(), get()) }
    single<ClassesScreenInteractor> { ClassesScreenInteractorImpl( get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { ClassesViewModel(get()) }
}