package SSIP_DSA_Class.Recursion;

public class Function_evaluation_2 {
    public static void main(String[] args) {
        System.out.println(evaluate(5, 3));
    }

    public static int evaluate(int n, int m) {
        if (m == 0 || m == n) {
            return 1;
        }
        return evaluate(n - 1, m) + evaluate(n - 1, m - 1);
    }
}
