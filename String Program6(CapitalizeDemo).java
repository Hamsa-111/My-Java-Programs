/*3c(vi)Write a Java Program for Capitalizing the first letter of each word. using user defined function capitalizeWords()*/




package Java;

public class CapitalizeDemo{
public static void main(String[] args){

String str="java programming is easy";

String result=capitalizeWords(str);

System.out.println("Original String: "+str+"\n");
System.out.println("Capitalized String: "+result);
}

// user-defined function
public static String capitalizeWords(String str){

String[] words=str.split(" ");
String result="";

for(String w:words){
if(w.length()>0){
result=result+w.substring(0,1).toUpperCase()+w.substring(1)+" ";
}
}

return result.trim();
}
}
