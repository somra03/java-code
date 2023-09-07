import java.util.Scanner;
public class Strings {
    public static boolean palindrome(String str) {
        //String str = "racecar";
        int n = str.length();
        for (int index = 0; index < n/2; index++) {
            if (str.charAt(index) != str.charAt(n-index-1)) {  
                System.out.println("The given string is not a palindrome");
                return false;           
            }
        }System.out.println("The given string is a palindrome");
        return true;
    }
    public static void shortestPath(String str) {
        int x = 0, y = 0;
        double d = 0;
        for (int index = 0; index < str.length(); index++) {
            if (str.charAt(index) == 'N') {
                y++;
            }
            else if (str.charAt(index) == 'W') {
                x--;
            }
            else if (str.charAt(index) == 'E') {
                x++;
            }
            else{
                y--;
            }
        }
         d = Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
         System.out.println("The shortest distance is : "+ d);
    }
    public static void subString(String str , int si , int ei) {
        String substr = "";
        for (int index = si; index <= ei; index++) {
            substr += str.charAt(index);
        }
        System.out.println(substr);
    }
    public static void largest1(String str1,String str2, String str3) {
        if (str1.length()>str2.length() && str1.length()>str3.length()) {
            System.out.println("Largest string is : " + str1);
        } else if (str2.length()>str3.length()) {
            System.out.println("Largest string is : " + str2);
        } else {
            System.out.println("Largest string is : " + str3);
        }
    }
    public static void largest2(String str1,String str2, String str3) {
        String str = (str1.length()>str2.length() && str1.length()>str3.length())? str1 : ((str2.length()>str3.length())? str2 : str3);
            System.out.println("Largest string is : " + str);
    }
    public static void Largest(String str[]) {
        String largest = str[0];
        for (int index = 0; index < str.length; index++) {
            if (largest.compareToIgnoreCase(str[index])<0) {
                largest = str[index];
            }
        }System.out.println(largest);
    }
    public static void StringToUppercase(String str) {
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
            sb.append(ch);
        for (int index = 1; index < str.length(); index++) {
            if (str.charAt(index) == ' ' && index<str.length()-1) {
                 sb.append(str.charAt(index));
                 index++;
                 ch = Character.toUpperCase(str.charAt(index));
                 sb.append(ch);
            }
            else{sb.append(str.charAt(index));}
        } System.out.println(sb);   
    }
    public static void compression(String str) {
        StringBuilder sb = new StringBuilder("");
        for (int index = 0; index < str.length(); index++) {
                Integer count = 1;
             while (index<str.length()-1 && str.charAt(index)==str.charAt(index+1) ) {
                    count++;
                    index++;
            }
            sb.append(str.charAt(index));
            if (count>1) {
                sb.append(count);
            }
        }System.out.println(sb);
    }
    public static void lowercaseVowel(String str) {
        int count = 0;
        for (int index = 0; index < str.length(); index++) {
            if (str.charAt(index)=='a') {
                count++;
            }else if (str.charAt(index) == 'e') {
                count++;
            } else if (str.charAt(index) == 'i') {
                count++;
            } else if (str.charAt(index) == 'o') {
                count++;
            } else if (str.charAt(index) == 'u') {
                count++;
            }
        }System.out.println("There are " + count + " lower case vowel");
    }
    public static void anagrams(String str1, String str2) {
        if (str1.length() == str2.length()) {
            int count = 0;
                for (int s = 0; s < str1.length(); s++) {
                    for (int index = 0; index < str2.length(); index++) {
                       if(str1.charAt(s) == str2.charAt(index))
                       {
                        count++;
                       }
                    }
            }
            if (count == str1.length()) {
                System.out.println("numbers are anagrams");
            } else {
                System.out.println("numbers are not anagrams");
            }
        }
        else {
            System.out.println("numbers are not anagrams");
        }
    }
    public static void main(String[] args) {
        //StringBuilder str = new StringBuilder(" ");
        Scanner sc = new Scanner(System.in);
        //String str = "hii i am sushmita";
        //String str[] = {"apple" , "mango" , "banana"};
        //String str = sc.nextLine();
        System.out.println("Enter the first string : ");
        String str1 = sc.nextLine();
        System.out.println("Enter the second string : ");
        String str2 = sc.nextLine();
        //System.out.println("Enter the third string : ");
        //String str3 = sc.nextLine();
        //palindrome(str);
        //shortestPath(str);
        //subString(str, 0, 5);
        //largest1(str1, str2, str3);
        //largest2(str1, str2, str3);
        //Largest(str);
        //for (char i = 'a'; i <= 'z'; i++) {
            //char ch = Character.toUpperCase(i);
            //sb.append(ch);
        //}System.out.println(sb + " " + sb.length());
        //StringToUppercase(str);
        //compression(str);
        //lowercaseVowel(str);
        anagrams(str1, str2);
        sc.close();
    }
}
