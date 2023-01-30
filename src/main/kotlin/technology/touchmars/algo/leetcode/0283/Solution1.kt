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
class Solution1 {

    fun moveZeroes(nums: IntArray): Unit {
        var head0 = -1
        nums.forEachIndexed { index, value ->
            if (value == 0) {
                // find the 1st 0
                if (head0 == -1) {
                    head0 = index
                }
            } else {
                // throw value to head0 position
                // then move head0 forward by 1
                // so that subrange [head0, index] should be 0
                if (head0 != -1) {
                    nums[head0++] = value
                }
            }

        }
        // if no 0 in the array, head0 will never move!
        if (head0!=-1)
            for (index in head0..nums.size-1)
                nums[index] = 0
    }

}