package com.example.capstone.dao

import androidx.room.*

@Dao
interface ListDao {

    @Query("Select * FROM armylist")
    fun getAllArmyLists(): List<com.example.capstone.models.ArmyList>

    @Insert
    fun insertArmyList(list: com.example.capstone.models.ArmyList)

    @Delete
    fun deleteArmyList(list: com.example.capstone.models.ArmyList)

    @Update
    fun updateArmyList(list: com.example.capstone.models.ArmyList)
}