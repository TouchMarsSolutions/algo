package technology.touchmars.algo.leetcode.q0341

import java.util.*

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     constructor()
 *
 *     // Constructor initializes a single integer.
 *     constructor(value: Int)
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     fun isInteger(): Boolean
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     fun getInteger(): Int?
 *
 *     // Set this NestedInteger to hold a single integer.
 *     fun setInteger(value: Int): Unit
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     fun add(ni: NestedInteger): Unit
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     fun getList(): List<NestedInteger>?
 * }
 */
class NestedInteger {
    constructor()

    constructor(value: Int)

    fun isInteger(): Boolean = false

    fun getInteger(): Int? = null

    fun setInteger(value: Int) {}

    fun add(ni: NestedInteger) {}

    fun getList(): List<NestedInteger>? = null
}

class NestedIterator(nestedList: List<NestedInteger>) {

    private val stack = Stack<NestedInteger>()

    init {
        for (ni in nestedList.reversed()) {
            stack.push(ni)
        }
    }

    fun next(): Int {
        return stack.pop().getInteger()!!
    }

    fun hasNext(): Boolean {
        if (stack.isEmpty()) return false
        while (stack.isNotEmpty()) {
            var p = stack.peek()
            if (p.isInteger()) return true
            else {
                p = stack.pop()
                val list = p.getList()
                if (!list.isNullOrEmpty()) {
                    for (ni in list.reversed()) {
                        stack.push(ni)
                    }
                }

            }
        }
        return false
    }
}