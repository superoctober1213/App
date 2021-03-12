package com.example.myapplication;

import java.util.Date;

public class UserInfo {

    private String CustomerName;
    private String CustomerGender;
    private Date CustomerBirthday;
    private int CardId;

//    public UserInfo(String CustomerName, String CustomerGender, Date CustomerBirthday, int CardId){
//        this.CustomerName = CustomerName;
//        this.CustomerGender = CustomerGender;
//        this.CustomerBirthday = CustomerBirthday;
//        this.CardId = CardId;
//    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerGender() {
        return CustomerGender;
    }

    public void setCustomerGender(String customerGender) {
        CustomerGender = customerGender;
    }

    public Date getCustomerBirthday() {
        return CustomerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        CustomerBirthday = customerBirthday;
    }

    public int getCardId() {
        return CardId;
    }

    public void setCardId(int cardId) {
        CardId = cardId;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "CustomerName='" + CustomerName + '\'' +
                ", CustomerGender='" + CustomerGender + '\'' +
                ", CustomerBirthday=" + CustomerBirthday +
                ", CardId=" + CardId +
                '}';
    }

}
