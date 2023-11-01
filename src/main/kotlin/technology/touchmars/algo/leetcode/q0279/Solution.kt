package technology.touchmars.algo.leetcode.q0279

import java.util.*
import kotlin.math.sqrt

class Solution {
    fun numSquares(n: Int): Int {
        val q = LinkedList<Pair<Int, Int>>().apply { add(Pair(n, 0)) }
        val visited = BooleanArray(n + 1).apply { this[n] = true }
        while (q.isNotEmpty()) {
            val (num, step) = q.poll()
            for (move in 1..sqrt(num.toDouble()).toInt()) {
                val next = num - move*move
                if (next < 0) break
                if (next == 0) return step + 1
                if (!visited[next]) { // visited => shorter path of next
                    q.add(Pair(next, step + 1))
                    visited[next] = true
                }
            }
        }
        return -1
    }
}
