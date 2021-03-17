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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabelaDeSimbolos {
    public enum TipoLA {
        INTEIRO,
        REAL,
        CADEIA,
        LOGICO,
        REGISTRO,
        PONTEIRO,
        INVALIDO
    }
    
    abstract class EntradaTabelaDeSimbolos{
        String nome;
        
        abstract public TipoLA getTipo();
    }
    
    class Variavel extends EntradaTabelaDeSimbolos{
        
        TipoLA tipo;

        private Variavel(String nome, TipoLA tipo) {
            super.nome = nome;
            this.tipo = tipo;
        }
        
        public TipoLA getTipo(){
            return this.tipo;
        }
        
    }
    
    class Ponteiro extends EntradaTabelaDeSimbolos{
        
        TipoLA tipo;
        TipoLA variavel;
        private Ponteiro(String nome,TipoLA pontas, TipoLA variavel) {
            super.nome = nome;
            this.tipo = pontas;
            this.variavel = variavel;
        }
        
        public TipoLA getTipo(){
            return this.variavel;
        }
        
        public TipoLA getTipoVar(){
            return this.tipo;
        }
        
        
    }
    
    class Registro extends EntradaTabelaDeSimbolos{
        
        List<Variavel> campos;
        
        private Registro(String nome, List<Variavel> campos){
            super.nome = nome;
            this.campos = campos;
        }
        
        public TipoLA getTipo(){
            return TipoLA.REGISTRO;
        }
    }
    
    private final Map<String, EntradaTabelaDeSimbolos> tabela;
    
    public TabelaDeSimbolos() {
        this.tabela = new HashMap<>();
    }
    
    public void adicionar(String nome, TipoLA tipo) {
        System.out.println("Adicionando variavel");
        tabela.put(nome, new Variavel(nome, tipo));
    }
    
    public void adicionar(String nome, TipoLA tipo, TipoLA var){
        System.out.println("Adicionando ponteiro");
        tabela.put(nome, new Ponteiro(nome,tipo,var));
    }
    public void adicionar(String nome, List<Variavel> campos){
        System.out.println("Adicionando registro");
        tabela.put(nome, new Registro(nome,campos));
    }
    
    public boolean existe(String nome) {
        return tabela.containsKey(nome);
    }
    
    public TipoLA verificar(String nome) {
        System.out.println("Buscando elemento com nome = " + nome);
        System.out.println("Tipo do elemento = " + tabela.get(nome).getTipo());
        return tabela.get(nome).getTipo();
    }
}