package com.kl51.talkies.utils

import android.content.Context
import androidx.preference.PreferenceManager
import javax.inject.Inject

class PreferenceUtils @Inject constructor(
    private val context: Context
) {

    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context)

    fun getStringPreference(key: String) = sharedPreferences.getString(key, "")

    fun getIntPreference(key: String) = sharedPreferences.getInt(key, 0)

    fun getFloatPreference(key: String) = sharedPreferences.getFloat(key, 0f)

    fun getBooleanPreference(key: String) = sharedPreferences.getBoolean(key, false)

    fun getLongPreference(key: String) = sharedPreferences.getLong(key, 0L)

    fun set(key: String, value: Any) {
        val prefEditor = sharedPreferences.edit()
        when (value) {
            is String -> prefEditor.putString(key, value)
            is Long -> prefEditor.putLong(key, value)
            is Int -> prefEditor.putInt(key, value)
            is Boolean -> prefEditor.putBoolean(key, value)
            is Float -> prefEditor.putFloat(key, value)
        }
        prefEditor.apply()
    }

    fun setSecuredBaseUrl(url: String) = set(SECURED_BASE_URL, url)

    fun getSecuredBaseUrl() = getStringPreference(SECURED_BASE_URL)

    companion object {
        private const val SECURED_BASE_URL = "secured_base_url"
    }
}
