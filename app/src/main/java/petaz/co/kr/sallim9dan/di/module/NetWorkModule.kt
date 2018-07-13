package petaz.co.kr.sallim9dan.module

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import petaz.co.kr.sallim9dan.BuildConfig
import petaz.co.kr.sallim9dan.MyApp
import petaz.co.kr.sallim9dan.data.network.error.Rx2ErrorHandlingCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val CONNECT_TIMEOUT: Long = 30
private const val WRITE_TIMEOUT: Long = 30
private const val READ_TIMEOUT: Long = 30

@Module
class NetWorkModule {

    private val baseUrl: String = "http://openapi.airkorea.or.kr/"

    @Provides
    @Singleton
    fun provideCache(application: MyApp): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10MB
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache, interceptor: Interceptor): OkHttpClient {
        val logger: HttpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logger.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logger.level = HttpLoggingInterceptor.Level.NONE
        }

        return OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                //.cookieJar(JavaNetCookieJar(CookieManager(null, CookiePolicy.ACCEPT_ALL)))
                .addInterceptor(logger)
                .addInterceptor(interceptor)
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(Rx2ErrorHandlingCallAdapterFactory.create())
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
    }

    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor {
        return Interceptor {
            val builder: Request.Builder = it.request().newBuilder()
            builder.header("User-Agent", "Android")

            it.proceed(builder.build())
        }
    }
}