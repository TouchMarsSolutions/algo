package technology.touchmars.algo.leetcode.q0442

/**
    Given an array of integers, `1 <= a[i] <= n` (n = size of array),
    some elements appear twice and others appear once.

    Find all the elements that appear twice in this array.

    Could you do it without extra space and in O(n) runtime?

    Example:
    Input: `[4,3,2,7,8,2,3,1]`
    Output: `[2,3]`

    [LeetCode 442](https://leetcode.com/problems/find-all-duplicates-in-an-array/)

    [result](https://leetcode.com/submissions/detail/343615784/)
 */
class Solution {

    fun findDuplicates(nums: IntArray): List<Int> {
        val res = ArrayList<Int>()
        nums.forEach {
            val index = Math.abs(it)-1
            if (nums[index] >= 0)
                nums[index] = nums[index].unaryMinus()
            else
                res.add(Math.abs(it))
        }
        return res
    }

}



