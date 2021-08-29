import java.util.Scanner;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] prices = new int[] {100, 200, 300};
        String[] products = new String[]{"Хлеб", "Яблоки", "Молоко"};
        int currentPrice = 0;
        int[] count = new int[3];

        System.out.printf("%s %9s %6s", "Number", "Name", "Price");
        System.out.println("");

        for (int i = 1; i <= 3; i++) System.out.printf("%3s %12s %4d\n", i,products[i - 1], prices[i - 1]);

        while(true) {
            System.out.print("Введите номер продукта: ");
            String input = scanner.nextLine();
            if("end".equals(input)){
                break;
            }
            System.out.print("Введите количество: ");
            int amount = scanner.nextInt();

            try {
                int productNumber = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число");
            }

            int productNumber = Integer.parseInt(input);
            currentPrice = currentPrice + (prices[productNumber - 1] * amount);
            scanner.nextLine();
            count[productNumber - 1] = count[productNumber - 1] + amount;
        }
        System.out.println("Ваша корзина:");
        System.out.printf("%s %9s %6s %s\n", "Наименование товара", "Количество", "Цена/за.ед", "Общая " + "стоимость");
        for (int i = 0; i < 3; i++){
            int priceOfproduct = count[i] * prices[i];
            System.out.printf("%s %9s %6s %s\n", products[i], count[i], priceOfproduct, currentPrice);
        }
    }
}