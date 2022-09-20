package aeskey_1627054;

public class AESkey_1627054 {

    public static void main(String[] args) {

//        String key = "54 68 61 74 73 20 6D 79 20 4B 75 6E 67 20 46 75";
//        String plaintext = "54 77 6F 20 4F 6E 65 20 4E 69 6E 65 20 54 77 6F";
       // String key = "0f 15 71 c9 47 d9 e8 59 0c b7 ad d6 af 7f 67 98";
        String key = "80 00 00 00 00 00 00 00 00 00 00 00 00 00 00 01";
        String plaintext = "01 23 45 67 89 ab cd ef fe dc ba 98 76 54 32 10";
        String w[][] = new String[4][4];
        String p[][] = new String[4][4];

        int m = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                w[j][i] = "";
                p[j][i] = "";
                while (m != (key.length())) {
                    if (key.charAt(m) == ' ') {
                        m++;
                        break;
                    }
                    w[j][i] += String.valueOf(key.charAt(m));
                    p[j][i] += String.valueOf(plaintext.charAt(m));
                    m++;
                    
                }
            }
        }
        System.out.println(key);
        System.out.println("Key");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(w[i][j] + "  ");
            }
            System.out.println(" ");
        }
        System.out.println("///////////////////////plain");
        System.out.println(plaintext);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(p[i][j] + "  ");
            }
            System.out.println(" ");
        }
        
        String[][] sbox = {
            {"63", "7c", "77", "7b", "f2", "6b", "6f", "c5", "30", "01", "67", "2b", "fe", "d7", "ab", "76"},
            {"ca", "82", "c9", "7d", "fa", "59", "47", "f0", "ad", "d4", "a2", "af", "9c", "a4", "72", "c0"},
            {"b7", "fd", "93", "26", "36", "3f", "f7", "cc", "34", "a5", "e5", "f1", "71", "d8", "31", "15"},
            {"04", "c7", "23", "c3", "18", "96", "05", "9a", "07", "12", "80", "e2", "eb", "27", "b2", "75"},
            {"09", "83", "2c", "1a", "1b", "6e", "5a", "a0", "52", "3b", "d6", "b3", "29", "e3", "2f", "84"},
            {"53", "d1", "00", "ed", "20", "fc", "b1", "5b", "6a", "cb", "be", "39", "4a", "4c", "58", "cf"},
            {"d0", "ef", "aa", "fb", "43", "4d", "33", "85", "45", "f9", "02", "7f", "50", "3c", "9f", "a8"},
            {"51", "a3", "40", "8f", "92", "9d", "38", "f5", "bc", "b6", "da", "21", "10", "ff", "f3", "d2"},
            {"cd", "0c", "13", "ec", "5f", "97", "44", "17", "c4", "a7", "7e", "3d", "64", "5d", "19", "73"},
            {"60", "81", "4f", "dc", "22", "2a", "90", "88", "46", "ee", "b8", "14", "de", "5e", "0b", "db"},
            {"e0", "32", "3a", "0a", "49", "06", "24", "5c", "c2", "d3", "ac", "62", "91", "95", "e4", "79"},
            {"e7", "c8", "37", "6d", "8d", "d5", "4e", "a9", "6c", "56", "f4", "ea", "65", "7a", "ae", "08"},
            {"ba", "78", "25", "2e", "1c", "a6", "b4", "c6", "e8", "dd", "74", "1f", "4b", "bd", "8b", "8a"},
            {"70", "3e", "b5", "66", "48", "03", "f6", "0e", "61", "35", "57", "b9", "86", "c1", "1d", "9e"},
            {"e1", "f8", "98", "11", "69", "d9", "8e", "94", "9b", "1e", "87", "e9", "ce", "55", "28", "df"},
            {"8c", "a1", "89", "0d", "bf", "e6", "42", "68", "41", "99", "2d", "0f", "b0", "54", "bb", "16"}
        };
        String inverssbox[][] = {
        {"52", "09", "6A", "D5", "30", "36", "A5", "38", "BF", "40", "A3", "9E", "81", "F3", "D7", "FB"},
        {"7C", "E3", "39", "82", "9B", "2F", "FF", "87", "34", "8E", "43", "44", "C4", "DE", "E9", "CB"},
        {"54", "7B", "94", "32", "A6", "C2", "23", "3D", "EE", "4C", "95", "0B", "42", "FA", "C3", "4E"},
        {"08", "2E", "A1", "66", "28", "D9", "24", "B2", "76", "5B", "A2", "49", "6D", "8B", "D1", "25"},
        {"72", "F8", "F6", "64", "86", "68", "98", "16", "D4", "A4", "5C", "CC", "5D", "65", "B6", "92"},
        {"6C", "70", "48", "50", "FD", "ED", "B9", "DA", "5E", "15", "46", "57", "A7", "8D", "9D", "84"},
        {"90", "D8", "AB", "00", "8C", "BC", "D3", "0A", "F7", "E4", "58", "05", "B8", "B3", "45", "06"},
        {"D0", "2C", "1E", "8F", "CA", "3F", "0F", "02", "C1", "AF", "BD", "03", "01", "13", "8A", "6B"},
        {"3A", "91", "11", "41", "4F", "67", "DC", "EA", "97", "F2", "CF", "CE", "F0", "B4", "E6", "73"},
        {"96", "AC", "74", "22", "E7", "AD", "35", "85", "E2", "F9", "37", "E8", "1C", "75", "DF", "6E"},
        {"47", "F1", "1A", "71", "1D", "29", "C5", "89", "6F", "B7", "62", "0E", "AA", "18", "BE", "1B"},
        {"FC", "56", "3E", "4B", "C6", "D2", "79", "20", "9A", "DB", "C0", "FE", "78", "CD", "5A", "F4"},
        {"1F", "DD", "A8", "33", "88", "07", "C7", "31", "B1", "12", "10", "59", "27", "80", "EC", "5F"},
        {"60", "51", "7F", "A9", "19", "B5", "4A", "0D", "2D", "E5", "7A", "9F", "93", "C9", "9C", "EF"},
        {"A0", "E0", "3B", "4D", "AE", "2A", "F5", "B0", "C8", "EB", "BB", "3C", "83", "53", "99", "61"},
        {"17", "2B", "04", "7E", "BA", "77", "D6", "26", "E1", "69", "14", "63", "55", "21", "0C", "7D"}};
        String Rcon[] = {"01", "02", "04", "08", "10", "20", "40", "80", "1b", "36"};
        
           String mixcolumn[][] = {
            {"02", "03", "01", "01"},
            {"01", "02", "03", "01"},
            {"01", "01", "02", "03"},
            {"03", "01", "01", "02"}};
           
           
        System.out.println("//////////////////////Key expansion");
        AesKey k[] = new AesKey[11];
        for (int i = 0; i < 11; i++) {
            k[i] = new AesKey();
        }

        for (int j = 0; j < 4; j++) {
            k[0].w0 += w[j][0];
            k[0].w1 += w[j][1];
            k[0].w2 += w[j][2];
            k[0].w3 += w[j][3];
        }
        k[0].key = k[0].w0 + " " + k[0].w1 + " " + k[0].w2 + " " + k[0].w3;
        System.out.println("w0  : " + k[0].w0);
        System.out.println("w1  : " + k[0].w1);
        System.out.println("w2  : " + k[0].w2);
        System.out.println("w3  : " + k[0].w3);
        System.out.println("k0  : " + k[0].key);
        String nw3 = "";
        String r = "";
        for (int c = 1; c < 11; c++) {     
            nw3 = shiftbyte(k[c - 1].w3);
//            System.out.println("nw3 : " + nw3);
            nw3 = subbyte(nw3, sbox); 
//             System.out.println("nw3 : " + nw3);
            r = bRcon(Rcon[c - 1]);
            //System.out.println("r : " + r);
            k[c].w0 = Xor(Xor(hextoBin(k[c - 1].w0), hextoBin(nw3)), r);
            k[c].w0 = binToHex(k[c].w0);
            k[c].w1 = Xor(hextoBin(k[c - 1].w1), hextoBin(k[c].w0));
            k[c].w1 = binToHex(k[c].w1);
            k[c].w2 = Xor(hextoBin(k[c - 1].w2), hextoBin(k[c].w1));
            k[c].w2 = binToHex(k[c].w2);
            k[c].w3 = Xor(hextoBin(k[c - 1].w3), hextoBin(k[c].w2));
            k[c].w3 = binToHex(k[c].w3);
            System.out.println(c + " " + k[c].w0 + " " + k[c].w1 + " " + k[c].w2 + " " + k[c].w3);

        }

        System.out.println("//////////////////////////encrypt");

        for (int sk = 0; sk < 10; sk++) {

            System.out.println("//////////round" + ": " + (sk + 1));
            System.out.println("//////////////////////roundkey");
            p = addRoundkey(p, w);
/////////////////////////subbyte
          System.out.println("/////////////////////subbyte");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    p[i][j] = subbyte(p[i][j], sbox);
                    System.out.print(p[i][j] + "  ");
                }
                System.out.println(" ");
            }
            /////////////////////shiftrow
             System.out.println("/////////////////////shiftrow");
            p = shiftrow(p, 1, 0);
            p = shiftrow(p, 2, 1);
            p = shiftrow(p, 3, 2);
           
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(p[i][j] + "  ");
                }
                System.out.println(" ");
            }
            //////////////////////////mixcolumn
            System.out.println("/////////////////////////mixcolumn");
            if (sk < 9) {
                p = Mixcolumn(p, mixcolumn);
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
//                p[j][i]=subbyte(p[j][i], sbox);
                        System.out.print(p[i][j] + "  ");
                    }
                    System.out.println(" ");
                }
                ///////////////////moving the key
                for (int j = 0; j < 4; j++) {
                    w[j][0] = k[sk + 1].w0.substring(j * 2, j * 2 + 2);
                    w[j][1] = k[sk + 1].w1.substring(j * 2, j * 2 + 2);
                    w[j][2] = k[sk + 1].w2.substring(j * 2, j * 2 + 2);
                    w[j][3] = k[sk + 1].w3.substring(j * 2, j * 2 + 2);
                }
            }

            System.out.println("/////////// key");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
