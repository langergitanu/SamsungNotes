package opennlp.tools.p217ml.naivebayes;

import opennlp.tools.p217ml.AbstractEventTrainer;
import opennlp.tools.p217ml.ArrayMath;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.DataIndexer;
import opennlp.tools.p217ml.model.EvalParameters;
import opennlp.tools.p217ml.model.MutableContext;
import opennlp.tools.util.TrainingParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NaiveBayesTrainer extends AbstractEventTrainer {
    public static final String NAIVE_BAYES_VALUE = "NAIVEBAYES";
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) NaiveBayesTrainer.class);
    private int[][] contexts;
    private int numEvents;
    private int numOutcomes;
    private int numPreds;
    private int[] numTimesEventsSeen;
    private int numUniqueEvents;
    private String[] outcomeLabels;
    private int[] outcomeList;
    private String[] predLabels;
    private float[][] values;

    public NaiveBayesTrainer() {
    }

    private MutableContext[] findParameters() {
        int[] iArr = new int[this.numOutcomes];
        for (int i = 0; i < this.numOutcomes; i++) {
            iArr[i] = i;
        }
        int i2 = this.numPreds;
        MutableContext[] mutableContextArr = new MutableContext[i2];
        for (int i4 = 0; i4 < this.numPreds; i4++) {
            mutableContextArr[i4] = new MutableContext(iArr, new double[this.numOutcomes]);
            for (int i5 = 0; i5 < this.numOutcomes; i5++) {
                mutableContextArr[i4].setParameter(i5, 0.0d);
            }
        }
        double[] dArr = new double[this.outcomeLabels.length];
        for (int i6 = 0; i6 < i2; i6++) {
            MutableContext mutableContext = mutableContextArr[i6];
            for (int i7 = 0; i7 < mutableContext.getOutcomes().length; i7++) {
                int i8 = mutableContext.getOutcomes()[i7];
                dArr[i8] = dArr[i8] + mutableContext.getParameters()[i7];
            }
        }
        NaiveBayesEvalParameters naiveBayesEvalParameters = new NaiveBayesEvalParameters(mutableContextArr, this.outcomeLabels.length, dArr, this.predLabels.length);
        for (int i9 = 0; i9 < this.numUniqueEvents; i9++) {
            int i10 = this.outcomeList[i9];
            for (int i11 = 0; i11 < this.numTimesEventsSeen[i9]; i11++) {
                int i12 = 0;
                while (true) {
                    int[] iArr2 = this.contexts[i9];
                    if (i12 < iArr2.length) {
                        int i13 = iArr2[i12];
                        float[][] fArr = this.values;
                        if (fArr == null) {
                            mutableContextArr[i13].updateParameter(i10, 1.0d);
                        } else {
                            mutableContextArr[i13].updateParameter(i10, 1.0d * ((double) fArr[i9][i12]));
                        }
                        i12++;
                    }
                }
            }
        }
        trainingStats(naiveBayesEvalParameters);
        return mutableContextArr;
    }

    private double trainingStats(EvalParameters evalParameters) {
        int i = 0;
        for (int i2 = 0; i2 < this.numUniqueEvents; i2++) {
            for (int i4 = 0; i4 < this.numTimesEventsSeen[i2]; i4++) {
                double[] dArr = new double[this.numOutcomes];
                float[][] fArr = this.values;
                if (fArr != null) {
                    NaiveBayesModel.eval(this.contexts[i2], fArr[i2], dArr, evalParameters, false);
                } else {
                    NaiveBayesModel.eval(this.contexts[i2], (float[]) null, dArr, evalParameters, false);
                }
                if (ArrayMath.argmax(dArr) == this.outcomeList[i2]) {
                    i++;
                }
            }
        }
        double d = ((double) i) / ((double) this.numEvents);
        logger.info("Stats: ({}/{}) {}", Integer.valueOf(i), Integer.valueOf(this.numEvents), Double.valueOf(d));
        return d;
    }

    @Override // opennlp.tools.p217ml.AbstractEventTrainer
    public boolean isSortAndMerge() {
        return false;
    }

    public AbstractModel trainModel(DataIndexer dataIndexer) {
        Logger logger2 = logger;
        logger2.info("Incorporating indexed data for training...");
        this.contexts = dataIndexer.getContexts();
        this.values = dataIndexer.getValues();
        this.numTimesEventsSeen = dataIndexer.getNumTimesEventsSeen();
        this.numEvents = dataIndexer.getNumEvents();
        this.numUniqueEvents = this.contexts.length;
        this.outcomeLabels = dataIndexer.getOutcomeLabels();
        this.outcomeList = dataIndexer.getOutcomeList();
        String[] predLabels = dataIndexer.getPredLabels();
        this.predLabels = predLabels;
        this.numPreds = predLabels.length;
        this.numOutcomes = this.outcomeLabels.length;
        logger2.info("done.");
        logger2.info("\tNumber of Event Tokens: {} \n\t Number of Outcomes: {} \n\t Number of Predicates: {}", Integer.valueOf(this.numUniqueEvents), Integer.valueOf(this.numOutcomes), Integer.valueOf(this.numPreds));
        logger2.info("Computing model parameters...");
        MutableContext[] mutableContextArrFindParameters = findParameters();
        logger2.info("...done.");
        return new NaiveBayesModel(mutableContextArrFindParameters, this.predLabels, this.outcomeLabels);
    }

    public NaiveBayesTrainer(TrainingParameters trainingParameters) {
        super(trainingParameters);
    }

    @Override // opennlp.tools.p217ml.AbstractEventTrainer
    public AbstractModel doTrain(DataIndexer dataIndexer) {
        return trainModel(dataIndexer);
    }
}
