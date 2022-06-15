package com.example.abdigitaltest.util.local_db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun listTOString(listOfString: List<String>): String? {
        return Gson().toJson(listOfString)
    }

    @TypeConverter
    fun stringToList(value: String?): List<String> {
        return  Gson().fromJson(
            value,
            object : TypeToken<List<String>?>() {}.type
        )
    }
}