package technology.touchmars.algo.leetcode.q0046

class Solution {

    fun permute(nums: IntArray): List<List<Int>> {
        val sol = mutableListOf<List<Int>>()
        nums.takeIf { it.isNotEmpty() } ?: return sol
        permutation(nums, 0, mutableListOf(), IntArray(nums.size), sol).let { return sol }

    }

    private fun permutation(nums: IntArray, start: Int,
                            path: MutableList<Int>, visited: IntArray, sol: MutableList<List<Int>>) {
        sol.takeIf { start==nums.size }?.add(path.toList())?.let { return }
        nums.indices.filter { 1!=visited[it] }.forEach { idx ->
            visited[idx] = 1
            permutation(nums, start+1, path.apply { add(nums[idx]) }, visited, sol)
            path.removeLast().let { visited[idx] = 0 }
        }
    }

}
