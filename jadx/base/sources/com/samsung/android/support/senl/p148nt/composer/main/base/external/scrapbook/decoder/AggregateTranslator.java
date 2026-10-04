package com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook.decoder;

import androidx.annotation.NonNull;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AggregateTranslator extends CharSequenceTranslator {
    private final CharSequenceTranslator[] translators;

    public AggregateTranslator(@NonNull CharSequenceTranslator... charSequenceTranslatorArr) {
        this.translators = (CharSequenceTranslator[]) charSequenceTranslatorArr.clone();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook.decoder.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i, Writer writer) {
        for (CharSequenceTranslator charSequenceTranslator : this.translators) {
            int iTranslate = charSequenceTranslator.translate(charSequence, i, writer);
            if (iTranslate != 0) {
                return iTranslate;
            }
        }
        return 0;
    }
}
