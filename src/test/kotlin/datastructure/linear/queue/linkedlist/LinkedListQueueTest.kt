package datastructure.linear.queue.linkedlist

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LinkedListQueueTest {
    @Test
    fun `LinkedListQueue는 가진 노드가 없을 때 없다는 표시를 할 수 있다`() {
        // given
        val linkedListQueue = LinkedListQueue<Int>()

        // when
        val actual = linkedListQueue.toString()

        // then
        assertThat(actual).isEqualTo("[]")
    }

    @Test
    fun `LinkedListQueue는 가진 노드가 하나일 때 노드 하나만 있는 것으로 표시된다`() {
        // given
        val linkedListQueue = LinkedListQueue<Int>()

        // when
        linkedListQueue.enqueue(1)
        val actual = linkedListQueue.toString()

        // then
        assertThat(actual).isEqualTo("[ 1 ]")
    }

    @Test
    fun `LinkedListQueue는 가진 노드가 여러개일 때 화살표를 통해 연결리스트를 표현한다`() {
        // given
        val linkedListQueue = LinkedListQueue<Int>()

        // when
        linkedListQueue.enqueue(1)
        linkedListQueue.enqueue(2)
        val actual = linkedListQueue.toString()

        // then
        assertThat(actual).isEqualTo("[ 1 -> 2 ]")
    }
}
