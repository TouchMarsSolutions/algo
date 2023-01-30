package technology.touchmars.algo.leetcode.q0349;

/**
 * [349. Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/)
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * ### Note:
 * + Each element in the result must be unique.
 * + The result can be in any order.
 *
 * #### Example 1:
 * - Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * - Output: [2]
 *
 * #### Example 2:
 * - Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * - Output: [9,4]
 *
 */
class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val set1 = nums1.toSet()
        val set2 = nums2.toSet()
        val set = set1.intersect(set2)
        return set.toIntArray()
    }
}
