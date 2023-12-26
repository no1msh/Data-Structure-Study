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

    fun searchByData(targetData: T): Node<T>? {
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
            stringBuilder.append(node.data).append(SEPARATOR)
            node = node.pointer
        }

        stringBuilder.setLength(stringBuilder.lastIndex - LAST_SEPARATOR_SIZE)
        stringBuilder.append(INFIX)

        return stringBuilder.toString()
    }

    companion object {
        private const val PREFIX = "[ "
        private const val INFIX = " ]"
        private const val SEPARATOR = " -> "
        private const val LAST_SEPARATOR_SIZE = 3
    }
}
