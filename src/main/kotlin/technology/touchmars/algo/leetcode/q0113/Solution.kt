package technology.touchmars.algo.leetcode.q0113
import technology.touchmars.algo.basic.TreeNode

class Solution {

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val sol = mutableListOf<List<Int>>()
        dfs(root, targetSum, mutableListOf(), sol)
        return sol
    }

    private fun dfs(node: TreeNode?, sum: Int, path: MutableList<Int>, sol: MutableList<List<Int>>) {
        node ?: return
        path.add(node.`val`)
        if (node.left==null && node.right==null && node.`val`==sum) {
            sol.add(path.toList())
        } else {
            dfs(node.left, sum-node.`val`, path, sol)
            dfs(node.right, sum-node.`val`, path, sol)
        }
        path.removeLast()
    }

}
