package technology.touchmars.algo.leetcode.`0120`

/**
 * [120. Triangle](https://leetcode.com/problems/triangle/)
 *
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * More formally, if you are on index i on the current row,
 * you may move to either index i or index i + 1 on the next row.
 *
 * ### Constraints:
 *
 * - `1 <= triangle.length <= 200`
 * - `triangle[0].length == 1`
 * - `triangle[i].length == triangle[i - 1].length + 1`
 * - `-10^4 <= triangle[i][j] <= 10^4`
 */
class Solution {

    fun minimumTotal(triangle: List<List<Int>>): Int {

        val height = triangle.size

        val paths = mutableListOf<List<Int>>()
        var lastRow = IntArray(1) { triangle[0][0] }.toList()
        paths.add(lastRow)
        for (row in 1 until height) {
            val t = triangle[row]
            val path = mutableListOf<Int>()
            path.add(t[0] + lastRow[0])
            for (col in 1 until t.size - 1) {
                path.add(t[col] + Math.min(lastRow[col - 1], lastRow[col]))
            }
            path.add(t[t.size-1] + lastRow[lastRow.size-1])
            paths.add(path)
            lastRow = path
        }

        var min = Int.MAX_VALUE
        for (i in lastRow) {
            if (i < min) min = i
        }
        return min

    }
}