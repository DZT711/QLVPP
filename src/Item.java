import java.io.Serializable;// thư viện giúp lưu trữ vào file (bill.txt và billhistory.txt)
import java.util.*;
//  Có interface
interface Discountable {
    double applyDiscount(double discount); // Phương thức trừu tượng cho giảm giá
}

//  Lớp trừu tượng Item
abstract class Item implements Serializable {
    protected String id;
    protected String name;
    protected double price;
    protected double discountedPrice;
    //  Thuộc tính static
    protected static int itemCount = 0;
            // Thêm phương thức abstract applyDiscount
    public abstract double applyDiscount(double discount);
    

    //  Hàm thiết lập 
    public Item(String id, String name, double price, double discountedPrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountedPrice=discountedPrice;
        itemCount++;
    }

    //  Hàm trừu tượng 
    public abstract void displayInfo();

    // Phương thức static
    public static int getTotalItems() {
        return itemCount;
    }
    public double getdiscountedPrice(){
        return discountedPrice;
    }
    public String getId() {
        return id;
    }
    public void setName(String name){
        this.name=name;
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

//  Lớp Pen kế thừa từ Item
class Pen extends Item implements Discountable {
    private String color;

    //  Hàm thiết lập 
    public Pen(String id, String name, double price, String color, double discountedPrice) {
        super(id, name, price, discountedPrice);
        this.color = color;
    }

    
    //  Cài đặt và sử dụng đa hình
    @Override
    public double applyDiscount(double discount) {
        Scanner z=new Scanner(System.in);

        discountedPrice = this.price*(1-discount); // Giảm giá 10% 
        //lấy giá gốc nhân với (1-%giảm)= giá sau khi giảm
        return discountedPrice;
    }
    @Override
    public void displayInfo() {
        System.out.println("Loai san pham: But bi  | Ten san pham: " + name + " |  Mau: " + color + " | Don gia: " + price+ " dong | Don gia ap dung khuyen mai: "+discountedPrice+ " dong");
    }
}

//  Lớp Notebook kế thừa từ Item
class Notebook extends Item implements Discountable {
    private int pages;

    //  Hàm thiết lập 
    public Notebook(String id, String name, double price, int pages, double discountedPrice) {
        super(id, name, price, discountedPrice);
        this.pages = pages;
    }

    
    //  Cài đặt và sử dụng đa hình
    @Override
    public double applyDiscount(double discount) {
        Scanner z=new Scanner(System.in);

        discountedPrice = this.price*(1-discount); // Giảm giá 10% 
        //lấy giá gốc nhân với (1-%giảm)= giá sau khi giảm
        return discountedPrice;
    }
    @Override
    public void displayInfo() {
        System.out.println("Loai san pham: So ghi chu | Ten san pham: " + name + " |  So trang: " + pages + " | Don gia: " + price+" dong | Don gia ap dung khuyen mai: "+discountedPrice+ " dong");
    }
}

