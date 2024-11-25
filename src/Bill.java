import java.io.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

// Class mới để lưu trữ item và số lượng
class ItemQuantity implements Serializable {
    Item item;
    int quantity;

    public ItemQuantity(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}

class Bill implements Serializable {
    private Customer customer;
    private ArrayList<ItemQuantity> itemQuantities;
    private double totalAmount;
    private double discountedAmount;
// final giong nhu const
    private static final String CURRENT_BILL_FILE = "bill.txt";//gán biến bằng tên file để đọc xuất dễ hơn
    private static final String HISTORY_BILL_FILE = "billhistory.txt";

    public Bill(Customer customer) {
        this.customer = customer;
        this.itemQuantities = new ArrayList<>();
        this.totalAmount = 0.0;
        this.discountedAmount=0.0;
    }

    public void addItem(Item item, int quantity) {//hàm thêm item cho bill
        // Kiểm tra xem item đã tồn tại chưa
        boolean found = false;
        for (ItemQuantity iq : itemQuantities) {
            if (iq.item.getId().equals(item.getId())) {
                iq.quantity += quantity;
                found = true;
                break;
            }
        }
        
        // Nếu item chưa tồn tại, thêm mới
        if (!found) {
            itemQuantities.add(new ItemQuantity(item, quantity));
        }
        
        totalAmount += item.getPrice() * quantity;
        discountedAmount += item.getdiscountedPrice() * quantity;
    }

    public void displayBill() {//hàm hiển thị tất cả bill 
        customer.displayInfo();
        System.out.println("Danh sach san pham can thanh toan:\n");
        for (ItemQuantity iq : itemQuantities) {
            if (iq.item instanceof Pen) //xét nếu sp là pen
            {
                System.out.println("Loai san pham: But bi | Ten but: " + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " +  iq.item.getdiscountedPrice() + " dong | So luong: " + iq.quantity);

                    
                   
            } else if (iq.item instanceof Notebook) 
            {
                System.out.println("Loai san pham: So ghi chu | Ten so ghi chu" + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " +  iq.item.getdiscountedPrice() + " dong | So luong: " + iq.quantity);


                    
            }
        }
        System.out.println("\nTong tien (chua giam tru): " + totalAmount+" dong");
        System.out.println("Tong so tien can thanh toan: " + discountedAmount+" dong");
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // Phương thức lưu hóa đơn hiện tại vào file bill.txt
    public static void saveBillToFile(ArrayList<Bill> bills) {
        try (FileWriter writer = new FileWriter(CURRENT_BILL_FILE)) {//try catch là phép thử nếu code xảy ra lỗi thì thực hiện lệnh trong khối lệnh catch
            // writer là biến đọc file giống cú pháp Scanner

            writer.write("=== HOA DON VAN PHONG PHAM ===\n");
            String timestamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());// in thời gian lưu vào file
            writer.write("Thoi gian: " + timestamp + "\n\n");
            
            for (Bill bill : bills) {
                writer.write("Khach hang: " + bill.customer.getName() + "\n");
                writer.write("SDT: " + bill.customer.getPhone() + "\n");
                writer.write("\nDanh sach san pham:\n");
                for (ItemQuantity iq : bill.itemQuantities) {
                    writer.write("\n- " + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " + iq.item.getdiscountedPrice() +  " dong | So luong: " + iq.quantity );
                        
                       
                }
                writer.write("\nTong tien (chua giam tru): " + bill.totalAmount + " dong\n");
                writer.write("Thanh tien: " + bill.discountedAmount + " dong\n");
                writer.write("================\n\n");
            }
            System.out.println("Da luu hoa don vao file " + CURRENT_BILL_FILE);
            
            // Đồng thời lưu vào lịch sử
            appendToHistory(bills);
            
        } catch (IOException e) {
            System.out.println("Loi khi luu file: " + e.getMessage());
        }
    }

    // Phương thức lưu vào file lịch sử billhistory.txt
    private static void appendToHistory(ArrayList<Bill> bills) {
        try (FileWriter writer = new FileWriter(HISTORY_BILL_FILE, true)) { // true để append giúp thêm nội dung mới vào cuối tệp mà không xóa dữ liệu cũ.

            String timestamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
            writer.write("=== HOA DON VAN PHONG PHAM - " + timestamp + " ===\n");
            
            for (Bill bill : bills) {
                writer.write("Khach hang: " + bill.customer.getName() + "\n");
                writer.write("SDT: " + bill.customer.getPhone() + "\n");
                writer.write("\nDanh sach san pham:\n");
                for (ItemQuantity iq : bill.itemQuantities) {
                    writer.write("\n- " + iq.item.getName() + " | Don gia: " + iq.item.getPrice() + " dong | Don gia ap dung khuyen mai " + iq.item.getdiscountedPrice() +  " dong | So luong: " + iq.quantity);
                        
                       
                }
                writer.write("\nTong tien (chua giam tru): " + bill.totalAmount + " dong\n");
                writer.write("Thanh tien: " + bill.discountedAmount + " dong\n");

                writer.write("================\n\n");
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
        } catch (FileNotFoundException e) {
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
            System.out.println("Chua co lich su hoa don");
        } catch (IOException e) {
            System.out.println("Loi khi doc lich su: " + e.getMessage());
        }
    }
}