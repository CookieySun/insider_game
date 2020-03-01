package kktyu.xyz.insidergame.selectnumber

import kotlin.random.Random

class SelectNumberViewModel {
    fun choiceMaster(selectedNumber: Int): Int =
        Random.nextInt(selectedNumber)

    fun choiceInsider(selectedNumber: Int, master: Int): Int {
        var insider = Random.nextInt(selectedNumber)

        while (master == insider) {
            insider = Random.nextInt(selectedNumber)
        }

        return insider
    }
}