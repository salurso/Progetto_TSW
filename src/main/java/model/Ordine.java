package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Ordine {
    private int id;
    private Date date;
    private double total;
    private String city;
    private String via;
    private int house_number;
    private String province;
    private int cap;
    private String email_user;
    private ArrayList<Prodotto> products;


    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public void setHouse_number(int house_number) {
        this.house_number = house_number;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public void setProducts(ArrayList<Prodotto> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getTotal() {
        return total;
    }

    public String getCity() {
        return city;
    }

    public String getVia() {
        return via;
    }

    public int getHouse_number() {
        return house_number;
    }

    public String getProvince() {
        return province;
    }

    public int getCap() {
        return cap;
    }

    public String getEmail_user() {
        return email_user;
    }

    public ArrayList<Prodotto> getProducts() {
        return products;
    }
}