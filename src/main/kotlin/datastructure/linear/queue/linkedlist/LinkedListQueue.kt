package datastructure.linear.queue.linkedlist

import datastructure.linear.linkedlist.single.OneWayNode
import datastructure.linear.linkedlist.single.SinglyLinkedList

class LinkedListQueue<T>(private val datas: SinglyLinkedList<T> = SinglyLinkedList()) {
    val front: OneWayNode<T>? get() = datas.head
    var rear: OneWayNode<T>? = null

    override fun toString(): String {
        return datas.toString()
    }

    fun enqueue(newData: T) {

        datas.add(newData)
        rear = datas.tail
    }

    fun dequeue(): T {
        val result = front!!.data
        datas.remove(result)

        return result
    }
}
