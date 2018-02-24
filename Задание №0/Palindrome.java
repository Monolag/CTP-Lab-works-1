public class Palindrome
{
    public static String reverseString(String s){

        String temp = "";

        for (int i = s.length()-1; i >= 0; i--){

            temp += s.charAt(i);
        }

        return temp;
    }


    public static void main(String[] args){
        String s = "pizzeria";
        String revS = reverseString(s);
        System.out.println(revS);
    }
}
