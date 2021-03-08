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
import java.io.PrintWriter;
import java.util.BitSet;
import org.antlr.v4.runtime.ANTLRErrorListener; // cuidado para importar a versão 4
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token; // Vamos também precisar de Token
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.ParseCancellationException;
// Outros imports vão ser necessários aqui. O NetBeans ou IntelliJ fazem isso automaticamente

public class MyErrorListener implements ANTLRErrorListener {
    
    PrintWriter pw;
    public MyErrorListener(PrintWriter pw) {
      this.pw = pw;    
    }

    @Override
    public void	reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }
    
    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }

    @Override
    public void	syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        

        Token t = (Token) offendingSymbol;//recebe a instancia do token que ocorreu o erro
        
        String tokenType = LALexer.VOCABULARY.getSymbolicName(t.getType());//recebe o tipo do token segundo o vocabulario
        String output = "";//aqui sera armazenada a string a ser impressa no terminal
        
        //System.out.println("Linha: "+t.getLine() +" erro sintatico proximo a "+t.getText());
        
        //caso o tipo de token esteja presente no vocabulario 
        if (tokenType != null && tokenType.equals("COMENT_NFECHADO")) {//se o token for do tipo COMENT_NFECHADO
            output = "Linha " + t.getLine() + ": comentario nao fechado";//atribui a string de saida
        }
        else if (tokenType != null && tokenType.equals("CADEIA_NFIM")) {//se o token for do tipo CADEIA_NFIM
            output = "Linha " + t.getLine() + ": cadeia literal nao fechada";//atribui a string de saida
        }
        else if (tokenType != null && tokenType.equals("ERROR_CHAR")) {//se o token for do tipo ERROR_CHAR
            output = "Linha " + t.getLine() + ": " + t.getText() + " - simbolo nao identificado";//atribui a string de saida
        }
        else if (t.getType() == Token.EOF) {//caso o token seja de fim de arquivo
            output = "Linha " + t.getLine() + ": erro sintatico proximo a EOF";//atribui a string de saida
        }
        else {//caso seja um erro sintatico
            output = "Linha " + t.getLine() + ": erro sintatico proximo a " + t.getText();//atribui a string de saida
        }
        pw.println(output);//armazena a string de saida no arquivo desejado
        pw.println("Fim da compilacao");//informa o fim da compilação e armazena a saida no arquivo desejado
        throw new ParseCancellationException(output);// informa o erro para finalizar a execução
        
        
    }
}
