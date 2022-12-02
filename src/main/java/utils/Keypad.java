package utils;

import java.util.Scanner;

public class Keypad {
    public static String readFromUser(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim().replaceAll(" ","");
    }
}
