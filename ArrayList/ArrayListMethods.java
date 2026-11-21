import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;

public class ArrayListMethods {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        // 1. add(element) / add(index, element)
        // Definition: Adds an element to the end of the list, or inserts it at a specified index.
        list.add("Apple");
        list.add("Banana");
        list.add(1, "Blueberry");
        System.out.println("1. add(): " + list);

        // 2. addAll(collection) / addAll(index, collection)
        // Definition: Appends all elements from a collection to the end, or inserts them at a specified index.
        List<String> moreFruits = List.of("Cherry", "Date", "Elderberry");
        list.addAll(moreFruits);
        list.addAll(2, List.of("Apricot"));
        System.out.println("2. addAll(): " + list);

        // 3. get(index)
        // Definition: Returns the element at the specified position in the list.
        System.out.println("3. get(1): " + list.get(1));

        // 4. set(index, element)
        // Definition: Replaces the element at the specified index with a new element.
        list.set(0, "Avocado");
        System.out.println("4. set(0, \"Avocado\"): " + list);

        // 5. size()
        // Definition: Returns the number of elements in the list.
        System.out.println("5. size(): " + list.size());

        // 6. isEmpty()
        // Definition: Returns true if the list contains no elements, otherwise false.
        System.out.println("6. isEmpty(): " + list.isEmpty());

        // 7. contains(element)
        // Definition: Returns true if the list contains the specified element.
        System.out.println("7. contains(\"Cherry\"): " + list.contains("Cherry"));

        // 8. indexOf(element)
        // Definition: Returns the index of the first occurrence of the element, or -1 if not found.
        System.out.println("8. indexOf(\"Cherry\"): " + list.indexOf("Cherry"));

        // 9. lastIndexOf(element)
        // Definition: Returns the index of the last occurrence of the element, or -1 if not found.
        list.add("Cherry");
        System.out.println("9. lastIndexOf(\"Cherry\"): " + list.lastIndexOf("Cherry"));

        // 10. remove(index) / remove(element)
        // Definition: Removes the element at the specified index or the first occurrence of the specified object.
        list.remove(list.size() - 1); // removes trailing "Cherry"
        list.remove("Date");
        System.out.println("10. remove(): " + list);

        // 11. removeAll(collection)
        // Definition: Removes all elements from the list that are also present in the specified collection.
        list.removeAll(List.of("Apricot", "Blueberry"));
        System.out.println("11. removeAll(): " + list);

        // 12. retainAll(collection)
        // Definition: Retains only the elements in the list that are also contained in the specified collection.
        list.addAll(List.of("Fig", "Grape"));
        list.retainAll(List.of("Avocado", "Cherry", "Fig"));
        System.out.println("12. retainAll(): " + list);

        // 13. removeIf(predicate)
        // Definition: Removes all elements that match a given condition (lambda/Predicate).
        list.removeIf(item -> item.startsWith("F"));
        System.out.println("13. removeIf(starts with F): " + list);

        // 14. replaceAll(operator)
        // Definition: Replaces each element in the list with the result of applying an operation to it.
        list.replaceAll(String::toUpperCase);
        System.out.println("14. replaceAll(toUpperCase): " + list);

        // 15. sort(comparator)
        // Definition: Sorts the list according to the order induced by the specified Comparator (pass null for natural order).
        list.sort(Comparator.naturalOrder());
        System.out.println("15. sort(): " + list);

        // 16. subList(fromIndex, toIndex)
        // Definition: Returns a view of the portion of the list between fromIndex (inclusive) and toIndex (exclusive).
        List<String> sub = list.subList(0, 2);
        System.out.println("16. subList(0, 2): " + sub);

        // 17. toArray() / toArray(T[])
        // Definition: Returns an array containing all elements in the list in proper sequence.
        Object[] objArray = list.toArray();
        String[] strArray = list.toArray(new String[0]);
        System.out.println("17. toArray(): " + Arrays.toString(strArray) + " (Object count: " + objArray.length + ")");

        // 18. forEach(action)
        // Definition: Performs the given action for each element in the list.
        System.out.print("18. forEach(): ");
        list.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 19. iterator()
        // Definition: Returns an Iterator over the elements in the list in proper sequence.
        Iterator<String> it = list.iterator();
        System.out.print("19. iterator(): ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 20. listIterator() / listIterator(index)
        // Definition: Returns a ListIterator for traversing the list in either direction (optionally starting at index).
        ListIterator<String> listIt = list.listIterator(list.size());
        System.out.print("20. listIterator() backwards: ");
        while (listIt.hasPrevious()) {
            System.out.print(listIt.previous() + " ");
        }
        System.out.println();

        // 21. spliterator()
        // Definition: Creates a late-binding and fail-fast Spliterator over the elements in the list for parallel/stream traversal.
        Spliterator<String> sp = list.spliterator();
        System.out.print("21. spliterator(): ");
        sp.forEachRemaining(item -> System.out.print(item + " "));
        System.out.println();

        // 22. clone()
        // Definition: Returns a shallow copy of this ArrayList instance.
        @SuppressWarnings("unchecked")
        ArrayList<String> clonedList = (ArrayList<String>) list.clone();
        System.out.println("22. clone(): " + clonedList);

        // 23. ensureCapacity(minCapacity)
        // Definition: Increases the capacity of this ArrayList instance, if necessary, to hold at least minCapacity elements.
        list.ensureCapacity(50);
        System.out.println("23. ensureCapacity(50) called; size is still: " + list.size());

        // 24. trimToSize()
        // Definition: Trims the capacity of this ArrayList instance to be the list's current size.
        list.trimToSize();
        System.out.println("24. trimToSize() called; size is still: " + list.size());

        // 25. clear()
        // Definition: Removes all elements from the list, leaving it empty.
        list.clear();
        System.out.println("25. clear(): " + list + " | isEmpty(): " + list.isEmpty());
    }
}