package technology.touchmars.algo.leetcode.q0126

class Solution {

    private var shortestPaths: MutableList<List<String>> = mutableListOf()
    private var adjList: MutableMap<String, MutableList<String>> = mutableMapOf()
    private var currPath: MutableList<String> = mutableListOf()

    fun findLadders(beginWord: String, endWord: String, wordList: List<String>?): List<List<String>> {
        val wordSet = wordList?.toMutableSet() ?: mutableSetOf()
        // copying the words into the set for efficient deletion in BFS
        if (wordSet.isEmpty() || !wordSet.contains(endWord)) return shortestPaths
        // build the DAG using BFS
        val bfs = bfs(beginWord, endWord, wordSet)
        // There is no valid sequence that connects `beginWord` to `endWord`
        if (!bfs) return shortestPaths
        // every path will start from the beginWord
        currPath.add(beginWord)
        // traverse the DAG to find all the paths between beginWord and endWord
        backtrack(beginWord, endWord)
        return shortestPaths
    }

    private fun bfs(beginWord: String, endWord: String, wordSet: MutableSet<String>): Boolean {

        val qStart = mutableSetOf(beginWord)
        val qEnd = mutableSetOf(endWord)
        var found = false
        var toVisit = Triple(qStart, qEnd, 1)

        while (toVisit.first.isNotEmpty()) {
            if (qStart.size > qEnd.size) toVisit = Triple(qEnd, qStart, 0)
            val q = toVisit.first
            val otherQ = toVisit.second
            val dir = toVisit.third
            val visited = mutableSetOf<String>()
            for (w in q) {
                val neighbors = findNeighbors(w, wordSet)
                for (child in neighbors) {
                    if (otherQ.contains(child)) {
                        found = true
                        addEdge(w, child, dir)
                    } else if (!found && wordSet.contains(child) && !q.contains(child)) {
                        visited.add(child)
                        addEdge(w, child, dir)
                    }
                }
            }
            q.forEach { wordSet.remove(it) }
            if (found) break
            q.apply { clear() }.addAll(visited)
        }
        return found

    }

    private fun backtrack(source: String, destination: String) {
        if (source == destination) {
            val tempPath = ArrayList(currPath)
            shortestPaths.add(tempPath)
        }
        if (!adjList.containsKey(source)) {
            return
        }
        for (i in adjList[source]!!.indices) {
            currPath.add(adjList[source]!![i])
            backtrack(adjList[source]!![i], destination)
            currPath.removeAt(currPath.size - 1)
        }
    }

    private fun addEdge(word1: String, word2: String, direction: Int) {
        if (direction == 1) {
            if (!adjList.containsKey(word1)) {
                adjList[word1] = ArrayList()
            }
            adjList[word1]!!.add(word2)
        } else {
            if (!adjList.containsKey(word2)) {
                adjList[word2] = ArrayList()
            }
            adjList[word2]!!.add(word1)
        }
    }

    private fun findNeighbors(word: String, wordSet: Set<String>) = wordSet.filter { similar(word, it) }.toMutableSet()

    private fun similar(word1: String, word2: String): Boolean {
        var diff = 0
        return word1.indices.any { word1[it] != word2[it] && ++diff > 1 }.not() && diff == 1
    }

}