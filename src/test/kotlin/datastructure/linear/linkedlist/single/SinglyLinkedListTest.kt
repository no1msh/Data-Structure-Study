package datastructure.linear.linkedlist.single

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class SinglyLinkedListTest {
    @Test
    fun `단일 연결 리스트는 헤드라는 제일 첫 번째 노드를 가진다`() {
        // given
        val singlyLinkedList = SinglyLinkedList<Int>()
        singlyLinkedList.add(1)

        // when

        // then
        assertThat(singlyLinkedList.head!!.data).isEqualTo(1)
    }

    @Test
    fun `노드를 추가할 때 헤드에 이미 값이 있으면 제일 마지막 노드의 포인터에 노드를 추가한다`() {
        // given
        val singlyLinkedList = SinglyLinkedList<Int>()
        singlyLinkedList.add(1)

        // when
        singlyLinkedList.add(2)

        // then
        assertThat(singlyLinkedList.head!!.next!!.data).isEqualTo(2)
    }

    @Test
    fun `단일 연결 리스트가 가진 모든 데이터를 문자열로 표현할 수 있다`() {
        // given
        val singlyLinkedList = SinglyLinkedList<Int>()
        singlyLinkedList.add(1)
        singlyLinkedList.add(2)
        singlyLinkedList.add(3)

        // when
        val expect = singlyLinkedList.toString()

        // then
        assertThat(expect).isEqualTo("[ 1 -> 2 -> 3 ]")
    }

    @Test
    fun `단일 연결 리스트가 가진 데이터가 없어도 표시 형식을 맞추어 String으로 변환된다`() {
        // given
        val singlyLinkedList = SinglyLinkedList<Int>()

        // when
        val expect = singlyLinkedList.toString()

        // then
        assertThat(expect).isEqualTo("[]")
    }

    @Test
    fun `단일 연결 리스트가 가진 데이터가 하나여도 표시 형식을 맞추어 String으로 변환된다`() {
        // given
        val singlyLinkedList = SinglyLinkedList<Int>()
        singlyLinkedList.add(1)

        // when
        val expect = singlyLinkedList.toString()

        // then
        assertThat(expect).isEqualTo("[ 1 ]")
    }

    @Test
    fun `단일 연결 리스트가 가진 노드 중 원하는 데이터를 가진 노드의 포인터에 노드를 추가할 수 있다`() {
        // given
        val singlyLinkedList = SinglyLinkedList<Int>()
        singlyLinkedList.add(1)
        singlyLinkedList.add(2)
        singlyLinkedList.add(3)

        // when
        singlyLinkedList.add(2, 4)

        // then
        assertThat(singlyLinkedList.toString()).isEqualTo("[ 1 -> 2 -> 4 -> 3 ]")
    }

    @Test
    fun `단일 연결 리스트가 가진 노드 중 원하는 노드를 검색하여 없다면 제일 뒤에 새 노드를 추가한다`() {
        // given
        val singlyLinkedList = SinglyLinkedList<Int>()
        singlyLinkedList.add(1)
        singlyLinkedList.add(2)
        singlyLinkedList.add(3)

        // when
        singlyLinkedList.add(5, 4)

        // then
        assertThat(singlyLinkedList.toString()).isEqualTo("[ 1 -> 2 -> 3 -> 4 ]")
    }

    @Test
    fun `단일 연결 리스트가 가진 노드를 삭제할 수 있다`() {
        // given
        val singlyLinkedList = SinglyLinkedList<Int>()
        singlyLinkedList.add(1)
        singlyLinkedList.add(2)
        singlyLinkedList.add(3)

        // when
        singlyLinkedList.remove(2)

        // then
        assertThat(singlyLinkedList.toString()).isEqualTo("[ 1 -> 3 ]")
    }

    @Test
    fun `단일 연결 리스트의 헤드에 삭제하고 싶은 노드가 있을 경우도 정상적으로 노드가 삭제된다`() {
        // given
        val singlyLinkedList = SinglyLinkedList<Int>()
        singlyLinkedList.add(1)
        singlyLinkedList.add(2)
        singlyLinkedList.add(3)

        // when
        singlyLinkedList.remove(1)

        // then
        assertThat(singlyLinkedList.toString()).isEqualTo("[ 2 -> 3 ]")
    }

    @Test
    fun `단일 연결 리스트의 맨 마지막 노드에 삭제하고 싶은 노드가 있을 경우도 정상적으로 노드가 삭제된다`() {
        // given
        val singlyLinkedList = SinglyLinkedList<Int>()
        singlyLinkedList.add(1)
        singlyLinkedList.add(2)
        singlyLinkedList.add(3)

        // when
        singlyLinkedList.remove(3)

        // then
        assertThat(singlyLinkedList.toString()).isEqualTo("[ 1 -> 2 ]")
    }

    @Test
    fun `단일 연결 리스트에 삭제하고 싶은 데이터가 없을 경우에도 예외처리 되지않는다`() {
        // given
        val singlyLinkedList = SinglyLinkedList<Int>()
        singlyLinkedList.add(1)
        singlyLinkedList.add(2)
        singlyLinkedList.add(3)

        // when

        // then
        assertDoesNotThrow { singlyLinkedList.remove(4) }
    }

    @Test
    fun `단일 연결 리스트의 헤드 노드를 삭제할 수 있다`() {
        // given
        val singlyLinkedList = SinglyLinkedList<Int>()
        singlyLinkedList.add(1)
        singlyLinkedList.add(2)
        singlyLinkedList.add(3)

        // when
        singlyLinkedList.removeFirst()

        // then
        assertThat(singlyLinkedList.toString()).isEqualTo("[ 2 -> 3 ]")
    }

    @Test
    fun `단일 연결 리스트의 헤드 노드가 존재하지 않을 때 헤드 노드를 삭제하려해도 예외처리 되지 않는다`() {
        // given
        val singlyLinkedList = SinglyLinkedList<Int>()

        // when

        // then
        assertDoesNotThrow { singlyLinkedList.removeFirst() }
    }

    @Test
    fun `단일 연결 리스트의 테일 노드를 삭제할 수 있다`() {
        // given
        val singlyLinkedList = SinglyLinkedList<Int>()
        singlyLinkedList.add(1)
        singlyLinkedList.add(2)
        singlyLinkedList.add(3)

        // when
        singlyLinkedList.removeLast()

        // then
        assertThat(singlyLinkedList.toString()).isEqualTo("[ 1 -> 2 ]")
    }

    @Test
    fun `단일 연결 리스트의 테일 노드가 없을 때 테일노드를 삭제하려해도 예외처리되지 않는다`() {
        // given
        val singlyLinkedList = SinglyLinkedList<Int>()

        // when

        // then
        assertDoesNotThrow { singlyLinkedList.removeLast() }
    }
}
