package day4

import AdventOfCodeRunnable
import Main
import java.util.*
import kotlin.collections.ArrayList

class GiantSquid1: AdventOfCodeRunnable {
    override fun invoke() {
        val sc = Scanner(Main::class.java.getResourceAsStream("giant_squid.txt")!!)
        val inputs = ArrayList<Int>()
        val boards = ArrayList<gs_board>()
        val str = sc.nextLine()
        for (i in str.split(",")) {
            inputs.add(i.toInt())
        }
        sc.nextLine()
        while (sc.hasNext()) {
            val ia1 = sc.nextLine().split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()
            val ia2 = sc.nextLine().split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()
            val ia3 = sc.nextLine().split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()
            val ia4 = sc.nextLine().split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()
            val ia5 = sc.nextLine().split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()
            boards.add(gs_board(ia1, ia2, ia3, ia4, ia5))
            if (sc.hasNextLine()) {
                sc.nextLine()
            }
        }
        for (i in inputs) {
            var found = false
            for (j in boards) {
                j.putInt(i)
                val isComplete = j.isComplete()
                if (isComplete != -1) {
                    println(i)
                    println(isComplete * i)
                    found = true
                    break
                }
            }
            if (found) {
                break
            }
        }
    }
}