import java.io.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

// Class mới để lưu trữ item và số lượng

class ItemQuantity implements Serializable  //đây là lớp mới, đổi tên Item thành ItemQuantity và đã thêm Serializable để tiện việc lưu trữ vào file (bill.txt và billhistory.txt)
{
    Item item;
    int quantity;
    double currentDiscountedPrice; // Thêm thuộc tính để lưu giá khuyến mãi hiện tại

    public ItemQuantity(Item item, int quantity, double currentDiscountedPrice) //hàm tl có ts thêm thuộc tính sl và giá km
    {
        this.item = item;
        this.quantity = quantity;
        this.currentDiscountedPrice = currentDiscountedPrice;
    }

    // Giữ lại hàm tạo cũ để không ảnh hưởng đến các phần khác của mã
    public ItemQuantity(Item item, int quantity) //hàm tl có ts thêm thuộc tính sl
    {
        this.item = item;
        this.quantity = quantity;
        this.currentDiscountedPrice = item.getPrice(); // Mặc định bằng giá gốc
    }
}
class Bill implements Serializable {
    private Customer customer;//biến chứa thông tin khách hàng
    private ArrayList<ItemQuantity> itemQuantities;//khai báo array list của items được đổi têm thành  ItemQuantity
    private String id;
    private double totalAmount;//pt tính tổng hóa đơn chưa tính giá km
    private double discountedAmount;// pt tính tổng hóa đơn áp dụng giá km
    // final cho phương thức giống như const cho biến

    private static final String CURRENT_BILL_FILE = "bill.txt";//gán biến bằng tên file để đọc xuất dễ hơn
    private static final String HISTORY_BILL_FILE = "billhistory.txt";

