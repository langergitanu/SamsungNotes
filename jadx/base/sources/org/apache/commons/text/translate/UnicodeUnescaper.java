package org.apache.commons.text.translate;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class UnicodeUnescaper extends CharSequenceTranslator {
    @Override // org.apache.commons.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
        int i2;
        int i4;
        if (charSequence.charAt(i) != '\\' || (i2 = i + 1) >= charSequence.length() || charSequence.charAt(i2) != 'u') {
            return 0;
        }
        int i5 = 2;
        while (true) {
            i4 = i + i5;
            if (i4 >= charSequence.length() || charSequence.charAt(i4) != 'u') {
                break;
            }
            i5++;
        }
        if (i4 < charSequence.length() && charSequence.charAt(i4) == '+') {
            i5++;
        }
        int i6 = i + i5;
        int i7 = i6 + 4;
        if (i7 > charSequence.length()) {
            throw new IllegalArgumentException("Less than 4 hex digits in unicode value: '" + ((Object) charSequence.subSequence(i, charSequence.length())) + "' due to end of CharSequence");
        }
        CharSequence charSequenceSubSequence = charSequence.subSequence(i6, i7);
        try {
            writer.write((char) Integer.parseInt(charSequenceSubSequence.toString(), 16));
            return i5 + 4;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Unable to parse unicode value: " + ((Object) charSequenceSubSequence), e);
        }
    }
}
