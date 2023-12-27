package datastructure.linear.linkedlist.single

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OneWayNodeTest {
    @Test
    fun `노드는 데이터를 제네릭 타입으로 저장할 수 있다`() {
        // given
        val intData = 1
        val stringData = "first"

        // when
        val intNode = OneWayNode(intData, null)
        val stringNode = OneWayNode(stringData, null)

        // then
        assertThat(intNode.data).isEqualTo(intData)
        assertThat(stringNode.data).isEqualTo(stringData)
    }

    @Test
    fun `노드는 다음 노드 위치를 저장할 수 있다`() {
        // given
        val headNode = OneWayNode(1, null)
        val nextNode = OneWayNode(2, null)

        // when
        headNode.next = nextNode

        // then
        assertThat(headNode.next).isEqualTo(nextNode)
    }

    @Test
    fun `노드의 다음 위치는 null이 될 수 있다`() {
        // given
        val node = OneWayNode(1, null)

        // when

        // then
        assertThat(node.next).isNull()
    }
}
