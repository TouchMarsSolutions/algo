package technology.touchmars.algo.leetcode.leco0080

/**
 * [80. Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii)
 */
class Solution {

    // pre: sorted array nums
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        // make sure [0..head] are sorted without ANY duplicate
        var head = 0
        nums.forEachIndexed{ index, value ->
            if (index>head)
                if (value!=nums[head] || head==0 || (nums[head]!=nums[head-1])) {
                    // find a diff one or the only allowed sibling
                    // move head forward 1 step to allocate space for value
                    head++
                    swap(nums, head, nums[head], index, value)
                }

        }
        return head+1
    }

    private fun swap(nums: IntArray, head: Int, target: Int, index: Int, value: Int) {
        nums[head] = value
        nums[index] = target
    }
}