//                p[j][i]=subbyte(p[j][i], sbox);
                    System.out.print(w[i][j] + "  ");
                }
                System.out.println(" ");
            }
//            System.out.println("///////////////the cipher");
//            for (int i = 0; i < 4; i++) {
//                for (int j = 0; j < 4; j++) {
////                p[j][i]=subbyte(p[j][i], sbox);
//                    System.out.print(p[i][j] + "  ");
//                }
//                System.out.println(" ");
//            }

        }
        for (int j = 0; j < 4; j++) {
            w[j][0] = k[10].w0.substring(j * 2, j * 2 + 2);
            w[j][1] = k[10].w1.substring(j * 2, j * 2 + 2);
            w[j][2] = k[10].w2.substring(j * 2, j * 2 + 2);
            w[j][3] = k[10].w3.substring(j * 2, j * 2 + 2);

        }
        p = addRoundkey(p, w);
        System.out.println("//////////////last round");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
//                p[j][i]=subbyte(p[j][i], sbox);
                System.out.print(p[i][j] + "  ");
            }
            System.out.println(" ");
        }
        System.out.println("//////////////Decryption");
        for (int j = 0; j < 4; j++) {
            w[j][0] = k[10].w0.substring(j * 2, j * 2 + 2);
            w[j][1] = k[10].w1.substring(j * 2, j * 2 + 2);
            w[j][2] = k[10].w2.substring(j * 2, j * 2 + 2);
            w[j][3] = k[10].w3.substring(j * 2, j * 2 + 2);
        }
        p = addRoundkey(p, w);
        for (int sk = 0; sk < 10; sk++) {
        /////////////////////////inv subbyte
          System.out.println("/////////////////////subbyte");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    p[i][j] = subbyte(p[i][j], inverssbox);
                    System.out.print(p[i][j] + "  ");
                }
                System.out.println(" ");
            }
        
        
        
        }
        
        
        
        
        

    }

    static String hextoBin(String input) {
        int n = input.length() * 4;
        input = Long.toBinaryString(
                Long.parseUnsignedLong(input, 16));
        while (input.length() < n) {
            input = "0" + input;
        }
        return input;
    }

    // binary to hexadecimal conversion
    static String binToHex(String input) {
        int n = (int) input.length() / 4;
        input = Long.toHexString(
                Long.parseUnsignedLong(input, 2));
        while (input.length() < n) {
            input = "0" + input;
        }
        return input;
    }

    static String shiftbyte(String w) {
        String g = "";
        g += w.substring(2, w.length());
        g += w.substring(0, 2);

        return g;
    }

    static String subbyte(String w3, String sbox[][]) {
        String nw3 = "";
        for (int i = 0; i < w3.length(); i += 2) {
            int row = Integer.parseInt(String.valueOf(w3.charAt(i)), 16);
            int column = Integer.parseInt(String.valueOf(w3.charAt(i + 1)), 16);
            nw3 += sbox[row][column];
        }

        return nw3;
    }

    static String Xor(String R, String K) {
        String EK = "";
        for (int i = 0; i < R.length(); i++) {
            if (R.charAt(i) == K.charAt(i)) {
                EK += "0";
            } else {
                EK += "1";
            }
        }

        return EK;

    }

    static String bRcon(String a) {
        a += "000000";
        a = hextoBin(a);
        return a;

    }

    static String[][] addRoundkey(String p[][], String key[][]) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                p[i][j] = binToHex(Xor(hextoBin(p[i][j]), hextoBin(key[i][j])));
            }

        }
        return p;
    }

    static String[][] shiftrow(String p[][], int row, int c) {

        String t = p[row][0];
        p[row][0] = p[row][1];
        p[row][1] = p[row][2];
        p[row][2] = p[row][3];
        p[row][3] = t;
        if (c == 0) {
            return p;
        }
        return shiftrow(p, row, c - 1);
    }
    static String[][] invshiftrow(String p[][], int row, int c) {

        String t = p[row][3];
        p[row][3] = p[row][2];
        p[row][2] = p[row][1];
        p[row][1] = p[row][0];
        p[row][0] = t;
        if (c == 0) {
            return p;
        }
        return shiftrow(p, row, c - 1);
    }
