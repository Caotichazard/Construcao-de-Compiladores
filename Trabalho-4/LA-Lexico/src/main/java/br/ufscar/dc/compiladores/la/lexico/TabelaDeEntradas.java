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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TabelaDeEntradas {
    public enum Tipos {
        NUMERO,
        CADEIA,
        DATA,
        REFERENCIA,
        VETOR,
        INVALIDO
        
    }
    
    private final Map<String, ListaDeclaracoes> declaracoes;
    private final Map<String, EntradaDefinicao> definicoes;
    
    public TabelaDeEntradas() {
        this.declaracoes = new HashMap<>();
        this.definicoes = new HashMap<>();
    }
    
    public class ListaDeclaracoes{
        String nome;
        
        List<EntradaDeclaracao> declaracoesList;
        
        
        public String getNome(){
            return this.nome;
        }
        
        public ListaDeclaracoes(String nome){
            this.nome = nome;
            this.declaracoesList = new ArrayList();
        }
    }
    
    public Set<String> getNomeDeclaracoes(){
        return declaracoes.keySet();
    }
    
    public class EntradaDeclaracao{
        
        String nome = null;
        
        List<CampoDeclaracao> campos;
        
        public EntradaDeclaracao(String nome, List<CampoDeclaracao> campos){
            this.nome = nome;
            this.campos = campos;
        }
        
    }
    
    public abstract class CampoDeclaracao{
        String nome;
        Tipos tipo;
        
        public abstract String getValor();
        public abstract List<CampoDeclaracao> getCampos();
        
        
    }
    
    public class CampoSimples extends CampoDeclaracao{
        String valor;
        
        public CampoSimples(String nome, Tipos tipo, String valor){
            this.nome = nome;
            this.tipo = tipo;
            this.valor = valor;
        }
        
        public String getValor(){
            return this.valor;
        }
       public List<CampoDeclaracao> getCampos(){
            return null;
        }
    }
    
    public class CampoVetor extends CampoDeclaracao{
        Tipos subtipo;
        List<CampoDeclaracao> campos;
        
        public CampoVetor(String nome, Tipos tipo, Tipos subtipo, List<CampoDeclaracao> campos){
            for(CampoDeclaracao camp: campos){
                System.out.println(camp.nome + ": " + camp.tipo + ":" + camp.getValor());
            }
            this.nome = nome;
            this.tipo = tipo;
            this.subtipo = subtipo;
            this.campos = campos;
        }
        
        public String getValor(){
            return null;
        }
        
        public List<CampoDeclaracao> getCampos(){
            return this.campos;
        }
    }
    
    public class EntradaDefinicao{
        String nome;
        List<CampoDefinicao> tipos;
        
        public EntradaDefinicao(String nome, List<CampoDefinicao> tipos){
            this.nome = nome;
            this.tipos = tipos;
        }
        public String getNome(){
            return this.nome;
        }
        
        
    }
    
    public class CampoDefinicao{
            String nome;
            TabelaDeEntradas.Tipos tipo;
            
            public CampoDefinicao(String nome, TabelaDeEntradas.Tipos tipo){
                this.nome = nome;
                this.tipo = tipo;
            }
        }
    
    public void adicionaDefinicao(String nome, List<CampoDefinicao> tipos){
        definicoes.put(nome, new EntradaDefinicao(nome, tipos));
    }
    
    public EntradaDefinicao getDefinicao(String name){
        return definicoes.get(name);
    }
    
    public boolean existeDefinicao(String name){
        return definicoes.containsKey(name);
    }
    
    public void adicionaTabelaDeclaracao(String nome){
        declaracoes.put(nome, new ListaDeclaracoes(nome));
    }
    
    public ListaDeclaracoes getListaDeclaracao(String nome){
        return declaracoes.get(nome);
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
