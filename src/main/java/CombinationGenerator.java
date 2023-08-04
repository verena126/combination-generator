import java.util.ArrayList;

import java.util.List;


public class CombinationGenerator {
    private final int size;
    private List<String> list;
    private int currentLimit;
    private int[] arr;


    public CombinationGenerator(int size) {
        this.size = size;
        list = new ArrayList<>();
        arr = setUpArray(size);

        if (size == 2) {
            currentLimit = 1;
        } else {
            currentLimit = 2;
        }
    }


    public int[] generate() {
        if (list.size() == 0) {
            list.add(toString(arr));
            return arr;
        } else {
            if (size > 4) {
                return generate(size - 1);
            }
            return generate(2);
        }
    }


    private int[] generate(int firstIndex) {
        int max = 3;
        int[] res = new int[arr.length];
        if (arr.length >= 2) {
            arr[arr.length - 2] = currentLimit;
        }

        // Array der Länge 1
        if (arr.length == 1) {
            for (int i = 1; i < currentLimit + 1; i++) {
                arr[arr.length - 1] = i;
                if (checkNumber(arr) == false) {

                    if (checkInList(arr) == false) {
                        list.add(toString(arr));
                        res = arr;
                        return res;
                    }
                }
            }
        }

        // for the last digit of the Array
        if (currentLimit >= 2 && arr.length > 1) {
            for (int k = 1; k <= currentLimit; k++) {
                arr[arr.length - 2] = k;
                for (int i = 1; i <= currentLimit; i++) {
                    arr[arr.length - 1] = i;
                    if (checkNumber(arr) == false) {
                        if (checkInList(arr) == false) {
                            list.add(toString(arr));
                            res = arr;
                            return res;
                        }
                    }
                }
            }
        }

        // Array with more than two elements
        if (arr.length > 2 && currentLimit > firstIndex) {


                while (arr[arr.length - firstIndex] >= currentLimit - 2 && arr.length > firstIndex) {
                    firstIndex++;
                    arr[arr.length - firstIndex] = arr[arr.length - firstIndex] + 1;
                }
                if (arr[arr.length - firstIndex] < currentLimit) {
                    while (firstIndex > 2) {
                        firstIndex--;
                        arr[arr.length - firstIndex] = 1;
                    }
                    return generate(firstIndex);
                }
        }
        currentLimit++;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;

        }
        if (size > 3) {
            firstIndex = 2;
        } else if (size == 3) {
            firstIndex = 4;
        }

        if (arr.length == 3 && currentLimit < max + 1) {
            arr[0] = 1;
            if (res[0] != 0) {
                return generate(firstIndex);
            }
        }

        if (arr.length >= firstIndex) {
            if (res[0] != 0) {
                return res;
            }
            return generate(firstIndex);
        }

        if (res[0] != 0) {
            return res;
        } else {
            return generate(firstIndex);
        }

    }

    private boolean checkInList(int[] arr) {

        for (int k = 0; k < list.size(); k++) {
            String arrInList = list.get(k);
            if (toString(arr).equals(arrInList)) {
                return true;
            }
        }
        return false;
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

    public void printList() {
        String printedList = "";
        for (String arr : list) {
            printedList += arr + "\n";
        }
        System.out.println(printedList);
    }

}
