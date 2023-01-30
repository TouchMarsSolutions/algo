package technology.touchmars.algo.leetcode.leco0082

import technology.touchmars.algo.basic.ListNode

class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var result: ListNode? = null // valid head
        var prev: ListNode? = null // prev valid
        var curr = head
        var cnt = 1
        var v: Int? = curr.`val`
        while(curr!=null) {
            if (v==curr.next?.`val`) {
                curr = curr.next
                cnt++
            } else { // at end of section
                if (cnt > 1) {
                    if (curr.next==null) { // if end of world
                        if (prev!=null) prev.next = null
                        return result
                    }
                } else {
                    if (result==null) result = curr
                    if (prev!=null) prev.next = curr
                    prev = curr
                }
                curr = curr.next
                cnt = 1
                v = curr?.`val`
            }
        }
        return result
    }
}