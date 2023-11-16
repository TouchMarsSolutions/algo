package technology.touchmars.algo.leetcode.q0404

import technology.touchmars.algo.basic.TreeNode

class Solution {

    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root == null) return 0
        val left = root.left
        val rite = root.right
        if (left!=null && isLeaf(left)) return left.`val`+sumOfLeftLeaves(rite)
        return sumOfLeftLeaves(left) + sumOfLeftLeaves(rite)
    }

    private fun isLeaf(node: TreeNode) = node.left==null && node.right == null

}
