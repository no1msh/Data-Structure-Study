package datastructure.linear.queue.array

class ArrayQueue<T>(
    private val capacity: Int,
    private val datas: Array<T> = arrayOfNulls<Any?>(capacity) as Array<T>,
) {

    var size = datas.count { it != null }
        private set

    val isFull: Boolean
        get() = capacity == size

    val isEmpty: Boolean
        get() = size == 0

    var front: Int = datas.indexOfFirst { it != null }.coerceAtLeast(MINIMUM_INDEX)
        private set

    var rear: Int = datas.indexOfLast { it != null }.coerceIn(MINIMUM_INDEX..<capacity)
        private set

    override fun toString(): String {
        return datas.joinToString(separator = INFIX, prefix = PREFIX, postfix = POSTFIX)
    }

    companion object {
        private const val MINIMUM_INDEX = 0
        private const val PREFIX = "["
        private const val POSTFIX = "]"
        private const val INFIX = ", "
    }
}
