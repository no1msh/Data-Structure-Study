package datastructure.linear.linkedlist

class SingleLinkedList<T> {
    var head: OneWayNode<T>? = null

    fun add(newNode: OneWayNode<T>) {
        if (head == null) {
            head = newNode
            return
        }

        var lastNode: OneWayNode<T> = head!!

        while (lastNode.pointer != null) {
            lastNode = lastNode.pointer!!
        }

        lastNode.pointer = newNode
    }

    fun searchByData(targetData: T): OneWayNode<T>? {
        if (head == null) return null

        var node = head
        while (node!!.pointer != null) {
            if (node.data == targetData) {
                return node
            }
            node = node.pointer
        }
        return null
    }

    override fun toString(): String {
        if (head == null) return ""

        val stringBuilder = StringBuilder()
        stringBuilder.append(PREFIX)
        var node = head

        while (node != null) {
            stringBuilder.append(node.data).append(INFIX)
            node = node.pointer
        }

        stringBuilder.setLength(stringBuilder.lastIndex - LAST_SEPARATOR_SIZE)
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

        if (searchedNode.pointer == null) {
            searchedNode.pointer = newNode
            return
        }

        val tempNode = searchedNode.pointer
        searchedNode.pointer = newNode
        newNode.pointer = tempNode
    }

    fun remove(targetData: T) {
        if (head == null) return

        if (head!!.data == targetData) {
            head = head!!.pointer
            return
        }

        var node: OneWayNode<T>? = head ?: return

        while (node?.pointer != null) {
            if (node.pointer!!.data == targetData) {
                node.pointer = node.pointer!!.pointer
            }
            node = node.pointer
        }
    }

    companion object {
        private const val PREFIX = "[ "
        private const val POSTFIX = " ]"
        private const val INFIX = " -> "
        private const val LAST_SEPARATOR_SIZE = 3
    }
}
