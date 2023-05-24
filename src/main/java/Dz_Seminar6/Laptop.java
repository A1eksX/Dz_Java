package Dz_Seminar6;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Создание класса Laptop
public class Laptop {
    // Создание полей
    String model;
    int diagonal;
    int hdd;
    int ram;
    String os;
    String color;
    // Создание пустого конструктора для работы с методами
    public Laptop() {
    }
    // Создание конструктора для создания экземпляров класса
    public Laptop(String model, int diagonal, int hdd, int ram, String os, String color) {
        this.model = model;
        this.diagonal = diagonal;
        this.hdd = hdd;
        this.ram = ram;
        this.os = os;
        this.color = color;
    }

    // создание метода фильтрации ноутбуков
    public Set<Laptop> filter(Set<Laptop> laptop) {
        Scanner input = new Scanner(System.in);
        Set<Laptop> listLaptop = new HashSet<>(laptop);

        System.out.println("Укажите номер критерия фильрации ноутбуков," +
                "\n1. Размер экрана 2. Жёсткий диск 3. Оперативная память 4. Тип ОС 5. Цвет");
        String request = input.nextLine();

        for (int i = 0; i < request.length(); i++) {
            if (Character.getNumericValue(request.charAt(i)) == 1){
                System.out.println("Укажите диагональ экрана ноутбука: 14, 15, 16, 17");
                int diagonalLaptop = input.nextInt();

                for (Laptop tempDiag: laptop) {
                    if(diagonalLaptop != tempDiag.diagonal){
                        listLaptop.remove(tempDiag);
                    }
                }
            }
            if (Character.getNumericValue(request.charAt(i)) == 2) {
                System.out.println("Укажите размер жёсткого диска в Гб: 128, 256, 512");
                int enterHardDisk = input.nextInt();

                for (Laptop tempLaptop : laptop) {
                    if (enterHardDisk != tempLaptop.hdd) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }

            if (Character.getNumericValue(request.charAt(i)) == 3) {
                System.out.println("Укажите объём оперативной памяти в Гб: 8, 16, 32, 64 ");
                int operativeMemory = input.nextInt();

                for (Laptop tempLaptop : laptop) {
                    if (operativeMemory != tempLaptop.ram) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }

            if (Character.getNumericValue(request.charAt(i)) == 4) {
                System.out.println("Укажите операционную систему: Windows, Linux, iOS");
                String enterOS = input.nextLine().toLowerCase();

                for (Laptop tempLaptop : laptop) {
                    if ((!enterOS.equals(tempLaptop.os))) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }

            if (Character.getNumericValue(request.charAt(i)) == 5) {
                System.out.println("Укажите цвет ноутбука: black, white, gray, red");
                String enterColor = input.nextLine().toLowerCase();
                for (Laptop tempLaptop : laptop) {
                    if (!(enterColor.equals(tempLaptop.color))) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }
        }
        return listLaptop;
    }

    // метод toString, выводит на экран данные объекта
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(model).append("   ").append("цвет ").append(color).append(" ").append("память ").append(ram).append(" Gb").append(" ")
                .append("ОС ").append(os).append(" ").append("диск ").append(hdd).append(" Gb").append(" ")
                .append("размер экрана ").append(diagonal).append("\"").append("\n");
        return builder.toString();
    }
}
