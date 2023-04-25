package Dz_Seminar3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_Dz3 {
    public static void main(String[] args) {
//        ex1();
        ex2();

    }

    private static void ex2() {
// 2. Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так,
// что на 0й позиции каждого внутреннего списка содержится название жанра, а на остальных позициях - названия книг.
// Напишите метод для заполнения данной структуры(можно через консоль).
// Пример:
// "Классика", "Преступление и наказание", "Война и мир", "Анна Каренина".
// "Научная фантастика", "Солярис", "Ночной дозор", "Братья Стругацкие".
// "Детектив", "Десять негритят".
// "Фантастика", "Хроники Нарнии", "Гарри Поттер и философский камень", "Грозовой перевал".

        List<ArrayList<String>> cataloge = new ArrayList<>();

        Scanner quantityGenreScan = new Scanner(System.in);
        System.out.println("Введите кол-во жанров: ");
        int quantityGenre = quantityGenreScan.nextInt();

        for (int k = 0; k < quantityGenre; k++) {
            ArrayList<String> nameBooks = new ArrayList<>();

            Scanner scannerGenre = new Scanner(System.in);
            System.out.println("Введите жанр книги: ");
            String genreBook = scannerGenre.nextLine();
            nameBooks.add(genreBook);   //добавили название жанра

            Scanner scannerCount = new Scanner(System.in);
            System.out.println("Введите количество книг в жанре: ");
            int count = scannerCount.nextInt();

            for (int i = 0; i < count; i++) {
                Scanner scannerNameBook = new Scanner(System.in);
                System.out.println("Введите название книги: ");
                String nameBook = scannerNameBook.nextLine();
                nameBooks.add(nameBook);
            }
            cataloge.add(nameBooks);
        }
        for (ArrayList<String> item: cataloge) {
            System.out.println( item);
        }
    }

    private static void ex1() {
// 1. Создать список типа ArrayList<String>. Поместить в него как строки, так и целые числа.
// Пройти по списку, найти и удалить целые числа.
// Пример: {"Яблоко", "11", "13", "Апельсин", "Дыня", "17"} -> {"Яблоко", "Апельсин", "Дыня"}

        ArrayList<String> list = new ArrayList<>();
        list.add("Яблоко");
        list.add("124");
        list.add("13");
        list.add("Апельсин");
        list.add("Дыня");
        list.add("17");
        for (int i = 0; i < list.size(); i++) {
            boolean check = false;
            try {
                int num = Integer.parseInt(list.get(i));
                check = true;
                if (check) {
                    list.remove(i);
                    i--;
                    }
                }catch (Exception e){
            }
        }
        System.out.println(list);
    }
}
