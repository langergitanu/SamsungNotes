package opennlp.tools.parser;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import opennlp.tools.chunker.Chunker;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.ngram.NGramModel;
import opennlp.tools.parser.chunking.ParserEventStream;
import opennlp.tools.postag.POSTagger;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Sequence;
import opennlp.tools.util.Span;
import opennlp.tools.util.StringList;
import opennlp.tools.util.TrainingParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractBottomUpParser implements Parser {
    public static final String COMPLETE = "c";
    public static final String CONT = "C-";
    public static final String INCOMPLETE = "i";
    public static final String INC_NODE = "INC";
    public static final String OTHER = "O";
    public static final String START = "S-";
    public static final String TOK_NODE = "TK";
    public static final String TOP_NODE = "TOP";
    public static final double defaultAdvancePercentage = 0.95d;
    public static final int defaultBeamSize = 20;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) AbstractBottomUpParser.class);

    /* JADX INFO: renamed from: K */
    protected int f9680K;

    /* JADX INFO: renamed from: M */
    protected int f9681M;

    /* JADX INFO: renamed from: Q */
    protected double f9682Q;
    protected Chunker chunker;
    protected HeadRules headRules;
    protected Set<String> punctSet;
    protected POSTagger tagger;
    protected boolean createDerivationString = false;
    protected boolean reportFailedParse = true;
    private SortedSet<Parse> odh = new TreeSet();
    private SortedSet<Parse> ndh = new TreeSet();
    private final SortedSet<Parse> completeParses = new TreeSet();

    public AbstractBottomUpParser(POSTagger pOSTagger, Chunker chunker, HeadRules headRules, int i, double d) {
        this.tagger = pOSTagger;
        this.chunker = chunker;
        this.f9681M = i;
        this.f9680K = i;
        this.f9682Q = d;
        this.headRules = headRules;
        this.punctSet = headRules.getPunctuationTags();
    }

    public static Dictionary buildDictionary(ObjectStream<Parse> objectStream, HeadRules headRules, TrainingParameters trainingParameters) {
        int i;
        int intParameter = trainingParameters.getIntParameter("dict", "Cutoff", 5);
        NGramModel nGramModel = new NGramModel();
        while (true) {
            Parse parse = objectStream.read();
            if (parse == null) {
                nGramModel.cutoff(intParameter, Integer.MAX_VALUE);
                return nGramModel.toDictionary(true);
            }
            parse.updateHeads(headRules);
            Parse[] tagNodes = parse.getTagNodes();
            int length = tagNodes.length;
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = tagNodes[i2].getCoveredText();
            }
            nGramModel.add(new StringList(strArr), 1, 1);
            Parse[] parseArrCollapsePunctuation = collapsePunctuation(AbstractParserEventStream.getInitialChunks(parse), headRules.getPunctuationTags());
            int length2 = parseArrCollapsePunctuation.length;
            String[] strArr2 = new String[length2];
            for (int i4 = 0; i4 < length2; i4++) {
                strArr2[i4] = parseArrCollapsePunctuation[i4].getHead().getCoveredText();
            }
            nGramModel.add(new StringList(strArr2), 2, 3);
            int i5 = 0;
            while (i5 < parseArrCollapsePunctuation.length) {
                if (parseArrCollapsePunctuation[i5].getParent() == null) {
                    parseArrCollapsePunctuation[i5].show();
                }
                Parse parse2 = parseArrCollapsePunctuation[i5];
                if (lastChild(parse2, parse2.getParent(), headRules.getPunctuationTags())) {
                    int i6 = i5;
                    while (i6 >= 0 && parseArrCollapsePunctuation[i6].getParent() == parseArrCollapsePunctuation[i5].getParent()) {
                        i6--;
                    }
                    int i7 = i6 + 1;
                    parseArrCollapsePunctuation = ParserEventStream.reduceChunks(parseArrCollapsePunctuation, i5, parseArrCollapsePunctuation[i5].getParent());
                    if (parseArrCollapsePunctuation.length != 0) {
                        String[] strArr3 = new String[5];
                        int i8 = i6 - 1;
                        if (i8 >= 0) {
                            strArr3[0] = parseArrCollapsePunctuation[i8].getHead().getCoveredText();
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (i6 >= 0) {
                            strArr3[i] = parseArrCollapsePunctuation[i6].getHead().getCoveredText();
                            i++;
                        }
                        int i9 = i + 1;
                        strArr3[i] = parseArrCollapsePunctuation[i7].getHead().getCoveredText();
                        int i10 = i6 + 2;
                        if (i10 < parseArrCollapsePunctuation.length) {
                            strArr3[i9] = parseArrCollapsePunctuation[i10].getHead().getCoveredText();
                            i9 = i + 2;
                        }
                        int i11 = i6 + 3;
                        if (i11 < parseArrCollapsePunctuation.length) {
                            strArr3[i9] = parseArrCollapsePunctuation[i11].getHead().getCoveredText();
                            i9++;
                        }
                        if (i9 < 5) {
                            String[] strArr4 = new String[i9];
                            System.arraycopy(strArr3, 0, strArr4, 0, i9);
                            strArr3 = strArr4;
                        }
                        if (strArr3.length >= 3) {
                            nGramModel.add(new StringList(strArr3), 2, 3);
                        } else if (strArr3.length == 2) {
                            nGramModel.add(new StringList(strArr3), 2, 2);
                        }
                    }
                    i5 = i6;
                }
                i5++;
            }
        }
    }

    public static Parse[] collapsePunctuation(Parse[] parseArr, Set<String> set) {
        ArrayList arrayList = new ArrayList(parseArr.length);
        int length = parseArr.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (set.contains(parseArr[i2].getType())) {
                if (i >= 0) {
                    parseArr[i].addNextPunctuation(parseArr[i2]);
                }
                int i4 = i2 + 1;
                while (i4 < length && set.contains(parseArr[i4].getType())) {
                    i4++;
                }
                if (i4 < length) {
                    parseArr[i4].addPreviousPunctuation(parseArr[i2]);
                }
            } else {
                arrayList.add(parseArr[i2]);
                i = i2;
            }
        }
        return arrayList.size() == parseArr.length ? parseArr : (Parse[]) arrayList.toArray(new Parse[0]);
    }

    private static boolean lastChild(Parse parse, Parse parse2, Set<String> set) {
        if (parse2 == null) {
            return false;
        }
        Parse[] parseArrCollapsePunctuation = collapsePunctuation(parse2.getChildren(), set);
        return parseArrCollapsePunctuation[parseArrCollapsePunctuation.length - 1] == parse;
    }

    public static void setParents(Parse parse) {
        for (Parse parse2 : parse.getChildren()) {
            parse2.setParent(parse);
            setParents(parse2);
        }
    }

    public Parse[] advanceChunks(Parse parse, double d) {
        int i;
        Sequence[] sequenceArr;
        String str;
        Parse[] children = parse.getChildren();
        int length = children.length;
        String[] strArr = new String[length];
        String[] strArr2 = new String[length];
        double[] dArr = new double[length];
        int length2 = children.length;
        int i2 = 0;
        for (int i4 = 0; i4 < length2; i4++) {
            Parse parse2 = children[i4];
            strArr[i4] = parse2.getHead().getCoveredText();
            strArr2[i4] = parse2.getType();
        }
        Sequence[] sequenceArr2 = this.chunker.topKSequences(strArr, strArr2, d - parse.getProb());
        Parse[] parseArr = new Parse[sequenceArr2.length];
        int length3 = sequenceArr2.length;
        int i5 = 0;
        while (i5 < length3) {
            Parse parse3 = (Parse) parse.clone();
            parseArr[i5] = parse3;
            if (this.createDerivationString) {
                StringBuffer derivation = parse3.getDerivation();
                derivation.append(i5);
                derivation.append(Extension.DOT);
            }
            String[] strArr3 = (String[]) sequenceArr2[i5].getOutcomes().toArray(new String[length]);
            sequenceArr2[i5].getProbs(dArr);
            int i6 = -1;
            int i7 = i2;
            int i8 = i7;
            String strSubstring = null;
            while (i7 <= strArr3.length) {
                if (i7 != strArr3.length) {
                    i = i6;
                    parseArr[i5].addProb(StrictMath.log(dArr[i7]));
                } else {
                    i = i6;
                }
                if (i7 == strArr3.length || !strArr3[i7].startsWith(CONT)) {
                    if (strSubstring != null) {
                        Parse parse4 = parse.getChildren()[i];
                        Parse parse5 = parse.getChildren()[i8];
                        int i9 = i8 - i;
                        Parse[] parseArr2 = new Parse[i9 + 1];
                        parseArr2[i2] = parse4;
                        if (i9 != 0) {
                            parseArr2[i9] = parse5;
                            for (int i10 = 1; i10 < i9; i10++) {
                                parseArr2[i10] = parse.getChildren()[i10 + i];
                            }
                        }
                        sequenceArr = sequenceArr2;
                        str = strSubstring;
                        Parse parse6 = new Parse(parse4.getText(), new Span(parse4.getSpan().getStart(), parse5.getSpan().getEnd()), str, 1.0d, this.headRules.getHead(parseArr2, strSubstring));
                        parse6.isChunk(true);
                        parseArr[i5].insert(parse6);
                    } else {
                        sequenceArr = sequenceArr2;
                        str = strSubstring;
                    }
                    if (i7 == strArr3.length) {
                        i6 = i;
                        strSubstring = str;
                    } else if (strArr3[i7].startsWith(START)) {
                        strSubstring = strArr3[i7].substring(2);
                        i6 = i7;
                        i8 = i6;
                    } else {
                        i6 = i;
                        strSubstring = null;
                    }
                } else {
                    i6 = i;
                    sequenceArr = sequenceArr2;
                    i8 = i7;
                }
                i7++;
                sequenceArr2 = sequenceArr;
                i2 = 0;
            }
            i5++;
            i2 = 0;
        }
        return parseArr;
    }

    public abstract Parse[] advanceParses(Parse parse, double d);

    public Parse[] advanceTags(Parse parse) {
        Parse[] children = parse.getChildren();
        int length = children.length;
        String[] strArr = new String[length];
        double[] dArr = new double[length];
        int length2 = children.length;
        for (int i = 0; i < length2; i++) {
            strArr[i] = children[i].getCoveredText();
        }
        Sequence[] sequenceArr = this.tagger.topKSequences(strArr);
        Parse[] parseArr = new Parse[sequenceArr.length];
        for (int i2 = 0; i2 < sequenceArr.length; i2++) {
            String[] strArr2 = (String[]) sequenceArr[i2].getOutcomes().toArray(new String[length]);
            sequenceArr[i2].getProbs(dArr);
            Parse parse2 = (Parse) parse.clone();
            parseArr[i2] = parse2;
            if (this.createDerivationString) {
                StringBuffer derivation = parse2.getDerivation();
                derivation.append(i2);
                derivation.append(Extension.DOT);
            }
            int i4 = 0;
            while (i4 < length) {
                Parse parse3 = children[i4];
                double d = dArr[i4];
                int i5 = i4;
                parseArr[i2].insert(new Parse(parse3.getText(), parse3.getSpan(), strArr2[i4], d, i5));
                parseArr[i2].addProb(StrictMath.log(d));
                i4 = i5 + 1;
            }
        }
        return parseArr;
    }

    public abstract void advanceTop(Parse parse);

    public int mapParseIndex(int i, Parse[] parseArr, Parse[] parseArr2) {
        int i2 = i;
        while (parseArr2[i2] != parseArr[i]) {
            i2++;
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010e  */
    @Override // opennlp.tools.parser.Parser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Parse[] parse(Parse parse, int i) {
        int i2;
        Parse[] parseArrAdvanceParses;
        if (this.createDerivationString) {
            parse.setDerivation(new StringBuffer(100));
        }
        this.odh.clear();
        this.ndh.clear();
        this.completeParses.clear();
        int i4 = 2;
        int childCount = (parse.getChildCount() * 2) + 3;
        this.odh.add(parse);
        Parse parse2 = null;
        double prob = 2.0d;
        double prob2 = -100000.0d;
        int i5 = 0;
        while (this.odh.size() > 0 && ((this.completeParses.size() < this.f9681M || this.odh.first().getProb() < prob) && i5 < childCount)) {
            this.ndh = new TreeSet();
            Iterator<Parse> it = this.odh.iterator();
            int i6 = 0;
            while (it.hasNext() && i6 < this.f9680K) {
                Parse next = it.next();
                if (parse2 == null && i5 == i4) {
                    parse2 = next;
                }
                Logger logger2 = logger;
                if (logger2.isDebugEnabled()) {
                    logger2.debug("{} {} {}", Integer.valueOf(i5), Integer.valueOf(i6), Double.valueOf(next.getProb()));
                    next.show();
                }
                if (i5 == 0) {
                    parseArrAdvanceParses = advanceTags(next);
                } else {
                    if (1 != i5) {
                        i2 = childCount;
                        parseArrAdvanceParses = advanceParses(next, this.f9682Q);
                    } else if (this.ndh.size() < this.f9680K) {
                        parseArrAdvanceParses = advanceChunks(next, prob2);
                    } else {
                        i2 = childCount;
                        parseArrAdvanceParses = advanceChunks(next, this.ndh.last().getProb());
                    }
                    if (parseArrAdvanceParses == null) {
                        for (Parse parse3 : parseArrAdvanceParses) {
                            if (parse3.complete()) {
                                advanceTop(parse3);
                                if (parse3.getProb() > prob2) {
                                    prob2 = parse3.getProb();
                                }
                                if (parse3.getProb() < prob) {
                                    prob = parse3.getProb();
                                }
                                this.completeParses.add(parse3);
                            } else {
                                this.ndh.add(parse3);
                            }
                        }
                    } else {
                        advanceTop(next);
                        this.completeParses.add(next);
                    }
                    i6++;
                    childCount = i2;
                    i4 = 2;
                }
                i2 = childCount;
                if (parseArrAdvanceParses == null) {
                }
                i6++;
                childCount = i2;
                i4 = 2;
            }
            i5++;
            this.odh = this.ndh;
            childCount = childCount;
            i4 = 2;
        }
        if (this.completeParses.size() == 0) {
            if (parse2 != null) {
                setParents(parse2);
                for (Parse parse4 : parse2.getChildren()) {
                    setParents(parse4);
                }
            }
            return new Parse[]{parse2};
        }
        if (i == 1) {
            Parse parseFirst = this.completeParses.first();
            setParents(parseFirst);
            for (Parse parse5 : parseFirst.getChildren()) {
                setParents(parse5);
            }
            return new Parse[]{parseFirst};
        }
        ArrayList arrayList = new ArrayList(i);
        while (!this.completeParses.isEmpty() && arrayList.size() < i) {
            Parse parseFirst2 = this.completeParses.first();
            setParents(parseFirst2);
            for (Parse parse6 : parseFirst2.getChildren()) {
                setParents(parse6);
            }
            this.completeParses.remove(parseFirst2);
            arrayList.add(parseFirst2);
        }
        return (Parse[]) arrayList.toArray(new Parse[0]);
    }

    public void setErrorReporting(boolean z) {
        this.reportFailedParse = z;
    }

    public static Dictionary buildDictionary(ObjectStream<Parse> objectStream, HeadRules headRules, int i) {
        TrainingParameters trainingParameters = new TrainingParameters();
        trainingParameters.put("dict", "Cutoff", i);
        return buildDictionary(objectStream, headRules, trainingParameters);
    }

    @Override // opennlp.tools.parser.Parser
    public Parse parse(Parse parse) {
        if (parse.getChildCount() <= 0) {
            return parse;
        }
        Parse parse2 = parse(parse, 1)[0];
        setParents(parse2);
        return parse2;
    }
}
