package technology.touchmars.algo.leetcode.q0653

fun main() {
    val root = TreeNode(2)
    root.left = TreeNode(0)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(-4)
    root.left!!.right = TreeNode(1)
    print(Solution().findTarget(root, -1))
}