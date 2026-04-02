package Java;
import java.util.ArrayList;

public class ColorSearch {
public static void main(String[] args) {

ArrayList<String> colors = new ArrayList<>();

colors.add("Blue");
colors.add("Green");
colors.add("Yellow");
colors.add("Red");
colors.add("Black");

System.out.println("List of Colors: " + colors);

if (colors.contains("Red")) {
System.out.println("Color 'Red' is available in the list.");
} else {
System.out.println("Color 'Red' is NOT available in the list.");
}
}
}