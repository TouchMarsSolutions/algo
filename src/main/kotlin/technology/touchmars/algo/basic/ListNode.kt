package technology.touchmars.algo.basic

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    // override toString
    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(`val`)
        var cur = next
        while (cur != null) {
            sb.append("->").append(cur.`val`)
            cur = cur.next
        }
        return sb.toString()
    }
}