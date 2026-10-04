package com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook.decoder;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OctalUnescaper extends CharSequenceTranslator {
    private static int OCTAL_MAX = 377;

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook.decoder.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
        if (charSequence.charAt(i) != '\\' || i >= charSequence.length() - 1) {
            return 0;
        }
        int i2 = i + 1;
        if (!Character.isDigit(charSequence.charAt(i2))) {
            return 0;
        }
        int i4 = i + 2;
        int length = charSequence.length();
        while (i4 < length && Character.isDigit(charSequence.charAt(i4))) {
            int i5 = i4 + 1;
            if (Integer.parseInt(charSequence.subSequence(i2, i5).toString(), 10) > OCTAL_MAX) {
                break;
            }
            i4 = i5;
        }
        writer.write(Integer.parseInt(charSequence.subSequence(i2, i4).toString(), 8));
        return (i4 + 1) - i2;
    }
}
