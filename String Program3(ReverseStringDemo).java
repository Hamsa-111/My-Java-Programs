/*3b(iii)Write a Java Program for Reversing the characters in a string using user defined function reverseString().*/


package Java;

public class ReverseStringDemo{
public static void main(String[] args){

String str="Java Programming";

String reversed=reverseString(str);

System.out.println("Original String: "+str);
System.out.println("Reversed String: "+reversed);
}

// user-defined function
public static String reverseString(String str){
String rev="";

for(int i=str.length()-1;i>=0;i--){
rev=rev+str.charAt(i);
}

return rev;
}
}
