package model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/13.
 *
 */
public class Supplier implements Serializable {
    private int id;
    private String name;
    private String address;
    private String people;
    private String goods;
    private String tel;

    public Supplier() {
    }

    public Supplier(int id, String name, String address, String people, String goods, String tel) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.people = people;
        this.goods = goods;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", people='" + people + '\'' +
                ", goods='" + goods + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
