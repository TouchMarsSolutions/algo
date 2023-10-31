package technology.touchmars.algo.leetcode.q0094

import technology.touchmars.algo.basic.TreeNode
import java.util.*

class Solution {

    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root==null) return emptyList()
        val sol = mutableListOf<Int>()
        val stack = Stack<TreeNode>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            if (node.left==null && node.right==null) sol.add(node.`val`)
            else {
                if (node.right!=null) {
                    stack.push(node.right)
                    node.right = null
                }
                val left = node.left
                node.left = null
                stack.push(node)
                if (left!=null) {
                    stack.push(left)
                }
            }
        }
        return sol
    }
}
