package v3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] testInputs = {
                "2023.09.15 \"Кофе\" 5",
                "2022.12.31 \"Чай\" 10",
                "2024.01.01 \"Сахар\" 100",
                "2023-09-15 \"Кофе\" 5",
                "2023.09.15 \"Кофе\" пять",
                "2023.09.15 Кофе 5",
                "2023.09.15",
                "2023.09.15 \"Кофе\"",
                "15.09.2023 \"Кофе\" 5"
        };

        for (String input : testInputs) {
            System.out.println("Ввод: " + input);
            try {
                GoodsReceiptModel model = InputValidator.validateAndParse(input);
                System.out.println("Созданный объект: " + model);
            } catch (Exception e) {
                System.out.println("Ошибка при обработке строки: " + e.getMessage());
            }
            System.out.println();
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите описание объекта.");
            System.out.println("Пример: 2023.09.15 \"Кофе\" 5");
            System.out.println("Введите 'exit', чтобы выйти из программы.");

            while (true) {
                System.out.print("Введите данные: ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Программа завершена.");
                    break;
                }

                try {
                    GoodsReceiptModel model = InputValidator.validateAndParse(input);
                    System.out.println("Созданный объект: " + model);
                } catch (Exception e) {
                    System.out.println("Ошибка при обработке строки: " + e.getMessage());
                }
            }
        }
    }
}
