package com.auralis.player.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

private val Context.auralisDataStore by preferencesDataStore(name = "auralis_settings")

private val playerStyleKey = stringPreferencesKey("player_style")

class AppearanceStore(private val context: Context) {
    val playerStyle = context.auralisDataStore.data

    suspend fun savePlayerStyle(styleName: String) {
        context.auralisDataStore.edit { preferences ->
            preferences[playerStyleKey] = styleName
        }
    }

    companion object {
        const val DEFAULT_PLAYER_STYLE = "PIXEL"
        val styleKey = playerStyleKey
    }
}
