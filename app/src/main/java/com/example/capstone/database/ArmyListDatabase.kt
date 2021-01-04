package com.example.capstone.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.capstone.dao.ListDao
import com.example.capstone.models.List

@Database(entities = [List::class], version = 1, exportSchema = false)
abstract class ArmyListDatabase : RoomDatabase(){

    abstract fun listDao() : ListDao

    companion object{
        private const val DATABASE_NAME = "ARMYLIST_DATBASE"

        @Volatile
        private var armylistDatabaseInstance: ArmyListDatabase? = null

        fun getDatabase(context: Context) : ArmyListDatabase? {
            if (armylistDatabaseInstance == null){
                synchronized(ArmyListDatabase::class.java){
                    if(armylistDatabaseInstance ==null){
                    armylistDatabaseInstance = Room.databaseBuilder(context.applicationContext, ArmyListDatabase::class.java, DATABASE_NAME).build()
                    }
                }
            }
            return armylistDatabaseInstance
        }
    }

}