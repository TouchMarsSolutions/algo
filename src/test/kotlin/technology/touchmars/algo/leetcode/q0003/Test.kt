package technology.touchmars.algo.leetcode.q0003

import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun test() {
        val sol = Solution()
        assertEquals(3, sol.lengthOfLongestSubstring("abcabcbb"))
        assertEquals(1, sol.lengthOfLongestSubstring("bbbb"))
        assertEquals(3, sol.lengthOfLongestSubstring("pwwkew"))
    }
}
