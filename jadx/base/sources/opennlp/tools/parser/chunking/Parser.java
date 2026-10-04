package opennlp.tools.parser.chunking;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import opennlp.tools.chunker.Chunker;
import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.p217ml.BeamSearch;
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
import opennlp.tools.util.Span;
import opennlp.tools.util.TrainingParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Parser extends AbstractBottomUpParser {
    private static final String TOP_START = "S-TOP";
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) Parser.class);
    private final double[] bprobs;
    private final BuildContextGenerator buildContextGenerator;
    private final MaxentModel buildModel;
    private final CheckContextGenerator checkContextGenerator;
    private final MaxentModel checkModel;
    private final int completeIndex;
    private final Map<String, String> contTypeMap;
    private final double[] cprobs;
    private final int incompleteIndex;
    private final Map<String, String> startTypeMap;
    private final int topStartIndex;

    public Parser(ParserModel parserModel, int i, double d) {
        this(parserModel.getBuildModel(), parserModel.getCheckModel(), new POSTaggerME(parserModel.getParserTaggerModel()), new ChunkerME(parserModel.getParserChunkerModel()), parserModel.getHeadRules(), i, d);
    }

    public static void mergeReportIntoManifest(Map<String, String> map, Map<String, String> map2, String str) {
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            map.put(AbstractC0541b.m757C(str, Extension.DOT, entry.getKey()), entry.getValue());
        }
    }

    public static ParserModel train(String str, ObjectStream<Parse> objectStream, HeadRules headRules, TrainingParameters trainingParameters) {
        Logger logger2 = logger;
        logger2.info("Building dictionary");
        Dictionary dictionaryBuildDictionary = AbstractBottomUpParser.buildDictionary(objectStream, headRules, trainingParameters);
        objectStream.reset();
        HashMap map = new HashMap();
        logger2.info("Training builder");
        ParserEventStream parserEventStream = new ParserEventStream(objectStream, headRules, ParserEventTypeEnum.BUILD, dictionaryBuildDictionary);
        HashMap map2 = new HashMap();
        MaxentModel maxentModelTrain = TrainerFactory.getEventTrainer(trainingParameters.getParameters("build"), map2).train(parserEventStream);
        mergeReportIntoManifest(map, map2, "build");
        objectStream.reset();
        if (!trainingParameters.getParameters("tagger").getObjectSettings().containsKey(BeamSearch.BEAM_SIZE_PARAMETER)) {
            trainingParameters.put("tagger", BeamSearch.BEAM_SIZE_PARAMETER, 10);
        }
        POSModel pOSModelTrain = POSTaggerME.train(str, new PosSampleStream(objectStream), trainingParameters.getParameters("tagger"), new POSTaggerFactory());
        objectStream.reset();
        ChunkerModel chunkerModelTrain = ChunkerME.train(str, new ChunkSampleStream(objectStream), trainingParameters.getParameters("chunker"), new ParserChunkerFactory());
        objectStream.reset();
        logger2.info("Training checker");
        ParserEventStream parserEventStream2 = new ParserEventStream(objectStream, headRules, ParserEventTypeEnum.CHECK);
        HashMap map3 = new HashMap();
        MaxentModel maxentModelTrain2 = TrainerFactory.getEventTrainer(trainingParameters.getParameters(Bixby2Constants.BIXBY_PARAM_CHECK), map3).train(parserEventStream2);
        mergeReportIntoManifest(map, map3, Bixby2Constants.BIXBY_PARAM_CHECK);
        return new ParserModel(str, maxentModelTrain, maxentModelTrain2, pOSModelTrain, chunkerModelTrain, headRules, ParserType.CHUNKING, map);
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x025f  */
    @Override // opennlp.tools.parser.AbstractBottomUpParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Parse[] advanceParses(Parse parse, double d) {
        double[] dArr;
        double d2;
        double d3;
        Parse parse2;
        String str;
        double d4 = 1.0d - d;
        Parse[] children = parse.getChildren();
        Parse[] parseArrCollapsePunctuation = AbstractBottomUpParser.collapsePunctuation(children, this.punctSet);
        int length = parseArrCollapsePunctuation.length;
        Parse parse3 = null;
        if (length == 0) {
            return null;
        }
        Parse parse4 = null;
        int i = -1;
        int i2 = 0;
        String str2 = null;
        while (i2 < length) {
            parse4 = parseArrCollapsePunctuation[i2];
            if (parse4.getLabel() == null) {
                break;
            }
            if (this.startTypeMap.containsKey(parse4.getLabel())) {
                String str3 = this.startTypeMap.get(parse4.getLabel());
                Logger logger2 = logger;
                if (logger2.isTraceEnabled()) {
                    logger2.trace("lastStart {} {} {}", Integer.valueOf(i2), parse4.getLabel(), Double.valueOf(parse4.getProb()));
                }
                str2 = str3;
                parse3 = parse4;
                i = i2;
            }
            i2++;
        }
        int iMapParseIndex = mapParseIndex(i2, parseArrCollapsePunctuation, children);
        ArrayList arrayList = new ArrayList(this.buildModel.getNumOutcomes());
        this.buildModel.eval(this.buildContextGenerator.getContext(parseArrCollapsePunctuation, i2), this.bprobs);
        double d5 = 0.0d;
        while (d5 < d) {
            int i4 = 0;
            int i5 = 1;
            while (true) {
                dArr = this.bprobs;
                d2 = d4;
                if (i5 >= dArr.length) {
                    break;
                }
                if (dArr[i5] > dArr[i4]) {
                    i4 = i5;
                }
                i5++;
                d4 = d2;
            }
            double d6 = dArr[i4];
            if (d6 == 0.0d) {
                break;
            }
            dArr[i4] = 0.0d;
            d5 += d6;
            String outcome = this.buildModel.getOutcome(i4);
            Logger logger3 = logger;
            if (logger3.isTraceEnabled()) {
                d3 = d6;
                logger3.trace("trying {} {} list={}", outcome, Double.valueOf(d5), outcome);
            } else {
                d3 = d6;
            }
            if (i4 != this.topStartIndex) {
                if (logger3.isTraceEnabled()) {
                    logger3.trace("{} {}", outcome, Double.valueOf(d3));
                }
                if (this.startTypeMap.containsKey(outcome)) {
                    str2 = this.startTypeMap.get(outcome);
                    parse3 = parse4;
                    i = i2;
                } else if (!this.contTypeMap.containsKey(outcome) || (parse3 != null && str2.equals(this.contTypeMap.get(outcome)))) {
                }
                Parse parse5 = (Parse) parse.clone();
                if (this.createDerivationString) {
                    StringBuffer derivation = parse5.getDerivation();
                    derivation.append(i4);
                    derivation.append(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
                }
                parse5.setChild(iMapParseIndex, outcome);
                int i6 = iMapParseIndex;
                parse5.addProb(StrictMath.log(d3));
                Parse[] parseArr = parseArrCollapsePunctuation;
                int i7 = length;
                this.checkModel.eval(this.checkContextGenerator.getContext(AbstractBottomUpParser.collapsePunctuation(parse5.getChildren(), this.punctSet), str2, i, i2), this.cprobs);
                if (logger3.isTraceEnabled()) {
                    logger3.trace("check {} {} {} {} {}", str2, Double.valueOf(this.cprobs[this.completeIndex]), Double.valueOf(this.cprobs[this.incompleteIndex]), outcome, Arrays.asList(this.checkContextGenerator.getContext(parse5.getChildren(), str2, i, i2)));
                }
                if (this.cprobs[this.completeIndex] > d2) {
                    Parse parse6 = (Parse) parse5.clone();
                    if (this.createDerivationString) {
                        StringBuffer derivation2 = parse6.getDerivation();
                        derivation2.append(1);
                        derivation2.append(Extension.DOT);
                    }
                    parse6.addProb(StrictMath.log(this.cprobs[this.completeIndex]));
                    int i8 = i2 - i;
                    Parse[] parseArr2 = new Parse[i8 + 1];
                    parseArr2[0] = parse3;
                    boolean zIsPosTag = parse3.isPosTag();
                    parseArr2[i8] = parse4;
                    boolean zIsPosTag2 = zIsPosTag & parse4.isPosTag();
                    for (int i9 = 1; i9 < i8; i9++) {
                        Parse parse7 = parseArr[i9 + i];
                        parseArr2[i9] = parse7;
                        zIsPosTag2 &= parse7.isPosTag();
                    }
                    if (zIsPosTag2) {
                        parse2 = parse3;
                        str = str2;
                    } else {
                        if (i == 0 && i2 == i7 - 1) {
                            Logger logger4 = logger;
                            if (logger4.isTraceEnabled()) {
                                parse2 = parse3;
                                logger4.trace("ParserME.advanceParses: reducing entire span: {} {} {}", new Span(parse3.getSpan().getStart(), parse4.getSpan().getEnd()), str2, Arrays.asList(parseArr));
                            } else {
                                parse2 = parse3;
                            }
                            str = str2;
                            parse6.insert(new Parse(parse.getText(), parse.getSpan(), str, this.cprobs[1], this.headRules.getHead(parseArr2, str2)));
                        } else {
                            parse2 = parse3;
                            str = str2;
                            parse6.insert(new Parse(parse.getText(), new Span(parse2.getSpan().getStart(), parse4.getSpan().getEnd()), str, this.cprobs[1], this.headRules.getHead(parseArr2, str2)));
                        }
                        arrayList.add(parse6);
                    }
                    if (this.cprobs[this.incompleteIndex] > d2) {
                        if (this.createDerivationString) {
                            StringBuffer derivation3 = parse5.getDerivation();
                            derivation3.append(0);
                            derivation3.append(Extension.DOT);
                        }
                        if (i2 != i7 - 1) {
                            parse5.addProb(StrictMath.log(this.cprobs[this.incompleteIndex]));
                            arrayList.add(parse5);
                        }
                    }
                    iMapParseIndex = i6;
                    d4 = d2;
                    parseArrCollapsePunctuation = parseArr;
                    length = i7;
                    str2 = str;
                    parse3 = parse2;
                }
            }
            d4 = d2;
        }
        Parse[] parseArr3 = new Parse[arrayList.size()];
        arrayList.toArray(parseArr3);
        return parseArr3;
    }

    @Override // opennlp.tools.parser.AbstractBottomUpParser
    public void advanceTop(Parse parse) {
        this.buildModel.eval(this.buildContextGenerator.getContext(parse.getChildren(), 0), this.bprobs);
        parse.addProb(StrictMath.log(this.bprobs[this.topStartIndex]));
        this.checkModel.eval(this.checkContextGenerator.getContext(parse.getChildren(), AbstractBottomUpParser.TOP_NODE, 0, 0), this.cprobs);
        parse.addProb(StrictMath.log(this.cprobs[this.completeIndex]));
        parse.setType(AbstractBottomUpParser.TOP_NODE);
    }

    public Parser(ParserModel parserModel) {
        this(parserModel, 20, 0.95d);
    }

    private Parser(MaxentModel maxentModel, MaxentModel maxentModel2, POSTagger pOSTagger, Chunker chunker, HeadRules headRules, int i, double d) {
        super(pOSTagger, chunker, headRules, i, d);
        this.buildModel = maxentModel;
        this.checkModel = maxentModel2;
        this.bprobs = new double[maxentModel.getNumOutcomes()];
        this.cprobs = new double[maxentModel2.getNumOutcomes()];
        this.buildContextGenerator = new BuildContextGenerator();
        this.checkContextGenerator = new CheckContextGenerator();
        this.startTypeMap = new HashMap();
        this.contTypeMap = new HashMap();
        int numOutcomes = maxentModel.getNumOutcomes();
        for (int i2 = 0; i2 < numOutcomes; i2++) {
            String outcome = maxentModel.getOutcome(i2);
            if (outcome.startsWith(AbstractBottomUpParser.START)) {
                Logger logger2 = logger;
                if (logger2.isTraceEnabled()) {
                    logger2.trace("startMap {} -> {} ", outcome, outcome.substring(2));
                }
                this.startTypeMap.put(outcome, outcome.substring(2));
            } else if (outcome.startsWith(AbstractBottomUpParser.CONT)) {
                Logger logger3 = logger;
                if (logger3.isTraceEnabled()) {
                    logger3.trace("contMap {} -> {}", outcome, outcome.substring(2));
                }
                this.contTypeMap.put(outcome, outcome.substring(2));
            }
        }
        this.topStartIndex = maxentModel.getIndex(TOP_START);
        this.completeIndex = maxentModel2.getIndex("c");
        this.incompleteIndex = maxentModel2.getIndex("i");
    }
}
