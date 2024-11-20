import java.io.Serializable;

// (1đ) Có interface
interface Discountable {
    void applyDiscount(); // Phương thức trừu tượng cho giảm giá
}

// (1đ) Lớp trừu tượng Item
abstract class Item implements Serializable {
    protected String id;
    protected String name;
    protected double price;
    
    // (1đ) Thuộc tính static
    protected static int itemCount = 0;

    // (1đ) Hàm thiết lập (constructor)
    public Item(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        itemCount++;
    }

    // (1đ) Hàm trừu tượng (abstract)
    public abstract void displayInfo();

    // Phương thức static
    public static int getTotalItems() {
        return itemCount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

// (1đ) Lớp Pen kế thừa từ Item
class Pen extends Item implements Discountable {
    private String color;

    // (1đ) Hàm thiết lập (constructor)
    public Pen(String id, String name, double price, String color) {
        super(id, name, price);
        this.color = color;
    }

    @Override
    public void displayInfo() {
        System.out.println("Ten but: " + name + " | Mua: " + color + " | Don gia: " + price);
    }

    // (1đ) Cài đặt và sử dụng đa hình
    @Override
    public void applyDiscount() {
        this.price *= 0.9; // Giảm giá 10%
    }
}

// (1đ) Lớp Notebook kế thừa từ Item
class Notebook extends Item implements Discountable {
    private int pages;

    // (1đ) Hàm thiết lập (constructor)
    public Notebook(String id, String name, double price, int pages) {
        super(id, name, price);
        this.pages = pages;
    }

    @Override
    public void displayInfo() {
        System.out.println("Ten so ghi chu: " + name + " | So trang: " + pages + " | Don gia: " + price);
    }

    // (1đ) Cài đặt và sử dụng đa hình
    @Override
    public void applyDiscount() {
        this.price *= 0.85; // Giảm giá 15%
    }
}
