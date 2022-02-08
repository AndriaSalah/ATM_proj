package atm;

public class ErrorHandel {

    public static String indicator="";

    public boolean check_numbers(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                System.out.println("false");
                indicator += "A";

                return false;

            }
        }
        System.out.println("true");
        return true;
    }

    public boolean check_letters(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
                System.out.println("false");
                indicator += "B";
               return false;
            }
        }
        System.out.println("true");
        return true;

    }

    public boolean checkpin(String length) {
        if (length.length() > 4) {
            indicator += "C";
        }
        for (int i = 0; i < length.length(); i++) {
            if (Character.isLetter(length.charAt(i))) {
                System.out.println("false");
                indicator += "D";

                return false;
            }
        }
        System.out.println("true");
        return true;
    }
}


