package com.jjmf.elementaryschool.app

import android.content.Context

class Preferencias(context:Context) {

    private val KEY_ID_USER = "KEY_ID_USER"

    private val storage = context.getSharedPreferences("SHARED_PREFS_BUHITO", 0)

    fun saveId(valor: Int) = storage.edit().putInt(KEY_ID_USER, valor).apply()
    fun getId() = storage.getInt(KEY_ID_USER, 0)
}