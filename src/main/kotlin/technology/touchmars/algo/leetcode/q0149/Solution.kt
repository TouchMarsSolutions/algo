package technology.touchmars.algo.leetcode.q0149

import java.math.BigInteger.valueOf

class Solution {

    companion object { const val duplicate_key = "0/0" }

    private fun slope(a: IntArray, b: IntArray): Pair<Int, Int> {
        var pair = Pair(a[0]-b[0], a[1]-b[1])
        return when {
            pair.first==0 && pair.second==0 -> Pair(0,0)
            pair.first==0 -> Pair(0, 1)
            pair.second==0 -> Pair(1,0)
            pair.second < 0 -> gcdDividedPair(Pair(-1*pair.first, -1*pair.second))
            else -> gcdDividedPair(pair)
        }
    }

    private fun gcdDividedPair(pair: Pair<Int, Int>): Pair<Int, Int> {
        if (pair.first==-1 || pair.first==1 || pair.second==1) return pair
        val gcd = valueOf(pair.first.toLong()).gcd(valueOf(pair.second.toLong())).toInt()
        return Pair(pair.first/gcd, pair.second/gcd)
    }

    fun maxPoints(points: Array<IntArray>): Int {
        if (points.size<2) return points.size
        var sol = 0
        for (p in points.indices) {
            val map = mutableMapOf<String, Int>()
            for (q in points.indices) {
                if (p==q) continue
                val slope = slope(points[p], points[q])
                val slopeKey = "${slope.first}/${slope.second}"
                map[slopeKey] = 1 + map.getOrDefault(slopeKey, 0)
            }
            var maxKey = ""
            var maxValue = 0
            map.forEach {
                if (it.value > maxValue) {
                    maxKey = it.key
                    maxValue = it.value
            } }
            if (!maxKey.contentEquals(duplicate_key))
                maxValue += map.getOrDefault(duplicate_key, 0)
            if (maxValue>sol) sol=maxValue
        }
        return sol+1
    }

}