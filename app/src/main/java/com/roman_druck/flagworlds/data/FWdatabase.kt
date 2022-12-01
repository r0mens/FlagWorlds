package com.roman_druck.flagworlds.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FWdata::class], version = 1, exportSchema = false)
abstract class FWdatabase: RoomDatabase() {
    abstract fun FWdao(): FWdao

    companion object {
        @Volatile private var INSTANCE : FWdatabase? = null

        fun getDatabase(context: Context) : FWdatabase{
            val tempINSTANCE = INSTANCE
            if (tempINSTANCE != null){
                return tempINSTANCE
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FWdatabase::class.java,
                    "fw_main_database"
                ).build()
                INSTANCE = instance
                return  instance
            }

        }
    }
}