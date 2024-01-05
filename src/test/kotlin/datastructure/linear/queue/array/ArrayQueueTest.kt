package datastructure.linear.queue.array

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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
}
