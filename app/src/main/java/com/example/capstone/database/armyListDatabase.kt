package com.example.capstone.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.capstone.dao.listDao
import com.example.capstone.models.List

@Database(entities = [List::class], version = 1, exportSchema = false)
abstract class armyListDatabase :RoomDatabase(){

    abstract fun ListDao() : listDao
    companion object{
        private const val DATABASE_NAME = "ARMYLIST_DATBASE"

        @Volatile
        private var armylistDatabaseInstance: armyListDatabase? = null

        fun getDatabase(context: Context) : armyListDatabase? {
            if (armylistDatabaseInstance == null){
                synchronized(armyListDatabase::class.java){
                    if(armylistDatabaseInstance ==null){
                    armylistDatabaseInstance = Room.databaseBuilder(context.applicationContext, armyListDatabase::class.java, DATABASE_NAME).build()
                    }
                }
            }
            return armylistDatabaseInstance
        }
    }

}