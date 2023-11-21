package technology.touchmars.algo.leetcode.q0437
import technology.touchmars.algo.basic.TreeNode

class Solution {

    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        root ?: return 0
        return findPath(root, targetSum.toLong()) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum)
    }

    private fun findPath(node: TreeNode?, sumLong: Long): Int {
        node ?: return 0
        val nv = node.`val`
        val sub = sumLong - nv
        var sol = if (sub==0L) 1 else 0
        sol += findPath(node.left, sub)+findPath(node.right, sub)
        return sol
    }

}
