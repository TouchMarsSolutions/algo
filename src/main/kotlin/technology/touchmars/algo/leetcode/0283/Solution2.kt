package technology.touchmars.algo.leetcode.leco0283

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
 Method: 2 pointers
 */
class Solution2 {

    fun moveZeroes(nums: IntArray): Unit {
        var head0 = -1
        for ((index, value) in nums.withIndex()) {
            if (value==0 && head0==-1) {
                head0 = index
            }else if (value!=0 && head0!=-1) {
                swap(nums, head0++, index)
            }
        }

    }

    private fun swap(nums: IntArray, head0: Int, index: Int) {
        nums[head0] = nums[index]
        nums[index] = 0
    }
}