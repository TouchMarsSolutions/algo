package technology.touchmars.algo.leetcode.q0111

import technology.touchmars.algo.basic.TreeNode
import kotlin.math.min

class Solution {

    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        if (root.left==null && root.right==null) return 1
        if (root.left!=null && root.right==null) return 1 + minDepth(root.left)
        if (root.left==null) return 1 + minDepth(root.right)
        return 1 + min(minDepth(root.left), minDepth(root.right))

    }
}
