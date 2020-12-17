package com.phattarapong.hilt.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.phattarapong.hilt.util.Converters

private const val DATABASE_NAME = "character_database"

@Database(entities = [CharacterLocal::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CharacterDatabase : RoomDatabase() {

    abstract val characterDao: CharacterDao

    companion object {

        @Volatile
        private var INSTANCE: CharacterDatabase? = null

        fun getInstance(context: Context): CharacterDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CharacterDatabase::class.java,
                        DATABASE_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}