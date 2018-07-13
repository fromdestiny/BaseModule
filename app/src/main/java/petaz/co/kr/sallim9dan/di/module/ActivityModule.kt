package petaz.co.kr.sallim9dan.module

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import petaz.co.kr.sallim9dan.UserScope


@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    @UserScope
    fun provideActivity() = activity
}