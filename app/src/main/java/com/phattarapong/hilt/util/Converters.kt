package com.phattarapong.hilt.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.phattarapong.hilt.model.CharacterLocation
import com.phattarapong.hilt.model.CharacterOrigin

class Converters {
    @TypeConverter
    fun listToJson(value : List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()

    @TypeConverter
    fun characterLocationToJson(value : CharacterLocation?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToCharacterLocation(value: String) = Gson().fromJson(value, CharacterLocation::class.java)

    @TypeConverter
    fun characterOriginToJson(value : CharacterOrigin?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToCharacterOrigin(value: String) = Gson().fromJson(value, CharacterOrigin::class.java)
}