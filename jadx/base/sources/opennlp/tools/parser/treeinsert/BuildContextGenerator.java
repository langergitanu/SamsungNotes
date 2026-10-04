package opennlp.tools.parser.treeinsert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import opennlp.tools.parser.AbstractContextGenerator;
import opennlp.tools.parser.Cons;
import opennlp.tools.parser.Parse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BuildContextGenerator extends AbstractContextGenerator {
    private final Parse[] leftNodes = new Parse[2];

    public String[] getContext(Object obj) {
        Object[] objArr = (Object[]) obj;
        return getContext((Parse[]) objArr[0], ((Integer) objArr[1]).intValue());
    }

    public String[] getContext(Parse[] parseArr, int i) {
        List<Parse> rightFrontier;
        int length = parseArr.length;
        Parse parse = parseArr[i];
        int i2 = i + 1;
        Parse parse2 = i2 < length ? parseArr[i2] : null;
        int i4 = i + 2;
        Parse parse3 = i4 < length ? parseArr[i4] : null;
        Collection<Parse> previousPunctuationSet = parse.getPreviousPunctuationSet();
        Collection<Parse> nextPunctuationSet = parse.getNextPunctuationSet();
        Collection<Parse> nextPunctuationSet2 = parse2 != null ? parse2.getNextPunctuationSet() : null;
        if (i == 0) {
            rightFrontier = Collections.EMPTY_LIST;
        } else {
            rightFrontier = Parser.getRightFrontier(parseArr[0], Collections.EMPTY_SET);
        }
        List<Parse> list = rightFrontier;
        getFrontierNodes(list, this.leftNodes);
        Parse[] parseArr2 = this.leftNodes;
        Parse parse4 = parseArr2[0];
        Parse parse5 = parseArr2[1];
        Collection<Parse> previousPunctuationSet2 = parse4 != null ? parse4.getPreviousPunctuationSet() : null;
        String strCons = cons(parse5, -2);
        String strCons2 = cons(parse4, -1);
        String strCons3 = cons(parse, 0);
        String strCons4 = cons(parse2, 1);
        String strCons5 = cons(parse3, 2);
        String strConsbo = consbo(parse5, -2);
        String strConsbo2 = consbo(parse4, -1);
        String strConsbo3 = consbo(parse, 0);
        String strConsbo4 = consbo(parse2, 1);
        String strConsbo5 = consbo(parse3, 2);
        Collection<Parse> collection = nextPunctuationSet2;
        Cons cons = new Cons(strCons, strConsbo, -2, true);
        Cons cons2 = new Cons(strCons2, strConsbo2, -1, true);
        Cons cons3 = new Cons(strCons3, strConsbo3, 0, true);
        Cons cons4 = new Cons(strCons4, strConsbo4, 1, true);
        Cons cons5 = new Cons(strCons5, strConsbo5, 2, true);
        ArrayList arrayList = new ArrayList();
        arrayList.add("default");
        arrayList.add(strCons);
        arrayList.add(strConsbo);
        arrayList.add(strCons2);
        arrayList.add(strConsbo2);
        arrayList.add(strCons3);
        arrayList.add(strConsbo3);
        arrayList.add(strCons4);
        arrayList.add(strConsbo4);
        arrayList.add(strCons5);
        arrayList.add(strConsbo5);
        cons2(arrayList, cons3, cons4, nextPunctuationSet, true);
        cons2(arrayList, cons2, cons3, previousPunctuationSet, true);
        cons3(arrayList, cons3, cons4, cons5, nextPunctuationSet, collection, true, true, true);
        cons3(arrayList, cons, cons2, cons3, previousPunctuationSet2, previousPunctuationSet, true, true, true);
        cons3(arrayList, cons2, cons3, cons4, previousPunctuationSet, previousPunctuationSet, true, true, true);
        if (list.isEmpty()) {
            arrayList.add("eos," + strCons3);
            arrayList.add("eos," + strConsbo3);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
