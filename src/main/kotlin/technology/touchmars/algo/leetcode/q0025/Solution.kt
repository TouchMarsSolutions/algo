package technology.touchmars.algo.leetcode.q0025
import technology.touchmars.algo.basic.ListNode
class Solution {
    /**
     * a linked list:
     * 0->1->2->3->4->5->6
     * |           |
     * pre        next
     * after call pre = reverse(pre, next)
     *
     * 0->3->2->1->4->5->6
     *          |  |
     *          pre next
     * @param preHead the previous node of the first node to be reversed
     * @param k up to the number of nodes to be reversed
     * @return the reversed list's last node, which is the precedence of parameter next, and the number of nodes reversed
     */
    private fun reverse(preHead: ListNode?, k: Int): Pair<ListNode?, Int> {
        val first = preHead?.next
        var cur = first?.next
        var prev = first
        var cnt = 1
        while (cnt < k && cur != null) {
            val next = cur.next
            cur.next = prev
            prev = cur
            cur = next
            cnt++
        }
        preHead?.next = prev
        first?.next = cur
        return Pair(first, cnt)
    }

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null || k == 1) return head
        val dummy = ListNode(0)
        dummy.next = head
        var pre: ListNode? = dummy
        while (true) {
            val reversed = reverse(pre, k)
            val cnt = reversed.second
            if (cnt < k) { // If there are fewer than k nodes left, revert the reversal
                reverse(pre, cnt) // Revert the changes
                break
            } else {
                pre = reversed.first
            }
        }
        return dummy.next
    }

    private fun reverse2(preHead: ListNode?, k: Int): Pair<ListNode?, Int> {
        val first = preHead?.next
        var cur = first?.next
        var cnt = 1
        while (cnt < k && cur != null) {
            val next = cur.next
            first?.next = next
            cur.next = preHead?.next
            preHead?.next = cur
            cur = first?.next
            cnt++
        }
        return Pair(first, cnt)
    }

}
