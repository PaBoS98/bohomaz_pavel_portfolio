package com.o2o.entity;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "Full_Name", length = 100)
    private String fullName;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


//    public int getProduct() {
//        return product;
//    }
//
//    public void setProduct(int product) {
//        this.product = product;
//    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", product=" + product +
                '}';
    }
}
