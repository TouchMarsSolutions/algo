package technology.touchmars.algo.leetcode.q0026

/**
`[Leetcode 26: Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/ "Remove Duplicates from Sorted Array")`
 */
class Solution {

    // pre: sorted array nums
    fun removeDuplicates(nums: IntArray): Int {
        val size = nums.size
        if (size in intArrayOf(0,1))
            return size
        // make sure [0..head] are sorted without ANY duplicate
        var head = 0
        for ((index, value) in nums.withIndex()) {
            if (value!=nums[head]) {
                // find a diff one
                // move head forward 1 step to allocate space for value
                head++
                if (index>head) {
                    swap(nums, head, nums[head], index, value)
                }
            }

        }
        return head+1
    }

    private fun swap(nums: IntArray, head: Int, target: Int, index: Int, value: Int) {
        nums[head] = value
        nums[index] = target
    }
}