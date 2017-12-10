package com.segunfamisa.kotlin.samples.retrofit.data.kotlin

import com.segunfamisa.kotlin.samples.retrofit.data.kotlin.notificationModel.NotiJson

/**
 * Repository method to access search functionality of the api service
 */
class SearchRepository(val apiService: GithubApiService) {

    fun searchUsers(location: String, language: String): io.reactivex.Observable<NotiJson> {
//        return apiService.search(query = "location:$location language:$language")
        return apiService.search(path = "1")
    }

}