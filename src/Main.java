import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main //hàm Main chứa menu và chạy chương trình 
{
    // mảng các lớp dối tượng
    private static ArrayList<Item> items = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Bill> bills = new ArrayList<>();

    //  hàm chức năng thêm sản phẩm
    public static void addItem() {
        Scanner scanner=new Scanner(System.in);
        boolean continueAdding = true;

        while (continueAdding) {
            System.out.println("\n_________________________________________\n");
            System.out.println("Menu Them San Pham:\n");
            System.out.println(" 1. But");
            System.out.println(" 2. Vo");
            System.out.println(" 3. Giay in");
            System.out.println(" 4. Gom");
            System.out.println(" 5. Thuoc ke");
            System.out.println(" 6. Keo dan");
            System.out.println(" 7. Phong bi");
            System.out.println(" 8. Keo cat giay");
            System.out.println(" 9. Nhan ten");
            System.out.println("10. Bia bao");
            System.out.println("11. Bang phan");
            System.out.println("12. Phan bang");
            System.out.println("13. Giay ghi chu");
            System.out.println("14. Sach");
            System.out.println("15. Quay lai menu chinh");

            System.out.println("_________________________________________\n");
            
            System.out.print("Nhap lua chon: ");
            int type = scanner.nextInt();
            scanner.nextLine(); // xuống dòng để tránh biến kiểu string bị rỗng
            
            if (type == 15) {
                System.out.println("Quay lai menu chinh...");
                break; // Quay lại menu chính
            }

            
            else if (type <1 || type >15) {
                System.out.println("Lua chon khong hop le. Vui long chon lai!");
                continue; // Quay lại đầu vòng lặp
            }
        

            System.out.print("ID san pham: ");
            String id = scanner.nextLine();

            while ("".equals(id)){//giống id==""
                System.out.println("Ban chua nhap ID san pham !!");
                System.out.print("ID san pham: ");
                id = scanner.nextLine();
            }
            System.out.print("Ten san pham: ");
            String name = scanner.nextLine();
            
            while("".equals(name))
            {
                System.out.println("Ban chua nhap ten san pham!!!Vui long nhap lai.");
                System.out.print("Ten san pham: ");
                name = scanner.nextLine();
            }

            System.out.print("Gia san pham: ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            
            while(price<0){
                System.out.println(" Gia san pham khong hop le!!!Vui long nhap lai.");
                System.out.print("Gia san pham: ");
                price = scanner.nextDouble();
                scanner.nextLine();
                
            }
            double discountedPrice=price;


            Item newItem = null;// khai báo tránh lỗi 
            switch (type) {
                case 1 : 
                {
                    System.out.print("Mau but: ");
                    String color = scanner.nextLine();
                    while("".equals(color)){
                        System.out.println("Ban chua nhap mau but!!");
                        System.out.print("Mau but: ");
                        color = scanner.nextLine();
                    }
                    
                    newItem = new Pen(id, name, price, color, discountedPrice);//tạo 1 sp bút bi
                }
                break;
                case 2 : 
                {
                    System.out.print("So trang: ");
                    int pages = scanner.nextInt();
                    scanner.nextLine();
                    while(pages<=10){
                        System.out.println("So trang khong hop le. Vui long nhap lai!!");
                        System.out.print("So trang: ");
                        pages = scanner.nextInt();
                        scanner.nextLine();

                    }
                    newItem = new Notebook(id, name, price, pages, discountedPrice);//tạo 1 sp sổ tay
                }
                break;
                case 3: {
                    System.out.print("Kich thuoc: ");
                    String attribute = scanner.nextLine();
                    while("".equals(attribute)){
                        System.out.println("Ban chua nhap kich thuoc giay in!!");
                        System.out.print("Kich thuoc: ");
                        attribute = scanner.nextLine();
                    }
                    newItem = new Paper(id, name, price, attribute, discountedPrice);
                }
                break;
                case 4: {
                    System.out.print("Chat lieu: ");
                    String attribute = scanner.nextLine();
                    while("".equals(attribute)){
                        System.out.println("Ban chua nhap Chat lieu gom!!");
                        System.out.print("Chat lieu: ");
                        attribute = scanner.nextLine();
                    }
                    newItem = new Eraser(id, name, price, attribute, discountedPrice);
                }
                break;
                case 5: {
                    System.out.print("Loai thuoc ke: ");
                    String attribute = scanner.nextLine();
                    while("".equals(attribute)){
                        System.out.println("Ban chua nhap Loai thuoc ke!!");
                        System.out.print("Loai thuoc ke: ");
                        attribute = scanner.nextLine();
                    }
                    newItem = new Ruler(id, name, price, attribute, discountedPrice);
                }
                break;
                case 6: {
                    System.out.print("Loai keo dan: ");
                    String attribute = scanner.nextLine();
                    while("".equals(attribute)){
                        System.out.println("Ban chua nhap Loai keo dan !!");
                        System.out.print("Loai keo dan: ");
                        attribute = scanner.nextLine();
                    }
                    newItem = new Glue(id, name, price, attribute, discountedPrice);
                }
                break;
                case 7: {
                    System.out.print("Mau phong bi: ");
                    String attribute = scanner.nextLine();
                    while("".equals(attribute)){
                        System.out.println("Ban chua nhap Mau phong bi !!");
                        System.out.print("Mau phong bi: ");
                        attribute = scanner.nextLine();
                    }
                    newItem = new Envelope(id, name, price, attribute, discountedPrice);
                }
                break;
                case 8: {
                    System.out.print("Loai luoi keo: ");
                    String attribute = scanner.nextLine();
                    while("".equals(attribute)){
                        System.out.println("Ban chua nhap Loai luoi keo !!");
                        System.out.print("Loai luoi keo: ");
                        attribute = scanner.nextLine();
                    }
                    newItem = new Scissor(id, name, price, attribute, discountedPrice);
                }
                break;
                case 9: {
                    System.out.print("Hinh dang nhan ten: ");
                    String attribute = scanner.nextLine();
                    while("".equals(attribute)){
                        System.out.println("Ban chua nhap Hinh dang nhan ten !!");
                        System.out.print("Hinh dang nhan ten: ");
                        attribute = scanner.nextLine();
                    }
                    newItem = new NameTag(id, name, price, attribute, discountedPrice);
                }
                break;
                case 10: {
                    System.out.print("Loai bao bi: ");
                    String attribute = scanner.nextLine();
                    while("".equals(attribute)){
                        System.out.println("Ban chua nhap Loai bao bi !!");
                        System.out.print("Loai bao bi: ");
                        attribute = scanner.nextLine();
                    }
                    newItem = new BookJacket(id, name, price, attribute, discountedPrice);
                }
                break;
                case 11: {
                    System.out.print("Kich thuoc bang: ");
                    String attribute = scanner.nextLine();
                    while("".equals(attribute)){
                        System.out.println("Ban chua nhap kich thuoc bang !!");
                        System.out.print("Kich thuoc bang: ");
                        attribute = scanner.nextLine();
                    }
                    newItem = new ChalkBoard(id, name, price, attribute, discountedPrice);
                }
                break;
                case 12: {
                    System.out.print("Mau phan: ");
                    String attribute = scanner.nextLine();
                    while("".equals(attribute)){
                        System.out.println("Ban chua nhap Mau phan !!");
                        System.out.print("Mau phan: ");
                        attribute = scanner.nextLine();
                    }
                    newItem = new Chalk(id, name, price, attribute, discountedPrice);
                }
                break;
                case 13: {
                    System.out.print("Mau giay: ");
                    String attribute = scanner.nextLine();
                    while("".equals(attribute)){
                        System.out.println("Ban chua nhap Mau giay !!");
                        System.out.print("Mau giay: ");
                        attribute = scanner.nextLine();
                    }
                    newItem = new NotePaper(id, name, price, attribute, discountedPrice);
                }
                break;
                case 14: {
                    System.out.print("Tac gia sach: ");
                    String attribute = scanner.nextLine();
                    while("".equals(attribute)){
                        System.out.println("Ban chua nhap Tac gia sach !!");
                        System.out.print("Tac gia sach: ");
                        attribute = scanner.nextLine();
                    }
                    newItem = new Book(id, name, price, attribute, discountedPrice);
                }
                break;
                // default : 
                // {
                //     System.out.println("Loai san pham khong hop le. Vui long chon lai!");
                //     addItem();
                // }
                // break;
            }

            if (newItem != null)// khi mảng không rỗng thì thông báo 
            {
                items.add(newItem);// thêm sp vào arraylist
                System.out.println("\nDa them san pham!\n");
            }
    }
}

    //  Danh sách sản phẩm hiện tại
    public static void displayItems() {
        System.out.println("_________________________________________\n");
        if (items.isEmpty())//nếu mảng items rỗng ko có sp
         {
            System.out.println("Danh sach san pham rong.");
        } else {
            System.out.println("Danh sach san pham hien tai:\n\n");
            int đem=0;
            for (Item item : items) 
            // giống for (int i=0;i<items.length;i++) 
            {
                đem++;
                System.out.print(đem+"/ ");
                item.displayInfo();//xuất ds sp
            }
        }
    }

    //  Sửa thông tin sản phẩm theo ID
    public static void editItem() {
        System.out.println("_________________________________________");
        Scanner z = new Scanner(System.in);
        System.out.print("Nhap ID san pham can sua: ");
        String id = z.nextLine();
        boolean found = false;//gọi biến để biết có tìm được ID sp ko

        for (Item item : items) {
            if (item.getId().equalsIgnoreCase(id)) //lấy id sp trong mảng item để so sánh với id input
            {
                System.out.print("Nhap ten moi: ");
                String newName = z.nextLine();
                System.out.print("Nhap gia moi: ");
                double newPrice = z.nextDouble();
                item.setName(newName); // Đổi tên
                item.setPrice(newPrice); // Đổi giá
                System.out.println("Da sua thong tin san pham.");
                found = true;
                break;
            }
        }
        if (!found) //không tim thấy
        {
            System.out.println("Khong tim thay san pham co ID: " + id);
        }
    }

    //  Tìm kiếm sản phẩm theo ID
    public static void searchItem() {
        System.out.println("_________________________________________");
        Scanner z = new Scanner(System.in);
        System.out.print("Nhap ID san pham can tim: ");
        String id = z.nextLine();
        boolean found = false;

        for (Item item : items) {
            if (item.getId().equalsIgnoreCase(id)) {
                System.out.println("Thong tin san pham:");
                item.displayInfo();//hiển thị kq tìm kiếm
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham co ID: " + id);
        }
    }

    //  Xóa sản phẩm theo ID
    public static void deleteItem() {
        System.out.println("_________________________________________");
        Scanner z = new Scanner(System.in);
        System.out.print("Nhap ID san pham can xoa: ");
        String id = z.nextLine();
        boolean found = false;

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equalsIgnoreCase(id)) {
                items.remove(i);//xóa sp
                System.out.println("San pham da duoc xoa.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham co ID: " + id);
        }
    }

    //  Chức năng tạo hóa đơn
    public static void createBill() {
        System.out.println("_________________________________________");
        Scanner z = new Scanner(System.in);
        System.out.print("Ten khach hang: ");
        String name = z.nextLine();
        System.out.print("So dien thoai: ");
        String phone = z.nextLine();
        System.out.print("Nhap ID khach hang: ");
        String id = z.nextLine();
        System.out.print("Nhap id bill: ");
        String billId = z.nextLine();
        Customer customer = new Customer(name, phone,id);// phương thức lớp khách hàng

        Bill bill = new Bill(customer,billId); //phương thức gọi lớp bill
        for (Item item : items) {
            
            double discount;
            int quantity;
            System.out.print("Nhap so luong cho san pham " + item.getName() + ": ");
            quantity = z.nextInt();
            
            while(quantity<0)
            {
                System.out.println("So luong khong hop le vui long nhap lai!!");
                System.out.print("Nhap so luong cho san pham " + item.getName() + ": ");
                quantity = z.nextInt();

            }
            // Trong vòng lặp nhập sản phẩm
            if(quantity!=0)
            {
                System.out.print("Nhap % giam gia cho san pham " +item.getName()+ "(0->1 vd;: ban muon giam 50% thi nhap 0.5 hoac 0,5): ");
                discount=z.nextDouble();
                while(discount<0 || discount>1 )
                // xét điều kiện để đảm bảo user nhập chính xác
                {
                    System.out.println("% giam gia khong hop le vui long nhap lai!!");
                    System.out.print("Nhap % giam gia cho san pham " +item.getName()+ "(0->1 vd;: ban muon giam 50% thi nhap 0.5 hoac 0,5): ");
                    discount=z.nextDouble();
                }
                bill.addItem(item, quantity, discount);//thêm sp và số lượng vào mảng 
            }
        }
        bills.add(bill);// xong phần nhập thì thêm hóa đơn vào mảng bill
        System.out.println("\nHoa don da tao thanh cong.");
    }

    //  Chức năng hiển thị hóa đơn
    public static void displayBills() {
        System.out.println("_________________________________________\n");
        System.out.println("Danh sach hoa don:\n");
        int dem =0;
        for (Bill bill : bills) {
            dem ++;
            System.out.print(dem+"/ ");
            bill.displayBill();// xuất tất cả hóa đơn
        }
    }


    // Phương thức lưu danh sách khách hàng vào file
public static void saveCustomersToFile() {
    try (FileWriter writer = new FileWriter("CustomersList.txt")) {
        // Tạo một Set để lưu trữ các khách hàng duy nhất
        Set<Customer> uniqueCustomers = new HashSet<>();
        
        // Thu thập các khách hàng duy nhất từ hóa đơn
        for (Bill bill : bills) {

            uniqueCustomers.add(bill.getcustomer());
        }

        if (uniqueCustomers.isEmpty()) {
            writer.write("\nDanh sach khach hang rong.\n");
            System.out.println("\nKhong co khach hang de luu.");
            return;
        }
        int dem=0;
        writer.write("\n=== DANH SACH KHACH HANG ===\n\n");
        writer.write("______________________________\n\n");
        String timestamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        writer.write("Thoi gian: " + timestamp + "\n\n");
        for (Customer customer : uniqueCustomers) {
            dem++;
            writer.write("\n"+dem+"/ Ten khach hang: " + customer.getName() + "\n");
            writer.write("ID khach hang: " + customer.getid() + "\n");
            writer.write("So dien thoai: " + customer.getPhone() + "\n");
            writer.write("______________________________\n");
        }
        System.out.println("\nDa luu danh sach khach hang vao CustomersList.txt");
    } catch (IOException e) {
        System.out.println("\nLoi khi luu danh sach khach hang: " + e.getMessage());
    }
}

// Phương thức đọc danh sách khách hàng từ file
public static void readCustomersFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader("CustomersList.txt"))) {
        String line;
        System.out.println("\nDanh sach khach hang tu file CustomersList.txt:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException e) {
        System.out.println("Loi khi doc danh sach khach hang: " + e.getMessage());
    }
}

    // Phương thức lưu danh sách sản phẩm vào file
    public static void saveItemsToFile() {
        try (FileWriter writer = new FileWriter("ItemsList.txt")) {
            if (items.isEmpty()) {
                writer.write("\nDanh sach san pham rong.\n");
                System.out.println("'nKhong co san pham de luu.");
                return;
            }

            writer.write("\n=== DANH SACH SAN PHAM ===\n\n");
            writer.write("______________________________\n\n");
            String timestamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
            writer.write("Thoi gian: " + timestamp + "\n\n");
            int dem = 0;
            for (Item item : items) {
                dem++;
                if (item instanceof Pen) {
                    writer.write("\n"+dem+"/ Loai san pham: But\n");
                } else if (item instanceof Notebook) {
                    writer.write("\n"+dem+"/ Loai san pham: Vo\n");
                } else if (item instanceof Ruler) {
                    writer.write("\n"+dem+"/ Loai san pham: Thuoc Ke\n");
                } else if (item instanceof Paper) {
                    writer.write("\n"+dem+"/ Loai san pham: Giay In\n");
                } else if (item instanceof Eraser) {
                    writer.write("\n"+dem+"/ Loai san pham: Gom\n");
                } else if (item instanceof Glue ) {
                    writer.write("\n"+dem+"/ Loai san pham: Keo Dan\n");
                } else if (item instanceof Scissor) {
                    writer.write("\n"+dem+"/ Loai san pham: Keo Cat Giay\n");
                } else if (item instanceof Chalk) {
                    writer.write("\n"+dem+"/ Loai san pham: Phan Bang\n");
                } else if (item instanceof ChalkBoard) {
                    writer.write("\n"+dem+"/ Loai san pham: Bang Phan\n");
                } else if (item instanceof NotePaper) {
                    writer.write("\n"+dem+"/ Loai san pham: Giay Ghi Chu\n");
                } else if (item instanceof Book) {
                    writer.write("\n"+dem+"/ Loai san pham: Sach\n");
                } else if (item instanceof NameTag) {
                    writer.write("\n"+dem+"/ Loai san pham: Nhan Ten\n");
                } else if (item instanceof BookJacket) {
                    writer.write("\n"+dem+"/ Loai san pham: Bia Sach Vo\n");
                } else if (item instanceof Envelope) {
                    writer.write("\n"+dem+"/ Loai san pham: Phong bi\n");
                }

                writer.write("Ten san pham: " + item.getName() + "\n");
                writer.write("ID san pham: " + item.getId() + "\n");
                writer.write("Gia goc: " + item.getPrice() + " dong\n");
                writer.write("Gia khuyen mai: " + item.getdiscountedPrice() + " dong\n");
                
                // Thêm thông tin chi tiết cho từng loại sản phẩm
                if (item instanceof Pen) {
                    writer.write("Mau: " + ((Pen)item).getcolor() + "\n");//lay thuoc tinh cua item lop pen
                } else if (item instanceof Paper) {
                    writer.write("Kich Thuoc : " + ((Paper)item).getsize() + "\n");
                } else if (item instanceof Eraser) {
                    writer.write("Chat lieu: " + ((Eraser)item).getmaterial() + "\n");
                } else if (item instanceof Glue) {
                    writer.write("Loai : " + ((Glue)item).gettype() + "\n");
                } else if (item instanceof Ruler) {
                    writer.write("Loai :" + ((Ruler)item).gettype() + "\n");
                } else if (item instanceof Envelope) {
                    writer.write("Mau san pham : " + ((Envelope)item).getcolor() + "\n");
                } else if (item instanceof Scissor) {
                    writer.write("Hinh dang luoi keo: " + ((Scissor)item).getScissorBlades() + "\n");
                } else if (item instanceof BookJacket) {
                    writer.write("Loai :" + ((BookJacket)item).gettype() + "\n");
                } else if (item instanceof ChalkBoard) {
                    writer.write("Kich Thuoc : " + ((ChalkBoard)item).getsize() + "\n");
                } else if (item instanceof Chalk) {
                    writer.write("Mau san pham : " + ((Chalk)item).getcolor() + "\n");
                } else if (item instanceof Book) {
                    writer.write("Tac gia: " + ((Book)item).getauthor() + "\n");
                } else if (item instanceof NotePaper) {
                    writer.write("Mau san pham : " + ((NotePaper)item).getcolor() + "\n");
                } else if (item instanceof NameTag) {
                    writer.write("Hinh dang nhan ten: " + ((NameTag)item).getNameTagShape() + "\n");
                } else if (item instanceof Notebook) {
                    writer.write("So trang: " + ((Notebook)item).getpages() + "\n");
                }

                writer.write("______________________________\n");
            }
            System.out.println("\nDa luu danh sach san pham vao ItemsList.txt");
        } catch (IOException e) {
            System.out.println("\nLoi khi luu danh sach san pham: " + e.getMessage());
        }
    }

    // Phương thức đọc danh sách sản phẩm từ file
    public static void readItemsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("ItemsList.txt"))) {
            String line;
            System.out.println("\nDanh sach san pham tu file ItemsList.txt:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Loi khi doc danh sach san pham: " + e.getMessage());
        }
    }

