// Generated from /home/alex/IdeaProjects/RedTeam/out/production/RedTeam/little.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class littleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KEYWORD=1, WS=2, OPERATOR=3, INTLITERAL=4, FLOATLITERAL=5, STRINGLITERAL=6, 
		COMMENT=7, IDENTIFIER=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"KEYWORD", "WS", "OPERATOR", "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", 
			"COMMENT", "IDENTIFIER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KEYWORD", "WS", "OPERATOR", "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", 
			"COMMENT", "IDENTIFIER"
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


	public littleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "little.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\n\u00a7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2m"+
		"\n\2\3\3\6\3p\n\3\r\3\16\3q\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4\u0080\n\4\3\5\6\5\u0083\n\5\r\5\16\5\u0084\3\6\7\6\u0088\n"+
		"\6\f\6\16\6\u008b\13\6\3\6\3\6\7\6\u008f\n\6\f\6\16\6\u0092\13\6\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\6\t\u009e\n\t\r\t\16\t\u009f\3\t\7"+
		"\t\u00a3\n\t\f\t\16\t\u00a6\13\t\2\2\n\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\3\2\13\5\2\13\f\17\17\"\"\6\2,-//\61\61??\6\2*+..=>@@\3\2\62;\4\2,"+
		",\60\60\3\2//\3\2\f\f\4\2C\\c|\5\2\62;C\\c|\2\u00c1\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\3l\3\2\2\2\5o\3\2\2\2\7\177\3\2\2\2\t\u0082\3\2\2\2\13\u0089"+
		"\3\2\2\2\r\u0093\3\2\2\2\17\u0097\3\2\2\2\21\u009d\3\2\2\2\23\24\7R\2"+
		"\2\24\25\7T\2\2\25\26\7Q\2\2\26\27\7I\2\2\27\30\7T\2\2\30\31\7C\2\2\31"+
		"m\7O\2\2\32\33\7D\2\2\33\34\7G\2\2\34\35\7I\2\2\35\36\7K\2\2\36m\7P\2"+
		"\2\37 \7G\2\2 !\7P\2\2!m\7F\2\2\"#\7H\2\2#$\7W\2\2$%\7P\2\2%&\7E\2\2&"+
		"\'\7V\2\2\'(\7K\2\2()\7Q\2\2)m\7P\2\2*+\7Y\2\2+,\7T\2\2,-\7K\2\2-.\7V"+
		"\2\2.m\7G\2\2/\60\7K\2\2\60m\7H\2\2\61\62\7G\2\2\62\63\7N\2\2\63\64\7"+
		"U\2\2\64m\7G\2\2\65\66\7G\2\2\66\67\7P\2\2\678\7F\2\289\7K\2\29m\7H\2"+
		"\2:;\7Y\2\2;<\7J\2\2<=\7K\2\2=>\7N\2\2>m\7G\2\2?@\7G\2\2@A\7P\2\2AB\7"+
		"F\2\2BC\7Y\2\2CD\7J\2\2DE\7K\2\2EF\7N\2\2Fm\7G\2\2GH\7E\2\2HI\7Q\2\2I"+
		"J\7P\2\2JK\7V\2\2KL\7K\2\2LM\7P\2\2MN\7W\2\2Nm\7G\2\2OP\7D\2\2PQ\7T\2"+
		"\2QR\7G\2\2RS\7C\2\2Sm\7M\2\2TU\7T\2\2UV\7G\2\2VW\7V\2\2WX\7W\2\2XY\7"+
		"T\2\2Ym\7P\2\2Z[\7K\2\2[\\\7P\2\2\\m\7V\2\2]^\7X\2\2^_\7Q\2\2_`\7K\2\2"+
		"`m\7F\2\2ab\7U\2\2bc\7V\2\2cd\7T\2\2de\7K\2\2ef\7P\2\2fm\7I\2\2gh\7H\2"+
		"\2hi\7N\2\2ij\7Q\2\2jk\7C\2\2km\7V\2\2l\23\3\2\2\2l\32\3\2\2\2l\37\3\2"+
		"\2\2l\"\3\2\2\2l*\3\2\2\2l/\3\2\2\2l\61\3\2\2\2l\65\3\2\2\2l:\3\2\2\2"+
		"l?\3\2\2\2lG\3\2\2\2lO\3\2\2\2lT\3\2\2\2lZ\3\2\2\2l]\3\2\2\2la\3\2\2\2"+
		"lg\3\2\2\2m\4\3\2\2\2np\t\2\2\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2"+
		"\2rs\3\2\2\2st\b\3\2\2t\6\3\2\2\2uv\7<\2\2v\u0080\7?\2\2w\u0080\t\3\2"+
		"\2xy\7#\2\2y\u0080\7?\2\2z\u0080\t\4\2\2{|\7>\2\2|\u0080\7?\2\2}~\7@\2"+
		"\2~\u0080\7?\2\2\177u\3\2\2\2\177w\3\2\2\2\177x\3\2\2\2\177z\3\2\2\2\177"+
		"{\3\2\2\2\177}\3\2\2\2\u0080\b\3\2\2\2\u0081\u0083\t\5\2\2\u0082\u0081"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\n\3\2\2\2\u0086\u0088\t\5\2\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2"+
		"\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u0089"+
		"\3\2\2\2\u008c\u0090\7\60\2\2\u008d\u008f\t\5\2\2\u008e\u008d\3\2\2\2"+
		"\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\f\3"+
		"\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7$\2\2\u0094\u0095\t\6\2\2\u0095"+
		"\u0096\7$\2\2\u0096\16\3\2\2\2\u0097\u0098\t\7\2\2\u0098\u0099\t\7\2\2"+
		"\u0099\u009a\t\6\2\2\u009a\u009b\t\b\2\2\u009b\20\3\2\2\2\u009c\u009e"+
		"\t\t\2\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a4\3\2\2\2\u00a1\u00a3\t\n\2\2\u00a2\u00a1\3\2"+
		"\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\22\3\2\2\2\u00a6\u00a4\3\2\2\2\13\2lq\177\u0084\u0089\u0090\u009f\u00a4"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}