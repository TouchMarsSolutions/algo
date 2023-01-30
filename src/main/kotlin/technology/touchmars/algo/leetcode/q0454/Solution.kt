package technology.touchmars.algo.leetcode.q0454

class Solution {
    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        val cdMap = mutableMapOf<Int, Int>()
        for (c in C) {
            for (d in D) {
                cdMap[c+d] = 1+ cdMap.getOrDefault(c+d, 0)
            }
        }
        var sol = 0
        for (a in A)
            for (b in B)
                sol += cdMap.getOrDefault(0-a-b, 0)

        return sol
    }
}