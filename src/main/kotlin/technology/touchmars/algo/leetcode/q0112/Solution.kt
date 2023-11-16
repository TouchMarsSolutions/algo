package technology.touchmars.algo.leetcode.q0112

import technology.touchmars.algo.basic.TreeNode

class Solution {

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root==null) return false
        if (root.left==null && root.right==null) return root.`val`==targetSum
        return hasPathSum(root.left, targetSum-root.`val`) ||
                hasPathSum(root.right, targetSum-root.`val`)
    }

}
