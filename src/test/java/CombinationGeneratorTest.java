import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CombinationGeneratorTest {
    private CombinationGeneratorNew cg1;
    private CombinationGeneratorNew cg2;
    private CombinationGeneratorNew cg3;
    private CombinationGeneratorNew cg4;
    private CombinationGeneratorNew cg5;
    private CombinationGeneratorNew cg6;
    private CombinationGeneratorNew cg8;


    @BeforeEach
    void setup() {
        cg1 = new CombinationGeneratorNew(1);
        cg2 = new CombinationGeneratorNew(2);
        cg3 = new CombinationGeneratorNew(3);
        cg4 = new CombinationGeneratorNew(4);
        cg5 = new CombinationGeneratorNew(5);
        cg6 = new CombinationGeneratorNew(6);
        cg8 = new CombinationGeneratorNew(8);


    }

    @Test
    void testCombinationGenerator() {
        for (int i = 0; i < 20; i++) {
            int[] res = cg1.generate();
            System.out.println(Arrays.toString(res));
        }
    }

    @Test
    void arrayIsInitalized() {
        var a1_1 = cg1.generate();
        assertThat(a1_1).contains(1);

        var a2_1 = cg2.generate();
        assertThat(a2_1).contains(1, 2);
        var a3_1 = cg3.generate();
        assertThat(a3_1).contains(1, 2, 3);
        var a4_1 = cg4.generate();
        assertThat(a4_1).contains(1, 2, 3, 4);
        var a5_1 = cg5.generate();
        assertThat(a5_1).contains(1, 2, 3, 4, 5);
        var a6_1 = cg6.generate();
        assertThat(a6_1).contains(1, 2, 3, 4, 5, 6);
    }


    @Test
    void testFirstElements() {

        var a2_1 = cg2.generate();
        assertThat(a2_1).contains(1, 2);
        var a2_2 = cg2.generate();
        assertThat(a2_2).contains(2, 1);
        var a2_3 = cg2.generate();
        assertThat(a2_3).contains(2, 3);
        var a2_4 = cg2.generate();
        assertThat(a2_4).contains(1, 3);
        var a2_5 = cg2.generate();
        assertThat(a2_5).contains(3, 1);
        var a2_6 = cg2.generate();
        assertThat(a2_6).contains(3, 2);
    }

    @Test
    void testFirstElementsforSizeThree() {
        var a3_1 = cg3.generate();
        assertThat(a3_1).contains(1, 2, 3);
        var a3_2 = cg3.generate();
        assertThat(a3_2).contains(1, 3, 2);
        var a3_3 = cg3.generate();
        assertThat(a3_3).contains(2, 1, 3);
        var a3_4 = cg3.generate();
        assertThat(a3_4).contains(2, 3, 1);

    }

    @Test
    void testFirstElementsforSizeFour() {
        var a4_1 = cg4.generate();
        assertThat(a4_1).contains(1, 2, 3, 4);
        var a4_2 = cg4.generate();
        assertThat(a4_2).contains(1, 2, 4, 3);
        var a4_3 = cg4.generate();
        assertThat(a4_3).contains(1, 3, 2, 4);
    }

    @Test
    void testFirstElementsforSizeFive() {

        var a5_1 = cg5.generate();
        assertThat(a5_1).contains(1, 2, 3, 4, 5);
        var a5_2 = cg5.generate();
        assertThat(a5_2).contains(1, 2, 3, 5, 4);
        var a5_3 = cg5.generate();
        assertThat(a5_3).contains(1, 2, 4, 3, 5);
    }

    @Test
    void testFirstElementsforSizeSix() {
        var a6_1 = cg6.generate();
        assertThat(a6_1).contains(1, 2, 3, 4, 5, 6);
        var a6_2 = cg6.generate();
        assertThat(a6_2).contains(1, 2, 3, 4, 6, 5);
        var a6_3 = cg6.generate();
        assertThat(a6_3).contains(1, 2, 3, 5, 4, 6);
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
        assertThat(tryFind(new int[]{30, 0}, cg2)).isFalse();

    }


    @Test
    void testGenerateWithThreeElements() {


        assertThat(tryFind(new int[]{1, 2, 3}, cg3)).isTrue();
        assertThat(tryFind(new int[]{3, 5, 7}, cg3)).isTrue();
        assertThat(tryFind(new int[]{7, 1, 6}, cg3)).isTrue();
        assertThat(tryFind(new int[]{4, 5, 1}, cg3)).isTrue();
        assertThat(tryFind(new int[]{12, 18, 4}, cg3)).isTrue();
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
        assertThat(tryFind(new int[]{13, 5, 11}, cg3)).isTrue();
        assertThat(tryFind(new int[]{17, 3, 14}, cg3)).isTrue();
        assertThat(tryFind(new int[]{7, 10, 11}, cg3)).isTrue();
        assertThat(tryFind(new int[]{18, 5, 1}, cg3)).isTrue();
        assertThat(tryFind(new int[]{20, 1, 12}, cg3)).isTrue();
        assertThat(tryFind(new int[]{3, 1, 16}, cg3)).isTrue();
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

        assertThat(tryFind(new int[]{1, 10, 4, 15}, cg4)).isTrue();
        assertThat(tryFind(new int[]{12, 13, 26, 6}, cg4)).isTrue();
        assertThat(tryFind(new int[]{12, 1, 24, 2}, cg4)).isTrue();
        assertThat(tryFind(new int[]{3, 2, 11, 14}, cg4)).isTrue();
        assertThat(tryFind(new int[]{17, 8, 19, 5}, cg4)).isTrue();
        assertThat(tryFind(new int[]{19, 4, 1, 5}, cg4)).isTrue();
        assertThat(tryFind(new int[]{1, 7, 8, 3}, cg4)).isTrue();
        assertThat(tryFind(new int[]{5, 2, 1, 6}, cg4)).isTrue();
        assertThat(tryFind(new int[]{1, 15, 35, 31}, cg4)).isTrue();
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
        assertThat(tryFind(new int[]{1, 0, 32, 5}, cg4)).isFalse();
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
        assertThat(tryFind(new int[]{1, 5, 4, 3, 2}, cg5)).isTrue();
        assertThat(tryFind(new int[]{3, 4, 5, 2, 1}, cg5)).isTrue();
        assertThat(tryFind(new int[]{1, 5, 4, 3, 6}, cg5)).isTrue();
        assertThat(tryFind(new int[]{2, 5, 6, 3, 1}, cg5)).isTrue();
        assertThat(tryFind(new int[]{3, 4, 6, 1, 2}, cg5)).isTrue();
        assertThat(tryFind(new int[]{1, 3, 6, 2, 7}, cg5)).isTrue();
        assertThat(tryFind(new int[]{4, 3, 7, 2, 1}, cg5)).isTrue();
        assertThat(tryFind(new int[]{1, 5, 2, 3, 9}, cg5)).isTrue();
        assertThat(tryFind(new int[]{1, 2, 8, 3, 5}, cg5)).isTrue();
        assertThat(tryFind(new int[]{6, 5, 4, 3, 2}, cg5)).isTrue();
        assertThat(tryFind(new int[]{1, 3, 4, 2, 12}, cg5)).isTrue();
        assertThat(tryFind(new int[]{3, 6, 2, 4, 7}, cg5)).isTrue();
        assertThat(tryFind(new int[]{2, 3, 1, 8, 10}, cg5)).isTrue();
        assertThat(tryFind(new int[]{1, 3, 4, 10, 2}, cg5)).isTrue();
        assertThat(tryFind(new int[]{2, 3, 5, 6, 1}, cg5)).isTrue();
        assertThat(tryFind(new int[]{4, 1, 10, 8, 2}, cg5)).isTrue();
        assertThat(tryFind(new int[]{1, 6, 2, 10, 12}, cg5)).isTrue();
        assertThat(tryFind(new int[]{7, 1, 4, 3, 2}, cg5)).isTrue();
        assertThat(tryFind(new int[]{4, 2, 12, 3, 6}, cg5)).isTrue();
        assertThat(tryFind(new int[]{1, 5, 4, 16, 8}, cg5)).isTrue();


    }


    @Test
    void testGenerateWithFiveElementsNegative() {

        assertThat(tryFind(new int[]{55, 10, 4, 10, 1}, cg5)).isFalse();
        assertThat(tryFind(new int[]{55, 5, 4, 55, 1}, cg5)).isFalse();
        assertThat(tryFind(new int[]{5, 3, 4, 10, 3}, cg5)).isFalse();
        assertThat(tryFind(new int[]{5, 1, 4, 11, 4}, cg5)).isFalse();
        assertThat(tryFind(new int[]{4, 3, 3, 12, 2}, cg5)).isFalse();
        assertThat(tryFind(new int[]{3, 5, 2, 13, 2}, cg5)).isFalse();
        assertThat(tryFind(new int[]{2, 7, 1, 14, 7}, cg5)).isFalse();
        assertThat(tryFind(new int[]{1, 9, 4, 15, 1}, cg5)).isFalse();
        assertThat(tryFind(new int[]{6, 7, 3, 16, 6}, cg5)).isFalse();
        assertThat(tryFind(new int[]{5, 5, 2, 17, 12}, cg5)).isFalse();
        assertThat(tryFind(new int[]{4, 3, 1, 18, 4}, cg5)).isFalse();
        assertThat(tryFind(new int[]{3, 1, 4, 19, 3}, cg5)).isFalse();
        assertThat(tryFind(new int[]{2, 3, 3, 2, 15}, cg5)).isFalse();
        assertThat(tryFind(new int[]{1, 5, 2, 3, 5}, cg5)).isFalse();
        assertThat(tryFind(new int[]{6, 7, 1, 4, 7}, cg5)).isFalse();
        assertThat(tryFind(new int[]{5, 9, 4, 5, 9}, cg5)).isFalse();
        assertThat(tryFind(new int[]{4, 7, 3, 6, 4}, cg5)).isFalse();
        assertThat(tryFind(new int[]{3, 5, 2, 7, 3}, cg5)).isFalse();
        assertThat(tryFind(new int[]{2, 3, 1, 8, 2}, cg5)).isFalse();
        assertThat(tryFind(new int[]{1, 1, 4, 9, 15}, cg5)).isFalse();

    }

    @Test
    void testGenerateWithSixElements() {

        assertThat(tryFind(new int[]{1, 2, 3, 5, 6, 4}, cg6)).isTrue();
        assertThat(tryFind(new int[]{2, 1, 3, 5, 6, 4}, cg6)).isTrue();
        assertThat(tryFind(new int[]{2, 1, 5, 3, 6, 4}, cg6)).isTrue();
        assertThat(tryFind(new int[]{1, 4, 3, 6, 5, 2}, cg6)).isTrue();
        assertThat(tryFind(new int[]{3, 1, 2, 5, 6, 4}, cg6)).isTrue();

    }

    @Test
    void testGenerateWithSixElementsNegative() {
        assertThat(tryFind(new int[]{55, 10, 4, 10, 1, 2}, cg6)).isFalse();
        assertThat(tryFind(new int[]{1, 9, 4, 7, 1, 3}, cg6)).isFalse();
        assertThat(tryFind(new int[]{2, 3, 4, 3, 1, 5}, cg6)).isFalse();
        assertThat(tryFind(new int[]{1, 8, 8, 6, 2, 3}, cg6)).isFalse();
        assertThat(tryFind(new int[]{2, 7, 3, 2, 5, 9}, cg6)).isFalse();

    }

    @Test
    void testGenerateWithSevenElements() {

        assertThat(tryFind(new int[]{2, 3, 4, 1, 5, 6, 7, 8}, cg8)).isTrue();
    }


    private boolean tryFind(int[] toFound, CombinationGeneratorNew cg) {
        cg = new CombinationGeneratorNew(toFound.length);
        int maxLimit = 7000000;
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
            //cg.printList();
        }
        return found;
    }


    @Test
    void testDouble() {
        for (int i = 1; i < 8; i++) {
            assertThat(checkDouble(i)).isFalse();
        }
    }

    private static boolean checkDouble(int currentLength) {
        int[] arr;
        CombinationGeneratorNew cg = new CombinationGeneratorNew(currentLength);
        for (int i = 0; i < 100; i++) {
            arr = cg.generate();
            for (int j = 0; j < currentLength - 1; j++) {
                for (int k = j + 1; k < currentLength; k++) {

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
        for (int i = 1; i < 7; i++) {
            assertThat(checkIfTheSame(i)).isTrue();
        }
    }

    private boolean checkIfTheSame(int currentLength) {
        int[] arr2;
        int[] arr3;

        CombinationGeneratorNew cg = new CombinationGeneratorNew(currentLength);
        CombinationGeneratorNew cg1 = new CombinationGeneratorNew(currentLength);
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
