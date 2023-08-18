package technology.touchmars.algo.leetcode.q0015

class Solution {

    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        return kSum(nums, 0, 0, 3)
    }

    // keep Long to avoid overflow
    fun kSum(nums: IntArray, target: Long, start: Int, k: Int): List<List<Int>> {
        val length = nums.size
        if (start >= length) return listOf()
        if (length - start < k) return listOf()
        if (k<2) return listOf()
        if (k==2) return twoSum(nums, target, start)
        val sol = mutableListOf<List<Int>>()
        for (idx in start until length-k+1) {
            val value = nums[idx]
            if (idx > start && value == nums[idx-1]) continue
            val prevSol = kSum(nums, target-value, idx+1, k-1)
            prevSol.forEach { addNewTuple(sol, it, value) }
        }
        return sol
    }

    private fun addNewTuple(sol: MutableList<List<Int>>, tuple: List<Int>, value: Int) {
        val newTuple = mutableListOf<Int>()
        newTuple.add(value)
        newTuple.addAll(tuple)
        sol.add(newTuple)
    }

    fun twoSum(nums: IntArray, target: Long, start: Int): List<List<Int>> {
        var left = start
        var rite = nums.size-1
        val sol = mutableListOf<List<Int>>()
        while (left < rite) {
            val sum = nums[left].toLong() + nums[rite].toLong()
            when {
                sum == target -> {
                    sol.add(listOf(nums[left], nums[rite]))
                    while (left < rite && nums[left]==nums[left+1]) left++
                    while (left < rite && nums[rite]==nums[rite-1]) rite--
                    left++
                    rite--
                }
                sum < target -> left++
                else -> rite--
            }
        }
        return sol
    }

}