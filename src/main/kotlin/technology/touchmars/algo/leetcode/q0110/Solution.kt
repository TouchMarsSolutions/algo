package technology.touchmars.algo.leetcode.q0110

import technology.touchmars.algo.basic.TreeNode
import kotlin.math.abs
import kotlin.math.max

class Solution {

    fun isBalanced(root: TreeNode?): Boolean {
        return height(root) != -1
    }

    private fun height(node: TreeNode?): Int {
        if (node==null) return 0
        val leftH = height(node.left)
        if (leftH == -1) return -1
        val riteH = height(node.right)
        if (riteH == -1) return -1
        if (abs(leftH - riteH) > 1) return -1
        return max(leftH, riteH) + 1

    }

}
