package com.mycompany.lex_an;

import java.util.ArrayList;

/**
 *
 * @author ivan_
 */
public class Analizador {

    Tabla_Sim simb = new Tabla_Sim();

    void AnLe(String cad) {
        // Caaso cadena.
        if(cadC(cad) != null){
            int i = 0;
            ArrayList<String> cads = cadC(cad);
            while(i < cads.size()){
                cad = cad.replace(cads.get(i), "");
                System.out.println(cads.get(i) + "\"" + " = Cadena | Tipo " + simb.getSimb("cad"));
                i++;
            }
        }
        String[] partes = cad.split(" ");
        char com = 34;
        int x = 0;
        
        while (x < partes.length) {
            // Error si la entrada empieza con ".".
            if (partes[x].startsWith(".") || partes[x].endsWith(".")) {
                System.out.println("ERROR en: " + partes[x] + " -> La entrada no puede "
                        + "empezar o terminar con: .");
                // Error si la entrada empieza con números y continúa con letras.
            } else if (errNumLett(partes[x])) {
                System.out.println("ERROR en: " + partes[x] + " -> La entrada no puede "
                        + "empezar por un entero o real y continuar con identificadores");

            } else {
                // Caso identificador.
                if (onlyNumLett(partes[x]) && !resW(partes[x])) {
                    System.out.println(partes[x] + " = Identificador | Tipo " + simb.getSimb("id"));
                } else if ((contAlf(partes[x]) && !contNum(partes[x])) && (!resW(partes[x]))) {
                    System.out.println("ERROR en: " + partes[x] + " -> Algún símbolo no es válido");
                }
                // Caso entero.
                if (onlyInt(partes[x])) {
                    System.out.println(partes[x] + " = Entero | Tipo " + simb.getSimb("int"));
                }
                // Caso real.
                if (real(partes[x])) {
                    System.out.println(partes[x] + " = Real | Tipo " + simb.getSimb("real"));
                }
                // Caso cadena.
                // Caso adición.
                if (partes[x].equals("+") || partes[x].equals("-")) {
                    System.out.println(partes[x] + " = Operador de adición | Tipo " + simb.getSimb("opS"));
                } else if ((partes[x].contains("+") || partes[x].contains("-")) && !contAlf(partes[x])) {
                    System.out.println("ERROR en: " + partes[x] + " -> Entrada no válida");
                }
                // Caso multiplicación.
                if (partes[x].equals("*") || partes[x].equals("/")) {
                    System.out.println(partes[x] + " = Operador de multiplicación | Tipo " + simb.getSimb("opM"));
                } else if ((partes[x].contains("*") || partes[x].contains("/")) && !contAlf(partes[x])) {
                    System.out.println("ERROR en: " + partes[x] + " -> Entrada no válida");
                }
                // Caso asignación.
                if (partes[x].equals("=")) {
                    System.out.println(partes[x] + " -> Operador de asignación | Tipo " + simb.getSimb("="));
                } else if (partes[x].contains("=") && !partes[x].equals("==") && !partes[x].equals("<")
                        && !partes[x].equals(">") && !partes[x].equals("<=") && !partes[x].equals(">=") && !partes[x].equals("!=")
                        && !contAlf(partes[x])) {
                    System.out.println("ERROR en: " + partes[x] + " -> Entrada no válida");
                }
                // Caso relacional.
                if (partes[x].equals("<") || partes[x].equals(">") || partes[x].equals("<=") || partes[x].equals(">=") || partes[x].equals("!=")
                        || partes[x].equals("==")) {
                    if (partes[x].equals("<") || partes[x].equals(">") || partes[x].equals("<=") || partes[x].equals(">=")) {
                        System.out.println(partes[x] + " = Operador relacional | Tipo " + simb.getSimb("opR"));
                    } else {
                        System.out.println(partes[x] + " = Operador relacional | Tipo " + simb.getSimb("opI"));
                    }
                } else if (partes[x].contains("<") || partes[x].contains(">") || partes[x].contains("<=") || partes[x].contains(">=")
                        || partes[x].contains("!=") || partes[x].contains("==") && !contAlf(partes[x])) {
                    System.out.println("ERROR en: " + partes[x] + " -> Entrada no válida");
                }
                // Caso And.
                if (partes[x].equals("&&")) {
                    System.out.println(partes[x] + " = Operador And | Tipo " + simb.getSimb("opA"));
                } else if (partes[x].contains("&&")) {
                    System.out.println("ERROR en: " + partes[x] + " -> Entrada no válida");
                }
                // Caso Or.
                if (partes[x].equals("||")) {
                    System.out.println(partes[x] + " = Operador Or | Tipo " + simb.getSimb("opO"));
                } else if (partes[x].contains("||")) {
                    System.out.println("ERROR en: " + partes[x] + " -> Entrada no válida");
                }
                // Caso Not.
                if (partes[x].equals("!")) {
                    System.out.println(partes[x] + " = Operador Not | Tipo " + simb.getSimb("opN"));
                } else if (partes[x].contains("!") && !partes[x].contains("=")) {
                    System.out.println("ERROR en: " + partes[x] + " -> Entrada no válida");
                }
                // Caso paréntesis.
                if (partes[x].equals("(") || partes[x].equals(")")) {
                    System.out.println(partes[x] + " = Paréntesis | Tipo " + simb.getSimb(partes[x]));
                } else if (partes[x].contains("(") || partes[x].contains(")") && !contAlf(partes[x])) {
                    System.out.println("ERROR en: " + partes[x] + " -> Entrada no válida");
                }
                // Caso llave.
                if (partes[x].equals("{") || partes[x].equals("}")) {
                    System.out.println(partes[x] + " = Llave | Tipo " + simb.getSimb(partes[x]));
                } else if (partes[x].contains("{") || partes[x].contains("}") && !contAlf(partes[x])) {
                    System.out.println("ERROR en: " + partes[x] + " -> Entrada no válida");
                }
                // Caso punto y coma.
                if (partes[x].equals(";")) {
                    System.out.println(partes[x] + " = Punto y coma | Tipo " + simb.getSimb(";"));
                } else if (partes[x].contains(";") && !contAlf(partes[x])) {
                    System.out.println("ERROR en: " + partes[x] + " -> Entrada no válida");
                }
                // Caso if, while, return, else, int, float, void.
                if (resW(partes[x])) {
                    switch (partes[x]) {
                        case "if":
                            System.out.println(partes[x] + " = " + partes[x] + " | Tipo " + simb.getSimb(partes[x]));
                            break;
                        case "while":
                            System.out.println(partes[x] + " = " + partes[x] + " | Tipo " + simb.getSimb(partes[x]));
                            break;
                        case "return":
                            System.out.println(partes[x] + " = " + partes[x] + " | Tipo " + simb.getSimb(partes[x]));
                            break;
                        case "else":
                            System.out.println(partes[x] + " = " + partes[x] + " | Tipo " + simb.getSimb(partes[x]));
                            break;
                        case "int":
                            System.out.println(partes[x] + " = " + partes[x] + " | Tipo " + simb.getSimb("tipo"));
                            break;
                        case "float":
                            System.out.println(partes[x] + " = " + partes[x] + " | Tipo " + simb.getSimb("tipo"));
                            break;
                        case "void":
                            System.out.println(partes[x] + " = " + partes[x] + " | Tipo " + simb.getSimb("tipo"));
                            break;
                        default:
                    }
                }
                // Caso ,
                if (partes[x].equals(",")) {
                    System.out.println(partes[x] + " = coma | Tipo " + simb.getSimb(","));
                } else if (partes[x].contains(",") && !contAlf(partes[x])) {
                    System.out.println("ERROR en: " + partes[x] + " -> Entrada no válida");
                }
                // Caso $
                if (partes[x].equals("$")) {
                    System.out.println(partes[x] + " = $ | Tipo " + simb.getSimb("$"));
                } else if (partes[x].contains("$") && !contAlf(partes[x])) {
                    System.out.println("ERROR en: " + partes[x] + " -> Entrada no válida");
                }
            }
            x++;
        }
    }

