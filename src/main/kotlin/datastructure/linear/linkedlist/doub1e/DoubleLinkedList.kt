package datastructure.linear.linkedlist.doub1e

class DoubleLinkedList<T> {
    var head: TwoWayNode<T>? = null
    var tail: TwoWayNode<T>? = null

    fun add(data: T) {
        if (head == null) {
            val newNode = TwoWayNode(data)
            head = newNode
            tail = newNode
            return
        }

        var node = head
        while (node!!.next != null) {
            node = node.next
        }

        val newNode = TwoWayNode(data)
        newNode.prev = node
        node.next = newNode
        tail = newNode
    }
}
