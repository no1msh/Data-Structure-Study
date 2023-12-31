package datastructure.linear.linkedlist.single

class SingleLinkedList<T> {
    var head: OneWayNode<T>? = null

    fun add(newNode: OneWayNode<T>) {
        if (head == null) {
            head = newNode
            return
        }

        var lastNode: OneWayNode<T> = head!!

        while (lastNode.next != null) {
            lastNode = lastNode.next!!
        }

        lastNode.next = newNode
    }

    fun searchByData(targetData: T): OneWayNode<T>? {
        if (head == null) return null

        var node = head
        while (node!!.next != null) {
            if (node.data == targetData) {
                return node
            }
            node = node.next
        }
        return null
    }

    override fun toString(): String {
        if (head == null) return EMPTY_DATA_FORMAT

        val stringBuilder = StringBuilder()
        stringBuilder.append(PREFIX)
        var node = head

        while (node != null) {
            stringBuilder.append(node.data).append(INFIX)
            node = node.next
        }

        stringBuilder.setLength(stringBuilder.lastIndex - INFIX_SIZE)
        stringBuilder.append(POSTFIX)

        return stringBuilder.toString()
    }

    fun addNodeByValue(data: T, newNode: OneWayNode<T>) {
        if (head == null) return

        val searchedNode: OneWayNode<T>? = searchByData(data)

        if (searchedNode == null) {
            add(newNode)
            return
        }

        if (searchedNode.next == null) {
            searchedNode.next = newNode
            return
        }

        val tempNode = searchedNode.next
        searchedNode.next = newNode
        newNode.next = tempNode
    }

    fun remove(targetData: T) {
        if (head == null) return

        if (head!!.data == targetData) {
            head = head!!.next
            return
        }

        var node: OneWayNode<T>? = head ?: return

        while (node?.next != null) {
            if (node.next!!.data == targetData) {
                node.next = node.next!!.next
            }
            node = node.next
        }
    }

    companion object {
        private const val EMPTY_DATA_FORMAT = "[]"
        private const val PREFIX = "[ "
        private const val POSTFIX = " ]"
        private const val INFIX = " -> "
        private const val INFIX_SIZE = 3
    }
}
