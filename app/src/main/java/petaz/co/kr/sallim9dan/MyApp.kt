package petaz.co.kr.sallim9dan

import android.app.Application
import android.content.Context

import petaz.co.kr.sallim9dan.module.AppModule
import petaz.co.kr.sallim9dan.module.NetWorkModule
import timber.log.Timber

class MyApp : Application() {


    val singleton: AppComponent by lazy {
        DaggerAppComponent.builder()
                .netWorkModule(NetWorkModule())
                //.preferenceModule(PreferenceModule())
                .appModule(AppModule(this))
                .build()
    }


    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        //JodaTimeAndroid.init(this)
    }

    companion object {
        fun getAppComponent(context: Context): AppComponent {
            return (context.applicationContext as MyApp).singleton
        }
    }
}