package opennlp.tools.postag;

import androidx.compose.animation.core.AnimationKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.ngram.NGramModel;
import opennlp.tools.p217ml.BeamSearch;
import opennlp.tools.p217ml.TrainerFactory;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.p217ml.model.SequenceClassificationModel;
import opennlp.tools.util.DownloadUtil;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Sequence;
import opennlp.tools.util.SequenceValidator;
import opennlp.tools.util.StringList;
import opennlp.tools.util.StringUtil;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.featuregen.StringPattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class POSTaggerME implements POSTagger {
    public static final int DEFAULT_BEAM_SIZE = 3;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) POSTaggerME.class);
    private Sequence bestSequence;
    protected final POSContextGenerator contextGen;
    private final SequenceClassificationModel model;
    private final POSModel modelPackage;
    private final POSTagFormat posTagFormat;
    private final POSTagFormatMapper posTagFormatMapper;
    private final SequenceValidator<String> sequenceValidator;
    protected final int size;
    protected final TagDictionary tagDictionary;

    public POSTaggerME(String str) {
        this(str, POSTagFormat.UD);
    }

    public static Dictionary buildNGramDictionary(ObjectStream<POSSample> objectStream, int i) {
        NGramModel nGramModel = new NGramModel();
        while (true) {
            POSSample pOSSample = objectStream.read();
            if (pOSSample == null) {
                nGramModel.cutoff(i, Integer.MAX_VALUE);
                return nGramModel.toDictionary(true);
            }
            String[] sentence = pOSSample.getSentence();
            if (sentence.length > 0) {
                nGramModel.add(new StringList(sentence), 1, 1);
            }
        }
    }

    private String[] convertTags(List<String> list) {
        return this.posTagFormatMapper.getGuessedFormat() == this.posTagFormat ? (String[]) list.toArray(new String[0]) : this.posTagFormatMapper.convertTags(list);
    }

    public static void populatePOSDictionary(ObjectStream<POSSample> objectStream, MutableTagDictionary mutableTagDictionary, int i) {
        logger.info("Expanding POS Dictionary ...");
        long jNanoTime = System.nanoTime();
        HashMap map = new HashMap();
        while (true) {
            POSSample pOSSample = objectStream.read();
            if (pOSSample == null) {
                break;
            }
            String[] sentence = pOSSample.getSentence();
            String[] tags = pOSSample.getTags();
            for (int i2 = 0; i2 < sentence.length; i2++) {
                if (!StringPattern.recognize(sentence[i2]).containsDigit()) {
                    String lowerCase = mutableTagDictionary.isCaseSensitive() ? sentence[i2] : StringUtil.toLowerCase(sentence[i2]);
                    if (!map.containsKey(lowerCase)) {
                        map.put(lowerCase, new HashMap());
                    }
                    String[] tags2 = mutableTagDictionary.getTags(lowerCase);
                    if (tags2 != null) {
                        for (String str : tags2) {
                            Map map2 = (Map) map.get(lowerCase);
                            if (!map2.containsKey(str)) {
                                map2.put(str, new AtomicInteger(i));
                            }
                        }
                    }
                    if (((Map) map.get(lowerCase)).containsKey(tags[i2])) {
                        ((AtomicInteger) ((Map) map.get(lowerCase)).get(tags[i2])).incrementAndGet();
                    } else {
                        ((Map) map.get(lowerCase)).put(tags[i2], new AtomicInteger(1));
                    }
                }
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                if (((AtomicInteger) entry2.getValue()).get() >= i) {
                    arrayList.add((String) entry2.getKey());
                }
            }
            if (!arrayList.isEmpty()) {
                mutableTagDictionary.put((String) entry.getKey(), (String[]) arrayList.toArray(new String[0]));
            }
        }
        logger.info("... finished expanding POS Dictionary. [ {} ms]", Long.valueOf((System.nanoTime() - jNanoTime) / AnimationKt.MillisToNanos));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static POSModel train(String str, ObjectStream<POSSample> objectStream, TrainingParameters trainingParameters, POSTaggerFactory pOSTaggerFactory) {
        MaxentModel maxentModel;
        MaxentModel maxentModelTrain;
        int intParameter = trainingParameters.getIntParameter(BeamSearch.BEAM_SIZE_PARAMETER, 3);
        POSContextGenerator pOSContextGenerator = pOSTaggerFactory.getPOSContextGenerator();
        HashMap map = new HashMap();
        TrainerFactory.TrainerType trainerType = TrainerFactory.getTrainerType(trainingParameters);
        SequenceClassificationModel sequenceClassificationModelTrain = null;
        if (TrainerFactory.TrainerType.EVENT_MODEL_TRAINER.equals(trainerType)) {
            maxentModelTrain = TrainerFactory.getEventTrainer(trainingParameters, map).train(new POSSampleEventStream(objectStream, pOSContextGenerator));
        } else {
            if (!TrainerFactory.TrainerType.EVENT_MODEL_SEQUENCE_TRAINER.equals(trainerType)) {
                if (TrainerFactory.TrainerType.SEQUENCE_TRAINER.equals(trainerType)) {
                    maxentModel = null;
                    sequenceClassificationModelTrain = TrainerFactory.getSequenceModelTrainer(trainingParameters, map).train(new POSSampleSequenceStream(objectStream, pOSContextGenerator));
                    return maxentModel == null ? new POSModel(str, maxentModel, intParameter, map, pOSTaggerFactory) : new POSModel(str, sequenceClassificationModelTrain, map, pOSTaggerFactory);
                }
                throw new IllegalArgumentException("Trainer type is not supported: " + trainerType);
            }
            maxentModelTrain = TrainerFactory.getEventModelSequenceTrainer(trainingParameters, map).train(new POSSampleSequenceStream(objectStream, pOSContextGenerator));
        }
        maxentModel = maxentModelTrain;
        if (maxentModel == null) {
        }
    }

    public String[] getAllPosTags() {
        return this.model.getOutcomes();
    }

    public String[] getOrderedTags(List<String> list, List<String> list2, int i) {
        return getOrderedTags(list, list2, i, null);
    }

    public void probs(double[] dArr) {
        this.bestSequence.getProbs(dArr);
    }

    @Override // opennlp.tools.postag.POSTagger
    public String[] tag(String[] strArr) {
        return tag(strArr, (Object[]) null);
    }

    @Override // opennlp.tools.postag.POSTagger
    public Sequence[] topKSequences(String[] strArr) {
        return topKSequences(strArr, null);
    }

    public POSTaggerME(String str, POSTagFormat pOSTagFormat) {
        this((POSModel) DownloadUtil.downloadModel(str, DownloadUtil.ModelType.POS, POSModel.class), pOSTagFormat);
    }

    public String[] getOrderedTags(List<String> list, List<String> list2, int i, double[] dArr) {
        MaxentModel maxentModel = (MaxentModel) this.modelPackage.getArtifact("pos.model");
        if (maxentModel == null) {
            throw new UnsupportedOperationException("This method can only be called if the classification model is an event model!");
        }
        double[] dArrEval = maxentModel.eval(this.contextGen.getContext(i, (String[]) list.toArray(new String[0]), (String[]) list2.toArray(new String[0]), (Object[]) null));
        String[] strArr = new String[dArrEval.length];
        for (int i2 = 0; i2 < dArrEval.length; i2++) {
            int i4 = 0;
            for (int i5 = 1; i5 < dArrEval.length; i5++) {
                if (dArrEval[i5] > dArrEval[i4]) {
                    i4 = i5;
                }
            }
            strArr[i2] = maxentModel.getOutcome(i4);
            if (dArr != null) {
                dArr[i2] = dArrEval[i4];
            }
            dArrEval[i4] = 0.0d;
        }
        return convertTags(Arrays.stream(strArr).toList());
    }

    public double[] probs() {
        return this.bestSequence.getProbs();
    }

    @Override // opennlp.tools.postag.POSTagger
    public String[] tag(String[] strArr, Object[] objArr) {
        Sequence sequenceBestSequence = this.model.bestSequence(strArr, objArr, this.contextGen, this.sequenceValidator);
        this.bestSequence = sequenceBestSequence;
        return convertTags(sequenceBestSequence.getOutcomes());
    }

    @Override // opennlp.tools.postag.POSTagger
    public Sequence[] topKSequences(String[] strArr, Object[] objArr) {
        return this.model.bestSequences(this.size, strArr, objArr, this.contextGen, this.sequenceValidator);
    }

    public POSTaggerME(POSModel pOSModel) {
        this(pOSModel, POSTagFormat.UD);
    }

    public POSTaggerME(POSModel pOSModel, POSTagFormat pOSTagFormat) {
        this.posTagFormat = pOSTagFormat;
        POSTaggerFactory factory = pOSModel.getFactory();
        String manifestProperty = pOSModel.getManifestProperty(BeamSearch.BEAM_SIZE_PARAMETER);
        int i = manifestProperty != null ? Integer.parseInt(manifestProperty) : 3;
        this.modelPackage = pOSModel;
        this.contextGen = factory.getPOSContextGenerator(i);
        this.tagDictionary = factory.getTagDictionary();
        this.size = i;
        this.sequenceValidator = factory.getSequenceValidator();
        if (pOSModel.getPosSequenceModel() != null) {
            this.model = pOSModel.getPosSequenceModel();
        } else {
            this.model = new BeamSearch(i, (MaxentModel) pOSModel.getArtifact("pos.model"), 0);
        }
        this.posTagFormatMapper = new POSTagFormatMapper(getAllPosTags());
    }

    public String[][] tag(int i, String[] strArr) {
        Sequence[] sequenceArrBestSequences = this.model.bestSequences(i, strArr, null, this.contextGen, this.sequenceValidator);
        int length = sequenceArrBestSequences.length;
        String[][] strArr2 = new String[length][];
        for (int i2 = 0; i2 < length; i2++) {
            strArr2[i2] = convertTags(sequenceArrBestSequences[i2].getOutcomes());
        }
        return strArr2;
    }
}
