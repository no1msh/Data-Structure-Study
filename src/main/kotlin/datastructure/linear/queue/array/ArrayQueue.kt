package datastructure.linear.queue.array

class ArrayQueue<T>(
    private val capacity: Int,
    private val datas: Array<T> = arrayOfNulls<Any?>(capacity) as Array<T>,
) {

    var size = datas.size
        private set

    val isFull: Boolean
        get() = capacity == size

    override fun toString(): String {
        return datas.joinToString(separator = INFIX, prefix = PREFIX, postfix = POSTFIX)
    }

    companion object {
        private const val PREFIX = "["
        private const val POSTFIX = "]"
        private const val INFIX = ", "
    }
}
