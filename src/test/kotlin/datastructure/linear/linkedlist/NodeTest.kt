package datastructure.linear.linkedlist

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NodeTest {
    @Test
    fun `노드는 데이터를 제네릭 타입으로 저장할 수 있다`() {
        // given
        val intData = 1
        val stringData = "first"

        // when
        val intNode = Node(intData, null)
        val stringNode = Node(stringData, null)

        // then
        assertThat(intNode.data).isEqualTo(intData)
        assertThat(stringNode.data).isEqualTo(stringData)
    }

    @Test
    fun `노드는 다음 노드 위치를 저장할 수 있다`() {
        // given
        val headNode = Node(1, null)
        val nextNode = Node(2, null)

        // when
        headNode.pointer = nextNode

        // then
        assertThat(headNode.pointer).isEqualTo(nextNode)
    }

    @Test
    fun `노드의 다음 위치는 null이 될 수 있다`() {
        // given
        val node = Node(1, null)

        // when

        // then
        assertThat(node.pointer).isNull()
    }
}
