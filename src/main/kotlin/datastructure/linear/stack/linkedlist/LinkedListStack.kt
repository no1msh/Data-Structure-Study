package datastructure.linear.stack.linkedlist

import datastructure.linear.linkedlist.single.SinglyLinkedList

class LinkedListStack<T> {
    private val linkedList = SinglyLinkedList<T>()

    val size get() = linkedList.size
    val isEmpty get() = linkedList.isEmpty

    fun push(data: T) {
        linkedList.add(data)
    }

    fun peek(): T {
        return linkedList.tail?.data ?: throw NoSuchElementException(NOT_EXISTED_DATA)
    }

    fun peekOrNull(): T? {
        return linkedList.tail?.data
    }

    fun pop(): T {
        val data: T = linkedList.tail?.data ?: throw NoSuchElementException(NOT_EXISTED_DATA)
        linkedList.removeLast()
        return data
    }

    fun popOrNull(): T? {
        val data: T? = linkedList.tail?.data
        linkedList.removeLast()
        return data
    }

    companion object {
        private const val NOT_EXISTED_DATA = "추출할 데이터가 존재하지 않습니다."
    }
}
