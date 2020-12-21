package technology.touchmars.algo.leetcode.leco0451

import java.util.stream.Collectors

class Solution {
    fun frequencySort(s: String): String {
        val map: MutableMap<Char, Int> = sortedMapOf<Char, Int>()
        for (idx in s.indices) {
            val char = s[idx]
            map[char] = if (map[char] == null) 1 else map[char]!! + 1
        }
        val sortedMap = map.toList().sortedByDescending { it.second }.toMap()
        var sol = ""
        sortedMap.keys.forEach { key -> sol+=key.toString().repeat(sortedMap[key]!!) }
        return sol
    }
}