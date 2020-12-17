package com.phattarapong.hilt.di

import android.content.Context
import com.phattarapong.hilt.database.CharacterDao
import com.phattarapong.hilt.database.CharacterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun proviedCharactorDao(@ApplicationContext context: Context): CharacterDao =
        CharacterDatabase.getInstance(context).characterDao
}
