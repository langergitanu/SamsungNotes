package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class OctalUnescaper extends CharSequenceTranslator {
    private boolean isZeroToThree(char c) {
        return c >= '0' && c <= '3';
    }

    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
        int length = (charSequence.length() - i) - 1;
        StringBuilder sb = new StringBuilder();
        if (charSequence.charAt(i) != '\\' || length <= 0) {
            return 0;
        }
        int i2 = i + 1;
        if (!CharUtils.isOctal(charSequence.charAt(i2))) {
            return 0;
        }
        int i4 = i + 2;
        int i5 = i + 3;
        sb.append(charSequence.charAt(i2));
        if (length > 1 && CharUtils.isOctal(charSequence.charAt(i4))) {
            sb.append(charSequence.charAt(i4));
            if (length > 2 && isZeroToThree(charSequence.charAt(i2)) && CharUtils.isOctal(charSequence.charAt(i5))) {
                sb.append(charSequence.charAt(i5));
            }
        }
        writer.write(Integer.parseInt(sb.toString(), 8));
        return sb.length() + 1;
    }
}
