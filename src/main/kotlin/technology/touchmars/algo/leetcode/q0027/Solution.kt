package technology.touchmars.algo.leetcode.q0027

/**
 `[Leetcode 27](https://leetcode.com/problems/remove-element/ "Remove Element")`
 */
class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var head = 0
        for ((index, value) in nums.withIndex()) {
            if (value!=`val`) {
                if (index!=head)
                    swap(nums, head++, `val`, index, value)
                else
                    head++
            }
        }
        return head
    }

    private fun swap(nums: IntArray, head: Int, target: Int, index: Int, value: Int) {
        nums[head] = value
        nums[index] = target
    }
}