package technology.touchmars.algo.leetcode.leco0076

/**
 * [76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring)
 *
 * Given two strings s and t, return the minimum window in s which will contain all the characters in t.
 * If there is no such window in s that covers all characters in t, return the empty string "".
 *
 * Note that If there is such a window, it is guaranteed that there will always be only one
 * unique minimum window in s.
 *
     ### Constraints:
     + 1 <= s.length, t.length <= 100,000;
     + s and t consist of English letters.
 */
class Solution {

    enum class NextMove { HEAD, TAIL }

    private val pCount = IntArray(26*2)
    private val sCount = IntArray(26*2)
    private var numUniqueCharsOfP = 0
    private var numMatchedCharsOfS = 0

    private fun getPos(charAsciiValue: Int): Int =
        if (charAsciiValue < 'a'.toInt()) {
            charAsciiValue - 'A'.toInt()
        } else {
            charAsciiValue - 'a'.toInt() + 26
        }

    private fun getPos(char: Char): Int = getPos(char.toInt())

    private fun initP(p: String) {
        p.chars().forEach { c->
            val pos = getPos(c)
            val cnt = ++pCount[pos]
            if (cnt == 1) numUniqueCharsOfP++
        }
    }

    private fun findNextCharIndex(s: String, from: Int): Int {
        for (idx in from until s.length) {
            if (isValid(s[idx])) return idx
        }
        return -1
    }

    private fun isValid(c: Int) = pCount[getPos(c)] > 0
    private fun isValid(c: Char) = isValid(c.toInt())

    private fun inc(sCount: IntArray, pos: Int) {
        sCount[pos]++
        if (sCount[pos]==1) numMatchedCharsOfS++
    }

    private fun dec(sCount: IntArray, pos: Int) {
        sCount[pos]--
        if (sCount[pos]==0) numMatchedCharsOfS--
    }

    // pre-condition: window is valid
    private fun updateSol(head: Int, tail: Int, s: String, sol: String): String {
        if (sol.isEmpty() || head-tail+1<sol.length) {
            return s.substring(IntRange(tail, head))
        }
        return sol
    }

    private fun isWindowValid(): Boolean {
        if (numMatchedCharsOfS < numUniqueCharsOfP)
            return false
        for (idx in 0 until 52) {
            if (sCount[idx] < pCount[idx])
                return false
        }
        return true
    }

    fun minWindow(s: String, p: String): String {
        // pre-condition::length
        if (s.length < p.length) return ""
        // init p hash table
        initP(p)
        // init s starting point
        val initIndex = findNextCharIndex(s, 0)
        if (initIndex < 0) return ""
        inc(sCount, getPos(s[initIndex]))
        if (p.length==1 && s[initIndex]==p[0]) return p
        // init local var
        var sol = ""
        var tail = initIndex
        var head = initIndex
        var nextMove = NextMove.HEAD
        // loop starts
        while (head < s.length && tail <= head) {
            if (nextMove == NextMove.HEAD) {
                val next = findNextCharIndex(s, head+1)
                if (next < 0) {
                    if (!isWindowValid()) return sol
                    nextMove = NextMove.TAIL
                    continue
                }
                head = next
                inc(sCount, getPos(s[head]))
                if (isWindowValid()) {
                    sol = updateSol(head, tail, s, sol)
                    nextMove = NextMove.TAIL
                }
            } else if (nextMove == NextMove.TAIL) {
                val next = findNextCharIndex(s, tail+1)
                if (next < 0) break // no way to move forward then leave
                dec(sCount, getPos(s[tail]))
                tail = next
                if (isWindowValid()) {
                    sol = updateSol(head, tail, s, sol)
                } else {
                    nextMove = NextMove.HEAD
                }
                if (tail == head) nextMove = NextMove.HEAD
            }
        }
        // final check on window
        if (isWindowValid())
            sol = updateSol(head, tail, s, sol)
        return sol
    }

}