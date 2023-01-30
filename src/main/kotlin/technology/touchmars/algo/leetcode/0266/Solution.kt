package technology.touchmars.algo.leetcode.leco0266

class Solution {
    fun canPermutePalindrome(s: String): Boolean {
        val map = mutableMapOf<Int, Int>()
        s.chars().forEach { c -> map[c] = map.getOrDefault(c, 0) + 1 }
        return 1>= map.values.filter { v -> v%2==1 }.size
    }
}