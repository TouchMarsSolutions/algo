package technology.touchmars.algo.leetcode.q0002

import technology.touchmars.algo.basic.ListNode

/**
 * [2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)
 *
 * ### Constraints:
 * - The number of nodes in each linked list is in the range `[1, 100]`
 * - `0 <= Node.val <= 9`
 * - It is guaranteed that the list represents a number that does not have leading zeros.
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1==null) return l2
        if (l2==null) return l1
        val list = ListNode(0)

        var p = list
        var p1 = l1
        var p2 = l2
        var promo = 0
        while (true) {
            val sum = (p1?.`val`?:0) + (p2?.`val`?:0) + promo
            p.`val` = sum % 10
            promo = sum / 10
            p1 = p1?.next
            p2 = p2?.next
            if (p1==null && p2==null) {
                if (promo>0) p.next = ListNode(promo)
                break
            }
            p.next = ListNode(0)
            p = p.next!!
        }
        return list
    }

}
