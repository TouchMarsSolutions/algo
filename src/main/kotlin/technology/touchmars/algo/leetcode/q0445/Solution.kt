package technology.touchmars.algo.leetcode.q0445

import technology.touchmars.algo.basic.ListNode

class Solution {
    private fun reverse(l: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr = l
        while (curr!=null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        return prev
    }

    // copy from 0002
    private fun addTwoNumbers0(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1==null) return l2
        if (l2==null) return l1
        val list = ListNode(0)

        var p = list
        var p1 = l1
        var p2 = l2
        var promo = 0
        while (true) {
            val sum = (p1?.`val`?:0) + (p2?.`val`?:0) + promo
            p.`val` = sum % 10
            promo = sum / 10
            p1 = p1?.next
            p2 = p2?.next
            if (p1==null && p2==null) {
                if (promo>0) p.next = ListNode(promo)
                break
            }
            p.next = ListNode(0)
            p = p.next!!
        }
        return list
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val r1 = reverse(l1)
        val r2 = reverse(l2)
        val sol = addTwoNumbers0(r1, r2)
        return reverse(sol)

    }
}
