import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Item> items = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Bill> bills = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("_________________________________________");
            System.out.println("\nMenu Quan Ly Van Phong Pham:");
            System.out.println("1. Them san pham");
            System.out.println("2. Tao hoa don");
            System.out.println("3. Xuat hoa don");
            System.out.println("4. Danh sach san pham hien tai");
            System.out.println("5. Sua thong tin san pham theo ID");
            System.out.println("6. Tim kiem san pham theo ID");
            System.out.println("7. Xoa san pham trong danh sach theo ID");
            System.out.println("8. Xuat");
            System.out.println("_________________________________________");

            System.out.print("Lua chon muc : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addItem();
                case 2 -> createBill();
                case 3 -> displayBills();
                case 8 -> System.out.println("Thoat chuong trinh.");
                default -> System.out.println("Lua chon khong hop le vui long chon lai.");
            }
        } while (choice <9 && >= 1 );
    }

    // (1đ) Chức năng thêm sản phẩm
    public static void addItem() {
        System.out.println("_________________________________________");
        Scanner z=new Scanner(System.in);
        System.out.print("Nhap loai san pham (1-Pen, 2-Notebook): ");
        int type = z.nextInt();
        z.nextLine();
        System.out.print("ID: ");
        String id = z.nextLine();
        System.out.print("Ten: ");
        String name = z.nextLine();
        System.out.print("Gia: ");
        double price = z.nextDouble();

        Item newItem = null;
        switch (type)
        {
        case 1-> {
            System.out.println("_________________________________________");

            System.out.print("Mau: ");
            z.nextLine();
            String color = z.nextLine();
            newItem = new Pen(id, name, price, color);
        } 
         case 2-> {
            System.out.println("_________________________________________");

            System.out.print("So trang: ");
            int pages = z.nextInt();
            newItem = new Notebook(id, name, price, pages);
        }
        default -> {
            System.out.println("Loai san pham khong hop le. Vui long chon lai!");
            addItem();
        }
        }
        if (newItem != null) {
            items.add(newItem);
            System.out.println("_________________________________________");

            System.out.println("Da them san pham!");
            }
        
    }

    // (1đ) Chức năng tạo hóa đơn
    public static void createBill() {
        System.out.println("_________________________________________");
        Scanner z=new Scanner(System.in);
        System.out.print("Tên khách hàng: ");
        String name = z.nextLine();
        System.out.print("Số điện thoại: ");
        String phone = z.nextLine();
        Customer customer = new Customer(name, phone);

        Bill bill = new Bill(customer);
        for (Item item : items) {
            System.out.print("Nhập số lượng cho sản phẩm " + item.getName() + ": ");
            int quantity = z.nextInt();
            bill.addItem(item, quantity);
        }
        bills.add(bill);
        System.out.println("_________________________________________");

        System.out.println("Hóa đơn đã được tạo.");
    }

    // (1đ) Chức năng hiển thị hóa đơn
    public static void displayBills() {
        System.out.println("_________________________________________");

        System.out.println("Danh sách hóa đơn:");
        for (Bill bill : bills) {
            bill.displayBill();
        }
    }
}
