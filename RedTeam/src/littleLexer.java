// Generated from little.g4 by ANTLR 4.5.1
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
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KEYWORD=1, WS=2, OPERATOR=3, INTLITERAL=4, FLOATLITERAL=5, STRINGLITERAL=6, 
		COMMENT=7, IDENTIFIER=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"KEYWORD", "WS", "OPERATOR", "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", 
		"COMMENT", "IDENTIFIER"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "KEYWORD", "WS", "OPERATOR", "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", 
		"COMMENT", "IDENTIFIER"
	};
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
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\n\u00b8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\5\2q\n\2\3\3\6\3t\n\3\r\3\16\3u\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\5\4\u0084\n\4\3\5\6\5\u0087\n\5\r\5\16\5\u0088\3"+
		"\6\7\6\u008c\n\6\f\6\16\6\u008f\13\6\3\6\3\6\7\6\u0093\n\6\f\6\16\6\u0096"+
		"\13\6\3\7\3\7\7\7\u009a\n\7\f\7\16\7\u009d\13\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\7\b\u00a5\n\b\f\b\16\b\u00a8\13\b\3\b\3\b\3\b\3\b\3\t\6\t\u00af\n\t"+
		"\r\t\16\t\u00b0\3\t\7\t\u00b4\n\t\f\t\16\t\u00b7\13\t\4\u009b\u00a6\2"+
		"\n\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\3\2\n\5\2\13\f\17\17\"\"\6\2,-/"+
		"/\61\61??\6\2*+..=>@@\3\2\62;\3\2$$\3\2\f\f\4\2C\\c|\5\2\62;C\\c|\u00d5"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3p\3\2\2\2\5s\3\2\2\2\7\u0083\3\2\2\2\t"+
		"\u0086\3\2\2\2\13\u008d\3\2\2\2\r\u0097\3\2\2\2\17\u00a0\3\2\2\2\21\u00ae"+
		"\3\2\2\2\23\24\7R\2\2\24\25\7T\2\2\25\26\7Q\2\2\26\27\7I\2\2\27\30\7T"+
		"\2\2\30\31\7C\2\2\31q\7O\2\2\32\33\7D\2\2\33\34\7G\2\2\34\35\7I\2\2\35"+
		"\36\7K\2\2\36q\7P\2\2\37 \7G\2\2 !\7P\2\2!q\7F\2\2\"#\7H\2\2#$\7W\2\2"+
		"$%\7P\2\2%&\7E\2\2&\'\7V\2\2\'(\7K\2\2()\7Q\2\2)q\7P\2\2*+\7Y\2\2+,\7"+
		"T\2\2,-\7K\2\2-.\7V\2\2.q\7G\2\2/\60\7K\2\2\60q\7H\2\2\61\62\7G\2\2\62"+
		"\63\7N\2\2\63\64\7U\2\2\64q\7G\2\2\65\66\7G\2\2\66\67\7P\2\2\678\7F\2"+
		"\289\7K\2\29q\7H\2\2:;\7Y\2\2;<\7J\2\2<=\7K\2\2=>\7N\2\2>q\7G\2\2?@\7"+
		"G\2\2@A\7P\2\2AB\7F\2\2BC\7Y\2\2CD\7J\2\2DE\7K\2\2EF\7N\2\2Fq\7G\2\2G"+
		"H\7E\2\2HI\7Q\2\2IJ\7P\2\2JK\7V\2\2KL\7K\2\2LM\7P\2\2MN\7W\2\2Nq\7G\2"+
		"\2OP\7D\2\2PQ\7T\2\2QR\7G\2\2RS\7C\2\2Sq\7M\2\2TU\7T\2\2UV\7G\2\2VW\7"+
		"V\2\2WX\7W\2\2XY\7T\2\2Yq\7P\2\2Z[\7K\2\2[\\\7P\2\2\\q\7V\2\2]^\7X\2\2"+
		"^_\7Q\2\2_`\7K\2\2`q\7F\2\2ab\7U\2\2bc\7V\2\2cd\7T\2\2de\7K\2\2ef\7P\2"+
		"\2fq\7I\2\2gh\7H\2\2hi\7N\2\2ij\7Q\2\2jk\7C\2\2kq\7V\2\2lm\7T\2\2mn\7"+
		"G\2\2no\7C\2\2oq\7F\2\2p\23\3\2\2\2p\32\3\2\2\2p\37\3\2\2\2p\"\3\2\2\2"+
		"p*\3\2\2\2p/\3\2\2\2p\61\3\2\2\2p\65\3\2\2\2p:\3\2\2\2p?\3\2\2\2pG\3\2"+
		"\2\2pO\3\2\2\2pT\3\2\2\2pZ\3\2\2\2p]\3\2\2\2pa\3\2\2\2pg\3\2\2\2pl\3\2"+
		"\2\2q\4\3\2\2\2rt\t\2\2\2sr\3\2\2\2tu\3\2\2\2us\3\2\2\2uv\3\2\2\2vw\3"+
		"\2\2\2wx\b\3\2\2x\6\3\2\2\2yz\7<\2\2z\u0084\7?\2\2{\u0084\t\3\2\2|}\7"+
		"#\2\2}\u0084\7?\2\2~\u0084\t\4\2\2\177\u0080\7>\2\2\u0080\u0084\7?\2\2"+
		"\u0081\u0082\7@\2\2\u0082\u0084\7?\2\2\u0083y\3\2\2\2\u0083{\3\2\2\2\u0083"+
		"|\3\2\2\2\u0083~\3\2\2\2\u0083\177\3\2\2\2\u0083\u0081\3\2\2\2\u0084\b"+
		"\3\2\2\2\u0085\u0087\t\5\2\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\n\3\2\2\2\u008a\u008c\t\5\2\2"+
		"\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0094\7\60\2\2"+
		"\u0091\u0093\t\5\2\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092"+
		"\3\2\2\2\u0094\u0095\3\2\2\2\u0095\f\3\2\2\2\u0096\u0094\3\2\2\2\u0097"+
		"\u009b\t\6\2\2\u0098\u009a\13\2\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3"+
		"\2\2\2\u009b\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009e\3\2\2\2\u009d"+
		"\u009b\3\2\2\2\u009e\u009f\t\6\2\2\u009f\16\3\2\2\2\u00a0\u00a1\7/\2\2"+
		"\u00a1\u00a2\7/\2\2\u00a2\u00a6\3\2\2\2\u00a3\u00a5\13\2\2\2\u00a4\u00a3"+
		"\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7"+
		"\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00aa\t\7\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\u00ac\b\b\2\2\u00ac\20\3\2\2\2\u00ad\u00af\t\b\2\2\u00ae\u00ad"+
		"\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00b5\3\2\2\2\u00b2\u00b4\t\t\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2"+
		"\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\22\3\2\2\2\u00b7\u00b5"+
		"\3\2\2\2\r\2pu\u0083\u0088\u008d\u0094\u009b\u00a6\u00b0\u00b5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}