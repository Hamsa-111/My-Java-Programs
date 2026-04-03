/*3c(vii)Write a Java Program for Shortening a string to a specified length and adds an ellipsis using user defined function truncate()*/



package Java;

public class TruncateDemo{
public static void main(String[] args){

String str="Java programming is very interesting";

String result=truncate(str,20);

System.out.println("Original String: "+str+"\n");
System.out.println("Truncated String: "+result);
}

// user-defined function
public static String truncate(String str,int length){

if(str.length()<=length){
return str;
}

return str.substring(0,length)+"...";
}
}