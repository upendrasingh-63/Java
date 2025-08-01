package SSIP_DSA_Class.Recursion;

public class Function_evaluation_4 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        for (int key : arr) {
            evaluate(key);
            System.out.println();
        }
    }

    public static void evaluate(int n) {
        if (n == 1) {
            System.out.print(1 + " ");
            return;
        } else {
            evaluate(n - 1);
            System.out.print(n + " ");
            evaluate(n - 1);

        }
    }
}
