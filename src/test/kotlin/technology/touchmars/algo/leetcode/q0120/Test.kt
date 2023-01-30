package technology.touchmars.algo.leetcode.q0120

import kotlin.test.Test

class Test {

    @Test
    fun test() {
        val solution = Solution()
        val triangle = listOf(
            listOf(2),
            listOf(3, 4),
            listOf(6, 5, 7),
            listOf(4, 1, 8, 3)
        )
        val result = solution.minimumTotal(triangle)
        println(result)
    }
}