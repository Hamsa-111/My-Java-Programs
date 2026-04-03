/*3c(ix)Write a Java Program for Creating a random string of a specified length using user defined function generateRandomString()*/


package Java;

import java.util.Random;

public class RandomStringDemo{
public static void main(String[] args){

String result=generateRandomString(8);

System.out.println("Random String: "+result);
}

// user-defined function
public static String generateRandomString(int length){

String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
Random rand=new Random();
String result="";

for(int i=0;i<length;i++){
int index=rand.nextInt(chars.length());
result=result+chars.charAt(index);
}

return result;
}
}