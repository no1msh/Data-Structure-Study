package datastructure.linear.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JavaArrayTest {
    /**
     * - 배열은 값은 타입의 값만 관리한다.
     * <p>
     * - 배열의 길이는 늘리거나 줄일 수 없다.
     */

    @Test
    void 배열을_값_목록_형태로_만들_수_있다() {
        // given & when
        final int[] intArray = {1, 2, 3, 4, 5};
        final String[] stringArray = {"a", "b", "c", "d", "e"};

        // then
        assertThat(Arrays.toString(intArray)).isEqualTo("[1, 2, 3, 4, 5]");
        assertThat(Arrays.toString(stringArray)).isEqualTo("[a, b, c, d, e]");
    }

    @Test
    void 배열을_다음과_같이_선언해둘순_있지만_초기값이_들어간다() {
        // given & when
        final int[] intArray = new int[3];
        final boolean[] booleanArray = new boolean[3];
        final String[] stringArray = new String[3];

        // then: 정수배열은 0, 실수 배열은 0.0, 논리 배열은 false, 참조 배열은 null로 초기화된다.
        assertThat(Arrays.toString(intArray)).isEqualTo("[0, 0, 0]");
        assertThat(Arrays.toString(booleanArray)).isEqualTo("[false, false, false]");
        assertThat(Arrays.toString(stringArray)).isEqualTo("[null, null, null]");
    }

    @Test
    void length를_통하여_배열의_초기설정된_길이를_구할_수_있다() {
        // given
        final int[] intArray = new int[3];

        // when
        final int actual = intArray.length;

        // then
        assertThat(actual).isEqualTo(3);
    }

    @Test
    void 표현식을_통해_원소를_수정할_수_있다() {
        // given
        final int[] intArray = new int[3];

        // when
        intArray[2] = 3;

        // then
        assertThat(intArray[2]).isEqualTo(3);
    }
}
