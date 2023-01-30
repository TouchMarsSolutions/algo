package technology.touchmars.algo.leetcode.leco0125

class Solution {
    fun isPalindrome(s: String): Boolean {
        if (s.isEmpty() || s.length==1) return true
        val length = s.length
        var start = 0
        var end = length-1
        while ( start < end ) {
            while (start<end && !isLegal(s.get(start))) {
                start++
            }
            while (start<end && !isLegal(s.get(end))) {
                end--
            }
            if (s.get(start).lowercaseChar()!=s.get(end).lowercaseChar()) 
                return false
            start++
            end--
        }
        return true
    }

    private fun isLegal(c: Char): Boolean {
        return c.isLetterOrDigit()
    }
}