// 1. Написать метод принимающий строку, ищущий в ней основание и степень.
//    После этого расчитывающий результат и выводящий в консоль строку параметра + ответ.
//    Пример строки: "Основание -12, степень 7, результат". Попробовать с разными входящими строками.
// 2. Сравнить скорость работы реплейса классов String и StringBuilder.

package untitled.src.main.java.org.example;

import java.util.Scanner;

public class HomeWork_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите основание степени: ");
        String base = in.nextLine();
        System.out.print("Введите показатель степени: ");
        String power = in.nextLine();
        String result_string = String.format("Основание %s, степень %s, результат ", base, power);
        System.out.println(DegreeNumber(result_string));
        System.out.println("-".repeat(40));

        System.out.print("Введите любую строку: ");
        String str = in.nextLine();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 30000; i++) {
            str += Character.getName(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Скорость работы класса String: " + (end - begin));
        StringBuilder builder = new StringBuilder(str);
        begin = System.currentTimeMillis();
        for (int i = 0; i < 30000; i++) {
            builder.append(Character.getName(i));
        }
        end = System.currentTimeMillis();
        System.out.println("Скорость работы класса StringBuilder: " + (end - begin));
        in.close();
    }

    static String DegreeNumber(String in_string) {
        String[] array_string = in_string.split(" ");
        int base = 0;
        int power = 0;
        double result;
        for (int i = 0; i < array_string.length; i++) {
            array_string[i] = array_string[i].replace(",", "");
            try {
                Integer.parseInt(array_string[i]);
                if (base == 0) {
                    base = Integer.parseInt(array_string[i]);
                } else {
                    power = Integer.parseInt(array_string[i]);
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }
        result = Math.pow(base, power);
        String str_res = Double.toString(result);
        return in_string + str_res;
    }
}
