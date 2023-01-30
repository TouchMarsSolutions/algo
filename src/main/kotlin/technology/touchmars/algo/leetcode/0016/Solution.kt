package technology.touchmars.algo.leetcode.leco0016

class Solution {

    fun abs(a: Int, b: Int): Int = if (a>=b) a-b else b-a

    // pre-condition: 1 solution
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var sol = intArrayOf(0,1,2).map { nums[it] }.sumOf { it }
        for ((idx, num) in nums.withIndex()) {
            var tail = idx+1
            var head = nums.size-1
            while (tail < head) {
                val sum = num + nums[tail] + nums[head]
                if (abs(sum, target) < abs(sol, target)) sol=sum
                when {
                    sum==target -> return sol
                    sum < target -> tail++
                    else -> head--
                }
            }
        }
        return sol
    }

}