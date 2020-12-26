package technology.touchmars.algo.leetcode.leco0653

class Solution {

    fun inOrder(root: TreeNode?, list: MutableList<Int> = mutableListOf()) {
        if (root == null) return
        inOrder(root.left, list)
        list.add(root.`val`)
        inOrder(root.right, list)
    }

    fun findTarget(root: TreeNode?, k: Int): Boolean {
        if (root==null) return false
        if (root.left == null && root.right == null) return false
        val rootVal = root.`val`
        var leftTree = root
        var rightTree = root
        when {
            k-rootVal > rootVal -> {
                rightTree = root.right
            }
            k-rootVal < rootVal -> {
                leftTree = root.left
            }
            else -> {
                leftTree = root.left
                rightTree = root.right
            }
        }
        while (leftTree!=null && rightTree!=null) {
            val sum = leftTree.`val` + rightTree.`val`
            if (sum == k) return true
            else if (sum < k) { // go to right
                if (leftTree.right!=rightTree) {
                    leftTree = leftTree.right
                } else if(leftTree.right == rightTree && rightTree.left!=null) {
                    leftTree = rightTree.left
                } else if (rightTree.right!=null) {
                    rightTree = rightTree.right
                } else {
                    return false
                }
            } else { // sum > k => go to left
                if (rightTree.left != null && rightTree.left != leftTree) {
                    rightTree = rightTree.left
                } else if (rightTree.left == leftTree && leftTree.right!=null) {
                    rightTree = leftTree.right
                } else if (leftTree.left!=null) {
                    leftTree = leftTree.left
                } else {
                    return false
                }
            }
        }
        return leftTree!=null && rightTree!=null && leftTree.`val`+rightTree.`val`==k
    }

}