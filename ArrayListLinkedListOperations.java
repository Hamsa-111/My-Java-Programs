/*1.a Develop a Java program for adding elements [Apple, Banana, Orange] into an ArrayList and a LinkedList to perform the following operations with different functions directed as follows
1. Adding elements, 2. Adding element at specific index, 3. Adding multiple elements, 4. Accessing elements,5. Updating elements, 6. Removing elements, 7. Searching elements, 8. List size, 9. Iterating over list, 10. Using Iterator, 11. Sorting, 12. Sublist, 13. Clearing the list
*/




import java.util.*;

public class ArrayListLinkedListOperations {
public static void main(String[] args) {

ArrayList<String> arrayList = new ArrayList<>();
LinkedList<String> linkedList = new LinkedList<>();

// 1. Adding elements
System.out.println("1. Adding Elements:");
arrayList.add("Apple");
arrayList.add("Banana");
arrayList.add("Orange");

linkedList.add("Apple");
linkedList.add("Banana");
linkedList.add("Orange");

System.out.println("ArrayList: " + arrayList);
System.out.println("LinkedList: " + linkedList);
System.out.println("--------------------------------");

// 2. Adding element at specific index
System.out.println("2. Adding Element at Specific Index (index 1 -> Mango):");
arrayList.add(1, "Mango");
linkedList.add(1, "Mango");

System.out.println("ArrayList: " + arrayList);
System.out.println("LinkedList: " + linkedList);
System.out.println("--------------------------------");

// 3. Adding multiple elements
System.out.println("3. Adding Multiple Elements (Grapes, Pineapple):");
arrayList.addAll(Arrays.asList("Grapes", "Pineapple"));
linkedList.addAll(Arrays.asList("Grapes", "Pineapple"));

System.out.println("ArrayList: " + arrayList);
System.out.println("LinkedList: " + linkedList);
System.out.println("--------------------------------");

// 4. Accessing elements
System.out.println("4. Accessing Element at index 2:");
System.out.println("ArrayList Element: " + arrayList.get(2));
System.out.println("--------------------------------");

// 5. Updating elements
System.out.println("5. Updating Element at index 2 -> Kiwi:");
arrayList.set(2, "Kiwi");
linkedList.set(2, "Kiwi");

System.out.println("ArrayList: " + arrayList);
System.out.println("LinkedList: " + linkedList);
System.out.println("--------------------------------");

// 6. Removing elements
System.out.println("6. Removing Element 'Banana':");
arrayList.remove("Banana");
linkedList.remove("Banana");

System.out.println("ArrayList: " + arrayList);
System.out.println("LinkedList: " + linkedList);
System.out.println("--------------------------------");

// 7. Searching elements
System.out.println("7. Searching Element 'Apple':");
System.out.println("ArrayList contains Apple? " + arrayList.contains("Apple"));
System.out.println("--------------------------------");

// 8. List size
System.out.println("8. Size of ArrayList:");
System.out.println("Size: " + arrayList.size());
System.out.println("--------------------------------");

// 9. Iterating over list
System.out.println("9. Iterating using for-each loop:");
for(String fruit : arrayList) {
System.out.println(fruit);
}
System.out.println("--------------------------------");

// 10. Using Iterator
System.out.println("10. Iterating using Iterator (LinkedList):");
Iterator<String> it = linkedList.iterator();
while(it.hasNext()) {
System.out.println(it.next());
}
System.out.println("--------------------------------");

// 11. Sorting
System.out.println("11. Sorting ArrayList:");
Collections.sort(arrayList);
System.out.println("Sorted ArrayList: " + arrayList);
System.out.println("--------------------------------");

// 12. Sublist
System.out.println("12. Sublist (index 0 to 2):");
System.out.println(arrayList.subList(0, 2));
System.out.println("--------------------------------");

// 13. Clearing the list
System.out.println("13. Clearing Lists:");
arrayList.clear();
linkedList.clear();

System.out.println("ArrayList after clear: " + arrayList);
System.out.println("LinkedList after clear: " + linkedList);
System.out.println("--------------------------------");

}
}