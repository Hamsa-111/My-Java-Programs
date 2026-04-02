/*2.Write a Java program to iterate a linked list in reverse order (using objlist.descendingIterator())
*/


package Java;

import java.util.LinkedList;
import java.util.Iterator;

public class ReverseLinkedListDemo{
public static void main(String[] args){

LinkedList<String> colors=new LinkedList<>();

colors.add("Red");
colors.add("Blue");
colors.add("Green");
colors.add("Yellow");

System.out.println("Original LinkedList: "+colors);

Iterator<String> it=colors.descendingIterator();

System.out.println("Elements in reverse order:");

while(it.hasNext()){
System.out.println(it.next());
}

}
}
