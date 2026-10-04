package org.apache.commons.text.translate;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import org.apache.commons.collections4.map.C13771a;
import p074R1.C0233e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AggregateTranslator extends CharSequenceTranslator {
    private final List<CharSequenceTranslator> translators;

    public AggregateTranslator(CharSequenceTranslator... charSequenceTranslatorArr) {
        ArrayList arrayList = new ArrayList();
        this.translators = arrayList;
        if (charSequenceTranslatorArr != null) {
            Stream.of((Object[]) charSequenceTranslatorArr).filter(new C0233e(24)).forEach(new C13771a(arrayList, 2));
        }
    }

    @Override // org.apache.commons.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i, Writer writer) {
        Iterator<CharSequenceTranslator> it = this.translators.iterator();
        while (it.hasNext()) {
            int iTranslate = it.next().translate(charSequence, i, writer);
            if (iTranslate != 0) {
                return iTranslate;
            }
        }
        return 0;
    }
}
