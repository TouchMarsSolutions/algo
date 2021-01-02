package technology.touchmars.algo.leetcode.leco0266

class Solution {
    fun canPermutePalindrome(s: String): Boolean {
        val map = mutableMapOf<Int, Int>()
        s.chars().forEach { map[it] = 1 + map.getOrDefault(it, 0) }
        var numOdd = 0
        map.values.forEach {
            if (it%2==1) numOdd++
            if (numOdd>1) return false
        }
        return true
    }
}