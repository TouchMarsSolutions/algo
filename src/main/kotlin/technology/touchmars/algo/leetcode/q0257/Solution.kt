package technology.touchmars.algo.leetcode.q0257

import technology.touchmars.algo.basic.TreeNode

class Solution {

    fun binaryTreePaths(root: TreeNode?): List<String> {
        val sol = mutableListOf<String>()
        if (root==null) return sol
        if (isLeaf(root)) return sol.apply { add(root.`val`.toString()) }
        listOf(binaryTreePaths(root.left), binaryTreePaths(root.right)).forEach { it.forEach {
            s -> sol.add(root.`val`.toString()+"->"+s)
        } }
        return sol
    }

    private fun isLeaf(node: TreeNode?): Boolean = node!=null && node.left==null && node.right==null

}
