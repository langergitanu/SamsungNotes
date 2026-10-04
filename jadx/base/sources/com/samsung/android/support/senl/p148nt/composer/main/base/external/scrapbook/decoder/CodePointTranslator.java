package com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook.decoder;

import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CodePointTranslator extends CharSequenceTranslator {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook.decoder.CharSequenceTranslator
    public final int translate(CharSequence charSequence, int i, Writer writer) {
        return translate(Character.codePointAt(charSequence, i), writer) ? 1 : 0;
    }

    public abstract boolean translate(int i, Writer writer);
}
