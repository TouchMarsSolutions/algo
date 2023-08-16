package technology.touchmars.algo.leetcode.q0209

class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var minLen = Int.MAX_VALUE
        var sum = 0
        var left = 0
        for (right in nums.indices) {
            sum += nums[right]
            while (sum >= target) {
                minLen = minOf(minLen, right - left + 1)
                sum -= nums[left++]
            }
        }
        return if (minLen == Int.MAX_VALUE) 0 else minLen
    }
}
