package technology.touchmars.algo.leetcode.q0220

class Solution {
    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        val set = sortedSetOf<Long>()
        for ((idx, numInt) in nums.withIndex()) {
            val num = numInt.toLong()
            // search inside set to find the least value that is greater than num-t
            val ceiling = set.ceiling(num-t)
            if (ceiling!=null && ceiling <= num+t) return true
            set.add(num)
            if (set.size == k+1) set.remove(nums[idx-k].toLong())
        }
        return false;
    }
}