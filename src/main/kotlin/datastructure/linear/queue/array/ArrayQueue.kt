package datastructure.linear.queue.array

class ArrayQueue<T>(capacity: Int, val datas: Array<T> = arrayOfNulls<Any?>(capacity) as Array<T>) {

    override fun toString(): String {
        return datas.joinToString(separator = INFIX, prefix = PREFIX, postfix = POSTFIX)
    }

    companion object {
        private const val PREFIX = "["
        private const val POSTFIX = "]"
        private const val INFIX = ", "
    }
}
