package technology.touchmars.algo.leetcode.leco0017

import java.util.*

class Solution {

    companion object {
        val charMap = mapOf('2' to "abc", '3' to "def",
            '4' to "ghi", '5' to "jkl", '6' to "mno",
            '7' to "pqrs", '8' to "tuv", '9' to "wxyz")
    }

    fun letterCombinations(digits: String): List<String> {
        val sol = LinkedList<String>()
        if(digits==null || digits.isEmpty()) return sol
        sol.push("")
        for (d in digits) {
            val chars = charMap.get(d)!!
            val solSize = sol.toArray().size
            for(i in 1..solSize) {
                val d = sol.removeFirst()
                chars.forEach { c -> sol.add(d+c) }
            }
        }
        return sol
    }




}