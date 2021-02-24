// Generated from /home/salomao/Documentos/BCC/Compiladores/Construcao-de-Compiladores/Trabalho-1/LA-Lexico/src/main/antlr4/br/ufscar/dc/compiladores/la/lexico/LALexer.g4 by ANTLR 4.8
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
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PALAVRAS_CHAVE=1, INTEIRO=2, LITERAL=3, REAL=4, LOGICO=5, SIMBOLOS=6, 
		OPERADORES=7, OPLOGICOS=8, IDENT=9, NUM_INT=10, NUM_REAL=11, CADEIA=12, 
		CADEIA_NFIM=13, COMENTARIO=14, COMENT_NFECHADO=15, WS=16, ERROR_CHAR=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PALAVRAS_CHAVE", "INTEIRO", "LITERAL", "REAL", "LOGICO", "SIMBOLOS", 
			"OPERADORES", "OPLOGICOS", "IDENT", "NUM_INT", "NUM_REAL", "CADEIA", 
			"CADEIA_NFIM", "ESC_SEQ", "COMENTARIO", "COMENT_NFECHADO", "WS", "ERROR_CHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'inteiro'", "'literal'", "'real'", "'logico'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PALAVRAS_CHAVE", "INTEIRO", "LITERAL", "REAL", "LOGICO", "SIMBOLOS", 
			"OPERADORES", "OPLOGICOS", "IDENT", "NUM_INT", "NUM_REAL", "CADEIA", 
			"CADEIA_NFIM", "COMENTARIO", "COMENT_NFECHADO", "WS", "ERROR_CHAR"
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
	public String getGrammarFileName() { return "LALexer.g4"; }

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
		case 14:
			COMENTARIO_action((RuleContext)_localctx, actionIndex);
			break;
		case 16:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u017b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\u00ce\n\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\5\b\u00f6\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0134\n\t\3\n\3"+
		"\n\7\n\u0138\n\n\f\n\16\n\u013b\13\n\3\13\6\13\u013e\n\13\r\13\16\13\u013f"+
		"\3\f\6\f\u0143\n\f\r\f\16\f\u0144\3\f\3\f\6\f\u0149\n\f\r\f\16\f\u014a"+
		"\5\f\u014d\n\f\3\r\3\r\3\r\6\r\u0152\n\r\r\r\16\r\u0153\3\r\3\r\3\16\3"+
		"\16\7\16\u015a\n\16\f\16\16\16\u015d\13\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\20\3\20\7\20\u0166\n\20\f\20\16\20\u0169\13\20\3\20\5\20\u016c\n\20\3"+
		"\20\3\20\3\21\3\21\7\21\u0172\n\21\f\21\16\21\u0175\13\21\3\22\3\22\3"+
		"\22\3\23\3\23\3\u0153\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\2\37\20!\21#\22%\23\3\2\r\b\2*+..\60\60<<]]__\5"+
		"\2,-//\61\61\4\2\'(``\4\2C\\c|\6\2\62;C\\aac|\6\2\f\f\17\17))^^\3\2$$"+
		"\4\2\f\f\17\17\5\2\f\f\17\17\177\177\3\2\177\177\5\2\13\f\17\17\"\"\2"+
		"\u01aa\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\3\u00cd\3\2\2\2\5\u00cf\3\2\2\2\7\u00d7\3\2\2\2\t\u00df\3\2"+
		"\2\2\13\u00e4\3\2\2\2\r\u00eb\3\2\2\2\17\u00f5\3\2\2\2\21\u0133\3\2\2"+
		"\2\23\u0135\3\2\2\2\25\u013d\3\2\2\2\27\u0142\3\2\2\2\31\u014e\3\2\2\2"+
		"\33\u0157\3\2\2\2\35\u0160\3\2\2\2\37\u0163\3\2\2\2!\u016f\3\2\2\2#\u0176"+
		"\3\2\2\2%\u0179\3\2\2\2\'(\7g\2\2()\7u\2\2)*\7e\2\2*+\7t\2\2+,\7g\2\2"+
		",-\7x\2\2-\u00ce\7c\2\2./\7n\2\2/\60\7g\2\2\60\61\7k\2\2\61\u00ce\7c\2"+
		"\2\62\63\7h\2\2\63\64\7k\2\2\64\65\7o\2\2\65\66\7a\2\2\66\67\7c\2\2\67"+
		"8\7n\2\289\7i\2\29:\7q\2\2:;\7t\2\2;<\7k\2\2<=\7v\2\2=>\7o\2\2>\u00ce"+
		"\7q\2\2?@\7c\2\2@A\7n\2\2AB\7i\2\2BC\7q\2\2CD\7t\2\2DE\7k\2\2EF\7v\2\2"+
		"FG\7o\2\2G\u00ce\7q\2\2HI\7f\2\2IJ\7g\2\2JK\7e\2\2KL\7n\2\2LM\7c\2\2M"+
		"N\7t\2\2N\u00ce\7g\2\2OP\7r\2\2PQ\7c\2\2QR\7t\2\2R\u00ce\7c\2\2ST\7c\2"+
		"\2TU\7v\2\2U\u00ce\7g\2\2VW\7h\2\2WX\7c\2\2XY\7e\2\2Y\u00ce\7c\2\2Z[\7"+
		"h\2\2[\\\7k\2\2\\]\7o\2\2]^\7a\2\2^_\7r\2\2_`\7c\2\2`a\7t\2\2a\u00ce\7"+
		"c\2\2bc\7g\2\2cd\7p\2\2de\7s\2\2ef\7w\2\2fg\7c\2\2gh\7p\2\2hi\7v\2\2i"+
		"\u00ce\7q\2\2jk\7h\2\2kl\7k\2\2lm\7o\2\2mn\7a\2\2no\7g\2\2op\7p\2\2pq"+
		"\7s\2\2qr\7w\2\2rs\7c\2\2st\7p\2\2tu\7v\2\2u\u00ce\7q\2\2vw\7t\2\2wx\7"+
		"g\2\2xy\7i\2\2yz\7k\2\2z{\7u\2\2{|\7v\2\2|}\7t\2\2}\u00ce\7q\2\2~\177"+
		"\7h\2\2\177\u0080\7k\2\2\u0080\u0081\7o\2\2\u0081\u0082\7a\2\2\u0082\u0083"+
		"\7t\2\2\u0083\u0084\7g\2\2\u0084\u0085\7i\2\2\u0085\u0086\7k\2\2\u0086"+
		"\u0087\7u\2\2\u0087\u0088\7v\2\2\u0088\u0089\7t\2\2\u0089\u00ce\7q\2\2"+
		"\u008a\u008b\7r\2\2\u008b\u008c\7t\2\2\u008c\u008d\7q\2\2\u008d\u008e"+
		"\7e\2\2\u008e\u008f\7g\2\2\u008f\u0090\7f\2\2\u0090\u0091\7k\2\2\u0091"+
		"\u0092\7o\2\2\u0092\u0093\7g\2\2\u0093\u0094\7p\2\2\u0094\u0095\7v\2\2"+
		"\u0095\u00ce\7q\2\2\u0096\u0097\7x\2\2\u0097\u0098\7c\2\2\u0098\u00ce"+
		"\7t\2\2\u0099\u009a\7h\2\2\u009a\u009b\7k\2\2\u009b\u009c\7o\2\2\u009c"+
		"\u009d\7a\2\2\u009d\u009e\7r\2\2\u009e\u009f\7t\2\2\u009f\u00a0\7q\2\2"+
		"\u00a0\u00a1\7e\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7f\2\2\u00a3\u00a4"+
		"\7k\2\2\u00a4\u00a5\7o\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7p\2\2\u00a7"+
		"\u00a8\7v\2\2\u00a8\u00ce\7q\2\2\u00a9\u00aa\7h\2\2\u00aa\u00ab\7w\2\2"+
		"\u00ab\u00ac\7p\2\2\u00ac\u00ad\7e\2\2\u00ad\u00ae\7c\2\2\u00ae\u00ce"+
		"\7q\2\2\u00af\u00b0\7h\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7o\2\2\u00b2"+
		"\u00b3\7a\2\2\u00b3\u00b4\7h\2\2\u00b4\u00b5\7w\2\2\u00b5\u00b6\7p\2\2"+
		"\u00b6\u00b7\7e\2\2\u00b7\u00b8\7c\2\2\u00b8\u00ce\7q\2\2\u00b9\u00ba"+
		"\7v\2\2\u00ba\u00bb\7k\2\2\u00bb\u00bc\7r\2\2\u00bc\u00ce\7q\2\2\u00bd"+
		"\u00be\7t\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1\7q\2\2"+
		"\u00c1\u00c2\7t\2\2\u00c2\u00c3\7p\2\2\u00c3\u00ce\7g\2\2\u00c4\u00c5"+
		"\7e\2\2\u00c5\u00c6\7q\2\2\u00c6\u00c7\7p\2\2\u00c7\u00c8\7u\2\2\u00c8"+
		"\u00c9\7v\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cb\7p\2\2\u00cb\u00cc\7v\2\2"+
		"\u00cc\u00ce\7g\2\2\u00cd\'\3\2\2\2\u00cd.\3\2\2\2\u00cd\62\3\2\2\2\u00cd"+
		"?\3\2\2\2\u00cdH\3\2\2\2\u00cdO\3\2\2\2\u00cdS\3\2\2\2\u00cdV\3\2\2\2"+
		"\u00cdZ\3\2\2\2\u00cdb\3\2\2\2\u00cdj\3\2\2\2\u00cdv\3\2\2\2\u00cd~\3"+
		"\2\2\2\u00cd\u008a\3\2\2\2\u00cd\u0096\3\2\2\2\u00cd\u0099\3\2\2\2\u00cd"+
		"\u00a9\3\2\2\2\u00cd\u00af\3\2\2\2\u00cd\u00b9\3\2\2\2\u00cd\u00bd\3\2"+
		"\2\2\u00cd\u00c4\3\2\2\2\u00ce\4\3\2\2\2\u00cf\u00d0\7k\2\2\u00d0\u00d1"+
		"\7p\2\2\u00d1\u00d2\7v\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7k\2\2\u00d4"+
		"\u00d5\7t\2\2\u00d5\u00d6\7q\2\2\u00d6\6\3\2\2\2\u00d7\u00d8\7n\2\2\u00d8"+
		"\u00d9\7k\2\2\u00d9\u00da\7v\2\2\u00da\u00db\7g\2\2\u00db\u00dc\7t\2\2"+
		"\u00dc\u00dd\7c\2\2\u00dd\u00de\7n\2\2\u00de\b\3\2\2\2\u00df\u00e0\7t"+
		"\2\2\u00e0\u00e1\7g\2\2\u00e1\u00e2\7c\2\2\u00e2\u00e3\7n\2\2\u00e3\n"+
		"\3\2\2\2\u00e4\u00e5\7n\2\2\u00e5\u00e6\7q\2\2\u00e6\u00e7\7i\2\2\u00e7"+
		"\u00e8\7k\2\2\u00e8\u00e9\7e\2\2\u00e9\u00ea\7q\2\2\u00ea\f\3\2\2\2\u00eb"+
		"\u00ec\t\2\2\2\u00ec\16\3\2\2\2\u00ed\u00f6\t\3\2\2\u00ee\u00ef\7>\2\2"+
		"\u00ef\u00f6\7/\2\2\u00f0\u00f1\7\60\2\2\u00f1\u00f6\7\60\2\2\u00f2\u00f3"+
		"\7>\2\2\u00f3\u00f6\7@\2\2\u00f4\u00f6\t\4\2\2\u00f5\u00ed\3\2\2\2\u00f5"+
		"\u00ee\3\2\2\2\u00f5\u00f0\3\2\2\2\u00f5\u00f2\3\2\2\2\u00f5\u00f4\3\2"+
		"\2\2\u00f6\20\3\2\2\2\u00f7\u0134\7g\2\2\u00f8\u00f9\7q\2\2\u00f9\u0134"+
		"\7w\2\2\u00fa\u00fb\7p\2\2\u00fb\u00fc\7c\2\2\u00fc\u0134\7q\2\2\u00fd"+
		"\u0134\4>@\2\u00fe\u00ff\7>\2\2\u00ff\u0134\7?\2\2\u0100\u0101\7@\2\2"+
		"\u0101\u0134\7?\2\2\u0102\u0103\7u\2\2\u0103\u0134\7g\2\2\u0104\u0105"+
		"\7u\2\2\u0105\u0106\7g\2\2\u0106\u0107\7p\2\2\u0107\u0108\7c\2\2\u0108"+
		"\u0134\7q\2\2\u0109\u010a\7h\2\2\u010a\u010b\7k\2\2\u010b\u010c\7o\2\2"+
		"\u010c\u010d\7a\2\2\u010d\u010e\7u\2\2\u010e\u0134\7g\2\2\u010f\u0110"+
		"\7g\2\2\u0110\u0111\7p\2\2\u0111\u0112\7v\2\2\u0112\u0113\7c\2\2\u0113"+
		"\u0134\7q\2\2\u0114\u0115\7e\2\2\u0115\u0116\7c\2\2\u0116\u0117\7u\2\2"+
		"\u0117\u0134\7q\2\2\u0118\u0119\7u\2\2\u0119\u011a\7g\2\2\u011a\u011b"+
		"\7l\2\2\u011b\u0134\7c\2\2\u011c\u011d\7h\2\2\u011d\u011e\7k\2\2\u011e"+
		"\u011f\7o\2\2\u011f\u0120\7a\2\2\u0120\u0121\7e\2\2\u0121\u0122\7c\2\2"+
		"\u0122\u0123\7u\2\2\u0123\u0134\7q\2\2\u0124\u0125\7h\2\2\u0125\u0126"+
		"\7c\2\2\u0126\u0127\7n\2\2\u0127\u0128\7u\2\2\u0128\u0134\7q\2\2\u0129"+
		"\u012a\7x\2\2\u012a\u012b\7g\2\2\u012b\u012c\7t\2\2\u012c\u012d\7f\2\2"+
		"\u012d\u012e\7c\2\2\u012e\u012f\7f\2\2\u012f\u0130\7g\2\2\u0130\u0131"+
		"\7k\2\2\u0131\u0132\7t\2\2\u0132\u0134\7q\2\2\u0133\u00f7\3\2\2\2\u0133"+
		"\u00f8\3\2\2\2\u0133\u00fa\3\2\2\2\u0133\u00fd\3\2\2\2\u0133\u00fe\3\2"+
		"\2\2\u0133\u0100\3\2\2\2\u0133\u0102\3\2\2\2\u0133\u0104\3\2\2\2\u0133"+
		"\u0109\3\2\2\2\u0133\u010f\3\2\2\2\u0133\u0114\3\2\2\2\u0133\u0118\3\2"+
		"\2\2\u0133\u011c\3\2\2\2\u0133\u0124\3\2\2\2\u0133\u0129\3\2\2\2\u0134"+
		"\22\3\2\2\2\u0135\u0139\t\5\2\2\u0136\u0138\t\6\2\2\u0137\u0136\3\2\2"+
		"\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\24"+
		"\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u013e\4\62;\2\u013d\u013c\3\2\2\2\u013e"+
		"\u013f\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140\26\3\2\2"+
		"\2\u0141\u0143\4\62;\2\u0142\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0142"+
		"\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u014c\3\2\2\2\u0146\u0148\7\60\2\2"+
		"\u0147\u0149\4\62;\2\u0148\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u0148"+
		"\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014d\3\2\2\2\u014c\u0146\3\2\2\2\u014c"+
		"\u014d\3\2\2\2\u014d\30\3\2\2\2\u014e\u0151\7$\2\2\u014f\u0152\5\35\17"+
		"\2\u0150\u0152\n\7\2\2\u0151\u014f\3\2\2\2\u0151\u0150\3\2\2\2\u0152\u0153"+
		"\3\2\2\2\u0153\u0154\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0155\3\2\2\2\u0155"+
		"\u0156\7$\2\2\u0156\32\3\2\2\2\u0157\u015b\7$\2\2\u0158\u015a\n\b\2\2"+
		"\u0159\u0158\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c"+
		"\3\2\2\2\u015c\u015e\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u015f\t\t\2\2\u015f"+
		"\34\3\2\2\2\u0160\u0161\7^\2\2\u0161\u0162\7)\2\2\u0162\36\3\2\2\2\u0163"+
		"\u0167\7}\2\2\u0164\u0166\n\n\2\2\u0165\u0164\3\2\2\2\u0166\u0169\3\2"+
		"\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u016b\3\2\2\2\u0169"+
		"\u0167\3\2\2\2\u016a\u016c\7\177\2\2\u016b\u016a\3\2\2\2\u016b\u016c\3"+
		"\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e\b\20\2\2\u016e \3\2\2\2\u016f\u0173"+
		"\7}\2\2\u0170\u0172\n\13\2\2\u0171\u0170\3\2\2\2\u0172\u0175\3\2\2\2\u0173"+
		"\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174\"\3\2\2\2\u0175\u0173\3\2\2\2"+
		"\u0176\u0177\t\f\2\2\u0177\u0178\b\22\3\2\u0178$\3\2\2\2\u0179\u017a\13"+
		"\2\2\2\u017a&\3\2\2\2\21\2\u00cd\u00f5\u0133\u0139\u013f\u0144\u014a\u014c"+
		"\u0151\u0153\u015b\u0167\u016b\u0173\4\3\20\2\3\22\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}