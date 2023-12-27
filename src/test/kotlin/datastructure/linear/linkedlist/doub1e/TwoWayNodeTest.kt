package datastructure.linear.linkedlist.doub1e

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class TwoWayNodeTest {
    @Test
    fun `양방향 노드는 데이터를 제네릭 타입으로 가질 수 있다`() {
        // given
        val intData = 1
        val stringData = "first"

        // when
        val intNode: TwoWayNode<Int> = TwoWayNode(intData, null, null)
        val stringNode: TwoWayNode<String> = TwoWayNode(stringData, null, null)

        // then

        assertAll(
            { assertThat(intNode.data).isEqualTo(intData) },
            { assertThat(stringNode.data).isEqualTo(stringData) },
        )
    }

    @Test
    fun `양방향 노드는 이전 노드와 다음 노드를 가리킬 수 있다`() {
        // given
        val prevNode = TwoWayNode(1, null, null)
        val nextNode = TwoWayNode(3, null, null)

        // when
        val node = TwoWayNode(2, prevNode, nextNode)
        prevNode.next = node
        nextNode.next = node

        // then
        assertAll(
            { assertThat(node.prev).isEqualTo(prevNode) },
            { assertThat(node.next).isEqualTo(nextNode) },
        )
    }

    @Test
    fun `양방향 노드는 노드를 가리키지 않을 수 있다`() {
        // given

        // when
        val node = TwoWayNode(1, null, null)

        // then
        assertAll(
            { assertThat(node.prev).isNull() },
            { assertThat(node.next).isNull() },
        )
    }
}
