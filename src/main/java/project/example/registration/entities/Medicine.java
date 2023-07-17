package project.example.registration.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Ordered_medicines")

public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "class_name")
    private String className;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "price")
    private String price;

    public Medicine(int id, String className, String brandName, String price) {
        super();
        this.id = id;
        this.className = className;
        this.brandName = brandName;
        this.price = price;
    }

    public Medicine() {
        super();
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
