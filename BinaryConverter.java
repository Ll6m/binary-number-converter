import java.util.Scanner;

/**
 * Converts non-negative values between decimal and binary without relying
 * on Java's built-in base-conversion methods.
 */
public class BinaryConverter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Binary Number Converter");

            boolean running = true;
            while (running) {
                printMenu();
                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        convertDecimalInput(scanner);
                        break;
                    case "2":
                        convertBinaryInput(scanner);
                        break;
                    case "3":
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. Decimal to Binary");
        System.out.println("2. Binary to Decimal");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    private static void convertDecimalInput(Scanner scanner) {
        System.out.print("Enter a non-negative decimal number: ");
        String input = scanner.nextLine().trim();

        try {
            long decimal = Long.parseLong(input);
            if (decimal < 0) {
                System.out.println("Please enter a non-negative number.");
                return;
            }

            System.out.println("Binary: " + decimalToBinary(decimal));
        } catch (NumberFormatException exception) {
            System.out.println("Invalid decimal number.");
        }
    }

    private static void convertBinaryInput(Scanner scanner) {
        System.out.print("Enter a binary number: ");
        String binary = scanner.nextLine().trim();

        if (!isValidBinary(binary)) {
            System.out.println("Invalid binary number. Use only 0 and 1.");
            return;
        }

        try {
            System.out.println("Decimal: " + binaryToDecimal(binary));
        } catch (ArithmeticException exception) {
            System.out.println("That binary number is too large to store as a long.");
        }
    }

    public static String decimalToBinary(long decimal) {
        if (decimal == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            binary.append(decimal % 2);
            decimal /= 2;
        }

        return binary.reverse().toString();
    }

    public static long binaryToDecimal(String binary) {
        long decimal = 0;

        for (int index = 0; index < binary.length(); index++) {
            int bit = binary.charAt(index) - '0';
            if (decimal > (Long.MAX_VALUE - bit) / 2) {
                throw new ArithmeticException("Binary value is too large");
            }
            decimal = decimal * 2 + bit;
        }

        return decimal;
    }

    public static boolean isValidBinary(String value) {
        if (value.isEmpty()) {
            return false;
        }

        for (int index = 0; index < value.length(); index++) {
            char digit = value.charAt(index);
            if (digit != '0' && digit != '1') {
                return false;
            }
        }

        return true;
    }
}
