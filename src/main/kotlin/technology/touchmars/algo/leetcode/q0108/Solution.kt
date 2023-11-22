package technology.touchmars.algo.leetcode.q0108
import technology.touchmars.algo.basic.TreeNode

class Solution {

    fun sortedArrayToBST(nums: IntArray): TreeNode? = buildTree(nums, 0, nums.lastIndex)

    private fun buildTree(nums: IntArray, l: Int, r: Int): TreeNode? {
        if (l > r) return null
        val mid = (l+r)/2
        return TreeNode(nums[mid]).apply {
            left = buildTree(nums, l, mid - 1)
            right = buildTree(nums, mid + 1, r)
        }

    }

}
