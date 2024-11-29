import java.io.Serializable;

class Customer implements Serializable {
    private String name;
    private String phone;
    private String id;

    //  Hàm thiết lập 
    public Customer(String name, String phone, String id) {
        this.name = name;
        this.id=id;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
    public String getid(){
        return id;
    }
    public void setid(String id) {
        this.id = id;
    }
    public void displayInfo() {
        System.out.println("Ten khach hang: " + name + " | ID: "+id+ " |  SDT: " + phone+"\n");
    }
}
