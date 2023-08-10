public class CombinationGenerator {
    private final int size;
    private final int[] arr;
    private int last;
    private int secondLast;
    private int currentLimit;
    private int currentIndex;
    private int temp = 1;
    private boolean activateIterateThroughSecondLast = false;


    private boolean activateIterateThroughLast = false;
    private int currentMaxLimitForLast;
    private int currentLimitForLast;
    private int maxLimitForLast3;

    private boolean iterateWithNew = false;

    private int maxLimit = 1;
    private int currentLimitAtFirstIndex = 3;
    private int l1 = 1;


    public CombinationGenerator(int size) {
        this.size = size;
        if (size > 2) {
            currentLimit = size + 1;
        } else {
            currentLimit = 1;
        }
        last = size;
        secondLast = size - 1;
        arr = setUpArray(size);
        currentIndex = 3;
    }


    public int[] generate() {
        if (arr.length == 1) {
            return generateArrayWithLengthOne();
        } else {
            return generateNumbers();
        }
    }

    // Array with length == 1
    private int[] generateArrayWithLengthOne() {
        arr[0] = ++last;
        return arr;
    }


    //Array with length>1(last two index) // mainly for array with two elements
    private int[] generateNumbers() {
        if (size > 2) {
            temp = arr[2] / 2;

            if (iterateWithNew) {
                return iterateWhileLastEqualsLimit(l1);
            }
            if (activateIterateThroughLast) {
                return iterateThroughTheLastElement(currentMaxLimitForLast, currentLimitForLast, maxLimitForLast3);
            }
        }

        if (activateIterateThroughSecondLast) { // limit reached --> go back to one with secondLast and to currentLimit with last;
            if (arr[arr.length - 1] == currentLimit) {
                last = 1;
                secondLast = 1;
            }
            return iterateThroughSecondLastPart();
        }
        //normal ; No limit reached
        else {
            for (int i = secondLast; i < currentLimit; i++) {
                arr[arr.length - 2] = i;
                for (int j = last; j < currentLimit + 1; j++) {
                    arr[arr.length - 1] = j;
                    if (!checkNumber(arr)) {
                        last = j + 1;
                        secondLast = i;
                        return arr;
                    }
                }
                secondLast = currentLimit - 1;
                last = 1;
                if (currentLimit >= 3 && i == currentLimit - 1) {
                    i = secondLast;
                }
            }
        }

        if (currentLimit > 5) {
            activateIterateThroughLast = true;
            currentLimitForLast = 1;
            currentMaxLimitForLast = currentLimit - 1;
            maxLimitForLast3 = currentLimit - 1;
        }
        //more than length three;
        if (size > 2) {
            if (size > 3) {
                if (arr[arr.length - 3] >= currentLimitAtFirstIndex) {
                    iterateIndexAtFirstPlace();
                } else {
                    arr[arr.length - 3] = 1;
                }
            }
            //arr[0] hochsetzen bis temp-1 reached entspricht max;
            if (arr[arr.length - currentIndex] >= temp / 2) {
                currentIndex = 3;
                currentLimit = currentLimit + 1;

                if (arr[arr.length - 1] >= 1) {
                    arr[arr.length - currentIndex] = arr[arr.length - currentIndex] + 1;
                }
                secondLast = 1;
                last = 1;
                return generateNumbers();
            } else {
                currentLimit++;
                //array with length 4 or more
                // for iterating through last index
                /*if (currentLimit < 5) {
                    currentLimit = maxLimit;
                }*/
                if (size == 3) {
                    currentIndex = size;
                } else {
                    currentIndex = size - 1;
                }
            }
        }

        //currentLimit reached--> secondlast back to 1; all combos with new currentLimit at the last part of array
        ++this.currentLimit;
        if (currentLimit > 2) {
            activateIterateThroughSecondLast = true;
        }
        if (maxLimit < currentLimit) {
            maxLimit = currentLimit;
        }
        if (currentLimit == maxLimit) {
            if (currentLimit > 3) {
                secondLast = 1;
                last = currentLimit - 1;
            }
        }
        return generateNumbers();
    }

    private int[] iterateThroughTheLastElement(int lastIndex, int firstIndex, int maxLimit) { // change length-3 & the last Element while lenght-2 == limit

        if (currentLimit > 4) {

            for (int k = firstIndex; k < this.currentLimit - 3; k++) {  // von 1 bis limit-2
                for (int j = maxLimit - 1; j > maxLimit - 2; j--) { // bleibt auf limit
                    for (int m = lastIndex; m > 0; m--) {                     // von limit bis 1 runterzählen
                        arr[arr.length - 3] = k;
                        arr[arr.length - 2] = j;
                        arr[arr.length - 1] = m;
                        --currentMaxLimitForLast; // testMethod1 == maxLimit/wird immer 1 heruntergesetzt

                        if (!checkNumber(arr)) {
                            return arr;
                        }
                    }
                    lastIndex = this.currentLimit - 1;
                    currentMaxLimitForLast = this.currentLimit - 1;
                    maxLimitForLast3--;
                    //return iterateThroughSecondLastPart();
                }
                currentLimitForLast++;
                maxLimitForLast3++;
                maxLimit = maxLimitForLast3;
            }
            arr[arr.length - 3] = currentLimit - 2;
            arr[arr.length - 2] = 1;
            arr[arr.length - 1] = 1;
        }
        secondLast = 1;
        last = 1;
        arr[arr.length - 3] = 1;
        l1 = 1;
        iterateWithNew = true;
        activateIterateThroughLast = false;

        return generateNumbers();
    }

    private int[] iterateWhileLastEqualsLimit(int i) { // iterate at( length-3) while length-2=1 and length-1= limit

        arr[arr.length - 2] = i;
        arr[arr.length - 1] = currentLimit - 1;

        if (arr[arr.length - 3] < currentLimit && i < currentLimit) {
            arr[arr.length - 3] = arr[arr.length - 3] + 1;
            if (!checkNumber(arr)) {
                return arr;
            }
        } else if (i < currentLimit) {
            arr[arr.length - 3] = 1;
            arr[arr.length - 1] = 1;
            ++l1;
            arr[arr.length - 2] = l1;


        } else {
            iterateWithNew = false;
            arr[arr.length - 3] = currentLimit - 2;
            arr[arr.length - 1] = 1;
            arr[arr.length - 2] = 1;
            secondLast = 1;
            last = 1;
        }
        return generateNumbers();
    }

    private int[] iterateThroughSecondLastPart() {
        //limit reached --> secondLast part again == 1(iterate here); while last part of array== currentLimit [?,limit]
        if (secondLast < currentLimit - 2) {
            do {
                arr[arr.length - 2] = secondLast;
                arr[arr.length - 1] = currentLimit - 1;
                secondLast++;
            } while (checkNumber(arr) && arr[arr.length - 2] < currentLimit);

            if (currentLimit > size + 2) { // needed, because otherwise [2,3] is twice
                return arr;
            } else {
                if ((size > 2 && arr[arr.length - 2] != 2 && arr[arr.length - 2] != 3) || (currentLimit > 3 && arr[arr.length - 2] != 2)) {
                    if (!checkNumber(arr)) {
                        return arr;
                    }
                }
                return generateNumbers();
            }
        }// array second last part again at currentLimit/ every Combination with last Part== currentLimit

        else {
            // secondLast = currentLimit;
            activateIterateThroughSecondLast = false;
            secondLast = currentLimit - 1;
            last = 1;
            return generateNumbers();

        }
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

    private void iterateIndexAtFirstPlace() { // currentIndex++; // for Array length>3
        if (arr.length > currentIndex && arr.length > 3) {
            if (currentIndex < arr.length && arr[arr.length - currentIndex] > currentLimit / 3) {
                currentIndex++;
            }

            arr[arr.length - currentIndex] = arr[arr.length - currentIndex] + 1;
            // set Array on back to 1 with new currentIndex;
            for (int i = 1; i < arr.length; i++) {
                arr[arr.length - i] = i;

            }
            currentLimit = 2;


            if (arr[arr.length - 4] > currentLimitAtFirstIndex) {
                currentLimitAtFirstIndex = arr[arr.length - 4];

            }
            currentIndex = 3;
            last = 1;
            secondLast = 1;


        }
    }


    private void goDownWithNewIndex() { // firstIndex== 1, while rest iteratesWith limit -2
        arr[arr.length - currentIndex] = 1;

    }
}
