package technology.touchmars.algo.leetcode.basic

fun main() {
    val bs = BinarySearch()
    println(bs.binarySearch(arrayOf(1,2,3,4,5,6), 6, 1))
    println(bs.binarySearch(arrayOf(1,2,3,4,5,6), 6, 3))
    println(bs.binarySearch(arrayOf(1,2,3,4,5,6), 6, 4))
    println(bs.binarySearch(arrayOf(1,2,3,4,5,6), 6, 6))
    println(bs.binarySearch(arrayOf(1,2,3,4,5,6), 6, 0))
    println(bs.binarySearch(arrayOf(1,2,3,4,5,6), 6, 7))
    println(bs.binarySearch(arrayOf(1,2), 2, 1))
    println(bs.binarySearch(arrayOf(1,2), 2, 2))
    println(bs.binarySearch(arrayOf(1,2), 2, 0))
    println(bs.binarySearch(arrayOf(1,2), 2, 3))
}