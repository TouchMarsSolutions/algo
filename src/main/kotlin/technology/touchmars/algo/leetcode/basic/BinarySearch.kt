package technology.touchmars.algo.leetcode.basic

class BinarySearch {
    /**
     * search for taraget in a sorted array with given size n
     * pre: sorted array and non null
     * @param arr given Array
     * @param n given array size
     * @param target the target to search for
     */
    fun <T: Comparable<T>>binarySearch(arr: Array<T>, n: Int, target: T): Int? {
        if(n==0)
            return null
        var left = 0
        var right = n-1
        while (left<=right && left>=0 && right<=n-1) {
            val mid = left+(right-left)/2
            val compare = target.compareTo(arr[mid])
            if (compare==0)
                return mid
            else {
                if (compare<0){
                    right = mid-1
                }else {
                    left = mid+1
                }
            }
        }
        return null
    }
}