package technology.touchmars.algo.leetcode.q0235
import technology.touchmars.algo.basic.TreeNode

class Solution {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if(root==null || p==null || q==null) return null
        val rv = root.`val`
        val pv = p.`val`
        val qv = q.`val`
        return if (pv<rv && qv<rv) lowestCommonAncestor(root.left, p, q)
        else if (pv>rv && qv>rv) lowestCommonAncestor(root.right, p, q)
        else root
    }

}
