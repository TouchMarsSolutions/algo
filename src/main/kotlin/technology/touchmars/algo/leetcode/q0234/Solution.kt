package technology.touchmars.algo.leetcode.q0234

import technology.touchmars.algo.basic.ListNode

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) return true
        val firstHalfEnd = endOfFirstHalf(head)
        val secondHalfStart = reverse(firstHalfEnd?.next!!)
        var p1 = head
        var p2 = secondHalfStart
        var result = true
        while (result && p2 != null) {
            if (p1?.`val` != p2.`val`) result = false
            p1 = p1?.next
            p2 = p2?.next
        }
        firstHalfEnd.next = reverse(secondHalfStart)
        return result
    }

    private fun reverse(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr: ListNode? = head
        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        return prev
    }

    private fun endOfFirstHalf(head: ListNode?): ListNode? {
        var fast = head
        var slow = head
        while (fast?.next != null && fast.next?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
        }
        return slow
    }
}
