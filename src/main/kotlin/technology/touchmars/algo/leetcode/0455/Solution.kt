package technology.touchmars.algo.leetcode.leco0455

/**
 * ### Question [455. Assign Cookies](https://leetcode.com/problems/assign-cookies/)
 */
class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sortDescending()
        s.sortDescending()
        // two points walk through g and s
        var i = 0
        var j = 0
        var count = 0
        while (i<g.size && j<s.size) {

            if (g[i]<=s[j]) {
                i++
                j++
                count++
            } else {
                i++
            }
        }
        return count
    }
}