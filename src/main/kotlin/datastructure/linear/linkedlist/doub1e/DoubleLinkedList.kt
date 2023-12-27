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

    override fun toString(): String {
        if (head == null) {
            return EMPTY_DATA_FORMAT
        }

        val stringBuilder = StringBuilder().append(PREFIX)

        var node = head
        while (node != null) {
            stringBuilder.append(node.data).append(INFIX)
            node = node.next
        }

        stringBuilder.setLength(stringBuilder.lastIndex - INFIX_SIZE)
        stringBuilder.append(POSTFIX)

        return stringBuilder.toString()
    }

    companion object {
        private const val EMPTY_DATA_FORMAT = "[]"
        private const val PREFIX = "[ "
        private const val POSTFIX = " ]"
        private const val INFIX = " <-> "
        private const val INFIX_SIZE = 4
    }
}
