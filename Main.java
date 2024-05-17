package org.example;

import org.example.Convertor;
;import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String time = input.next();

        String res = Convertor.convertTimeToWords(time);

        System.out.println(res);
    }

}