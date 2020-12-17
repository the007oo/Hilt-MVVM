package com.phattarapong.hilt.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characterLocal: CharacterLocal): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characterLocals: List<CharacterLocal>)

    @Update
    suspend fun update(characterLocal: CharacterLocal)

    @Delete
    suspend fun deletePhoto(characterLocal: CharacterLocal)

    @Query("SELECT * from character_table WHERE id =:id")
    fun getById(id: String): LiveData<CharacterLocal>

    @Query("SELECT * from character_table")
    fun getAll(): LiveData<List<CharacterLocal>>

    @Query("DELETE FROM character_table")
    suspend fun deleteTable()
}