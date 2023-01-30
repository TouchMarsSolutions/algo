package technology.touchmars.algo.leetcode.q0217

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>()
        nums.forEach { num ->
            if (set.contains(num)) return true
            else set.add(num)
        }
        return false;
    }
}