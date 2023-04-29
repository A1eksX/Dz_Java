package Dz_Seminar2;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        ex1("F:\\Java");
        ex2();
    }
    private static void ex2() {
// 1. Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
// используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
//        Пример 1:
// Параметры для фильтрации: {"name:Ivanov", "country:Russia", "city:Moscow", "age:null"}
// Результат: SELECT * FROM USER WHERE name = 'Ivanov' and country = 'Russia' and city = 'Moscow';
//        Пример 2:
// Параметры для фильтрации: {"name:null", "country:null", "city:null", "age:null"}
// Результат: SELECT * FROM USER;
        String as = "\" name:Ivanov\", \"country:Russia\", \"city:Moscow\", \"age:null\"";
        String[] select = as.split("\",\"?\\s+\"?|:\"?");
        String request = "SELECT * FROM USER WHERE";
        StringBuilder sb = new StringBuilder(request);
        String check = "null";
        String qwer = " end ";
        String result;
        int len = qwer.length();
        boolean retVal;

        for (int i = 0; i < select.length - 1; i+= 2) {
            String elemArrSelect = select[i].replace("\"", ""); //убираем кавычки в начале
            String elemArSelect1 = select[i + 1].replace("\"", ""); //убираем кавычки в конце
            retVal = check.equalsIgnoreCase(elemArSelect1);
            if (!retVal) {
                String a = elemArrSelect + " = " + "'" + elemArSelect1 + "'";
                sb.append(a).append(qwer);
            }
        }
        result = sb.toString();
        result = result.substring(0, result.length() - 5); //убираем последние 5 элементов строки (" end ")
        System.out.println(result);
    }


    private static void ex1(String pathDir) {
//        Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида:
//        1 Расширение файла: txt
//        2 Расширение файла: pdf
//        3 Расширение файла:
//        4 Расширение файла: jpg
        File expansion = new File(pathDir);
        StringBuilder sb = new StringBuilder();
        String extension = "";
        for (String nameExpansion : expansion.list()) {
            int index = nameExpansion.lastIndexOf('.');
            if (index >= 0){
                extension = nameExpansion.substring(index);
                sb.append(extension).append(System.lineSeparator());
            }
        }
        System.out.println(sb);
    }






}
