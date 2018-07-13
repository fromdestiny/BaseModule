package petaz.co.kr.sallim9dan.module

import dagger.Module
import dagger.Provides
import petaz.co.kr.sallim9dan.MyApp
import petaz.co.kr.sallim9dan.SettingPreference
import javax.inject.Singleton

@Module
class PreferenceModule {

    @Provides
    @Singleton
    fun provideSettingPreference(app: MyApp): SettingPreference {
        return SettingPreference(app)
    }

}