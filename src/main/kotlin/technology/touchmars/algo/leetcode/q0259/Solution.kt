package technology.touchmars.algo.leetcode.q0259

import java.util.SortedMap

class Solution {
    private fun min(a:Int, b: Int): Int = if (a<=b) a else b
    private fun initMap(nums: IntArray, map: SortedMap<Int, Int> = sortedMapOf()): SortedMap<Int, Int> {
        nums.forEach { num -> map[num] = 1 + map.getOrDefault(num, 0) }
        return map
    }
    fun combinatorics(n: Int, k: Int): Int {
        return if (n==0||k==0||n==k) 1
        else if (n==k+1) n
        else if (k==1) n
        else if (k==2) n*(n-1)/2
        else if (k==3) n*(n-1)*(n-2)/6
        else combinatorics(n-1, k) + combinatorics(n-1, k-1)
    }
    fun threeSumSmaller(nums: IntArray, target: Int): Int {
        if (nums.size<3) return 0
        val map = initMap(nums)
        val max = map.lastKey()
        var result = 0
        var tailMap = map
        while (tailMap.isNotEmpty()) {
            val tail = tailMap.firstKey()
            if (tail*3>=target) break
            val cnt = tailMap[tail]!!
            if (cnt>=3 && tail*3<target) result+=combinatorics(cnt, 3) // AAA
            if (cnt>=2) { // A, A, B
                val comp = target - 2 * tail - 1
                if (comp > tail && tail < max) {
                    result += combinatorics(cnt, 2) *
                            tailMap.tailMap(tail+1).headMap(min(comp, max)+1).values.sumOf { it }
                }
                // append::A, B, ? in [B, max]
            }
            // A, B, ? in [B, max]
            val headMap = tailMap.tailMap(tail+1) // okay since size>=2
            for (head in headMap.keys) {
                val cntHead = headMap[head]!!
                // A, B, B
                if (cntHead >= 2 && head * 2 + tail < target) {
                    result += cnt * combinatorics(cntHead, 2)
                }
                // A, B, C
                val comp = target - tail - head - 1
                if (comp > head && head < max) {
                    result += cnt * cntHead *
                            headMap.tailMap(head+1).headMap(min(comp, max)+1).values.sumOf { it }
                }
            }
            tailMap = map.tailMap(tail+1)
        }
        return result
    }

}