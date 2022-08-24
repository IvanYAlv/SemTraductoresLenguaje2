package com.mycompany.lex_an;

/**
 *
 * @author ivan_
 */
public class Tabla_Sim {
    
    int getSimb(String s){
        switch(s){
            case "id": return 0;
            case "int": return 1;
            case "real": return 2;
            case "cad": return 3;
            case "tipo": return 4;
            case "opS": return 5;
            case "opM": return 6;
            case "opR": return 7;
            case "opO": return 8;
            case "opA": return 9;
            case "opN": return 10;
            case "opI": return 11;
            case ";": return 12;
            case ",": return 13;
            case "(": return 14;
            case ")": return 15;
            case "{": return 16;
            case "}": return 17;
            case "=": return 18;
            case "if": return 19;
            case "while": return 20;
            case "return": return 21;
            case "else": return 22;
            case "$": return 23;
            default: return -1;
        }
    }
    
}
