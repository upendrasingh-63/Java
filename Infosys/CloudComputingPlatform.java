package Infosys;

import java.util.List;

public class CloudComputingPlatform {
    private static long findTotalSum(int n, List<Integer> servers, int q, List<List<Integer>> querry) {
        long sum = 0;
        for (List<Integer> ll : querry) {
            if (ll.get(0) == 1) {
                servers.set(ll.get(1) - 1, servers.get(ll.get(1) - 1) + ll.get(2));
            }
            if (ll.get(0) == 2) {
                int l = ll.get(1);
                int r = ll.get(2);
                int m = ll.get(3);

                int max = 0;
                int j = l - 1;
                int k = 0;
                while (j < r) {
                    if (servers.get(j) >= m) {
                        k++;
                    } else {
                        k = 0;
                    }
                    max = Math.max(max, k);
                    j++;
                }
                sum += max;
            }
        }
        return sum;
    }
}
