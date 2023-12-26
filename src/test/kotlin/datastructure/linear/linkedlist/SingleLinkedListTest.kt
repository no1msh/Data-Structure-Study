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

}
