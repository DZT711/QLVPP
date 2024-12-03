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
    public void setdiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
    public void setId(String id)
    {
        this.id=id;
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

    public String getcolor(){
        return color;
    }
    
    //  Cài đặt và sử dụng đa hình
    @Override
    public double applyDiscount(double discount) {
        Scanner z=new Scanner(System.in);

        discountedPrice = this.price*(1-discount); // Giảm giá 
        //lấy giá gốc nhân với (1-%giảm)= giá sau khi giảm
        return discountedPrice;
    }
    @Override
    public void displayInfo() {
        System.out.println("Loai san pham: But   | Ten san pham: " + name + " | ID : "+id+ "|  Mau : " + color + " | Don gia: " + price+ " dong" );
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


    public int getpages(){

        return pages;
    }
    //  Cài đặt và sử dụng đa hình
    @Override
    public double applyDiscount(double discount) {
        Scanner z=new Scanner(System.in);

        discountedPrice = this.price*(1-discount); // Giảm giá 
        //lấy giá gốc nhân với (1-%giảm)= giá sau khi giảm
        return discountedPrice;
    }
    @Override
    public void displayInfo() {
        System.out.println("Loai san pham: Vo | Ten san pham: " + name + " |  ID : "+id+ " |  So trang: " + pages + " | Don gia: " + price+" dong" );
    }
}

class Paper extends Item implements Discountable {
    private String size;

    //  Hàm thiết lập 
    public Paper(String id, String name, double price, String size, double discountedPrice) {
        super(id, name, price, discountedPrice);
        this.size = size;
    }

    public String getsize(){
        return size;
    }
    
    //  Cài đặt và sử dụng đa hình
    @Override
    public double applyDiscount(double discount) {
        Scanner z=new Scanner(System.in);

        discountedPrice = this.price*(1-discount); // Giảm giá 
        //lấy giá gốc nhân với (1-%giảm)= giá sau khi giảm
        return discountedPrice;
    }
    @Override
    public void displayInfo() {
        System.out.println("Loai san pham: Giay in   | Ten san pham: " + name + " | ID : "+id+ "|  Kich co : " + size + " | Don gia: " + price+ " dong" );
    }
}

class Eraser extends Item implements Discountable {
    private String material;

    //  Hàm thiết lập 
    public Eraser(String id, String name, double price, String material, double discountedPrice) {
        super(id, name, price, discountedPrice);
        this.material = material;
    }

    public String getmaterial(){
        return material;
    }
    
    //  Cài đặt và sử dụng đa hình
    @Override
    public double applyDiscount(double discount) {
        Scanner z=new Scanner(System.in);

        discountedPrice = this.price*(1-discount); // Giảm giá 
        //lấy giá gốc nhân với (1-%giảm)= giá sau khi giảm
        return discountedPrice;
    }
    @Override
    public void displayInfo() {
        System.out.println("Loai san pham: Gom   | Ten san pham: " + name + " | ID : "+id+ "|  Chat lieu : " + material + " | Don gia: " + price+ " dong" );
    }
}

class Glue extends Item implements Discountable {
private String type;

    //  Hàm thiết lập 
    public Glue(String id, String name, double price, String type, double discountedPrice) {
        super(id, name, price, discountedPrice);
        this.type = type;
    }

    public String gettype(){
        return type;
    }
    
    //  Cài đặt và sử dụng đa hình
    @Override
    public double applyDiscount(double discount) {
        Scanner z=new Scanner(System.in);

        discountedPrice = this.price*(1-discount); // Giảm giá 
        //lấy giá gốc nhân với (1-%giảm)= giá sau khi giảm
        return discountedPrice;
    }
    @Override
    public void displayInfo() {
        System.out.println("Loai san pham: Keo dan   | Ten san pham: " + name + " | ID : "+id+ "|  Loai keo dan : " + type + " | Don gia: " + price+ " dong" );
    }
}

class Ruler extends Item implements Discountable {
private String type;

    //  Hàm thiết lập 
    public Ruler(String id, String name, double price, String type, double discountedPrice) {
        super(id, name, price, discountedPrice);
        this.type = type;
    }

    public String gettype(){
        return type;
    }
    
    //  Cài đặt và sử dụng đa hình
    @Override
    public double applyDiscount(double discount) {
        Scanner z=new Scanner(System.in);

        discountedPrice = this.price*(1-discount); // Giảm giá 
        //lấy giá gốc nhân với (1-%giảm)= giá sau khi giảm
        return discountedPrice;
    }
    @Override
    public void displayInfo() {
        System.out.println("Loai san pham: Thuoc   | Ten san pham: " + name + " | ID : "+id+ "|  Kieu thuoc : " + type + " | Don gia: " + price+ " dong" );
    }
}

class Envelope extends Item implements Discountable {
    private String color;

    //  Hàm thiết lập 
    public Envelope(String id, String name, double price, String color, double discountedPrice) {
        super(id, name, price, discountedPrice);
        this.color = color;
    }

    public String getcolor(){
        return color;
    }
    
    //  Cài đặt và sử dụng đa hình
    @Override
    public double applyDiscount(double discount) {
        Scanner z=new Scanner(System.in);

        discountedPrice = this.price*(1-discount); // Giảm giá 
        //lấy giá gốc nhân với (1-%giảm)= giá sau khi giảm
        return discountedPrice;
    }
    @Override
    public void displayInfo() {
        System.out.println("Loai san pham: Phong bi   | Ten san pham: " + name + " | ID : "+id+ "|  Mau phong bi : " + color + " | Don gia: " + price+ " dong" );
    }
}

class Scissor extends Item implements Discountable {
    private String ScissorBlades;

    //  Hàm thiết lập 
    public Scissor(String id, String name, double price, String ScissorBlades, double discountedPrice) {
        super(id, name, price, discountedPrice);
        this.ScissorBlades = ScissorBlades;
    }

    public String getScissorBlades(){
        return ScissorBlades;
    }
    
    //  Cài đặt và sử dụng đa hình
    @Override
    public double applyDiscount(double discount) {
        Scanner z=new Scanner(System.in);

        discountedPrice = this.price*(1-discount); // Giảm giá 
        //lấy giá gốc nhân với (1-%giảm)= giá sau khi giảm
        return discountedPrice;
    }
    @Override
    public void displayInfo() {
        System.out.println("Loai san pham: Keo cat giay   | Ten san pham: " + name + " | ID : "+id+ "|  Loai luoi keo : " + ScissorBlades + " | Don gia: " + price+ " dong" );
    }
}

class NameTag extends Item implements Discountable {
    private String NameTagShape;

    //  Hàm thiết lập 
    public NameTag(String id, String name, double price, String NameTagShape, double discountedPrice) {
        super(id, name, price, discountedPrice);
        this.NameTagShape = NameTagShape;
    }

    public String getNameTagShape(){
        return NameTagShape;
    }
    
    //  Cài đặt và sử dụng đa hình
    @Override
    public double applyDiscount(double discount) {
        Scanner z=new Scanner(System.in);

        discountedPrice = this.price*(1-discount); // Giảm giá 
        //lấy giá gốc nhân với (1-%giảm)= giá sau khi giảm
        return discountedPrice;
    }
    @Override
    public void displayInfo() {
        System.out.println("Loai san pham: Nhan ten   | Ten san pham: " + name + " | ID : "+id+ "|  Hinh dang nhan ten : " + NameTagShape + " | Don gia: " + price+ " dong" );
    }
}

class BookJacket extends Item implements Discountable {
    private String type;

    //  Hàm thiết lập 
    public BookJacket(String id, String name, double price, String type, double discountedPrice) {
        super(id, name, price, discountedPrice);
        this.type = type;
    }

    public String gettype(){
        return type;
    }
    
    //  Cài đặt và sử dụng đa hình
    @Override
    public double applyDiscount(double discount) {
        Scanner z=new Scanner(System.in);

        discountedPrice = this.price*(1-discount); // Giảm giá 
        //lấy giá gốc nhân với (1-%giảm)= giá sau khi giảm
        return discountedPrice;
    }
    @Override
    public void displayInfo() {
        System.out.println("Loai san pham: Bia bao sach vo   | Ten san pham: " + name + " | ID : "+id+ "|  Kieu bia bao : " + type + " | Don gia: " + price+ " dong" );
    }
}

class ChalkBoard extends Item implements Discountable {
    private String size;

    //  Hàm thiết lập 
    public ChalkBoard(String id, String name, double price, String size, double discountedPrice) {
        super(id, name, price, discountedPrice);
        this.size = size;
    }

    public String getsize(){
        return size;
    }
    
    //  Cài đặt và sử dụng đa hình
    @Override
    public double applyDiscount(double discount) {
        Scanner z=new Scanner(System.in);

        discountedPrice = this.price*(1-discount); // Giảm giá 
        //lấy giá gốc nhân với (1-%giảm)= giá sau khi giảm
        return discountedPrice;
    }
    @Override
    public void displayInfo() {
        System.out.println("Loai san pham: Bang phan   | Ten san pham: " + name + " | ID : "+id+ "|  Kich thuoc (chieu rong x chieu dai) : " + size + " | Don gia: " + price+ " dong" );
    }
}
class Chalk extends Item implements Discountable {
    private String color;

    //  Hàm thiết lập 
    public Chalk(String id, String name, double price, String color, double discountedPrice) {
        super(id, name, price, discountedPrice);
        this.color = color;
    }

    public String getcolor(){
        return color;
    }
    
    //  Cài đặt và sử dụng đa hình
    @Override
    public double applyDiscount(double discount) {
        Scanner z=new Scanner(System.in);

        discountedPrice = this.price*(1-discount); // Giảm giá 
        //lấy giá gốc nhân với (1-%giảm)= giá sau khi giảm
        return discountedPrice;
    }
    @Override
    public void displayInfo() {
        System.out.println("Loai san pham: Phan viet bang   | Ten san pham: " + name + " | ID : "+id+ "|  Mau phan : " + color + " | Don gia: " + price+ " dong" );
    }
}

class Book extends Item implements Discountable {
    private String author;

    //  Hàm thiết lập 
    public Book(String id, String name, double price, String author, double discountedPrice) {
        super(id, name, price, discountedPrice);
        this.author = author;
    }

    public String getauthor(){
        return author;
    }
    
    //  Cài đặt và sử dụng đa hình
    @Override
    public double applyDiscount(double discount) {
        Scanner z=new Scanner(System.in);

        discountedPrice = this.price*(1-discount); // Giảm giá 
        //lấy giá gốc nhân với (1-%giảm)= giá sau khi giảm
        return discountedPrice;
    }
    @Override
    public void displayInfo() {
        System.out.println("Loai san pham: Sach   | Ten san pham: " + name + " | ID : "+id+ "|  Tac gia : " + author + " | Don gia: " + price+ " dong" );
    }
}
class NotePaper extends Item implements Discountable {
    private String color;

    //  Hàm thiết lập 
    public NotePaper(String id, String name, double price, String color, double discountedPrice) {
        super(id, name, price, discountedPrice);
        this.color = color;
    }

    public String getcolor(){
        return color;
    }
    
    //  Cài đặt và sử dụng đa hình
    @Override
    public double applyDiscount(double discount) {
        Scanner z=new Scanner(System.in);

        discountedPrice = this.price*(1-discount); // Giảm giá 
        //lấy giá gốc nhân với (1-%giảm)= giá sau khi giảm
        return discountedPrice;
    }
    @Override
    public void displayInfo() {
        System.out.println("Loai san pham: Giay ghi chu   | Ten san pham: " + name + " | ID : "+id+ "|  Mau giay : " + color + " | Don gia: " + price+ " dong" );
    }
}