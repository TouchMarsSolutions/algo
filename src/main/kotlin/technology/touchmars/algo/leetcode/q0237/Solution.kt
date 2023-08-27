package technology.touchmars.algo.leetcode.q0237

import technology.touchmars.algo.basic.ListNode


/** leetcode 237
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * description:
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 */
class Solution {
    fun deleteNode(node: ListNode?) {
        val next = node?.next!!
        node.`val` = next.`val`
        node.next = next.next
    }

}
