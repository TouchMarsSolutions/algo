package technology.touchmars.algo.leetcode.q0404

import technology.touchmars.algo.basic.TreeNode

class Solution {

    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root == null) return 0
        val left = root.left
        val rite = root.right
        return sumOfLeftLeaves(rite) + if (left!=null && isLeaf(left)) left.`val` else sumOfLeftLeaves(left)
    }

    private fun isLeaf(node: TreeNode) = node.left==null && node.right == null

}
