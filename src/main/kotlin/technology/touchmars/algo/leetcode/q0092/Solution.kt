package technology.touchmars.algo.leetcode.q0092

import technology.touchmars.algo.basic.ListNode

class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (head==null) return null
        if (head.next==null) return head
        // link size >= 2
        var prev: ListNode? = null
        var curr: ListNode = head
        var next: ListNode? = head.next
        var idx = 1
        // move to left
        while (idx<left && next!=null) {
            prev = curr
            curr = next
            next = next.next
            idx++
        }
        var leftNode = curr
        var leftNodeLeft = prev
        // move to right
        while (idx<right && next!=null) {
            prev = curr
            curr = next
            next = next.next
            curr.next = prev
            idx++
        }
        curr.next = prev
        var riteNode = curr
        // flip
        leftNode.next = next
        return if (leftNodeLeft!=null) {
            leftNodeLeft.next = riteNode
            head
        } else {
            riteNode
        }

    }

}