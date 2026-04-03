/*3a(i) Write a Java Program for Checking if a given string is null or contains only whitespace using user defined function isNullOrEmpty().*/



package Java;

public class NullOrEmptyDemo{
public static void main(String[] args){

String input="   ";   // you can change the value here

if(isNullOrEmpty(input)){
System.out.println("String is null or contains only whitespace");
}else{
System.out.println("String is not null and not empty");
}

}

// user-defined function
public static boolean isNullOrEmpty(String str){
return (str==null || str.trim().isEmpty());
}
}