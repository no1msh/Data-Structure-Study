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

    @Test
    fun `단일 연결 리스트가 가진 모든 데이터를 문자열로 표현할 수 있다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()
        val node1 = Node(1, null)
        val node2 = Node(2, null)
        val node3 = Node(3, null)
        singleLinkedList.add(node1)
        singleLinkedList.add(node2)
        singleLinkedList.add(node3)

        // when
        val expect = singleLinkedList.toString()

        // then
        assertThat(expect).isEqualTo("[ 1 -> 2 -> 3 ]")
    }

    @Test
    fun `단일 연결 리스트가 가진 데이터가 하나여도 표시 형식을 맞추어 String으로 변환된다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()
        val node1 = Node(1, null)
        singleLinkedList.add(node1)

        // when
        val expect = singleLinkedList.toString()

        // then
        assertThat(expect).isEqualTo("[ 1 ]")
    }
}
