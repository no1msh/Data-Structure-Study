package datastructure.linear.linkedlist

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SingleLinkedListTest {
    @Test
    fun `단일 연결 리스트는 헤드라는 제일 첫 번째 노드를 가진다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()
        val firstNode = Node(1, null)

        // when
        singleLinkedList.head = firstNode

        // then
        assertThat(singleLinkedList.head).isEqualTo(firstNode)
    }

    @Test
    fun `단일 연결 리스트에 노드를 추가할 때 헤드가 null이라면 헤드에 노드를 추가한다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()
        val newNode = Node(1, null)

        // when
        singleLinkedList.add(newNode)

        // then
        assertThat(singleLinkedList.head).isEqualTo(newNode)
    }

    @Test
    fun `노드를 추가할 때 헤드에 이미 값이 있으면 헤드가 가리키는 다음 자리에 노드를 추가한다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()
        val headNode = Node(1, null)
        val newNode = Node(2, null)
        singleLinkedList.add(headNode)

        // when
        singleLinkedList.add(newNode)

        // then
        assertThat(singleLinkedList.head!!.pointer).isEqualTo(newNode)
    }
}
