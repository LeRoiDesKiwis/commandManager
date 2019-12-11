package fr.leroideskiwis.command.core;

import java.util.Scanner;

public class CustomScanner {

    private Scanner scanner;

    public CustomScanner() {
        this.scanner = new Scanner(System.in);
    }

    public String readString(String message){
        System.out.print(message);
        String readed = scanner.nextLine();
        System.out.println();
        return readed;
    }
}
