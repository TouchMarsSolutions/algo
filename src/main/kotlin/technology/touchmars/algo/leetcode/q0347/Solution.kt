package technology.touchmars.algo.leetcode.q0347

import java.util.*


class Solution {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val freq = nums.groupBy { it }.mapValues { it.value.size }
        val useK = (k <= freq.size/2)
        val heapSize = if (useK) k else freq.size-k
        val comparator = if (useK) compareBy<Pair<Int, Int>>{ it.second } else compareByDescending { it.second }
        val heap = PriorityQueue(comparator)
        freq.forEach {
            heap.add(it.toPair())
            if (heap.size > heapSize) heap.poll()
        }
        return if (useK) {
            heap.map { it.first }.toIntArray()
        } else {
            val exclusion = heap.map { it.first }.toSet()
            freq.keys.filter { it !in exclusion }.toIntArray()
        }
    }

    fun main() {
        val nums = intArrayOf(1, 2, 2, 3, 3, 3)
        val k = 1
        print(Solution().topKFrequent(nums, k))
    }

}
