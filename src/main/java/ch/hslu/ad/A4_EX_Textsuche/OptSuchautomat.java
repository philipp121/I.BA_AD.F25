package ch.hslu.ad.A4_EX_Textsuche;

public class OptSuchautomat {

    public static void main(String[] args) {
        String t1 = "This is an Ananas";
        System.out.println(stateSearch(t1));

        String t2 = "Ananas";
        System.out.println(stateSearch(t2));

        String t3 = "This is an Apple";
        System.out.println(stateSearch(t3));

        String t4 = "I eat an Ananas for dinner";
        System.out.println(stateSearch(t4));

        String t5 = "Anananas is not a thing";
        System.out.println(stateSearch(t5));
    }

    public static int stateSearch(final String a) {
        int state = 0;
        final int PATTERN_LENGTH = "ANANAS".length();
        String s = a.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //System.out.println("i=" + i + " c=" + c + " state=" + state);
            switch (state) {
                case 0:
                    if (c == 'A') state = 1;
                    break;
                case 1:
                    if (c == 'N') state = 2;
                    else if (c != 'A') state = 0;
                    break;
                case 2:
                    if (c == 'A') state = 3;
                    else state = 0;
                    break;
                case 3:
                    if (c == 'N') state = 4;
                    else if (c == 'A') state = 1;
                    else state = 0;
                    break;
                case 4:
                    if (c == 'A') state = 5;
                    else state = 0;
                    break;
                case 5:
                    if (c == 'S') return i - (PATTERN_LENGTH - 1);
                    else if (c == 'A') state = 4;
                    else state = 0;
                    break;
            }
        }
        return -1;
    }
}
