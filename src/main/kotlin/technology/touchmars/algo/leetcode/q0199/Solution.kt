package technology.touchmars.algo.leetcode.q0199

import technology.touchmars.algo.basic.TreeNode
import java.util.*

class Solution {

    fun rightSideView(root: TreeNode?): List<Int> {
        val sol = mutableListOf<Int>()
        val queue = LinkedList<Pair<TreeNode, Int>>().apply { root?.let { add(Pair(it, 0)) } }
        while (queue.isNotEmpty()) {
            val p = queue.poll()
            val (node, level) = p
            if (sol.size <= level) sol.add(node.`val`)
            else sol[level] = node.`val`
            node.left?.let { queue.add(Pair(it, level+1)) }
            node.right?.let { queue.add(Pair(it, level+1)) }
        }
        return sol
    }
}
