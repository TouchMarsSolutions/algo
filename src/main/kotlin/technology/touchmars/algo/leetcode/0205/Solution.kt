package technology.touchmars.algo.leetcode.leco0205

class Solution {

    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length!=t.length) return false
        val mapS = HashMap<Int, Int>() // map chars from s to t
        val setT = HashSet<Int>() // save occurrence of t
        for (idx in s.indices) {
            val charS = s[idx].code
            val charT = t[idx].code
            val match = mapS[charS]
            if (match == null) {
                if (setT.contains(charT)) return false
                else setT.add(charT)
                mapS[charS] = charT
            } else if (match!=charT) return false
        }
        return true
    }

}