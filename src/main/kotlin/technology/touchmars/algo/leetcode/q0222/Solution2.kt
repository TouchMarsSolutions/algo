package technology.touchmars.algo.leetcode.q0222

import technology.touchmars.algo.basic.TreeNode

class Solution2 {

    fun countNodes(root: TreeNode?): Int {
        if (root==null) return 0
        return 1+countNodes(root.left)+countNodes(root.right)
    }






}
