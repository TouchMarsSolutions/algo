package technology.touchmars.algo.leetcode.leco0003

import kotlin.math.max

/**
 [LeetCode 0003 - Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/ "Longest Substring Without Repeating Characters")
 */
class Solution {
    /**
     * method: sliding window
     * walk through the String, mark down the length of the qualified substring
     * TODO: review
     * time: `O(n)`
     * space: `O(256)`
     */
    fun lengthOfLongestSubstring(s: String): Int {
        val hashIndexes = IntArray(256){-1}
        var l = 0
        var res = 0
        for ((r, value) in s.withIndex()) {
            val indexR = value.toInt()
            l = max(l, hashIndexes[indexR]+1)
            hashIndexes[indexR] = r
            res = max(res,r-l+1)
        }
        return res
    }


}