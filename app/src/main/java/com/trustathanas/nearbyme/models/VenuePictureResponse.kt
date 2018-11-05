package com.trustathanas.nearbyme.models


import com.google.gson.annotations.SerializedName


data class VenuePictureResponse(
    @SerializedName("meta") val meta: PictureMeta,
    @SerializedName("response") val response: PictureResponse
)


data class PicturePhotos(
    @SerializedName("count") val count: Int = 0,
    @SerializedName("dupesRemoved") val dupesRemoved: Int = 0,
    @SerializedName("items") val items: List<PictureItemsItem>?
)


data class PictureResponse(@SerializedName("photos") val photos: PicturePhotos)


data class PictureMeta(
    @SerializedName("code") val code: Int = 0,
    @SerializedName("requestId") val requestId: String = ""
)


data class PictureUser(
    @SerializedName("firstName") val firstName: String = "",
    @SerializedName("lastName") val lastName: String = "",
    @SerializedName("gender") val gender: String = "",
    @SerializedName("photo") val photo: PicturePhoto,
    @SerializedName("id") val id: String = ""
)


data class PictureCheckin(
    @SerializedName("createdAt") val createdAt: Int = 0,
    @SerializedName("timeZoneOffset") val timeZoneOffset: Int = 0,
    @SerializedName("id") val id: String = "",
    @SerializedName("type") val type: String = ""
)


data class PicturePhoto(
    @SerializedName("prefix") val prefix: String = "",
    @SerializedName("suffix") val suffix: String = ""
)


data class PictureItemsItem(
    @SerializedName("createdAt") val createdAt: Int = 0,
    @SerializedName("checkin") val checkin: PictureCheckin,
    @SerializedName("visibility") val visibility: String = "",
    @SerializedName("prefix") val prefix: String = "",
    @SerializedName("width") val width: Int = 0,
    @SerializedName("id") val id: String = "",
    @SerializedName("source") val source: PictureSource,
    @SerializedName("suffix") val suffix: String = "",
    @SerializedName("user") val user: PictureUser,
    @SerializedName("height") val height: Int = 0
)


data class PictureSource(
    @SerializedName("name") val name: String = "",
    @SerializedName("url") val url: String = ""
)


