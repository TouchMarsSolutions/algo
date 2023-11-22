package technology.touchmars.algo.leetcode.q0450
import technology.touchmars.algo.basic.TreeNode

class Solution {

    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        root ?: return null
        val rv = root.`val`
        val left = root.left
        val rite = root.right
        when {
            key < rv -> root.left = deleteNode(left, key)
            key > rv -> root.right = deleteNode(rite, key)
            else -> {
                when {
                    isLeaf(root) -> return null
                    left == null -> return rite
                    rite == null -> return left
                    else -> {
                        val min = findMin(rite)
                        root.`val` = min.`val`
                        root.right = deleteNode(rite, min.`val`)
                    }
                }
            }
        }
        return root
    }

    private fun findMin(node: TreeNode): TreeNode {
        var cur = node
        while (cur.left!=null) {
            cur = cur.left!!
        }
        return cur
    }

    private fun isLeaf(node: TreeNode?) = node!=null && node.left==null && node.right==null

}
