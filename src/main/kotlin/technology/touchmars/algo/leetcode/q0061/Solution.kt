package technology.touchmars.algo.leetcode.q0061

import technology.touchmars.algo.basic.ListNode

class Solution {

    // leetcode question 61
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null || k == 0) return head
        var len = 1
        var tail = head
        while (tail?.next != null) {
            tail = tail.next
            len++
        }
        tail?.next = head
        var newTail = head
        for (i in 0 until len - k % len - 1) {
            newTail = newTail?.next
        }
        val newHead = newTail?.next
        newTail?.next = null
        return newHead

    }
}
