package technology.touchmars.algo.leetcode.q0170

class TwoSum {
    /** Initialize your data structure here. */
    private val map = sortedMapOf<Int, Int>()

    /** Add the number to an internal data structure.. */
    fun add(number: Int) {
        map[number] = 1 + map.getOrDefault(number, 0)
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    fun find(value: Int): Boolean {
        return map.keys.filter { key ->
            val comp = value - key
            if (comp!=key) map.containsKey(comp) else map[key]!! > 1
        }.any()
    }
}