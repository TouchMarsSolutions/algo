package technology.touchmars.algo.leetcode.q0020

import java.util.*

class Solution {

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (c in s) {
            // if c is in ['(','[','{'] then push it to stack
            if (c in listOf('(','[','{')) {
                stack.push(c)
            } else if (stack.isNotEmpty()) {
                val left = stack.pop()
                if (c == ')' && left != '(') {
                    return false
                } else if (c == ']' && left != '[') {
                    return false
                } else if (c == '}' && left != '{') {
                    return false
                }
            } else {
                return false
            }

        }
        return stack.isEmpty()
    }

}
