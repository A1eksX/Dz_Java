package Dz_Seminar6;

import java.util.HashSet;
import java.util.Set;
/*
    1. Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
    2. Создать множество ноутбуков.
    3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
    отвечающие фильтру. Критерии фильтрации можно хранить в Map.
    Например:
    Введите цифру, соответствующую необходимому критерию:
    1 - ОЗУ
    2 - Объём ЖД
    3 - Операционная система
    4 - Цвет …

    Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
    Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */
public class Main {
    public static void main(String[] args) {
// Создание объектов класса Laptop
        Laptop hp = new Laptop("hp", 16,1000, 16, "windows", "black");
        Laptop xiaomi_62 = new Laptop("xiaomi_62", 14, 512, 32, "ios", "white");
        Laptop samsung_123 = new Laptop("samsung_123", 15,256, 32, "ios", "black");
        Laptop samsung_345 = new Laptop("samsung_345", 16,1000, 16, "linux", "black");
        Laptop lenovo_x756 = new Laptop("lenovo_x756", 16,512, 16, "windows", "white");
        Laptop macbook_pro = new Laptop("macbook_pro", 17,1000, 8, "ios", "white");
        Laptop asus_Extenza_3746B = new Laptop("asus_Extenza_3746B", 17,128, 4, "linux", "red");
        Laptop acer_X5 = new Laptop("acer_X5", 17,128, 8, "linux", "black");
        Laptop acer_2101 = new Laptop("acer_2101" ,16,512, 16, "windows", "gray");
        Laptop msi_katana_123 = new Laptop("msi_katana_123", 15,512, 8, "windows", "gray");

// Создание множества
        Set <Laptop> laptop = new HashSet<>();
        laptop.add(hp);
        laptop.add(xiaomi_62);
        laptop.add(samsung_123);
        laptop.add(samsung_345);
        laptop.add(lenovo_x756);
        laptop.add(macbook_pro);
        laptop.add(asus_Extenza_3746B);
        laptop.add(acer_X5);
        laptop.add(acer_2101);
        laptop.add(msi_katana_123);
// создание нового объекта вызова методов
        Laptop FilterLaptop = new Laptop();

// вызод метода фильтрации
        System.out.println(FilterLaptop.filter(laptop));
    }
}

