package com.csv.validatecsv;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static boolean validateEmail(String email){
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern =Pattern.compile(regex);
        Matcher matcher =pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean validateContact(String contact){
        String regex = "^[0-9]{10}$";
        Pattern pattern =Pattern.compile(regex);
        Matcher matcher =pattern.matcher(contact);
        return matcher.matches();
    }

}
