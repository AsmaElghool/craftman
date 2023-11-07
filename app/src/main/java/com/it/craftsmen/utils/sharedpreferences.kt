package com.it.craftsmen.utils

import android.content.Context


/**
 * Set a shared preference value
 */
inline fun <reified T> Context.setPrefValue(key: String, value: T) {
    val prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    val editor = prefs.edit()
    when (T::class) {
        Int::class -> editor.putInt(key, value as Int)
        Long::class -> editor.putLong(key, value as Long)
        Float::class -> editor.putFloat(key, value as Float)
        Boolean::class -> editor.putBoolean(key, value as Boolean)
        String::class -> editor.putString(key, value as String)
        else -> throw IllegalArgumentException("Unsupported preference type")
    }
    editor.apply()
}

/**
 * Get a shared preference value
 */
inline fun <reified T> Context.getPrefValue(key: String, defaultValue: T): T {
    val prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    return when (T::class) {
        Int::class -> prefs.getInt(key, defaultValue as Int) as T
        Long::class -> prefs.getLong(key, defaultValue as Long) as T
        Float::class -> prefs.getFloat(key, defaultValue as Float) as T
        Boolean::class -> prefs.getBoolean(key, defaultValue as Boolean) as T
        String::class -> prefs.getString(key, defaultValue as String) as T
        else -> throw IllegalArgumentException("Unsupported preference type")
    }
}
