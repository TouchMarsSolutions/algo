package technology.touchmars.algo.leetcode.q0104

import technology.touchmars.algo.basic.TreeNode

class Solution {

    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right))

    }

}
