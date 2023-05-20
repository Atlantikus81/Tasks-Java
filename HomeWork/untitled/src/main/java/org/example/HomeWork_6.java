// Разработать программу, имитирующую поведение коллекции HashSet.
// В программе содать метод add, добавляющий элемент,
// метод toString, возвращающий строку с элементами множества, и метод, позволяющий читать элементы по индексу.
// *Реализовать все методы из семинара.
// Формат данных Integer.

package untitled.src.main.java.org.example;

import java.util.*;

public class HomeWork_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество элементов коллекций: ");
        int elementsCount = in.nextInt();
        mySet mySet = new mySet();
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        myTreeSet myTreeSet = new myTreeSet(comparator);
        for (int i = 0; i < elementsCount; i++) {
            mySet.add(new Random().nextInt(100));
            myTreeSet.add(new Random().nextInt(100));
        }
        System.out.println("Работа с коллекцией HashSet:");
        System.out.println(mySet.contains(77));
        System.out.println(Arrays.toString(mySet.toArray()));
        System.out.println("-".repeat(40));
        Iterator<Integer> iterator = mySet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }
        System.out.println();
        System.out.println("-".repeat(40));
        System.out.println(mySet.getItem(3));
        System.out.println("=".repeat(40));

        System.out.println("Работа с коллекцией TreeSet:");
        System.out.println(Arrays.toString(myTreeSet.toArray()));
        System.out.println("-".repeat(40));
        Iterator<Integer> iterator1 = myTreeSet.iterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + "  ");
        }
        System.out.println();
        System.out.println("-".repeat(40));
        System.out.println(myTreeSet.getItem(3));
        in.close();
    }
}

class mySet {
    static final Object OBJECT = new Object();
    private LinkedHashMap<Integer, Object> hashMap = new LinkedHashMap<>();

    public boolean add(int num) {
        return hashMap.put(num, OBJECT) == null;
    }

    public boolean contains(int num) {
        return hashMap.containsKey(num);
    }

    public Object[] toArray() {
        return hashMap.keySet().toArray();
    }

    public Iterator<Integer> iterator() {
        return hashMap.keySet().iterator();
    }

    public Integer getItem(int index) {
        return (Integer) toArray()[index];
    }
}

class myTreeSet {
    private Comparator<Integer> comparator;

    public myTreeSet(Comparator<Integer> comp) {
        comparator = comp;
    }

    static final Object OBJECT = new Object();
    private TreeMap<Integer, Object> treeMap = new TreeMap<>(comparator);

    public boolean add(int num) {
        return treeMap.put(num, OBJECT) == null;
    }

    public boolean contains(int num) {
        return treeMap.containsKey(num);
    }

    public Object[] toArray() {
        return treeMap.keySet().toArray();
    }

    public Iterator<Integer> iterator() {
        return treeMap.keySet().iterator();
    }

    public Integer getItem(int index) {
        return (Integer) toArray()[index];
    }
}
