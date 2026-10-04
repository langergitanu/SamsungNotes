package opennlp.tools.namefind;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import opennlp.tools.util.SequenceCodec;
import opennlp.tools.util.SequenceValidator;
import opennlp.tools.util.Span;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BioCodec implements SequenceCodec<String> {
    public static final String CONTINUE = "cont";
    public static final String OTHER = "other";
    public static final String START = "start";
    private static final Pattern TYPED_OUTCOME_PATTERN = Pattern.compile("(.+)-\\w+");

    public static String extractNameType(String str) {
        Matcher matcher = TYPED_OUTCOME_PATTERN.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    @Override // opennlp.tools.util.SequenceCodec
    public boolean areOutcomesCompatible(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : strArr) {
            if (str.endsWith("start")) {
                arrayList.add(str.substring(0, str.length() - 5));
            } else if (str.endsWith("cont")) {
                arrayList2.add(str.substring(0, str.length() - 4));
            } else if (!str.equals("other")) {
                return false;
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            if (!arrayList.contains((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // opennlp.tools.util.SequenceCodec
    public Span[] decode(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int i = -1;
        int i2 = -1;
        for (int i4 = 0; i4 < list.size(); i4++) {
            String str = list.get(i4);
            if (str.endsWith("start")) {
                if (i != -1) {
                    arrayList.add(new Span(i, i2, extractNameType(list.get(i4 - 1))));
                }
                i2 = i4 + 1;
                i = i4;
            } else if (str.endsWith("cont")) {
                i2 = i4 + 1;
            } else if (str.endsWith("other") && i != -1) {
                arrayList.add(new Span(i, i2, extractNameType(list.get(i4 - 1))));
                i = -1;
                i2 = -1;
            }
        }
        if (i != -1) {
            arrayList.add(new Span(i, i2, extractNameType((String) AbstractC0000a.m10g(list, 1))));
        }
        return (Span[]) arrayList.toArray(new Span[0]);
    }

    @Override // opennlp.tools.util.SequenceCodec
    /* JADX INFO: renamed from: createSequenceValidator, reason: merged with bridge method [inline-methods] */
    public SequenceValidator<String> createSequenceValidator2() {
        return new NameFinderSequenceValidator();
    }

    @Override // opennlp.tools.util.SequenceCodec
    public String[] encode(Span[] spanArr, int i) {
        String[] strArr = new String[i];
        Arrays.fill(strArr, "other");
        for (Span span : spanArr) {
            if (span.getType() == null) {
                strArr[span.getStart()] = "default-start";
            } else {
                strArr[span.getStart()] = AbstractC0541b.m756B(span.getType(), "-start");
            }
            int start = span.getStart();
            while (true) {
                start++;
                if (start < span.getEnd()) {
                    if (span.getType() == null) {
                        strArr[start] = "default-cont";
                    } else {
                        strArr[start] = AbstractC0541b.m756B(span.getType(), "-cont");
                    }
                }
            }
        }
        return strArr;
    }
}
