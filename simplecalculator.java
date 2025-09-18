import java.util.InputMismatchException;
import java.util.Scanner;

class op { // assigning a class for operation methods.

    public String getChoice(Scanner scanner) { // assignning a method to display and get user's choice.

        System.out.println("- - - - - - - - - - -");
        System.out.println("Select operation.");
        System.out.println("1.Add      : + ");
        System.out.println("2.Subtract : - ");
        System.out.println("3.Multiply : * ");
        System.out.println("4.Divide   : / ");
        System.out.println("5.Terminate: # ");
        System.out.println("- - - - - - - - - - -");

        System.out.print("Enter choice(+,-,*,/,#): ");
        return scanner.nextLine();

    }

    public double getNum(Scanner scanner) { // assigning a method to get the numbers.

        while (true) {

            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid Number, Enter again: ");
                scanner.nextLine(); // This consumes the invalid input
            }
        }

    }

    public double calc(String choice, double num1, double num2) { // assigning a method to check the choice and do the
                                                                  // mathematical operations.
        double total;
        
        if (choice.equals("+")) {
            return num1 + num2;
        }

        else if (choice.equals("-")) {
            return num1 - num2;
        }

        else if (choice.equals("*")) {
            return num1 * num2;
        }

        else if (choice.equals("/")) {
            if (num2 == 0) {
                throw new ArithmeticException(" Cannot divide by zero.");
            }
            return num1 / num2;

        }

        else {
            throw new IllegalArgumentException(" Invalid operation symbol.");
        }

    }
}

public class simplecalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        op myObj = new op(); // creating a op object to perform operations that assigned above.

        while (true) {

            String choice = myObj.getChoice(scanner); // calling getChoice method to get user's choice
            if (choice.equals("#")) { // making a terminate symbol.
                break;
            }

            System.out.print("Enter Your First Number: ");
            double num1 = myObj.getNum(scanner); // getting numbers as inputs by calling getNum method that assigned
                                                 // above.
            System.out.print("Enter Your Second Number: ");
            double num2 = myObj.getNum(scanner);

            scanner.nextLine(); // This consume the newline character left in the buffer.

            try {
                double total = myObj.calc(choice, num1, num2); // performing final calculations by calling calc method.
                System.out.println("| Total is: " + total + "  |"); // displaying total.

            }

            catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("- - - - - - - - - - -");
                System.out.println("Error:" + e.getMessage());
            }

        }

    }

}
