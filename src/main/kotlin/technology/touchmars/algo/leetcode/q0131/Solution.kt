package technology.touchmars.algo.leetcode.q0131

class Solution {

    fun partition(s: String): List<List<String>> {
        val sol = mutableListOf<List<String>>()
        dfs(s, 0, mutableListOf(), sol).let { return sol }
    }

    private fun dfs(s: String, start: Int, list: MutableList<String>, sol: MutableList<List<String>>) {
        sol.takeIf { start==s.length }?.add(list.toList())?.let { return }
        (start until s.length).filter { isPalindrome(s, start, it) }.forEach { end ->
            list.add(s.substring(start, end+1))
            dfs(s, end+1, list, sol)
            list.removeLast()
        }
    }

    private fun isPalindrome(s: String, start: Int, end: Int) = s.substring(start, end + 1).let { it == it.reversed() }

}
