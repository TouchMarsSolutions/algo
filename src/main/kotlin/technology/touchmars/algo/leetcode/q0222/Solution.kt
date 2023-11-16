package technology.touchmars.algo.leetcode.q0222

import technology.touchmars.algo.basic.TreeNode

class Solution {

    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0
        val d = computeDepth(root)
        if (d == 0) return 1
        var left = 1
        var right = (1 shl d) - 1
        var pivot: Int
        while (left <= right) {
            pivot = left + (right - left) / 2
            if (exists(pivot, d, root)) left = pivot + 1
            else right = pivot - 1
        }
        return (1 shl d) - 1 + left
    }

    private fun computeDepth(node: TreeNode?): Int {
        var d = 0
        var cur = node
        while(cur?.left!=null) {
            cur = cur.left
            d++
        }
        return d
    }

    private fun exists(idx: Int, d: Int, node: TreeNode?): Boolean {
        var left = 0
        var right = (1 shl d) - 1
        var pivot: Int
        var cur = node
        for (i in 0 until d) {
            pivot = left + (right - left) / 2
            if (idx <= pivot) {
                cur = cur?.left
                right = pivot
            } else {
                cur = cur?.right
                left = pivot + 1
            }
        }
        return cur != null
    }

}
