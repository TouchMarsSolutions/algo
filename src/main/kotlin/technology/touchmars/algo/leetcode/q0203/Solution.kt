package technology.touchmars.algo.leetcode.q0203
import technology.touchmars.algo.basic.ListNode
class Solution {

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var preHead = ListNode(0)
        var prev: ListNode? = null
        var cur = head
        while (cur != null) {
            val v = cur.`val`
            if (v != `val`) {
                if (preHead.next == null) {
                    preHead.next = cur
                } else if (prev != null) {
                    prev.next = cur
                }
                prev = cur

            }
            cur = cur.next
        }
        prev?.next = null
        return preHead.next
    }

}
