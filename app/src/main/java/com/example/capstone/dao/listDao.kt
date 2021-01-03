package com.example.capstone.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface listDao {

    @Query("Select * FROM armylist")
    fun getAllArmyLists(): List<com.example.capstone.models.List>

    @Insert
    fun insertArmyList(list: com.example.capstone.models.List)

    @Delete
    fun deleteArmyList(list: com.example.capstone.models.List)

    @Update
    fun updateArmyList(list: com.example.capstone.models.List)


}