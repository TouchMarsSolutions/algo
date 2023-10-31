package technology.touchmars.algo.leetcode.q0107

import technology.touchmars.algo.basic.TreeNode
import java.util.*

class Solution {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val sol = mutableListOf<List<Int>>()
        val queue = LinkedList<Pair<TreeNode, Int>>().apply { root?.let { add(Pair(it, 0)) } }
        while (queue.isNotEmpty()) {
            val (p, level) = queue.poll()
            if (sol.size <= level) sol.add(0, mutableListOf())
            (sol.first() as MutableList).add(p.`val`)
            p.left?.let { queue.add(Pair(it, level+1)) }
            p.right?.let { queue.add(Pair(it, level+1)) }
        }
        return sol
    }
}
