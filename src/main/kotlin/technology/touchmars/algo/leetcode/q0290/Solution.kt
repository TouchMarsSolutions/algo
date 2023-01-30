package technology.touchmars.algo.leetcode.q0290

class Solution {

    private fun numSpaces(s: String): Int = s.chars().filter { c -> c==' '.code }.count().toInt()

    // time: O(n), space: O(26)+O(26)=O(1)
    fun wordPattern(pattern: String, s: String): Boolean {
        // helper space: map and set
        val map = HashMap<String, String>()
        val set = HashSet<String>()
        if (numSpaces(s)+1 != pattern.length) return false
        var tailIndex = 0
        var spaceIndex = s.indexOf(" ")
        var idx = 0
        while (true) {
            val token = if (spaceIndex<0) s.substring(tailIndex) else s.substring(tailIndex, spaceIndex)
            // find by 2 ways and compare
            val existingMatch = map[token]
            val char = pattern[idx].toString()
            if (existingMatch==null) {
                map[token] = char
                if (set.contains(char)) return false
                set.add(char)
            } else if (existingMatch != char) return false
            // if this is the last token => exit
            if (spaceIndex<0) break
            // update index
            tailIndex = spaceIndex+1
            spaceIndex = s.indexOf(" ", tailIndex)
            idx++
        }
        return true
    }

}
