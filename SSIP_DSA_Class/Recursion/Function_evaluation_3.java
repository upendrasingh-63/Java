package SSIP_DSA_Class.Recursion;

public class Function_evaluation_3 {
    public static void main(String[] args) {
        System.out.println(evaluate(2, 7));
    }

    public static int evaluate(int n, int m) {
        if (n == m) {
            return n * m;
        }
        return evaluate(n, (n + m) / 2) + evaluate(((n + m) / 2) + 1, m);
    }
}
