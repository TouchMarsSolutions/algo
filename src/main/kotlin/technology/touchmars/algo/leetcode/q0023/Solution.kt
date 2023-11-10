package technology.touchmars.algo.leetcode.q0023

import technology.touchmars.algo.basic.ListNode
import java.util.*

class Solution {

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val comparator = compareBy<ListNode>{ it.`val` }
        val heap = PriorityQueue(comparator)
        lists.filterNotNull().flatMap { generateSequence(it) { node -> node.next } }.forEach(heap::add)
        val preHead = ListNode(-10000)
        var cur = preHead
        while (heap.isNotEmpty()) {
            val p = heap.poll()
            cur.next = p
            cur = p
            cur.next = null
        }
        return preHead.next
    }

}
