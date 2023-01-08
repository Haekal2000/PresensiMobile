package com.example.aplikasipresensi.preferences

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataPreferences(
    contex: Context
) {
    private val appContext = contex.applicationContext
    private val dataStore : DataStore<Preferences>

    init {
        dataStore = appContext.createDataStore(
            name = "pref_data_store"
        )
    }

    val getToken: Flow<String>
    get() = dataStore.data.map { p ->
        p[TOKEN] ?: ""
    }

    suspend fun setToken(value: String){
        dataStore.edit { p ->
            p[TOKEN] = value
        }
    }

    val getTokenTeacher: Flow<String>
    get() = dataStore.data.map { p ->
        p[TOKENTEACHER] ?: ""
    }

    suspend fun setTokenTeacher(value: String){
        dataStore.edit { p ->
            p[TOKENTEACHER] = value
        }
    }

    val getNik: Flow<String>
    get() = dataStore.data.map { p ->
        p[NIK] ?: ""
    }

    suspend fun setNik(value: String){
        dataStore.edit { p ->
            p[NIK] = value
        }
    }

    val getNrpId: Flow<String>
    get() = dataStore.data.map { p ->
        p[NRP] ?: ""
    }

    suspend fun setNrpId(value: String){
        dataStore.edit { p ->
            p[NRP] = value
        }
    }

    val getName: Flow<String>
    get() = dataStore.data.map { p ->
        p[NAME] ?: ""
    }

    suspend fun setName(value: String){
        dataStore.edit { p ->
            p[NAME] = value
        }
    }

    val getDepartmentId: Flow<String>
    get() = dataStore.data.map { p ->
        p[DEPARTMENTID] ?: ""
    }

    suspend fun setDepartmentId(value: String){
        dataStore.edit { p ->
            p[DEPARTMENTID] = value
        }
    }

    val getDepartmentName: Flow<String>
    get() = dataStore.data.map { p ->
        p[DEPARTMENTNAME] ?: ""
    }

    suspend fun setDepartmentName(value: String){
        dataStore.edit { p ->
            p[DEPARTMENTNAME] = value
        }
    }

    val getAcademicPeriodId: Flow<String>
    get() = dataStore.data.map { p ->
        p[ACADEMICPERIODID] ?:""
    }

    suspend fun setAcademicPeriodId(value: String){
        dataStore.edit { p ->
            p[ACADEMICPERIODID] = value
        }
    }

    val getImage: Flow<String>
    get() = dataStore.data.map { p ->
        p[IMAGE] ?: ""
    }

    suspend fun setImage(value: String){
        dataStore.edit { p ->
            p[IMAGE] = value
        }
    }

    companion object{
        private val TOKEN = preferencesKey<String>("token")
        private val TOKENTEACHER = preferencesKey<String>("token_teacher")
        private val NIK = preferencesKey<String>("lecturer_nik")
        private val NRP = preferencesKey<String>("nrpId")
        private val NAME = preferencesKey<String>("name")
        private val DEPARTMENTID = preferencesKey<String>("department_id")
        private val DEPARTMENTNAME = preferencesKey<String>("departmentName")
        private val ACADEMICPERIODID = preferencesKey<String>("academic_period_id")
        private val IMAGE = preferencesKey<String>("image")
    }
}