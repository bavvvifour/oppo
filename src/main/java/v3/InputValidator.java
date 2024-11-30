package v3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputValidator {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public static GoodsReceiptModel validateAndParse(String input) throws Exception {
        String[] parts = input.split("\\s+");

        if (parts.length < 3) {
            throw new Exception("Некорректное количество аргументов. Пример: 2023.09.15 \"Кофе\" 5");
        }

        LocalDate date = parseDate(parts[0]);

        String productName = parts[1].replaceAll("\"", "");
        int quantity = parseQuantity(parts[2]);

        return new GoodsReceiptModel(date, productName, quantity);
    }

    private static LocalDate parseDate(String dateStr) throws Exception {
        try {
            return LocalDate.parse(dateStr, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new Exception("Некорректный формат даты. Ожидается формат: yyyy.MM.dd");
        }
    }

    private static int parseQuantity(String quantityStr) throws Exception {
        try {
            return Integer.parseInt(quantityStr);
        } catch (NumberFormatException e) {
            throw new Exception("Количество должно быть целым числом.");
        }
    }
}
