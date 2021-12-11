package technology.touchmars.algo.leco0686

class Solution {
    fun repeatedStringMatch(a: String, b: String): Int {
        if (a.isEmpty() || b.isEmpty()) return -1
        if (a == b) return 1
        var firstMatch = a.indices.firstOrNull { a[it] == b[0] } ?: return -1
        var indexA = firstMatch
        var indexB = 0
        var result = 1
        while (indexB<b.length) {
            if (a[indexA]!=b[indexB]) {
                indexB=0
                result=1
                firstMatch = a.indices.firstOrNull { it > firstMatch && a[it]==b[0] } ?: return -1
                indexA = firstMatch
            } else {
                indexB++
                indexA = (indexA+1) % a.length
                if (indexA==0 && indexB<b.length) {
                    result++
                }
            }
        }
        return result
    }
}