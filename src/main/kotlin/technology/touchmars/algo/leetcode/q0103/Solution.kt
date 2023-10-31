package technology.touchmars.algo.leetcode.q0103

import technology.touchmars.algo.basic.TreeNode
import java.util.*

class Solution {

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val sol = mutableListOf<List<Int>>()
        val queue = LinkedList<Pair<TreeNode, Int>>().apply { root?.let { add(Pair(it, 0)) } }
        while (queue.isNotEmpty()) {
            val (p, level) = queue.poll()
            // entering new level
            if (sol.size <= level) sol.add(mutableListOf())
            (sol.last() as MutableList).apply {
                if (level % 2 == 0) add(p.`val`)
                else add(0, p.`val`)
            }
            p.left?.let { queue.add(Pair(it, level+1)) }
            p.right?.let { queue.add(Pair(it, level+1)) }
        }
        return sol
    }
}
