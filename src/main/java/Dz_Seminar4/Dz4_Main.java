package Dz_Seminar4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Dz4_Main {
    public static void main(String[] args) {
        ex1();
 //       ex2();
    }

    private static void ex2() {
//  2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
        LinkedList <String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        for (int i = list.size() - 1; i >= 0; i--){
            System.out.println(list.get(i));
        }
    }

    private static void ex1() {
//  1. Реализовать консольное приложение, которое:
//  Принимает от пользователя и “запоминает” строки.
//  Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
//  Если введено revert, удаляет предыдущую введенную строку из памяти.

    Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (true) {
        System.out.println("Введите слово: ");
        String word = sc.nextLine();
        list.add(word);

            if (word.equalsIgnoreCase("print")) {
                list.forEach(System.out::println);
                for (int i = list.size() - 1; i >= 0; i--){
                    System.out.print(list.get(i) + " ") ;
                }
                break;
            }
            if (word.equalsIgnoreCase("revert")){
                int index = list.lastIndexOf("revert");
                list.remove(index - 1);
                System.out.println(list);
            }
        }
    }
}
