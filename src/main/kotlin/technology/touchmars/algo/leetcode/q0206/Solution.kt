package technology.touchmars.algo.leetcode.q0206

import technology.touchmars.algo.basic.ListNode

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
    fun reverseList(head: ListNode?): ListNode? {
        if (head==null) return null
        var prev: ListNode? = null
        var curr: ListNode = head
        var next: ListNode? = head.next
        while (next!=null) {
            curr.next = prev
            // shift dance
            prev = curr
            curr = next
            next = next.next
        }
        curr.next = prev
        return curr

    }
}