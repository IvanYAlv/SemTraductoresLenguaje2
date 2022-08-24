package com.mycompany.lex_an;

import java.io.*;

/**
 *
 * @author ivan_
 */
public class Lex_An {

    public static void main(String[] args) {
        Analizador an = new Analizador();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Ingrese la cadena: ");
            String ent = br.readLine();
            an.AnLe(ent);
        } catch (IOException ex) {}
    }
    
}
