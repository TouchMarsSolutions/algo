package technology.touchmars.algo.leetcode.q0347

import kotlin.test.Test

class Test {
    @Test
    fun test() {
      val solution = Solution()
        val nums = intArrayOf(1, 2, 2, 3, 3, 3)
        val k = 1
        print(solution.topKFrequent(nums, k).toList())
    }
}
