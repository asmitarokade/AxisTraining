package jdbcConn;

import java.util.Scanner;

public class Basic {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Num1 (between 10 and 100): ");
        String num1Input = input.nextLine();
        int num1 = validateNumber(num1Input);
        if (num1 == -1) {
            System.out.println("Bad Number: " + num1Input);
            return;
        }
        System.out.print("Enter Num2 (between -10 and 10): ");
        String num2Input = input.nextLine();
        int num2 = validateNumber(num2Input);
        if (num2 == -1) {
            System.out.println("Bad Number: " + num2Input);
            return;
        }
        System.out.print("Enter Operation (+, -, *, /): ");
        String operation = input.nextLine();
        if (!isValidOperation(operation)) {
            System.out.println("Bad Operation: " + operation);
            return;
        }
        int result = calculate(num1, num2, operation);
        System.out.println("Result: " + result);
    }

    public static int validateNumber(String number) {
        int num;
        try {
            num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return -1;
        }
        if (num < 10 || num > 100) {
            return -1;
        }
        return num;
    }

    public static boolean isValidOperation(String operation) {
        return operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/");
    }

    public static int calculate(int num1, int num2, String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;
    }
}
