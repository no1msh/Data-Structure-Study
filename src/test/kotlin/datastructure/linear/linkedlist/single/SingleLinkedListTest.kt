package datastructure.linear.linkedlist.single

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class SingleLinkedListTest {
    @Test
    fun `단일 연결 리스트는 헤드라는 제일 첫 번째 노드를 가진다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()
        val firstNode = OneWayNode(1, null)

        // when
        singleLinkedList.head = firstNode

        // then
        assertThat(singleLinkedList.head).isEqualTo(firstNode)
    }

    @Test
    fun `단일 연결 리스트에 노드를 추가할 때 헤드가 null이라면 헤드에 노드를 추가한다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()
        val newNode = OneWayNode(1, null)

        // when
        singleLinkedList.add(newNode)

        // then
        assertThat(singleLinkedList.head).isEqualTo(newNode)
    }

    @Test
    fun `노드를 추가할 때 헤드에 이미 값이 있으면 제일 마지막 노드의 포인터에 노드를 추가한다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()
        val headNode = OneWayNode(1, null)
        val newNode = OneWayNode(2, null)
        singleLinkedList.add(headNode)

        // when
        singleLinkedList.add(newNode)

        // then
        assertThat(singleLinkedList.head!!.next).isEqualTo(newNode)
    }

    @Test
    fun `단일 연결 리스트가 가진 모든 데이터를 문자열로 표현할 수 있다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()
        val node1 = OneWayNode(1, null)
        val node2 = OneWayNode(2, null)
        val node3 = OneWayNode(3, null)
        singleLinkedList.add(node1)
        singleLinkedList.add(node2)
        singleLinkedList.add(node3)

        // when
        val expect = singleLinkedList.toString()

        // then
        assertThat(expect).isEqualTo("[ 1 -> 2 -> 3 ]")
    }

    @Test
    fun `단일 연결 리스트가 가진 데이터가 없어도 표시 형식을 맞추어 String으로 변환된다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()

        // when
        val expect = singleLinkedList.toString()

        // then
        assertThat(expect).isEqualTo("[]")
    }

    @Test
    fun `단일 연결 리스트가 가진 데이터가 하나여도 표시 형식을 맞추어 String으로 변환된다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()
        val node1 = OneWayNode(1, null)
        singleLinkedList.add(node1)

        // when
        val expect = singleLinkedList.toString()

        // then
        assertThat(expect).isEqualTo("[ 1 ]")
    }

    @Test
    fun `단일 연결 리스트가 가진 노드를 검색해서 인자로 받은 데이터를 가진 노드를 반환받을 수 있다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()
        val node1 = OneWayNode(1, null)
        val targetNode = OneWayNode(2, null)
        val node3 = OneWayNode(3, null)
        singleLinkedList.add(node1)
        singleLinkedList.add(targetNode)
        singleLinkedList.add(node3)

        // when
        val searchedNode: OneWayNode<Int>? = singleLinkedList.searchByData(2)

        // then
        assertThat(searchedNode).isEqualTo(targetNode)
    }

    @Test
    fun `검색하려는 단일 연결 리스트의 헤드가 null이라면 null을 반환한다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()

        // when
        val searchedNode: OneWayNode<Int>? = singleLinkedList.searchByData(1)

        // then
        assertThat(searchedNode).isNull()
    }

    @Test
    fun `검색하려는 노드가 단일 연결 리스트에 없다면 null을 반환한다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()
        val node1 = OneWayNode(1, null)
        val node2 = OneWayNode(2, null)
        val node3 = OneWayNode(3, null)
        singleLinkedList.add(node1)
        singleLinkedList.add(node2)
        singleLinkedList.add(node3)

        // when
        val searchedNode: OneWayNode<Int>? = singleLinkedList.searchByData(4)

        // then
        assertThat(searchedNode).isNull()
    }

    @Test
    fun `단일 연결 리스트가 가진 노드 중 원하는 데이터를 가진 노드의 포인터에 노드를 추가할 수 있다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()
        val node1 = OneWayNode(1, null)
        val node2 = OneWayNode(2, null)
        val node3 = OneWayNode(3, null)
        singleLinkedList.add(node1)
        singleLinkedList.add(node2)
        singleLinkedList.add(node3)

        val newNode = OneWayNode(4, null)

        // when
        singleLinkedList.addNodeByValue(2, newNode)

        // then
        assertThat(singleLinkedList.searchByData(2)?.next).isEqualTo(newNode)
    }

    @Test
    fun `단일 연결 리스트가 가진 노드 중 원하는 노드를 검색하여 없다면 제일 뒤에 새 노드를 추가한다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()
        val node1 = OneWayNode(1, null)
        val node2 = OneWayNode(2, null)
        val node3 = OneWayNode(3, null)
        singleLinkedList.add(node1)
        singleLinkedList.add(node2)
        singleLinkedList.add(node3)

        val newNode = OneWayNode(4, null)

        // when
        singleLinkedList.addNodeByValue(5, newNode)

        // then
        assertThat(singleLinkedList.searchByData(3)?.next).isEqualTo(newNode)
    }

    @Test
    fun `단일 연결 리스트가 가진 노드를 삭제할 수 있다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()
        val node1 = OneWayNode(1, null)
        val node2 = OneWayNode(2, null)
        val node3 = OneWayNode(3, null)
        singleLinkedList.add(node1)
        singleLinkedList.add(node2)
        singleLinkedList.add(node3)

        // when
        singleLinkedList.remove(2)

        // then
        assertThat(singleLinkedList.searchByData(1)?.next).isEqualTo(node3)
    }

    @Test
    fun `단일 연결 리스트의 헤드에 삭제하고 싶은 노드가 있을 경우도 정상적으로 노드가 삭제된다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()
        val node1 = OneWayNode(1, null)
        val node2 = OneWayNode(2, null)
        val node3 = OneWayNode(3, null)
        singleLinkedList.add(node1)
        singleLinkedList.add(node2)
        singleLinkedList.add(node3)

        // when
        singleLinkedList.remove(1)

        // then
        assertThat(singleLinkedList.head).isEqualTo(node2)
    }

    @Test
    fun `단일 연결 리스트의 맨 마지막 노드에 삭제하고 싶은 노드가 있을 경우도 정상적으로 노드가 삭제된다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()
        val node1 = OneWayNode(1, null)
        val node2 = OneWayNode(2, null)
        val node3 = OneWayNode(3, null)
        singleLinkedList.add(node1)
        singleLinkedList.add(node2)
        singleLinkedList.add(node3)

        // when
        singleLinkedList.remove(3)

        // then
        assertThat(singleLinkedList.searchByData(node2.data)?.next).isNull()
        print(singleLinkedList)
    }

    @Test
    fun `단일 연결 리스트에 삭제하고 싶은 데이터가 없을 경우에도 예외처리 되지않는다`() {
        // given
        val singleLinkedList = SingleLinkedList<Int>()
        val node1 = OneWayNode(1, null)
        val node2 = OneWayNode(2, null)
        val node3 = OneWayNode(3, null)
        singleLinkedList.add(node1)
        singleLinkedList.add(node2)
        singleLinkedList.add(node3)

        // when

        // then
        assertDoesNotThrow { singleLinkedList.remove(4) }
    }
}
