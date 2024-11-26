import java.io.Serializable;

class Customer implements Serializable {
    private String name;
    private String phone;

    //  Hàm thiết lập 
    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void displayInfo() {
        System.out.println("Ten khach hang: " + name + " | SDT: " + phone+"\n");
    }
}
