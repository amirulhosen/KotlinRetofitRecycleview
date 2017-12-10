package com.segunfamisa.kotlin.samples.retrofit.data.kotlin.notificationModel

import com.google.gson.annotations.SerializedName

data class NotiJson(val birthday: String = "",
                    val image: String = "",
                    @SerializedName("link-canonical")
                    val linkCanonical: String = "",
                    val website: String = "",
                    @SerializedName("anime-staff-position")
                    val animeStaffPosition: List<AnimeStaffPositionItem>?,
                    @SerializedName("alternate-names")
                    val alternateNames: String? = null,
                    @SerializedName("member-favorites")
                    val memberFavorites: Int = 0,
                    @SerializedName("given-name")
                    val givenName: String = "",
                    @SerializedName("family-name")
                    val familyName: String = "",
                    @SerializedName("voice-acting-role")
                    val voiceActingRole: List<VoiceActingRoleItem>?)