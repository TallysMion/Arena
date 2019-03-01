package com.example.tally.arena.model.Enum;

import java.util.ArrayList;
import java.util.List;

public enum HR {
    h0, h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14, h15, h16, h17, h18, h19, h20, h21, h22, h23;

    public String toString(){
        switch (this){
            case h0:  return "00";
            case h1:  return "01";
            case h2:  return "02";
            case h3:  return "03";
            case h4:  return "04";
            case h5:  return "05";
            case h6:  return "06";
            case h7:  return "07";
            case h8:  return "08";
            case h9:  return "09";
            case h10: return "10";
            case h11: return "11";
            case h12: return "12";
            case h13: return "13";
            case h14: return "14";
            case h15: return "15";
            case h16: return "16";
            case h17: return "17";
            case h18: return "18";
            case h19: return "19";
            case h20: return "20";
            case h21: return "21";
            case h22: return "22";
            case h23: return "23";
        }
        return null;
    }

    public static HR byString(String s){
        if(s.equals(h0.toString())) return h0;
        if(s.equals(h1.toString())) return h1;
        if(s.equals(h2.toString())) return h2;
        if(s.equals(h3.toString())) return h3;
        if(s.equals(h4.toString())) return h4;
        if(s.equals(h5.toString())) return h5;
        if(s.equals(h6.toString())) return h6;
        if(s.equals(h7.toString())) return h7;
        if(s.equals(h8.toString())) return h8;
        if(s.equals(h9.toString())) return h9;
        if(s.equals(h10.toString())) return h10;
        if(s.equals(h11.toString())) return h11;
        if(s.equals(h12.toString())) return h12;
        if(s.equals(h13.toString())) return h13;
        if(s.equals(h14.toString())) return h14;
        if(s.equals(h15.toString())) return h15;
        if(s.equals(h16.toString())) return h16;
        if(s.equals(h17.toString())) return h17;
        if(s.equals(h18.toString())) return h18;
        if(s.equals(h19.toString())) return h19;
        if(s.equals(h20.toString())) return h20;
        if(s.equals(h21.toString())) return h21;
        if(s.equals(h22.toString())) return h22;
        if(s.equals(h23.toString())) return h23;
        return null;
    }

    public static List<String> getList(){
        List<String> result = new ArrayList<>();
        result.add(h0.toString());
        result.add(h1.toString());
        result.add(h2.toString());
        result.add(h3.toString());
        result.add(h4.toString());
        result.add(h5.toString());
        result.add(h6.toString());
        result.add(h7.toString());
        result.add(h8.toString());
        result.add(h9.toString());
        result.add(h10.toString());
        result.add(h11.toString());
        result.add(h12.toString());
        result.add(h13.toString());
        result.add(h14.toString());
        result.add(h15.toString());
        result.add(h16.toString());
        result.add(h17.toString());
        result.add(h18.toString());
        result.add(h19.toString());
        result.add(h20.toString());
        result.add(h21.toString());
        result.add(h22.toString());
        result.add(h23.toString());
        return result;
    }


}
