package technology.touchmars.algo.leco0018

class Solution {

    private fun convert(v: String): MutableList<Int?> =
        v.split(";").map { token -> token.toIntOrNull() }.toCollection(mutableListOf())

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val sol = mutableListOf<List<Int>>()
        val size = nums.size
        if (size<4) return sol
        val set = hashSetOf<Int>()
        nums.forEach { set.add(it) }
        // map{value->1st index}
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, it -> if (!map.containsKey(it)) map[it]=index }
        // since N <= 200, N^2 <= 40000 => build a SUM map is okay!
        val sumMap = mutableMapOf<Int, MutableSet<String>>()
        for (a in 0 until size-1) {
            for (b in a+1 until nums.size) {
                val sum = nums[a] + nums[b]
                if (!sumMap.containsKey(sum)) sumMap[sum] = hashSetOf()
                sumMap[sum]!!.add("${nums[a]};${nums[b]}")
            }
        }
        // go into sumMap
        for (key in sumMap.keys) {

            val comp = target - key
            val cdSet = sumMap[comp] ?: continue
            for (v in cdSet) {
                val cd = convert(v)
                val c = map[cd[0]!!]!!
                val d = map[cd[1]!!]!!
                val abSet = sumMap[key]
                for (u in abSet!!) {
                    val ab = convert(u)
                    val a = map[ab[0]!!]!!
                    val b = map[ab[1]!!]!!
                    // b vs c
                    if (b > c) continue
                    else if (b < c) sol.add(listOf(nums[a], nums[b], nums[c], nums[d]))
                    else { // b==c
                        val cntBC = 2 + intArrayOf(a, d).filter { it==b }.size
                        if (b+cntBC-1<size && nums[b+cntBC-1]==nums[b]) sol.add(listOf(nums[a], nums[b], nums[c], nums[d]))
                    }

                }

            }
        }
        return sol
    }

}