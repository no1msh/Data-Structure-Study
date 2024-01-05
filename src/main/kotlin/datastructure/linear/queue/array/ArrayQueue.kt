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
        return datas.filterNotNull().joinToString(separator = INFIX, prefix = PREFIX, postfix = POSTFIX)
    }

    fun enqueue(newData: T) {
        if (isFull) throw IndexOutOfBoundsException("Queue가 수용할 수 있는 크기를 넘어서 enqueue를 할 수 없습니다.")

        datas[rear] = newData
        rear = (rear - 1).coerceAtLeast(MINIMUM_INDEX)
        size++
    }

    companion object {
        private const val MINIMUM_INDEX = 0
        private const val PREFIX = "["
        private const val POSTFIX = "]"
        private const val INFIX = ", "
    }
}
