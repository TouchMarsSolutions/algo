package technology.touchmars.algo.leetcode.q0242

class Solution {

    private val pFreq = IntArray(26)

    private fun initP(p: String) {
        for(c in p.chars()) {
            pFreq[getPos(c)]++
        }
    }

    private fun getPos(c: Int): Int = c-'a'.code

    private fun isFreqMatched(pFreq: IntArray): Boolean = pFreq.none { f -> f != 0 }

    fun isAnagram(s: String, t: String): Boolean {
        initP(t)
        for (c in s.chars()) {
            val freq = pFreq[getPos(c)]--
            if (freq < 0) return false
        }
        return isFreqMatched(pFreq)
    }

}