package technology.touchmars.algo.leetcode.q0101

import technology.touchmars.algo.basic.TreeNode

class Solution {

    fun isSymmetric(root: TreeNode?): Boolean {
        return root==null || symmetric(root.left, root.right)
    }

    fun symmetric(left: TreeNode?, rite: TreeNode?): Boolean {
        if (left==null && rite==null) return true
        return left?.`val`==rite?.`val` && symmetric(left?.left, rite?.right) && symmetric(left?.right, rite?.left)
    }

}
