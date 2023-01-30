package technology.touchmars.algo.leetcode.q0392

/**
 * ### [392. Is Subsequence](https://leetcode.com/problems/is-subsequence/)
 */
class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var si = 0
        var ti = 0
        val len = s.length
        while (si<len && ti<t.length) {
            if (s[si]==t[ti]) {
                si++
                ti++
            } else {
                ti++
            }
        }
        return si==len
    }
}