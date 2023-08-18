package technology.touchmars.algo.leetcode.q0018

import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun test() {
        val solution = Solution()
        val ans = solution.fourSum(
            intArrayOf(1000000000, 1000000000, 1000000000, 100000000), -294967296
        )
        println(ans)
        assertEquals(0, ans.size)
    }
}
