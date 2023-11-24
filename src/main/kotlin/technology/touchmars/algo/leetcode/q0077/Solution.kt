package technology.touchmars.algo.leetcode.q0077

class Solution {

    fun combine(n: Int, k: Int): List<List<Int>> {
        if (n<=0 || k<=0 || k>n) return emptyList()
        return mutableListOf<List<Int>>().also { combination(n, k, 1, mutableListOf(), it) }
    }

    private fun combination(n: Int, k: Int, start: Int, path: MutableList<Int>, sol: MutableList<List<Int>>) {
        sol.takeIf { k==path.size }?.add(path.toList())?.let { return }
        val size = path.size
        (start..(n+1-k+size)).forEach {
            combination(n, k, it+1, path.apply { add(it) }, sol)
            path.removeLast()
        }
    }

}
