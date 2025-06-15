package ch.hslu.ad.A3_EX_AutomatenSprachen;

public class Main {
    public static void main(String[] args) {
        System.out.println("0 :" + isWordLanguage("0"));
        System.out.println("010 :" + isWordLanguage("010") );
        System.out.println("01110 :" + isWordLanguage("01110"));
        System.out.println("0111010 :" + isWordLanguage("0111010"));
        System.out.println("0101110 :" + isWordLanguage("0101110"));
        System.out.println("0101010 :" + isWordLanguage("0101010"));

        System.out.println("010 :" + isWordLanguage("0110"));
        System.out.println("010 :" + isWordLanguage(""));
        System.out.println("010 :" + isWordLanguage("0101"));
    }

    public static boolean isWordLanguage(final String s){
        int state = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (state) {
                case 0: //Z0
                    if (c == '0') state = 1;
                    else return false;
                    break;
                case 1, 3, 4: //Z1, Z3, Z4
                    if (c == '1') state = 2;
                    else return false;
                    break;
                case 2: //Z2
                    if (c == '1') state = 3;
                    else if (c == '0') state = 4;
                    else return false;
                    break;
                default:
                    return false;
            }
        }
        return state == 4 || state == 1;
    }
}
