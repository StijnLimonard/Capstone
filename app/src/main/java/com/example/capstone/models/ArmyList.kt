package com.example.capstone.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.collections.List

@Entity(tableName = "armyList")
data class ArmyList(
    @PrimaryKey(autoGenerate=true)
    @ColumnInfo(name="id")
    var id:Long? = null,

    var listName : String,
    var alliance: String,
    var heroes: String,
    var battleline: String,
    var units: String,
    var artillery: String,
    var behemoths: String

    )

