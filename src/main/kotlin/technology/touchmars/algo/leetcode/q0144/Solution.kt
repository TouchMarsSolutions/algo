package technology.touchmars.algo.leetcode.q0144

import technology.touchmars.algo.basic.TreeNode
import java.util.*

class Solution {

    fun preorderTraversal(root: TreeNode?): List<Int> {
        if (root==null) return emptyList()
        val sol = mutableListOf<Int>()
        val stack = Stack<TreeNode>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            // leaf goto sol
            if (node.right==null && node.left==null) sol.add(node.`val`)
            else {
                if (node.right!=null) {
                    stack.push(node.right)
                    node.right = null
                }
                if (node.left!=null) {
                    stack.push(node.left)
                    node.left = null
                }
                stack.push(node)

            }
        }
        return sol
    }
}
