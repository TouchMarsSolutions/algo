package technology.touchmars.algo.leetcode.q0098
import technology.touchmars.algo.basic.TreeNode

class Solution {

    var prev: TreeNode? = null
    fun isValidBST(root: TreeNode?): Boolean {
        root ?: return true
        if (!isValidBST(root.left)) return false
        if (prev!=null && root.`val`<= prev!!.`val`) return false
        prev = root
        return isValidBST(root.right)
    }

}
