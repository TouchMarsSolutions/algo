package technology.touchmars.algo.leetcode.q0230
import technology.touchmars.algo.basic.TreeNode

class Solution {

    var cnt = 0
    var sol = 0

    fun kthSmallest(root: TreeNode?, k: Int): Int = inOrder(root, k).let { return sol }

    private fun inOrder(root: TreeNode?, k: Int) {
        root ?: return
        inOrder(root.left, k)
        if (++cnt == k) {
            sol = root.`val`
            return
        }
        inOrder(root.right, k)
    }

}
