package technology.touchmars.algo.leetcode.`0064`

/**
 * [64. Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)
 *
 * ### Constraints:
 *
 * - `m == grid.length`
 * - `n == grid[i].length`
 * - `1 <= m, n <= 200`
 * - `0 <= grid[i][j] <= 100`
 */
class Solution {

    private fun augment(row: Int, col: Int, sol: Array<IntArray>): Int =
        if (row==0 && col==0) 0
        else if (row==0) sol[row][col-1]
        else if (col==0) sol[row-1][col]
        else Math.min(sol[row-1][col], sol[row][col-1])

    fun minPathSum(grid: Array<IntArray>): Int {
        val height = grid.size
        val width = grid[0].size
        val sol = Array(height) { IntArray(width) {-1} }
        for ((row, rowArray) in grid.withIndex()) {
            for ((col, value) in rowArray.withIndex()) {
                sol[row][col] = value + augment(row, col, sol)
            }
        }
        return sol[height-1][width-1]
    }
}