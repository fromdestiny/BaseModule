package petaz.co.kr.sallim9dan.module

import dagger.Module
import dagger.Provides
import petaz.co.kr.sallim9dan.MyApp
import javax.inject.Singleton


@Module
class AppModule(private val app: MyApp) {

    @Provides
    @Singleton
    fun provideApp() = app


}