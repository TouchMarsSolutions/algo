package technology.touchmars.algo.leetcode.leco1214

class Solution {

    fun inOrder(root: TreeNode?, set: MutableSet<Int> = mutableSetOf()): Set<Int> {
        if (root==null) return set
        inOrder(root.left, set)
        set.add(root.`val`)
        inOrder(root.right, set)
        return set
    }
    fun inOrderCheck(root: TreeNode?, target: Int, set: Set<Int>): Boolean {
        return if (root==null) false
        else inOrderCheck(root.left, target, set) ||
                set.contains(target-root.`val`) ||
                inOrderCheck(root.right, target, set)
    }
    fun twoSumBSTs(root1: TreeNode?, root2: TreeNode?, target: Int): Boolean {
        val setLeft = inOrder(root1)
        return inOrderCheck(root2, target, setLeft)
    }

}