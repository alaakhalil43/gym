package org.example.model;

import javax.swing.*;

public class Util {


     public static boolean check(String x) {
       try {
           int num=Integer.parseInt(x);

       }
       catch (NumberFormatException e){
           return false;
       }
       return true;

    }






}
