package Dz_Seminar5;

import java.util.Collections;
import java.util.*;
import java.util.Map;
import java.util.HashMap;


public class Main_Dz5 {
    public static void main(String[] args) {
//        ex1();
//        ex2();
        ex3(8);
    }

    static void ex3(int n) {
        int[] result = queens(new int[n], 0);
        if (result != null) {
            printPosition(result);
        } else {
            System.out.println("Расстановка невозможна");
        }
    }
    static int[] queens(int[] board, int fixed) {
        int n = board.length;
        if (fixed == n) {
// Все ферзи расставлены
            return board;
        }
        for (int i = 0; i < n; ++i) {
            if (valid(board, fixed, i)) {
                board[fixed] = i;
                int[] result = queens(board, fixed + 1);
                if (result != null) return result;
            }
        }
        return null;
    }
    static boolean valid(int[] board, int fixed, int pos) {
        for (int i = 0; i < fixed; ++i) {
            if (pos == board[i] || fixed - i == Math.abs(pos - board[i])) {
                return false;
            }
        }
        return true;
    }

    static void printPosition(int[] pos) {
        int n = pos.length;
        for (int row : pos) {
            for (int i = 0; i < row; ++i) System.out.print(" .");
            System.out.print(" *");
            for (int i = row+1; i < n; ++i) System.out.print(" .");
            System.out.println();
        }

    }

    private static void ex2() {
//        2. Пусть дан список сотрудников:
//        Иван Иванов   Светлана Петрова   Кристина Белова    Анна Мусина     Анна Крутова      Иван Юрин
//        Петр Лыков    Павел Чернов       Петр Чернышов      Мария Федорова  Марина Светлова   Мария Савина
//        Мария Рыкова  Марина Лугова      Анна Владимирова   Иван Мечников   Петр Петин        Иван Ежов

//        2.1. Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
//        2.2. Отсортировать по убыванию популярности.

        ArrayList <String> list = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        Map <String,Integer> nameCount = new HashMap<>();

        list.add("Иван Иванов");
        list.add("Светлана Петрова");
        list.add("Кристина Белова");
        list.add("Анна Мусина");
        list.add("Анна Крутова");
        list.add("Иван Юрин");
        list.add("Петр Лыков");
        list.add("Павел Чернов");
        list.add("Петр Чернышов");
        list.add("Мария Федорова");
        list.add("Марина Светлова");
        list.add("Мария Савина");
        list.add("Мария Рыкова");
        list.add("Марина Лугова");
        list.add("Анна Владимирова");
        list.add("Иван Мечников");
        list.add("Петр Петин");
        list.add("Иван Ежов");
//      Собрал массив имён
        String temp = "";
        String prevTemp = "";
        String nextTemp = "";
        for (int i = 0; i < list.size(); i++){
            temp = list.get(i).toLowerCase();
            String[] tempArray = temp.split(" ");
            name.add(tempArray[0]);
        }
//      Считаю кол-во одинаковых имён
        for (int i = 0; i < name.size(); i++){
            int count = 1;
            prevTemp = name.get(i);
            for (int j = i + 1; j < name.size(); j++){
                nextTemp = name.get(j);
                if (prevTemp.equalsIgnoreCase(nextTemp)) {
                    count++;
                    name.remove(j);
                    j--;
                }
            }
            nameCount.put(prevTemp, count);
        }

        List listSort = new ArrayList<>(nameCount.entrySet());
        Collections.sort(listSort, new Comparator<Map.Entry<String, Integer>>() {
           @Override // переопределение
           public int compare (Map.Entry<String, Integer> a, Map.Entry<String, Integer> b){
               return b.getValue() - a.getValue();
           }
        });
        listSort.forEach(System.out::println);
    }

    private static void ex1() {
    Scanner sc = new Scanner(System.in);

    Map <String, ArrayList <String>> telBook = new HashMap <> ();
//        1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
        String data = "";
        while (!data.equalsIgnoreCase("выход")){
            ArrayList <String> numberTel = new ArrayList<>();
            System.out.println("Для выхода введите ВЫХОД или введите имя и фамилию: ");
            data = sc.nextLine().toLowerCase().trim();
            if (data.equalsIgnoreCase("выход")){
                break;
            }else {
                System.out.println("Введите кол-во телефонных номеров: ");
                int num = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < num; i++){
                    System.out.println("Введите номер телефона: ");
                    String phone = sc.nextLine();
                    numberTel.add(phone);
                }
                telBook.put(data, numberTel);
            }
        }
 /*       for (String  key: nameCount.keySet()){
            String names = key.toString();                      // нормальный вывод на экран
            String count = nameCount.get(names).toString();
            System.out.println( names + " >>> " + count);
        }           */
        for (String  item: telBook.keySet()){
            String name = item.toString();
            String telNumber = telBook.get(name).toString();
            System.out.println(name + ": Номер(а) телефонов " + telNumber);
        }

    }
}
