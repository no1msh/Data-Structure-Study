package datastructure.linear.linkedlist.doub1e

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class DoubleLinkedListTest {
    @Test
    fun `더블 링크드 리스트는 첫번째 노드인 헤드와 마지막 노드인 테일이 있다`() {
        // given
        val doubleLinedList = DoubleLinkedList<Int>()
        val headNode = TwoWayNode(1)
        val tailNode = TwoWayNode(2)

        // when
        doubleLinedList.head = headNode
        doubleLinedList.tail = tailNode

        // then
        assertAll(
            { assertThat(doubleLinedList.head).isEqualTo(headNode) },
            { assertThat(doubleLinedList.tail).isEqualTo(tailNode) },
        )
    }
}
