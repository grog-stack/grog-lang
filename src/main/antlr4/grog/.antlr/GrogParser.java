// Generated from /home/martinstraus/MEGA/proyectos/propios/grog-lang/src/main/antlr4/grog/Grog.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrogParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_type = 1, RULE_function = 2, RULE_expression = 3, 
		RULE_functionCall = 4, RULE_atom = 5, RULE_lambda = 6, RULE_parameter = 7, 
		RULE_typeDeclaration = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "type", "function", "expression", "functionCall", "atom", 
			"lambda", "parameter", "typeDeclaration"
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

	@Override
	public String getGrammarFileName() { return "Grog.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrogParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE || _la==FUNC) {
				{
				setState(20);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TYPE:
					{
					setState(18);
					type();
					}
					break;
				case FUNC:
					{
					setState(19);
					function();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << NOT) | (1L << BOOLEAN) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0)) {
				{
				setState(25);
				expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Token name;
		public FunctionContext function;
		public List<FunctionContext> functions = new ArrayList<FunctionContext>();
		public TerminalNode TYPE() { return getToken(GrogParser.TYPE, 0); }
		public TerminalNode ASSIGN() { return getToken(GrogParser.ASSIGN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GrogParser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(GrogParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(GrogParser.RBRACE, 0); }
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(TYPE);
			setState(29);
			((TypeContext)_localctx).name = match(IDENTIFIER);
			setState(30);
			match(ASSIGN);
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC:
				{
				setState(31);
				((TypeContext)_localctx).function = function();
				((TypeContext)_localctx).functions.add(((TypeContext)_localctx).function);
				}
				break;
			case LBRACE:
				{
				setState(32);
				match(LBRACE);
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(33);
					((TypeContext)_localctx).function = function();
					((TypeContext)_localctx).functions.add(((TypeContext)_localctx).function);
					}
					}
					setState(36); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==FUNC );
				setState(38);
				match(RBRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public Token name;
		public TerminalNode FUNC() { return getToken(GrogParser.FUNC, 0); }
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(GrogParser.IDENTIFIER, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(FUNC);
			setState(43);
			((FunctionContext)_localctx).name = match(IDENTIFIER);
			setState(44);
			lambda();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PowerExprContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public TerminalNode POWER() { return getToken(GrogParser.POWER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PowerExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class NegativeExprContext extends ExpressionContext {
		public ExpressionContext value;
		public TerminalNode NOT() { return getToken(GrogParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NegativeExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class FunctionCallExprContext extends ExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class PlusExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(GrogParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(GrogParser.MINUS, 0); }
		public PlusExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ComparisonExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(GrogParser.EQUAL, 0); }
		public TerminalNode DIFFERENT() { return getToken(GrogParser.DIFFERENT, 0); }
		public TerminalNode GREATER() { return getToken(GrogParser.GREATER, 0); }
		public TerminalNode LESS() { return getToken(GrogParser.LESS, 0); }
		public TerminalNode GREATER_OR_EQUAL() { return getToken(GrogParser.GREATER_OR_EQUAL, 0); }
		public TerminalNode LESS_OR_EQUAL() { return getToken(GrogParser.LESS_OR_EQUAL, 0); }
		public ComparisonExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class LambdaExprContext extends ExpressionContext {
		public LambdaContext value;
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public LambdaExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class AtomExprContext extends ExpressionContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class TimesExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode TIMES() { return getToken(GrogParser.TIMES, 0); }
		public TerminalNode DIVIDE() { return getToken(GrogParser.DIVIDE, 0); }
		public TimesExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(GrogParser.AND, 0); }
		public TerminalNode OR() { return getToken(GrogParser.OR, 0); }
		public BooleanExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new NegativeExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(47);
				match(NOT);
				setState(48);
				((NegativeExprContext)_localctx).value = expression(4);
				}
				break;
			case 2:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(49);
				functionCall();
				}
				break;
			case 3:
				{
				_localctx = new LambdaExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(50);
				((LambdaExprContext)_localctx).value = lambda();
				}
				break;
			case 4:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51);
				atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(87);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(85);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new PowerExprContext(new ExpressionContext(_parentctx, _parentState));
						((PowerExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(54);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(55);
						match(POWER);
						setState(56);
						((PowerExprContext)_localctx).right = expression(10);
						}
						break;
					case 2:
						{
						_localctx = new TimesExprContext(new ExpressionContext(_parentctx, _parentState));
						((TimesExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(57);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(60);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case TIMES:
							{
							setState(58);
							((TimesExprContext)_localctx).operator = match(TIMES);
							}
							break;
						case DIVIDE:
							{
							setState(59);
							((TimesExprContext)_localctx).operator = match(DIVIDE);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(62);
						((TimesExprContext)_localctx).right = expression(9);
						}
						break;
					case 3:
						{
						_localctx = new PlusExprContext(new ExpressionContext(_parentctx, _parentState));
						((PlusExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(63);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(66);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case PLUS:
							{
							setState(64);
							((PlusExprContext)_localctx).operator = match(PLUS);
							}
							break;
						case MINUS:
							{
							setState(65);
							((PlusExprContext)_localctx).operator = match(MINUS);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(68);
						((PlusExprContext)_localctx).right = expression(8);
						}
						break;
					case 4:
						{
						_localctx = new ComparisonExprContext(new ExpressionContext(_parentctx, _parentState));
						((ComparisonExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(69);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(76);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case GREATER:
							{
							setState(70);
							((ComparisonExprContext)_localctx).operator = match(GREATER);
							}
							break;
						case LESS:
							{
							setState(71);
							((ComparisonExprContext)_localctx).operator = match(LESS);
							}
							break;
						case GREATER_OR_EQUAL:
							{
							setState(72);
							((ComparisonExprContext)_localctx).operator = match(GREATER_OR_EQUAL);
							}
							break;
						case LESS_OR_EQUAL:
							{
							setState(73);
							((ComparisonExprContext)_localctx).operator = match(LESS_OR_EQUAL);
							}
							break;
						case EQUAL:
							{
							setState(74);
							match(EQUAL);
							}
							break;
						case DIFFERENT:
							{
							setState(75);
							match(DIFFERENT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(78);
						((ComparisonExprContext)_localctx).right = expression(7);
						}
						break;
					case 5:
						{
						_localctx = new BooleanExprContext(new ExpressionContext(_parentctx, _parentState));
						((BooleanExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(79);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(82);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case AND:
							{
							setState(80);
							((BooleanExprContext)_localctx).operator = match(AND);
							}
							break;
						case OR:
							{
							setState(81);
							((BooleanExprContext)_localctx).operator = match(OR);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(84);
						((BooleanExprContext)_localctx).right = expression(6);
						}
						break;
					}
					} 
				}
				setState(89);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public Token name;
		public ExpressionContext expression;
		public List<ExpressionContext> parameters = new ArrayList<ExpressionContext>();
		public TerminalNode LPAREN() { return getToken(GrogParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GrogParser.RPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GrogParser.IDENTIFIER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(GrogParser.COMMA, 0); }
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			((FunctionCallContext)_localctx).name = match(IDENTIFIER);
			setState(91);
			match(LPAREN);
			setState(92);
			((FunctionCallContext)_localctx).expression = expression(0);
			((FunctionCallContext)_localctx).parameters.add(((FunctionCallContext)_localctx).expression);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(93);
				match(COMMA);
				setState(94);
				((FunctionCallContext)_localctx).expression = expression(0);
				((FunctionCallContext)_localctx).parameters.add(((FunctionCallContext)_localctx).expression);
				}
			}

			setState(97);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReferenceExprContext extends AtomContext {
		public Token value;
		public TerminalNode IDENTIFIER() { return getToken(GrogParser.IDENTIFIER, 0); }
		public ReferenceExprContext(AtomContext ctx) { copyFrom(ctx); }
	}
	public static class NumberExprContext extends AtomContext {
		public Token value;
		public TerminalNode NUMBER() { return getToken(GrogParser.NUMBER, 0); }
		public NumberExprContext(AtomContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanLiteralExprContext extends AtomContext {
		public Token value;
		public TerminalNode BOOLEAN() { return getToken(GrogParser.BOOLEAN, 0); }
		public BooleanLiteralExprContext(AtomContext ctx) { copyFrom(ctx); }
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atom);
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new ReferenceExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				((ReferenceExprContext)_localctx).value = match(IDENTIFIER);
				}
				break;
			case NUMBER:
				_localctx = new NumberExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				((NumberExprContext)_localctx).value = match(NUMBER);
				}
				break;
			case BOOLEAN:
				_localctx = new BooleanLiteralExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				((BooleanLiteralExprContext)_localctx).value = match(BOOLEAN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaContext extends ParserRuleContext {
		public ParameterContext parameter;
		public List<ParameterContext> parameters = new ArrayList<ParameterContext>();
		public TerminalNode LPAREN() { return getToken(GrogParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GrogParser.RPAREN, 0); }
		public TerminalNode ASSIGN() { return getToken(GrogParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GrogParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GrogParser.COMMA, i);
		}
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_lambda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(LPAREN);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(105);
				((LambdaContext)_localctx).parameter = parameter();
				((LambdaContext)_localctx).parameters.add(((LambdaContext)_localctx).parameter);
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(106);
					match(COMMA);
					setState(107);
					((LambdaContext)_localctx).parameter = parameter();
					((LambdaContext)_localctx).parameters.add(((LambdaContext)_localctx).parameter);
					}
					}
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(115);
			match(RPAREN);
			setState(116);
			match(ASSIGN);
			setState(117);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public Token name;
		public TypeDeclarationContext typeDecl;
		public TerminalNode IDENTIFIER() { return getToken(GrogParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(GrogParser.COLON, 0); }
		public TypeDeclarationContext typeDeclaration() {
			return getRuleContext(TypeDeclarationContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			((ParameterContext)_localctx).name = match(IDENTIFIER);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(120);
				match(COLON);
				setState(121);
				((ParameterContext)_localctx).typeDecl = typeDeclaration();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GrogParser.IDENTIFIER, 0); }
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u0081\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\7\2\27\n\2\f\2\16\2\32\13\2\3\2\5\2\35\n\2\3\3\3\3\3\3\3\3\3\3\3\3\6"+
		"\3%\n\3\r\3\16\3&\3\3\3\3\5\3+\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\5\5\67\n\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5?\n\5\3\5\3\5\3\5\3\5\5\5E"+
		"\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5O\n\5\3\5\3\5\3\5\3\5\5\5U\n\5"+
		"\3\5\7\5X\n\5\f\5\16\5[\13\5\3\6\3\6\3\6\3\6\3\6\5\6b\n\6\3\6\3\6\3\7"+
		"\3\7\3\7\5\7i\n\7\3\b\3\b\3\b\3\b\7\bo\n\b\f\b\16\br\13\b\5\bt\n\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\5\t}\n\t\3\n\3\n\3\n\2\3\b\13\2\4\6\b\n\f\16"+
		"\20\22\2\2\2\u0092\2\30\3\2\2\2\4\36\3\2\2\2\6,\3\2\2\2\b\66\3\2\2\2\n"+
		"\\\3\2\2\2\fh\3\2\2\2\16j\3\2\2\2\20y\3\2\2\2\22~\3\2\2\2\24\27\5\4\3"+
		"\2\25\27\5\6\4\2\26\24\3\2\2\2\26\25\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2"+
		"\2\30\31\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\33\35\5\b\5\2\34\33\3\2\2"+
		"\2\34\35\3\2\2\2\35\3\3\2\2\2\36\37\7\3\2\2\37 \7\35\2\2 *\7\30\2\2!+"+
		"\5\6\4\2\"$\7\4\2\2#%\5\6\4\2$#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2"+
		"\'(\3\2\2\2()\7\5\2\2)+\3\2\2\2*!\3\2\2\2*\"\3\2\2\2+\5\3\2\2\2,-\7\6"+
		"\2\2-.\7\35\2\2./\5\16\b\2/\7\3\2\2\2\60\61\b\5\1\2\61\62\7\22\2\2\62"+
		"\67\5\b\5\6\63\67\5\n\6\2\64\67\5\16\b\2\65\67\5\f\7\2\66\60\3\2\2\2\66"+
		"\63\3\2\2\2\66\64\3\2\2\2\66\65\3\2\2\2\67Y\3\2\2\289\f\13\2\29:\7\27"+
		"\2\2:X\5\b\5\f;>\f\n\2\2<?\7\23\2\2=?\7\24\2\2><\3\2\2\2>=\3\2\2\2?@\3"+
		"\2\2\2@X\5\b\5\13AD\f\t\2\2BE\7\25\2\2CE\7\26\2\2DB\3\2\2\2DC\3\2\2\2"+
		"EF\3\2\2\2FX\5\b\5\nGN\f\b\2\2HO\7\f\2\2IO\7\r\2\2JO\7\16\2\2KO\7\17\2"+
		"\2LO\7\20\2\2MO\7\21\2\2NH\3\2\2\2NI\3\2\2\2NJ\3\2\2\2NK\3\2\2\2NL\3\2"+
		"\2\2NM\3\2\2\2OP\3\2\2\2PX\5\b\5\tQT\f\7\2\2RU\7\32\2\2SU\7\33\2\2TR\3"+
		"\2\2\2TS\3\2\2\2UV\3\2\2\2VX\5\b\5\bW8\3\2\2\2W;\3\2\2\2WA\3\2\2\2WG\3"+
		"\2\2\2WQ\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\t\3\2\2\2[Y\3\2\2\2\\"+
		"]\7\35\2\2]^\7\t\2\2^a\5\b\5\2_`\7\7\2\2`b\5\b\5\2a_\3\2\2\2ab\3\2\2\2"+
		"bc\3\2\2\2cd\7\n\2\2d\13\3\2\2\2ei\7\35\2\2fi\7\36\2\2gi\7\34\2\2he\3"+
		"\2\2\2hf\3\2\2\2hg\3\2\2\2i\r\3\2\2\2js\7\t\2\2kp\5\20\t\2lm\7\7\2\2m"+
		"o\5\20\t\2nl\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qt\3\2\2\2rp\3\2\2\2"+
		"sk\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\7\n\2\2vw\7\30\2\2wx\5\b\5\2x\17\3\2"+
		"\2\2y|\7\35\2\2z{\7\31\2\2{}\5\22\n\2|z\3\2\2\2|}\3\2\2\2}\21\3\2\2\2"+
		"~\177\7\35\2\2\177\23\3\2\2\2\23\26\30\34&*\66>DNTWYahps|";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}