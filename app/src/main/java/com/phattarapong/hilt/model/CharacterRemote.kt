package com.phattarapong.hilt.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.phattarapong.hilt.database.CharacterLocal
import kotlinx.android.parcel.Parcelize

data class CharacterRemote(
    @SerializedName("info")
    var info: CharacterInfo? = null,
    @SerializedName("results")
    var results: List<CharacterResult>? = null
)

data class CharacterInfo(
    @SerializedName("count")
    var count: Int? = null,
    @SerializedName("next")
    var next: String? = null,
    @SerializedName("pages")
    var pages: Int? = null,
    @SerializedName("prev")
    var prev: Any? = null
)

data class CharacterResult(
    @SerializedName("created")
    var created: String? = null,
    @SerializedName("episode")
    var episode: List<String>? = null,
    @SerializedName("gender")
    var gender: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("location")
    var location: CharacterLocation? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("origin")
    var origin: CharacterOrigin? = null,
    @SerializedName("species")
    var species: String? = null,
    @SerializedName("status")
    var status: String? = null,
    @SerializedName("type")
    var type: String? = null,
    @SerializedName("url")
    var url: String? = null
)

fun List<CharacterResult>.asLocalList() =
    this.map {
        CharacterLocal(
            it.created, it.episode, it.gender, it.id, it.image, it.location, it.name, it.origin
            , it.species, it.status, it.type, it.url
        )
    }

@Parcelize
data class CharacterLocation(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("url")
    var url: String? = null
) : Parcelable

@Parcelize
data class CharacterOrigin(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("url")
    var url: String? = null
) : Parcelable