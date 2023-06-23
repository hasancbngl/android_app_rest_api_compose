package com.hasancbngl.herocomposeapp.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.hasancbngl.herocomposeapp.domain.repository.DataStoreOperations
import com.hasancbngl.herocomposeapp.util.Constants.PREFERENCES_KEY
import com.hasancbngl.herocomposeapp.util.Constants.PREFERENCES_NAME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME)
class DataStoreOperationsImp(context: Context) : DataStoreOperations {

    private object PreferencesKey{
        val onBoardingKey = booleanPreferencesKey(PREFERENCES_KEY)
    }

    private val dataStore = context.dataStore

    override suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.edit { pref->
            pref[PreferencesKey.onBoardingKey] = completed
        }
    }

    override fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception->
                if (exception is IOException) emit(emptyPreferences())
                else throw exception
            }.map { prefs->
                val onBoardingState = prefs[PreferencesKey.onBoardingKey] ?: false
                onBoardingState
            }
    }
}