// Tìm kiếm khách hàng theo ID
public static void searchCustomerById() {
    System.out.println("_________________________________________");
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhap ID khach hang can tim: ");
    String id = scanner.nextLine();
    boolean found = false;

    // Tìm kiếm khách hàng trong danh sách hóa đơn
    for (Bill bill : bills) {
        Customer customer = bill.getcustomer();
        if (customer.getid().equalsIgnoreCase(id)) {
            System.out.println("Thong tin khach hang:");
            customer.displayInfo(); // Sử dụng phương thức displayInfo() của lớp Customer
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Khong tim thay khach hang co ID: " + id);
    }
}

// Sửa thông tin khách hàng theo ID
public static void editCustomerById() {
    System.out.println("_________________________________________");
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhap ID khach hang can sua: ");
    String id = scanner.nextLine();
    boolean found = false;

    // Duyệt qua các hóa đơn để tìm và sửa thông tin khách hàng
    for (Bill bill : bills) {
        Customer customer = bill.getcustomer();
        if (customer.getid().equalsIgnoreCase(id)) {
            System.out.println("Thong tin hien tai cua khach hang:");
            customer.displayInfo();

            System.out.print("Nhap ten moi (hoac an Enter de giu nguyen): ");
            String newName = scanner.nextLine();
            if (!newName.trim().isEmpty()) {
                customer.setName(newName);
            }

            System.out.print("Nhap so dien thoai moi (hoac an Enter de giu nguyen): ");
            String newPhone = scanner.nextLine();
            if (!newPhone.trim().isEmpty()) {
                customer.setPhone(newPhone);
            }

            System.out.println("Thong tin khach hang da duoc cap nhat.");
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Khong tim thay khach hang co ID: " + id);
    }
}

// Phương thức xuất danh sách khách hàng
public static void displayCustomers() {
    System.out.println("_________________________________________\n");
    System.out.println("Danh sach khach hang:\n");
    
    // Sử dụng Set để loại bỏ các khách hàng trùng lặp
    Set<Customer> uniqueCustomers = new HashSet<>();
    
    // Thu thập các khách hàng duy nhất từ hóa đơn
    for (Bill bill : bills) {
        uniqueCustomers.add(bill.getcustomer());
    }
    
    if (uniqueCustomers.isEmpty()) {
        System.out.println("Danh sach khach hang rong.");
        return;
    }
    
    int dem = 0;
    for (Customer customer : uniqueCustomers) {
        dem++;
        System.out.print(dem + "/ ");
        customer.displayInfo();
    }
}// Tìm kiếm hóa đơn theo ID
public static void searchBillById() {
    System.out.println("_________________________________________");
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhap ID hoa don can tim: ");
    String billId = scanner.nextLine();
    boolean found = false;

    for (Bill bill : bills) {
        if (bill.getid().equalsIgnoreCase(billId)) {
            System.out.println("Thong tin hoa don:");
            bill.displayBill();
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Khong tim thay hoa don co ID: " + billId);
    }
}

// Xóa hóa đơn theo ID
public static void deleteBillById() {
    System.out.println("_________________________________________");
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhap ID hoa don can xoa: ");
    String billId = scanner.nextLine();
    boolean found = false;

    for (int i = 0; i < bills.size(); i++) {
        if (bills.get(i).getid().equalsIgnoreCase(billId)) {
            bills.remove(i);
            System.out.println("Hoa don da duoc xoa.");
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Khong tim thay hoa don co ID: " + billId);
    }
}
public static void editBillById() {
    System.out.println("_________________________________________");
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhap ID hoa don can sua: ");
    String billId = scanner.nextLine();
    boolean found = false;

    for (int billIndex = 0; billIndex < bills.size(); billIndex++) {
        Bill bill = bills.get(billIndex);
        if (bill.getid().equalsIgnoreCase(billId)) {
            System.out.println("Thong tin hien tai cua hoa don:");
            bill.displayBill();

            // Menu for editing options
            System.out.println("_________________________________________\n");
            System.out.println("\nChon thong tin chinh sua:\n");

            System.out.println("1. Sua thong tin khach hang");
            System.out.println("2. Sua san pham trong hoa don");
            System.out.println("3. Sua ca hai\n");
            System.out.println("_________________________________________");

            System.out.print("Lua chon: ");
            int editChoice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            // Edit customer information
            if (editChoice == 1 || editChoice == 3) {
                Customer customer = bill.getcustomer();
                System.out.print("Nhap ten moi (Enter de giu nguyen): ");
                String newName = scanner.nextLine();
                if (!newName.trim().isEmpty()) {
                    customer.setName(newName);
                }

                System.out.print("Nhap so dien thoai moi (Enter de giu nguyen): ");
                String newPhone = scanner.nextLine();
                if (!newPhone.trim().isEmpty()) {
                    customer.setPhone(newPhone);
                }
            }

            // Edit bill items
            if (editChoice == 2 || editChoice == 3) {
                // Create a new bill with the same customer
                Bill newBill = new Bill(bill.getcustomer(), bill.getid());
                
                // Re-add items with potential changes
                for (Item item : items) {
                    System.out.print("Nhap so luong cho san pham " + item.getName() + ": ");
                    int quantity = scanner.nextInt();
                    
                    while(quantity < 0) {
                        System.out.println("So luong khong hop le. Vui long nhap lai!!");
                        System.out.print("Nhap so luong cho san pham " + item.getName() + ": ");
                        quantity = scanner.nextInt();
                    }
                    
                    if(quantity > 0) {
                        System.out.print("Nhap % giam gia cho san pham " + item.getName() + " (0->1, VD: 0.5 de giam 50%): ");
                        double discount = scanner.nextDouble();
                        
                        while(discount < 0 || discount > 1) {
                            System.out.println("% giam gia khong hop le. Vui long nhap lai!!");
                            System.out.print("Nhap % giam gia cho san pham " + item.getName() + " (0->1, VD: 0.5 de giam 50%): ");
                            discount = scanner.nextDouble();
                        }
                        
                        newBill.addItem(item, quantity, discount);
                    }
                }
                
                // Replace the old bill with the new one
                bills.set(billIndex, newBill);
            }

            System.out.println("Hoa don da duoc cap nhat thanh cong.");
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Khong tim thay hoa don co ID: " + billId);
    }
}


 // Cập nhật phương thức main để thêm các chức năng mới
 public static void main(String[] args) {
    System.out.println("Xin chao!!!");
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
        System.out.println("_________________________________________");
        System.out.println("\n  Menu Quan Ly Van Phong Pham:\n");
        System.out.println(" 1. Them san pham");
        System.out.println(" 2. Tao hoa don");
        System.out.println(" 3. Xuat tat ca hoa don");
        System.out.println(" 4. Xuat danh sach san pham ");
        System.out.println(" 5. Sua thong tin san pham theo ID");
        System.out.println(" 6. Tim kiem san pham theo ID");
        System.out.println(" 7. Xoa san pham trong danh sach theo ID");
        System.out.println(" 8. Luu hoa don vao file");
        System.out.println(" 9. Doc tat ca hoa don da nhap moi day tu file");
        System.out.println("10. Xem lich su hoa don");
        System.out.println("11. Luu danh sach khach hang vao file");
        System.out.println("12. Doc danh sach khach hang tu file");
        System.out.println("13. Tim kiem khach hang bang ID");
        System.out.println("14. Sua thong tin khach hang bang ID");
        System.out.println("15. Luu danh sach san pham vao file");
        System.out.println("16. Doc danh sach san pham tu file");
        System.out.println("17. Xem danh sach khach hang");
        System.out.println("18. Tim kiem hoa don bang ID");
        System.out.println("19. Xoa hoa don bang ID");
        System.out.println("20. Sua thong tin hoa don bang ID");
        System.out.println("21. Thoat\n");
        System.out.println("_________________________________________\n");
        
        System.out.print("Lua chon muc: ");
        choice = scanner.nextInt();
        System.out.println("\n_________________________________________");

        switch (choice) {
            case 1 : addItem();//gọi hàm 
            break;
            case 2 : createBill();
            break;
            case 3 : displayBills();
            break;
            case 4 : displayItems();
            break;
            case 5 : editItem();
            break;
            case 6 : searchItem();
            break;
            case 7 : deleteItem();
            break;
            case 8 : Bill.saveBillToFile(bills);//gọi hàm trong file Bill.java
            break;
            case 9 : Bill.readBillFromFile();
            break;
            case 10 : Bill.readBillHistory();
            break;
            // Xử lý các chức năng mới
            case 11 : saveCustomersToFile(); 
            break;
            case 12 : readCustomersFromFile(); 
            break;
            case 13 : searchCustomerById();
            break;
            case 14 : editCustomerById();
            break;
            case 15 : saveItemsToFile(); 
            break;
            case 16 : readItemsFromFile(); 
            break;
            case 17: displayCustomers();
            break;
            case 18 : searchBillById();
            break;
            case 19 : deleteBillById();
            break;
            case 20 : editBillById();
            break;
            case 21 : System.out.println("Thoat chuong trinh.\nThoat chuong trinh..\nThoat chuong trinh...\n Chao tam biet !!!");
            break;
            default : System.out.println("Lua chon khong hop le. Vui long chon lai.");
        }
    } while (choice != 21);
    }
}
