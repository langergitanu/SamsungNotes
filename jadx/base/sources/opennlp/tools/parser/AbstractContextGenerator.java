package opennlp.tools.parser;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.AbstractC12991c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractContextGenerator {
    protected static final String EOS = "eos";
    protected Set<String> punctSet;
    protected boolean useLabel;
    protected boolean zeroBackOff;

    public void checkcons(Parse parse, String str, String str2, List<String> list) {
        StringBuilder sb = new StringBuilder(20);
        sb.append("c");
        sb.append(str);
        sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
        sb.append(parse.getType());
        sb.append("|");
        sb.append(parse.getHead().getCoveredText());
        sb.append("|");
        sb.append(str2);
        list.add(sb.toString());
        sb.setLength(0);
        sb.append("c");
        sb.append(str);
        sb.append("*=");
        sb.append(parse.getType());
        sb.append("|");
        sb.append(str2);
        list.add(sb.toString());
    }

    public String cons(Parse parse, int i) {
        StringBuilder sb = new StringBuilder(20);
        sb.append(i);
        sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
        if (parse != null) {
            if (this.useLabel && i < 0) {
                sb.append(parse.getLabel());
                sb.append("|");
            }
            sb.append(parse.getType());
            sb.append("|");
            sb.append(parse.getHead().getCoveredText());
        } else {
            sb.append(EOS);
        }
        return sb.toString();
    }

    public void cons2(List<String> list, Cons cons, Cons cons2, Collection<Parse> collection, boolean z) {
        if (collection == null) {
            if (z) {
                list.add(cons.cons + "," + cons2.cons);
            }
            if (cons2.unigram) {
                list.add(cons.consbo + "," + cons2.cons);
            }
            if (cons.unigram) {
                list.add(cons.cons + "," + cons2.consbo);
            }
            list.add(cons.consbo + "," + cons2.consbo);
            return;
        }
        for (Parse parse : collection) {
            int i = cons2.index;
            if (i <= 0) {
                i--;
            }
            String strPunctbo = punctbo(parse, i);
            list.add(strPunctbo);
            if (cons.index == 0) {
                if (cons.unigram) {
                    list.add(cons.cons + "," + strPunctbo);
                }
                list.add(cons.consbo + "," + strPunctbo);
            }
            if (cons2.index == 0) {
                if (cons2.unigram) {
                    list.add(strPunctbo + "," + cons2.cons);
                }
                list.add(strPunctbo + "," + cons2.consbo);
            }
            if (z) {
                list.add(AbstractC2322a.m1622l(cons.cons, ",", strPunctbo, ",", cons2.cons));
            }
            if (cons2.unigram) {
                list.add(AbstractC2322a.m1622l(cons.consbo, ",", strPunctbo, ",", cons2.cons));
            }
            if (cons.unigram) {
                list.add(AbstractC2322a.m1622l(cons.cons, ",", strPunctbo, ",", cons2.consbo));
            }
            list.add(AbstractC2322a.m1622l(cons.consbo, ",", strPunctbo, ",", cons2.consbo));
        }
    }

    public void cons3(List<String> list, Cons cons, Cons cons2, Cons cons3, Collection<Parse> collection, Collection<Parse> collection2, boolean z, boolean z2, boolean z3) {
        if (collection != null && cons.index == -2) {
            for (Parse parse : collection) {
                int i = cons2.index;
                if (i <= 0) {
                    i--;
                }
                list.add(punctbo(parse, i));
            }
        }
        if (collection2 == null) {
            if (collection == null) {
                if (z) {
                    list.add(AbstractC2322a.m1622l(cons.cons, ",", cons2.cons, ",", cons3.cons));
                }
                if (z3) {
                    list.add(AbstractC2322a.m1622l(cons.consbo, ",", cons2.cons, ",", cons3.cons));
                }
                if (cons.unigram && cons3.unigram) {
                    list.add(AbstractC2322a.m1622l(cons.cons, ",", cons2.consbo, ",", cons3.cons));
                }
                if (z2) {
                    list.add(AbstractC2322a.m1622l(cons.cons, ",", cons2.cons, ",", cons3.consbo));
                }
                if (cons3.unigram) {
                    list.add(AbstractC2322a.m1622l(cons.consbo, ",", cons2.consbo, ",", cons3.cons));
                }
                if (cons2.unigram) {
                    list.add(AbstractC2322a.m1622l(cons.consbo, ",", cons2.cons, ",", cons3.consbo));
                }
                if (cons.unigram) {
                    list.add(AbstractC2322a.m1622l(cons.cons, ",", cons2.consbo, ",", cons3.consbo));
                }
                list.add(AbstractC2322a.m1622l(cons.consbo, ",", cons2.consbo, ",", cons3.consbo));
                return;
            }
            for (Parse parse2 : collection) {
                int i2 = cons2.index;
                if (i2 <= 0) {
                    i2--;
                }
                String strPunctbo = punctbo(parse2, i2);
                if (z) {
                    AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.cons, ",", strPunctbo, ",", cons2.cons), ",", cons3.cons, list);
                }
                if (z3) {
                    AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.consbo, ",", strPunctbo, ",", cons2.cons), ",", cons3.cons, list);
                }
                if (cons.unigram && cons3.unigram) {
                    AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.cons, ",", strPunctbo, ",", cons2.consbo), ",", cons3.cons, list);
                }
                if (z2) {
                    AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.cons, ",", strPunctbo, ",", cons2.cons), ",", cons3.consbo, list);
                }
                if (cons3.unigram) {
                    AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.consbo, ",", strPunctbo, ",", cons2.consbo), ",", cons3.cons, list);
                }
                if (cons2.unigram) {
                    AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.consbo, ",", strPunctbo, ",", cons2.cons), ",", cons3.consbo, list);
                }
                if (cons.unigram) {
                    AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.cons, ",", strPunctbo, ",", cons2.consbo), ",", cons3.consbo, list);
                }
                AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.consbo, ",", strPunctbo, ",", cons2.consbo), ",", cons3.consbo, list);
            }
            return;
        }
        if (cons3.index == 2) {
            Iterator<Parse> it = collection2.iterator();
            while (it.hasNext()) {
                list.add(punctbo(it.next(), cons3.index));
            }
        }
        if (collection == null) {
            for (Parse parse3 : collection2) {
                int i4 = cons3.index;
                if (i4 <= 0) {
                    i4--;
                }
                String strPunctbo2 = punctbo(parse3, i4);
                if (z) {
                    AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.cons, ",", cons2.cons, ",", strPunctbo2), ",", cons3.cons, list);
                }
                if (z3) {
                    AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.consbo, ",", cons2.cons, ",", strPunctbo2), ",", cons3.cons, list);
                }
                if (cons.unigram && cons3.unigram) {
                    AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.cons, ",", cons2.consbo, ",", strPunctbo2), ",", cons3.cons, list);
                }
                if (z2) {
                    AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.cons, ",", cons2.cons, ",", strPunctbo2), ",", cons3.consbo, list);
                }
                if (cons3.unigram) {
                    AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.consbo, ",", cons2.consbo, ",", strPunctbo2), ",", cons3.cons, list);
                }
                if (cons2.unigram) {
                    AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.consbo, ",", cons2.cons, ",", strPunctbo2), ",", cons3.consbo, list);
                }
                if (cons.unigram) {
                    AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.cons, ",", cons2.consbo, ",", strPunctbo2), ",", cons3.consbo, list);
                }
                AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.consbo, ",", cons2.consbo, ",", strPunctbo2), ",", cons3.consbo, list);
                if (this.zeroBackOff) {
                    if (z2) {
                        list.add(AbstractC2322a.m1622l(cons.cons, ",", cons2.cons, ",", strPunctbo2));
                    }
                    if (cons2.unigram) {
                        list.add(AbstractC2322a.m1622l(cons.consbo, ",", cons2.cons, ",", strPunctbo2));
                    }
                    if (cons.unigram) {
                        list.add(AbstractC2322a.m1622l(cons.cons, ",", cons2.consbo, ",", strPunctbo2));
                    }
                    list.add(AbstractC2322a.m1622l(cons.consbo, ",", cons2.consbo, ",", strPunctbo2));
                }
            }
            return;
        }
        for (Parse parse4 : collection2) {
            int i5 = cons3.index;
            if (i5 <= 0) {
                i5--;
            }
            String strPunctbo3 = punctbo(parse4, i5);
            for (Parse parse5 : collection) {
                int i6 = cons2.index;
                if (i6 <= 0) {
                    i6--;
                }
                String strPunctbo4 = punctbo(parse5, i6);
                if (z) {
                    list.add(AbstractC0541b.m776r(AbstractC2821a.m2228s(cons.cons, ",", strPunctbo4, ",", cons2.cons), ",", strPunctbo3, ",", cons3.cons));
                }
                if (z3) {
                    list.add(AbstractC0541b.m776r(AbstractC2821a.m2228s(cons.consbo, ",", strPunctbo4, ",", cons2.cons), ",", strPunctbo3, ",", cons3.cons));
                }
                if (cons.unigram && cons3.unigram) {
                    list.add(AbstractC0541b.m776r(AbstractC2821a.m2228s(cons.cons, ",", strPunctbo4, ",", cons2.consbo), ",", strPunctbo3, ",", cons3.cons));
                }
                if (z2) {
                    list.add(AbstractC0541b.m776r(AbstractC2821a.m2228s(cons.cons, ",", strPunctbo4, ",", cons2.cons), ",", strPunctbo3, ",", cons3.consbo));
                }
                if (cons3.unigram) {
                    list.add(AbstractC0541b.m776r(AbstractC2821a.m2228s(cons.consbo, ",", strPunctbo4, ",", cons2.consbo), ",", strPunctbo3, ",", cons3.cons));
                }
                if (cons2.unigram) {
                    list.add(AbstractC0541b.m776r(AbstractC2821a.m2228s(cons.consbo, ",", strPunctbo4, ",", cons2.cons), ",", strPunctbo3, ",", cons3.consbo));
                }
                if (cons.unigram) {
                    list.add(AbstractC0541b.m776r(AbstractC2821a.m2228s(cons.cons, ",", strPunctbo4, ",", cons2.consbo), ",", strPunctbo3, ",", cons3.consbo));
                }
                list.add(AbstractC0541b.m776r(AbstractC2821a.m2228s(cons.consbo, ",", strPunctbo4, ",", cons2.consbo), ",", strPunctbo3, ",", cons3.consbo));
                if (this.zeroBackOff) {
                    if (z2) {
                        AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.cons, ",", strPunctbo4, ",", cons2.cons), ",", strPunctbo3, list);
                    }
                    if (cons2.unigram) {
                        AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.consbo, ",", strPunctbo4, ",", cons2.cons), ",", strPunctbo3, list);
                    }
                    if (cons.unigram) {
                        AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.cons, ",", strPunctbo4, ",", cons2.consbo), ",", strPunctbo3, list);
                    }
                    AbstractC12991c.m13978B(AbstractC2821a.m2228s(cons.consbo, ",", strPunctbo4, ",", cons2.consbo), ",", strPunctbo3, list);
                }
            }
        }
    }

    public String consbo(Parse parse, int i) {
        StringBuilder sb = new StringBuilder(20);
        sb.append(i);
        sb.append("*=");
        if (parse != null) {
            if (this.useLabel && i < 0) {
                sb.append(parse.getLabel());
                sb.append("|");
            }
            sb.append(parse.getType());
        } else {
            sb.append(EOS);
        }
        return sb.toString();
    }

    public void getFrontierNodes(List<Parse> list, Parse[] parseArr) {
        int i = 0;
        int i2 = -1;
        for (Parse parse : list) {
            int headIndex = parse.getHeadIndex();
            if (headIndex != i2) {
                parseArr[i] = parse;
                i++;
                if (i == parseArr.length) {
                    break;
                } else {
                    i2 = headIndex;
                }
            }
        }
        while (i < parseArr.length) {
            parseArr[i] = null;
            i++;
        }
    }

    public String production(Parse parse, boolean z) {
        StringBuilder sb = new StringBuilder(20);
        sb.append(parse.getType());
        sb.append("->");
        Parse[] parseArrCollapsePunctuation = AbstractBottomUpParser.collapsePunctuation(parse.getChildren(), this.punctSet);
        int i = 0;
        while (i < parseArrCollapsePunctuation.length) {
            sb.append(parseArrCollapsePunctuation[i].getType());
            int i2 = i + 1;
            if (i2 != parseArrCollapsePunctuation.length) {
                sb.append(",");
                Collection<Parse> nextPunctuationSet = parseArrCollapsePunctuation[i].getNextPunctuationSet();
                if (z && nextPunctuationSet != null) {
                    Iterator<Parse> it = nextPunctuationSet.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().getType());
                        sb.append(",");
                    }
                }
            }
            i = i2;
        }
        return sb.toString();
    }

    public String punct(Parse parse, int i) {
        return i + MarketingConstants.REFERRER_DELIMITER_U003D + parse.getCoveredText();
    }

    public String punctbo(Parse parse, int i) {
        return i + MarketingConstants.REFERRER_DELIMITER_U003D + parse.getType();
    }

    public void surround(Parse parse, int i, String str, Collection<Parse> collection, List<String> list) {
        StringBuilder sb = new StringBuilder(20);
        sb.append("s");
        sb.append(i);
        sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
        if (collection == null) {
            if (parse != null) {
                sb.append(parse.getHead().getCoveredText());
                sb.append("|");
                sb.append(str);
                sb.append("|");
                sb.append(parse.getType());
            } else {
                sb.append(str);
                sb.append("|eos");
            }
            list.add(sb.toString());
            sb.setLength(0);
            sb.append("s");
            sb.append(i);
            sb.append("*=");
            if (parse != null) {
                sb.append(str);
                sb.append("|");
                sb.append(parse.getType());
            } else {
                AbstractC1974b.m1332y(sb, str, "|", EOS);
            }
            list.add(sb.toString());
            return;
        }
        for (Parse parse2 : collection) {
            if (parse != null) {
                sb.append(parse.getHead().getCoveredText());
                sb.append("|");
                sb.append(str);
                sb.append("|");
                sb.append(parse.getType());
                sb.append("|");
                sb.append(parse2.getType());
            } else {
                AbstractC2821a.m2207B(sb, str, "|", EOS, "|");
                sb.append(parse2.getType());
            }
            list.add(sb.toString());
            sb.setLength(0);
            sb.append("s");
            sb.append(i);
            sb.append("*=");
            if (parse != null) {
                sb.append(str);
                sb.append("|");
                sb.append(parse.getType());
                sb.append("|");
                sb.append(parse2.getType());
            } else {
                AbstractC2821a.m2207B(sb, str, "|", EOS, "|");
                sb.append(parse2.getType());
            }
            list.add(sb.toString());
            sb.setLength(0);
            sb.append("s");
            sb.append(i);
            sb.append("*=");
            sb.append(str);
            sb.append("|");
            sb.append(parse2.getType());
            list.add(sb.toString());
        }
    }

    public void checkcons(Parse parse, Parse parse2, String str, List<String> list) {
        StringBuilder sb = new StringBuilder(20);
        sb.append("cil=");
        sb.append(str);
        sb.append(",");
        sb.append(parse.getType());
        sb.append("|");
        sb.append(parse.getHead().getCoveredText());
        sb.append(",");
        sb.append(parse2.getType());
        sb.append("|");
        sb.append(parse2.getHead().getCoveredText());
        list.add(sb.toString());
        sb.setLength(0);
        sb.append("ci*l=");
        sb.append(str);
        sb.append(",");
        sb.append(parse.getType());
        sb.append(",");
        sb.append(parse2.getType());
        sb.append("|");
        sb.append(parse2.getHead().getCoveredText());
        list.add(sb.toString());
        sb.setLength(0);
        sb.append("cil*=");
        sb.append(str);
        sb.append(",");
        sb.append(parse.getType());
        sb.append("|");
        sb.append(parse.getHead().getCoveredText());
        sb.append(",");
        sb.append(parse2.getType());
        list.add(sb.toString());
        sb.setLength(0);
        sb.append("ci*l*=");
        sb.append(str);
        sb.append(",");
        sb.append(parse.getType());
        sb.append(",");
        sb.append(parse2.getType());
        list.add(sb.toString());
    }
}
