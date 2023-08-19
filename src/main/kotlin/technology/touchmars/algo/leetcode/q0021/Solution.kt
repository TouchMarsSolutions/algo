package technology.touchmars.algo.leetcode.q0021
import technology.touchmars.algo.basic.ListNode
class Solution {

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1==null) return list2
        if (list2==null) return list1
        var preHead = ListNode(-1)
        var cur: ListNode? = null
        var cur1 = list1
        var cur2 = list2
        while (cur1!=null && cur2!=null) {
            val min = min(cur1, cur2)
            // deal with cur
            if (preHead.next==null) {
                preHead.next = min
            } else if (cur!=null) {
                cur.next = min
            }
            cur = min
            // deal with next
            if (min==cur1) {
                cur1 = cur1.next
            } else {
                cur2 = cur2.next
            }
        }

        if (cur1==null) {
            cur?.next = cur2
        } else if (cur2==null){
            cur?.next = cur1
        }
        return preHead.next
    }

    fun min(a: ListNode, b: ListNode): ListNode {
        return if (a.`val` <= b.`val`) a else b
    }

}