    public Bill(Customer customer,String id) {
        this.customer = customer;
        this.itemQuantities = new ArrayList<>();
        this.totalAmount = 0.0;
        this.discountedAmount=0.0;
        this.id=id;
    }
    public void setid(String id)
    {
        this.id=id;
    }
    public String getid()
    {
        return id;
    }
    public Customer getcustomer() {
        return customer;
    }
    public void addItem(Item item, int quantity, double discount) {//hàm thêm item cho bill với thêm tham số giảm giá
        // Kiểm tra xem mảng item có chứa phần tử nào chưa trước khi xét số lượng item đó
        boolean found = false;
        for (ItemQuantity iq : itemQuantities) {
            if (iq.item.getId().equals(item.getId())) {// nếu id item đã có trong mảng thì sl sp mang id đó  +1
                iq.quantity += quantity;
                found = true;
                break;
            }
        }
        
        // Tính giá khuyến mãi riêng cho từng hóa đơn
        double discountedPrice = item.getPrice() * (1 - discount);
        
        // Nếu item chưa tồn tại, thêm mới biến quantity vào
        if (!found) {
            itemQuantities.add(new ItemQuantity(item, quantity, discountedPrice));
        }
        
        totalAmount += item.getPrice() * quantity;
        discountedAmount += discountedPrice * quantity;
    }
    public void displayBill() {//hàm hiển thị tất cả bill 
        System.out.println("ID hoa don:"+id);
        customer.displayInfo();
        System.out.println("Danh sach san pham can thanh toan:\n\n");
        for (ItemQuantity iq : itemQuantities) {
            if (iq.item instanceof Pen) //xét nếu loại sp là pen
            {
                System.out.println("Loai san pham: But  | Ten But: " + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " +  iq.currentDiscountedPrice + " dong | So luong: " + iq.quantity);
            }// sài pp xuất thủ công để thêm mục số lượng giúp tiết kiệm dữ liệu khi xuất & lưu vào file
    
             else if (iq.item instanceof Notebook) 
            
            {
                System.out.println("Loai san pham: Vo | Ten Vo: " + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " +  iq.currentDiscountedPrice + " dong | So luong: " + iq.quantity);
            }
             else if (iq.item instanceof Paper) 
            
            {
                System.out.println("Loai san pham: Giay In | Ten Giay In: " + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " +  iq.currentDiscountedPrice + " dong | So luong: " + iq.quantity);
            }
             else if (iq.item instanceof Eraser) 
            
            {
                System.out.println("Loai san pham: Gom | Ten Gom: " + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " +  iq.currentDiscountedPrice + " dong | So luong: " + iq.quantity);
            }
             else if (iq.item instanceof Glue) 
            
            {
                System.out.println("Loai san pham: Keo Dan | Ten Keo Dan:" + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " +  iq.currentDiscountedPrice + " dong | So luong: " + iq.quantity);
            }
             else if (iq.item instanceof Ruler) 
            
            {
                System.out.println("Loai san pham: Thuoc Ke | Ten Thuoc Ke:" + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " +  iq.currentDiscountedPrice + " dong | So luong: " + iq.quantity);
            }
             else if (iq.item instanceof Envelope) 
            
            {
                System.out.println("Loai san pham: Phong Bi | Ten Phong Bi:" + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " +  iq.currentDiscountedPrice + " dong | So luong: " + iq.quantity);
            }
             else if (iq.item instanceof Scissor) 
            
            {
                System.out.println("Loai san pham: Keo Cat Giay | Ten Keo Cat Giay:" + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " +  iq.currentDiscountedPrice + " dong | So luong: " + iq.quantity);
            }
             else if (iq.item instanceof NameTag) 
            
            {
                System.out.println("Loai san pham: Nhan Nhan Ten | Ten Nhan Nhan Ten:" + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " +  iq.currentDiscountedPrice + " dong | So luong: " + iq.quantity);
            }
             else if (iq.item instanceof BookJacket) 
            
            {
                System.out.println("Loai san pham: Bia Sach Vo | Ten Bia Sach Vo:" + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " +  iq.currentDiscountedPrice + " dong | So luong: " + iq.quantity);
            }
             else if (iq.item instanceof ChalkBoard) 
            
            {
                System.out.println("Loai san pham: Bang Phan | Ten Bang Phan:" + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " +  iq.currentDiscountedPrice + " dong | So luong: " + iq.quantity);
            }
             else if (iq.item instanceof Chalk) 
            
            {
                System.out.println("Loai san pham: Phan Bang | Ten Phan Bang:" + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " +  iq.currentDiscountedPrice + " dong | So luong: " + iq.quantity);
            }
             else if (iq.item instanceof Book) 
            
            {
                System.out.println("Loai san pham: Sach | Ten Sach:" + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " +  iq.currentDiscountedPrice + " dong | So luong: " + iq.quantity);
            }
             else if (iq.item instanceof NotePaper) { 
            
            {
                System.out.println("Loai san pham: Giay Ghi Chu | Ten Giay Ghi Chu:" + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " +  iq.currentDiscountedPrice + " dong | So luong: " + iq.quantity);
            }

        }
    }
    System.out.println("\nTong tien (chua giam tru): " + totalAmount+" dong");
    System.out.println("Tong so tien can thanh toan: " + discountedAmount+" dong");
}

    public double getTotalAmount() {
        // phương thức lấy tổng tiền chưa km
        return totalAmount;
    }


// Phương thức lưu hóa đơn hiện tại vào file bill.txt
public static void saveBillToFile(ArrayList<Bill> bills) {
    try (FileWriter writer = new FileWriter(CURRENT_BILL_FILE)) {//try catch là phép thử nếu code xảy ra lỗi thì thực hiện lệnh trong khối lệnh catch
        // writer là biến đọc file giống cú pháp Scanner

        writer.write("=== HOA DON VAN PHONG PHAM ===\n\n");
        String timestamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());// in thời gian lưu vào file
        writer.write("Thoi gian: " + timestamp + "\n\n");
        for (Bill bill : bills) {
            writer.write("ID hoa don: "+bill.id+"\n");
            writer.write("Khach hang: " + bill.customer.getName() + "\n");
            writer.write("SDT: " + bill.customer.getPhone() + "\n");
            writer.write("ID khach: "+bill.customer.getid());
            writer.write("\n\nDanh sach san pham:\n");
            for (ItemQuantity iq : bill.itemQuantities) {
                writer.write("\n_ " + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " + iq.currentDiscountedPrice +  " dong | So luong: " + iq.quantity );
            }
            writer.write("\n\nTong tien (chua giam tru): " + bill.totalAmount + " dong\n");
            writer.write("Thanh tien: " + bill.discountedAmount + " dong\n");
            writer.write("==============================================\n\n");
        }
        System.out.println("Da luu hoa don vao file " + CURRENT_BILL_FILE);
        
        // Đồng thời lưu vào lịch sử
        appendToHistory(bills);
        
    } 
    catch (IOException e)
    //khi bắt được lỗi input ouput file thì nó sẽ xuất thông báo lỗi mà không ảnh hương tới chương trình
    
    {
        System.out.println("Loi khi luu file: " + e.getMessage());
    }
}

// Phương thức lưu vào file lịch sử hóa đơn billhistory.txt
private static void appendToHistory(ArrayList<Bill> bills) {
    try (FileWriter writer = new FileWriter(HISTORY_BILL_FILE, true)) { // true để append giúp thêm nội dung mới vào cuối tệp mà không ghi đè lên dữ liệu cũ.

        writer.write("=== HOA DON VAN PHONG PHAM  ===\n");
        String timestamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        writer.write("Thoi gian: " + timestamp + "\n\n");
        for (Bill bill : bills) {
            writer.write("ID hoa don: "+bill.id);
            writer.write("\nKhach hang: " + bill.customer.getName() + "\n");
            writer.write("SDT: " + bill.customer.getPhone() + "\n");
            writer.write("ID khach: "+bill.customer.getid());

            writer.write("\n\nDanh sach san pham:\n");
            for (ItemQuantity iq : bill.itemQuantities) {
                writer.write("\n_ " + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " + iq.currentDiscountedPrice +  " dong | So luong: " + iq.quantity);
            }
            writer.write("\n\nTong tien (chua giam tru): " + bill.totalAmount + " dong\n");
            writer.write("Thanh tien: " + bill.discountedAmount + " dong\n");

            writer.write("==============================================\n\n");
        }
    } catch (IOException e) {
        System.out.println("Loi khi luu lich su: " + e.getMessage());
    }
}

    // Phương thức đọc hóa đơn từ file bill.txt
    public static void readBillFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CURRENT_BILL_FILE))) {//BufferedReader đọc dữ liệu một cách hiệu quả bằng cách sử dụng bộ đệm nội bộ.
            String line;
            System.out.println("\nDoc hoa don tu file " + CURRENT_BILL_FILE + ":");
            while ((line = reader.readLine()) != null) {// đọc file từng dòng
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {//lỗi không tìm thấy file
            System.out.println("Khong tim thay file " + CURRENT_BILL_FILE);
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }

    // Phương thức đọc lịch sử hóa đơn từ file billhistory.txt
    public static void readBillHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(HISTORY_BILL_FILE))) {
            String line;
            System.out.println("\nLich su hoa don tu file " + HISTORY_BILL_FILE + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Chua co du lieu lich su hoa don");
        } catch (IOException e) {
            System.out.println("Loi khi doc lich su: " + e.getMessage());
        }
    }

}
