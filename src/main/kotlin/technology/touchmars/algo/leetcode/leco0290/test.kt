package technology.touchmars.algo.leetcode.leco0290

fun main() {
    println(Solution().wordPattern("abba","dog cat cat dog")) // true
    println(Solution().wordPattern("abba","dog cat cat fish")) // false
    println(Solution().wordPattern("aaaa","dog cat cat dog")) // false
    println(Solution().wordPattern("abba","dog dog dog dog")) // false
}