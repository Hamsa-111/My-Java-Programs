/*1.Write a Java program to iterate through all elements in a linked list starting at the specified position ( 2nd) 
using iterator ( hint : Iterator iteratorobj = listobj.listIterator(1))
*/



package Java;

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListIteratorDemo{
public static void main(String[] args){

LinkedList<String> colors=new LinkedList<>();

colors.add("Red");
colors.add("Blue");
colors.add("Green");
colors.add("Yellow");

System.out.println("Original LinkedList: "+colors);

Iterator<String> it=colors.listIterator(1);

System.out.println("Elements from 2nd position:");

while(it.hasNext()){
System.out.println(it.next());
}

}
}
