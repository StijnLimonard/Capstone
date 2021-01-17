package com.example.capstone.dao

import androidx.room.*

@Dao
interface ListDao {

    @Query("Select * FROM armylist")
    suspend fun getAllArmyLists(): List<com.example.capstone.models.ArmyList>

    @Insert
    suspend fun insertArmyList(list: com.example.capstone.models.ArmyList)

    @Delete
    suspend fun deleteArmyList(list: com.example.capstone.models.ArmyList)

    @Update
    suspend fun updateArmyList(list: com.example.capstone.models.ArmyList)
}