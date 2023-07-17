package project.example.registration.entities;

import jakarta.persistence.*;

@Entity  //will create table in our database
@Table(name="Priority_orders")
public class MyMedicineList {
    @Id

    private int id;
    private String className;
    private String brandName;
    private String price;



    public MyMedicineList(int id, String className, String brandName, String price) {

        this.id = id;
        this.className = className;
        this.brandName = brandName;
        this.price = price;
    }

    public MyMedicineList() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
