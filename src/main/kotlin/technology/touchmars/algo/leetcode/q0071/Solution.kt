package technology.touchmars.algo.leetcode.q0071

import java.util.*

class Solution {

    fun simplifyPath(path: String): String {
        var sol = ""
        val stack = Stack<String>()
        path.split("/").forEach { token ->
            when (token) {
                "", "." -> {}
                ".." -> if (!stack.isEmpty()) stack.pop()
                else -> stack.push(token)
            }
        }
        while (!stack.isEmpty()) {
            sol = "/" + stack.pop() + sol
        }
        if (sol.isEmpty()) sol = "/"
        return sol
    }
}
