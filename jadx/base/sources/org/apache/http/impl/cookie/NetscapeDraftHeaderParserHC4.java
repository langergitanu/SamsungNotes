package org.apache.http.impl.cookie;

import java.util.ArrayList;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicHeaderElement;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.ParserCursor;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class NetscapeDraftHeaderParserHC4 {
    public static final NetscapeDraftHeaderParserHC4 DEFAULT = new NetscapeDraftHeaderParserHC4();

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
    
        r5 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        boolean z;
        boolean z2;
        boolean z3;
        String strSubstringTrimmed;
        int i;
        char cCharAt;
        int pos = parserCursor.getPos();
        int pos2 = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        while (true) {
            z = true;
            if (pos >= upperBound || (cCharAt = charArrayBuffer.charAt(pos)) == '=') {
                break;
            }
            if (cCharAt == ';') {
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
            return new BasicNameValuePair(strSubstringTrimmed, null);
        }
        int i2 = i;
        while (true) {
            if (i2 >= upperBound) {
                z = z3;
                break;
            }
            if (charArrayBuffer.charAt(i2) == ';') {
                break;
            }
            i2++;
        }
        while (i < i2 && HTTP.isWhitespace(charArrayBuffer.charAt(i))) {
            i++;
        }
        int i4 = i2;
        while (i4 > i && HTTP.isWhitespace(charArrayBuffer.charAt(i4 - 1))) {
            i4--;
        }
        String strSubstring = charArrayBuffer.substring(i, i4);
        if (z) {
            i2++;
        }
        parserCursor.updatePos(i2);
        return new BasicNameValuePair(strSubstringTrimmed, strSubstring);
    }

    public HeaderElement parseHeader(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        NameValuePair nameValuePair = parseNameValuePair(charArrayBuffer, parserCursor);
        ArrayList arrayList = new ArrayList();
        while (!parserCursor.atEnd()) {
            arrayList.add(parseNameValuePair(charArrayBuffer, parserCursor));
        }
        return new BasicHeaderElement(nameValuePair.getName(), nameValuePair.getValue(), (NameValuePair[]) arrayList.toArray(new NameValuePair[arrayList.size()]));
    }
}
