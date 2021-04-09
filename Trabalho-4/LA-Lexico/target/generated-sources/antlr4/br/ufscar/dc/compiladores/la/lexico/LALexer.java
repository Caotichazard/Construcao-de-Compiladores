// Generated from br/ufscar/dc/compiladores/la/lexico/LA.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.la.lexico;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LALexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, IDENT=15, DATA=16, NUM=17, 
		CADEIA=18, CADEIA_NFIM=19, COMENTARIO=20, COMENT_NFECHADO=21, WS=22, ERROR_CHAR=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "IDENT", "DATA", "NUM", "CADEIA", 
			"CADEIA_NFIM", "ESC_SEQ", "COMENTARIO", "COMENT_NFECHADO", "WS", "ERROR_CHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'declare'", "':'", "','", "'fim_declare'", "'defina'", "'fim_defina'", 
			"'{'", "'}'", "'['", "']'", "'CADEIA'", "'NUMERO'", "'DATA'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "IDENT", "DATA", "NUM", "CADEIA", "CADEIA_NFIM", "COMENTARIO", 
			"COMENT_NFECHADO", "WS", "ERROR_CHAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LALexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LA.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 20:
			COMENTARIO_action((RuleContext)_localctx, actionIndex);
			break;
		case 22:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void COMENTARIO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u00d3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\20\7\20|\n\20\f\20\16\20\177\13\20\3\20\5\20\u0082"+
		"\n\20\3\21\5\21\u0085\n\21\3\21\3\21\3\21\5\21\u008a\n\21\3\21\3\21\3"+
		"\21\6\21\u008f\n\21\r\21\16\21\u0090\3\22\6\22\u0094\n\22\r\22\16\22\u0095"+
		"\3\22\3\22\6\22\u009a\n\22\r\22\16\22\u009b\5\22\u009e\n\22\3\23\3\23"+
		"\3\23\6\23\u00a3\n\23\r\23\16\23\u00a4\3\23\3\23\3\24\3\24\7\24\u00ab"+
		"\n\24\f\24\16\24\u00ae\13\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\7\26\u00b9\n\26\f\26\16\26\u00bc\13\26\3\26\3\26\5\26\u00c0\n\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\7\27\u00c8\n\27\f\27\16\27\u00cb\13\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\31\3\31\3\u00a4\2\32\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\2+\26-\27/\30\61\31\3\2\t\6\2\62;C\\aac|\6\2\f\f\17\17))^^\3\2$$\4\2"+
		"\f\f\17\17\5\2\f\f\17\17\177\177\3\2\177\177\5\2\13\f\17\17\"\"\2\u00df"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\3\63\3\2\2\2\5;\3\2\2\2\7=\3\2\2\2\t?\3\2\2\2\13K\3\2\2\2\rR\3\2"+
		"\2\2\17]\3\2\2\2\21_\3\2\2\2\23a\3\2\2\2\25c\3\2\2\2\27e\3\2\2\2\31l\3"+
		"\2\2\2\33s\3\2\2\2\35x\3\2\2\2\37\u0081\3\2\2\2!\u0084\3\2\2\2#\u0093"+
		"\3\2\2\2%\u009f\3\2\2\2\'\u00a8\3\2\2\2)\u00b1\3\2\2\2+\u00b4\3\2\2\2"+
		"-\u00c3\3\2\2\2/\u00ce\3\2\2\2\61\u00d1\3\2\2\2\63\64\7f\2\2\64\65\7g"+
		"\2\2\65\66\7e\2\2\66\67\7n\2\2\678\7c\2\289\7t\2\29:\7g\2\2:\4\3\2\2\2"+
		";<\7<\2\2<\6\3\2\2\2=>\7.\2\2>\b\3\2\2\2?@\7h\2\2@A\7k\2\2AB\7o\2\2BC"+
		"\7a\2\2CD\7f\2\2DE\7g\2\2EF\7e\2\2FG\7n\2\2GH\7c\2\2HI\7t\2\2IJ\7g\2\2"+
		"J\n\3\2\2\2KL\7f\2\2LM\7g\2\2MN\7h\2\2NO\7k\2\2OP\7p\2\2PQ\7c\2\2Q\f\3"+
		"\2\2\2RS\7h\2\2ST\7k\2\2TU\7o\2\2UV\7a\2\2VW\7f\2\2WX\7g\2\2XY\7h\2\2"+
		"YZ\7k\2\2Z[\7p\2\2[\\\7c\2\2\\\16\3\2\2\2]^\7}\2\2^\20\3\2\2\2_`\7\177"+
		"\2\2`\22\3\2\2\2ab\7]\2\2b\24\3\2\2\2cd\7_\2\2d\26\3\2\2\2ef\7E\2\2fg"+
		"\7C\2\2gh\7F\2\2hi\7G\2\2ij\7K\2\2jk\7C\2\2k\30\3\2\2\2lm\7P\2\2mn\7W"+
		"\2\2no\7O\2\2op\7G\2\2pq\7T\2\2qr\7Q\2\2r\32\3\2\2\2st\7F\2\2tu\7C\2\2"+
		"uv\7V\2\2vw\7C\2\2w\34\3\2\2\2xy\7\60\2\2y\36\3\2\2\2z|\t\2\2\2{z\3\2"+
		"\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0082\3\2\2\2\177}\3\2\2\2\u0080"+
		"\u0082\7a\2\2\u0081}\3\2\2\2\u0081\u0080\3\2\2\2\u0082 \3\2\2\2\u0083"+
		"\u0085\4\62;\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086\u0087\4\62;\2\u0087\u0089\7\61\2\2\u0088\u008a\4\62;\2\u0089"+
		"\u0088\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\4\62"+
		";\2\u008c\u008e\7\61\2\2\u008d\u008f\4\62;\2\u008e\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\"\3\2\2\2"+
		"\u0092\u0094\4\62;\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093"+
		"\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u009d\3\2\2\2\u0097\u0099\7\60\2\2"+
		"\u0098\u009a\4\62;\2\u0099\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099"+
		"\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2\2\2\u009d\u0097\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e$\3\2\2\2\u009f\u00a2\7$\2\2\u00a0\u00a3\5)\25\2\u00a1"+
		"\u00a3\n\3\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2"+
		"\2\2\u00a4\u00a5\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00a7\7$\2\2\u00a7&\3\2\2\2\u00a8\u00ac\7$\2\2\u00a9\u00ab\n\4\2\2\u00aa"+
		"\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\t\5\2\2\u00b0"+
		"(\3\2\2\2\u00b1\u00b2\7^\2\2\u00b2\u00b3\7)\2\2\u00b3*\3\2\2\2\u00b4\u00b5"+
		"\7\61\2\2\u00b5\u00b6\7,\2\2\u00b6\u00ba\3\2\2\2\u00b7\u00b9\n\6\2\2\u00b8"+
		"\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2"+
		"\2\2\u00bb\u00bf\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\7,\2\2\u00be"+
		"\u00c0\7\61\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3"+
		"\2\2\2\u00c1\u00c2\b\26\2\2\u00c2,\3\2\2\2\u00c3\u00c4\7\61\2\2\u00c4"+
		"\u00c5\7,\2\2\u00c5\u00c9\3\2\2\2\u00c6\u00c8\n\7\2\2\u00c7\u00c6\3\2"+
		"\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7\f\2\2\u00cd.\3\2\2\2"+
		"\u00ce\u00cf\t\b\2\2\u00cf\u00d0\b\30\3\2\u00d0\60\3\2\2\2\u00d1\u00d2"+
		"\13\2\2\2\u00d2\62\3\2\2\2\21\2}\u0081\u0084\u0089\u0090\u0095\u009b\u009d"+
		"\u00a2\u00a4\u00ac\u00ba\u00bf\u00c9\4\3\26\2\3\30\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}