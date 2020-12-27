package technology.touchmars.algo.leetcode.leco0259

import java.util.*

class Solution {

    private fun initMap(nums: IntArray, map: SortedMap<Int, Int> = sortedMapOf()): SortedMap<Int, Int> {
        nums.forEach { num -> map[num] = 1 + map.getOrDefault(num, 0) }
        return map
    }
    private fun combinatorics(n: Int, k: Int): Int {
        return if (n<=k) 1
        else {
            var sol = 1
            IntRange(k+1, n).forEach { r -> sol+=r*sol }
            sol
        }
    }
    fun threeSumSmaller(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return 0
        val map = initMap(nums)
        var result = 0
//        val min = map.firstKey()
//        val max = map.lastKey()
        var tailMap = map
//        var tail = min
        while (tailMap.isNotEmpty()) {
            val tail = tailMap.firstKey()
            val cnt = tailMap[tail]!!
            when (tailMap.size) {
                1 -> { // tail == max = 0
                    if (tail==0 && cnt>=3) result+=combinatorics(cnt, 3)
                    return result
                }
                else -> { // size >= 2
                    if (cnt>=2) {
                        // A, A, ?
                        val comp = 0 - 2 * tail
                        if (comp==tail && cnt>=3) { // AAA=000
                            result += combinatorics(cnt, 3)
                        }else if (comp>tail && tailMap.containsKey(comp)){ // A, A, B
                            result += combinatorics(cnt, 2)*tailMap[comp]!!
                        }
                        // append::A, B, ? in [B, max]
                    }
                    // A, B, ? in [B, max]
                    val headMap = tailMap.tailMap(tail+1) // okay since size>=2
                    for (head in headMap.keys) {
                        val comp = 0 - tail - head
                        if (comp==head && headMap[comp]!!>=2) { // A, B, B
                            result+=cnt*combinatorics(headMap[comp]!!, 2)
                        } else if (comp>head && headMap.containsKey(comp)) // A, B, C
                            result+=cnt*headMap[head]!!*headMap[comp]!!
                    }
                }
            } // end when
            tailMap = map.tailMap(tail+1)
        }
        return result
    }

}