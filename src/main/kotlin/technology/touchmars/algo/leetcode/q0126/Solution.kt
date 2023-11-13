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

        var forwardQueue: MutableSet<String> = mutableSetOf(beginWord)
        var backwardQueue: MutableSet<String> = mutableSetOf(endWord)
        var found = false
        var direction = 1

        while (forwardQueue.isNotEmpty()) {
            // visited will store the words of current layer
            val visited = mutableSetOf<String>()

            // swap the queues because we are always extending the forwardQueue
            if (forwardQueue.size > backwardQueue.size) {
                val temp = forwardQueue
                forwardQueue = backwardQueue
                backwardQueue = temp
                direction = direction xor 1
            }
            for (currWord in forwardQueue) {
                val neighbors = findNeighbors(currWord, wordSet)
                for (word in neighbors) {
                    // if the backwardQueue already contains it we can stop after completing this level
                    if (backwardQueue.contains(word)) {
                        found = true
                        addEdge(currWord, word, direction)
                    } else if (!found && wordSet.contains(word) && !forwardQueue.contains(word)) {
                        visited.add(word)
                        addEdge(currWord, word, direction)
                    }
                }
            }

            // removing the words of the previous layer
            for (currWord in forwardQueue) {
                if (wordSet.contains(currWord)) {
                    wordSet.remove(currWord)
                }
            }
            if (found) {
                break
            }
            forwardQueue = visited
        }
        return found
    }

    private fun backtrack(source: String, destination: String) {
        // store the path if we reached the endWord
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