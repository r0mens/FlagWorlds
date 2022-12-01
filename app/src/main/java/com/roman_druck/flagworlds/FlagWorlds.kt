package com.roman_druck.flagworlds


import com.roman_druck.flagworlds.DataManager.flagLista
import java.util.Locale.getDefault

class FlagWorlds() {
    var rond = 0            //No of ronds played
    var points = 0          //No of points
    var correctAnswer = 0   //Position of correct flag

    fun printFlags(): Array<String> {
        rond++
        val country: String
        val dispLista = mutableListOf<Flag?>()
        var f: Flag

        for (i in 0..3) {
            dispLista.add(null)
        }

        //Get flag to guess
        do {
            f = flagLista[(0..(flagLista.size - 1)).random()]
        } while (f.used)
        f.used = true

        //Get position of flag to guess
        correctAnswer = (0..3).random()
        dispLista[correctAnswer] = f

        //Get the rest of the flags (must be unique
        for (i in 0..3) {
            if (dispLista[i] == null) dispLista[i] = uniqueFlag(dispLista)
        }

        //Get name of the country
        if (getDefault().language == "uk"){
            country = dispLista[correctAnswer]!!.uaCountry
        } else if (getDefault().language == "ru"){
            country = dispLista[correctAnswer]!!.ruCountry
        } else {
            country = dispLista[correctAnswer]!!.enCountry
        }
        return arrayOf(
            dispLista[0]!!.flagId,
            dispLista[1]!!.flagId,
            dispLista[2]!!.flagId,
            dispLista[3]!!.flagId,
            country
        )
    }

    //Get a random flag that has not been used
    fun uniqueFlag(l: List<Flag?>): Flag {
        var f: Flag
        var foundIt: Boolean
        do {
            f = flagLista[(0..(flagLista.size - 1)).random()]
            foundIt = true
            for (i in 0..3) {
                if (f == l[i])
                    foundIt = false
            }
        } while (!foundIt)

        return f
    }

    //Check if there is any unused flags left
    fun checkFlagsLeft(): Boolean {
        for (f in flagLista) {
            if (!f.used)
                return true
        }
        return false
    }

    //Return no of flags in list
    fun noOfFlags(): Int {
        return flagLista.size
    }
}