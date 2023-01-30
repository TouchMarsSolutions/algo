package technology.touchmars.algo.leetcode.q0283

/**
 * [LeetCode 283](https://leetcode.com/problems/move-zeroes/)
 ```
    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Example:

    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]
    Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
 ```
 Method: 2 pointers, DO NOT swap self, be careful of head0 pointer!
 */
class Solution {

    fun moveZeroes(nums: IntArray): Unit {
        var head0 = 0
        for ((index, value) in nums.withIndex()) {
            if (value != 0) {
                if (index != head0)
                    swap(nums, head0++, index)
                else
                    head0++
            }
        }
    }

    private fun swap(nums: IntArray, head0: Int, index: Int) {
        nums[head0] = nums[index]
        nums[index] = 0
    }
}