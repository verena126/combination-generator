import java.util.LinkedList;

public class CombinationGenerator {
    static LinkedList<String> list = new LinkedList<String>();
    public static void main(String[] args) {
        int length = 2;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i + 1;
        }
        generate(arr, 1);
    }

    public static void generate(int[] arr, int limit) {

        arr[arr.length - 2] = limit;
        for (int i = 1; i <= limit + 1; i++) {
            arr[arr.length - 1] = i;
            if (checkNumber(arr) == false) {

                if (checkInList(arr) == false) {
                    list.add(toString(arr));
                    System.out.println(toString(arr));
                }
            }
        }
        if (limit > 2) {
            for (int k = 1; k < limit; k++) {
                arr[arr.length - 2] = k;
                for (int i = 1; i <= limit; i++) {
                    arr[arr.length - 1] = i;
                    if (checkNumber(arr) == false) {

                        if (checkInList(arr) == false) {
                            list.add(toString(arr));
                            System.out.println(toString(arr));
                        }
                    }
                }
            }
        }
        limit++;
        if (limit < 60) {
            generate(arr, limit);
        }
    }

    private static boolean checkInList(int[] arr) {

        for (int k = 0; k < list.size(); k++) {
            // System.out.println("1");
            String arrInList = list.get(k);
            //System.out.println("2");
            if (toString(arr).equals(arrInList)) {
                //  System.out.println("3");
                return true;
            }
        }
        return false;
    }

    public static String toString(int[] arr) {
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i] + " ";
        }
        return s;
    }

    public static boolean checkNumber(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[i] == arr[k]) {
                    return true;
                }
            }
        }
        return false;
    }

}
