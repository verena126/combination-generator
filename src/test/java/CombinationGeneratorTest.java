import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CombinationGeneratorTest {

    private CombinationGenerator cg2;
    private CombinationGenerator cg3;
    private CombinationGenerator cg4;
    private CombinationGenerator cg5;
    private CombinationGenerator cg6;


    @BeforeEach
    void setup() {
        cg2 = new CombinationGenerator(2);
        cg3 = new CombinationGenerator(3);
        cg4 = new CombinationGenerator(4);
        cg5 = new CombinationGenerator(5);
        cg6 = new CombinationGenerator(6);


    }

    @Test
    void arrayIsInitalized() {


        var a2_1 = cg2.generate();
        assertThat(a2_1).contains(1, 2);
        var a3_1 = cg3.generate();
        assertThat(a3_1).contains(1, 2, 3);

        var a4_1 = cg4.generate();
        assertThat(a4_1).contains(1, 2, 3, 4);
        var a5_1 = cg5.generate();
        assertThat(a5_1).contains(1, 2, 3, 4, 5);
    }


    @Test
    void testFirstElements() {

        var a2_1 = cg2.generate();
        assertThat(a2_1).contains(1, 2);
        var a2_2 = cg2.generate();
        assertThat(a2_2).contains(2, 1);
        var a2_3 = cg2.generate();
        assertThat(a2_3).contains(1, 3);
        var a2_4 = cg2.generate();
        assertThat(a2_4).contains(2, 3);
        var a2_5 = cg2.generate();
        assertThat(a2_5).contains(3, 1);
        var a2_6 = cg2.generate();
        assertThat(a2_6).contains(3, 2);

        var a3_1 = cg3.generate();
        assertThat(a3_1).contains(1, 2, 3);
        var a3_2 = cg3.generate();
        assertThat(a3_2).contains(1, 3, 2);
        var a3_3 = cg3.generate();
        assertThat(a3_3).contains(2, 1, 3);
        var a3_4 = cg3.generate();
        assertThat(a3_4).contains(3, 1, 2);


        var a4_1 = cg4.generate();
        assertThat(a4_1).contains(1, 2, 3, 4);
        var a4_2 = cg4.generate();
        assertThat(a4_2).contains(1, 2, 4, 3);
        var a4_3 = cg4.generate();
        assertThat(a4_3).contains(1, 3, 2, 4);

    }

    @Test
    void testGenerateWithTwoElements() {
        assertThat(tryFind(new int[]{2, 10}, cg2)).isTrue();
        assertThat(tryFind(new int[]{12, 4}, cg2)).isTrue();
        assertThat(tryFind(new int[]{19, 1}, cg2)).isTrue();
        assertThat(tryFind(new int[]{4, 10}, cg2)).isTrue();
        assertThat(tryFind(new int[]{12, 23}, cg2)).isTrue();
        assertThat(tryFind(new int[]{5, 1}, cg2)).isTrue();
        assertThat(tryFind(new int[]{6, 19}, cg2)).isTrue();
        assertThat(tryFind(new int[]{22, 4}, cg2)).isTrue();
        assertThat(tryFind(new int[]{32, 1}, cg2)).isTrue();
        assertThat(tryFind(new int[]{8, 15}, cg2)).isTrue();
        assertThat(tryFind(new int[]{12, 2}, cg2)).isTrue();
        assertThat(tryFind(new int[]{11, 15}, cg2)).isTrue();
        assertThat(tryFind(new int[]{23, 12}, cg2)).isTrue();
        assertThat(tryFind(new int[]{1, 18}, cg2)).isTrue();
        assertThat(tryFind(new int[]{19, 5}, cg2)).isTrue();
        assertThat(tryFind(new int[]{2, 1}, cg2)).isTrue();
        assertThat(tryFind(new int[]{13, 5}, cg2)).isTrue();
        assertThat(tryFind(new int[]{17, 3}, cg2)).isTrue();
        assertThat(tryFind(new int[]{7, 10}, cg2)).isTrue();
        assertThat(tryFind(new int[]{18, 5}, cg2)).isTrue();
    }

    @Test
    void testGenerateWithTwoElementsNegative() {
        assertThat(tryFind(new int[]{2, 2}, cg2)).isFalse();
        assertThat(tryFind(new int[]{12, 12}, cg2)).isFalse();
        assertThat(tryFind(new int[]{19, 19}, cg2)).isFalse();
        assertThat(tryFind(new int[]{5, 5}, cg2)).isFalse();
        assertThat(tryFind(new int[]{17, 17}, cg2)).isFalse();
        assertThat(tryFind(new int[]{21, 21}, cg2)).isFalse();
        assertThat(tryFind(new int[]{1, 1}, cg2)).isFalse();
        assertThat(tryFind(new int[]{6, 6}, cg2)).isFalse();
        assertThat(tryFind(new int[]{7, 7}, cg2)).isFalse();
        assertThat(tryFind(new int[]{8, 8}, cg2)).isFalse();
        assertThat(tryFind(new int[]{15, 15}, cg2)).isFalse();
        assertThat(tryFind(new int[]{24, 24}, cg2)).isFalse();
        assertThat(tryFind(new int[]{25, 25}, cg2)).isFalse();
        assertThat(tryFind(new int[]{3, 3}, cg2)).isFalse();
        assertThat(tryFind(new int[]{4, 4}, cg2)).isFalse();
        assertThat(tryFind(new int[]{9, 9}, cg2)).isFalse();
        assertThat(tryFind(new int[]{10, 10}, cg2)).isFalse();
        assertThat(tryFind(new int[]{11, 11}, cg2)).isFalse();
        assertThat(tryFind(new int[]{28, 28}, cg2)).isFalse();
        assertThat(tryFind(new int[]{30, 30}, cg2)).isFalse();
    }


    @Test
    void testGenerateWithThreeElements() {
        assertThat(tryFind(new int[]{1, 2, 3}, cg3)).isTrue();
        assertThat(tryFind(new int[]{3, 5, 7}, cg3)).isTrue();
        assertThat(tryFind(new int[]{7, 1, 6}, cg3)).isTrue();
        assertThat(tryFind(new int[]{4, 5, 1}, cg3)).isTrue();
        assertThat(tryFind(new int[]{12, 23, 4}, cg3)).isTrue();
        assertThat(tryFind(new int[]{5, 1, 2}, cg3)).isTrue();
        assertThat(tryFind(new int[]{6, 19, 16}, cg3)).isTrue();
        assertThat(tryFind(new int[]{22, 4, 3}, cg3)).isTrue();
        assertThat(tryFind(new int[]{32, 1, 6}, cg3)).isTrue();
        assertThat(tryFind(new int[]{8, 15, 5}, cg3)).isTrue();
        assertThat(tryFind(new int[]{12, 2, 11}, cg3)).isTrue();
        assertThat(tryFind(new int[]{11, 15, 8}, cg3)).isTrue();
        assertThat(tryFind(new int[]{23, 12, 9}, cg3)).isTrue();
        assertThat(tryFind(new int[]{1, 18, 12}, cg3)).isTrue();
        assertThat(tryFind(new int[]{19, 5, 1}, cg3)).isTrue();
        assertThat(tryFind(new int[]{2, 1, 15}, cg3)).isTrue();
        assertThat(tryFind(new int[]{13, 5, 11}, cg3)).isTrue();
        assertThat(tryFind(new int[]{17, 3, 14}, cg3)).isTrue();
        assertThat(tryFind(new int[]{7, 10, 11}, cg3)).isTrue();
        assertThat(tryFind(new int[]{18, 5, 1}, cg3)).isTrue();
        assertThat(tryFind(new int[]{20, 1, 12}, cg3)).isTrue();
    }

    @Test
    void testGenerateWithThreeElementsNegative() {
        assertThat(tryFind(new int[]{3, 10, 3}, cg3)).isFalse();
        assertThat(tryFind(new int[]{24, 1, 1}, cg3)).isFalse();
        assertThat(tryFind(new int[]{1, 1, 33}, cg3)).isFalse();
        assertThat(tryFind(new int[]{5, 10, 5}, cg3)).isFalse();
        assertThat(tryFind(new int[]{24, 24, 1}, cg3)).isFalse();
        assertThat(tryFind(new int[]{1, 8, 1}, cg3)).isFalse();
        assertThat(tryFind(new int[]{2, 20, 2}, cg3)).isFalse();
        assertThat(tryFind(new int[]{4, 4, 13}, cg3)).isFalse();
        assertThat(tryFind(new int[]{5, 5, 5}, cg3)).isFalse();
        assertThat(tryFind(new int[]{23, 11, 11}, cg3)).isFalse();
        assertThat(tryFind(new int[]{14, 1, 14}, cg3)).isFalse();
        assertThat(tryFind(new int[]{8, 8, 21}, cg3)).isFalse();
        assertThat(tryFind(new int[]{7, 10, 7}, cg3)).isFalse();
        assertThat(tryFind(new int[]{13, 13, 5}, cg3)).isFalse();
        assertThat(tryFind(new int[]{14, 14, 33}, cg3)).isFalse();
        assertThat(tryFind(new int[]{32, 3, 3}, cg3)).isFalse();
        assertThat(tryFind(new int[]{12, 7, 7}, cg3)).isFalse();
        assertThat(tryFind(new int[]{9, 9, 3}, cg3)).isFalse();
        assertThat(tryFind(new int[]{6, 17, 6}, cg3)).isFalse();
        assertThat(tryFind(new int[]{8, 8, 23}, cg3)).isFalse();

    }

    @Test
    void testGenerateWithFourElements() {

        assertThat(tryFind(new int[]{1, 10, 4, 30}, cg4)).isTrue();
        assertThat(tryFind(new int[]{24, 13, 26, 6}, cg4)).isTrue();
        assertThat(tryFind(new int[]{12, 1, 24, 2}, cg4)).isTrue();
        assertThat(tryFind(new int[]{3, 1, 11, 14}, cg4)).isTrue();
        assertThat(tryFind(new int[]{17, 8, 92, 5}, cg4)).isTrue();
        assertThat(tryFind(new int[]{91, 4, 1, 5}, cg4)).isTrue();
        assertThat(tryFind(new int[]{1, 7, 8, 3}, cg4)).isTrue();
        assertThat(tryFind(new int[]{5, 2, 1, 6}, cg4)).isTrue();
        assertThat(tryFind(new int[]{1, 15, 62, 31}, cg4)).isTrue();
        assertThat(tryFind(new int[]{9, 2, 42, 1}, cg4)).isTrue();
        assertThat(tryFind(new int[]{12, 4, 52, 1}, cg4)).isTrue();
        assertThat(tryFind(new int[]{14, 5, 1, 2}, cg4)).isTrue();
        assertThat(tryFind(new int[]{1, 4, 13, 3}, cg4)).isTrue();
        assertThat(tryFind(new int[]{6, 16, 26, 36}, cg4)).isTrue();
        assertThat(tryFind(new int[]{2, 24, 26, 28}, cg4)).isTrue();
        assertThat(tryFind(new int[]{3, 1, 5, 23}, cg4)).isTrue();
        assertThat(tryFind(new int[]{7, 2, 3, 13}, cg4)).isTrue();
        assertThat(tryFind(new int[]{8, 3, 11, 2}, cg4)).isTrue();
        assertThat(tryFind(new int[]{6, 2, 1, 5}, cg4)).isTrue();
        assertThat(tryFind(new int[]{7, 1, 5, 23}, cg4)).isTrue();
        assertThat(tryFind(new int[]{10, 20, 3, 1}, cg4)).isTrue();


    }

    @Test
    void testGenerateWithFourElementsNegative() {
        assertThat(tryFind(new int[]{55, 10, 4, 10}, cg4)).isFalse();
        assertThat(tryFind(new int[]{24, 100, 99, 24}, cg4)).isFalse();
        assertThat(tryFind(new int[]{33, 1, 53, 53}, cg4)).isFalse();
        assertThat(tryFind(new int[]{55, 55, 2, 2}, cg4)).isFalse();
        assertThat(tryFind(new int[]{24, 24, 1, 2}, cg4)).isFalse();
        assertThat(tryFind(new int[]{33, 1, 53, 1}, cg4)).isFalse();
        assertThat(tryFind(new int[]{2, 2, 5, 4}, cg4)).isFalse();
        assertThat(tryFind(new int[]{6, 6, 12, 1}, cg4)).isFalse();
        assertThat(tryFind(new int[]{4, 4, 5, 1}, cg4)).isFalse();
        assertThat(tryFind(new int[]{61, 42, 1, 1}, cg4)).isFalse();
        assertThat(tryFind(new int[]{1, 15, 12, 15}, cg4)).isFalse();
        assertThat(tryFind(new int[]{3, 3, 24, 1}, cg4)).isFalse();
        assertThat(tryFind(new int[]{2, 2, 10, 6}, cg4)).isFalse();
        assertThat(tryFind(new int[]{3, 7, 12, 3}, cg4)).isFalse();
        assertThat(tryFind(new int[]{7, 4, 2, 7}, cg4)).isFalse();
        assertThat(tryFind(new int[]{17, 34, 21, 17}, cg4)).isFalse();
        assertThat(tryFind(new int[]{8, 3, 12, 12}, cg4)).isFalse();
        assertThat(tryFind(new int[]{36, 5, 5, 2}, cg4)).isFalse();
        assertThat(tryFind(new int[]{1, 14, 12, 1}, cg4)).isFalse();
        assertThat(tryFind(new int[]{7, 7, 43, 2}, cg4)).isFalse();
        assertThat(tryFind(new int[]{8, 2, 8, 1}, cg4)).isFalse();


    }

    @Test
    void testGenerateWithFiveElements() {

        assertThat(tryFind(new int[]{2, 5, 4, 3, 1}, cg5)).isTrue();
    }


    @Test
    void testGenerateWithFiveElementsNegative() {

        assertThat(tryFind(new int[]{55, 10, 4, 10, 1}, cg5)).isFalse();
    }

    @Test
    void testGenerateWithSixElements() {
        assertThat(tryFind(new int[]{1, 3, 2, 5, 6, 4}, cg6)).isTrue();
    }


    private boolean tryFind(int[] toFound, CombinationGenerator cg) {
        cg = new CombinationGenerator(toFound.length);
        int maxLimit = 2000;
        boolean found = false;
        int step = 0;

        while (found == false & step < maxLimit) {
            int[] res = cg.generate();
            found = false;
            for (int i = 0; i < toFound.length; i++) {
                found = true;
                if (toFound[i] != res[i]) {
                    found = false;
                    break;
                }
            }
            step++;
            cg.printList();
        }
        return found;
    }

    @Test
    void testDouble() {
        for (int i = 1; i < 100; i++) {
            assertThat(checkDouble(i)).isFalse();
        }
    }

    private static boolean checkDouble(int currentLength) {
        int[] arr;
        CombinationGenerator cg = new CombinationGenerator(currentLength);
        for (int i = 0; i < 100; i++) {
            arr = cg.generate();
            for (int j = 0; j < currentLength - 1; j++) {
                for (int k = i + 1; k < currentLength; k++) {

                    if (arr[j] == arr[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Test
    void testIfAlwaysTheSame() {
        for (int i = 1; i < 100; i++) {
            assertThat(checkIfTheSame(i)).isTrue();
        }
    }

    private boolean checkIfTheSame(int currentLength) {
        int[] arr2;
        int[] arr3;

        CombinationGenerator cg = new CombinationGenerator(currentLength);
        CombinationGenerator cg1 = new CombinationGenerator(currentLength);
        for (int i = 0; i < 100; i++) {
            arr2 = cg.generate();
            arr3 = cg1.generate();
            for (int k = 0; k < arr2.length; k++) {
                if (arr2[k] != arr3[k]) {
                    return false;

                }
            }
        }
        return true;
    }

}
