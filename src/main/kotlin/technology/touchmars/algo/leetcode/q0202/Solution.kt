package technology.touchmars.algo.leetcode.q0202

class Solution {

    private fun sumSq(num: Int): Int {
        var sol = 0
        var d = num%10
        var n = num/10
        while (n!=0) {
            sol += d*d
            d = n%10
            n /= 10
        }
        sol+=d*d
        return sol
    }

    // idea: the continuity will either go into 1 or a circle
    fun isHappy(n: Int): Boolean {
        val set = HashSet<Int>()
        var sumSq = sumSq(n)
        while (sumSq!=1){
            if (set.contains(sumSq)) return false
            set.add(sumSq)
            sumSq = sumSq(sumSq)
        }
        return true
    }
}