package ch.hslu.ad.E1_EX_Einfuehrung;

public class Symmetrisch {

    public static void main(String[] args) {
        System.out.println(nextMirroredNumber("4524"));
        System.out.println(nextMirroredNumber("192"));
    }

    public static String nextMirroredNumber(String number) {
        int n = number.length();
        String mirrored = mirrorNumber(number);

        // Case 1: If mirrored is greater → we're done
        if (mirrored.compareTo(number) > 0) {
            return mirrored;
        }

        // Case 2: Otherwise, increment the left half and re-mirror
        int halfLength = (n % 2 == 0) ? n / 2 : n / 2 + 1;
        String leftPart = number.substring(0, halfLength);

        // Increment leftPart as a number
        int incremented = Integer.parseInt(leftPart) + 1;
        String newLeft = String.format("%0" + halfLength + "d", incremented);

        // Handle overflow like "999" → "1000"
        if (newLeft.length() > halfLength) {
            // Special case: number like "999" → next symmetric is "1001"
            return "1" + "0".repeat(n - 1) + "1";
        }

        // Mirror new left part
        String rightMirror;
        if (n % 2 == 0) {
            rightMirror = new StringBuilder(newLeft).reverse().toString();
        } else {
            rightMirror = new StringBuilder(newLeft.substring(0, n / 2)).reverse().toString();
        }

        return newLeft + rightMirror;
    }


    public static String mirrorNumber(String number){
        int n = number.length();
        String leftPart;
        if (n % 2 == 0){
            leftPart = number.substring(0, n / 2);
            String mirrored = new StringBuilder(leftPart).reverse().toString();
            return leftPart + mirrored;
        } else {
            leftPart = number.substring(0, n / 2 + 1);
            String mirrored = new StringBuilder(leftPart.substring(0, n / 2)).reverse().toString();
            return leftPart + mirrored;
        }
    }
}
