package datastructure.linear.queue

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.LinkedList

class QueueTest {
    @Test
    fun `큐는 가진 데이터를 표시형식에 맞추어 문자열로 반환할 수 있다`() {
        // given
        val datas = LinkedList<Int>().apply {
            add(1)
            add(2)
            add(3)
        }

        // when
        val queue: Queue<Int> = Queue(datas)

        // then
        assertThat(queue.toString()).isEqualTo("<=[ 1, 2, 3 ]=<")
    }

    @Test
    fun `큐는 enqueue로 데이터를 추가할 수 있다`() {
        // given
        val queue = Queue<Int>()

        // when
        queue.enqueue(1)

        // then
        assertThat(queue.toString()).isEqualTo("<=[ 1 ]=<")
    }
}
