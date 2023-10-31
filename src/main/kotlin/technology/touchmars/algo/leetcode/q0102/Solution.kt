package technology.touchmars.algo.leetcode.q0102

import technology.touchmars.algo.basic.TreeNode
import java.util.*

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val sol = mutableListOf<List<Int>>()
        if (root==null) return sol
        val queue = LinkedList<Pair<TreeNode, Int>>().apply { add(Pair(root, 0)) }
        while (queue.isNotEmpty()) {
            val (node, level) = queue.poll()
            if (sol.size <= level) sol.add(mutableListOf())
            // trick: sol goes by level, the last 1 is always the level we are working on
            (sol.last() as MutableList).add(node.`val`)
            if (node.left!=null) queue.add(Pair(node.left!!, level+1))
            if (node.right!=null) queue.add(Pair(node.right!!, level+1))
        }
        return sol
    }
}
