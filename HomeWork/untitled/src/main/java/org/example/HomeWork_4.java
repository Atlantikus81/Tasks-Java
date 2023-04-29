// 1. Сохранить в файл строку и загрузить из файла строку с выводом в консоль,
//    используя классы FileWriter и FileReader.
// 2. Загрузить из файла многострочный текст формата: ФИО, возраст и пол через пробелы.
//    Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
// 3. Загруженный и разбитый по строкам текст загрузить в подготовленные списки.
//    Фамилии, имена, отчества, возраст и пол в отдельных списках.
// 4. Отсортировать по возрасту используя дополнительный список индексов.

package untitled.src.main.java.org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class HomeWork_4 {

    static ArrayList<String> listf = new ArrayList<>();
    static ArrayList<String> listn = new ArrayList<>();
    static ArrayList<String> listsn = new ArrayList<>();
    static ArrayList<Integer> listage = new ArrayList<>();
    static ArrayList<Boolean> listgend = new ArrayList<>();
    static LinkedList<Integer> listid = new LinkedList<>();


    public static void main(String[] args) {

        String str = "";
        try {
            FileReader reader = new FileReader("text_in");
            while (reader.ready()) str += (char) reader.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("1. Исходный список:");
        System.out.println(str);
        System.out.println("-".repeat(40));

        String[] strings = str.split("\n");
        for (int i = 0; i < strings.length; i++) {
            String[] tmp = strings[i].split(" ");
            listf.add(tmp[0]);
            listn.add(tmp[1]);
            listsn.add(tmp[2]);
            listage.add(Integer.parseInt(tmp[3]));
            listgend.add(tmp[4].contains("М") ? true : false);
            listid.add(i);
        }
        System.out.println("2. Список с фамилиями и инициалами:");
        for (int i : listid) {
            System.out.println(getFIO(i));
        }
        System.out.println("-".repeat(40));

        int cnt = listid.size() - 1;
        while (cnt > -1) {
            int max_age = listage.get(listid.get(cnt));
            int index = cnt;
            for (int i = 0; i < cnt; i++) {
                if (max_age < listage.get(listid.get(i))) {
                    max_age = listage.get(listid.get(i));
                    index = i;
                }
            }
            int tmp = listid.get(cnt);
            listid.set(cnt, listid.get(index));
            listid.set(index, tmp);
            cnt--;
        }
        System.out.println("3. Список, отсортированный по возрастам:");
        for (int i : listid) {
            System.out.println(getFIO(i));
        }
    }

    private static String getFIO(int index) {
        return listf.get(index).toUpperCase().charAt(0)
                + listf.get(index).toLowerCase().substring(1) + " "
                + listn.get(index).toUpperCase().charAt(0) + "."
                + listsn.get(index).toUpperCase().charAt(0) + ". "
                + listage.get(index) + ", "
                + (listgend.get(index) ? "М" : "Ж");
    }
}
