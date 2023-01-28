package technology.touchmars.algo.leetcode.leco0328

import  technology.touchmars.algo.basic.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }
        val oddHead = head
        var oddTail = oddHead
        val evenHead = head.next!!
        var next = head
        var index = 1
        while (next!!.next != null) {
            val curr = next
            next = next.next
            curr.next = next!!.next
            if (index % 2 == 1) {
                oddTail = curr.next ?: curr
            }
            index ++
        }
        oddTail!!.next = evenHead
        return oddHead
    }
}