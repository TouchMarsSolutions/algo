package technology.touchmars.algo.leetcode.q0145

import technology.touchmars.algo.basic.TreeNode
import java.util.*

class Solution {

    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root==null) return emptyList()
        val sol = mutableListOf<Int>()
        val stack = Stack<TreeNode>().apply { push(root)}
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            // leaf goto sol
            if (node.right==null && node.left==null) sol.add(node.`val`)
            else {
                stack.push(node)
                if (node.right!=null) {
                    stack.push(node.right)
                    node.right = null
                }
                if (node.left!=null) {
                    stack.push(node.left)
                    node.left = null
                }


            }
        }
        return sol
    }

}
