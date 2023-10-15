package gb.com.educational_app.app

import android.app.Application
import gb.com.educational_app.di.appModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}