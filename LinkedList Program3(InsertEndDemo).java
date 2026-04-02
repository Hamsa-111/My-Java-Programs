/*3.Write a Java program to insert the specified element at the end of a linked list.( using l_listobj.offerLast("Pink"))*/


package Java;

import java.util.LinkedList;

public class InsertEndDemo{
public static void main(String[] args){

LinkedList<String> colors=new LinkedList<>();

colors.add("Red");
colors.add("Blue");
colors.add("Green");

System.out.println("Original LinkedList: "+colors);

// insert element at the end
colors.offerLast("Pink");

System.out.println("After inserting at end: "+colors);
}
}
