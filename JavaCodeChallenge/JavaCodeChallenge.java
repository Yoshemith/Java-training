import java.util.ArrayList;
import java.util.Scanner;
public class JavaCodeChallenge {

    //Method that decodes a phone number with letter and returns it with all numbers.
    public static String decodeFullPhoneNumber(String phoneNumber){
        String normal = "";
        for(char c: phoneNumber.toUpperCase().toCharArray())
            normal += getDecodedNumber(c);
        return normal;
    }

    //decodes character by character and returns a number if the character is a letter.
    public static char getDecodedNumber(char charToDecode){
        if (Character.isDigit(charToDecode))
            return charToDecode;
        else {
            return switch (charToDecode) {
                case 'A', 'B', 'C' -> '2';
                case 'D', 'E', 'F' -> '3';
                case 'G', 'H', 'I' -> '4';
                case 'J', 'K', 'L' -> '5';
                case 'M', 'N', 'O' -> '6';
                case 'P', 'Q', 'R', 'S' -> '7';
                case 'T', 'U', 'V' -> '8';
                case 'W', 'X', 'Y', 'Z' -> '9';
                default -> '?';
            };
        }
    }

    //Method that returns a phone number formatted like this (800)-123-4567
    public static String formatPhoneNUmber(String str){
        String result = "("+str.substring(0,3)+")-"+str.substring(3,6)+"-"+str.substring(6,10);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> phoneList = new ArrayList<>();
        String decodedPhoneNumber;
        String formattedPhoneNumber;

        System.out.println("Enter The Phone Number (With Letters): ");
        while (phoneList.size() < 5) {
            decodedPhoneNumber = decodeFullPhoneNumber(scanner.next().toUpperCase());

            //FYI: In the second half of the interview, the list of phone numbers will be entered backwards.
            StringBuilder reversedString = new StringBuilder();
            reversedString.append(decodedPhoneNumber); // append a string into StringBuilder reversedString
            reversedString.reverse(); // reverse StringBuilder reversedString

            formattedPhoneNumber = formatPhoneNUmber(String.valueOf(reversedString));
            phoneList.add(formattedPhoneNumber);
        }

        System.out.println("The formatted numbers are: ");
        for (String s : phoneList) {
            System.out.println(s);
        }
    }
}

/* SAMPLE DATA:
EVOL119008
KSAT687008
TSET345008
KNIL223008
ECIN777008
 */