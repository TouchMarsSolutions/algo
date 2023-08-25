package technology.touchmars.algo.leetcode.q0025
import technology.touchmars.algo.basic.ListNode
class Solution {
    /**
     * Reverse a link list between pre and next exclusively
     * an example:
     * a linked list:
     * 0->1->2->3->4->5->6
     * |           |
     * pre        next
     * after call pre = reverse(pre, next)
     *
     * 0->3->2->1->4->5->6
     *          |  |
     *          pre next
     * @param pre
     * @param next
     * @return the reversed list's last node, which is the precedence of parameter next
     */
    private fun reverse(pre: ListNode?, k: Int): Pair<ListNode?, Int> {
        val first = pre?.next // This node will become the last node after reversal
        var cur = first?.next
        var cnt = 1
        while (cnt < k && cur != null) {
            first?.next = cur.next
            cur.next = pre?.next
            pre?.next = cur
            cur = first?.next
            cnt++
        }
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

}
