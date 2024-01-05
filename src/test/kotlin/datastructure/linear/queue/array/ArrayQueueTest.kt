package datastructure.linear.queue.array

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class ArrayQueueTest {
    @Test
    fun `ArrayQueue는 배열에 데이터를 저장한다`() {
        // given

        // when
        val arrayQueue = ArrayQueue<Int>(5).apply {
            enqueue(1)
            enqueue(2)
            enqueue(3)
        }

        // then
        assertThat(arrayQueue.toString()).isEqualTo("[1, 2, 3]")
    }

    @Test
    fun `ArrayQueue는 자신이 가진 원소의 개수를 반환할 수 있다`() {
        // given
        val arrayQueue = ArrayQueue<Int>(5).apply {
            enqueue(1)
            enqueue(2)
            enqueue(3)
        }

        // when
        val actual = arrayQueue.size

        // then
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `ArrayQueue는  자신이 가진 원소개수를 반환할 떄 가진게 없다면 0을 반환한다`() {
        // given
        val arrayQueue = ArrayQueue<Int>(5)

        // when
        val actual = arrayQueue.size

        // then
        assertThat(0).isEqualTo(actual)
    }

    @Test
    fun `ArrayQueue는 큐가 가득 차있는지에 따라 Boolean값을 반환 받을 수 있다`() {
        // given
        val fullQueue = ArrayQueue<Int>(3).apply {
            enqueue(1)
            enqueue(2)
            enqueue(3)
        }
        val notFullQueue = ArrayQueue<Int>(3).apply {
            enqueue(1)
            enqueue(2)
        }

        // when
        val actualFull: Boolean = fullQueue.isFull
        val actualNotFull: Boolean = notFullQueue.isFull

        // then
        assertAll(
            { assertThat(actualFull).isTrue },
            { assertThat(actualNotFull).isFalse },
        )
    }

    @Test
    fun `ArrayQueue는 dequeue를 했을 때 가장 먼저 반환되는 값의 인덱스를 front라고 한다`() {
        // given
        val arrayQueue = ArrayQueue<Int>(3)

        // when
        val actualFront = arrayQueue.front

        // then
        assertThat(actualFront).isEqualTo(0)
    }

    @Test
    fun `front는 dequeue를 할 시 뒤로 한 칸씩 이동한다`() {
        // given
        val arrayQueue = ArrayQueue<Int>(3)
        arrayQueue.enqueue(1)

        // when
        arrayQueue.dequeue()
        val actual = arrayQueue.front

        // then
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun `front는 dequeue를 더이상 못할 때 가용크기 - 1 의 값을 가진다`() {
        // given
        val arrayQueue = ArrayQueue<Int>(3).apply {
            enqueue(1)
            enqueue(2)
            enqueue(3)
            dequeue()
            dequeue()
            dequeue()
        }

        // when
        val actual = arrayQueue.front

        // then
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun `ArrayQueue는 enqueue를 했을 때 값이 들어갈 인덱스를 rear라고 한다`() {
        // given
        val arrayQueue = ArrayQueue<Int>(3)

        // when
        val actualRear = arrayQueue.rear

        // then
        assertThat(actualRear).isEqualTo(0)
    }

    @Test
    fun `rear는 enqueue를 하면 그 횟수에 맞게 값이 증가한다`() {
        // given
        val queueWithTwoEnqueue = ArrayQueue<Int>(3)

        // when
        val rearWithNoEnqueue = queueWithTwoEnqueue.rear

        queueWithTwoEnqueue.enqueue(1)
        val rearWithOneEnqueue = queueWithTwoEnqueue.rear

        queueWithTwoEnqueue.enqueue(2)
        val rearWithTwoEnqueue = queueWithTwoEnqueue.rear

        queueWithTwoEnqueue.enqueue(3)
        val rearWithThreeEnqueue = queueWithTwoEnqueue.rear

        // then
        assertAll(
            { assertThat(rearWithNoEnqueue).isEqualTo(0) },
            { assertThat(rearWithOneEnqueue).isEqualTo(1) },
            { assertThat(rearWithTwoEnqueue).isEqualTo(2) },
            { assertThat(rearWithThreeEnqueue).isEqualTo(2) },
        )
    }

    @Test
    fun `ArrayQueue는 가진 데이터가 없는지를 Boolean 값으로 반환받을 수 있다`() {
        // given
        val arrayQueue = ArrayQueue<Int>(5)

        // when
        val expect = arrayQueue.isEmpty

        // then
        assertThat(expect).isTrue
    }

    @Test
    fun `만일 데이터가 있다면 isEmpty는 false를 반환한다`() {
        // given
        val arrayQueue = ArrayQueue<Int>(3)
        arrayQueue.enqueue(1)

        // when
        val actual = arrayQueue.isEmpty

        // then
        assertThat(actual).isFalse
    }

    @Test
    fun `ArrayQueue는 enqueue를 통해 데이터를 추가할 수 있다`() {
        // given
        val arrayQueue = ArrayQueue<Int>(3)

        // when
        arrayQueue.enqueue(1)

        // then
        assertThat(arrayQueue.toString()).isEqualTo("[1]")
    }

    @Test
    fun `ArrayQueue는 수용할 수 있는 데이터들을 모두 수용했다면 enqueue를 할 시 예외처리한다`() {
        // given
        val arrayQueue = ArrayQueue<Int>(3).apply {
            enqueue(1)
            enqueue(2)
            enqueue(3)
        }

        // when
        val exception = assertThrows<IndexOutOfBoundsException> { arrayQueue.enqueue(4) }

        // then
        assertThat(exception.message).isEqualTo("Queue가 수용할 수 있는 크기를 넘어서 enqueue를 할 수 없습니다.")
    }

    @Test
    fun `ArrayQueue는 dequeue를 통해 front에 위치한 값을 반환한다`() {
        // given
        val arrayQueue = ArrayQueue<Int>(5)
        arrayQueue.enqueue(1)

        // when
        val actual = arrayQueue.dequeue()

        // then
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun `ArrayQueue는 가용 공간에 데이터가 전부 존재해도 dequeue를 할 수 있다`() {
        // given
        val arrayQueue = ArrayQueue<Int>(3).apply {
            enqueue(1)
            enqueue(2)
            enqueue(3)
        }

        // when
        val actual1 = arrayQueue.dequeue()
        val actual2 = arrayQueue.dequeue()
        val actual3 = arrayQueue.dequeue()

        // then
        assertAll(
            { assertThat(actual1).isEqualTo(1) },
            { assertThat(actual2).isEqualTo(2) },
            { assertThat(actual3).isEqualTo(3) },
        )
    }
}
