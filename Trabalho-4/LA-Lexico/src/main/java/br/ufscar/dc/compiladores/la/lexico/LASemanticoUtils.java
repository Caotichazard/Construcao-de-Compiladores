package br.ufscar.dc.compiladores.la.lexico;

import br.ufscar.dc.compiladores.la.lexico.TabelaDeSimbolos.TipoLA;
import br.ufscar.dc.compiladores.la.lexico.TabelaDeSimbolos;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Pair;
import br.ufscar.dc.compiladores.la.lexico.LASemantico;
import br.ufscar.dc.compiladores.la.lexico.TabelaDeSimbolos.EntradaTabelaDeSimbolos;
import br.ufscar.dc.compiladores.la.lexico.TabelaDeSimbolos.Variavel;
import org.antlr.v4.runtime.tree.TerminalNode;

public class LASemanticoUtils {

    public static List<String> erros = new ArrayList<>();

    public static void adicionaErro(String msg) {
        erros.add(msg);
    }
    
    
}
