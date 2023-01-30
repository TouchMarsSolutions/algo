package technology.touchmars.algo.leetcode.leco0447

class Solution {

    private fun distance(i: IntArray, j: IntArray): Int = distance(i[0], i[1], j[0], j[1])
    private fun distance(x: Int, y: Int, a: Int, b: Int): Int = (x-a)*(x-a)+(y-b)*(y-b)

    fun numberOfBoomerangs(points: Array<IntArray>): Int {
        var sol = 0
        for (p in points.indices) {
            // map for distance -> count of points
            val map = hashMapOf<Int, Int>()
            for (q in points.indices) {
                if (p!=q) {
                    val dis = distance(points[p], points[q])
                    map[dis] = 1 + map.getOrDefault(dis, 0)
                }
            }
            // iterate distance map for p
            map.values.forEach { sol+=it*(it-1) }
        }
        return sol
    }

}