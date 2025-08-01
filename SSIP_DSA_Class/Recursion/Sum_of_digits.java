package SSIP_DSA_Class.Recursion;

public class Sum_of_digits {
    static int sum = 0;

    public static void main(String[] args) {
        int n = 123456789;
        sumOfDigits(n);
    }

    public static void sumOfDigits(int n) {
        if (n <= 0) {
            System.out.println(sum);
            return;
        }
        sum += n % 10;
        sumOfDigits(n / 10);
    }
}
