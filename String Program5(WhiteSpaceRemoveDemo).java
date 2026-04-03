/*3b(v)Write a Java Program for Eliminating all whitespace characters from a string using user defined function removeWhitespace()*/



package Java;

public class RemoveWhitespaceDemo{
public static void main(String[] args){

String str="Java   Programming   is   fun";

String result=removeWhitespace(str);

System.out.println("Original String: "+str+"\n");

System.out.println("After removing whitespace: "+result);
}

// user-defined function
public static String removeWhitespace(String str){
return str.replaceAll("\\s","");   // removes all whitespace
}
}