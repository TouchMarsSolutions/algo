package technology.touchmars.algo.leetcode.q0219

class Solution {
    /**
     * idea: sliding window of length=k+1
     * Use a Set of which the size is limited to k+1
     */
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val set = HashSet<Int>(k+1)
        for ((idx, num) in nums.withIndex()) {
            if (set.contains(num)) return true
            set.add(num)
            if (set.size == k+1) set.remove(nums[idx-k])
        }
        return false
    }
}