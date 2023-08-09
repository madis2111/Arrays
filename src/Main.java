import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int productNumber;                  //номер продукта.
        int productCount;                   //количество продукта
        int currentPrice;                   //соотнесение введен. продукта и его цены
        int sumProducts = 0;                // итоговая сумма всех покупок
        int[] count = new int[3];           //массив для подсчета количества раз добавления товара
        int[] sumOfOneProduct = new int[3]; //массив для подсчета суммы по одному товару

        Scanner scanner = new Scanner(System.in);

        String[] products = {"хлеб", "яблоки", "молоко"};
        int[] prices = {100, 200, 300} ;

        System.out.println("список возможных товаров для покупки:");

        for (int i = 0; i < products.length; i++){
            System.out.println(i+1 + "." + products[i] + " " + prices[i] + " руб/шт");
        }

        while (true) {
            System.out.println("выберите товар и количество или введите end");
            String line = scanner.nextLine();
            if("end".equals(line)) {
                break;
            }

            String[] parts = line.split(" ");
            productNumber = Integer.parseInt(parts[0]) - 1;
            productCount = Integer.parseInt(parts[1]);
            currentPrice = prices[productNumber];
            count[productNumber] += productCount;
            sumOfOneProduct[productNumber] += productCount*currentPrice;
            sumProducts = sumProducts + productCount*currentPrice;
        }

        System.out.println("Ваша корзина: ");
        System.out.println("Наименование товара  Количество  цена за ед. общая стоимость");
        for (int i = 0; i<count.length;i++) {
            if (count[i] > 0) {
                System.out.println(products[i] + " " + count[i] +
                        " " + prices[i] + " " + sumOfOneProduct[i] + " руб.");
            }
        }

        System.out.println("Итого: " + sumProducts +" руб.");
    }
}