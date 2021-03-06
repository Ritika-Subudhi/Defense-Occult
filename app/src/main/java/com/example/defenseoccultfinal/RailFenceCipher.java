package com.example.defenseoccultfinal;

public class RailFenceCipher {

    static String RFEncryptionWork(int key, String text) {
        int move = 1;
        int count = 0;
        String[][] rfp = new String[key][text.length()];

        // arrange dot fence
        for (int x = 0; x < rfp.length; x++) {
            for (int y = 0; y < rfp[x].length; y++) {
                rfp[x][y] = ".";
            }
        }

        // formatting according fence rails
        for (int i = 0; i < text.length(); i++) {
            if ((move % 2) != 0) {
                rfp[count][i] = "" + text.charAt(i);
                if (count == (key - 1)) {
                    move = 2;
                    count = (key - 2);
                } else
                    count++;
            } else if ((move % 2) == 0) {
                rfp[count][i] = "" + text.charAt(i);
                if (count == 0) {
                    move = 1;
                    count = 1;
                } else
                    count--;
            }

        }

        //replace any white space with X or random
        for (int x = 0; x < rfp.length; x++) {
            for (int y = 0; y < rfp[x].length; y++) {
                if (rfp[x][y].equals(" "))
                    rfp[x][y] = " ";
            }
        }

        // display
        /*System.out.println();
        for (int i = 0; i < rfp.length; i++) {
            for (int u = 0; u < rfp[i].length; u++) {
                System.out.print(rfp[i][u] + " ");
            }
            System.out.println();
        }
        System.out.println();*/

        StringBuilder cb = new StringBuilder();
        //encode string from fence
        for (int i = 0; i < rfp.length; i++) {
            for (int u = 0; u < rfp[i].length; u++) {
                if (!".".equals(rfp[i][u])) {
                    cb.append(rfp[i][u]);
                }
            }
        }

        return "" + cb;
    }

    static String RFDecryptionWork(String text, int key) {
        String[][] rfp = new String[key][text.length()];

        for (int x = 0; x < rfp.length; x++) {
            for (int y = 0; y < rfp[x].length; y++) {
                rfp[x][y] = ".";
            }
        }

        // arrange according to fence rail
        int count = 0;
        int c = 1;
        int a = 0, b = 0;
        int init = (2 * key) - 2;
        a = init - 2;
        b = 2;
        for (int i = 0; i < rfp.length; i++) {
            c = 0;
            for (int u = i; u < rfp[i].length;) {
                if (count != text.length()) {
                    if (i == 0 || i == key - 1) {
                        rfp[i][u] = "" + text.charAt(count);
                        u = u + init;
                    } else {
                        rfp[i][u] = "" + text.charAt(count);
                        if (c % 2 == 0)
                            u = u + a;
                        else if (c % 2 == 1)
                            u = u + b;
                        c++;
                    }
                    count++;
                } else
                    break;

            }
            if (i != 0 && i != key - 1) {
                a = a - 2;
                b = b + 2;
            }
        }

        //display
       /* System.out.println("\n\nDecrypting..list into table");

        for (int i = 0; i < rfp.length; i++) {
            for (int u = 0; u < rfp[i].length; u++) {
                System.out.print(rfp[i][u] + " ");
            }
            System.out.println();
        }*/

        int move = 1;
        count = 0;
        String sb = "";
        for (int i = 0; i < text.length(); i++) {
            if ((move % 2) != 0) {
                sb = sb + rfp[count][i];
                if (count == (key - 1)) {
                    move = 2;
                    count = (key - 2);
                } else
                    count++;
            } else if ((move % 2) == 0) {
                sb = sb + rfp[count][i];
                if (count == 0) {
                    move = 1;
                    count = 1;
                } else
                    count--;
            }

        }

        return sb;
    }

}
