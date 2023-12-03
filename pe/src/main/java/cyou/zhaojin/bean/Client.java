package cyou.zhaojin.bean;

import java.io.Serializable;

/**
 * @author Zhao JIN
 */

public class Client implements Serializable {
    private Integer id;
    private String email;
    private String name;
    private String address;
    private String tel;
    private int amount;
    private int duration;
    private String description;
    private double income;
    private double spent;

    public Client() {}

    public Client(Integer id, String email, String name, String address, String tel, int amount, int duration, String description, double income, double spent) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.amount = amount;
        this.duration = duration;
        this.description = description;
        this.income = income;
        this.spent = spent;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }


    public String getName() {
        return name;
    }


    public String getAddress() {
        return address;
    }


    public String getTel() {
        return tel;
    }


    public int getAmount() {
        return amount;
    }


    public int getDuration() {
        return duration;
    }


    public String getDescription() {
        return description;
    }


    public double getIncome() {
        return income;
    }


    public double getSpent() {
        return spent;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setSpent(double spent) {
        this.spent = spent;
    }
}
