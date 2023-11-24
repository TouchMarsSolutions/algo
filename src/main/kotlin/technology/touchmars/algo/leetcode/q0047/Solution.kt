package technology.touchmars.algo.leetcode.q0047

class Solution {

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val sol: MutableList<List<Int>> = mutableListOf()
        nums.takeIf { it.isNotEmpty() } ?: return sol
        nums.sort()
        permutation(nums, 0, mutableListOf(), BooleanArray(nums.size), sol).let { return sol }

    }

    private fun permutation(nums: IntArray, start: Int,
                            path: MutableList<Int>, visited: BooleanArray, sol: MutableList<List<Int>>) {
        sol.takeIf { start==nums.size }?.add(path.toList())?.let { return }
        nums.indices.filterNot { visited[it] || (it>0 && nums[it-1]==nums[it] && !visited[it-1]) }.forEach { idx ->
            visited[idx] = true
            permutation(nums, start+1, path.apply { add(nums[idx]) }, visited, sol)
            path.removeLast().let { visited[idx] = false }
        }
    }

}
