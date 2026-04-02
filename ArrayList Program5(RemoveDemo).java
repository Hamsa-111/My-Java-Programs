/*5. Write a java program for getting different colors through ArrayList interface and delete nth element from the ArrayList object by using remove by index
*/


package Java;

import java.util.ArrayList;

public class RemoveDemo{
public static void main(String[] args){

ArrayList<String> colors=new ArrayList<>();

colors.add("Red");
colors.add("Blue");
colors.add("Green");
colors.add("Yellow");

System.out.println("Original ArrayList: "+colors);

// remove 2nd element (nth element)
colors.remove(1);

System.out.println("After removing element: "+colors);
}
}