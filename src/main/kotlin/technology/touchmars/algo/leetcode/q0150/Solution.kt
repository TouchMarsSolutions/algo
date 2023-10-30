package technology.touchmars.algo.leetcode.q0150

import java.util.*

class Solution {

    fun evalRPN(tokens: Array<String>): Int {
        val ops = setOf("+", "-", "*", "/")
        val stack = Stack<Int>()
        for (t in tokens) {
            // if t is number push to stack
            if (t !in ops) {
                stack.push(t.toInt())
            } else {
                val num2 = stack.pop()
                val num1 = stack.pop()
                when (t) {
                    "+" -> stack.push(num1 + num2)
                    "-" -> stack.push(num1 - num2)
                    "*" -> stack.push(num1 * num2)
                    "/" -> stack.push(num1 / num2)
                }
            }
        }
        return stack.pop()
    }

}
