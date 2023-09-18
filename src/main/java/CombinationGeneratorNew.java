import java.util.ArrayList;

public class CombinationGeneratorNew {

    private final int size;
    private int[] arr;
    private int last;
    private int secondLast;
    private int currentLimit;
    private int maxLimit;
    ArrayList<ArrayList<Integer>> results = new ArrayList<>();
    private boolean activateIterateThroughSecondLast = false;


    public CombinationGeneratorNew(int size) {
        this.size = size;
        if (size > 2) {
            currentLimit = size + 1;
        } else {
            currentLimit = 1;
        }
        last = size;
        secondLast = size - 1;
        arr = setUpArray(size);
        maxLimit = size + 1;
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
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nums.add(arr[i]);
        }
        if (results.size() == 0) {
            boolean isTwice = false;
            for (int i = arr.length - 2; i >= 0; i--) {
                arr[i]++;
                if (checkIfNumberIsTwice(arr) == false) {
                    isTwice = true;
                    if (i == 0) {
                        for (int j = 1; j < arr.length - 1; j++) {
                            arr[j] = arr[i] + j;
                        }
                    } else if (i > 0 && i < arr.length - 2) {
                        for (int j = i + 1; j < arr.length - 1; j++) {
                            arr[j] = arr[j - 1] + 1;
                        }
                    }
                    break;
                } else {

                    arr[i]--;
                }
            }
            if (isTwice == false) {

                arr[arr.length - 1]++;
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = j + 1;
                }

            }
        }


        if (results.size() == 0) {
            results = permute(nums);
        } else if (results.size() > 0) {
            int[] array1 = new int[size];
            for (int i = 0; i < size; i++) {
                array1[i] = results.get(0).get(i);
            }
            results.remove(0);
            return array1;
        }
        return ArrayWithLengthMoreThanTwo();
    }

    private ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int x = nums.size() - 1;
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
