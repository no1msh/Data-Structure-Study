package datastructure.linear.stack.linkedlist

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class LinkedListStackTest {
    @Test
    fun `stack은 peek으로 가장 마지막에 삽입한 값을 확인할 수 있다`() {
        // given
        val linkedListStack = LinkedListStack<Int>()
        linkedListStack.push(1)

        // when
        val actual = linkedListStack.peek()

        // then
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun `peek은 가져올 수 있는 데이터가 없을 시 예외처리 된다`() {
        // given
        val linkedListStack = LinkedListStack<Int>()

        // when
        val exception = assertThrows<NoSuchElementException> { linkedListStack.peek() }

        // then
        assertThat(exception.message).isEqualTo("추출할 데이터가 존재하지 않습니다.")
    }

    @Test
    fun `peekOrNull은 가져올 수 있는 데이터가 없을 시 null을 반환한다`() {
        // given
        val linkedListStack = LinkedListStack<Int>()

        // when
        val actual = linkedListStack.peekOrNull()

        // then
        assertThat(actual).isNull()
    }

    @Test
    fun `stack은 push로 값을 삽입할 수 있다`() {
        // given
        val linkedListStack = LinkedListStack<Int>()

        // when
        linkedListStack.push(1)

        // then
        assertThat(linkedListStack.peek()).isEqualTo(1)
    }

    @Test
    fun `pop을 통해 제일 마지막에 들어가있던 값을 반환 받을 수 있다`() {
        // given
        val linkedListStack = LinkedListStack<Int>()
        linkedListStack.push(1)

        // when
        val actual = linkedListStack.pop()

        // then
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun `pop을 통해 값을 반환 받을 때 데이터가 존재하지 않는다면 예외처리한다`() {
        // given
        val linkedListStack = LinkedListStack<Int>()

        // when
        val exception = assertThrows<NoSuchElementException> { linkedListStack.pop() }

        // then
        assertThat(exception.message).isEqualTo("추출할 데이터가 존재하지 않습니다.")
    }

    @Test
    fun `popOrNull을 통해 값을 반환 받을 때 데이터가 존재하지 않는다면 null을 반환한다`() {
        // given
        val linkedListStack = LinkedListStack<Int>()

        // when
        val actual = linkedListStack.popOrNull()

        // then
        assertThat(actual).isNull()
    }

    @Test
    fun `1 2 3 4 5를 push 하고 5번 pop하면 5 4 3 2 1이 반환된다`() {
        // given
        val linkedListStack = LinkedListStack<Int>().apply {
            push(1)
            push(2)
            push(3)
            push(4)
            push(5)
        }

        // when
        val actual1 = linkedListStack.pop()
        val actual2 = linkedListStack.pop()
        val actual3 = linkedListStack.pop()
        val actual4 = linkedListStack.pop()
        val actual5 = linkedListStack.pop()
        val exception = assertThrows<NoSuchElementException> { linkedListStack.pop() }

        // then
        assertAll(
            { assertThat(actual1).isEqualTo(5) },
            { assertThat(actual2).isEqualTo(4) },
            { assertThat(actual3).isEqualTo(3) },
            { assertThat(actual4).isEqualTo(2) },
            { assertThat(actual5).isEqualTo(1) },
            { assertThat(exception.message).isEqualTo("추출할 데이터가 존재하지 않습니다.") },
        )
    }

    @Test
    fun `stack의 사이즈를 측정할 수 있다`() {
        // given
        val linkedListStack = LinkedListStack<Int>()

        // when
        linkedListStack.push(1)
        linkedListStack.push(2)
        val actual1 = linkedListStack.size
        linkedListStack.pop()
        val actual2 = linkedListStack.size
        linkedListStack.pop()
        val actual3 = linkedListStack.size

        // then
        assertAll(
            { assertThat(actual1).isEqualTo(2) },
            { assertThat(actual2).isEqualTo(1) },
            { assertThat(actual3).isEqualTo(0) },
        )
    }

    @Test
    fun `stack이 비었는지 확인할 수 있다`() {
        // given
        val linkedListStack = LinkedListStack<Int>()

        // when
        val actual1 = linkedListStack.isEmpty
        linkedListStack.push(1)
        val actual2 = linkedListStack.isEmpty

        // then
        assertAll(
            { assertThat(actual1).isTrue() },
            { assertThat(actual2).isFalse() },
        )
    }
}
