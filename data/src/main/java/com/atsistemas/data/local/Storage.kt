package com.atsistemas.data.local

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.Gson
import java.util.*

class Storage {
    fun getPreferences(context: Context?): SharedPreferences? {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }


    fun saveName(context: Context?, name: String?) {
        val editor: SharedPreferences.Editor = getPreferences(context)!!.edit()
        val gson = Gson()
        val json = gson.toJson(name)
        editor.putString("data", json)
        editor.apply()
    }

    fun getName(context: Context?): String? {
        val sharedPref: SharedPreferences? = getPreferences(context)
        return sharedPref!!.getString("data", null)
    }

    fun saveUsername(context: Context?, name: String?) {
        val editor: SharedPreferences.Editor = getPreferences(context)!!.edit()
        val gson = Gson()
        val json = gson.toJson(name)
        editor.putString("data2", json)
        editor.apply()
    }

    fun getUsername(context: Context?): String? {
        val sharedPref: SharedPreferences? = getPreferences(context)
        return sharedPref?.getString("data2", null)
    }
}