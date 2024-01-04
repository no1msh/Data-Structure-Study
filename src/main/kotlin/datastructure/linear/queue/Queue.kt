package datastructure.linear.queue

import java.util.LinkedList

class Queue<T>(private val datas: LinkedList<T> = LinkedList()) {

    override fun toString(): String {
        return datas.joinToString(separator = INFIX, prefix = PREFIX, postfix = POSTFIX)
    }

    companion object {
        private const val PREFIX = "<=[ "
        private const val POSTFIX = " ]=<"
        private const val INFIX = ", "
    }
}
