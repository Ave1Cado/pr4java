import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Массив названий фирм часов
        String[] firms = {"Rolex", "Gshok", "Apple"};

        // Двумерный массив, связывающий фирмы с марками
        String[][] watches = {
                {"Rolex", "UltraDorogo"},
                {"Gshok", "Biambam"},
                {"Apple", "Watch"}
        };

        // Создание массива покупателей
        ArrayList<Customer> customers = new ArrayList<>();

        // Создание заказов
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите данные покупателя " + (i + 1) + ":");
            System.out.print("ФИО: ");
            String name = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Номер телефона: ");
            String phone = scanner.nextLine();

            // Вывод списка позиций товаров
            System.out.println("Список имеющихся позиций в магазине:");
            for (int j = 0; j < firms.length; j++) {
                System.out.println((j + 1) + ". " + watches[j][1] + " - " + firms[j]);
            }

            // Ввод позиции товара и количества
            System.out.print("Выберите позицию товара (введите номер): ");
            int position = scanner.nextInt() - 1;
            scanner.nextLine(); // Считываем лишний перевод строки после nextInt()
            System.out.print("Введите количество: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Считываем лишний перевод строки после nextInt()

            // Создание объекта покупателя и добавление его в список
            Customer customer = new Customer(name, email, phone, watches[position], quantity);
            customers.add(customer);
        }

        // Вывод информации о заказах
        System.out.println("\nИнформация о заказах:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}

// Класс для представления покупателя
class Customer {
    private String name;
    private String email;
    private String phone;
    private String[] position;
    private int quantity;

    public Customer(String name, String email, String phone, String[] position, int quantity) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.position = position;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Покупатель: " + name +
                "\nEmail: " + email +
                "\nНомер телефона: " + phone +
                "\nТовар: " + position[1] + " (" + position[0] + ")" +
                "\nКоличество: " + quantity + "\n";
    }
}
