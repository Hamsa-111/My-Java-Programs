/*3b(iv) Write a Java Program for Checking if a string reads the same backward as forward (ignoring case and punctuation) using user defined function isPalindrome():*/



package Java;

public class PalindromeDemo{
public static void main(String[] args){

String str="Madam, I'm Adam";

if(isPalindrome(str)){
System.out.println(str + " is a Palindrome");
}else{
System.out.println(str + "is not a Palindrome");
}

}

// user-defined function
public static boolean isPalindrome(String str){

// remove punctuation and spaces, convert to lowercase
str=str.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

int i=0;
int j=str.length()-1;

while(i<j){
if(str.charAt(i)!=str.charAt(j)){
return false;
}
i++;
j--;
}

return true;
}
}