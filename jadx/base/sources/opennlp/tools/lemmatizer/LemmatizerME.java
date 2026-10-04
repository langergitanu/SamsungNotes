package opennlp.tools.lemmatizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import opennlp.tools.p217ml.BeamSearch;
import opennlp.tools.p217ml.TrainerFactory;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.p217ml.model.SequenceClassificationModel;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Sequence;
import opennlp.tools.util.SequenceValidator;
import opennlp.tools.util.StringUtil;
import opennlp.tools.util.TrainingParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LemmatizerME implements Lemmatizer {
    public static final int DEFAULT_BEAM_SIZE = 3;
    public static final int LEMMA_NUMBER = 29;
    protected final int beamSize;
    private Sequence bestSequence;
    private final LemmatizerContextGenerator contextGenerator;
    private final SequenceClassificationModel model;
    private final SequenceValidator<String> sequenceValidator;

    public LemmatizerME(LemmatizerModel lemmatizerModel) {
        LemmatizerFactory factory = lemmatizerModel.getFactory();
        String manifestProperty = lemmatizerModel.getManifestProperty(BeamSearch.BEAM_SIZE_PARAMETER);
        int i = manifestProperty != null ? Integer.parseInt(manifestProperty) : 3;
        this.contextGenerator = factory.getContextGenerator();
        this.beamSize = i;
        this.sequenceValidator = factory.getSequenceValidator();
        if (lemmatizerModel.getLemmatizerSequenceModel() != null) {
            this.model = lemmatizerModel.getLemmatizerSequenceModel();
        } else {
            this.model = new BeamSearch(i, (MaxentModel) lemmatizerModel.getLemmatizerSequenceModel(), 0);
        }
    }

    public static String[] decodeLemmas(String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            String strDecodeShortestEditScript = StringUtil.decodeShortestEditScript(strArr[i].toLowerCase(), strArr2[i]);
            if (strDecodeShortestEditScript.length() == 0) {
                strDecodeShortestEditScript = "_";
            }
            arrayList.add(strDecodeShortestEditScript);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static String[] encodeLemmas(String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            String shortestEditScript = StringUtil.getShortestEditScript(strArr[i], strArr2[i]);
            if (shortestEditScript.length() == 0) {
                shortestEditScript = "_";
            }
            arrayList.add(shortestEditScript);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static LemmatizerModel train(String str, ObjectStream<LemmaSample> objectStream, TrainingParameters trainingParameters, LemmatizerFactory lemmatizerFactory) {
        SequenceClassificationModel sequenceClassificationModelTrain;
        MaxentModel maxentModelTrain;
        LemmatizerContextGenerator contextGenerator = lemmatizerFactory.getContextGenerator();
        HashMap map = new HashMap();
        TrainerFactory.TrainerType trainerType = TrainerFactory.getTrainerType(trainingParameters);
        MaxentModel maxentModel = null;
        if (TrainerFactory.TrainerType.EVENT_MODEL_TRAINER.equals(trainerType)) {
            maxentModelTrain = TrainerFactory.getEventTrainer(trainingParameters, map).train(new LemmaSampleEventStream(objectStream, contextGenerator));
        } else {
            if (!TrainerFactory.TrainerType.EVENT_MODEL_SEQUENCE_TRAINER.equals(trainerType)) {
                if (TrainerFactory.TrainerType.SEQUENCE_TRAINER.equals(trainerType)) {
                    sequenceClassificationModelTrain = TrainerFactory.getSequenceModelTrainer(trainingParameters, map).train(new LemmaSampleSequenceStream(objectStream, contextGenerator));
                    return maxentModel == null ? new LemmatizerModel(str, maxentModel, trainingParameters.getIntParameter(BeamSearch.BEAM_SIZE_PARAMETER, 3), map, lemmatizerFactory) : new LemmatizerModel(str, sequenceClassificationModelTrain, map, lemmatizerFactory);
                }
                throw new IllegalArgumentException("Trainer type is not supported: " + trainerType);
            }
            maxentModelTrain = TrainerFactory.getEventModelSequenceTrainer(trainingParameters, map).train(new LemmaSampleSequenceStream(objectStream, contextGenerator));
        }
        maxentModel = maxentModelTrain;
        sequenceClassificationModelTrain = null;
        if (maxentModel == null) {
        }
    }

    @Override // opennlp.tools.lemmatizer.Lemmatizer
    public String[] lemmatize(String[] strArr, String[] strArr2) {
        return decodeLemmas(strArr, predictSES(strArr, strArr2));
    }

    public String[][] predictLemmas(int i, String[] strArr, String[] strArr2) {
        Sequence[] sequenceArrBestSequences = this.model.bestSequences(i, strArr, new Object[]{strArr2}, this.contextGenerator, this.sequenceValidator);
        int length = sequenceArrBestSequences.length;
        String[][] strArr3 = new String[length][];
        for (int i2 = 0; i2 < length; i2++) {
            strArr3[i2] = decodeLemmas(strArr, (String[]) sequenceArrBestSequences[i2].getOutcomes().toArray(new String[0]));
        }
        return strArr3;
    }

    public String[] predictSES(String[] strArr, String[] strArr2) {
        Sequence sequenceBestSequence = this.model.bestSequence(strArr, new Object[]{strArr2}, this.contextGenerator, this.sequenceValidator);
        this.bestSequence = sequenceBestSequence;
        return (String[]) sequenceBestSequence.getOutcomes().toArray(new String[0]);
    }

    public void probs(double[] dArr) {
        this.bestSequence.getProbs(dArr);
    }

    public Sequence[] topKLemmaClasses(String[] strArr, String[] strArr2) {
        return this.model.bestSequences(3, strArr, new Object[]{strArr2}, this.contextGenerator, this.sequenceValidator);
    }

    public Sequence[] topKSequences(String[] strArr, String[] strArr2) {
        return this.model.bestSequences(3, strArr, new Object[]{strArr2}, this.contextGenerator, this.sequenceValidator);
    }

    public double[] probs() {
        return this.bestSequence.getProbs();
    }

    public Sequence[] topKLemmaClasses(String[] strArr, String[] strArr2, double d) {
        return this.model.bestSequences(3, strArr, new Object[]{strArr2}, d, this.contextGenerator, this.sequenceValidator);
    }

    public Sequence[] topKSequences(String[] strArr, String[] strArr2, double d) {
        return this.model.bestSequences(3, strArr, new Object[]{strArr2}, d, this.contextGenerator, this.sequenceValidator);
    }

    @Override // opennlp.tools.lemmatizer.Lemmatizer
    public List<List<String>> lemmatize(List<String> list, List<String> list2) {
        String[][] strArrPredictLemmas = predictLemmas(29, (String[]) list.toArray(new String[0]), (String[]) list2.toArray(new String[0]));
        ArrayList arrayList = new ArrayList();
        for (String[] strArr : strArrPredictLemmas) {
            arrayList.add(Arrays.asList(strArr));
        }
        return arrayList;
    }
}
