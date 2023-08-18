package technology.touchmars.algo.leetcode.q0015

class Solution3 {

    // map array to Map<item, indexes>
    fun initMap(nums: IntArray): Map<Int, MutableList<Int>> {
        return nums.mapIndexed { index, i -> i to index }.groupByTo(sortedMapOf(), {it.first}, {it.second})
        // as Map<Int, MutableList<Int>>
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        val target = 0
        if (nums.size < 3) return listOf()
        val sol = mutableListOf<List<Int>>()
        val map = initMap(nums)
        val keys = map.keys.toIntArray()
        val min = keys.first()
        val max = keys.last()
        // all positive
        if (min > target && max > target) return sol
        // all negative
        if (min < target && max < target) return sol
        // has zero
        var has0 = false
        if (map[0]!=null) {
            has0 = true
            if (map[0]!!.size >= 3) sol.add(listOf(0, 0, 0))
        }
        for ((idx, numA) in keys.withIndex()) {
            if (numA >= target) break
            // -A, -A, +2A
            if (map[numA]!!.size>=2 && map[-2*numA]!=null) sol.add(listOf(numA, numA, -2*numA))
            // -A, 0, A
            if (has0 && map[-numA]!=null) sol.add(listOf(numA, 0, -numA))
            // -A(even), +A/2, +A/2
            if (numA%2==0 && map[-numA/2]!=null && map[-numA/2]!!.size >=2) sol.add(listOf(numA, -numA/2, -numA/2))
            // -A < -B|+B, +C
            var idxB = idx + 1
            var numB = keys[idxB]
            var numC = target-numA-numB
            while(numB <= target-numA/2 && numB < numC && numB < max) {
                if (numB!=0 && numC <= max && map[numC] != null) sol.add(listOf(numA, numB, numC))
                numB = keys[++idxB]
                numC = target-numA-numB
            }
        }
        return if (sol.isEmpty())  listOf() else sol
    }

}