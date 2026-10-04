package org.apache.http.message;

import java.util.ArrayList;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class BasicHeaderValueParserHC4 implements HeaderValueParser {
    private static final char ELEM_DELIMITER = ',';
    private static final char PARAM_DELIMITER = ';';

    @Deprecated
    public static final BasicHeaderValueParserHC4 DEFAULT = new BasicHeaderValueParserHC4();
    public static final BasicHeaderValueParserHC4 INSTANCE = new BasicHeaderValueParserHC4();
    private static final char[] ALL_DELIMITERS = {';', ','};

    private static boolean isOneOf(char c, char[] cArr) {
        if (cArr != null) {
            for (char c2 : cArr) {
                if (c == c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static HeaderElement[] parseElements(String str, HeaderValueParser headerValueParser) {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (headerValueParser == null) {
            headerValueParser = INSTANCE;
        }
        return headerValueParser.parseElements(charArrayBuffer, parserCursor);
    }

    public static HeaderElement parseHeaderElement(String str, HeaderValueParser headerValueParser) {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (headerValueParser == null) {
            headerValueParser = INSTANCE;
        }
        return headerValueParser.parseHeaderElement(charArrayBuffer, parserCursor);
    }

    public static NameValuePair parseNameValuePair(String str, HeaderValueParser headerValueParser) {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (headerValueParser == null) {
            headerValueParser = INSTANCE;
        }
        return headerValueParser.parseNameValuePair(charArrayBuffer, parserCursor);
    }

    public static NameValuePair[] parseParameters(String str, HeaderValueParser headerValueParser) {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (headerValueParser == null) {
            headerValueParser = INSTANCE;
        }
        return headerValueParser.parseParameters(charArrayBuffer, parserCursor);
    }

    public HeaderElement createHeaderElement(String str, String str2, NameValuePair[] nameValuePairArr) {
        return new BasicHeaderElement(str, str2, nameValuePairArr);
    }

    public NameValuePair createNameValuePair(String str, String str2) {
        return new BasicNameValuePair(str, str2);
    }

    @Override // org.apache.http.message.HeaderValueParser
    public HeaderElement[] parseElements(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        ArrayList arrayList = new ArrayList();
        while (!parserCursor.atEnd()) {
            HeaderElement headerElement = parseHeaderElement(charArrayBuffer, parserCursor);
            if (headerElement.getName().length() != 0 || headerElement.getValue() != null) {
                arrayList.add(headerElement);
            }
        }
        return (HeaderElement[]) arrayList.toArray(new HeaderElement[arrayList.size()]);
    }

    @Override // org.apache.http.message.HeaderValueParser
    public HeaderElement parseHeaderElement(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        NameValuePair nameValuePair = parseNameValuePair(charArrayBuffer, parserCursor);
        return createHeaderElement(nameValuePair.getName(), nameValuePair.getValue(), (parserCursor.atEnd() || charArrayBuffer.charAt(parserCursor.getPos() + (-1)) == ',') ? null : parseParameters(charArrayBuffer, parserCursor));
    }

    @Override // org.apache.http.message.HeaderValueParser
    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        return parseNameValuePair(charArrayBuffer, parserCursor, ALL_DELIMITERS);
    }

    @Override // org.apache.http.message.HeaderValueParser
    public NameValuePair[] parseParameters(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        while (pos < upperBound && HTTP.isWhitespace(charArrayBuffer.charAt(pos))) {
            pos++;
        }
        parserCursor.updatePos(pos);
        if (parserCursor.atEnd()) {
            return new NameValuePair[0];
        }
        ArrayList arrayList = new ArrayList();
        while (!parserCursor.atEnd()) {
            arrayList.add(parseNameValuePair(charArrayBuffer, parserCursor));
            if (charArrayBuffer.charAt(parserCursor.getPos() - 1) == ',') {
                break;
            }
        }
        return (NameValuePair[]) arrayList.toArray(new NameValuePair[arrayList.size()]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
    
        r5 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, char[] cArr) {
        boolean z;
        boolean z2;
        boolean z3;
        String strSubstringTrimmed;
        int i;
        char cCharAt;
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        int pos = parserCursor.getPos();
        int pos2 = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        while (true) {
            z = true;
            if (pos >= upperBound || (cCharAt = charArrayBuffer.charAt(pos)) == '=') {
                break;
            }
            if (isOneOf(cCharAt, cArr)) {
                z2 = true;
                break;
            }
            pos++;
        }
        if (pos == upperBound) {
            z3 = true;
            i = pos;
            strSubstringTrimmed = charArrayBuffer.substringTrimmed(pos2, upperBound);
        } else {
            z3 = z2;
            strSubstringTrimmed = charArrayBuffer.substringTrimmed(pos2, pos);
            i = pos + 1;
        }
        if (z3) {
            parserCursor.updatePos(i);
            return createNameValuePair(strSubstringTrimmed, null);
        }
        boolean z4 = false;
        boolean z5 = false;
        int i2 = i;
        while (true) {
            if (i2 < upperBound) {
                char cCharAt2 = charArrayBuffer.charAt(i2);
                if (cCharAt2 == '\"' && !z4) {
                    z5 = !z5;
                }
                if (!z5 && !z4 && isOneOf(cCharAt2, cArr)) {
                    break;
                }
                z4 = !z4 && z5 && cCharAt2 == '\\';
                i2++;
            } else {
                z = z3;
                break;
            }
        }
        while (i < i2 && HTTP.isWhitespace(charArrayBuffer.charAt(i))) {
            i++;
        }
        int i4 = i2;
        while (i4 > i && HTTP.isWhitespace(charArrayBuffer.charAt(i4 - 1))) {
            i4--;
        }
        if (i4 - i >= 2 && charArrayBuffer.charAt(i) == '\"' && charArrayBuffer.charAt(i4 - 1) == '\"') {
            i++;
            i4--;
        }
        String strSubstring = charArrayBuffer.substring(i, i4);
        if (z) {
            i2++;
        }
        parserCursor.updatePos(i2);
        return createNameValuePair(strSubstringTrimmed, strSubstring);
    }
}
