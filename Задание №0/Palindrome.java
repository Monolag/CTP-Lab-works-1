public class Palindrome
{
    public static String reverseString(String s){
        String temp = "";
        for (int i = s.length()-1; i >= 0; i--){
            temp += s.charAt(i);
        }
        return temp;
    }

    public static boolean isPalindrome(String str){
        String revStr = reverseString(str);
        if (str.equals(revStr))
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        String str = "";
        for (int i = 0; i < args.length; i++) {
            str = args[i];
            if (isPalindrome(str))
                System.out.println(str + " - palindrome");
            else
                System.out.println(str + " - not a palindrome");
        }
    }
}
