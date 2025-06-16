package ch.hslu.ad.A4_EX_Textsuche;

public class KMP {

    public static void main(String[] args) {
        String pattern = "ananas";
        String t1 = "anananssannaanananasan";
        System.out.println(kmpSearch(t1, pattern));
    }

    public static int kmpSearch(String text, String pattern) {
        StringBuilder s1 = new StringBuilder();
        int counter = 0;
        int[] tabelle = randTabelle(pattern); // Rand-Tabelle erstellen
        int j = 0; // Index im Pattern = Zustand des Automaten
        for (int i = 0; i < text.length(); i++) {
            s1.append(text.charAt(i));
            System.out.println(counter + ". i = " + i + " | j = " + j + " | " + s1);
            counter++;
            // Fall 2 (kann mehrfach auftreten, daher Schleife)
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = tabelle[j]; // Automat gemäss Randtabelle zurücksetzen
                s1.setLength(j);
                System.out.println(counter + ". i = " + i + " | j = " + j + " | " + s1);
                counter++;
            }
            // Fall 1 (Fall 3 ist implizit in der for-Schleife enthalten)
            if (text.charAt(i) == pattern.charAt(j)) {
                j++; // Match, nächstes Zeichen im Pattern
                //System.out.println(counter + ". i = " + i + " | j = " + j);
            }

            //System.out.println(counter + ". i = " + i + " | j = " + j);
            // Pattern gefunden? Startposition zurückliefern
            if (j == pattern.length()) return i - j + 1;
        }
        return -1; // Pattern nicht gefunden
    }

    public static int[] randTabelle(String pattern) {
        int[] tabelle = new int[pattern.length() + 1];
        tabelle[0] = 0; // eigentlich uninteressant, da wir nie auf tabelle[0] zugreifen
        int j = 0; // j ist der Index im Pattern

        for (int i = 1; i < pattern.length(); i++) {
            // Falls aktuelles Präfix nicht verlängert werden kann,
            // gehe zu einem kürzeren Präfix zurück
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = tabelle[j];
            }

            // Wenn das aktuelle Zeichen mit dem Zeichen an der Position j übereinstimmt,
            // dann verlängere das Präfix
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            // Setze den Wert in der Randtabelle für die aktuelle Position i
            tabelle[i + 1] = j;
        }
        return tabelle;
    }
}
