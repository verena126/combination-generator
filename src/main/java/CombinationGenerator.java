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
            list.add(arr.toString());
            return arr;
        } else {
            int[] arr = generate(2);
            return arr;
        }
    }


    private int[] generate(int firstIndex) {
        int max = 8;
        int[] res = new int[arr.length];
        if (arr.length >= 2) {
            arr[arr.length - 2] = currentLimit;
        }
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

        //for the last two digits of the Array

        // Array with more than two elements
        if (arr.length > 2 && currentLimit > max - 2) {
            if (arr[arr.length - firstIndex] >= max - 1 && arr.length > firstIndex) {

                firstIndex++;
                arr[arr.length - firstIndex] = arr[arr.length - firstIndex] + 1;

                if (arr[arr.length - firstIndex] < max + 1) {
                    firstIndex--;
                    arr[arr.length - firstIndex] = 1;
                    generate(firstIndex);
                }
            }
            if (arr.length >= firstIndex && arr[arr.length - firstIndex] < currentLimit) {
                arr[arr.length - firstIndex] = arr[arr.length - firstIndex] + 1;
                generate(firstIndex);
            } else if (arr.length > firstIndex && arr[arr.length - firstIndex] == currentLimit) {
                if (arr.length > 4) {
                    firstIndex += 2;
                    if (arr[arr.length - firstIndex] < max) {
                        arr[arr.length - firstIndex] = arr[arr.length - firstIndex] + 1;
                        int i = firstIndex;
                        while (i >= 2) {
                            i--;
                            arr[arr.length - i] = 1;
                        }
                        if (firstIndex < 6) {
                            firstIndex -= 2;
                            if (res[0] != 0) {
                                generate(firstIndex);
                            }
                        }
                    }
                }
            }
        }
        currentLimit++;
        if (arr.length == 3 && currentLimit < max + 1) {
            arr[0] = 1;
            if (res[0] != 0) {
                generate(firstIndex);
            }
        }

        if (currentLimit < max + 1 && arr.length >= firstIndex && arr[arr.length - firstIndex] < max - 1) {
            if (res[0] != 0) {
                return res;
            }
            generate(firstIndex);
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
