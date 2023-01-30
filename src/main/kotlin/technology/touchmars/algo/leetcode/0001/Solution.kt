package technology.touchmars.algo.leetcode.leco0001

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for ((idx, num) in nums.withIndex()) {
            val complementIndex = map[target - num];
            if (complementIndex!=null) return intArrayOf(complementIndex, idx)
            map[num] = idx
        }
        return intArrayOf()
    }
}