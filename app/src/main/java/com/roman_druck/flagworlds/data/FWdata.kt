package com.roman_druck.flagworlds.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fw_main_table")
data class FWdata(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val enCountry: String,
    val uaCountry: String,
    val ruCountry: String,
    val flagId: String,
    val continent: String
)
