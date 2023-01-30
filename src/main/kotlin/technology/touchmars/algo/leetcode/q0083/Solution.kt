package technology.touchmars.algo.leetcode.q0083

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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var cur = head
        while (cur!=null) {
            val curValue = cur.`val`
            val next = cur.next
            if (next!=null && next.`val`==curValue) {
                cur.next = next.next
                next.next = null
            } else {
                cur = next
            }
        }
        return head

    }
}