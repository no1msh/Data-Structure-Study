package datastructure.linear.queue.array

@Suppress("UNCHECKED_CAST")
class ArrayQueue<T>(private val capacity: Int) {
    private val datas: Array<T?> = arrayOfNulls<Any?>(capacity) as Array<T?>

    var size = datas.count { it != null }
        private set

    val isFull: Boolean
        get() = capacity == size

    val isEmpty: Boolean
        get() = size == 0

    var front: Int = datas.indexOfFirst { it != null }.coerceInIndexes()
        private set(value) {
            field = value.coerceInIndexes()
        }

    var rear: Int = datas.indexOfLast { it != null }.coerceInIndexes()
        private set(value) {
            field = value.coerceInIndexes()
        }

    override fun toString(): String {
        return datas.filterNotNull().joinToString(separator = INFIX, prefix = PREFIX, postfix = POSTFIX)
    }

    fun enqueue(newData: T) {
        if (isFull) throw IndexOutOfBoundsException("Queue가 수용할 수 있는 크기를 넘어서 enqueue를 할 수 없습니다.")

        datas[rear] = newData
        rear++
        size++
    }

    fun dequeue(): T {
        if (isEmpty) throw NoSuchElementException("Queue에 데이터가 존재하지 않습니다.")

        val result: T = datas[front] ?: throw NullPointerException("front가 null을 참조하고 있습니다.")
        front++
        rear--
        size--
        return result
    }

    private fun Int.coerceInIndexes(): Int = this.coerceIn(MINIMUM_INDEX..<capacity)

    companion object {
        private const val MINIMUM_INDEX = 0
        private const val PREFIX = "["
        private const val POSTFIX = "]"
        private const val INFIX = ", "
    }
}
