/*5.Write a Java program that swaps two elements ( first and third elements ) in a linked list ( using Collections.swap(l_list, 0, 2)) */



package Java;

import java.util.LinkedList;
import java.util.Collections;

public class SwapDemo{
public static void main(String[] args){

LinkedList<String> colors=new LinkedList<>();

colors.add("Red");
colors.add("Blue");
colors.add("Green");
colors.add("Yellow");

System.out.println("Before swap: "+colors);

// swap 1st and 3rd elements (index 0 and 2)
Collections.swap(colors,0,2);

System.out.println("After swap: "+colors);
}
}
