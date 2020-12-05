package com.example.bekasshop.Util;

import java.util.ArrayList;

public class Singleton {
    private static Singleton mInstance;

    public int price;
    public String address;

    public static Singleton getInstance() {
        if(mInstance == null)
            mInstance = new Singleton();
        return mInstance;
    }

    public void setTotalPrice(int Tprice, int Tqty) {
        price = Tprice * Tqty;
    }
    public void setUserAddress(String Taddress) {
        address = Taddress;
    }

}
