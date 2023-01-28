package technology.touchmars.algo.leetcode.leco0435

/**
 * [435 Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)
 *
 * Given a collection of intervals, find the minimum number of intervals
 * you need to remove to make the rest of the intervals non-overlapping.
 *
 */
class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortWith(Comparator { a, b ->
            if (a[1] == b[1]) a[0].compareTo(b[0])
            else a[1].compareTo(b[1])
        })
        val size = intervals.size
        if (size <= 1) return 0

        var res = 0
        var pre = intervals[0]
        for (i in 1 until intervals.size) {
            val cur = intervals[i]
            if (cur[0] >= pre[1]) {
                res++
                pre = cur
            }
        }
        return size - res - 1

    }
}