package com.example.capstone.repository

import android.content.Context
import com.example.capstone.dao.ListDao
import com.example.capstone.database.ArmyListDatabase

public class armylistRepository(context: Context) {
    private var listDao : ListDao

    init {
        val armyListDatabase = ArmyListDatabase.getDatabase(context)
        listDao = armyListDatabase!!.listDao()
    }

    fun getAllArmylists(): List<com.example.capstone.models.List> {
        return listDao.getAllArmyLists()
    }

    fun insertArmylist(armylist: com.example.capstone.models.List) {
        listDao.insertArmyList(armylist)
    }

    fun updateArmylist(armylist: com.example.capstone.models.List) {
        listDao.updateArmyList(armylist)
    }

    fun deleteArmylist(armylist: com.example.capstone.models.List) {
        listDao.deleteArmyList(armylist)
    }

}