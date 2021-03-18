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
        CUSTOMIZADO,
        INVALIDO
    }
    
    
    public abstract class EntradaTabelaDeSimbolos{
        String nome;
        
        abstract public TipoLA getTipo();
        abstract public List<EntradaTabelaDeSimbolos> getCampos();
    }
    
    class Variavel extends EntradaTabelaDeSimbolos{
        
        TipoLA tipo;

        public Variavel(String nome, TipoLA tipo) {
            super.nome = nome;
            this.tipo = tipo;
        }
        
        public TipoLA getTipo(){
            return this.tipo;
        }
        
        public List<EntradaTabelaDeSimbolos> getCampos(){
            return null;
        };
        
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
        
        public List<EntradaTabelaDeSimbolos> getCampos(){
            return null;
        };
        
        
    }
    
    class Registro extends EntradaTabelaDeSimbolos{
        
        List<EntradaTabelaDeSimbolos> campos;
        
        public Registro(String nome, List<EntradaTabelaDeSimbolos> campos){
            super.nome = nome;
            this.campos = campos;
        }
        
        public TipoLA getTipo(){
            return TipoLA.REGISTRO;
        }
        
        public List<EntradaTabelaDeSimbolos> getCampos(){
            return this.campos;
        }
    }
    
    private final Map<String, EntradaTabelaDeSimbolos> tabela;
    
    
    public TabelaDeSimbolos() {
        this.tabela = new HashMap<>();
        this.tiposNovos = new HashMap<>();
    }
    
    private final Map<String, EntradaTabelaDeSimbolos> tiposNovos;
    
    
    
    public void adicionar(String nome, TipoLA tipo) {
        System.out.println("Adicionando variavel");
        tabela.put(nome, new Variavel(nome, tipo));
    }
    
    public void adicionar(String nome, TipoLA tipo, TipoLA var){
        System.out.println("Adicionando ponteiro");
        tabela.put(nome, new Ponteiro(nome,tipo,var));
    }
    public void adicionar(String nome, List<EntradaTabelaDeSimbolos> campos){
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
    
    public EntradaTabelaDeSimbolos getEntrada(String nome){
        return tabela.get(nome);
    }
    
    public void adicionaTipo(String nome, TipoLA tipo){
        System.out.println("Adicionando variavel ao tipo");
        tiposNovos.put(nome, new Variavel(nome, tipo));
          
    }
    public void adicionaTipo(String nome, TipoLA tipo, TipoLA var){
        System.out.println("Adicionando ponteiro ao tipo");
        tiposNovos.put(nome, new Ponteiro(nome,tipo,var));
    }
    
    public void adicionaTipo(String nome, List<EntradaTabelaDeSimbolos> campos){
        System.out.println("Adicionando registro ao tipo");
        tiposNovos.put(nome, new Registro(nome,campos));
    }
    
    public EntradaTabelaDeSimbolos getTipoCustomizado(String nome){
        return tiposNovos.get(nome);
    }
    
    public boolean existeTipo(String nome) {
        return tiposNovos.containsKey(nome);
    }
}