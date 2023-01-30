package technology.touchmars.algo.leetcode.leco0438

/**
 * [438. Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and
 * the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 */
class Solution {
    var numUniqueCharsOfP = 0
    var numUniqueCharsOfS = 0
    // pos[0] => 'a', pos[25] => 'z'
    val pCount = IntArray(26)
    val sCount = IntArray(26)

    private fun getPos(charAsciiValue: Int): Int = charAsciiValue - 'a'.code
    private fun getPos(char: Char): Int = char.code - 'a'.code

    private fun initP(p: String) {
        p.chars().forEach { c->
            val pos = getPos(c)
            val cnt = ++pCount[pos]
            if (cnt == 1) numUniqueCharsOfP++
        }
    }

    private fun initS(s: String, len: Int) {
        for (idx in 0 until len) {
            val pos = getPos(s[idx])
            val cnt = ++sCount[pos]
            if (cnt == 1) numUniqueCharsOfS++
        }
    }

    private fun inc(sCount: IntArray, pos: Int) {
        sCount[pos]++
        if (sCount[pos]==1) numUniqueCharsOfS++
    }

    private fun dec(sCount: IntArray, pos: Int) {
        sCount[pos]--
        if (sCount[pos]==0) numUniqueCharsOfS--
    }

    private fun compare(idx: Int, sol: MutableList<Int>) {
        if (numUniqueCharsOfP == numUniqueCharsOfS && sCount.contentEquals(pCount))
            sol.add(idx)
    }

    fun findAnagrams(s: String, p: String): List<Int> {
        if (s.length < p.length)
            return listOf()
        val sol = mutableListOf<Int>()
        initP(p)
        // idx = 0
        initS(s, p.length)
        compare(0, sol)
        // move forward
        for (idx in 1 .. s.length-p.length) {
            val tail = idx - 1
            val head = idx+p.length-1
            inc(sCount, getPos(s.get(head)))
            dec(sCount, getPos(s.get(tail)))
            compare(idx, sol)
        }
        return sol;
    }

}

