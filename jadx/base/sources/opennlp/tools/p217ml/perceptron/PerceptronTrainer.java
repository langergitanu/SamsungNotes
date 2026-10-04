package opennlp.tools.p217ml.perceptron;

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
public class PerceptronTrainer extends AbstractEventTrainer {
    public static final String PERCEPTRON_VALUE = "PERCEPTRON";
    public static final double TOLERANCE_DEFAULT = 1.0E-5d;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) PerceptronTrainer.class);
    private int[][] contexts;
    private int numEvents;
    private int numOutcomes;
    private int numPreds;
    private int[] numTimesEventsSeen;
    private int numUniqueEvents;
    private String[] outcomeLabels;
    private int[] outcomeList;
    private String[] predLabels;
    private Double stepSizeDecrease;
    private double tolerance;
    private boolean useSkippedlAveraging;
    private float[][] values;

    public PerceptronTrainer() {
        this.tolerance = 1.0E-5d;
    }

    private MutableContext[] findParameters(int i, boolean z) {
        double d;
        MutableContext[] mutableContextArr;
        MutableContext[] mutableContextArr2;
        double d2;
        int i2;
        double d3;
        int i4;
        logger.info("Performing {} iterations.", Integer.valueOf(i));
        int[] iArr = new int[this.numOutcomes];
        for (int i5 = 0; i5 < this.numOutcomes; i5++) {
            iArr[i5] = i5;
        }
        MutableContext[] mutableContextArr3 = new MutableContext[this.numPreds];
        int i6 = 0;
        while (true) {
            d = 0.0d;
            if (i6 >= this.numPreds) {
                break;
            }
            mutableContextArr3[i6] = new MutableContext(iArr, new double[this.numOutcomes]);
            for (int i7 = 0; i7 < this.numOutcomes; i7++) {
                mutableContextArr3[i6].setParameter(i7, 0.0d);
            }
            i6++;
        }
        EvalParameters evalParameters = new EvalParameters(mutableContextArr3, this.numOutcomes);
        MutableContext[] mutableContextArr4 = new MutableContext[this.numPreds];
        if (z) {
            for (int i8 = 0; i8 < this.numPreds; i8++) {
                mutableContextArr4[i8] = new MutableContext(iArr, new double[this.numOutcomes]);
                for (int i9 = 0; i9 < this.numOutcomes; i9++) {
                    mutableContextArr4[i8].setParameter(i9, 0.0d);
                }
            }
        }
        int i10 = 1;
        double d4 = 0.0d;
        double d5 = 0.0d;
        double dDoubleValue = 1.0d;
        int i11 = 0;
        while (true) {
            if (i10 > i) {
                mutableContextArr = mutableContextArr3;
                mutableContextArr2 = mutableContextArr4;
                break;
            }
            Double d6 = this.stepSizeDecrease;
            if (d6 != null) {
                dDoubleValue *= 1.0d - d6.doubleValue();
            }
            double d7 = dDoubleValue;
            int i12 = 0;
            int i13 = 0;
            while (i12 < this.numUniqueEvents) {
                int i14 = this.outcomeList[i12];
                MutableContext[] mutableContextArr5 = mutableContextArr3;
                MutableContext[] mutableContextArr6 = mutableContextArr4;
                int i15 = 0;
                while (i15 < this.numTimesEventsSeen[i12]) {
                    double[] dArr = new double[this.numOutcomes];
                    int i16 = i15;
                    float[][] fArr = this.values;
                    if (fArr != null) {
                        d2 = d;
                        i2 = 0;
                        PerceptronModel.eval(this.contexts[i12], fArr[i12], dArr, evalParameters, false);
                    } else {
                        d2 = d;
                        i2 = 0;
                        PerceptronModel.eval(this.contexts[i12], (float[]) null, dArr, evalParameters, false);
                    }
                    int iArgmax = ArrayMath.argmax(dArr);
                    if (iArgmax != i14) {
                        int i17 = i2;
                        while (true) {
                            int[] iArr2 = this.contexts[i12];
                            if (i17 >= iArr2.length) {
                                break;
                            }
                            int i18 = iArr2[i17];
                            float[][] fArr2 = this.values;
                            if (fArr2 == null) {
                                mutableContextArr5[i18].updateParameter(i14, d7);
                                d3 = d4;
                                mutableContextArr5[i18].updateParameter(iArgmax, -d7);
                                i4 = i17;
                            } else {
                                d3 = d4;
                                i4 = i17;
                                mutableContextArr5[i18].updateParameter(i14, ((double) fArr2[i12][i17]) * d7);
                                mutableContextArr5[i18].updateParameter(iArgmax, ((double) this.values[i12][i4]) * (-d7));
                            }
                            i17 = i4 + 1;
                            d4 = d3;
                        }
                    }
                    double d8 = d4;
                    if (iArgmax == i14) {
                        i13++;
                    }
                    i15 = i16 + 1;
                    d = d2;
                    d4 = d8;
                }
                i12++;
                mutableContextArr3 = mutableContextArr5;
                mutableContextArr4 = mutableContextArr6;
            }
            mutableContextArr = mutableContextArr3;
            mutableContextArr2 = mutableContextArr4;
            double d9 = d;
            double d10 = d4;
            int i19 = i13;
            double d11 = ((double) i19) / ((double) this.numEvents);
            if (i10 < 10 || i10 % 10 == 0) {
                logger.info("{}: ({}/{}) {}", Integer.valueOf(i10), Integer.valueOf(i19), Integer.valueOf(this.numEvents), Double.valueOf(d11));
            }
            if ((z && this.useSkippedlAveraging && (i10 < 20 || isPerfectSquare(i10))) || z) {
                i11++;
                int i20 = 0;
                while (i20 < this.numPreds) {
                    int i21 = 0;
                    while (i21 < this.numOutcomes) {
                        mutableContextArr2[i20].updateParameter(i21, mutableContextArr[i20].getParameters()[i21]);
                        i21++;
                        i10 = i10;
                        i20 = i20;
                    }
                    i20++;
                }
            }
            int i22 = i10;
            if (StrictMath.abs(d9 - d11) < this.tolerance && StrictMath.abs(d10 - d11) < this.tolerance) {
                double dAbs = StrictMath.abs(d5 - d11);
                double d12 = this.tolerance;
                if (dAbs < d12) {
                    logger.warn("Stopping: change in training set accuracy less than {}", Double.valueOf(d12));
                    break;
                }
            }
            i10 = i22 + 1;
            dDoubleValue = d7;
            d4 = d5;
            mutableContextArr3 = mutableContextArr;
            mutableContextArr4 = mutableContextArr2;
            d5 = d11;
            d = d10;
        }
        int i23 = i11;
        trainingStats(evalParameters);
        if (!z) {
            return mutableContextArr;
        }
        for (int i24 = 0; i24 < this.numPreds; i24++) {
            for (int i25 = 0; i25 < this.numOutcomes; i25++) {
                MutableContext mutableContext = mutableContextArr2[i24];
                mutableContext.setParameter(i25, mutableContext.getParameters()[i25] / ((double) i23));
            }
        }
        return mutableContextArr2;
    }

    private static boolean isPerfectSquare(int i) {
        int iSqrt = (int) StrictMath.sqrt(i);
        return iSqrt * iSqrt == i;
    }

    private double trainingStats(EvalParameters evalParameters) {
        int i = 0;
        for (int i2 = 0; i2 < this.numUniqueEvents; i2++) {
            for (int i4 = 0; i4 < this.numTimesEventsSeen[i2]; i4++) {
                double[] dArr = new double[this.numOutcomes];
                float[][] fArr = this.values;
                if (fArr != null) {
                    PerceptronModel.eval(this.contexts[i2], fArr[i2], dArr, evalParameters, false);
                } else {
                    PerceptronModel.eval(this.contexts[i2], (float[]) null, dArr, evalParameters, false);
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

    public void setSkippedAveraging(boolean z) {
        this.useSkippedlAveraging = z;
    }

    public void setStepSizeDecrease(double d) {
        if (d >= 0.0d && d <= 100.0d) {
            this.stepSizeDecrease = Double.valueOf(d);
            return;
        }
        throw new IllegalArgumentException("decrease must be between 0 and 100 but is " + d + "!");
    }

    public void setTolerance(double d) {
        if (d >= 0.0d) {
            this.tolerance = d;
            return;
        }
        throw new IllegalArgumentException("tolerance must be a positive number but is " + d + "!");
    }

    public AbstractModel trainModel(int i, DataIndexer dataIndexer, int i2) {
        return trainModel(i, dataIndexer, i2, true);
    }

    @Override // opennlp.tools.p217ml.AbstractEventTrainer, opennlp.tools.p217ml.AbstractTrainer
    public void validate() {
        super.validate();
        String algorithm = getAlgorithm();
        if (algorithm != null && !PERCEPTRON_VALUE.equals(algorithm)) {
            throw new IllegalArgumentException("algorithmName must be PERCEPTRON");
        }
    }

    @Override // opennlp.tools.p217ml.AbstractEventTrainer
    public AbstractModel doTrain(DataIndexer dataIndexer) {
        int iterations = getIterations();
        int cutoff = getCutoff();
        boolean booleanParameter = this.trainingParameters.getBooleanParameter("UseAverage", true);
        boolean booleanParameter2 = this.trainingParameters.getBooleanParameter("UseSkippedAveraging", false);
        boolean z = booleanParameter2 ? true : booleanParameter;
        double doubleParameter = this.trainingParameters.getDoubleParameter("StepSizeDecrease", 0.0d);
        double doubleParameter2 = this.trainingParameters.getDoubleParameter("Tolerance", 1.0E-5d);
        setSkippedAveraging(booleanParameter2);
        if (doubleParameter > 0.0d) {
            setStepSizeDecrease(doubleParameter);
        }
        setTolerance(doubleParameter2);
        return trainModel(iterations, dataIndexer, cutoff, z);
    }

    public AbstractModel trainModel(int i, DataIndexer dataIndexer, int i2, boolean z) {
        Logger logger2 = logger;
        logger2.info("Incorporating indexed data for training... ");
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
        MutableContext[] mutableContextArrFindParameters = findParameters(i, z);
        logger2.info("...done.");
        return new PerceptronModel(mutableContextArrFindParameters, this.predLabels, this.outcomeLabels);
    }

    public PerceptronTrainer(TrainingParameters trainingParameters) {
        super(trainingParameters);
        this.tolerance = 1.0E-5d;
    }
}
