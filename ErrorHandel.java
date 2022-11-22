package atm;

public class ErrorHandel {
// indicator is a string that will hold the error keys which can be one or all of these (abcd)
//each letter represents an error message for the signup page
    public static String indicator="";

    // checks if there is numbers in a given text field
    // returns false if a number is found and true if a number is not found
    public boolean check_numbers(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {

                indicator += "A";

                return false;

            }
        }
        System.out.println("true");
        return true;
    }

    // checks if there are letters in a given text field
    // returns false if a letter is found and true if a letter was not found
    public boolean check_letters(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {

                indicator += "B";
               return false;
            }
        }

        return true;

    }
    // method only exclusive to signup since it checks if the pin entered contains numbers only , if it contains a letter
    public boolean checkpin(String length) {
        if (length.length() > 4) {
            indicator += "C";
        }
        for (int i = 0; i < length.length(); i++) {
            if (Character.isLetter(length.charAt(i))) {

                indicator += "D";

                return false;
            }
        }

        return true;
    }
}


