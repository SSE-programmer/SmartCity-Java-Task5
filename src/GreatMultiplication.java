import java.util.InputMismatchException;
import java.util.Scanner;

public class GreatMultiplication {
    private static String number = null;
    private static String multiplier = null;

    public static void setNumber() {
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                System.out.printf("\nВведите целое число: ");
                number = in.next("[+-]?(0|[1-9][0-9]*)");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Недопустимый формат числа.");
                in.next();
            }
        }
    }

    public static void setMultiplier() {
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                System.out.printf("\nВведите множитель [0...9]: ");
                multiplier = in.next("[+-]?([0-9])");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Недопустимый формат числа.");
                in.next();
            }
        }
    }

    private static List numberToList(String number) {
        List list = new List();

        for (int i = (number.charAt(0) == '-' || number.charAt(0) == '+') ? 1 : 0; i < number.length(); i++) {
            list.addStart(Character.getNumericValue(number.charAt(i)));
        }

        return list;
    }

    public static String multiplication(String number, String multiplier) {
        List lNumber = numberToList(number);

        int mul = Integer.parseInt(multiplier);

        if (mul < 0) {
            mul *= -1;
        }

        if (mul == 0) {
            return "0";
        }

        Node node = new Node();
        node = lNumber.getHead();

        int remember = 0;

        do {
            int result = node.data * mul + remember;
            remember = result / 10;
            node.data = result % 10;
            node = node.next;
        } while (node != null);

        if (remember != 0) {
            lNumber.addFinish(remember);
            remember = 0;
        }

        if (multiplier.charAt(0) == '-' && number.charAt(0) != '-' ||
                multiplier.charAt(0) != '-' && number.charAt(0) == '-') {
            return "-" + lNumber.toString();
        }

        return lNumber.toString();
    }

    public static void main(String[] args) {
        while (true) {
            setNumber();
            setMultiplier();
            String result = multiplication(number, multiplier);

            System.out.println("Результат умножения: " + result);
        }
    }
}
