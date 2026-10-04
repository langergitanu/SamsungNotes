package opennlp.tools.parser.treeinsert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.p217ml.model.Event;
import opennlp.tools.parser.AbstractBottomUpParser;
import opennlp.tools.parser.AbstractParserEventStream;
import opennlp.tools.parser.HeadRules;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.ParserEventTypeEnum;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ParserEventStream extends AbstractParserEventStream {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) ParserEventStream.class);
    protected AttachContextGenerator attachContextGenerator;
    protected BuildContextGenerator buildContextGenerator;
    protected CheckContextGenerator checkContextGenerator;

    public ParserEventStream(ObjectStream<Parse> objectStream, HeadRules headRules, ParserEventTypeEnum parserEventTypeEnum, Dictionary dictionary) {
        super(objectStream, headRules, parserEventTypeEnum, dictionary);
    }

    private Map<Parse, Integer> getNonAdjoinedParent(Parse parse) {
        HashMap map = new HashMap();
        Parse parent = parse.getParent();
        map.put(parent, Integer.valueOf(indexOf(parse, parent)));
        while (true) {
            Parse parse2 = parent;
            Parse parse3 = parse;
            parse = parse2;
            if (!parse.getType().equals(parse3.getType())) {
                return map;
            }
            parent = parse.getParent();
            map.put(parent, Integer.valueOf(indexOf(parse, parent)));
        }
    }

    private int indexOf(Parse parse, Parse parse2) {
        Parse[] parseArrCollapsePunctuation = AbstractBottomUpParser.collapsePunctuation(parse2.getChildren(), this.punctSet);
        for (int i = 0; i < parseArrCollapsePunctuation.length; i++) {
            if (parse == parseArrCollapsePunctuation[i]) {
                return i;
            }
        }
        return -1;
    }

    private int nonPunctChildCount(Parse parse) {
        return AbstractBottomUpParser.collapsePunctuation(parse.getChildren(), this.punctSet).length;
    }

    @Override // opennlp.tools.parser.AbstractParserEventStream
    public void addParseEvents(List<Event> list, Parse[] parseArr) {
        String str;
        int i;
        Parse parse;
        ArrayList arrayList;
        String str2;
        int i2;
        Map<Parse, Integer> map;
        int i4;
        Map<Parse, Integer> map2;
        int i5;
        Parse parse2;
        Parse[] parseArr2 = parseArr;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Parse[] parseArr3 = new Parse[parseArr2.length];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            str = "c";
            if (i7 >= parseArr2.length) {
                break;
            }
            Parse parse3 = (Parse) parseArr2[i7].clone();
            parseArr3[i7] = parse3;
            parse3.setPrevPunctuation(parseArr2[i7].getPreviousPunctuationSet());
            parseArr3[i7].setNextPunctuation(parseArr2[i7].getNextPunctuationSet());
            parseArr3[i7].setLabel("c");
            parseArr2[i7].setLabel("c");
            i7++;
        }
        int i8 = 0;
        while (i8 < parseArr2.length) {
            Parse parse4 = parseArr2[i8];
            if (parse4.isPosTag()) {
                i = i6;
            } else {
                arrayList3.add(i6, parseArr2[i8]);
                i = 1;
            }
            for (Parse parent = parseArr2[i8].getParent(); !parent.getType().equals(AbstractBottomUpParser.TOP_NODE) && parent.getLabel() == null; parent = parent.getParent()) {
                if (!parse4.getType().equals(parent.getType())) {
                    Logger logger2 = logger;
                    if (logger2.isDebugEnabled()) {
                        logger2.debug("Build: {} for: {}", parent.getType(), parseArr3[i8]);
                    }
                    if (this.etype == ParserEventTypeEnum.BUILD) {
                        list.add(new Event(parent.getType(), this.buildContextGenerator.getContext(parseArr3, i8)));
                    }
                    int i9 = i + 1;
                    arrayList3.add(i, parent);
                    Parse parse5 = new Parse(parseArr3[i8].getText(), parseArr3[i8].getSpan(), parent.getType(), 1.0d, 0);
                    parse5.add(parseArr3[i8], this.rules);
                    parse5.setPrevPunctuation(parseArr3[i8].getPreviousPunctuationSet());
                    parse5.setNextPunctuation(parseArr3[i8].getNextPunctuationSet());
                    parseArr3[i8].setParent(parse5);
                    parseArr3[i8] = parse5;
                    parse5.setLabel(Parser.BUILT);
                    if (lastChild(parseArr2[i8], parent)) {
                        if (this.etype == ParserEventTypeEnum.CHECK) {
                            list.add(new Event(str, this.checkContextGenerator.getContext(parseArr3[i8], parseArr3, i8, false)));
                        }
                        parseArr3[i8].setLabel(str);
                        parent.setLabel(str);
                    } else {
                        if (this.etype == ParserEventTypeEnum.CHECK) {
                            list.add(new Event("i", this.checkContextGenerator.getContext(parseArr3[i8], parseArr3, i8, false)));
                        }
                        parseArr3[i8].setLabel("i");
                        parent.setLabel(str);
                    }
                    parseArr2[i8] = parent;
                    i = i9;
                }
                parent.setLabel(Parser.BUILT);
                parse4 = parent;
            }
            if (this.etype == ParserEventTypeEnum.BUILD) {
                list.add(new Event("d", this.buildContextGenerator.getContext(parseArr3, i8)));
            }
            if (i8 == 0) {
                new Parse(parseArr3[i8].getText(), new Span(0, parseArr3[i8].getText().length()), AbstractBottomUpParser.TOP_NODE, 1.0d, 0).insert(parseArr3[i8]);
                i4 = 0;
            } else {
                List<Parse> rightFrontier = Parser.getRightFrontier(parseArr3[0], this.punctSet);
                if (rightFrontier.size() != arrayList2.size()) {
                    logger.error("Frontiers mis-aligned: {} != {} {} {}", Integer.valueOf(rightFrontier.size()), Integer.valueOf(arrayList2.size()), rightFrontier, arrayList2);
                    System.exit(1);
                }
                Map<Parse, Integer> nonAdjoinedParent = getNonAdjoinedParent(parseArr2[i8]);
                Parse parse6 = null;
                int i10 = -1;
                int i11 = 0;
                Object obj = null;
                while (true) {
                    parse = parse6;
                    if (i11 >= rightFrontier.size()) {
                        arrayList = arrayList3;
                        str2 = str;
                        i2 = i10;
                        map = nonAdjoinedParent;
                        break;
                    }
                    Parse parse7 = (Parse) arrayList2.get(i11);
                    Parse parse8 = rightFrontier.get(i11);
                    Object obj2 = obj;
                    if (Parser.checkComplete && str.equals(parse8.getLabel())) {
                        Logger logger3 = logger;
                        if (logger3.isDebugEnabled()) {
                            arrayList = arrayList3;
                            i2 = i10;
                            map = nonAdjoinedParent;
                            logger3.debug("Skipping ({}): {},{} {} :for {} {} -> {}", Integer.valueOf(i11), parse8.getType(), parse8.getPreviousPunctuationSet(), parse8, parseArr3[i8].getType(), parseArr3[i8], nonAdjoinedParent);
                        } else {
                            arrayList = arrayList3;
                            i2 = i10;
                            map = nonAdjoinedParent;
                        }
                        str2 = str;
                        parse2 = parse8;
                    } else {
                        arrayList = arrayList3;
                        i2 = i10;
                        map = nonAdjoinedParent;
                        Integer num = map.get(parse7);
                        Logger logger4 = logger;
                        if (logger4.isDebugEnabled()) {
                            str2 = str;
                            parse2 = parse8;
                            logger4.debug("Looking at attachment site ({}): {} ci={} cs={}, {} :for {} {} -> {}", Integer.valueOf(i11), parse8.getType(), num, Integer.valueOf(nonPunctChildCount(parse8)), parse8, parseArr3[i8].getType(), parseArr3[i8], map);
                        } else {
                            str2 = str;
                            parse2 = parse8;
                        }
                        if (parse == null && num != null && num.intValue() == nonPunctChildCount(parse2)) {
                            if (this.etype == ParserEventTypeEnum.ATTACH) {
                                list.add(new Event("d", this.attachContextGenerator.getContext(parseArr3, i8, rightFrontier, i11)));
                            }
                            obj2 = "d";
                            parse = parse2;
                            i2 = i11;
                        }
                    }
                    if (Parser.checkComplete && parse2.getLabel().equals("i")) {
                        Logger logger5 = logger;
                        if (logger5.isDebugEnabled()) {
                            logger5.debug("breaking on incomplete: {} {}", parse2.getType(), parse2);
                        }
                        obj = obj2;
                    } else {
                        i11++;
                        nonAdjoinedParent = map;
                        str = str2;
                        parse6 = parse;
                        obj = obj2;
                        i10 = i2;
                        arrayList3 = arrayList;
                    }
                }
                int i12 = i2;
                int i13 = 0;
                while (true) {
                    if (i13 >= rightFrontier.size()) {
                        break;
                    }
                    Parse parse9 = (Parse) arrayList2.get(i13);
                    Parse parse10 = rightFrontier.get(i13);
                    Object obj3 = obj;
                    if (parse == null && map.containsKey(parse9.getParent())) {
                        map2 = map;
                        if (parse9.getType().equals(parse9.getParent().getType())) {
                            if (this.etype == ParserEventTypeEnum.ATTACH) {
                                list.add(new Event("s", this.attachContextGenerator.getContext(parseArr3, i8, rightFrontier, i13)));
                            }
                            parseArr[i8].getParent().setLabel(Parser.BUILT);
                            i12 = i13;
                            i5 = i12;
                            parse = parse10;
                            obj = "s";
                        }
                        if (Parser.checkComplete || !parse10.getLabel().equals("i")) {
                            i13 = i5 + 1;
                            map = map2;
                        } else {
                            Logger logger6 = logger;
                            if (logger6.isDebugEnabled()) {
                                logger6.debug("breaking on incomplete: {} {}", parse10.getType(), parse10);
                            }
                        }
                    } else {
                        map2 = map;
                    }
                    if (i13 != i12 && this.etype == ParserEventTypeEnum.ATTACH) {
                        i5 = i13;
                        list.add(new Event("n", this.attachContextGenerator.getContext(parseArr3, i8, rightFrontier, i13)));
                    } else {
                        i5 = i13;
                    }
                    obj = obj3;
                    if (Parser.checkComplete) {
                    }
                    i13 = i5 + 1;
                    map = map2;
                }
                Parse parse11 = parse;
                if (parse11 == null) {
                    throw new RuntimeException("No Attachment: " + parseArr[i8]);
                }
                if ("d".equals(obj)) {
                    Parse parse12 = parseArr3[i8];
                    Logger logger7 = logger;
                    if (logger7.isDebugEnabled()) {
                        logger7.debug("daughter attach a={}:{} d={} com={}", parse11.getType(), parse11, parse12, Boolean.valueOf(lastChild(parseArr[i8], (Parse) arrayList2.get(i12))));
                    }
                    parse11.add(parse12, this.rules);
                    parse12.setParent(parse11);
                    if (lastChild(parseArr[i8], (Parse) arrayList2.get(i12))) {
                        if (this.etype == ParserEventTypeEnum.CHECK) {
                            str = str2;
                            list.add(new Event(str, this.checkContextGenerator.getContext(parse11, parseArr3, i8, true)));
                        } else {
                            str = str2;
                        }
                        parse11.setLabel(str);
                    } else {
                        str = str2;
                        if (this.etype == ParserEventTypeEnum.CHECK) {
                            list.add(new Event("i", this.checkContextGenerator.getContext(parse11, parseArr3, i8, true)));
                        }
                    }
                } else {
                    str = str2;
                    if ("s".equals(obj)) {
                        arrayList2.set(i12, ((Parse) arrayList2.get(i12)).getParent());
                        Parse parse13 = parseArr3[i8];
                        Logger logger8 = logger;
                        if (logger8.isDebugEnabled()) {
                            logger8.debug("sister attach a={}:{} s={} ap={} com={}", parse11.getType(), parse11, parse13, parse11.getParent(), Boolean.valueOf(lastChild(parseArr[i8], (Parse) arrayList2.get(i12))));
                        }
                        Parse parseAdjoin = parse11.getParent().adjoin(parse13, this.rules);
                        parseAdjoin.setParent(parse11.getParent());
                        parse11.setParent(parseAdjoin);
                        parse13.setParent(parseAdjoin);
                        if (parse11 == parseArr3[0]) {
                            parseArr3[0] = parseAdjoin;
                        }
                        if (lastChild(parseArr[i8], (Parse) arrayList2.get(i12))) {
                            if (this.etype == ParserEventTypeEnum.CHECK) {
                                list.add(new Event(str, this.checkContextGenerator.getContext(parseAdjoin, parseArr3, i8, true)));
                            }
                            parseAdjoin.setLabel(str);
                        } else {
                            if (this.etype == ParserEventTypeEnum.CHECK) {
                                list.add(new Event("i", this.checkContextGenerator.getContext(parseAdjoin, parseArr3, i8, true)));
                            }
                            parseAdjoin.setLabel("i");
                        }
                    }
                }
                int i14 = 0;
                while (true) {
                    i4 = 0;
                    if (i14 >= i12) {
                        break;
                    }
                    arrayList2.remove(0);
                    i14++;
                }
                arrayList3 = arrayList;
            }
            arrayList2.addAll(i4, arrayList3);
            arrayList3.clear();
            i8++;
            i6 = i4;
            parseArr2 = parseArr;
        }
    }

    @Override // opennlp.tools.parser.AbstractParserEventStream
    public void init() {
        this.buildContextGenerator = new BuildContextGenerator();
        this.attachContextGenerator = new AttachContextGenerator(this.punctSet);
        this.checkContextGenerator = new CheckContextGenerator(this.punctSet);
    }

    @Override // opennlp.tools.parser.AbstractParserEventStream
    public boolean lastChild(Parse parse, Parse parse2) {
        boolean zLastChild = super.lastChild(parse, parse2);
        while (!zLastChild) {
            Parse parent = parse.getParent();
            if (parent == parse2 || !parent.getType().equals(parse.getType())) {
                break;
            }
            zLastChild = super.lastChild(parent, parse2);
            parse = parent;
        }
        return zLastChild;
    }

    public ParserEventStream(ObjectStream<Parse> objectStream, HeadRules headRules, ParserEventTypeEnum parserEventTypeEnum) {
        super(objectStream, headRules, parserEventTypeEnum);
    }
}
