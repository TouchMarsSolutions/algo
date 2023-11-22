package technology.touchmars.algo.leetcode.q0017

class Solution2 {

    companion object {
        val charMap = mapOf('2' to "abc", '3' to "def",
            '4' to "ghi", '5' to "jkl", '6' to "mno",
            '7' to "pqrs", '8' to "tuv", '9' to "wxyz")
    }
    val sol = mutableListOf<String>()

    fun letterCombinations(digits: String): List<String> {
        if (digits.isNullOrBlank()) return sol
        findComb(digits, 0, "").apply { return sol }
    }

    private fun findComb(digits: String, idx: Int, s: String) {
        if (idx==digits.length) {
            sol.add(s)
            return
        }
        val letters = charMap[digits[idx]] ?: ""
        letters.forEach { findComb(digits, idx+1, s+it) }
    }

}