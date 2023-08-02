import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CombinationGeneratorTest {

    private CombinationGenerator cg2;
    private CombinationGenerator cg3;
    private CombinationGenerator cg4;


    @BeforeEach
    void setup() {
        cg2 = new CombinationGenerator(2);
        cg3 = new CombinationGenerator(3);
        cg4 = new CombinationGenerator(4);


    }

    @Test
    void arrayIsInitalized() {
        var a2_1 = cg2.generate();
        assertThat(a2_1).contains(1, 2);
        var a3_1 = cg3.generate();
        assertThat(a3_1).contains(1, 2, 3);
    }


    @Test
    void testFirstElements() {

        var a2_1 = cg2.generate();
        assertThat(a2_1).contains(1, 2);

        var a2_2 = cg2.generate();
        assertThat(a2_2).contains(2, 1);


        var a2_3 = cg2.generate();
        assertThat(a2_3).contains(2, 3);

        var a3_1 = cg3.generate();
        assertThat(a3_1).contains(1, 2, 3);
        var a3_2 = cg3.generate();
        assertThat(a3_2).contains(1, 3, 2);
        var a3_3 = cg3.generate();
        assertThat(a3_3).contains(1, 3, 4);

    }

    @Test
    void testGenerateWithTwoElements() {
        assertThat(tryFind(new int[]{2, 10}, cg2)).isTrue();
        assertThat(tryFind(new int[]{12, 4}, cg2)).isTrue();
        assertThat(tryFind(new int[]{19, 1}, cg2)).isTrue();

        assertThat(tryFind(new int[]{2, 2}, cg2)).isFalse();
        assertThat(tryFind(new int[]{12, 12}, cg2)).isFalse();
        assertThat(tryFind(new int[]{19, 19}, cg2)).isFalse();

    }

    private boolean tryFind(int[] toFound, CombinationGenerator cg) {
        cg= new CombinationGenerator(toFound.length);
        int maxLimit = 4000;
        boolean found = false;
        int step = 0;
        boolean found2 = false;
        while (found == false & step < maxLimit) {
            //cg.printList();
            int[] res = cg.generate();
            found=false;
            for (int i = 0; i < toFound.length; i++) {
                found=true;
                if (toFound[i] != res[i]) {
                    found = false;
                    break;
                }
        }
            //cg.printList();
        step++;
    }
        return found;
}

    @Test
    void testGenerateWithThreeElements() {

        assertThat(tryFind(new int[]{1, 2, 3}, cg3)).isTrue();
        assertThat(tryFind(new int[]{3,5, 7}, cg3)).isTrue();
        assertThat(tryFind(new int[]{7, 1, 6}, cg3)).isTrue();

        assertThat(tryFind(new int[]{3, 10, 3}, cg3)).isFalse();
        assertThat(tryFind(new int[]{24, 1,1}, cg3)).isFalse();
        assertThat(tryFind(new int[]{1, 1, 33}, cg3)).isFalse();
    }

    @Test
    void testGenerateWithFourElements() {

        assertThat(tryFind(new int[]{1, 10, 4, 30}, cg4)).isTrue();
        assertThat(tryFind(new int[]{24, 13, 26, 6}, cg4)).isTrue();
        assertThat(tryFind(new int[]{12, 1, 24, 2}, cg4)).isTrue();

        assertThat(tryFind(new int[]{55, 10, 4, 10}, cg3)).isFalse();
        assertThat(tryFind(new int[]{24, 100, 99, 24}, cg3)).isFalse();
        assertThat(tryFind(new int[]{33, 1, 53, 53}, cg3)).isFalse();
    }


}
