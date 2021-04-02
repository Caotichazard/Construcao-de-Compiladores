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
		T__9=10, IDENT=11, DATA=12, NUM_INT=13, NUM_REAL=14, CADEIA=15, CADEIA_NFIM=16, 
		COMENTARIO=17, COMENT_NFECHADO=18, WS=19, ERROR_CHAR=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "IDENT", "DATA", "NUM_INT", "NUM_REAL", "CADEIA", "CADEIA_NFIM", 
			"ESC_SEQ", "COMENTARIO", "COMENT_NFECHADO", "WS", "ERROR_CHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'defina'", "':'", "'fim_defina'", "'declare'", "'fim_declare'", 
			"','", "'{'", "'}'", "'CADEIA'", "'NUMERO'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "IDENT", 
			"DATA", "NUM_INT", "NUM_REAL", "CADEIA", "CADEIA_NFIM", "COMENTARIO", 
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
		case 17:
			COMENTARIO_action((RuleContext)_localctx, actionIndex);
			break;
		case 19:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u00c3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\7\fl\n\f\f\f\16\fo\13\f\3\r\5\rr\n\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\6\rz\n\r\r\r\16\r{\3\16\6\16\177\n\16\r\16\16\16\u0080\3"+
		"\17\6\17\u0084\n\17\r\17\16\17\u0085\3\17\3\17\6\17\u008a\n\17\r\17\16"+
		"\17\u008b\5\17\u008e\n\17\3\20\3\20\3\20\6\20\u0093\n\20\r\20\16\20\u0094"+
		"\3\20\3\20\3\21\3\21\7\21\u009b\n\21\f\21\16\21\u009e\13\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\7\23\u00a9\n\23\f\23\16\23\u00ac\13"+
		"\23\3\23\3\23\5\23\u00b0\n\23\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u00b8"+
		"\n\24\f\24\16\24\u00bb\13\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\u0094"+
		"\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\2%\23\'\24)\25+\26\3\2\n\4\2C\\c|\6\2\62;C\\aac|\6\2\f"+
		"\f\17\17))^^\3\2$$\4\2\f\f\17\17\5\2\f\f\17\17\177\177\3\2\177\177\5\2"+
		"\13\f\17\17\"\"\2\u00ce\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2"+
		"\2\5\64\3\2\2\2\7\66\3\2\2\2\tA\3\2\2\2\13I\3\2\2\2\rU\3\2\2\2\17W\3\2"+
		"\2\2\21Y\3\2\2\2\23[\3\2\2\2\25b\3\2\2\2\27i\3\2\2\2\31q\3\2\2\2\33~\3"+
		"\2\2\2\35\u0083\3\2\2\2\37\u008f\3\2\2\2!\u0098\3\2\2\2#\u00a1\3\2\2\2"+
		"%\u00a4\3\2\2\2\'\u00b3\3\2\2\2)\u00be\3\2\2\2+\u00c1\3\2\2\2-.\7f\2\2"+
		"./\7g\2\2/\60\7h\2\2\60\61\7k\2\2\61\62\7p\2\2\62\63\7c\2\2\63\4\3\2\2"+
		"\2\64\65\7<\2\2\65\6\3\2\2\2\66\67\7h\2\2\678\7k\2\289\7o\2\29:\7a\2\2"+
		":;\7f\2\2;<\7g\2\2<=\7h\2\2=>\7k\2\2>?\7p\2\2?@\7c\2\2@\b\3\2\2\2AB\7"+
		"f\2\2BC\7g\2\2CD\7e\2\2DE\7n\2\2EF\7c\2\2FG\7t\2\2GH\7g\2\2H\n\3\2\2\2"+
		"IJ\7h\2\2JK\7k\2\2KL\7o\2\2LM\7a\2\2MN\7f\2\2NO\7g\2\2OP\7e\2\2PQ\7n\2"+
		"\2QR\7c\2\2RS\7t\2\2ST\7g\2\2T\f\3\2\2\2UV\7.\2\2V\16\3\2\2\2WX\7}\2\2"+
		"X\20\3\2\2\2YZ\7\177\2\2Z\22\3\2\2\2[\\\7E\2\2\\]\7C\2\2]^\7F\2\2^_\7"+
		"G\2\2_`\7K\2\2`a\7C\2\2a\24\3\2\2\2bc\7P\2\2cd\7W\2\2de\7O\2\2ef\7G\2"+
		"\2fg\7T\2\2gh\7Q\2\2h\26\3\2\2\2im\t\2\2\2jl\t\3\2\2kj\3\2\2\2lo\3\2\2"+
		"\2mk\3\2\2\2mn\3\2\2\2n\30\3\2\2\2om\3\2\2\2pr\4\62;\2qp\3\2\2\2qr\3\2"+
		"\2\2rs\3\2\2\2st\4\62;\2tu\7\61\2\2uv\4\62\63\2vw\4\62;\2wy\7\61\2\2x"+
		"z\4\62;\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\32\3\2\2\2}\177\4\62"+
		";\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\34\3\2\2\2\u0082\u0084\4\62;\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2"+
		"\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u008d\3\2\2\2\u0087\u0089"+
		"\7\60\2\2\u0088\u008a\4\62;\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2"+
		"\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u0087"+
		"\3\2\2\2\u008d\u008e\3\2\2\2\u008e\36\3\2\2\2\u008f\u0092\7$\2\2\u0090"+
		"\u0093\5#\22\2\u0091\u0093\n\4\2\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2"+
		"\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0097\7$\2\2\u0097 \3\2\2\2\u0098\u009c\7$\2\2\u0099"+
		"\u009b\n\5\2\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00a0\t\6\2\2\u00a0\"\3\2\2\2\u00a1\u00a2\7^\2\2\u00a2\u00a3\7)\2\2\u00a3"+
		"$\3\2\2\2\u00a4\u00a5\7\61\2\2\u00a5\u00a6\7,\2\2\u00a6\u00aa\3\2\2\2"+
		"\u00a7\u00a9\n\7\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8"+
		"\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00af\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad"+
		"\u00ae\7,\2\2\u00ae\u00b0\7\61\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\b\23\2\2\u00b2&\3\2\2\2\u00b3\u00b4"+
		"\7\61\2\2\u00b4\u00b5\7,\2\2\u00b5\u00b9\3\2\2\2\u00b6\u00b8\n\b\2\2\u00b7"+
		"\u00b6\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\7\f\2\2\u00bd"+
		"(\3\2\2\2\u00be\u00bf\t\t\2\2\u00bf\u00c0\b\25\3\2\u00c0*\3\2\2\2\u00c1"+
		"\u00c2\13\2\2\2\u00c2,\3\2\2\2\20\2mq{\u0080\u0085\u008b\u008d\u0092\u0094"+
		"\u009c\u00aa\u00af\u00b9\4\3\23\2\3\25\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}