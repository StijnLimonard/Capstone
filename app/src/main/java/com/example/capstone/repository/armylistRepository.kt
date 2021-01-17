package com.example.capstone.repository

import android.content.Context
import com.example.capstone.dao.ListDao
import com.example.capstone.database.ArmyListDatabase
import com.example.capstone.models.ArmyList

public class armylistRepository(context: Context) {
    private var listDao : ListDao

    init {
        val armyListDatabase = ArmyListDatabase.getDatabase(context)
        listDao = armyListDatabase!!.listDao()
    }

    suspend fun getAllArmylists(): List<ArmyList> {
        return listDao.getAllArmyLists()
    }

    suspend fun insertArmylist(armylist: ArmyList) {
        listDao.insertArmyList(armylist)
    }

    suspend fun updateArmylist(armylist: ArmyList) {
        listDao.updateArmyList(armylist)
    }

    suspend fun deleteArmylist(armylist: ArmyList) {
        listDao.deleteArmyList(armylist)
    }

}