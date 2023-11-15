package technology.touchmars.algo.leetcode.q0226

import technology.touchmars.algo.basic.TreeNode

class Solution {

    fun invertTree(root: TreeNode?): TreeNode? {
        if (root?.left==null && root?.right==null) return root
        invertTree(root.left)
        invertTree(root.right)
        swapSubtree(root)
        return root
    }

    private fun swapSubtree(root: TreeNode) {
        val tmp = root.left
        root.left = root.right
        root.right = tmp
    }

}
