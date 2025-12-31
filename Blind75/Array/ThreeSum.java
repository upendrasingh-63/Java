package Blind75.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> list = getTriplets(arr);
        System.out.println(list);
    }

    private static List<List<Integer>> getTriplets(int[] arr) {

        List<List<Integer>> list = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((arr[i] + arr[j] + arr[k] == 0)) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(temp);
                        if (!list.contains(temp))
                            list.add(temp);
                    }
                }
            }
        }
        return list;
    }

}
