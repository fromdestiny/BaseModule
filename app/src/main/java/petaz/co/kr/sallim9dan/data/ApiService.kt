package petaz.co.kr.sallim9dan.data

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {


    @GET("/search/repositories")
//    fun searchRepositories(@QueryMap params: Map<String, String>): Observable<String>
    fun getTest(): Observable<TestVo>
}

