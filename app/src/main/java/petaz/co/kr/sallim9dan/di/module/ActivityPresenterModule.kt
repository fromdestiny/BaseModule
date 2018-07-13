package petaz.co.kr.sallim9dan.module

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import petaz.co.kr.sallim9dan.MainPresenter
import petaz.co.kr.sallim9dan.UserScope

@Module
class ActivityPresenterModule {

    @Provides
    @UserScope
    fun provideMainPresenter(context: AppCompatActivity): MainPresenter {
        return MainPresenter(context)
    }

}