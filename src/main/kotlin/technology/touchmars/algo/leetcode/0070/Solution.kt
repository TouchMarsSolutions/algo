package technology.touchmars.algo.leetcode.`0070`

/**
 * [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Constraints: `1 <= n <= 45`
 */
class Solution {
    private fun initMemo(n: Int): IntArray {
        val memo = IntArray(n+1)
        memo[0] = 1
        memo[1] = 1
        for (i in 2..n) memo[i] = memo[i-1] + memo[i-2]
        return memo

    }
    fun climbStairs(n: Int): Int {
        return initMemo(n)[n]
    }
}