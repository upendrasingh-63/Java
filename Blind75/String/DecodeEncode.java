package Blind75.String;

public class DecodeEncode {
    public static void main(String[] args) {
        String[] arr = { "hello", "world", "java" };

        String s = Encode(arr);
        System.out.println(s);

        String[] ans = Decode(s);
        System.out.println(ans.length);
        for (String key : ans) {
            System.out.print(key + " ");
        }
    }

    private static String Encode(String[] s) {
        String ans = s[0];
        for (int i = 1; i < s.length; i++) {
            s[i] = "4#" + s[i];
        }
        for (int i = 1; i < s.length; i++) {
            ans += s[i];
        }
        return ans;
    }

    private static String[] Decode(String s) {
        String[] arr = s.split("4#");
        return arr;
    }
}
