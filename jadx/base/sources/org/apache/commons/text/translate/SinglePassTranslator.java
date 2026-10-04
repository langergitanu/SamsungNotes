package org.apache.commons.text.translate;

import androidx.collection.AbstractC0622a;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
abstract class SinglePassTranslator extends CharSequenceTranslator {
    private String getClassName() {
        Class<?> cls = getClass();
        return cls.isAnonymousClass() ? cls.getName() : cls.getSimpleName();
    }

    @Override // org.apache.commons.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i, Writer writer) {
        if (i == 0) {
            translateWhole(charSequence, writer);
            return Character.codePointCount(charSequence, i, charSequence.length());
        }
        throw new IllegalArgumentException(AbstractC0622a.m1170p(getClassName(), ".translate(final CharSequence input, final int index, final Writer out) cannot handle a non-zero index.", new StringBuilder()));
    }

    public abstract void translateWhole(CharSequence charSequence, Writer writer);
}
