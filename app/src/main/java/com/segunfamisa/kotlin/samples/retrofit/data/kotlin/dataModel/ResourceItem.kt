package com.example.amirul.kotlinsample.dataModel

import com.google.gson.annotations.SerializedName

data class ResourceItem(val townname: String = "",
                        val townid: Int = 0,
                        @SerializedName("country_id")
                        val countryId: Int = 0)