    // ---Comprobar si la entrada comienza con números pero contiene letras.------
    static boolean errNumLett(String s) {
        int ide = 0;
        if ((s.startsWith("0") || s.startsWith("1") || s.startsWith("2") || s.startsWith("3") || s.startsWith("4")
                || s.startsWith("5") || s.startsWith("6") || s.startsWith("7") || s.startsWith("8") || s.startsWith("9")) && (contAlf(s))) {
            ide = 1;
        }
        if (ide == 1) {
            return true;
        } else {
            return false;
        }
    }

    static boolean contAlf(String s) {
        for (int i = 0; i < s.length(); i++) {
            char aux = s.charAt(i);
            if ((aux >= 'a' && aux <= 'z') || (aux >= 'A' && aux <= 'Z')) {
                return true;
            }
        }
        return false;
    }
    //------------------------------------------------------------------------------------------.

    // Comprobar si la entrada contiene números.
    static boolean contNum(String s) {
        boolean band = false;
        int i = 0;
        while (i < s.length() && band == false) {
            char aux = s.charAt(i);
            if (aux >= 48 && aux <= 57) {
                band = true;
            } else {
                i++;
            }
        }
        return band;
    }

    // Valida identificadores.
    static boolean onlyNumLett(String s) {
        boolean band = true;
        int i = 0;
        while (i < s.length() && band == true) {
            char aux = s.charAt(i);
            if (((s.charAt(0) >= 65 && s.charAt(0) <= 90) || (s.charAt(0) >= 97 && s.charAt(0) <= 122)) && ((aux >= 65 && aux <= 90)
                    || aux >= 48 && aux <= 57) || (aux >= 97 && aux <= 122) || (s.contains("ñ") || s.contains("Ñ"))) {
                i++;
            } else {
                band = false;
                return band;
            }
        }
        return band;
    }

