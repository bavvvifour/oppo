package v3;

import java.time.LocalDate;

public class GoodsReceiptModel {
    private final LocalDate date;
    private final String productName;
    private final int quantity;

    public GoodsReceiptModel(LocalDate date, String productName, int quantity) {
        this.date = date;
        this.productName = productName;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "GoodsReceiptModel{" +
                "date=" + date +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
