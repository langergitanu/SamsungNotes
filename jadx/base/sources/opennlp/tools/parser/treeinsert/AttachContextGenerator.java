package opennlp.tools.parser.treeinsert;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import opennlp.tools.parser.AbstractContextGenerator;
import opennlp.tools.parser.Cons;
import opennlp.tools.parser.Parse;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AttachContextGenerator extends AbstractContextGenerator {
    public AttachContextGenerator(Set<String> set) {
        this.punctSet = set;
    }

    private boolean containsPunct(Collection<Parse> collection, String str) {
        if (collection == null) {
            return false;
        }
        Iterator<Parse> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next().getType().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public String[] getContext(Object obj) {
        Object[] objArr = (Object[]) obj;
        return getContext((Parse[]) objArr[0], ((Integer) objArr[1]).intValue(), (List) objArr[2], ((Integer) objArr[3]).intValue());
    }

    public String[] getContext(Parse[] parseArr, int i, List<Parse> list, int i2) {
        ArrayList arrayList = new ArrayList(100);
        Parse parse = list.get(i2);
        int i4 = i2 + 1;
        Parse parse2 = i4 < list.size() ? list.get(i4) : null;
        Parse parse3 = list.size() > 0 ? list.get(0) : null;
        Parse parse4 = parseArr[i];
        int i5 = i + 1;
        Parse parse5 = i5 < parseArr.length ? parseArr[i5] : null;
        Collection<Parse> previousPunctuationSet = parse.getPreviousPunctuationSet();
        Collection<Parse> previousPunctuationSet2 = parse4.getPreviousPunctuationSet();
        Collection<Parse> nextPunctuationSet = parse4.getNextPunctuationSet();
        String strCons = cons(parse2, -3);
        String strCons2 = cons(parse, -2);
        String strCons3 = cons(parse3, -1);
        String strCons4 = cons(parse4, 0);
        String strCons5 = cons(parse5, 1);
        String strConsbo = consbo(parse2, -3);
        String strConsbo2 = consbo(parse, -2);
        String strConsbo3 = consbo(parse3, -1);
        String strConsbo4 = consbo(parse4, 0);
        String strConsbo5 = consbo(parse5, 1);
        Cons cons = new Cons(strCons, strConsbo, -3, true);
        Cons cons2 = new Cons(strCons2, strConsbo2, -2, true);
        Cons cons3 = new Cons(strCons3, strConsbo3, -1, true);
        Cons cons4 = new Cons(strCons4, strConsbo4, 0, true);
        Cons cons5 = new Cons(strCons5, strConsbo5, 1, true);
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
        String strProduction = production(parse, false);
        arrayList.add("pn=" + strProduction);
        arrayList.add("pd=" + strProduction + "," + parse4.getType());
        String type = parse.getType();
        String type2 = parse.getType();
        String type3 = parse4.getType();
        StringBuilder sbM16m = AbstractC0000a.m16m("ps=", type, "->", type2, ",");
        sbM16m.append(type3);
        arrayList.add(sbM16m.toString());
        if (previousPunctuationSet2 != null) {
            Iterator<Parse> it = previousPunctuationSet2.iterator();
            while (it.hasNext()) {
                it.next().getType();
            }
        }
        cons2(arrayList, cons, cons4, previousPunctuationSet2, true);
        cons2(arrayList, cons2, cons4, previousPunctuationSet2, true);
        cons2(arrayList, cons3, cons4, previousPunctuationSet2, true);
        cons2(arrayList, cons4, cons5, nextPunctuationSet, true);
        cons3(arrayList, cons2, cons3, cons4, null, previousPunctuationSet2, true, true, true);
        cons3(arrayList, cons2, cons4, cons5, previousPunctuationSet2, nextPunctuationSet, true, true, true);
        cons3(arrayList, cons, cons2, cons4, null, previousPunctuationSet2, true, true, true);
        int headIndex = parse4.getHeadIndex() - parse.getHeadIndex();
        arrayList.add("hd=" + headIndex);
        arrayList.add("nd=" + i2);
        arrayList.add("nd=" + parse4.getType() + Extension.DOT + i2);
        arrayList.add("hd=" + parse4.getType() + Extension.DOT + headIndex);
        if (containsPunct(previousPunctuationSet2, "''") && containsPunct(previousPunctuationSet, "``")) {
            arrayList.add("quotematch");
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
