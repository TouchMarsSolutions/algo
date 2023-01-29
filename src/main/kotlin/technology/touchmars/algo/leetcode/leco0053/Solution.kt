package technology.touchmars.algo.leetcode.leco0053

/**
 * [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
 *
 * Given an integer array `nums`, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 */
class Solution {
    // Kadane's Algorithm
    fun maxSubArray(nums: IntArray): Int {
        var max = nums[0]
        var curMax = nums[0]
        for (i in 1 until nums.size) {
            curMax = maxOf(nums[i], curMax + nums[i])
            max = maxOf(max, curMax)
        }
        return max
    }
}