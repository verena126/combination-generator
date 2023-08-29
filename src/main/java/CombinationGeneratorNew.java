import java.util.ArrayList;

public class CombinationGeneratorNew {

    private final int size;
    private int[] arr;
    private int last;
    private int secondLast;
    private int currentLimit;
    private int maxLimit;
    private int currentIndex;
    private int pos;
    private int counter = 0;
    private int maxPermutation = 1;
    private int currentPermuationLimit;
    private ArrayList<ArrayList<Integer>> res;

    private boolean activateIterateThroughSecondLast = false;


    public CombinationGeneratorNew(int size) {
        this.size = size;
         if (size > 2) {
            currentLimit = size + 1;
            currentPermuationLimit = size;
        } else {
            currentLimit = 1;

        }
        last = size;
        secondLast = size - 1;
        arr = setUpArray(size);
        maxLimit = size + 1;
        currentIndex = size - 3;
        //reachedNewLimit = size;
        pos = size;
        for (int i = 1; i <= arr.length; i++) {
            maxPermutation *= i;
        }

    }

    private static int[] setUpArray(int length) {
        int[] arr2 = new int[length];
        for (int i = 0; i < length; i++) {
            arr2[i] = i + 1;
        }
        return arr2;
    }

    private static boolean checkIfNumberIsTwice(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[i] == arr[k]) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[] generate() {
        if (arr.length == 1) {
            return generateArrayWithLengthOne();
        } else if (size == 2) {
            return generateArrayWithLengthTwo();
        } else {
            return ArrayWithLengthMoreThanTwo();
        }
    }

    // Array with length == 1
    private int[] generateArrayWithLengthOne() {
        arr[0] = last++;
        return arr;
    }


    private int[] generateArrayWithLengthTwo() {
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
                    if (!checkIfNumberIsTwice(arr)) {
                        if (checkIfMaxLimit(arr) || maxLimit < 5) {
                            last = j + 1;
                            secondLast = i;
                            return arr;
                        }
                    }
                }
                secondLast = currentLimit - 1;
                last = 1;
                if (currentLimit >= 3 && i == currentLimit - 1) {
                    i = secondLast;
                }
            }
        }
        if (size <= 2) {
            currentLimit++;
        } else {
            return generateArrayWithLengthTwo();
        }
        if (currentLimit > 2) {
            activateIterateThroughSecondLast = true;
        }
        if (currentLimit > 3) {
            secondLast = 1;
            last = currentLimit - 1;
        }
        return generateArrayWithLengthTwo();

    }

    private int[] ArrayWithLengthMoreThanTwo() {

        if (counter == 0) {

            counter = 1;
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                nums.add(arr[i]);
            }

            res = permute(nums);
            if (res != null) {
                for (int i = 0; i < size; i++) {
                    arr[i] = res.get(0).get(i);
                }
            }
            if (checkIfNumberIsTwice(arr) != true) {
                return arr;
            } else {
                arr[0]++;
            }
            //Set<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        }
        if (counter < maxPermutation) {

            for (int i = 0; i < size; i++) {
                arr[i] = res.get(counter).get(i);
            }
            counter++;
            if (checkIfNumberIsTwice(arr) != true) {
                return arr;
            } else {
                arr[0]++;
            }
        } else if (counter >= maxPermutation) {
            // System.out.println(true);
            arr[0]++;
            if (arr[0] >= currentPermuationLimit && arr[arr.length - 1] < arr[0] - 2 && arr[1 ]!= 1) {
                arr[arr.length - 1]++;
                arr[arr.length - 2]=1;
                arr[0]--;
            }

            if (currentPermuationLimit < arr[0]) {
                currentPermuationLimit = arr[0];

                for (int j = 1; j < arr.length; j++) {
                    arr[j] = j;
                }
            }

        }

        counter = 0;
        return ArrayWithLengthMoreThanTwo();
    }

    private ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // Declaring result variable
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int x = nums.size() - 1;
        // Calling permutations for the first
        // time by passing l
        // as 0 and h = nums.size()-1
        permutations(res, nums, 0, x);
        return res;
    }

    private void permutations(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> nums, int l, int h) {
        if (l == h) {
            ArrayList<Integer> nums1 = new ArrayList<Integer>(nums);

            res.add(nums1);
            return;
        }
        for (int i = l; i <= h; i++) {

            // Swapping
            int left = nums.get(l);
            nums.set(l, nums.get(i));
            nums.set(i, left);

            // Calling permutations for
            // next greater value of l
            permutations(res, nums, l + 1, h);

            // Backtracking
            left = nums.get(l);
            nums.set(l, nums.get(i));
            nums.set(i, left);
        }
    }

    private boolean checkIfMaxLimit(int[] arr) {
        for (int i = 0; i < size; i++) {
            if (arr[i] >= maxLimit - 1) {
                return true;
            }
        }
        return false;
    }

    private int[] iterateThroughSecondLastPart() {
        //limit reached --> secondLast part again == 1(iterate here); while last part of array== currentLimit [?,limit]
        if (secondLast < currentLimit - 2) {
            do {
                arr[arr.length - 2] = secondLast;
                arr[arr.length - 1] = currentLimit - 1;
                secondLast++;
            } while (checkIfNumberIsTwice(arr) && arr[arr.length - 2] < currentLimit - 3);

            if (currentLimit > size + 2) { // needed, because otherwise [2,3] is twice
                return arr;
            } else {
                if ((size > 2 && arr[arr.length - 2] != 2 && arr[arr.length - 2] != 3) || (currentLimit > 3 && arr[arr.length - 2] != 2)) {
                    if (!checkIfNumberIsTwice(arr)) {
                        if (checkIfMaxLimit(arr) || maxLimit < 5) {
                            return arr;
                        }
                    }
                }
                return generateArrayWithLengthTwo();
            }
        }// array second last part again at currentLimit/ every Combination with last Part== currentLimit

        else {
            // secondLast = currentLimit;
            activateIterateThroughSecondLast = false;
            secondLast = currentLimit - 1;
            last = 1;
            return generateArrayWithLengthTwo();
        }
    }


}
