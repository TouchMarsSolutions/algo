package technology.touchmars.algo.leetcode.leco0015

class Solution {

    fun initMap(nums: IntArray): Map<Int, MutableList<Int>> {
        return nums.mapIndexed { index, i -> i to index }.groupByTo(sortedMapOf(), {it.first}, {it.second}) // as Map<Int, MutableList<Int>>
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return listOf()
        val sol = mutableListOf<List<Int>>()
        val map = initMap(nums)
        val keys = map.keys.toIntArray()
        val min = keys.first()
        val max = keys.last()
        // all positive
        if (min > 0 && max > 0) return sol
        // all negative
        if (min < 0 && max < 0) return sol
        // has zero
        var has0 = false
        if (map[0]!=null) {
            has0 = true
            if (map[0]!!.size >= 3) sol.add(listOf(0, 0, 0))
        }
        for ((idx, numA) in keys.withIndex()) {
            if (numA >= 0) break
            // -A, -A, +2A
            if (map[numA]!!.size>=2 && map[-2*numA]!=null) sol.add(listOf(numA, numA, -2*numA))
            // -A, 0, A
            if (has0 && map[-numA]!=null) sol.add(listOf(numA, 0, -numA))
            // -A(even), +A/2, +A/2
            if (numA%2==0 && map[-numA/2]!=null && map[-numA/2]!!.size >=2) sol.add(listOf(numA, -numA/2, -numA/2))
            // -A < -B|+B, +C
            var idxB = idx + 1
            var numB = keys[idxB]
            var numC = 0-numA-numB
            while(numB <= 0-numA/2 && numB < numC && numB < max) {
                if (numB!=0 && numC <= max && map[numC] != null) sol.add(listOf(numA, numB, numC))
                numB = keys[++idxB]
                numC = 0-numA-numB
            }
        }
        return if (sol.isEmpty())  listOf() else sol
    }

}