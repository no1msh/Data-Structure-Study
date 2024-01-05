package datastructure.linear.queue.array

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class ArrayQueueTest {
    @Test
    fun `ArrayQueue는 배열에 데이터를 저장한다`() {
        // given

        // when
        val arrayQueue = ArrayQueue(5, arrayOf(1, 2, 3))

        // then
        assertThat(arrayQueue.toString()).isEqualTo("[1, 2, 3]")
    }

    @Test
    fun `ArrayQueue는 자신이 가진 원소의 개수를 반환할 수 있다`() {
        // given
        val arrayQueue = ArrayQueue(5, arrayOf(1, 2, 3))

        // when
        val expect = arrayQueue.size

        // then
        assertThat(expect).isEqualTo(3)
    }

    @Test
    fun `ArrayQueue는  자신이 가진 원소개수를 반환할 떄 가진게 없다면 0을 반환한다`() {
        // given
        val arrayQueue = ArrayQueue<Int>(5)

        // when
        val expect = arrayQueue.size

        // then
        assertThat(0).isEqualTo(expect)
    }

    @Test
    fun `ArrayQueue는 큐가 가득 차있는지에 따라 Boolean값을 반환 받을 수 있다`() {
        // given
        val fullQueue = ArrayQueue(5, arrayOf(1, 2, 3, 4, 5))
        val notFullQueue = ArrayQueue(5, arrayOf(1, 2, 3))

        // when
        val expectFull: Boolean = fullQueue.isFull
        val expectNotFull: Boolean = notFullQueue.isFull

        // then
        assertAll(
            { assertThat(expectFull).isTrue },
            { assertThat(expectNotFull).isFalse },
        )
    }

    @Test
    fun `ArrayQueue는 dequeue를 했을 때 가장 먼저 반환되는 값의 인덱스를 front라고 한다`() {
        // given
        val arrayQueue = ArrayQueue<Int>(5)

        // when
        val expectFront = arrayQueue.front

        // then
        assertThat(expectFront).isEqualTo(0)
    }

    // TODO(dequeue 중 이동하는 front 검증 필요)

    @Test
    fun `ArrayQueue는 enqueue를 했을 때 값이 들어갈 인덱스를 rear라고 한다`() {
        // given
        val arrayQueue = ArrayQueue<Int>(5)

        // when
        val expectRear = arrayQueue.rear

        // then
        assertThat(expectRear).isEqualTo(0)
    }

    // TODO(dequeue 중 이동하는 rear 검증 필요)

    @Test
    fun `ArrayQueue는 가진 데이터가 없는지를 Boolean 값으로 반환받을 수 있다`() {
        // given
        val arrayQueue = ArrayQueue<Int>(5)

        // when
        val expect = arrayQueue.isEmpty

        // then
        assertThat(expect).isTrue
    }

    @Test
    fun `만일 데이터가 있다면 isEmpty는 false를 반환한다`() {
        // given
        val arrayQueue = ArrayQueue(5, arrayOf(1))

        // when
        val expect = arrayQueue.isEmpty

        // then
        assertThat(expect).isFalse
    }

    @Test
    fun `ArrayQueue는 enqueue를 통해 데이터를 추가할 수 있다`() {
        // given
        val arrayQueue = ArrayQueue<Int>(5)

        // when
        arrayQueue.enqueue(1)

        // then
        assertThat(arrayQueue.toString()).isEqualTo("[1]")
    }

    @Test
    fun `ArrayQueue는 수용할 수 있는 데이터들을 모두 수용했다면 enqueue를 할 시 예외처리한다`() {
        // given
        val arrayQueue = ArrayQueue<Int>(5).apply {
            enqueue(1)
            enqueue(2)
            enqueue(3)
            enqueue(4)
            enqueue(5)
        }

        // when
        val error = assertThrows<IndexOutOfBoundsException> { arrayQueue.enqueue(6) }

        // then
        assertThat(error.message).isEqualTo("Queue가 수용할 수 있는 크기를 넘어서 enqueue를 할 수 없습니다.")
    }
}
