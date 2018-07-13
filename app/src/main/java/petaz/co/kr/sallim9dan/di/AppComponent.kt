package petaz.co.kr.sallim9dan

import dagger.Component
import petaz.co.kr.sallim9dan.module.AppModule
import petaz.co.kr.sallim9dan.module.FireBaseDbModule
import petaz.co.kr.sallim9dan.module.NetWorkModule
import petaz.co.kr.sallim9dan.module.PreferenceModule
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (NetWorkModule::class), (PreferenceModule::class)]
)
interface AppComponent {
    fun retrofit(): Retrofit

//    fun firebaseStore(): FirebaseFirestore

    fun setting(): SettingPreference
}