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

    @Test
    fun `더블 링크드 리스트에 값을 추가할 때 헤드가 null이라면 헤드와 테일에 노드를 추가한다`() {
        // given
        val doubleLinkedList = DoubleLinkedList<Int>()
        val newData = 1

        // when
        doubleLinkedList.add(newData)

        // then
        assertAll(
            { assertThat(doubleLinkedList.head!!.data).isEqualTo(newData) },
            { assertThat(doubleLinkedList.tail!!.data).isEqualTo(newData) },
        )
    }

    @Test
    fun `더블 링크드 리스트에 값을 추가할 때 헤드와 테일이 이미 있다면 기존 테일에 값을 연결하여 추가한다`() {
        // given
        val doubleLinkedList = DoubleLinkedList<Int>()
        val headNode = TwoWayNode(1)
        val tailNode = TwoWayNode(2)
        doubleLinkedList.head = headNode
        doubleLinkedList.tail = tailNode

        val newData = 3

        // when
        doubleLinkedList.add(newData)

        // then
        assertThat(doubleLinkedList.tail!!.data).isEqualTo(newData)
    }

    @Test
    fun `더블 링크드 리스트가 가진 모든 데이터를 문자열로 표현할 수 있다`() {
        // given
        val doubleLinkedList = DoubleLinkedList<Int>()
        doubleLinkedList.add(1)
        doubleLinkedList.add(2)
        doubleLinkedList.add(3)

        // when
        val expect = doubleLinkedList.toString()

        // then
        assertThat(expect).isEqualTo("[ 1 <-> 2 <-> 3 ]")
    }

    @Test
    fun `더블 링크드 리스트가 가진 데이터가 없다면 빈 모양을 문자열로 반환한다`() {
        // given
        val doubleLinkedList = DoubleLinkedList<Int>()

        // when
        val expect = doubleLinkedList.toString()

        // then
        assertThat(expect).isEqualTo("[]")
    }

    @Test
    fun `더블 링크드 리스트가 가진 노드가 하나여도 표시형식에 맞추어 출력된다`() {
        // given
        val doubleLinkedList = DoubleLinkedList<Int>()
        doubleLinkedList.add(1)

        // when
        val expect = doubleLinkedList.toString()

        // then
        assertThat(expect).isEqualTo("[ 1 ]")
    }
}
