package technology.touchmars.algo.leetcode.leco0086

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
    fun partition(head: ListNode?, x: Int): ListNode? {
        if (head==null || head.next==null) return head
        var newHead: ListNode = head
        var leftEnd: ListNode? = null
        var prev: ListNode? = null
        var curr: ListNode? = head
        while (curr!=null) {
            val next: ListNode? = curr.next
            val v = curr.`val`
            if (v < x) {
                if (prev==null) {
                    prev = curr
                } else if (prev.`val` >= x) {
                    prev.next = curr.next
                }
                if (leftEnd!=null) {
                    if (leftEnd.next!=curr) {
                        curr.next = leftEnd.next
                        leftEnd.next = curr                        
                    }
                } else {
                    if (curr!=newHead) {
                        curr.next = newHead
                        newHead = curr                    
                    }                    
                }
                leftEnd = curr
                
            } else {
                prev = curr
            }
            curr = next
            
        }        
        return newHead
    }
}