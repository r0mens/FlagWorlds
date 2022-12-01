package com.roman_druck.flagworlds.data



class FWRepository(private val fWdao: FWdao) {
    suspend fun getAllData(): List<FWdata>{
        return fWdao.readAllData()
    }

    suspend fun addFWdata(fWdata: FWdata) {
        fWdao.addFWdata(fWdata)
    }

    suspend fun updateFWdata(fWdata: FWdata) {
        fWdao.updateFWdata(fWdata)
    }

    suspend fun deleteFWdata(fWdata: FWdata) {
        fWdao.deleteFWdata(fWdata)
    }

    suspend fun deleteAllFWdata() {
        fWdao.deleteAllFWdata()
    }

    suspend fun getCount(): Int {
        return fWdao.getCount()
    }

    suspend fun getContinent(continent: String): List<FWdata>{
        return fWdao.getContinent(continent)
    }
}