import java.util.ArrayList;
import java.util.Scanner;

public class Main //hàm Main chứa menu và chạy chương trình 
{
    // mảng các lớp dối tượng
    private static ArrayList<Item> items = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Bill> bills = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Xin chao!!!");
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("_________________________________________");
            System.out.println("\n  Menu Quan Ly Van Phong Pham:");
            System.out.println("1. Them san pham");
            System.out.println("2. Tao hoa don");
            System.out.println("3. Xuat tat ca hoa don");
            System.out.println("4. Danh sach san pham hien tai");
            System.out.println("5. Sua thong tin san pham theo ID");
            System.out.println("6. Tim kiem san pham theo ID");
            System.out.println("7. Xoa san pham trong danh sach theo ID");
            System.out.println("8. Luu hoa don vao file");
            System.out.println("9. Doc tat ca hoa don tu file");
            System.out.println("10. Xem lich su hoa don");
            System.out.println("11. Thoat");
            System.out.println("_________________________________________");

            System.out.print("Lua chon muc: ");
            choice = scanner.nextInt();
   

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
                case 11 : System.out.println("Thoat chuong trinh. Tam biet !!!");
            break;
                default : System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 11);
    }
    //  hàm chức năng thêm sản phẩm
    public static void addItem() {
        Scanner scanner=new Scanner(System.in);
        boolean continueAdding = true;

        while (continueAdding) {
            System.out.println("\n_________________________________________");
            System.out.println("Menu Them San Pham:");
            System.out.println("1. But bi");
            System.out.println("2. So ghi chu");
            System.out.println("3. Quay lai menu chinh");

            System.out.println("_________________________________________");
            
            System.out.print("Nhap lua chon: ");
            int type = scanner.nextInt();
            scanner.nextLine(); // xuống dòng để tránh biến kiểu string bị rỗng
            
            if (type == 3) {
                System.out.println("Quay lai menu chinh...");
                break; // Quay lại menu chính
            }

            
            else if (type != 1 && type != 2) {
                System.out.println("Lua chon khong hop le. Vui long chon lai!");
                continue; // Quay lại đầu vòng lặp
            }
        

        System.out.print("ID san pham: ");
        String id = scanner.nextLine();
        System.out.print("Ten san pham: ");
        String name = scanner.nextLine();
        System.out.print("Gia san pham: ");
        double price = scanner.nextDouble();
        double discountedPrice=price;


        Item newItem = null;// khai báo tránh lỗi 
        switch (type) {
            case 1 : 
            {
                System.out.print("Mau: ");
                scanner.nextLine();
                String color = scanner.nextLine();
                newItem = new Pen(id, name, price, color, discountedPrice);//tạo 1 sp bút bi
            }
            break;
            case 2 : 
            {
                System.out.print("So trang: ");
                int pages = scanner.nextInt();
                newItem = new Notebook(id, name, price, pages, discountedPrice);//tạo 1 sp sổ tay
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
            System.out.println("Da them san pham!");
        }
    }
}

    //  Danh sách sản phẩm hiện tại
    public static void displayItems() {
        System.out.println("_________________________________________");
        if (items.isEmpty())//nếu mảng items rỗng ko có sp
         {
            System.out.println("Danh sach san pham rong.");
        } else {
            System.out.println("Danh sach san pham hien tai:");
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
        Customer customer = new Customer(name, phone);// phương thức lớp khách hàng

        Bill bill = new Bill(customer); //phương thức gọi lớp bill
        for (Item item : items) {
            double discount;
            int quantity;

            System.out.print("Nhap % giam gia cho san pham " +item.getName()+ "(0->1 vd;: ban muon giam 50% thi nhap 0.5): ");
             discount=z.nextDouble();
            double discountedPrice = item.applyDiscount(discount); // Gọi phương thức từ đối tượng item
            while(discount<0 || discount>1 )
            // xét điều kiện để đảm bảo user nhập chính xác
            {
                System.out.println("% giam gia khong hop le vui long nhap lai!!");
                System.out.print("Nhap % giam gia cho san pham " +item.getName()+ "(0->1 vd;: ban muon giam 50% thi nhap 0.5): ");
                 discount=z.nextDouble();
                 discountedPrice = item.applyDiscount(discount); // Gọi phương thức từ đối tượng item
            }
            
            System.out.print("Nhap so luong cho san pham " + item.getName() + ": ");
            quantity = z.nextInt();

            while(quantity<1)
            {
                System.out.println("So luong khong hop le vui long nhap lai!!");
                System.out.print("Nhap so luong cho san pham " + item.getName() + ": ");
                quantity = z.nextInt();

            }
            bill.addItem(item, quantity);//thêm sp và số lượng vào mảng 
        }
        bills.add(bill);// xong phần nhập thì thêm hóa đơn vào mảng bill
        System.out.println("Hoa don da tao thanh cong.");
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
}
