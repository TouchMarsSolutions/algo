package technology.touchmars.algo.leetcode.q0129
import technology.touchmars.algo.basic.TreeNode
class Solution {

    fun sumNumbers(root: TreeNode?): Int {
        return dfs(root, 0)
    }

    private fun dfs(node: TreeNode?, sum: Int): Int {
        node ?: return 0
        if (node.left==null && node.right==null) return 10*sum+node.`val`
        return dfs(node.left, sum*10+node.`val`) + dfs(node.right, sum*10+node.`val`)
    }

}
