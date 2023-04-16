package Dz_Seminar1;

import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ex1(4,5);
        //       ex2();
        //      ex3();
        //      ex4();
        //       ex5(ex2(), -4); // используем массив из ex2
    }
    //1. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив
// типа int длиной len, каждая ячейка которого равна initialValue;
    private static int[] ex1 (int len, int initialValue){
        int[] arr = new int[len];
        for(int i = 0; i< arr.length; i++){
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr)); // для распечатывания массива используем Arrays.toString(arr)
        return arr;
    }

    //2. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
    private static int[] ex2() {
        int[] arr = {2,-5,3,7,9,33,2,1};
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
//        System.out.println(min);
//        System.out.println(max);
        return arr;
    }

    //3. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
// и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
// если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу:
// индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
    private static void ex3() {
        int[][] matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++){      // Строка
            for (int j = 0; j < matrix.length; j++){    //Столбец
                if (i==j) matrix[i][j] = 1;
                else matrix[i][j] = 0;
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    //4. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
//"Доброе утро, <Имя>!", если время от 05:00 до 11:59
//"Добрый день, <Имя>!", если время от 12:00 до 17:59;
//"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
//"Доброй ночи, <Имя>!", если время от 23:00 до 4:59
    private static void ex4() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = iScanner.nextLine();

        LocalTime CurrentTime = LocalTime.now();
        int time = CurrentTime.getHour();
        if (time >= 5 & time < 12) System.out.println("Доброе утро, " + name);
        if (time >= 12 & time < 18) System.out.println("Добрый день, " + name);
        if (time >= 18 & time < 23) System.out.println("Добрый вечер, " + name);
        if (time >= 23 | time < 5) System.out.println("Доброй ночи, " + name);
    }
    //5.** Написать метод, которому на вход подается одномерный массив и число n
// (может быть положительным, или отрицательным), при этом метод должен сместить все
// элементы массива на n позиций. Элементы смещаются циклично.
// Для усложнения задачи нельзя пользоваться вспомогательными массивами.
// Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
// [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг
// можете выбирать сами.
    private static int[] ex5(int arr[], int number) {
        if (number > 0) {
            for (int i = 1; i <= number; i++) {
                int temp = arr[arr.length - 1];   // последний элемент
                for (int j = arr.length - 1; j > 0; j--){
                    arr[j] = arr[j - 1];
                }
                arr[0] = temp;
            }
        }
        if (number < 0){
            for (int i = -1; i >= number; i--) {
                int temp = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}

