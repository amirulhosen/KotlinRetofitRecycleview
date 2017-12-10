package com.segunfamisa.kotlin.samples.retrofit.data.kotlin

import com.segunfamisa.kotlin.samples.retrofit.data.kotlin.notificationModel.NotiJson
import retrofit2.http.Path


interface GithubApiService {

    @retrofit2.http.GET("api/person/{person}")
//    fun search(@retrofit2.http.Query("q") query: String,
//               @retrofit2.http.Query("page") page: Int = 1,
//               @retrofit2.http.Query("per_page") perPage: Int = 20): io.reactivex.Observable<Result>

    fun search( @Path("person") path: String): io.reactivex.Observable<NotiJson>

    /**
     * Companion object for the factory
     */
    companion object Factory {
        fun create(): com.segunfamisa.kotlin.samples.retrofit.data.kotlin.GithubApiService {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.create())
                    .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                    .baseUrl("http://jikan.me/")
                    .build()

            return retrofit.create(com.segunfamisa.kotlin.samples.retrofit.data.kotlin.GithubApiService::class.java);
        }
    }
}