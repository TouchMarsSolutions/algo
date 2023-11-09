package technology.touchmars.algo.leetcode.q0127

import java.util.*

class Solution {

    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        if (!wordList.contains(endWord)) return 0
        val qStart = LinkedList<String>().apply { add(beginWord) }
        val stepStart = mutableMapOf(beginWord to 1)
        val qEnd = LinkedList<String>().apply { add(endWord) }
        val stepEnd = mutableMapOf(endWord to 1)

        while (qStart.isNotEmpty() && qEnd.isNotEmpty()) {
            val toVisit = if (qStart.size <= qEnd.size) qStart to stepStart else qEnd to stepEnd
            val queue = toVisit.first
            val qSize = queue.size
            val stepMap = toVisit.second
            val otherStepMap = if (stepMap === stepStart) stepEnd else stepStart
            for (i in 0 until qSize) {
                val p = queue.poll()
                val step = stepMap[p]!!
                wordList.filter { similar(p, it) }.forEach {
                    if (it in otherStepMap) {
                        return step + (otherStepMap[it] ?: 0)
                    } else if (it !in stepMap) {
                        queue.add(it)
                        stepMap[it] = step + 1
                    }
                }
            }

        }
        return 0
    }

    private fun similar(word1: String, word2: String): Boolean {
        if (word1.length != word2.length)
            throw IllegalArgumentException("word1 and word2 must have the same length")
        var diff = 0
        for (i in word1.indices) {
            if (word1[i] != word2[i]) {
                diff++
                if (diff > 1) return false
            }
        }
        return diff == 1
    }
}