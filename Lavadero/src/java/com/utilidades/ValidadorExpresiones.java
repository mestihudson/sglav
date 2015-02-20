/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilidades;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jcmm
 */
public class ValidadorExpresiones {
    String palabran;
    List<String> palabras=new LinkedList();
    List<String> palabrasNEG=new LinkedList();
    
    public void incluirPalabras(){
        palabras.add("Nojoda");
        palabras.add("Culo");
    }
    
    public boolean validar(String cadena){
     boolean tiene=false;     
     for(String p:palabras){
     Pattern pat = Pattern.compile(".*"+p+".*");
     Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            tiene=true;
            palabran=p;palabrasNEG.add(p);
            break;
        }
     }
     return tiene;    
    }
    
    
}