//https://www.javatpoint.com/java-program-to-multiply-two-matrices
    //all i needed was product of two  matrices
    static String[][] Mixcolumn(String p[][], String m[][]) {
        String rc1, rc2, rc3, rc4, c1, c2;
        String c[][] = new String[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                c[i][j] = "";
//                for (int k = 0; k < 3; k++) {
//                    c[i][j]=xm(c[i][j], xm(m[i][k], p[k][j]));
//                }
                rc1 = xm(m[i][0], p[0][j]);
                rc2 = xm(m[i][1], p[1][j]);
                rc3 = xm(m[i][2], p[2][j]);
                rc4 = xm(m[i][3], p[3][j]);

                c1 = Xor(hextoBin(rc1), hextoBin(rc2));
                c2 = Xor(hextoBin(rc3), hextoBin(rc4));
                c[i][j] = binToHex(Xor(c1, c2));

            }

        }
        return c;
    }

                              
    static String xm(String m, String p) {
        
        if(m.equals(""))
            return p;

        if (m.equals("01")) {

            return p;
        } else if (m.equals("02")) {

            p = hextoBin(p);

            if (p.charAt(0) == '0') {

                String f = p.substring(1, p.length());

                f += "0";

                return binToHex(f);
            } else if (p.charAt(0) == '1') {

                String f = p.substring(1, p.length());
                f += "0";

                return binToHex(Xor(f, hextoBin("1B")));
            }
        } else if (m.equals("03")) {
            return binToHex(Xor(hextoBin(xm("02", p)), hextoBin(p)));
        }

        return p;

    }

}

//         p= addRoundkey(p, w);
//         for (int i = 0; i < 4; i++) {
//                for (int j = 0; j < 4; j++) {
////                p[j][i]=subbyte(p[j][i], sbox);
//                    System.out.print(p[i][j] + "  ");
//                }
//                System.out.println(" ");
//            }
