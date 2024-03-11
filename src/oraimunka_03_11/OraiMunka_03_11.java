/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oraimunka_03_11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class OraiMunka_03_11 {

    
    public static void main(String[] args) throws IOException {
        nehanySzamokGyoke();
       
        /*tomb kiiras 3asaval*/

        tombMegjelenitese();

       
    }

    private static void nehanySzamokGyoke() {
        haromSzamGyoke();
        
        otSzamGyoke();
    }
        private static void haromSzamGyoke() {
        /* 3 szám gyökének a megjelenítésével*/
        int osszeg = osszegzes(2,osszegzes(3,4));
        double gyok = gyokVonas(osszeg);
        String kimenet = "%d gyöke: %.4f\n".formatted(osszeg,gyok);
        konzolraIr(kimenet);
    }

    private static void otSzamGyoke() {
        /* 5 szám gyökének a megjelenítésével   */
        int [] szamok = {7,7,6,2,3};
        int osszeg = osszegzes(szamok);
        //osszeg = osszegzes(6,osszegzes(5,osszegzes(2,osszegzes(3,4))));
        double gyok = gyokVonas(osszeg);
        String kimenet = "%d gyöke: %.4f\n".formatted(osszeg,gyok);
        konzolraIr(kimenet);
    }

    private static int osszegzes(int a,int b) {
        return osszegzes(new int []{a,b});
    }

    private static int osszegzes(int[] szamok) {
        int gyujto = 0;
        for (int  i = 0;  i < szamok.length;  i++) {
            gyujto += szamok[i];
        }
        return gyujto;
    }



    private static double gyokVonas(int szam) {
        return Math.sqrt(szam);
    }
        private static void konzolraIr(String kimenet) {
        System.out.println(kimenet);
    }
        
        
        
    private static char[] tombKeszit(int meret) {
        char [] tomb = new char [meret];
        for (int i = 0; i < meret; i++) {
            tomb[i] = (char)(i+97);
        }
        return tomb;
    }
    
    private static void tombMegjelenitese() throws IOException {
        char[] tomb = tombKeszit(21);
        konzolonEgysorban(tomb);
        konzolonMatrixban(tomb);
        fajlbaTablazatban(tomb);
    }



    private static void konzolonEgysorban(char[] tomb) {
        String kimenet = egymasutanSzokozzel(tomb);
        konzolraIr("tömb elemi 1 sorban\n");
        konzolraIr(kimenet +"\n");
    }
        private static void konzolonMatrixban(char[] tomb) {
        String kimenet = tablazatban(tomb);
        konzolraIr("Tömb elemi táblázatban\n");
        konzolraIr(kimenet +"\n");
    }

    private static String egymasutanSzokozzel(char [] tomb) {
        String kimenet = "";
        for (int i = 0; i < tomb.length; i++) {
            kimenet += tomb[i] + " ";
        }
        return kimenet;
    }

    
        private static String tablazatban(char [] tomb,int oszlop) {
        String kimenet = "";
        for (int i = 0; i < tomb.length; i++) {
            if(i != 0 && i % oszlop == 0){
                kimenet += "\n";
            }
            kimenet += tomb[i]+" ";
            
        }
        return kimenet;
    }
    
    private static String tablazatban(char [] tomb) {
        String kimenet = "";
        for (int i = 0; i < tomb.length; i++) {
            if(i != 0 && i % 3 == 0){
                kimenet += "\n";
            }
            kimenet += tomb[i]+" ";
            
        }
        return kimenet;
    }

    private static void fajlbaTablazatban(char[]tomb) throws IOException {
        String kimenet = tablazatban(tomb);
        konzolraIr("Tömb elemi táblázatban\n");
        konzolraIr(kimenet +"\n");
        fajlbair(kimenet+ "\n");
        
    }

    private static void fajlbair(String uzenet) throws IOException {
        Path hova = Paths.get("fajlNeve.txt");
        Files.write(hova, uzenet.getBytes());
    }





    
    
}
