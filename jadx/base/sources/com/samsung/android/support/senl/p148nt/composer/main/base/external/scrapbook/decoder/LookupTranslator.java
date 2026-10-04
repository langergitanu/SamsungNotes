package com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook.decoder;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class LookupTranslator extends CharSequenceTranslator {
    private final int longest;
    private final HashMap<CharSequence, CharSequence> lookupMap = new HashMap<>();
    private final int shortest;

    public LookupTranslator(CharSequence[]... charSequenceArr) {
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        if (charSequenceArr != null) {
            int i4 = 0;
            for (CharSequence[] charSequenceArr2 : charSequenceArr) {
                this.lookupMap.put(charSequenceArr2[0], charSequenceArr2[1]);
                int length = charSequenceArr2[0].length();
                i = length < i ? length : i;
                if (length > i4) {
                    i4 = length;
                }
            }
            i2 = i4;
        }
        this.shortest = i;
        this.longest = i2;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook.decoder.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
        int length = this.longest;
        if (i + length > charSequence.length()) {
            length = charSequence.length() - i;
        }
        while (length >= this.shortest) {
            CharSequence charSequence2 = this.lookupMap.get(charSequence.subSequence(i, i + length));
            if (charSequence2 != null) {
                writer.write(charSequence2.toString());
                return length;
            }
            length--;
        }
        return 0;
    }
}
