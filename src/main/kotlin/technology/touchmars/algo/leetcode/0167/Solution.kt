package technology.touchmars.algo.leetcode.leco0167

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        if(numbers.size<2) return intArrayOf()
        var tail=0
        var head=numbers.size-1
        while (tail < head) {
            val sum = numbers[tail] + numbers[head]
            when {
                sum==target -> return intArrayOf(tail+1, head+1)
                sum<target -> tail++
                else -> head--
            }
        }
        return intArrayOf()
    }
}