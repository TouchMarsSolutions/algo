package technology.touchmars.algo.leetcode.q0259

fun main() {
    println(Solution().combinatorics(3,2)) // 3
    println(Solution().combinatorics(4,2)) // 6
    println(Solution().combinatorics(5,2)) // 10
    println(Solution().combinatorics(5,3)) // 10
    println(Solution().combinatorics(10,2)) // 45
    println(Solution().combinatorics(10,3)) // 120

    println(Solution().threeSumSmaller(intArrayOf(-2,0,1,3), 2))
    println(Solution().threeSumSmaller(intArrayOf(1,1,-2), 1)) // 1
    println(Solution().threeSumSmaller(intArrayOf(3,2,-2,6,2,-2,6,-2,-4,2,3,0,4,4,1), 3))
    println(Solution().threeSumSmaller(intArrayOf(1,-1,3,-1,-4,-1,0,-3,-1,-5,-4,-4,2,1), 3)) // 343
    println(Solution().threeSumSmaller(intArrayOf(2,-5,-2,1,4,-1,-4,-5,-5,-5,2,1,-2,1,-3,0), -5)) // 215
    println(Solution().threeSumSmaller(intArrayOf(-4,-2,1,-2,0,3,-2,1,3,0,-4,-5,0,-4,0,-2,3), -5)) // 173
    println(Solution().threeSumSmaller(intArrayOf(3,-3,2,-3,-3,2,3,4,-3,-3,-5,3), 2))


}