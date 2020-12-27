package technology.touchmars.algo.leetcode.leco1099

import java.util.*

class Solution {

    fun twoSumLessThanK(nums: IntArray, k: Int): Int {
        if (nums==null || nums.size < 2) return -1
        val map = sortedMapOf<Int, Int>() as TreeMap
        nums.forEach { num -> map[num] = 1 + (map[num]?:0) }
        val min = map.keys.first()
        val max = map.keys.last()
        var head = max
        var tail = min
        var result = -1
        while (tail < head) {
            val sum = tail + head
            when {
                sum >= k -> {
                    do {
                        --head
                    } while (!map.containsKey(head) && tail < head)
                }
                sum == k-1 -> return sum
                else -> {
                    if (sum > result) result = sum
                    do {
                        tail++
                    } while (!map.containsKey(tail) && tail < head)

                }
            }
        }
        return if (head == tail && map.containsKey(tail) && map[tail]!! > 1 && tail*2<k) tail+head else result
    }

}