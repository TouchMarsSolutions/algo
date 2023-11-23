package technology.touchmars.algo.leetcode.q0093

import kotlin.math.min

class Solution {

    fun restoreIpAddresses(s: String): List<String> {
        val sol = mutableListOf<String>()
        if (s.length <4 || s.length > 12) return sol
        restore(s, "", 0, sol).apply { return sol }
    }

    private fun restore(res: String, cur: String, cnt: Int, sol: MutableList<String>) {
        if (cnt==4 && res.isEmpty()) sol.add(cur).let { return }
        if (cnt==4 || res.isEmpty()) return
        for (i in 1..min(if(res.startsWith("0")) 1 else 3, res.length)) {
            res.substring(0, i).toInt().takeIf { it in 0..255 }?.let {
                restore(res.substring(i), "$cur${if (cnt != 0) "." else ""}$it", cnt+1, sol)
            }
        }
    }

}
