package technology.touchmars.algo.leetcode.leco1281

/**
    Given an integer number n, return the difference between the product of its digits and the sum of its digits.

    Example 1:

    Input: n = 234
    Output: 15
    Explanation:
    Product of digits = 2 * 3 * 4 = 24
    Sum of digits = 2 + 3 + 4 = 9
    Result = 24 - 9 = 15
    Example 2:

    Input: n = 4421
    Output: 21
    Explanation:
    Product of digits = 4 * 4 * 2 * 1 = 32
    Sum of digits = 4 + 4 + 2 + 1 = 11
    Result = 32 - 11 = 21

    Constraints: `1 <= n <= 10^5`

    [_LeetCode1281_](https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/)
 */
class Solution {
    fun subtractProductAndSum(n: Int): Int {
        var sum = 0
        var product = 1
        var n1 = n
        for (i in 1..5) {
            val digit = n1%10
            sum += digit
            product *= digit
            n1 /= 10
            if (n1==0)
                break
        }
        return product - sum
    }
}