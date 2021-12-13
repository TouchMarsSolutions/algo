package technology.touchmars.algo.basic

fun printListNode(head: ListNode?) {
    if (head==null) println("NULL")
    var curr = head
    while (curr!=null) {
        print("${curr.`val`} -> ")
        curr = curr.next
    }
    println("NULL")
}