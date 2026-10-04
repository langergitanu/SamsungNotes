package opennlp.tools.namefind;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import opennlp.tools.util.SequenceCodec;
import opennlp.tools.util.SequenceValidator;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BilouCodec implements SequenceCodec<String> {
    public static final String CONTINUE = "cont";
    public static final String LAST = "last";
    public static final String OTHER = "other";
    public static final String START = "start";
    public static final String UNIT = "unit";

    @Override // opennlp.tools.util.SequenceCodec
    public boolean areOutcomesCompatible(String[] strArr) {
        HashSet hashSet = new HashSet();
        HashSet<String> hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (String str : strArr) {
            if (str.endsWith("start")) {
                hashSet.add(str.substring(0, str.length() - 5));
            } else if (str.endsWith("cont")) {
                hashSet2.add(str.substring(0, str.length() - 4));
            } else if (str.endsWith(LAST)) {
                hashSet3.add(str.substring(0, str.length() - 4));
            } else if (str.endsWith(UNIT)) {
                hashSet4.add(str.substring(0, str.length() - 4));
            } else if (!str.equals("other")) {
                return false;
            }
        }
        if (hashSet.isEmpty() && hashSet4.isEmpty()) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (!hashSet3.contains((String) it.next())) {
                return false;
            }
        }
        for (String str2 : hashSet2) {
            if (!hashSet.contains(str2) && !hashSet3.contains(str2)) {
                return false;
            }
        }
        Iterator it2 = hashSet3.iterator();
        while (it2.hasNext()) {
            if (!hashSet.contains((String) it2.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // opennlp.tools.util.SequenceCodec
    /* JADX INFO: renamed from: createSequenceValidator */
    public SequenceValidator<String> createSequenceValidator2() {
        return new BilouNameFinderSequenceValidator();
    }

    @Override // opennlp.tools.util.SequenceCodec
    public Span[] decode(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int i = -1;
        int i2 = -1;
        for (int i4 = 0; i4 < list.size(); i4++) {
            String str = list.get(i4);
            if (str.endsWith("start")) {
                i2 = i4 + 1;
                i = i4;
            } else if (str.endsWith("cont")) {
                i2 = i4 + 1;
            } else if (str.endsWith(LAST)) {
                if (i != -1) {
                    arrayList.add(new Span(i, i2 + 1, BioCodec.extractNameType(list.get(i4 - 1))));
                    i = -1;
                    i2 = -1;
                }
            } else if (str.endsWith(UNIT)) {
                arrayList.add(new Span(i4, i4 + 1, BioCodec.extractNameType(list.get(i4))));
            }
        }
        return (Span[]) arrayList.toArray(new Span[0]);
    }

    @Override // opennlp.tools.util.SequenceCodec
    public String[] encode(Span[] spanArr, int i) {
        String[] strArr = new String[i];
        Arrays.fill(strArr, "other");
        for (Span span : spanArr) {
            if (span.length() > 1) {
                if (span.getType() == null) {
                    strArr[span.getStart()] = "default-start";
                } else {
                    strArr[span.getStart()] = AbstractC0541b.m756B(span.getType(), "-start");
                }
                for (int start = span.getStart() + 1; start < span.getEnd() - 1; start++) {
                    if (span.getType() == null) {
                        strArr[start] = "default-cont";
                    } else {
                        strArr[start] = AbstractC0541b.m756B(span.getType(), "-cont");
                    }
                }
                if (span.getType() == null) {
                    strArr[span.getEnd() - 1] = "default-last";
                } else {
                    strArr[span.getEnd() - 1] = AbstractC0541b.m756B(span.getType(), "-last");
                }
            } else if (span.getType() == null) {
                strArr[span.getEnd() - 1] = "default-unit";
            } else {
                strArr[span.getEnd() - 1] = AbstractC0541b.m756B(span.getType(), "-unit");
            }
        }
        return strArr;
    }
}
