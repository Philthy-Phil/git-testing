import java.util.Locale;

public class StringManipulations {

    public static void main(String[] args) {

        String ausgabe = "Mein Name ist Bond. ";
        System.out.println(ausgabe + "James Bond.");

        System.out.println("###################################################");

        String string = "Man nennt mich " + "00" + "7.";
        System.out.println(string);

        System.out.println("###################################################");

        int zahl = 17 + 4;
        String string2 = "Drei Wochen haben " + zahl + " Tage.";
        System.out.println(string2);

        System.out.println("###################################################");

        String ausgabe2 = "Mein Name ist Bond. James Bond.";
        char zeichen = ausgabe2.charAt(1);

        if (ausgabe2 != null) {
            zeichen = ausgabe2.charAt(1);
            System.out.println(zeichen);
        } else {
            zeichen = ' ';
            System.out.println(zeichen);
        }

        System.out.println("###################################################");

        String ausgabe3a = "Mein Name ist Bond." + " James Bond.";
        System.out.println(ausgabe3a);
        String ausgabe3b = "Mein Name ist Bond.".concat(" James Bond.");
        System.out.println(ausgabe3b);
        boolean gleich = ausgabe3a.equals(ausgabe3b);
        System.out.println("Sind die Strings gleich? " + gleich);

        System.out.println("###################################################");

        String jb007 = "Mein Name ist Bond. James Bond.";
        String bond = "Mein Name ist Bond. " + "James Bond.";
        if (jb007.equals(bond)) {
            System.out.println("gleich");
        } else {
            System.out.println("nicht gleich");
        }

        System.out.println("###################################################");

        String ausgabe4 = "Mein Name ist Bond. James Bond.";
        boolean gleich2 = ausgabe4.equalsIgnoreCase("MEIN name ist bOND. James bond.");
        System.out.println(gleich2);

        System.out.println("###################################################");

        int laenge = ausgabe4.length();
        System.out.println(ausgabe4 + " hat eine Länge von " + laenge);

        System.out.println("###################################################");

        boolean leer = ausgabe4.isEmpty();
        System.out.println(leer);

        System.out.println("###################################################");

        boolean istDrin = ausgabe4.contains("Bond");
        System.out.println(istDrin);

        boolean istDrin2 = ausgabe4.toLowerCase().contains("bond");
        System.out.println(istDrin2);

        System.out.println("###################################################");

        String ausgabe5 = "      Mein Name ist Bond. James Bond        ";
        String neu = ausgabe5.trim();
        System.out.println(neu);

        System.out.println("###################################################");

        int position = ausgabe4.indexOf("Bond");
        System.out.println(position);
        int position2 = ausgabe4.indexOf("Bond", 15);
        System.out.println(position2);

        while (position >= 0) {
            System.out.println("Position: " + position);
            position = ausgabe4.indexOf("Bond", position + 1);
        }

        System.out.println("###################################################");

        String bond2 = ausgabe4.substring(26);
        System.out.println(bond2);
        String bond3 = ausgabe4.substring(26, 30);
        System.out.println(bond3);

        System.out.println("###################################################");

        String ichBins = ausgabe4.replace("Bond", "Willemer");
        System.out.println(ichBins);

        String such = "Bond";
        String ersatz = "Gutter";
        String ichBinds2 = ausgabe4.replaceAll(such, ersatz);
        System.out.println(ichBinds2);

        System.out.println("###################################################");

        String ich007 = ausgabe4.replaceAll("[A-Z]o.d", "Willemer");
        System.out.println(ich007);

        String nocheiner = ausgabe4.replaceAll("[A-Z].*e", "Willemer");
        System.out.println(nocheiner);

        System.out.println("###################################################");

        int zahlenVariable = 7;
        String zahlString = "" + zahlenVariable;
        System.out.println(zahlString);

        System.out.println("###################################################");

        int zahl2 = Integer.parseInt("122");
        double wert = Double.parseDouble("12.2");
        System.out.println(zahl2 + " | " + wert);

        System.out.println("###################################################");

        String linuxPfad = "/media/usbstick/daten/unfug";
        String windowsPfad = "";
        int pos = 0;
        int oldPos = 0;
        while (pos >= 0) {
            pos = linuxPfad.indexOf('/', oldPos);
            if (pos >= 0) {
                if (pos > oldPos) {
                    windowsPfad = windowsPfad + "\\" + linuxPfad.substring(oldPos, pos);
                }
                oldPos = pos + 1;
            }
        }
        if (oldPos < linuxPfad.length()) {
            windowsPfad = windowsPfad + "\\" + linuxPfad.substring(oldPos, linuxPfad.length());
        }
        System.out.println(linuxPfad);
        System.out.println(windowsPfad);

        System.out.println("###################################################");

        String linuxPfad2 = "/media/usbstick/daten/unfug";
        String windowsPfad2 = linuxPfad2.replace("/", "\\");
        System.out.println(linuxPfad2);
        System.out.println(windowsPfad2);

        System.out.println("###################################################");

        StringBuilder pfad = new StringBuilder("/media/usbstick/daten/unfug");
        int pos3 = 0;
        int oldPos3 = 0;
        while (pos3 >= 0) {
            pos3 = pfad.indexOf("/", oldPos3);
            if (pos3 >= 0) {
                pfad.setCharAt(pos3, '\\');
            }
            if (pos3 >= 0) oldPos3 = pos3 + 1;
        }
        System.out.println(linuxPfad);
        System.out.println(pfad);

        System.out.println("###################################################");

        String ausgabe6 = "Mein Name ist Bond. James Bond.";
        int laenge6 = ausgabe6.length();
        for (int i = 0; i < laenge6; i++) {
            System.out.print(ausgabe6.charAt(i) + " ");
        }
        System.out.println();

        System.out.println("###################################################");

        String searchString = "bla";
        String allString = "blablabla blabla blablabla";
        int positionA = 0;
        int countDupl = 0;
        while (positionA >= 0) {
//            System.out.println("Position: " + positionA);
            positionA = allString.indexOf(searchString, positionA + 1);
            countDupl++;
        }
        System.out.println("der String" + " " + searchString + " kommt " + countDupl + " im gesamten String vor");

        System.out.println("###################################################");

        String pal = "Ein Neger mit Gazelle zagt im Regen nie";
        pal = pal.toLowerCase().replaceAll(" ", "");

        System.out.println("normal: " + pal);

        char[] palSplit = pal.toLowerCase().toCharArray();
        char[] palRevSplit = new char[palSplit.length];

        int k = palSplit.length - 1;

        for (int i = 0; i < palSplit.length; i++) {
            palRevSplit[k] = palSplit[i];
            k--;
        }
        String revPal = new String(palRevSplit);

        System.out.println("reversed: " + revPal);

        if (pal.equals(revPal)) {
            System.out.println("true, its a palindrom");
        } else {
            System.out.println("false, its not a palindrom");
        }

        System.out.println("###################################################");

        String input = "haha 1245 huhu";
        int poS = 0;
        long ergebnis = 0L;
        char sign = input.charAt(poS);

        while (sign < '0' || sign > '9') {
            poS++;
            sign = input.charAt(poS);
        }
        while (sign >= '0' && sign <= '9') {
            ergebnis *= 10;
            ergebnis += sign - '0';
            poS++;
            sign = input.charAt(poS);
        }
//        if (sign == '.' || sign == ',') {
//            poS++;
//            sign = input.charAt(poS);
//            double komma = 1.0;
//            while (sign >= '0' && sign <= '9') {
//                komma *= 10;
//                ergebnis *= 10;
//                ergebnis += sign-'0';
//                poS++;
//                sign = input.charAt(poS);
//            }
//            ergebnis /= komma;
//        }
        System.out.println(ergebnis);


    }

}
