package technology.touchmars.algo.leetcode.q0100

import technology.touchmars.algo.basic.TreeNode

class Solution {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return (p == null && q == null) ||
                (p?.`val` == q?.`val` && isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right))
    }

}
