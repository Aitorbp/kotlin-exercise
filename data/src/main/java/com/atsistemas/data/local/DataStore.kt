package com.atsistemas.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.createDataStore
import com.atsistemas.data.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


   class DataStore(context: Context)    {

    private val dataStore: DataStore<Preferences> =  context!!.createDataStore(name = context.getString(
            R.string.dataStore))
    companion object{
        val USER_NAME_KEY  = stringPreferencesKey("USER_NAME")
        val NAME_KEY  = stringPreferencesKey("NAME")
    }
    suspend fun storeUser(username: String, name:String){
        dataStore.edit {
            it[USER_NAME_KEY] = name
            it[NAME_KEY] = username
        }
    }

    val userNameFlow: Flow<String> = dataStore.data.map {
        it[USER_NAME_KEY] ?:""
    }
    val nameFlow: Flow<String> = dataStore.data.map {
        it[NAME_KEY] ?:""
    }


}