/*3c(x) Write a Java Program for Counting the number of words in a string using user defined function countWords()*/




package Java;

public class WordCountDemo{
public static void main(String[] args){

String str="Java programming is very easy to learn";

int count=countWords(str);

System.out.println("String: "+str+"\n");
System.out.println("Number of words: "+count);
}

// user-defined function
public static int countWords(String str){

if(str==null || str.trim().isEmpty()){
return 0;
}

String[] words=str.trim().split("\\s+");
return words.length;
}
}