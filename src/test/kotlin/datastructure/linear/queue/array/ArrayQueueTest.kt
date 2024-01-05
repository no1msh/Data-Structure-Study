package datastructure.linear.queue.array

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

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
            { assertThat(expectFull).isEqualTo(true) },
            { assertThat(expectNotFull).isEqualTo(false) },
        )
    }
}
