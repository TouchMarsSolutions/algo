package technology.touchmars.algo.leetcode.q0001

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        return twoSum(nums, target, 0)
    }

    fun twoSum(nums: IntArray, target: Int, start: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (idx in start until nums.size) {
            val num = nums[idx]
            val complementIndex = map[target - num]
            if (complementIndex!=null) return intArrayOf(complementIndex, idx)
            map[num] = idx
        }
        return intArrayOf()
    }
}