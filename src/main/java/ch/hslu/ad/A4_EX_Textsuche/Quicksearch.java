package ch.hslu.ad.A4_EX_Textsuche;

public class Quicksearch {
    public static void main(String[] args) {
        test("ananas", "ana");       // Match at 0
        test("banananana", "nana");  // Match at 2
        test("hello world", "world"); // Match at 6
        test("quicksearch", "search"); // Match at 5
        test("pattern", "notfound"); // No match → -1
        test("abcabcabc", "cab");    // Match at 2
        test("abc", "abcd");         // Pattern longer → -1
        test("abcabcabc", "abcabcabc"); // Full match → 0
        test("abcabcabc", "abcabcabcd"); // Pattern too long → -1
        test("aaaaaa", "aaa");       // First match → 0 (should stop at first)
    }

    public static void test(String text, String pattern) {
        int result = optimalQuickSearch(text, pattern);
        System.out.printf("Text: %-15s Pattern: %-10s → Result: %d\n", text, pattern, result);
    }


    public static int quickSearch(final String a, final String p) {
        final int n = a.length();
        final int m = p.length();
        final int range = 256; // -> ASCII-Range
        final int[] shift = new int[range];
        // Shift-array erzeugen, Grundbelegung
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }
        // Shifts aufgrund von Muster eintragen
        for (int i = 0; i < m; i++) {
            shift[p.charAt(i)] = m - i;
        }
        // Suche
        int i = 0; // Text-Index
        int j = 0; // Pattern-Index
        do {
            if (a.charAt(i + j) == p.charAt(j)) { // Match?
                j++;
            } else {
                if ((i + m) < n) { // falls a.charAt(i1+m) nicht ausserhalb ist…
                    i += shift[a.charAt(i + m)]; // Sprung
                    j = 0;
                } else {
                    break; // sonst Ende
                }
            }
        } while ((j < m) && ((i + m) <= n));
        if (j == m) {
            return i; // Pattern gefunden
        } else {
            return -1; // nicht gefunden
        }
    }

    public static int optimalQuickSearch(final String text, final String pattern) {
        final int n = text.length();
        final int m = pattern.length();
        final int range = 256;
        final int[] shift = new int[range];
        final int[] compareOrder = new int[m];  // Dynamisch veränderbar

        // Schritt 1: Shift-Tabelle wie bei Quicksearch
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }
        for (int i = 0; i < m; i++) {
            shift[pattern.charAt(i)] = m - i;
        }

        // Schritt 2: Initiale Vergleichsreihenfolge = 0..m-1
        for (int i = 0; i < m; i++) {
            compareOrder[i] = i;
        }

        // Schritt 3: Suche mit dynamischer Reorganisation
        int i = 0;
        while ((i + m) <= n) {
            int j = 0;
            while (j < m && text.charAt(i + compareOrder[j]) == pattern.charAt(compareOrder[j])) {
                j++;
            }

            if (j == m) {
                return i; // Treffer
            }

            // Reorganisationsstrategie: Mismatch-Index an den Anfang verschieben
            if (j < m) {
                moveToFront(compareOrder, j);
            }

            // Shift nach Quicksearch-Regel
            if ((i + m) < n) {
                i += shift[text.charAt(i + m)];
            } else {
                break;
            }
        }

        return -1;
    }

    // Reorganisiert compareOrder[], indem das Element an Position `index` nach vorne geschoben wird
    public static void moveToFront(int[] array, int index) {
        int value = array[index];
        System.arraycopy(array, 0, array, 1, index);
        array[0] = value;
    }
}
