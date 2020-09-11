package tictactoe;

import java.util.Scanner;

public class Main {
    public static void print(String input) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.println(String.format("| %c %c %c |", input.charAt(i * 3), input.charAt(i * 3 + 1), input.charAt(i * 3 + 2)));
        }
        System.out.println("---------");
    }

    public static String getInput(String input, Scanner scanner, int id) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        while ((x > 3 || x < 1 || y > 3 || y < 1)) {
            System.out.println("Coordinates should be from 1 to 3!");
            x = scanner.nextInt();
            y = scanner.nextInt();
        }

        String newInput = " ";

        if (input.charAt(8 - y * 3 + x) == ' ') {
            if (id % 2 == 1) {
                newInput = input.substring(0, 8 - y * 3 + x) + 'X' + input.substring(9 - y * 3 + x);
            } else {
                newInput = input.substring(0, 8 - y * 3 + x) + 'O' + input.substring(9 - y * 3 + x);
            }
            System.out.println(newInput);
            return newInput;
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            return getInput(input, scanner, id);
        }
    }

    public static String checkStatus(String input) {
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) == input.charAt(i + 3) && input.charAt(i) == input.charAt(i + 6) && input.charAt(i) != ' ') {
                return String.format("%c wins", input.charAt(i));
            }
            if (input.charAt(i * 3) == input.charAt(i * 3 + 1) && input.charAt(i * 3) == input.charAt(i * 3 + 2) && input.charAt(i * 3) != ' ') {
                return String.format("%c wins", input.charAt(i * 3));
            }
        }
        if (input.charAt(0) == input.charAt(4) && input.charAt(0) == input.charAt(8) && input.charAt(0) != ' ') {
            return String.format("%c wins", input.charAt(0));
        }
        if (input.charAt(2) == input.charAt(4) && input.charAt(2) == input.charAt(6) && input.charAt(2) != ' ') {
            return String.format("%c wins", input.charAt(2));
        }
        for (int i = 0; i < 9; i++) {
            if (input.charAt(i) == ' ') {
                return "not finish";
            }
        }
        return "Draw";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "         ";

        print(input);

        String status = "not finish";

        int id = 1;

        String newInput = getInput(input, scanner, id);
        print(newInput);

        while (status == "not finish") {
            ++id;
            newInput = getInput(newInput, scanner, id);
            System.out.println(newInput);
            print(newInput);
            status = checkStatus(newInput);
        }

        System.out.println(status);
    }
}

