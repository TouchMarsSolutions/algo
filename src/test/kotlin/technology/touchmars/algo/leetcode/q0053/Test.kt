package technology.touchmars.algo.leetcode.q0053

import kotlin.test.assertEquals
import kotlin.test.Test

class Test {
    @Test
    fun test1() {
        val solution = Solution()
        val nums = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
        val max = solution.maxSubArray(nums)
        assertEquals(6, max)
    }

    @Test
    fun test2() {
        val solution = Solution()
        val nums = intArrayOf(-2,-1)
        val max = solution.maxSubArray(nums)
        assertEquals(-1, max)
    }

    @Test
    fun test3() {
        val solution = Solution()
        val nums = intArrayOf(0,-3,1,1)
        val max = solution.maxSubArray(nums)
        assertEquals(2, max)
    }

    @Test
    fun test4() {
        val solution = Solution()
        val nums = intArrayOf(3,-2,-3,-3,1,3,0)
        val max = solution.maxSubArray(nums)
        assertEquals(4, max)
    }
}