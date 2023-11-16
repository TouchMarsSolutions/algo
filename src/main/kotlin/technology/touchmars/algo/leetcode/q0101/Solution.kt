package technology.touchmars.algo.leetcode.q0101

import technology.touchmars.algo.basic.TreeNode

class Solution {

    fun isSymmetric(root: TreeNode?): Boolean =
        root==null || symmetric(root.left, root.right)

    private fun symmetric(left: TreeNode?, rite: TreeNode?): Boolean =
        (left==null && rite==null) ||
        (left?.`val`==rite?.`val`
                && symmetric(left?.left, rite?.right)
                && symmetric(left?.right, rite?.left)
        )

}
