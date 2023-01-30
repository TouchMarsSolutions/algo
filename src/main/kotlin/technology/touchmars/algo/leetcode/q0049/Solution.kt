package technology.touchmars.algo.leetcode.q0049

class Solution {

    private fun convertInt2String(i: Int) = if (i<10) "0$i" else i
    private fun convertString2Hash(str: String): String {
        val spectrum = IntArray(26)
        str.chars().forEach { spectrum[it-'a'.code]++ }
        var hashKey = ""
        spectrum.forEach { i -> hashKey+=convertInt2String(i) }
        return hashKey
    }

    /**
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     * @param strs consists of lower-case English letters.
     */
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val sol = mutableListOf<List<String>>()
        val map = hashMapOf<Int, Map<String, List<String>>>()
        for(str in strs) {
            val len = str.length
            if (!map.containsKey(len)) map[len] = mutableMapOf()
            val hashMap = map[len]!! as MutableMap
            var hashKey = convertString2Hash(str)
            if (!hashMap.containsKey(hashKey)) hashMap[hashKey] = mutableListOf()
            val list = hashMap[hashKey]!! as MutableList
            list.add(str)
        }
        map.values.forEach { hashMap -> hashMap.values.forEach { sol.add(it) } }
        return sol
    }

}