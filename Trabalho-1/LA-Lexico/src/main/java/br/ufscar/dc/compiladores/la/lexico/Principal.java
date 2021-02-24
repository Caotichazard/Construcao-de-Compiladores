/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.compiladores.la.lexico;

/**
 *
 * @author salomao
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.ParseCancellationException;


public class Principal {
    
    
    public static void main(String[] args) {
        
        try {
            List<String> list  = new ArrayList<>();
            // args[0] é o primeiro argumento da linha de comando
            CharStream cs = CharStreams.fromFileName(args[0]);
            LALexer lex = new LALexer(cs);
            Token t = null;
            while ((t = lex.nextToken()).getType() != Token.EOF) {
                String tmp = tokenParser(t);
                list.add(tmp);
                if(tmp.contains(" - simbolo nao identificado") || tmp.contains("comentario nao fechado") || tmp.contains("cadeia literal nao fechada")){
                    break;
                }
            }
            saveToFile(list,args[1]);
        } catch (IOException ex) {
            System.out.println("BBBBB");
        } catch(ParseCancellationException ex){
            System.out.println("AAAA");
        }
    }
    
    public static void saveToFile(List<String> list,String pathToFile){
        try{
            PrintWriter out = new PrintWriter(new FileWriter(pathToFile));
            //System.out.println(list);
            for (String temp: list) {
                out.println(temp);
            }
        out.close();
        }catch(IOException ex){
            
        }
    }
    
    public static String tokenParser(Token token){
        String tmp = LALexer.VOCABULARY.getDisplayName(token.getType());
        if(null == tmp){
            return "<" + LALexer.VOCABULARY.getDisplayName(token.getType())  + "," + token.getText() + ">";
        }else switch (tmp) {
            case "IDENT":
                return "<'"+token.getText() + "'," + "IDENT>";
            case "CADEIA":
                return "<'"+token.getText() + "'," + "CADEIA>";
            case "NUM_INT":
                return "<'"+token.getText() + "'," + "NUM_INT>";
            case "NUM_REAL":
                return "<'"+token.getText() + "'," + "NUM_REAL>";
            case "ERROR_CHAR":
                return "Linha "+ token.getLine() + ": " + token.getText() + " - simbolo nao identificado";
            case "COMENT_NFECHADO":
                return "Linha "+ token.getLine() + ": comentario nao fechado";
            case "CADEIA_NFIM":
                System.out.println("AAAAAAAa");
                return "Linha "+ token.getLine() + ": cadeia literal nao fechada";
            default:
                return "<'" + token.getText() + "','"+token.getText()+"'>";
        }
        
    }
    
}
