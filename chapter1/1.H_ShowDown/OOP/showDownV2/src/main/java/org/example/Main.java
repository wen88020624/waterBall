package main.java.org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShowDown showDown = new ShowDown(
                List.of(
                        new HumanPlayer(),
                        new AI(),
                        new AI(),
                        new AI()
                )
        );
        showDown.start();
    }
}