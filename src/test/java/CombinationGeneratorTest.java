import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CombinationGeneratorTest {
    private PermutationGeneratorNew cg1;
    private PermutationGeneratorNew cg2;
    private PermutationGeneratorNew cg3;
    private PermutationGeneratorNew cg4;
    private PermutationGeneratorNew cg5;
    private PermutationGeneratorNew cg6;
    private PermutationGeneratorNew cg7;


    @BeforeEach
    void setup() {

        cg1 = new PermutationGeneratorNew(1);
        cg2 = new PermutationGeneratorNew(2);
        cg3 = new PermutationGeneratorNew(3);
        cg4 = new PermutationGeneratorNew(4);
        cg5 = new PermutationGeneratorNew(5);
        cg6 = new PermutationGeneratorNew(6);
        cg7 = new PermutationGeneratorNew(7);
    }

    @Test
    void testCombinationGenerator() {
        for (int i = 0; i < 20; i++) {
            int[] res = cg1.next();
            System.out.println(Arrays.toString(res));
        }
    }

    @Test
    void arrayIsInitalized() {
        var a1_1 = cg1.next();
        assertThat(a1_1).contains(1);
        var a2_1 = cg2.next();
        assertThat(a2_1).contains(1, 2);
        var a3_1 = cg3.next();
        assertThat(a3_1).contains(1, 2, 3);
        var a4_1 = cg4.next();
        assertThat(a4_1).contains(1, 2, 3, 4);
        var a5_1 = cg5.next();
        assertThat(a5_1).contains(1, 2, 3, 4, 5);
        var a6_1 = cg6.next();
        assertThat(a6_1).contains(1, 2, 3, 4, 5, 6);
        var a7_1 = cg7.next();
        assertThat(a7_1).contains(1, 2, 3, 4, 5, 6, 7);
    }


    @Test
    void testFirstElements() {
        var a2_1 = cg2.next();
        assertThat(a2_1).contains(1, 2);
        var a2_2 = cg2.next();
        assertThat(a2_2).contains(2, 1);
        var a2_3 = cg2.next();
        assertThat(a2_3).contains(2, 3);
        var a2_4 = cg2.next();
        assertThat(a2_4).contains(1, 3);
        var a2_5 = cg2.next();
        assertThat(a2_5).contains(3, 1);
        var a2_6 = cg2.next();
        assertThat(a2_6).contains(3, 2);
        var a2_7 = cg2.next();
        assertThat(a2_7).contains(3, 4);
        var a2_8 = cg2.next();
        assertThat(a2_8).contains(1, 4);
    }

    @Test
    void testFirstElementsForSizeThree() {
        var a3_1 = cg3.next();
        assertThat(a3_1).contains(1, 2, 3);
        var a3_2 = cg3.next();
        assertThat(a3_2).contains(1, 3, 2);
        var a3_3 = cg3.next();
        assertThat(a3_3).contains(2, 1, 3);
        var a3_4 = cg3.next();
        assertThat(a3_4).contains(2, 3, 1);
        var a3_5 = cg3.next();
        assertThat(a3_5).contains(3, 1, 2);
        var a3_6 = cg3.next();
        assertThat(a3_6).contains(3, 2, 1);
        var a3_7 = cg3.next();
        assertThat(a3_7).contains(1, 2, 4);
        var a3_8 = cg3.next();
        assertThat(a3_8).contains(1, 4, 2);
    }

    @Test
    void testFirstElementsForSizeFour() {
        var a4_1 = cg4.next();
        assertThat(a4_1).contains(1, 2, 3, 4);
        var a4_2 = cg4.next();
        assertThat(a4_2).contains(1, 2, 4, 3);
        var a4_3 = cg4.next();
        assertThat(a4_3).contains(1, 3, 2, 4);
        var a4_4 = cg4.next();
        assertThat(a4_4).contains(1, 3, 4, 2);
        var a4_5 = cg4.next();
        assertThat(a4_5).contains(1, 4, 2, 3);
        var a4_6 = cg4.next();
        assertThat(a4_6).contains(1, 4, 3, 2);
    }

    @Test
    void testFirstElementsForSizeFive() {
        var a5_1 = cg5.next();
        assertThat(a5_1).contains(1, 2, 3, 4, 5);
        var a5_2 = cg5.next();
        assertThat(a5_2).contains(1, 2, 3, 5, 4);
        var a5_3 = cg5.next();
        assertThat(a5_3).contains(1, 2, 4, 3, 5);
        var a5_4 = cg5.next();
        assertThat(a5_4).contains(1, 2, 4, 5, 3);
        var a5_5 = cg5.next();
        assertThat(a5_5).contains(1, 2, 5, 3, 4);
        var a5_6 = cg5.next();
        assertThat(a5_6).contains(1, 2, 5, 4, 3);
    }

    @Test
    void testFirstElementsForSizeSix() {
        var a6_1 = cg6.next();
        assertThat(a6_1).contains(1, 2, 3, 4, 5, 6);
        var a6_2 = cg6.next();
        assertThat(a6_2).contains(1, 2, 3, 4, 6, 5);
        var a6_3 = cg6.next();
        assertThat(a6_3).contains(1, 2, 3, 5, 4, 6);
        var a6_4 = cg6.next();
        assertThat(a6_4).contains(1, 2, 3, 5, 6, 4);
        var a6_5 = cg6.next();
        assertThat(a6_5).contains(1, 2, 3, 6, 4, 5);
    }

    @Test
    void testGenerateWithTwoElements() {
        assertThat(tryFind(new int[]{2, 10})).isTrue();
        assertThat(tryFind(new int[]{12, 86})).isTrue();
        assertThat(tryFind(new int[]{19, 1})).isTrue();
        assertThat(tryFind(new int[]{4, 10})).isTrue();
        assertThat(tryFind(new int[]{12, 23})).isTrue();
        assertThat(tryFind(new int[]{5, 1})).isTrue();
        assertThat(tryFind(new int[]{6, 19})).isTrue();
        assertThat(tryFind(new int[]{22, 4})).isTrue();
        assertThat(tryFind(new int[]{32, 17})).isTrue();
        assertThat(tryFind(new int[]{8, 15})).isTrue();
        assertThat(tryFind(new int[]{12, 2})).isTrue();
        assertThat(tryFind(new int[]{93, 15})).isTrue();
        assertThat(tryFind(new int[]{23, 12})).isTrue();
        assertThat(tryFind(new int[]{95, 18})).isTrue();
        assertThat(tryFind(new int[]{19, 5})).isTrue();
        assertThat(tryFind(new int[]{2, 1})).isTrue();
        assertThat(tryFind(new int[]{13, 5})).isTrue();
        assertThat(tryFind(new int[]{17, 3})).isTrue();
        assertThat(tryFind(new int[]{7, 10})).isTrue();
        assertThat(tryFind(new int[]{18, 5})).isTrue();
        assertThat(tryFind(new int[]{18, 99})).isTrue();
    }

    @Test
    void testGenerateWithTwoElementsNegative() {
        assertThat(tryFind(new int[]{2, 2})).isFalse();
        assertThat(tryFind(new int[]{12, 12})).isFalse();
        assertThat(tryFind(new int[]{19, 19})).isFalse();
        assertThat(tryFind(new int[]{5, 5})).isFalse();
        assertThat(tryFind(new int[]{17, 17})).isFalse();
        assertThat(tryFind(new int[]{21, 21})).isFalse();
        assertThat(tryFind(new int[]{1, 1})).isFalse();
        assertThat(tryFind(new int[]{6, 6})).isFalse();
        assertThat(tryFind(new int[]{7, 7})).isFalse();
        assertThat(tryFind(new int[]{8, 8})).isFalse();
        assertThat(tryFind(new int[]{15, 15})).isFalse();
        assertThat(tryFind(new int[]{24, 24})).isFalse();
        assertThat(tryFind(new int[]{25, 25})).isFalse();
        assertThat(tryFind(new int[]{3, 3})).isFalse();
        assertThat(tryFind(new int[]{4, 4})).isFalse();
        assertThat(tryFind(new int[]{9, 9})).isFalse();
        assertThat(tryFind(new int[]{10, 10})).isFalse();
        assertThat(tryFind(new int[]{11, 11})).isFalse();
        assertThat(tryFind(new int[]{28, 28})).isFalse();
        assertThat(tryFind(new int[]{30, 0})).isFalse();
    }


    @Test
    void testGenerateWithThreeElements() {
        assertThat(tryFind(new int[]{1, 2, 3})).isTrue();
        assertThat(tryFind(new int[]{3, 5, 7})).isTrue();
        assertThat(tryFind(new int[]{7, 1, 6})).isTrue();
        assertThat(tryFind(new int[]{4, 5, 1})).isTrue();
        assertThat(tryFind(new int[]{12, 18, 4})).isTrue();
        assertThat(tryFind(new int[]{50, 1, 2})).isTrue();
        assertThat(tryFind(new int[]{68, 19, 16})).isTrue();
        assertThat(tryFind(new int[]{22, 4, 3})).isTrue();
        assertThat(tryFind(new int[]{32, 1, 6})).isTrue();
        assertThat(tryFind(new int[]{8, 15, 5})).isTrue();
        assertThat(tryFind(new int[]{12, 2, 11})).isTrue();
        assertThat(tryFind(new int[]{11, 15, 8})).isTrue();
        assertThat(tryFind(new int[]{23, 12, 9})).isTrue();
        assertThat(tryFind(new int[]{1, 18, 12})).isTrue();
        assertThat(tryFind(new int[]{19, 5, 1})).isTrue();
        assertThat(tryFind(new int[]{13, 5, 11})).isTrue();
        assertThat(tryFind(new int[]{17, 3, 14})).isTrue();
        assertThat(tryFind(new int[]{70, 10, 11})).isTrue();
        assertThat(tryFind(new int[]{18, 5, 1})).isTrue();
        assertThat(tryFind(new int[]{20, 1, 12})).isTrue();
        assertThat(tryFind(new int[]{3, 1, 16})).isTrue();
        assertThat(tryFind(new int[]{100, 99, 30})).isTrue();
    }

    @Test
    void testGenerateWithThreeElementsNegative() {
        assertThat(tryFind(new int[]{3, 10, 3})).isFalse();
        assertThat(tryFind(new int[]{24, 1, 1})).isFalse();
        assertThat(tryFind(new int[]{1, 1, 33})).isFalse();
        assertThat(tryFind(new int[]{5, 10, 5})).isFalse();
        assertThat(tryFind(new int[]{24, 24, 1})).isFalse();
        assertThat(tryFind(new int[]{1, 8, 1})).isFalse();
        assertThat(tryFind(new int[]{2, 20, 2})).isFalse();
        assertThat(tryFind(new int[]{4, 4, 13})).isFalse();
        assertThat(tryFind(new int[]{5, 5, 5})).isFalse();
        assertThat(tryFind(new int[]{23, 11, 11})).isFalse();
        assertThat(tryFind(new int[]{14, 1, 14})).isFalse();
        assertThat(tryFind(new int[]{8, 8, 21})).isFalse();
        assertThat(tryFind(new int[]{7, 10, 7})).isFalse();
        assertThat(tryFind(new int[]{13, 13, 5})).isFalse();
        assertThat(tryFind(new int[]{64, 14, 64})).isFalse();
        assertThat(tryFind(new int[]{32, 3, 3})).isFalse();
        assertThat(tryFind(new int[]{12, 7, 7})).isFalse();
        assertThat(tryFind(new int[]{9, 9, 3})).isFalse();
        assertThat(tryFind(new int[]{6, 17, 6})).isFalse();
        assertThat(tryFind(new int[]{8, 8, 23})).isFalse();
    }

    @Test
    void testGenerateWithFourElements() {
        assertThat(tryFind(new int[]{1, 10, 48, 15})).isTrue();
        assertThat(tryFind(new int[]{12, 13, 26, 6})).isTrue();
        assertThat(tryFind(new int[]{12, 1, 24, 2})).isTrue();
        assertThat(tryFind(new int[]{3, 72, 11, 14})).isTrue();
        assertThat(tryFind(new int[]{17, 8, 19, 5})).isTrue();
        assertThat(tryFind(new int[]{19, 4, 1, 5})).isTrue();
        assertThat(tryFind(new int[]{1, 7, 8, 3})).isTrue();
        assertThat(tryFind(new int[]{5, 26, 1, 6})).isTrue();
        assertThat(tryFind(new int[]{1, 15, 35, 31})).isTrue();
        assertThat(tryFind(new int[]{9, 2, 42, 1})).isTrue();
        assertThat(tryFind(new int[]{12, 4, 52, 1})).isTrue();
        assertThat(tryFind(new int[]{14, 5, 81, 2})).isTrue();
        assertThat(tryFind(new int[]{71, 4, 13, 3})).isTrue();
        assertThat(tryFind(new int[]{6, 16, 26, 36})).isTrue();
        assertThat(tryFind(new int[]{2, 24, 26, 28})).isTrue();
        assertThat(tryFind(new int[]{3, 61, 5, 23})).isTrue();
        assertThat(tryFind(new int[]{7, 2, 39, 13})).isTrue();
        assertThat(tryFind(new int[]{8, 23, 11, 29})).isTrue();
        assertThat(tryFind(new int[]{48, 2, 1, 5})).isTrue();
        assertThat(tryFind(new int[]{7, 15, 5, 23})).isTrue();
        assertThat(tryFind(new int[]{10, 20, 3, 1})).isTrue();
        assertThat(tryFind(new int[]{3, 89, 5, 23})).isTrue();
        assertThat(tryFind(new int[]{4, 3, 2, 1})).isTrue();
    }

    @Test
    void testGenerateWithFourElementsNegative() {
        assertThat(tryFind(new int[]{1, 0, 32, 5})).isFalse();
        assertThat(tryFind(new int[]{55, 10, 4, 10})).isFalse();
        assertThat(tryFind(new int[]{24, 100, 99, 24})).isFalse();
        assertThat(tryFind(new int[]{33, 1, 53, 53})).isFalse();
        assertThat(tryFind(new int[]{55, 55, 2, 2})).isFalse();
        assertThat(tryFind(new int[]{24, 24, 1, 2})).isFalse();
        assertThat(tryFind(new int[]{33, 1, 53, 1})).isFalse();
        assertThat(tryFind(new int[]{2, 2, 5, 4})).isFalse();
        assertThat(tryFind(new int[]{6, 6, 12, 1})).isFalse();
        assertThat(tryFind(new int[]{4, 4, 5, 1})).isFalse();
        assertThat(tryFind(new int[]{61, 42, 1, 1})).isFalse();
        assertThat(tryFind(new int[]{1, 15, 12, 15})).isFalse();
        assertThat(tryFind(new int[]{3, 3, 24, 1})).isFalse();
        assertThat(tryFind(new int[]{2, 2, 10, 6})).isFalse();
        assertThat(tryFind(new int[]{3, 7, 12, 3})).isFalse();
        assertThat(tryFind(new int[]{7, 4, 2, 7})).isFalse();
        assertThat(tryFind(new int[]{17, 34, 21, 17})).isFalse();
        assertThat(tryFind(new int[]{8, 3, 12, 12})).isFalse();
        assertThat(tryFind(new int[]{36, 5, 5, 2})).isFalse();
        assertThat(tryFind(new int[]{1, 14, 12, 1})).isFalse();
        assertThat(tryFind(new int[]{7, 7, 43, 2})).isFalse();
        assertThat(tryFind(new int[]{8, 2, 8, 1})).isFalse();
    }

    @Test
    void testGenerateWithFiveElements() {
        assertThat(tryFind(new int[]{2, 5, 4, 3, 1})).isTrue();
        assertThat(tryFind(new int[]{1, 5, 4, 3, 2})).isTrue();
        assertThat(tryFind(new int[]{3, 4, 5, 2, 1})).isTrue();
        assertThat(tryFind(new int[]{1, 5, 4, 3, 6})).isTrue();
        assertThat(tryFind(new int[]{2, 5, 16, 3, 1})).isTrue();
        assertThat(tryFind(new int[]{3, 4, 6, 1, 2})).isTrue();
        assertThat(tryFind(new int[]{1, 3, 6, 2, 7})).isTrue();
        assertThat(tryFind(new int[]{4, 3, 7, 2, 1})).isTrue();
        assertThat(tryFind(new int[]{1, 5, 2, 3, 9})).isTrue();
        assertThat(tryFind(new int[]{1, 2, 8, 3, 5})).isTrue();
        assertThat(tryFind(new int[]{6, 5, 4, 3, 2})).isTrue();
        assertThat(tryFind(new int[]{1, 3, 4, 2, 12})).isTrue();
        assertThat(tryFind(new int[]{3, 6, 2, 4, 7})).isTrue();
        assertThat(tryFind(new int[]{2, 3, 1, 8, 10})).isTrue();
        assertThat(tryFind(new int[]{1, 3, 4, 10, 2})).isTrue();
        assertThat(tryFind(new int[]{2, 3, 5, 6, 1})).isTrue();
        assertThat(tryFind(new int[]{4, 1, 10, 8, 2})).isTrue();
        assertThat(tryFind(new int[]{1, 6, 2, 10, 12})).isTrue();
        assertThat(tryFind(new int[]{7, 1, 4, 3, 2})).isTrue();
        assertThat(tryFind(new int[]{4, 2, 12, 3, 6})).isTrue();
        assertThat(tryFind(new int[]{1, 5, 4, 16, 8})).isTrue();
        assertThat(tryFind(new int[]{4, 1, 10, 50, 2})).isTrue();
    }


    @Test
    void testGenerateWithFiveElementsNegative() {
        assertThat(tryFind(new int[]{55, 10, 4, 10, 1})).isFalse();
        assertThat(tryFind(new int[]{55, 5, 4, 55, 1})).isFalse();
        assertThat(tryFind(new int[]{5, 3, 4, 10, 3})).isFalse();
        assertThat(tryFind(new int[]{5, 1, 4, 11, 4})).isFalse();
        assertThat(tryFind(new int[]{4, 3, 3, 12, 2})).isFalse();
        assertThat(tryFind(new int[]{3, 5, 2, 13, 2})).isFalse();
        assertThat(tryFind(new int[]{2, 7, 1, 14, 7})).isFalse();
        assertThat(tryFind(new int[]{1, 9, 4, 15, 1})).isFalse();
        assertThat(tryFind(new int[]{6, 7, 3, 16, 6})).isFalse();
        assertThat(tryFind(new int[]{5, 5, 2, 17, 12})).isFalse();
        assertThat(tryFind(new int[]{4, 3, 1, 18, 4})).isFalse();
        assertThat(tryFind(new int[]{3, 1, 4, 19, 3})).isFalse();
        assertThat(tryFind(new int[]{2, 3, 3, 2, 15})).isFalse();
        assertThat(tryFind(new int[]{1, 5, 2, 3, 5})).isFalse();
        assertThat(tryFind(new int[]{6, 7, 1, 4, 7})).isFalse();
        assertThat(tryFind(new int[]{5, 9, 4, 5, 9})).isFalse();
        assertThat(tryFind(new int[]{4, 7, 3, 6, 4})).isFalse();
        assertThat(tryFind(new int[]{3, 5, 2, 7, 3})).isFalse();
        assertThat(tryFind(new int[]{2, 3, 1, 8, 2})).isFalse();
        assertThat(tryFind(new int[]{1, 1, 4, 9, 15})).isFalse();

    }

    @Test
    void testGenerateWithSixElements() {
        assertThat(tryFind(new int[]{1, 2, 3, 5, 6, 4})).isTrue();
        assertThat(tryFind(new int[]{2, 1, 3, 5, 6, 4})).isTrue();
        assertThat(tryFind(new int[]{2, 1, 5, 3, 6, 4})).isTrue();
        assertThat(tryFind(new int[]{1, 4, 3, 6, 5, 2})).isTrue();
        assertThat(tryFind(new int[]{3, 1, 2, 5, 6, 4})).isTrue();
        assertThat(tryFind(new int[]{1, 5, 2, 3, 9, 4})).isTrue();
        assertThat(tryFind(new int[]{1, 2, 8, 3, 5, 10})).isTrue();
        assertThat(tryFind(new int[]{6, 5, 4, 3, 2, 1})).isTrue();
        assertThat(tryFind(new int[]{1, 3, 4, 2, 12, 5})).isTrue();
        assertThat(tryFind(new int[]{3, 6, 2, 4, 7, 1})).isTrue();
        assertThat(tryFind(new int[]{2, 3, 1, 8, 10, 6})).isTrue();
        assertThat(tryFind(new int[]{1, 3, 4, 10, 2, 8})).isTrue();
        assertThat(tryFind(new int[]{2, 3, 5, 6, 1, 7})).isTrue();
        assertThat(tryFind(new int[]{4, 1, 10, 8, 2, 3})).isTrue();
        assertThat(tryFind(new int[]{1, 6, 2, 10, 12, 4})).isTrue();
        assertThat(tryFind(new int[]{7, 1, 4, 3, 2, 5})).isTrue();
        assertThat(tryFind(new int[]{4, 2, 12, 3, 6, 1})).isTrue();
        assertThat(tryFind(new int[]{1, 5, 4, 16, 8, 10})).isTrue();
        assertThat(tryFind(new int[]{22, 1, 2, 3, 4, 5})).isTrue();
    }

    @Test
    void testGenerateWithSixElementsNegative() {
        assertThat(tryFind(new int[]{55, 10, 4, 10, 1, 2})).isFalse();
        assertThat(tryFind(new int[]{1, 9, 4, 7, 1, 3})).isFalse();
        assertThat(tryFind(new int[]{2, 3, 4, 3, 1, 5})).isFalse();
        assertThat(tryFind(new int[]{1, 8, 8, 6, 2, 3})).isFalse();
        assertThat(tryFind(new int[]{2, 7, 3, 2, 5, 9})).isFalse();
        assertThat(tryFind(new int[]{6, 7, 3, 16, 6, 14})).isFalse();
        assertThat(tryFind(new int[]{5, 5, 2, 17, 12, 15})).isFalse();
        assertThat(tryFind(new int[]{4, 3, 1, 18, 4, 12})).isFalse();
        assertThat(tryFind(new int[]{3, 1, 4, 19, 3, 11})).isFalse();
        assertThat(tryFind(new int[]{2, 3, 3, 2, 15, 10})).isFalse();
        assertThat(tryFind(new int[]{1, 5, 2, 3, 5, 4})).isFalse();
        assertThat(tryFind(new int[]{6, 7, 1, 4, 7, 2})).isFalse();
        assertThat(tryFind(new int[]{5, 9, 4, 5, 9, 10})).isFalse();
        assertThat(tryFind(new int[]{4, 7, 3, 6, 4, 8})).isFalse();
        assertThat(tryFind(new int[]{3, 5, 2, 7, 3, 6})).isFalse();
        assertThat(tryFind(new int[]{2, 3, 1, 8, 2, 3})).isFalse();
        assertThat(tryFind(new int[]{1, 1, 4, 9, 15, 12})).isFalse();
    }

    @Test
    void testGenerateWithSevenElements() {
        assertThat(tryFind(new int[]{2, 3, 4, 1, 5, 6, 7})).isTrue();
        assertThat(tryFind(new int[]{1, 5, 2, 3, 9, 4, 6})).isTrue();
        assertThat(tryFind(new int[]{1, 2, 8, 3, 5, 10, 4})).isTrue();
        assertThat(tryFind(new int[]{6, 5, 4, 3, 2, 1, 7})).isTrue();
        assertThat(tryFind(new int[]{1, 3, 4, 2, 12, 5, 6})).isTrue();
        assertThat(tryFind(new int[]{3, 6, 2, 4, 7, 1, 8})).isTrue();
        assertThat(tryFind(new int[]{2, 3, 1, 8, 10, 6, 9})).isTrue();
        assertThat(tryFind(new int[]{1, 3, 4, 10, 2, 8, 5})).isTrue();
        assertThat(tryFind(new int[]{2, 3, 5, 6, 1, 7, 4})).isTrue();
        assertThat(tryFind(new int[]{4, 1, 10, 8, 2, 3, 9})).isTrue();
        assertThat(tryFind(new int[]{1, 6, 2, 10, 12, 4, 11})).isTrue();
        assertThat(tryFind(new int[]{7, 1, 4, 3, 2, 5, 6})).isTrue();
        assertThat(tryFind(new int[]{4, 2, 12, 3, 6, 1, 5})).isTrue();
        assertThat(tryFind(new int[]{7, 6, 5, 4, 3, 2, 1})).isTrue();
    }


    @Test
    @Timeout(20)
    void testGenerateWithSevenElementsNegative() {
        assertThat(tryFind(new int[]{55, 10, 4, 10, 1, 2, 5})).isFalse();
        assertThat(tryFind(new int[]{1, 9, 4, 7, 1, 3, 0})).isFalse();
        assertThat(tryFind(new int[]{2, 3, 4, 3, 1, 5, 2})).isFalse();
        assertThat(tryFind(new int[]{1, 8, 8, 6, 2, 3, 1})).isFalse();
        assertThat(tryFind(new int[]{2, 7, 3, 2, 5, 9, 8})).isFalse();
        assertThat(tryFind(new int[]{6, 7, 3, 16, 6, 14, 14})).isFalse();
        assertThat(tryFind(new int[]{5, 5, 2, 17, 12, 15, 16})).isFalse();
        assertThat(tryFind(new int[]{4, 3, 1, 18, 4, 12, 5})).isFalse();
        assertThat(tryFind(new int[]{3, 1, 4, 19, 3, 11, 90})).isFalse();
        assertThat(tryFind(new int[]{2, 3, 3, 2, 15, 10, 46})).isFalse();
        assertThat(tryFind(new int[]{1, 5, 2, 3, 5, 4, 3})).isFalse();
        assertThat(tryFind(new int[]{6, 7, 1, 4, 7, 2, 34})).isFalse();
        assertThat(tryFind(new int[]{5, 9, 4, 5, 9, 10, 21})).isFalse();
        assertThat(tryFind(new int[]{4, 7, 3, 6, 4, 8, 90})).isFalse();
        assertThat(tryFind(new int[]{3, 5, 2, 7, 3, 6, 43})).isFalse();
        assertThat(tryFind(new int[]{2, 3, 1, 8, 2, 3, 23})).isFalse();
        assertThat(tryFind(new int[]{1, 1, 4, 9, 15, 12, 35})).isFalse();
    }


    private boolean tryFind(int[] toFound) {

            var cg = new PermutationGeneratorNew(toFound.length);
            boolean found = false;
            long startTime = System.currentTimeMillis();
            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.schedule(() -> {
                executorService.shutdownNow(); // Interrupt the test after 5 seconds
            }, 1, TimeUnit.SECONDS);
            while (!found) {
                int[] res = cg.next();
                found = true;
                for (int i = 0; i < toFound.length; i++) {
                    if (toFound[i] != res[i]) {
                        found = false;
                        break;
                    }
                }
                long currentTime = System.currentTimeMillis();
                if (toFound.length < 4) {
                    if (currentTime - startTime >= 1000) {
                        executorService.shutdownNow(); // Stop the scheduled task if the loop takes more than 3 seconds
                        return false;
                    }
                } else if(toFound.length<7) {
                    if (currentTime - startTime >= 30000) {
                        executorService.shutdownNow(); // Stop the scheduled task if the loop takes more than 40 seconds
                        return false;
                    }
                }else{
                    if (currentTime - startTime >= 2000) {
                        executorService.shutdownNow(); // Stop the scheduled task if the loop takes more than 40 seconds
                        return false;
                    }

                }
            }
            executorService.shutdown();
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
        PermutationGeneratorNew cg = new PermutationGeneratorNew(currentLength);
        for (int i = 0; i < 100; i++) {
            arr = cg.next();
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
        PermutationGeneratorNew cg = new PermutationGeneratorNew(currentLength);
        PermutationGeneratorNew cg1 = new PermutationGeneratorNew(currentLength);
        for (int i = 0; i < 100; i++) {
            arr2 = cg.next();
            arr3 = cg1.next();
            for (int k = 0; k < arr2.length; k++) {
                if (arr2[k] != arr3[k]) {
                    return false;
                }
            }
        }
        return true;
    }

}
