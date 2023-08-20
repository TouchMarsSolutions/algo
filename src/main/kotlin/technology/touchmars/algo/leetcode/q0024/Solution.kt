package technology.touchmars.algo.leetcode.q0024
import technology.touchmars.algo.basic.ListNode

class Solution {

    fun swapPairs(head: ListNode?): ListNode? {
        val preHead = ListNode(-1)
        preHead.next = if (head?.next == null) head else head.next
        var prev = ListNode(-1)
        var cur1 = head
        var cur2 = head?.next
        while (cur1 !=null && cur2 != null) {
            var next = cur2.next
            prev.next = cur2
            cur2.next = cur1
            cur1.next = next
            prev = cur1
            cur1 = next
            cur2 = next?.next
        }
        return preHead.next
    }

}
