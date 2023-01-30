package technology.touchmars.algo.leetcode.q1099

class Solution {

    fun twoSumLessThanK(nums: IntArray, k: Int): Int {
        if (nums.size < 2) return -1
        val map = sortedMapOf<Int, Int>()
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
                    head = map.headMap(head).lastKey()
                }
                sum == k-1 -> return sum
                else -> {
                    if (sum > result) result = sum
                    tail = map.tailMap(tail+1).firstKey()
                }
            }
        }
        return if (head == tail && map.containsKey(tail) && map[tail]!! > 1 && tail*2<k) tail+head else result
    }

}