package opennlp.tools.parser.chunking;

import androidx.compose.runtime.AbstractC1974b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import opennlp.tools.namefind.BilouCodec;
import opennlp.tools.parser.AbstractContextGenerator;
import opennlp.tools.parser.Parse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CheckContextGenerator extends AbstractContextGenerator {
    public String[] getContext(Object obj) {
        Object[] objArr = (Object[]) obj;
        return getContext((Parse[]) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
    }

    public String[] getContext(Parse[] parseArr, String str, int i, int i2) {
        Parse parse;
        Collection<Parse> previousPunctuationSet;
        Parse parse2;
        Collection<Parse> nextPunctuationSet;
        int length = parseArr.length;
        ArrayList arrayList = new ArrayList(100);
        arrayList.add("default");
        arrayList.add("fl=" + parseArr[0].getLabel());
        Parse parse3 = parseArr[i];
        Parse parse4 = parseArr[i2];
        checkcons(parse3, "begin", str, arrayList);
        checkcons(parse4, BilouCodec.LAST, str, arrayList);
        StringBuilder sb = new StringBuilder(20);
        StringBuilder sb2 = new StringBuilder(20);
        sb.append("p=");
        sb.append(str);
        sb.append("->");
        AbstractC1974b.m1332y(sb2, "pp=", str, "->");
        for (int i4 = i; i4 < i2; i4++) {
            Parse parse5 = parseArr[i4];
            checkcons(parse5, parse4, str, arrayList);
            sb.append(parse5.getType());
            sb.append(",");
            sb2.append(parse5.getType());
            sb2.append(",");
            Collection<Parse> nextPunctuationSet2 = parse5.getNextPunctuationSet();
            if (nextPunctuationSet2 != null) {
                Iterator<Parse> it = nextPunctuationSet2.iterator();
                while (it.hasNext()) {
                    sb2.append(it.next().getType());
                    sb2.append(",");
                }
            }
        }
        sb.append(parse4.getType());
        sb2.append(parse4.getType());
        arrayList.add(sb.toString());
        arrayList.add(sb2.toString());
        Collection<Parse> nextPunctuationSet3 = parseArr[i2].getNextPunctuationSet();
        Collection<Parse> previousPunctuationSet2 = parseArr[i].getPreviousPunctuationSet();
        int i5 = i - 2;
        Parse parse6 = i5 >= 0 ? parseArr[i5] : null;
        int i6 = i - 1;
        if (i6 >= 0) {
            parse = parseArr[i6];
            previousPunctuationSet = parse.getPreviousPunctuationSet();
        } else {
            parse = null;
            previousPunctuationSet = null;
        }
        int i7 = i2 + 1;
        if (i7 < length) {
            parse2 = parseArr[i7];
            nextPunctuationSet = parse2.getNextPunctuationSet();
        } else {
            parse2 = null;
            nextPunctuationSet = null;
        }
        int i8 = i2 + 2;
        Parse parse7 = i8 < length ? parseArr[i8] : null;
        surround(parse, -1, str, previousPunctuationSet2, arrayList);
        surround(parse6, -2, str, previousPunctuationSet, arrayList);
        surround(parse2, 1, str, nextPunctuationSet3, arrayList);
        surround(parse7, 2, str, nextPunctuationSet, arrayList);
        return (String[]) arrayList.toArray(new String[0]);
    }
}
