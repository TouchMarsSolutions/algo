package technology.touchmars.algo.leetcode.q0017

class Solution {

    companion object {
        val charMap = mapOf('2' to "abc", '3' to "def",
            '4' to "ghi", '5' to "jkl", '6' to "mno",
            '7' to "pqrs", '8' to "tuv", '9' to "wxyz")
    }

    fun letterCombinations(digits: String): List<String> {
        val sol = mutableListOf<String>()
        if(digits.isEmpty()) return sol
        sol.add("")
        digits.forEach { d ->
            val chars = charMap[d]!!
            repeat(sol.size) {
                sol.addAll(sol.removeFirst().let { g -> chars.map { c -> g + c } })
            }
        }
        return sol
    }

}