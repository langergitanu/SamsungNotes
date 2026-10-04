package opennlp.tools.parser.treeinsert;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import opennlp.tools.namefind.BilouCodec;
import opennlp.tools.parser.AbstractBottomUpParser;
import opennlp.tools.parser.AbstractContextGenerator;
import opennlp.tools.parser.Parse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CheckContextGenerator extends AbstractContextGenerator {
    private final Parse[] leftNodes;

    public CheckContextGenerator(Set<String> set) {
        this.punctSet = set;
        this.leftNodes = new Parse[2];
    }

    public String[] getContext(Object obj) {
        Object[] objArr = (Object[]) obj;
        return getContext((Parse) objArr[0], (Parse[]) objArr[1], ((Integer) objArr[2]).intValue(), ((Boolean) objArr[3]).booleanValue());
    }

    public String[] getContext(Parse parse, Parse[] parseArr, int i, boolean z) {
        List<Parse> list;
        Parse parse2;
        Collection<Parse> nextPunctuationSet;
        ArrayList arrayList = new ArrayList(100);
        arrayList.add("default");
        Parse[] parseArrCollapsePunctuation = AbstractBottomUpParser.collapsePunctuation(parse.getChildren(), this.punctSet);
        Parse parse3 = parseArrCollapsePunctuation[0];
        Parse parse4 = parseArrCollapsePunctuation[parseArrCollapsePunctuation.length - 1];
        String type = parse.getType();
        checkcons(parse3, "begin", type, arrayList);
        checkcons(parse4, BilouCodec.LAST, type, arrayList);
        String strM772n = AbstractC0541b.m772n("p=", production(parse, false));
        String str = "pp=" + production(parse, true);
        arrayList.add(strM772n);
        arrayList.add(str);
        Collection<Parse> nextPunctuationSet2 = parseArr[i].getNextPunctuationSet();
        Collection<Parse> previousPunctuationSet = parseArr[i].getPreviousPunctuationSet();
        if (i == 0) {
            list = Collections.EMPTY_LIST;
        } else {
            List<Parse> rightFrontier = Parser.getRightFrontier(parseArr[0], this.punctSet);
            if (z) {
                int iIndexOf = rightFrontier.indexOf(parse);
                if (iIndexOf == -1) {
                    throw new RuntimeException("Parent not found in right frontier:" + parse + " rf=" + rightFrontier);
                }
                for (int i2 = 0; i2 <= iIndexOf; i2++) {
                    rightFrontier.remove(0);
                }
            }
            list = rightFrontier;
        }
        getFrontierNodes(list, this.leftNodes);
        Parse[] parseArr2 = this.leftNodes;
        Parse parse5 = parseArr2[0];
        Parse parse6 = parseArr2[1];
        int length = parseArr.length;
        Collection<Parse> previousPunctuationSet2 = parse5 != null ? parse5.getPreviousPunctuationSet() : null;
        int i4 = i + 1;
        if (i4 < length) {
            Parse parse7 = parseArr[i4];
            nextPunctuationSet = parse7.getNextPunctuationSet();
            parse2 = parse7;
        } else {
            parse2 = null;
            nextPunctuationSet = null;
        }
        int i5 = i + 2;
        Parse parse8 = i5 < length ? parseArr[i5] : null;
        surround(parse5, -1, type, previousPunctuationSet, arrayList);
        surround(parse6, -2, type, previousPunctuationSet2, arrayList);
        surround(parse2, 1, type, nextPunctuationSet2, arrayList);
        surround(parse8, 2, type, nextPunctuationSet, arrayList);
        return (String[]) arrayList.toArray(new String[0]);
    }
}
