package datastructure.linear.array;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JavaLinkedListTest {
    @Test
    void 이중연결리스트는_add를_통해_값을_추가할_수_있다() {
        // given
        // 참조타입만 제네릭 타입으로 넣을 수 있다.
        LinkedList<Integer> linkedList = new LinkedList<>();

        // when
        linkedList.add(1);
        linkedList.add(2);

        // then
        assertThat(linkedList.toString()).isEqualTo("[1, 2]");
    }

    @Test
    void 이중연결리스트는_remove를_통해_Head값을_제거할_수_있다() {
        // given
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);

        // when
        linkedList.remove();

        // then
        assertThat(linkedList.toString()).isEqualTo("[2]");
    }

    @Test
    void 이중연결리스트는_size를_통해_현재크기를_알_수_있다() {
        // given
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);

        // when
        final int actual = linkedList.size();

        // then
        assertThat(actual).isEqualTo(2);
    }

    @Test
    void 이중연결리스트는_indexOf를_통해_찾으려는_원소의_인덱스를_알_수_있다() {
        // given
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);

        // when
        final int actual = linkedList.indexOf(2);

        // then
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void 이중연결리스트는_indexOf를_통해_찾으려는_원소가_없다면_마이너스_1을_반환한다() {
        // given
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);

        // when
        final int actual = linkedList.indexOf(3);

        // then
        assertThat(actual).isEqualTo(-1);
    }

    @Test
    void 이중연결리스트는_내부적으로_indexOf를_통해_contains를_구현한다() {
        // given
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);

        // when
        final boolean actual = linkedList.contains(2);

        // then
        assertThat(actual).isEqualTo(true);
    }

    @Test
    void 이중연결리스트는_clear를_통해_모든_노드를_제거할_수_있다() {
        // given
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);

        // when
        linkedList.clear();

        // then
        assertThat(linkedList.toString()).isEqualTo("[]");
    }
}
