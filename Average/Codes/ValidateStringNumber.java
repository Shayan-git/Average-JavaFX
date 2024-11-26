public class ValidateStringNumber {
    public static boolean validateNumber(String text) {
        if (text.length() == 0)
            return false;

        int dotCounter = 0;

        char[] charsArray = text.toCharArray();

        for (char c : charsArray) {
            if (c == '.')
                dotCounter++;

            if (!Character.isDigit(c) && c != '.')
                return false;
        }

        return dotCounter <= 1 && charsArray[0] != '.' && charsArray[charsArray.length - 1] != '.';
    }
}
