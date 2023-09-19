package technology.touchmars.algo.leetcode.q0143

import technology.touchmars.algo.basic.ListNode

class Solution {

    fun reorderList(head: ListNode?): Unit {
        if (head?.next == null) return
        val length = length(head)
        val steps = length / 2
        val middle = walk(head, steps)
        val tail = reverse(middle)
        var left = head
        var rite = tail
        while (left!= middle && rite != middle) {
            val leftNext = left?.next
            val riteNext = rite?.next
            left?.next = rite
            rite?.next = leftNext
            left = leftNext
            rite = riteNext
        }
    }

    private fun length(head: ListNode?): Int {
        var len = 0
        var node = head
        while (node != null) {
            len++
            node = node.next
        }
        return len
    }

    private fun walk(head: ListNode, steps: Int): ListNode {
        var node = head
        for (i in 0 until steps) {
            node = node.next!!
        }
        return node
    }

    private fun reverse(middle: ListNode): ListNode? {
        var prev: ListNode? = null
        var curr: ListNode? = middle
        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        return prev
    }

}
