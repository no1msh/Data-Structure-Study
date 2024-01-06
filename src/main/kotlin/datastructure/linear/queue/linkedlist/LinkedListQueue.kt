package datastructure.linear.queue.linkedlist

import datastructure.linear.linkedlist.single.OneWayNode
import datastructure.linear.linkedlist.single.SingleLinkedList

class LinkedListQueue<T>(private val datas: SingleLinkedList<T> = SingleLinkedList()) {
    val front: OneWayNode<T>? get() = datas.head
    var rear: OneWayNode<T>? = null

    override fun toString(): String {
        return datas.toString()
    }

    fun enqueue(newData: T) {
        val newNode = OneWayNode(newData)
        datas.add(newNode)
        rear = newNode
    }

    fun dequeue(): T {
        val result = front!!.data
        datas.remove(result)

        return result
    }
}