    // Valida enteros.
    static boolean onlyInt(String s) {
        boolean band = true;
        int i = 0;
        while (i < s.length() && band == true) {
            char aux = s.charAt(i);
            if (aux >= 48 && aux <= 57) {
                i++;
            } else {
                band = false;
                return band;
            }
        }
        return band;
    }

    // Valida reales.
    static boolean real(String s) {
        boolean band = true;
        int i = 0;
        while (i < s.length() && band == true) {
            char aux = s.charAt(i);
            if ((aux >= 48 && aux <= 57 || aux == 46) && s.contains(".")) {
                i++;
            } else {
                band = false;
                return band;
            }
        }
        return band;
    }

    // Valida algunas palabras reservadas.
    static boolean resW(String s) {
        boolean band;
        switch (s) {
            case "if":
                band = true;
                break;
            case "while":
                band = true;
                break;
            case "return":
                band = true;
                break;
            case "else":
                band = true;
                break;
            case "int":
                band = true;
                break;
            case "float":
                band = true;
                break;
            case "void":
                band = true;
                break;
            default:
                band = false;
        }
        return band;
    }
    
    // Valida cadena.
    static ArrayList<String> cadC(String s){
        ArrayList<String> cads = new ArrayList<>();
        int pos[] = {-1, -1}, cont = 0, i = 0, x = 0;
        while(i < s.length()){
            if(s.charAt(i) == 34 && cont < 2){
                pos[cont] = i;
                cont++;
            }
            if(cont == 2){
                cads.add(s.substring(pos[0], (pos[1])));
                cont = 0;
                x++;
            }
            i++;
        }
        return cads;
    }
}
