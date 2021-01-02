package technology.touchmars.algo.leetcode.leco1640

class Solution {
    fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
        val map = mutableMapOf<Int, Int>()
        for ((idx,list) in pieces.withIndex()) {
            if (list==null || list.isEmpty()) continue
            map[list[0]] = idx
        }
        var idx = 0
        while (idx < arr.size) {
            val v = arr[idx]
            if (!map.containsKey(v)) return false
            val list = pieces[map.remove(v)!!]
            for (a in list) {
                if (idx<arr.size && arr[idx]==a) idx++
                else return false
            }
        }
        return idx==arr.size && map.isEmpty()
    }
}