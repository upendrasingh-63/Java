package SSIP_DSA_Class.Recursion;

public class Funtion_evaluation {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7 };
        for (int key : arr) {
            System.out.println(evaluate(key));
        }
    }

    public static int evaluate(int n) {
        if (n <= 1)
            return n;
        if (n > 1 && n % 2 == 0) {
            return n + evaluate(n / 2);
        }
        return evaluate((n + 1) / 2) + evaluate((n - 1) / 2);
    }
}
