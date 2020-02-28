import org.antlr.v4.runtime.*;

/** Class to override the default automatic error recovery of ANTLR4
 *  parser. Instead, errors will cause the program to bail. Copied from
 *  "The Definitive ANTLR4 Reference, 2nd Edition," Section 9.5 pgs 172-174,
 *  written by Dr. Terence Parr
 *
 */
public class BailErrorStrategy extends DefaultErrorStrategy {
    /** Instead of recovering from exception e, rethrow it wrapped
     * in a generic RuntimeException so it is not caught by the
     * rule function catches. Exception e is the "cause" of the
     * RuntimeException.
     */
    @Override
    public void recover(Parser recognizer, RecognitionException e) {
        throw new RuntimeException(e);
    }

    /** Make sure we don't attempt to recover inline; if the parser
     * successfully recovers, it won't throw an exception.
     */
    @Override
    public Token recoverInline(Parser recognizer)
            throws RecognitionException
    {
        throw new RuntimeException();
    }
    /** Make sure we don't attempt to recover from problems in subrules. */
    @Override
    public void sync(Parser recognizer) { }

    @Override
    public void reportNoViableAlternative(Parser parser, NoViableAltException e)
            throws RecognitionException { }
}

