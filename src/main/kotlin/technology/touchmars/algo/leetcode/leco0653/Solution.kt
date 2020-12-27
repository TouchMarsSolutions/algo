package technology.touchmars.algo.leetcode.leco0653

class Solution {

    fun inOrder(root: TreeNode?, list: MutableList<Int> = mutableListOf()): List<Int> {
        if (root == null) return list
        inOrder(root.left, list)
        list.add(root.`val`)
        inOrder(root.right, list)
        return list
    }

    fun findTarget(root: TreeNode?, k: Int): Boolean {
        val list = inOrder(root)
        if (list.size < 2) return false
        var tail = 0
        var head = list.lastIndex
        while (tail < head) {
            val sum = list[tail] + list[head]
            when {
                sum == k -> return true
                sum < k -> tail++
                else -> head--
            }
        }
        return false
    }

}