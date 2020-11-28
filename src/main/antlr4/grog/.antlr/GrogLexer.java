// Generated from /home/martinstraus/MEGA/proyectos/propios/grog-lang/src/main/antlr4/grog/Grog.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrogLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TYPE=1, LBRACE=2, RBRACE=3, FUNC=4, COMMA=5, SEMICOLON=6, LPAREN=7, RPAREN=8, 
		DOT=9, GREATER=10, LESS=11, GREATER_OR_EQUAL=12, LESS_OR_EQUAL=13, EQUAL=14, 
		DIFFERENT=15, NOT=16, TIMES=17, DIVIDE=18, PLUS=19, MINUS=20, POWER=21, 
		ASSIGN=22, COLON=23, AND=24, OR=25, BOOLEAN=26, IDENTIFIER=27, NUMBER=28, 
		WS=29, COMMENT=30, LINE_COMMENT=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TYPE", "LBRACE", "RBRACE", "FUNC", "COMMA", "SEMICOLON", "LPAREN", "RPAREN", 
			"DOT", "GREATER", "LESS", "GREATER_OR_EQUAL", "LESS_OR_EQUAL", "EQUAL", 
			"DIFFERENT", "NOT", "TIMES", "DIVIDE", "PLUS", "MINUS", "POWER", "ASSIGN", 
			"COLON", "AND", "OR", "BOOLEAN", "IDENTIFIER", "NUMBER", "VALID_ID_START", 
			"VALID_ID_CHAR", "DIGIT", "WS", "COMMENT", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'type'", "'{'", "'}'", "'func'", "','", "';'", "'('", "')'", "'.'", 
			"'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'!'", "'*'", "'/'", "'+'", 
			"'-'", "'^'", "'<-'", "':'", "'&'", "'|'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TYPE", "LBRACE", "RBRACE", "FUNC", "COMMA", "SEMICOLON", "LPAREN", 
			"RPAREN", "DOT", "GREATER", "LESS", "GREATER_OR_EQUAL", "LESS_OR_EQUAL", 
			"EQUAL", "DIFFERENT", "NOT", "TIMES", "DIVIDE", "PLUS", "MINUS", "POWER", 
			"ASSIGN", "COLON", "AND", "OR", "BOOLEAN", "IDENTIFIER", "NUMBER", "WS", 
			"COMMENT", "LINE_COMMENT"
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


	public GrogLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grog.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00cc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u008e"+
		"\n\33\3\34\3\34\7\34\u0092\n\34\f\34\16\34\u0095\13\34\3\35\6\35\u0098"+
		"\n\35\r\35\16\35\u0099\3\35\3\35\6\35\u009e\n\35\r\35\16\35\u009f\5\35"+
		"\u00a2\n\35\3\36\5\36\u00a5\n\36\3\37\3\37\5\37\u00a9\n\37\3 \3 \3!\6"+
		"!\u00ae\n!\r!\16!\u00af\3!\3!\3\"\3\"\3\"\3\"\7\"\u00b8\n\"\f\"\16\"\u00bb"+
		"\13\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\7#\u00c6\n#\f#\16#\u00c9\13#\3#"+
		"\3#\3\u00b9\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36;\2=\2?\2A\37C E!\3\2\5\5\2C\\aac|\5\2\13\f\17\17\"\"\4\2\f"+
		"\f\17\17\2\u00d1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5L\3\2\2\2\7N"+
		"\3\2\2\2\tP\3\2\2\2\13U\3\2\2\2\rW\3\2\2\2\17Y\3\2\2\2\21[\3\2\2\2\23"+
		"]\3\2\2\2\25_\3\2\2\2\27a\3\2\2\2\31c\3\2\2\2\33f\3\2\2\2\35i\3\2\2\2"+
		"\37l\3\2\2\2!o\3\2\2\2#q\3\2\2\2%s\3\2\2\2\'u\3\2\2\2)w\3\2\2\2+y\3\2"+
		"\2\2-{\3\2\2\2/~\3\2\2\2\61\u0080\3\2\2\2\63\u0082\3\2\2\2\65\u008d\3"+
		"\2\2\2\67\u008f\3\2\2\29\u0097\3\2\2\2;\u00a4\3\2\2\2=\u00a8\3\2\2\2?"+
		"\u00aa\3\2\2\2A\u00ad\3\2\2\2C\u00b3\3\2\2\2E\u00c1\3\2\2\2GH\7v\2\2H"+
		"I\7{\2\2IJ\7r\2\2JK\7g\2\2K\4\3\2\2\2LM\7}\2\2M\6\3\2\2\2NO\7\177\2\2"+
		"O\b\3\2\2\2PQ\7h\2\2QR\7w\2\2RS\7p\2\2ST\7e\2\2T\n\3\2\2\2UV\7.\2\2V\f"+
		"\3\2\2\2WX\7=\2\2X\16\3\2\2\2YZ\7*\2\2Z\20\3\2\2\2[\\\7+\2\2\\\22\3\2"+
		"\2\2]^\7\60\2\2^\24\3\2\2\2_`\7@\2\2`\26\3\2\2\2ab\7>\2\2b\30\3\2\2\2"+
		"cd\7@\2\2de\7?\2\2e\32\3\2\2\2fg\7>\2\2gh\7?\2\2h\34\3\2\2\2ij\7?\2\2"+
		"jk\7?\2\2k\36\3\2\2\2lm\7#\2\2mn\7?\2\2n \3\2\2\2op\7#\2\2p\"\3\2\2\2"+
		"qr\7,\2\2r$\3\2\2\2st\7\61\2\2t&\3\2\2\2uv\7-\2\2v(\3\2\2\2wx\7/\2\2x"+
		"*\3\2\2\2yz\7`\2\2z,\3\2\2\2{|\7>\2\2|}\7/\2\2}.\3\2\2\2~\177\7<\2\2\177"+
		"\60\3\2\2\2\u0080\u0081\7(\2\2\u0081\62\3\2\2\2\u0082\u0083\7~\2\2\u0083"+
		"\64\3\2\2\2\u0084\u0085\7v\2\2\u0085\u0086\7t\2\2\u0086\u0087\7w\2\2\u0087"+
		"\u008e\7g\2\2\u0088\u0089\7h\2\2\u0089\u008a\7c\2\2\u008a\u008b\7n\2\2"+
		"\u008b\u008c\7u\2\2\u008c\u008e\7g\2\2\u008d\u0084\3\2\2\2\u008d\u0088"+
		"\3\2\2\2\u008e\66\3\2\2\2\u008f\u0093\5;\36\2\u0090\u0092\5=\37\2\u0091"+
		"\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u00948\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0098\5? \2\u0097\u0096"+
		"\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u00a1\3\2\2\2\u009b\u009d\7\60\2\2\u009c\u009e\5? \2\u009d\u009c\3\2"+
		"\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a2\3\2\2\2\u00a1\u009b\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2:\3\2\2\2"+
		"\u00a3\u00a5\t\2\2\2\u00a4\u00a3\3\2\2\2\u00a5<\3\2\2\2\u00a6\u00a9\5"+
		";\36\2\u00a7\u00a9\5? \2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9"+
		">\3\2\2\2\u00aa\u00ab\4\62;\2\u00ab@\3\2\2\2\u00ac\u00ae\t\3\2\2\u00ad"+
		"\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\b!\2\2\u00b2B\3\2\2\2\u00b3\u00b4"+
		"\7\61\2\2\u00b4\u00b5\7,\2\2\u00b5\u00b9\3\2\2\2\u00b6\u00b8\13\2\2\2"+
		"\u00b7\u00b6\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00ba\3\2\2\2\u00b9\u00b7"+
		"\3\2\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\7,\2\2\u00bd"+
		"\u00be\7\61\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\b\"\3\2\u00c0D\3\2\2\2"+
		"\u00c1\u00c2\7\61\2\2\u00c2\u00c3\7\61\2\2\u00c3\u00c7\3\2\2\2\u00c4\u00c6"+
		"\n\4\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\b#"+
		"\3\2\u00cbF\3\2\2\2\r\2\u008d\u0093\u0099\u009f\u00a1\u00a4\u00a8\u00af"+
		"\u00b9\u00c7\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}