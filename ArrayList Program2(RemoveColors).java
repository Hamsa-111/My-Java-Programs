/* 2.	Write a java program for getting different colors through ArrayList interface and remove the 2nd element and color "Blue" from the ArrayList*/


package Java;
import java.util.ArrayList;

public class RemoveColors {
public static void main(String[] args) {

ArrayList<String> colors = new ArrayList<>();

colors.add("Blue");
colors.add("Green");
colors.add("Yellow");
colors.add("Red");
colors.add("Black");

System.out.println("Original List: " + colors);

// Remove 2nd element (index 1)
colors.remove(1);

// Remove color "Blue"
colors.remove("Blue");

System.out.println("Updated List: " + colors);
}
}