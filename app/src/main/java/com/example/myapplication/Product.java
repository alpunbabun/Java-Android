package com.example.myapplication;

import java.util.Comparator;

public class Product {

    String Product, SerialNumber, Block, Fullname;

    public Product(){}

    public Product(String product, String block, String fullName, String SerialNumber) {
        this.Product = product;
        this.Block = block;
        this.Fullname = fullName;
        this.SerialNumber = SerialNumber;
    }

    public static Comparator<Product> ProductItemAtoZComparator = new Comparator<com.example.myapplication.Product>() {
        @Override
        public int compare(com.example.myapplication.Product product, com.example.myapplication.Product t1) {
            return product.getFullName().compareTo(t1.getFullName());
        }
    };

    public static Comparator<Product> ProductItemZtoAComparator = new Comparator<com.example.myapplication.Product>() {
        @Override
        public int compare(com.example.myapplication.Product product, com.example.myapplication.Product t1) {
            return t1.getFullName().compareTo(product.getFullName());
        }
    };

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        this.Product = product;
    }

    public String getBlock() {
        return Block;
    }

    public void setBlock(String block) {
        this.Block = block;
    }

    public String getFullName() {
        return Fullname;
    }

    public void setFullName(String fullName) {
        this.Fullname = fullName;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(String SerialNumber) {
        this.SerialNumber = SerialNumber;
    }
}
