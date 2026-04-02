/*4.Write a java program for getting different colors through ArrayList interface and extract the elements 1st and 2nd from the ArrayList object by using SubList()
*/



package Java;

import java.util.ArrayList;
import java.util.List;

public class SubListDemo{
public static void main(String[] args){

ArrayList<String> colors=new ArrayList<>();

colors.add("Red");
colors.add("Blue");
colors.add("Green");
colors.add("Yellow");

System.out.println("Original ArrayList: "+colors);

List<String> subColors=colors.subList(0,2);

System.out.println("Extracted elements: "+subColors);
}
}
