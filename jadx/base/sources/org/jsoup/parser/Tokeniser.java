package org.jsoup.parser;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import kotlin.text.Typography;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.Token;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class Tokeniser {
    private static final char[] notCharRefCharsSorted;
    static final char replacementChar = 65533;
    private Token emitPending;
    private ParseErrorList errors;
    private String lastStartTag;
    private CharacterReader reader;
    Token.Tag tagPending;
    private TokeniserState state = TokeniserState.Data;
    private boolean isEmitPending = false;
    private String charsString = null;
    private StringBuilder charsBuilder = new StringBuilder(1024);
    StringBuilder dataBuffer = new StringBuilder(1024);
    Token.StartTag startPending = new Token.StartTag();
    Token.EndTag endPending = new Token.EndTag();
    Token.Character charPending = new Token.Character();
    Token.Doctype doctypePending = new Token.Doctype();
    Token.Comment commentPending = new Token.Comment();
    private boolean selfClosingFlagAcknowledged = true;
    private final char[] charRefHolder = new char[1];

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', ' ', Typography.less, Typography.amp};
        notCharRefCharsSorted = cArr;
        Arrays.sort(cArr);
    }

    public Tokeniser(CharacterReader characterReader, ParseErrorList parseErrorList) {
        this.reader = characterReader;
        this.errors = parseErrorList;
    }

    private void characterReferenceError(String str) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Invalid character reference: %s", str));
        }
    }

    public void acknowledgeSelfClosingFlag() {
        this.selfClosingFlagAcknowledged = true;
    }

    public void advanceTransition(TokeniserState tokeniserState) {
        this.reader.advance();
        this.state = tokeniserState;
    }

    public String appropriateEndTagName() {
        String str = this.lastStartTag;
        if (str == null) {
            return null;
        }
        return str;
    }

    public char[] consumeCharacterReference(Character ch, boolean z) {
        int iIntValue;
        if (this.reader.isEmpty()) {
            return null;
        }
        if ((ch != null && ch.charValue() == this.reader.current()) || this.reader.matchesAnySorted(notCharRefCharsSorted)) {
            return null;
        }
        char[] cArr = this.charRefHolder;
        this.reader.mark();
        if (!this.reader.matchConsume(ContentUtils.HASH_SYMBOL)) {
            String strConsumeLetterThenDigitSequence = this.reader.consumeLetterThenDigitSequence();
            boolean zMatches = this.reader.matches(SQLKeyword.DELIMITER);
            if (!Entities.isBaseNamedEntity(strConsumeLetterThenDigitSequence) && (!Entities.isNamedEntity(strConsumeLetterThenDigitSequence) || !zMatches)) {
                this.reader.rewindToMark();
                if (zMatches) {
                    characterReferenceError(AbstractC0541b.m773o("invalid named referenece '", strConsumeLetterThenDigitSequence, "'"));
                }
                return null;
            }
            if (z && (this.reader.matchesLetter() || this.reader.matchesDigit() || this.reader.matchesAny('=', '-', '_'))) {
                this.reader.rewindToMark();
                return null;
            }
            if (!this.reader.matchConsume(";")) {
                characterReferenceError("missing semicolon");
            }
            cArr[0] = Entities.getCharacterByName(strConsumeLetterThenDigitSequence).charValue();
            return cArr;
        }
        boolean zMatchConsumeIgnoreCase = this.reader.matchConsumeIgnoreCase("X");
        CharacterReader characterReader = this.reader;
        String strConsumeHexSequence = zMatchConsumeIgnoreCase ? characterReader.consumeHexSequence() : characterReader.consumeDigitSequence();
        if (strConsumeHexSequence.length() == 0) {
            characterReferenceError("numeric reference with no numerals");
            this.reader.rewindToMark();
            return null;
        }
        if (!this.reader.matchConsume(";")) {
            characterReferenceError("missing semicolon");
        }
        try {
            iIntValue = Integer.valueOf(strConsumeHexSequence, zMatchConsumeIgnoreCase ? 16 : 10).intValue();
        } catch (NumberFormatException unused) {
            iIntValue = -1;
        }
        if (iIntValue == -1 || ((iIntValue >= 55296 && iIntValue <= 57343) || iIntValue > 1114111)) {
            characterReferenceError("character outside of valid range");
            cArr[0] = 65533;
            return cArr;
        }
        if (iIntValue >= 65536) {
            return Character.toChars(iIntValue);
        }
        cArr[0] = (char) iIntValue;
        return cArr;
    }

    public void createCommentPending() {
        this.commentPending.reset();
    }

    public void createDoctypePending() {
        this.doctypePending.reset();
    }

    public Token.Tag createTagPending(boolean z) {
        Token.Tag tagReset = z ? this.startPending.reset() : this.endPending.reset();
        this.tagPending = tagReset;
        return tagReset;
    }

    public void createTempBuffer() {
        Token.reset(this.dataBuffer);
    }

    public boolean currentNodeInHtmlNS() {
        return true;
    }

    public void emit(Token token) {
        Validate.isFalse(this.isEmitPending, "There is an unread token pending!");
        this.emitPending = token;
        this.isEmitPending = true;
        Token.TokenType tokenType = token.type;
        if (tokenType != Token.TokenType.StartTag) {
            if (tokenType != Token.TokenType.EndTag || ((Token.EndTag) token).attributes == null) {
                return;
            }
            error("Attributes incorrectly present on end tag");
            return;
        }
        Token.StartTag startTag = (Token.StartTag) token;
        this.lastStartTag = startTag.tagName;
        if (startTag.selfClosing) {
            this.selfClosingFlagAcknowledged = false;
        }
    }

    public void emitCommentPending() {
        emit(this.commentPending);
    }

    public void emitDoctypePending() {
        emit(this.doctypePending);
    }

    public void emitTagPending() {
        this.tagPending.finaliseTag();
        emit(this.tagPending);
    }

    public void eofError(TokeniserState tokeniserState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    public void error(TokeniserState tokeniserState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.reader.current()), tokeniserState));
        }
    }

    public TokeniserState getState() {
        return this.state;
    }

    public boolean isAppropriateEndTagToken() {
        String str = this.lastStartTag;
        return str != null && this.tagPending.tagName.equals(str);
    }

    public Token read() {
        if (!this.selfClosingFlagAcknowledged) {
            error("Self closing flag not acknowledged");
            this.selfClosingFlagAcknowledged = true;
        }
        while (!this.isEmitPending) {
            this.state.read(this, this.reader);
        }
        if (this.charsBuilder.length() > 0) {
            String string = this.charsBuilder.toString();
            StringBuilder sb = this.charsBuilder;
            sb.delete(0, sb.length());
            this.charsString = null;
            return this.charPending.data(string);
        }
        String str = this.charsString;
        if (str == null) {
            this.isEmitPending = false;
            return this.emitPending;
        }
        Token.Character characterData = this.charPending.data(str);
        this.charsString = null;
        return characterData;
    }

    public void transition(TokeniserState tokeniserState) {
        this.state = tokeniserState;
    }

    public String unescapeEntities(boolean z) {
        StringBuilder sb = new StringBuilder();
        while (!this.reader.isEmpty()) {
            sb.append(this.reader.consumeTo(Typography.amp));
            if (this.reader.matches(Typography.amp)) {
                this.reader.consume();
                char[] cArrConsumeCharacterReference = consumeCharacterReference(null, z);
                if (cArrConsumeCharacterReference == null || cArrConsumeCharacterReference.length == 0) {
                    sb.append(Typography.amp);
                } else {
                    sb.append(cArrConsumeCharacterReference);
                }
            }
        }
        return sb.toString();
    }

    private void error(String str) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), str));
        }
    }

    public void emit(String str) {
        if (this.charsString == null) {
            this.charsString = str;
            return;
        }
        if (this.charsBuilder.length() == 0) {
            this.charsBuilder.append(this.charsString);
        }
        this.charsBuilder.append(str);
    }

    public void emit(char[] cArr) {
        emit(String.valueOf(cArr));
    }

    public void emit(char c) {
        emit(String.valueOf(c));
    }
}
