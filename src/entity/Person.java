package entity;

import java.io.Serializable;

public class Person{
    protected String name;
    protected String address;
    protected Long phoneNum;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Person() {
    }

    public Person(String name, String address, Long phoneNum) {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public void setName(String name) {
        this.name = name;
    }
}

