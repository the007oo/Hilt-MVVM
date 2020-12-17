package com.phattarapong.hilt.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.phattarapong.hilt.model.CharacterLocation
import com.phattarapong.hilt.model.CharacterOrigin
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "character_table")
data class CharacterLocal(
    var created: String? = null,
    var episode: List<String>? = null,
    var gender: String? = null,
    @PrimaryKey
    var id: Int? = null,
    var image: String? = null,
    var location: CharacterLocation? = null,
    var name: String? = null,
    var origin: CharacterOrigin? = null,
    var species: String? = null,
    var status: String? = null,
    var type: String? = null,
    var url: String? = null
) : Parcelable

