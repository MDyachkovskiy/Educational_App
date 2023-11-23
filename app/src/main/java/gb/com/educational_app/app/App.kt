package gb.com.educational_app.app

import android.app.Application
import gb.com.educational_app.di.appModule
import gb.com.educational_app.di.interactorModule
import gb.com.educational_app.di.viewModelModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule, viewModelModule, interactorModule)
        }
    }
}