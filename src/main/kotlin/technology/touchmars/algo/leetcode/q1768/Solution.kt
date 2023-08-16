package technology.touchmars.algo.leetcode.q1768

class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        val sb = StringBuilder()
        var i = 0
        while (i < word1.length && i < word2.length) {
            sb.append(word1[i])
            sb.append(word2[i])
            i++
        }
        if (i < word1.length) {
            sb.append(word1.substring(i))
        }
        if (i < word2.length) {
            sb.append(word2.substring(i))
        }
        return sb.toString()
    }

}
