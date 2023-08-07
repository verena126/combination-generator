import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;


public class CombinationGenerator {
    private final int size;


    private int[] arr;
    private int last;
    private int secondLast;
    private int currentLimit;
    private int[] currentArr;
    private int currentIndex;
    private boolean goDown = false;


    public CombinationGenerator(int size) {
        this.size = size;
        currentLimit = 1;
        last = size;
        secondLast = size - 1;
        arr = setUpArray(size);
        currentArr = new int[]{1, 2};
        currentIndex = 3;
    }


    public int[] generate() {
        return generateNumbers();

    }


    private int[] generateNumbers() {


        // Array with length == 1
        if (arr.length == 1) {
            arr[0] = last;
            last++;
            return arr;
        }

        //Array with length>1(last two index)
        else { //normal ; No limit reached
            if (goDown == false) {
                for (int i = secondLast; i < currentLimit; i++) {
                    arr[arr.length - 2] = i;
                    for (int j = last; j < currentLimit + 1; j++) {
                        arr[arr.length - 1] = j;
                        if (checkNumber(arr) == false) {
                            last = j + 1;
                            //if (isDouble(arr, currentArr) ==false) {
                            currentArr = arr;
                            return arr;
                            //}
                        }
                    }
                    secondLast = currentLimit;
                    last = 1;
                    if (currentLimit >= 3 && i == currentLimit - 1) {
                        i = currentLimit + 1;
                    }
                }

            } else {
                //limit reached --> secondLast part again ==1; while last part of array== currentLimit
                if (secondLast < currentLimit - 1) {
                    do {
                        arr[arr.length - 2] = secondLast;
                        arr[arr.length - 1] = currentLimit - 1;
                        secondLast++;
                    }
                    while (checkNumber(arr) != false && arr[arr.length - 2] < currentLimit);
                    if (currentLimit > 4) { // needed, because otherwise [2,3] is twice
                        return arr;
                    } else {
                        if (arr[arr.length - 2] != 2) {
                            return arr;
                        }
                        return generateNumbers();
                    }

                }// array second last part again at currentLimit/ every Combination with last Part== currentLimit
                else {
                    goDown = false;

                    last = 1;
                    return generateNumbers();

                }
            }


        }
        //more than length 3;
        if (size > 2) {
            if (arr[arr.length - currentIndex] < currentLimit / 2) {
                currentLimit = 2;
                arr[arr.length - currentIndex] = arr[arr.length - currentIndex] + 1;
            } else {
                if (currentIndex < arr.length) {
                    currentIndex++;
                    if (arr[arr.length - currentIndex] < currentLimit) {
                        arr[arr.length - currentIndex] = arr[arr.length - currentIndex] + 1;
                    }
                    currentIndex = 3;
                    currentLimit = 2;
                }
            }
        }

        //currentLimit reached--> secondlast back to 1; all combos with new currentLimit at the last part of array
        ++this.currentLimit;
        if (currentLimit > 3) {
            secondLast = 1;
            last = this.currentLimit - 1;
            goDown = true;
        }else{

        }


        return generateNumbers();

    }

    private boolean isDouble(int[] arr, int[] currentArr) {
        boolean isdouble = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != currentArr[i]) {
                return false;
            }
        }
        return isdouble;
    }


    private static String toString(int[] arr) {
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i] + " ";
        }
        return s;
    }

    private static boolean checkNumber(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[i] == arr[k]) {
                    return true;
                }
            }
        }
        return false;
    }


    private static int[] setUpArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i + 1;
        }
        return arr;

    }


}
