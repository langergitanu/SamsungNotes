package opennlp.tools.namefind;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import opennlp.tools.p217ml.BeamSearch;
import opennlp.tools.p217ml.TrainerFactory;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.p217ml.model.SequenceClassificationModel;
import opennlp.tools.p217ml.perceptron.PerceptronTrainer;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Sequence;
import opennlp.tools.util.SequenceCodec;
import opennlp.tools.util.SequenceValidator;
import opennlp.tools.util.Span;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.featuregen.AdditionalContextFeatureGenerator;
import opennlp.tools.util.featuregen.WindowFeatureGenerator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NameFinderME implements TokenNameFinder {
    public static final String CONTINUE = "cont";
    public static final int DEFAULT_BEAM_SIZE = 3;
    public static final String OTHER = "other";
    public static final String START = "start";
    private final AdditionalContextFeatureGenerator additionalContextFeatureGenerator;
    private Sequence bestSequence;
    protected final NameContextGenerator contextGenerator;
    protected final SequenceClassificationModel model;
    private final SequenceCodec<String> seqCodec;
    private final SequenceValidator<String> sequenceValidator;
    private static final String[][] EMPTY = (String[][]) Array.newInstance((Class<?>) String.class, 0, 0);
    private static final Pattern typedOutcomePattern = Pattern.compile("(.+)-\\w+");

    public NameFinderME(TokenNameFinderModel tokenNameFinderModel) {
        AdditionalContextFeatureGenerator additionalContextFeatureGenerator = new AdditionalContextFeatureGenerator();
        this.additionalContextFeatureGenerator = additionalContextFeatureGenerator;
        TokenNameFinderFactory factory = tokenNameFinderModel.getFactory();
        SequenceCodec<String> sequenceCodecCreateSequenceCodec = factory.createSequenceCodec();
        this.seqCodec = sequenceCodecCreateSequenceCodec;
        this.sequenceValidator = sequenceCodecCreateSequenceCodec.createSequenceValidator2();
        this.model = tokenNameFinderModel.getNameFinderSequenceModel();
        NameContextGenerator nameContextGeneratorCreateContextGenerator = factory.createContextGenerator();
        this.contextGenerator = nameContextGeneratorCreateContextGenerator;
        nameContextGeneratorCreateContextGenerator.addFeatureGenerator(new WindowFeatureGenerator(additionalContextFeatureGenerator, 8, 8));
    }

    public static Span[] dropOverlappingSpans(Span[] spanArr) {
        ArrayList arrayList = new ArrayList(spanArr.length);
        Collections.addAll(arrayList, spanArr);
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        Span span = null;
        while (it.hasNext()) {
            Span span2 = (Span) it.next();
            if (span == null || !span.intersects(span2)) {
                span = span2;
            } else {
                it.remove();
            }
        }
        return (Span[]) arrayList.toArray(new Span[0]);
    }

    public static String extractNameType(String str) {
        Matcher matcher = typedOutcomePattern.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    private Span[] setProbs(Span[] spanArr) {
        double[] dArrProbs = probs(spanArr);
        if (dArrProbs != null) {
            for (int i = 0; i < dArrProbs.length; i++) {
                spanArr[i] = new Span(spanArr[i], dArrProbs[i]);
            }
        }
        return spanArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TokenNameFinderModel train(String str, String str2, ObjectStream<NameSample> objectStream, TrainingParameters trainingParameters, TokenNameFinderFactory tokenNameFinderFactory) {
        MaxentModel maxentModel;
        MaxentModel maxentModelTrain;
        trainingParameters.putIfAbsent("Algorithm", PerceptronTrainer.PERCEPTRON_VALUE);
        trainingParameters.putIfAbsent("Cutoff", 0);
        trainingParameters.putIfAbsent("Iterations", 300);
        int intParameter = trainingParameters.getIntParameter(BeamSearch.BEAM_SIZE_PARAMETER, 3);
        HashMap map = new HashMap();
        TrainerFactory.TrainerType trainerType = TrainerFactory.getTrainerType(trainingParameters);
        SequenceClassificationModel sequenceClassificationModelTrain = null;
        if (TrainerFactory.TrainerType.EVENT_MODEL_TRAINER.equals(trainerType)) {
            maxentModelTrain = TrainerFactory.getEventTrainer(trainingParameters, map).train(new NameFinderEventStream(objectStream, str2, tokenNameFinderFactory.createContextGenerator(), tokenNameFinderFactory.createSequenceCodec()));
        } else {
            if (!TrainerFactory.TrainerType.EVENT_MODEL_SEQUENCE_TRAINER.equals(trainerType)) {
                if (!TrainerFactory.TrainerType.SEQUENCE_TRAINER.equals(trainerType)) {
                    throw new IllegalStateException("Unexpected trainer type!");
                }
                maxentModel = null;
                sequenceClassificationModelTrain = TrainerFactory.getSequenceModelTrainer(trainingParameters, map).train(new NameSampleSequenceStream(objectStream, tokenNameFinderFactory.createContextGenerator(), false));
                if (sequenceClassificationModelTrain != null) {
                    return new TokenNameFinderModel(str, maxentModel, intParameter, tokenNameFinderFactory.getFeatureGenerator(), tokenNameFinderFactory.getResources(), map, tokenNameFinderFactory.getSequenceCodec(), tokenNameFinderFactory);
                }
                return new TokenNameFinderModel(str, sequenceClassificationModelTrain, tokenNameFinderFactory.getFeatureGenerator(), tokenNameFinderFactory.getResources(), map, tokenNameFinderFactory.getSequenceCodec(), tokenNameFinderFactory);
            }
            maxentModelTrain = TrainerFactory.getEventModelSequenceTrainer(trainingParameters, map).train(new NameSampleSequenceStream(objectStream, tokenNameFinderFactory.createContextGenerator()));
        }
        maxentModel = maxentModelTrain;
        if (sequenceClassificationModelTrain != null) {
        }
    }

    @Override // opennlp.tools.namefind.TokenNameFinder
    public void clearAdaptiveData() {
        this.contextGenerator.clearAdaptiveData();
    }

    @Override // opennlp.tools.namefind.TokenNameFinder
    public Span[] find(String[] strArr) {
        return find(strArr, EMPTY);
    }

    public void probs(double[] dArr) {
        this.bestSequence.getProbs(dArr);
    }

    public Span[] find(String[] strArr, String[][] strArr2) {
        this.additionalContextFeatureGenerator.setCurrentContext(strArr2);
        Sequence sequenceBestSequence = this.model.bestSequence(strArr, strArr2, this.contextGenerator, this.sequenceValidator);
        this.bestSequence = sequenceBestSequence;
        List<String> outcomes = sequenceBestSequence.getOutcomes();
        this.contextGenerator.updateAdaptiveData(strArr, (String[]) outcomes.toArray(new String[0]));
        return setProbs(this.seqCodec.decode(outcomes));
    }

    public double[] probs() {
        return this.bestSequence.getProbs();
    }

    public double[] probs(Span[] spanArr) {
        double[] dArr = new double[spanArr.length];
        double[] probs = this.bestSequence.getProbs();
        for (int i = 0; i < spanArr.length; i++) {
            double d = 0.0d;
            for (int start = spanArr[i].getStart(); start < spanArr[i].getEnd(); start++) {
                d += probs[start];
            }
            dArr[i] = d / ((double) spanArr[i].length());
        }
        return dArr;
    }
}
