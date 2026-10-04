package opennlp.tools.parser.treeinsert;

import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import opennlp.tools.chunker.Chunker;
import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.p217ml.TrainerFactory;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.parser.AbstractBottomUpParser;
import opennlp.tools.parser.ChunkSampleStream;
import opennlp.tools.parser.HeadRules;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.ParserChunkerFactory;
import opennlp.tools.parser.ParserEventTypeEnum;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.parser.ParserType;
import opennlp.tools.parser.PosSampleStream;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTagger;
import opennlp.tools.postag.POSTaggerFactory;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.TrainingParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Parser extends AbstractBottomUpParser {
    public static final String ATTACH_DAUGHTER = "d";
    public static final String ATTACH_SISTER = "s";
    public static final String BUILT = "built";
    public static final String DONE = "d";
    public static final String NON_ATTACH = "n";
    private final double[] aprobs;
    private final AttachContextGenerator attachContextGenerator;
    private final MaxentModel attachModel;
    private final int[] attachments;
    private final double[] bprobs;
    private final BuildContextGenerator buildContextGenerator;
    private final MaxentModel buildModel;
    private final CheckContextGenerator checkContextGenerator;
    private final MaxentModel checkModel;
    private final int completeIndex;
    private double[] cprobs;
    private final int daughterAttachIndex;
    private final int doneIndex;
    private final int nonAttachIndex;
    private final int sisterAttachIndex;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) Parser.class);
    static boolean checkComplete = false;

    public Parser(ParserModel parserModel, int i, double d) {
        this(parserModel.getBuildModel(), parserModel.getAttachModel(), parserModel.getCheckModel(), new POSTaggerME(parserModel.getParserTaggerModel()), new ChunkerME(parserModel.getParserChunkerModel()), parserModel.getHeadRules(), i, d);
    }

    public static List<Parse> getRightFrontier(Parse parse, Set<String> set) {
        LinkedList linkedList = new LinkedList();
        if (AbstractBottomUpParser.TOP_NODE.equals(parse.getType()) || AbstractBottomUpParser.INC_NODE.equals(parse.getType())) {
            parse = AbstractBottomUpParser.collapsePunctuation(parse.getChildren(), set)[0];
        }
        while (!parse.isPosTag()) {
            linkedList.add(0, parse);
            parse = parse.getChildren()[r4.length - 1];
        }
        return new ArrayList(linkedList);
    }

    private boolean isBuilt(Parse parse) {
        String label = parse.getLabel();
        return label != null && label.startsWith(BUILT);
    }

    private boolean isComplete(Parse parse) {
        String label = parse.getLabel();
        return label != null && label.endsWith("c");
    }

    private void setBuilt(Parse parse) {
        if (parse.getLabel() == null) {
            parse.setLabel(BUILT);
        } else if (isComplete(parse)) {
            parse.setLabel("built.c");
        } else {
            parse.setLabel("built.i");
        }
    }

    private void setComplete(Parse parse) {
        parse.getLabel();
        if (isBuilt(parse)) {
            parse.setLabel("built.c");
        } else {
            parse.setLabel("c");
        }
    }

    private void setIncomplete(Parse parse) {
        if (isBuilt(parse)) {
            parse.setLabel("built.i");
        } else {
            parse.setLabel("i");
        }
    }

    public static ParserModel train(String str, ObjectStream<Parse> objectStream, HeadRules headRules, TrainingParameters trainingParameters) {
        HashMap map = new HashMap();
        Logger logger2 = logger;
        logger2.info("Building dictionary");
        Dictionary dictionaryBuildDictionary = AbstractBottomUpParser.buildDictionary(objectStream, headRules, trainingParameters);
        objectStream.reset();
        POSModel pOSModelTrain = POSTaggerME.train(str, new PosSampleStream(objectStream), trainingParameters.getParameters("tagger"), new POSTaggerFactory());
        objectStream.reset();
        ChunkerModel chunkerModelTrain = ChunkerME.train(str, new ChunkSampleStream(objectStream), trainingParameters.getParameters("chunker"), new ParserChunkerFactory());
        objectStream.reset();
        logger2.info("Training builder");
        ParserEventStream parserEventStream = new ParserEventStream(objectStream, headRules, ParserEventTypeEnum.BUILD, dictionaryBuildDictionary);
        HashMap map2 = new HashMap();
        MaxentModel maxentModelTrain = TrainerFactory.getEventTrainer(trainingParameters.getParameters("build"), map2).train(parserEventStream);
        opennlp.tools.parser.chunking.Parser.mergeReportIntoManifest(map, map2, "build");
        objectStream.reset();
        logger2.info("Training checker");
        ParserEventStream parserEventStream2 = new ParserEventStream(objectStream, headRules, ParserEventTypeEnum.CHECK);
        HashMap map3 = new HashMap();
        MaxentModel maxentModelTrain2 = TrainerFactory.getEventTrainer(trainingParameters.getParameters(Bixby2Constants.BIXBY_PARAM_CHECK), map3).train(parserEventStream2);
        opennlp.tools.parser.chunking.Parser.mergeReportIntoManifest(map, map3, Bixby2Constants.BIXBY_PARAM_CHECK);
        objectStream.reset();
        logger2.info("Training attacher");
        ParserEventStream parserEventStream3 = new ParserEventStream(objectStream, headRules, ParserEventTypeEnum.ATTACH);
        HashMap map4 = new HashMap();
        MaxentModel maxentModelTrain3 = TrainerFactory.getEventTrainer(trainingParameters.getParameters("attach"), map4).train(parserEventStream3);
        opennlp.tools.parser.chunking.Parser.mergeReportIntoManifest(map, map4, "attach");
        return new ParserModel(str, maxentModelTrain, maxentModelTrain2, maxentModelTrain3, pOSModelTrain, chunkerModelTrain, headRules, ParserType.TREEINSERT, map);
    }

    @Override // opennlp.tools.parser.AbstractBottomUpParser
    public Parse[] advanceChunks(Parse parse, double d) {
        Parse[] parseArrAdvanceChunks = super.advanceChunks(parse, d);
        for (Parse parse2 : parseArrAdvanceChunks) {
            for (Parse parse3 : parse2.getChildren()) {
                setComplete(parse3);
            }
        }
        return parseArrAdvanceChunks;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0373 A[LOOP:6: B:120:0x036d->B:122:0x0373, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0425  */
    @Override // opennlp.tools.parser.AbstractBottomUpParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Parse[] advanceParses(Parse parse, double d) {
        double d2;
        Parse parse2;
        List<Parse> list;
        String str;
        Parse parse3;
        Parse parse4;
        int i;
        Parse[] parseArr;
        int i2;
        int i4;
        Parse parse5;
        int i5;
        int i6;
        Parse parse6;
        Parse parseAdjoinRoot;
        int i7;
        int i8;
        Parse parse7;
        int i9;
        double[] dArr;
        double d3;
        Parse[] parseArr2;
        int i10;
        double d4 = 1.0d - d;
        Parse[] children = parse.getChildren();
        Parse[] parseArrCollapsePunctuation = AbstractBottomUpParser.collapsePunctuation(children, this.punctSet);
        int length = parseArrCollapsePunctuation.length;
        Parse parse8 = null;
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        int i12 = 1;
        if (length == 1) {
            if (parseArrCollapsePunctuation[0].isPosTag()) {
                return null;
            }
            parse.expandTopNode(parseArrCollapsePunctuation[0]);
            return new Parse[]{parse};
        }
        int i13 = 0;
        while (i13 < length) {
            parse8 = parseArrCollapsePunctuation[i13];
            if (!isBuilt(parse8)) {
                break;
            }
            i13++;
        }
        Parse parse9 = parse8;
        int iMapParseIndex = mapParseIndex(0, parseArrCollapsePunctuation, children);
        int iMapParseIndex2 = mapParseIndex(i13, parseArrCollapsePunctuation, children);
        ArrayList arrayList = new ArrayList();
        this.buildModel.eval(this.buildContextGenerator.getContext(parseArrCollapsePunctuation, i13), this.bprobs);
        double d5 = this.bprobs[this.doneIndex];
        Logger logger2 = logger;
        if (logger2.isDebugEnabled()) {
            d2 = 1.0d;
            parse2 = parse9;
            logger2.debug("adi={} {}.{} {} choose build={} attach={}", Integer.valueOf(i13), parse9.getType(), parse9.getLabel(), parse9, Double.valueOf(1.0d - d5), Double.valueOf(d5));
        } else {
            d2 = 1.0d;
            parse2 = parse9;
        }
        String str2 = "Only advancing complete node";
        if (d2 - d5 > d4) {
            double d6 = 0.0d;
            while (d6 < d) {
                int i14 = i11;
                int i15 = i12;
                while (true) {
                    dArr = this.bprobs;
                    if (i15 >= dArr.length) {
                        break;
                    }
                    if (dArr[i15] > dArr[i14]) {
                        i14 = i15;
                    }
                    i15++;
                }
                double d7 = dArr[i14];
                if (d7 == 0.0d) {
                    break;
                }
                dArr[i14] = 0.0d;
                d6 += d7;
                String outcome = this.buildModel.getOutcome(i14);
                if (outcome.equals("d")) {
                    d3 = d4;
                    parseArr2 = parseArrCollapsePunctuation;
                    i10 = iMapParseIndex;
                } else {
                    Parse parse10 = (Parse) parse.clone();
                    Parse parse11 = new Parse(parse.getText(), parse2.getSpan(), outcome, d7, parse2.getHead());
                    parse10.insert(parse11);
                    d3 = d4;
                    parse10.addProb(StrictMath.log(d7));
                    arrayList.add(parse10);
                    if (checkComplete) {
                        this.cprobs = this.checkModel.eval(this.checkContextGenerator.getContext(parse11, parseArrCollapsePunctuation, i13, false));
                        Logger logger3 = logger;
                        if (logger3.isDebugEnabled()) {
                            logger3.debug("building {} {} c={}", outcome, Double.valueOf(d7), Double.valueOf(this.cprobs[this.completeIndex]));
                        }
                        double d8 = this.cprobs[this.completeIndex];
                        if (d8 > d) {
                            setComplete(parse11);
                            parseArr2 = parseArrCollapsePunctuation;
                            i10 = iMapParseIndex;
                            parse10.addProb(StrictMath.log(this.cprobs[this.completeIndex]));
                            if (logger3.isDebugEnabled()) {
                                logger3.debug("Only advancing complete node");
                            }
                        } else {
                            parseArr2 = parseArrCollapsePunctuation;
                            i10 = iMapParseIndex;
                            if (d2 - d8 > d) {
                                setIncomplete(parse11);
                                parse10.addProb(StrictMath.log(d2 - this.cprobs[this.completeIndex]));
                                if (logger3.isDebugEnabled()) {
                                    logger3.debug("Only advancing incomplete node");
                                }
                            } else {
                                if (logger3.isDebugEnabled()) {
                                    logger3.debug("Advancing both complete and incomplete nodes");
                                }
                                setComplete(parse11);
                                parse10.addProb(StrictMath.log(this.cprobs[this.completeIndex]));
                                Parse parse12 = (Parse) parse.clone();
                                Parse parse13 = new Parse(parse.getText(), parse2.getSpan(), outcome, d7, parse2.getHead());
                                parse12.insert(parse13);
                                parse12.addProb(StrictMath.log(d7));
                                arrayList.add(parse12);
                                parse12.addProb(StrictMath.log(d2 - this.cprobs[this.completeIndex]));
                                setIncomplete(parse13);
                            }
                        }
                    } else {
                        parseArr2 = parseArrCollapsePunctuation;
                        i10 = iMapParseIndex;
                        Logger logger4 = logger;
                        if (logger4.isDebugEnabled()) {
                            logger4.debug("building {} {}", outcome, Double.valueOf(d7));
                        }
                    }
                }
                parseArrCollapsePunctuation = parseArr2;
                d4 = d3;
                iMapParseIndex = i10;
                i11 = 0;
                i12 = 1;
            }
        }
        double d9 = d4;
        Parse[] parseArr3 = parseArrCollapsePunctuation;
        int i16 = iMapParseIndex;
        if (d5 > d9) {
            Parse parse14 = (Parse) parse.clone();
            if (!checkComplete) {
                parse14.setChild(iMapParseIndex2, BUILT);
            } else if (isComplete(parse2)) {
                parse14.setChild(iMapParseIndex2, "built.c");
            } else {
                parse14.setChild(iMapParseIndex2, "built.i");
            }
            parse14.addProb(StrictMath.log(d5));
            if (i13 != 0) {
                List<Parse> rightFrontier = getRightFrontier(parse, this.punctSet);
                int size = rightFrontier.size();
                int i17 = 0;
                while (true) {
                    if (i17 >= size) {
                        break;
                    }
                    Parse parse15 = rightFrontier.get(i17);
                    this.attachModel.eval(this.attachContextGenerator.getContext(parseArr3, i13, rightFrontier, i17), this.aprobs);
                    Logger logger5 = logger;
                    if (logger5.isDebugEnabled()) {
                        Parse parse16 = parse2;
                        str = str2;
                        list = rightFrontier;
                        parse3 = parse15;
                        parse2 = parse16;
                        logger5.debug("Frontier node({}): {}.{} {} <- {} {} d={} s={} ", Integer.valueOf(i17), parse15.getType(), parse15.getLabel(), parse15, parse16.getType(), parse16, Double.valueOf(this.aprobs[this.daughterAttachIndex]), Double.valueOf(this.aprobs[this.sisterAttachIndex]));
                    } else {
                        list = rightFrontier;
                        str = str2;
                        parse3 = parse15;
                    }
                    int[] iArr = this.attachments;
                    int length2 = iArr.length;
                    int i18 = 0;
                    while (i18 < length2) {
                        int i19 = iArr[i18];
                        int[] iArr2 = iArr;
                        double d10 = this.aprobs[i19];
                        if (d10 <= d9 || ((checkComplete || (i19 == this.daughterAttachIndex && isComplete(parse3))) && (!checkComplete || ((i19 != this.daughterAttachIndex || isComplete(parse3)) && !(i19 == this.sisterAttachIndex && isComplete(parse3)))))) {
                            parse4 = parse14;
                            i = size;
                            parseArr = parseArr3;
                            i2 = iMapParseIndex2;
                            i4 = length2;
                            parse5 = parse3;
                            i5 = i18;
                            i6 = i16;
                            Logger logger6 = logger;
                            if (logger6.isDebugEnabled()) {
                                parse6 = parse5;
                                logger6.debug("Skipping {}.{} {} daughter={} complete={} prob={}", parse5.getType(), parse5.getLabel(), parse6, Boolean.valueOf(i19 == this.daughterAttachIndex), Boolean.valueOf(isComplete(parse6)), Double.valueOf(d10));
                            }
                            i18 = i5 + 1;
                            i16 = i6;
                            parse3 = parse6;
                            iArr = iArr2;
                            size = i;
                            parse14 = parse4;
                            parseArr3 = parseArr;
                            length2 = i4;
                            iMapParseIndex2 = i2;
                        } else {
                            i = size;
                            i6 = i16;
                            Parse parseCloneRoot = parse14.cloneRoot(parse3, i6);
                            parse4 = parse14;
                            parseArr = parseArr3;
                            Parse[] parseArrCollapsePunctuation2 = AbstractBottomUpParser.collapsePunctuation(parseCloneRoot.getChildren(), this.punctSet);
                            int i20 = i6 + 1;
                            i4 = length2;
                            int i21 = i20;
                            while (i21 <= iMapParseIndex2) {
                                int i22 = iMapParseIndex2;
                                Logger logger7 = logger;
                                if (logger7.isTraceEnabled()) {
                                    i8 = i21;
                                    i9 = i18;
                                    parse7 = parse3;
                                    logger7.trace("{}-removing {} {}", Integer.valueOf(i8), Integer.valueOf(i20), parseCloneRoot.getChildren()[i20]);
                                } else {
                                    i8 = i21;
                                    parse7 = parse3;
                                    i9 = i18;
                                }
                                parseCloneRoot.remove(i20);
                                i21 = i8 + 1;
                                parse3 = parse7;
                                iMapParseIndex2 = i22;
                                i18 = i9;
                            }
                            i2 = iMapParseIndex2;
                            parse5 = parse3;
                            i5 = i18;
                            List<Parse> rightFrontier2 = getRightFrontier(parseCloneRoot, this.punctSet);
                            if (i19 == this.daughterAttachIndex) {
                                parseAdjoinRoot = rightFrontier2.get(i17);
                                parseAdjoinRoot.add(parse2, this.headRules);
                            } else {
                                int i23 = i17 + 1;
                                if (i23 < rightFrontier2.size()) {
                                    parseAdjoinRoot = rightFrontier2.get(i23).adjoin(parse2, this.headRules);
                                } else {
                                    parseAdjoinRoot = parseCloneRoot.adjoinRoot(parse2, this.headRules, i6);
                                    parseArrCollapsePunctuation2[0] = parseAdjoinRoot;
                                    for (i7 = i17 + 1; i7 < rightFrontier2.size(); i7++) {
                                        rightFrontier2.get(i7).updateSpan();
                                    }
                                    parseCloneRoot.addProb(StrictMath.log(d10));
                                    arrayList.add(parseCloneRoot);
                                    if (!checkComplete) {
                                        double[] dArrEval = this.checkModel.eval(this.checkContextGenerator.getContext(parseAdjoinRoot, parseArrCollapsePunctuation2, i13, true));
                                        this.cprobs = dArrEval;
                                        double d11 = dArrEval[this.completeIndex];
                                        if (d11 > d) {
                                            setComplete(parseAdjoinRoot);
                                            parseCloneRoot.addProb(StrictMath.log(this.cprobs[this.completeIndex]));
                                            Logger logger8 = logger;
                                            if (logger8.isDebugEnabled()) {
                                                logger8.debug(str);
                                            }
                                        } else if (d2 - d11 > d) {
                                            setIncomplete(parseAdjoinRoot);
                                            parseCloneRoot.addProb(StrictMath.log(d2 - this.cprobs[this.completeIndex]));
                                            Logger logger9 = logger;
                                            if (logger9.isDebugEnabled()) {
                                                logger9.debug("Only advancing incomplete node");
                                            }
                                        } else {
                                            setComplete(parseAdjoinRoot);
                                            Parse parseCloneRoot2 = parseCloneRoot.cloneRoot(parseAdjoinRoot, i6);
                                            parseCloneRoot2.addProb(StrictMath.log(this.cprobs[this.completeIndex]));
                                            arrayList.add(parseCloneRoot2);
                                            setIncomplete(parseAdjoinRoot);
                                            parseCloneRoot.addProb(StrictMath.log(d2 - this.cprobs[this.completeIndex]));
                                            Logger logger10 = logger;
                                            if (logger10.isDebugEnabled()) {
                                                logger10.debug("Advancing both complete and incomplete nodes; c={}", Double.valueOf(this.cprobs[this.completeIndex]));
                                            }
                                        }
                                    }
                                }
                            }
                            while (i7 < rightFrontier2.size()) {
                            }
                            parseCloneRoot.addProb(StrictMath.log(d10));
                            arrayList.add(parseCloneRoot);
                            if (!checkComplete) {
                            }
                        }
                        parse6 = parse5;
                        i18 = i5 + 1;
                        i16 = i6;
                        parse3 = parse6;
                        iArr = iArr2;
                        size = i;
                        parse14 = parse4;
                        parseArr3 = parseArr;
                        length2 = i4;
                        iMapParseIndex2 = i2;
                    }
                    Parse parse17 = parse14;
                    int i24 = size;
                    Parse[] parseArr4 = parseArr3;
                    int i25 = iMapParseIndex2;
                    Parse parse18 = parse3;
                    int i26 = i16;
                    if (!checkComplete || isComplete(parse18)) {
                        i17++;
                        i16 = i26;
                        str2 = str;
                        size = i24;
                        parse14 = parse17;
                        parseArr3 = parseArr4;
                        iMapParseIndex2 = i25;
                        rightFrontier = list;
                    } else {
                        Logger logger11 = logger;
                        if (logger11.isDebugEnabled()) {
                            logger11.debug("Stopping at incomplete node({}): {} . {} {}", Integer.valueOf(i17), parse18.getType(), parse18.getLabel(), parse18);
                        }
                    }
                }
            } else {
                arrayList.add(parse14);
            }
        }
        Parse[] parseArr5 = new Parse[arrayList.size()];
        arrayList.toArray(parseArr5);
        return parseArr5;
    }

    @Override // opennlp.tools.parser.AbstractBottomUpParser
    public void advanceTop(Parse parse) {
        parse.setType(AbstractBottomUpParser.TOP_NODE);
    }

    public Parser(ParserModel parserModel) {
        this(parserModel, 20, 0.95d);
    }

    private Parser(MaxentModel maxentModel, MaxentModel maxentModel2, MaxentModel maxentModel3, POSTagger pOSTagger, Chunker chunker, HeadRules headRules, int i, double d) {
        super(pOSTagger, chunker, headRules, i, d);
        this.buildModel = maxentModel;
        this.attachModel = maxentModel2;
        this.checkModel = maxentModel3;
        this.buildContextGenerator = new BuildContextGenerator();
        this.attachContextGenerator = new AttachContextGenerator(this.punctSet);
        this.checkContextGenerator = new CheckContextGenerator(this.punctSet);
        this.bprobs = new double[maxentModel.getNumOutcomes()];
        this.aprobs = new double[maxentModel2.getNumOutcomes()];
        this.cprobs = new double[maxentModel3.getNumOutcomes()];
        this.doneIndex = maxentModel.getIndex("d");
        int index = maxentModel2.getIndex("s");
        this.sisterAttachIndex = index;
        int index2 = maxentModel2.getIndex("d");
        this.daughterAttachIndex = index2;
        this.nonAttachIndex = maxentModel2.getIndex("n");
        this.attachments = new int[]{index2, index};
        this.completeIndex = maxentModel3.getIndex("c");
    }

    public static ParserModel train(String str, ObjectStream<Parse> objectStream, HeadRules headRules, int i, int i2) {
        TrainingParameters trainingParameters = new TrainingParameters();
        trainingParameters.put("dict", "Cutoff", i2);
        trainingParameters.put("tagger", "Cutoff", i2);
        trainingParameters.put("tagger", "Iterations", i);
        trainingParameters.put("chunker", "Cutoff", i2);
        trainingParameters.put("chunker", "Iterations", i);
        trainingParameters.put(Bixby2Constants.BIXBY_PARAM_CHECK, "Cutoff", i2);
        trainingParameters.put(Bixby2Constants.BIXBY_PARAM_CHECK, "Iterations", i);
        trainingParameters.put("build", "Cutoff", i2);
        trainingParameters.put("build", "Iterations", i);
        return train(str, objectStream, headRules, trainingParameters);
    }
}
