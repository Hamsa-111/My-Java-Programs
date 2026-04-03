/*3b(ii)Write a Java Program for Counting how many times a substring appears in a main string using user defined function countOccurrences()

*/




package Java;

public class SubstringCountDemo{
public static void main(String[] args){

String mainStr="Java is easy. Java is powerful. Java is popular.";
String subStr="Java";

int result=countOccurrences(mainStr,subStr);

System.out.println("Main String: "+mainStr);
System.out.println("Substring: "+subStr);
System.out.println("Number of occurrences: "+result);
}

// user-defined function
public static int countOccurrences(String str,String sub){
int count=0;
int pos=0;

while((pos=str.indexOf(sub,pos))!=-1){
count++;
pos=pos+sub.length();
}

return count;
}
}