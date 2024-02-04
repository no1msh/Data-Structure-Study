package datastructure.linear.linkedlist.single

class SinglyLinkedList<T> {
    var head: OneWayNode<T>? = null
        private set
    var tail: OneWayNode<T>? = null
        private set

    fun add(newData: T) {
        if (head == null) {
            head = OneWayNode(newData)
            tail = head
            return
        }

        val newNode = OneWayNode(newData)
        tail!!.next = newNode
        tail = newNode
    }

    fun add(existedData: T, newData: T) {
        if (head == null) return

        val searchedNode: OneWayNode<T>? = searchNodeByData(existedData)

        if (searchedNode == null) {
            add(newData)
            return
        }

        val newNode = OneWayNode(newData)

        if (searchedNode.next == null) {
            searchedNode.next = newNode
            return
        }

        val tempNode = searchedNode.next
        searchedNode.next = newNode
        newNode.next = tempNode
    }

    private fun searchNodeByData(targetData: T): OneWayNode<T>? {
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

    fun removeFirst() {
        if (head == null) return

        val nextNode = head!!.next
        head = nextNode
    }

    fun removeLast() {
        if (tail == null) return

        var tempNode = head
        while (tempNode!!.next != tail) {
            tempNode = tempNode.next
        }

        tail = tempNode
        tail!!.next = null
    }

    companion object {
        private const val EMPTY_DATA_FORMAT = "[]"
        private const val PREFIX = "[ "
        private const val POSTFIX = " ]"
        private const val INFIX = " -> "
        private const val INFIX_SIZE = 3
    }
}
