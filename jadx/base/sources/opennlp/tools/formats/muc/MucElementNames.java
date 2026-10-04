package opennlp.tools.formats.muc;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class MucElementNames {
    static final Set<String> CONTENT_ELEMENTS;
    static final String DATELINE_ELEMENT = "DATELINE";
    static final String DD_ELEMENT = "DD";
    static final String DOC_ELEMENT = "DOC";
    static final String HEADLINE_ELEMENT = "HL";
    static final String SENTENCE_ELEMENT = "s";

    static {
        Object[] objArr = {HEADLINE_ELEMENT, DATELINE_ELEMENT, DD_ELEMENT, "s"};
        HashSet hashSet = new HashSet(4);
        for (int i = 0; i < 4; i++) {
            Object obj = objArr[i];
            Objects.requireNonNull(obj);
            if (!hashSet.add(obj)) {
                throw new IllegalArgumentException(AbstractC0541b.m769k(obj, "duplicate element: "));
            }
        }
        CONTENT_ELEMENTS = Collections.unmodifiableSet(hashSet);
    }

    private MucElementNames() {
    }
}
