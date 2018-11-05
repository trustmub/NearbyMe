package com.trustathanas.nearbyme.models


import com.google.gson.annotations.SerializedName

data class Photos(@SerializedName("count") val count: Int = 0,
                  @SerializedName("dupesRemoved") val dupesRemoved: Int = 0,
                  @SerializedName("items") val items: List<ItemsItem>?)


data class VenueResponse(@SerializedName("photos") val photos: Photos)


data class VenueMeta(@SerializedName("code") val code: Int = 0,
                @SerializedName("requestId") val requestId: String = "")


data class User(@SerializedName("firstName") val firstName: String = "",
                @SerializedName("lastName") val lastName: String = "",
                @SerializedName("gender") val gender: String = "",
                @SerializedName("photo") val photo: Photo,
                @SerializedName("id") val id: String = "")


data class SingleVenueModel(@SerializedName("meta")
                            val meta: VenueMeta,
                            @SerializedName("response")
                            val response: VenueResponse)


data class Checkin(@SerializedName("createdAt") val createdAt: Int = 0,
                   @SerializedName("timeZoneOffset") val timeZoneOffset: Int = 0,
                   @SerializedName("id") val id: String = "",
                   @SerializedName("type") val type: String = "")


data class Photo(@SerializedName("prefix") val prefix: String = "",
                 @SerializedName("suffix") val suffix: String = "")


data class ItemsItem(@SerializedName("createdAt") val createdAt: Int = 0,
                     @SerializedName("checkin") val checkin: Checkin,
                     @SerializedName("visibility") val visibility: String = "",
                     @SerializedName("prefix") val prefix: String = "",
                     @SerializedName("width") val width: Int = 0,
                     @SerializedName("id") val id: String = "",
                     @SerializedName("source") val source: Source,
                     @SerializedName("suffix") val suffix: String = "",
                     @SerializedName("user") val user: User,
                     @SerializedName("height") val height: Int = 0)


data class Source(@SerializedName("name") val name: String = "",
                  @SerializedName("url") val url: String = "")


