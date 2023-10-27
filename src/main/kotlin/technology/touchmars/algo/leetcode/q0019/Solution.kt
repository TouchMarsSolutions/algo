package technology.touchmars.algo.leetcode.q0019

import technology.touchmars.algo.basic.ListNode

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var first = head
        var second = head
        repeat(n) { first = first?.next }
        if (first == null) {
            return head?.next
        }
        while (first?.next != null) {
            first = first?.next
            second = second?.next
        }
        second?.next = second?.next?.next
        return head

    }
}
