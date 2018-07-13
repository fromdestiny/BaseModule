package petaz.co.kr.sallim9dan.module

import dagger.Module
import dagger.Provides
import petaz.co.kr.sallim9dan.UserScope
import petaz.co.kr.sallim9dan.data.ApiService
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    @UserScope
    fun provideApiSerVice(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


}