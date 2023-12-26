package datastructure.linear.linkedlist

class SingleLinkedList<T> {
    var head: Node<T>? = null

    fun add(newNode: Node<T>) {
        if (head == null) {
            head = newNode
            return
        }

        var lastNode: Node<T> = head!!

        while (lastNode.pointer != null) {
            lastNode = lastNode.pointer!!
        }

        lastNode.pointer = newNode
    }
}
