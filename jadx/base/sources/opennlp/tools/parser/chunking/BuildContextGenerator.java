package opennlp.tools.parser.chunking;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.ArrayList;
import java.util.Collection;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.parser.AbstractBottomUpParser;
import opennlp.tools.parser.AbstractContextGenerator;
import opennlp.tools.parser.Cons;
import opennlp.tools.parser.Parse;
import opennlp.tools.util.StringList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BuildContextGenerator extends AbstractContextGenerator {
    private String[] bigram;
    private Dictionary dict;
    private String[] trigram;
    private String[] unigram;

    public BuildContextGenerator() {
        this.zeroBackOff = false;
        this.useLabel = true;
    }

    public String[] getContext(Object obj) {
        Object[] objArr = (Object[]) obj;
        return getContext((Parse[]) objArr[0], ((Integer) objArr[1]).intValue());
    }

    public String[] getContext(Parse[] parseArr, int i) {
        Parse parse;
        Collection<Parse> previousPunctuationSet;
        Parse parse2;
        Collection<Parse> nextPunctuationSet;
        Collection<Parse> collection;
        Collection<Parse> collection2;
        Collection<Parse> collection3;
        int i2;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean zContains;
        boolean z13;
        boolean zContains2;
        boolean z14;
        boolean zContains3;
        boolean z15;
        boolean zContains4;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean zContains5;
        boolean zContains6;
        ArrayList arrayList = new ArrayList(100);
        int length = parseArr.length;
        int i5 = i - 2;
        Parse parse3 = i5 >= 0 ? parseArr[i5] : null;
        int i6 = i - 1;
        if (i6 >= 0) {
            parse = parseArr[i6];
            previousPunctuationSet = parse.getPreviousPunctuationSet();
        } else {
            parse = null;
            previousPunctuationSet = null;
        }
        Parse parse4 = parseArr[i];
        Collection<Parse> previousPunctuationSet2 = parse4.getPreviousPunctuationSet();
        Collection<Parse> nextPunctuationSet2 = parse4.getNextPunctuationSet();
        int i7 = i + 1;
        if (i7 < length) {
            parse2 = parseArr[i7];
            nextPunctuationSet = parse2.getNextPunctuationSet();
        } else {
            parse2 = null;
            nextPunctuationSet = null;
        }
        int i8 = i + 2;
        Parse parse5 = i8 < length ? parseArr[i8] : null;
        if (this.dict != null) {
            if (parse3 != null) {
                this.unigram[0] = parse3.getHead().getCoveredText();
                i2 = 2;
                collection = nextPunctuationSet2;
                zContains = this.dict.contains(new StringList(this.unigram));
            } else {
                collection = nextPunctuationSet2;
                i2 = 2;
                zContains = true;
            }
            if (parse5 != null) {
                this.unigram[0] = parse5.getHead().getCoveredText();
                z13 = zContains;
                zContains2 = this.dict.contains(new StringList(this.unigram));
            } else {
                z13 = zContains;
                zContains2 = true;
            }
            this.unigram[0] = parse4.getHead().getCoveredText();
            boolean z19 = zContains2;
            boolean zContains7 = this.dict.contains(new StringList(this.unigram));
            if (parse3 == null || parse == null) {
                z14 = zContains7;
                zContains3 = true;
                z15 = true;
            } else {
                this.bigram[0] = parse3.getHead().getCoveredText();
                this.bigram[1] = parse.getHead().getCoveredText();
                z14 = zContains7;
                boolean zContains8 = this.dict.contains(new StringList(this.bigram));
                this.trigram[0] = parse3.getHead().getCoveredText();
                this.trigram[1] = parse.getHead().getCoveredText();
                this.trigram[i2] = parse4.getHead().getCoveredText();
                z15 = zContains8;
                zContains3 = this.dict.contains(new StringList(this.trigram));
            }
            if (parse == null || parse2 == null) {
                z9 = zContains3;
                zContains4 = true;
            } else {
                this.trigram[0] = parse.getHead().getCoveredText();
                this.trigram[1] = parse4.getHead().getCoveredText();
                this.trigram[i2] = parse2.getHead().getCoveredText();
                z9 = zContains3;
                zContains4 = this.dict.contains(new StringList(this.trigram));
            }
            if (parse != null) {
                this.unigram[0] = parse.getHead().getCoveredText();
                boolean z20 = zContains4;
                boolean zContains9 = this.dict.contains(new StringList(this.unigram));
                z18 = z15 && zContains9 && z13;
                boolean z21 = z9 && (zContains9 & z13) && z14;
                z8 = z20 && zContains9 && z14;
                z17 = zContains9;
                this.bigram[0] = parse.getHead().getCoveredText();
                this.bigram[1] = parse4.getHead().getCoveredText();
                collection2 = previousPunctuationSet2;
                collection3 = nextPunctuationSet;
                z16 = this.dict.contains(new StringList(this.bigram)) && z17 && z14;
                z9 = z21;
            } else {
                boolean z22 = zContains4;
                collection2 = previousPunctuationSet2;
                collection3 = nextPunctuationSet;
                z16 = true;
                z17 = true;
                z18 = z15;
                z8 = z22;
            }
            if (parse2 == null || parse5 == null) {
                z10 = z16;
                zContains5 = true;
                zContains6 = true;
            } else {
                this.bigram[0] = parse2.getHead().getCoveredText();
                this.bigram[1] = parse5.getHead().getCoveredText();
                zContains6 = this.dict.contains(new StringList(this.bigram));
                this.trigram[0] = parse4.getHead().getCoveredText();
                this.trigram[1] = parse2.getHead().getCoveredText();
                this.trigram[i2] = parse5.getHead().getCoveredText();
                z10 = z16;
                zContains5 = this.dict.contains(new StringList(this.trigram));
            }
            if (parse2 != null) {
                this.unigram[0] = parse2.getHead().getCoveredText();
                boolean z23 = zContains5;
                boolean zContains10 = this.dict.contains(new StringList(this.unigram));
                boolean z24 = zContains6 && zContains10 && z19;
                boolean z25 = z23 && zContains10 && z19 && z14;
                boolean z26 = z8 && z14 && z17 && zContains10;
                this.bigram[0] = parse4.getHead().getCoveredText();
                this.bigram[1] = parse2.getHead().getCoveredText();
                z12 = z24;
                z11 = z25;
                z7 = this.dict.contains(new StringList(this.bigram)) && z14 && zContains10;
                z = z13;
                z6 = z18;
                z4 = z19;
                z8 = z26;
                z2 = z14;
                z5 = z17;
                z3 = zContains10;
                i4 = length;
            } else {
                z11 = zContains5;
                z12 = zContains6;
                z3 = true;
                z = z13;
                z2 = z14;
                z5 = z17;
                z6 = z18;
                i4 = length;
                z4 = z19;
                z7 = true;
            }
        } else {
            collection = nextPunctuationSet2;
            collection2 = previousPunctuationSet2;
            collection3 = nextPunctuationSet;
            i2 = 2;
            i4 = length;
            z = true;
            z2 = true;
            z3 = true;
            z4 = true;
            z5 = true;
            z6 = true;
            z7 = true;
            z8 = true;
            z9 = true;
            z10 = true;
            z11 = true;
            z12 = true;
        }
        String strCons = cons(parse3, -2);
        Collection<Parse> collection4 = previousPunctuationSet;
        String strCons2 = cons(parse, -1);
        String strCons3 = cons(parse4, 0);
        String strCons4 = cons(parse2, 1);
        int i9 = i2;
        boolean z27 = z4;
        String strCons5 = cons(parse5, i9);
        String strConsbo = consbo(parse3, -2);
        String strConsbo2 = consbo(parse, -1);
        String strConsbo3 = consbo(parse4, 0);
        String strConsbo4 = consbo(parse2, 1);
        String strConsbo5 = consbo(parse5, 2);
        Cons cons = new Cons(strCons, strConsbo, -2, z);
        boolean z28 = z;
        Cons cons2 = new Cons(strCons2, strConsbo2, -1, z5);
        Cons cons3 = new Cons(strCons3, strConsbo3, 0, z2);
        Cons cons4 = new Cons(strCons4, strConsbo4, 1, z3);
        boolean z29 = z3;
        boolean z30 = z2;
        Cons cons5 = new Cons(strCons5, strConsbo5, 2, z27);
        arrayList.add("default");
        if (z30) {
            arrayList.add(strCons3);
        }
        arrayList.add(strConsbo3);
        if (z28) {
            arrayList.add(strCons);
        }
        arrayList.add(strConsbo);
        if (z5) {
            arrayList.add(strCons2);
        }
        arrayList.add(strConsbo2);
        if (z29) {
            arrayList.add(strCons4);
        }
        arrayList.add(strConsbo4);
        if (z27) {
            arrayList.add(strCons5);
        }
        arrayList.add(strConsbo5);
        boolean z31 = z7;
        cons2(arrayList, cons3, cons4, collection, z31);
        cons2(arrayList, cons2, cons3, collection2, z10);
        cons3(arrayList, cons3, cons4, cons5, collection, collection3, z11, z31, z12);
        boolean z32 = z10;
        Collection<Parse> collection5 = collection2;
        cons3(arrayList, cons, cons2, cons3, collection4, collection5, z9, z6, z32);
        cons3(arrayList, cons2, cons3, cons4, collection5, collection, z8, z32, z31);
        String type = parse4.getType();
        if (type.equals("-RRB-")) {
            int i10 = i6;
            while (true) {
                if (i10 < 0) {
                    break;
                }
                Parse parse6 = parseArr[i10];
                if (parse6.getType().equals("-LRB-")) {
                    arrayList.add("bracketsmatch");
                    break;
                }
                if (parse6.getLabel().startsWith(AbstractBottomUpParser.START)) {
                    break;
                }
                i10--;
            }
        }
        if (type.equals("-RCB-")) {
            int i11 = i6;
            while (true) {
                if (i11 < 0) {
                    break;
                }
                Parse parse7 = parseArr[i11];
                if (parse7.getType().equals("-LCB-")) {
                    arrayList.add("bracketsmatch");
                    break;
                }
                if (parse7.getLabel().startsWith(AbstractBottomUpParser.START)) {
                    break;
                }
                i11--;
            }
        }
        if (type.equals("''")) {
            int i12 = i6;
            while (true) {
                if (i12 < 0) {
                    break;
                }
                Parse parse8 = parseArr[i12];
                if (parse8.getType().equals("``")) {
                    arrayList.add("quotesmatch");
                    break;
                }
                if (parse8.getLabel().startsWith(AbstractBottomUpParser.START)) {
                    break;
                }
                i12--;
            }
        }
        if (type.equals("'")) {
            int i13 = i6;
            while (true) {
                if (i13 < 0) {
                    break;
                }
                Parse parse9 = parseArr[i13];
                if (parse9.getType().equals("`")) {
                    arrayList.add("quotesmatch");
                    break;
                }
                if (parse9.getLabel().startsWith(AbstractBottomUpParser.START)) {
                    break;
                }
                i13--;
            }
        }
        if (type.equals(",")) {
            int i14 = i6;
            while (true) {
                if (i14 < 0) {
                    break;
                }
                Parse parse10 = parseArr[i14];
                if (parse10.getType().equals(",")) {
                    arrayList.add("iscomma");
                    break;
                }
                if (parse10.getLabel().startsWith(AbstractBottomUpParser.START)) {
                    break;
                }
                i14--;
            }
        }
        if (type.equals(Extension.DOT) && i == i4 - 1) {
            int i15 = i6;
            while (true) {
                if (i15 < 0) {
                    break;
                }
                if (!parseArr[i15].getLabel().startsWith(AbstractBottomUpParser.START)) {
                    i15--;
                } else if (i15 == 0) {
                    arrayList.add("endofsentence");
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public BuildContextGenerator(Dictionary dictionary) {
        this();
        this.dict = dictionary;
        this.unigram = new String[1];
        this.bigram = new String[2];
        this.trigram = new String[3];
    }
}
