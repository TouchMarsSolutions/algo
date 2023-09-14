package technology.touchmars.algo.leetcode.q0147

import technology.touchmars.algo.basic.ListNode

/** leetcode 147
 * https://leetcode.com/problems/insertion-sort-list/
 * description:
 * Sort a linked list using insertion sort.
 */
class Solution {

    fun insertionSortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val preHead = ListNode(-5000) // preHead.next is NULL, as the wall
        var cur = head
        while (cur!=null) {
            // find the position to insert from start, mark as prev
            var pre = preHead
            while (pre.next != null && cur > pre.next!!) {
                pre = pre.next!!
            }
            val next = cur.next
            cur.next = pre.next
            pre.next = cur
            cur = next
        }

        return preHead.next
    }

    private operator fun ListNode.compareTo(other: ListNode): Int {
        return this.`val` - other.`val`
    }

}
