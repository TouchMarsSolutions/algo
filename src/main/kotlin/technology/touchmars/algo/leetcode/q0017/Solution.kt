package technology.touchmars.algo.leetcode.q0017

import java.util.*

class Solution {

    companion object {
        val charMap = mapOf('2' to "abc", '3' to "def",
            '4' to "ghi", '5' to "jkl", '6' to "mno",
            '7' to "pqrs", '8' to "tuv", '9' to "wxyz")
    }

    fun letterCombinations(digits: String): List<String> {
        val sol = LinkedList<String>()
        if(digits.isEmpty()) return sol
        sol.push("")
        digits.forEach { d ->
            run {
                val chars = charMap[d]!!
                val solSize = sol.size
                for (i in 1..solSize) {
                    val g = sol.removeFirst()
                    chars.forEach { c -> sol.add(g + c) }
                }
            }
        }
        return sol
    }

}