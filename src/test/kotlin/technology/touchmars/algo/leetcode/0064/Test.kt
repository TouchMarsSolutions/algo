package technology.touchmars.algo.leetcode.`0064`

import kotlin.test.Test

class Test {
    @Test
    fun test() {
        val sol = Solution()
        assert(sol.minPathSum(arrayOf(intArrayOf(1,3,1), intArrayOf(1,5,1), intArrayOf(4,2,1))) == 7)
        assert(sol.minPathSum(arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6))) == 12)
    }
}