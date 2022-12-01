package com.roman_druck.flagworlds.data

import androidx.room.*


@Dao
interface FWdao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFWdata(fwData: FWdata)

    @Update
    suspend fun updateFWdata(fwData: FWdata)

    @Delete
    suspend fun deleteFWdata(fwData: FWdata)

    @Query("DELETE FROM fw_main_table")
    suspend fun deleteAllFWdata()

    @Query("SELECT * FROM fw_main_table ORDER BY id ASC")
    suspend fun readAllData(): List<FWdata>

    @Query("SELECT COUNT(*) FROM fw_main_table")
    suspend fun getCount(): Int

    @Query("SELECT * FROM fw_main_table WHERE continent LIKE :continent")
    suspend fun getContinent(continent: String): List<FWdata>
}
