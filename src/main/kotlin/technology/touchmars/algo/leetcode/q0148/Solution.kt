package technology.touchmars.algo.leetcode.q0148

import technology.touchmars.algo.basic.ListNode

class Solution {

    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        val len = length(head)
        val dummy = ListNode(0)
        dummy.next = head
        var n = 1
        while (n < len) {
            var cur = dummy.next // partial sorted head
            var tail: ListNode? = dummy
            var l: ListNode?
            var r: ListNode?
            while (cur != null) {
                l = cur
                r = split(l, n)
                cur = split(r, n)
                val merged = merge(l, r)
                tail?.next = merged.first
                tail = merged.second
            }
            n = n shl 1
        }
        return dummy.next
    }

    private fun length(head: ListNode?): Int {
        var len = 0
        var headVar = head
        while (headVar != null) {
            len++
            headVar = headVar.next
        }
        return len
    }

    private fun split(head: ListNode?, n: Int): ListNode? {
        var headVar = head
        var nVar = n
        while (nVar > 1 && headVar != null) {
            headVar = headVar.next
            nVar--
        }
        val rest = headVar?.next
        if (headVar != null) headVar.next = null
        return rest
    }

    private fun merge(l1: ListNode?, l2: ListNode?): Pair<ListNode?, ListNode?> {
        val dummy = ListNode(0)
        var tail: ListNode? = dummy
        var l1Var = l1
        var l2Var = l2
        while (l1Var != null && l2Var != null) {
            if (l1Var.`val` > l2Var.`val`) {
                val temp = l1Var
                l1Var = l2Var
                l2Var = temp
            }
            tail?.next = l1Var
            l1Var = l1Var.next
            tail = tail?.next
        }
        tail?.next = l1Var ?: l2Var
        while (tail?.next != null) tail = tail.next
        return Pair(dummy.next, tail)
    }

}
