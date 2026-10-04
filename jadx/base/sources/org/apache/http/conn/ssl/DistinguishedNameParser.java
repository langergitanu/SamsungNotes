package org.apache.http.conn.ssl;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
final class DistinguishedNameParser {
    private final TokenParser tokenParser = new InternalTokenParser();
    public static final DistinguishedNameParser INSTANCE = new DistinguishedNameParser();
    private static final BitSet EQUAL_OR_COMMA_OR_PLUS = TokenParser.INIT_BITSET(61, 44, 43);
    private static final BitSet COMMA_OR_PLUS = TokenParser.INIT_BITSET(44, 43);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InternalTokenParser extends TokenParser {
        @Override // org.apache.http.conn.ssl.TokenParser
        public void copyUnquotedContent(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet, StringBuilder sb) {
            int pos = parserCursor.getPos();
            int pos2 = parserCursor.getPos();
            int upperBound = parserCursor.getUpperBound();
            boolean z = false;
            while (pos2 < upperBound) {
                char cCharAt = charArrayBuffer.charAt(pos2);
                if (!z) {
                    if ((bitSet != null && bitSet.get(cCharAt)) || TokenParser.isWhitespace(cCharAt) || cCharAt == '\"') {
                        break;
                    } else if (cCharAt == '\\') {
                        z = true;
                    } else {
                        sb.append(cCharAt);
                    }
                } else {
                    sb.append(cCharAt);
                    z = false;
                }
                pos2++;
                pos++;
            }
            parserCursor.updatePos(pos);
        }
    }

    public List<NameValuePair> parse(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        ArrayList arrayList = new ArrayList();
        this.tokenParser.skipWhiteSpace(charArrayBuffer, parserCursor);
        while (!parserCursor.atEnd()) {
            arrayList.add(parseParameter(charArrayBuffer, parserCursor));
        }
        return arrayList;
    }

    public NameValuePair parseParameter(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        String token = parseToken(charArrayBuffer, parserCursor, EQUAL_OR_COMMA_OR_PLUS);
        if (parserCursor.atEnd()) {
            return new BasicNameValuePair(token, null);
        }
        char cCharAt = charArrayBuffer.charAt(parserCursor.getPos());
        parserCursor.updatePos(parserCursor.getPos() + 1);
        if (cCharAt == ',') {
            return new BasicNameValuePair(token, null);
        }
        String value = parseValue(charArrayBuffer, parserCursor, COMMA_OR_PLUS);
        if (!parserCursor.atEnd()) {
            parserCursor.updatePos(parserCursor.getPos() + 1);
        }
        return new BasicNameValuePair(token, value);
    }

    public String parseToken(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet) {
        return this.tokenParser.parseToken(charArrayBuffer, parserCursor, bitSet);
    }

    public String parseValue(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet) {
        return this.tokenParser.parseValue(charArrayBuffer, parserCursor, bitSet);
    }

    public List<NameValuePair> parse(String str) {
        if (str == null) {
            return null;
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        return parse(charArrayBuffer, new ParserCursor(0, str.length()));
    }
}
