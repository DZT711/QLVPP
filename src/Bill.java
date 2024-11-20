import java.io.Serializable;
import java.util.ArrayList;

class Bill implements Serializable {
    private Customer customer;
    private ArrayList<Item> items;
    private double totalAmount;

    // (1đ) Lớp mảng các đối tượng (danh sách)
    public Bill(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    // (1đ) Đọc và ghi dữ liệu lên file (text)
    public void addItem(Item item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(item);
            totalAmount += item.getPrice();
        }
    }

    public void displayBill() {
        customer.displayInfo();
        System.out.println("Dung cu thanh toan:");
        for (Item item : items) {
            item.displayInfo(); // Gọi phương thức displayInfo() (đa hình)
        }
        System.out.println("So luong: " + totalAmount);
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
