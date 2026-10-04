package opennlp.tools.p217ml.maxent;

import androidx.appcompat.widget.AbstractC0541b;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import opennlp.tools.cmdline.ThreadFactoryC13623a;
import opennlp.tools.p217ml.AbstractEventTrainer;
import opennlp.tools.p217ml.ArrayMath;
import opennlp.tools.p217ml.model.DataIndexer;
import opennlp.tools.p217ml.model.EvalParameters;
import opennlp.tools.p217ml.model.Event;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.p217ml.model.MutableContext;
import opennlp.tools.p217ml.model.OnePassDataIndexer;
import opennlp.tools.p217ml.model.Prior;
import opennlp.tools.p217ml.model.UniformPrior;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.TrainingParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class GISTrainer extends AbstractEventTrainer {
    private static final boolean GAUSSIAN_SMOOTHING_DEFAULT = false;
    private static final String GAUSSIAN_SMOOTHING_PARAM = "GaussianSmoothing";
    private static final double GAUSSIAN_SMOOTHING_SIGMA_DEFAULT = 2.0d;
    private static final String GAUSSIAN_SMOOTHING_SIGMA_PARAM = "GaussianSmoothingSigma";
    public static final double LOG_LIKELIHOOD_THRESHOLD_DEFAULT = 1.0E-4d;
    public static final String LOG_LIKELIHOOD_THRESHOLD_PARAM = "LLThreshold";
    public static final String MAXENT_VALUE = "MAXENT";
    private static final boolean SMOOTHING_DEFAULT = false;
    private static final double SMOOTHING_OBSERVATION = 0.1d;
    private static final String SMOOTHING_OBSERVATION_PARAM = "SmoothingObservation";
    private static final String SMOOTHING_PARAM = "Smoothing";
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) GISTrainer.class);
    private int[][] contexts;
    private EvalParameters evalParams;
    private MutableContext[][] modelExpects;
    private int numOutcomes;
    private int numPreds;
    private int[] numTimesEventsSeen;
    private int numUniqueEvents;
    private MutableContext[] observedExpects;
    private String[] outcomeLabels;
    private int[] outcomeList;
    private MutableContext[] params;
    private String[] predLabels;
    private Prior prior;
    private float[][] values;
    private double llThreshold = 1.0E-4d;
    private boolean useSimpleSmoothing = false;
    private boolean useGaussianSmoothing = false;
    private double sigma = 2.0d;
    private double _smoothingObservation = 0.1d;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ModelExpectationComputeTask implements Callable<ModelExpectationComputeTask> {
        private final int length;
        private final int startIndex;
        private final int threadIndex;
        private double loglikelihood = 0.0d;
        private int numEvents = 0;
        private int numCorrect = 0;

        public ModelExpectationComputeTask(int i, int i2, int i4) {
            this.startIndex = i2;
            this.length = i4;
            this.threadIndex = i;
        }

        public synchronized double getLoglikelihood() {
            return this.loglikelihood;
        }

        public synchronized int getNumCorrect() {
            return this.numCorrect;
        }

        public synchronized int getNumEvents() {
            return this.numEvents;
        }

        @Override // java.util.concurrent.Callable
        public ModelExpectationComputeTask call() {
            double[] dArr = new double[GISTrainer.this.numOutcomes];
            for (int i = this.startIndex; i < this.startIndex + this.length; i++) {
                if (GISTrainer.this.values != null) {
                    GISTrainer.this.prior.logPrior(dArr, GISTrainer.this.contexts[i], GISTrainer.this.values[i]);
                    GISModel.eval(GISTrainer.this.contexts[i], GISTrainer.this.values[i], dArr, GISTrainer.this.evalParams);
                } else {
                    GISTrainer.this.prior.logPrior(dArr, GISTrainer.this.contexts[i]);
                    GISModel.eval(GISTrainer.this.contexts[i], dArr, GISTrainer.this.evalParams);
                }
                for (int i2 = 0; i2 < GISTrainer.this.contexts[i].length; i2++) {
                    int i4 = GISTrainer.this.contexts[i][i2];
                    int[] outcomes = GISTrainer.this.modelExpects[this.threadIndex][i4].getOutcomes();
                    for (int i5 = 0; i5 < outcomes.length; i5++) {
                        int i6 = outcomes[i5];
                        if (GISTrainer.this.values == null || GISTrainer.this.values[i] == null) {
                            GISTrainer.this.modelExpects[this.threadIndex][i4].updateParameter(i5, dArr[i6] * ((double) GISTrainer.this.numTimesEventsSeen[i]));
                        } else {
                            GISTrainer.this.modelExpects[this.threadIndex][i4].updateParameter(i5, dArr[i6] * ((double) GISTrainer.this.values[i][i2]) * ((double) GISTrainer.this.numTimesEventsSeen[i]));
                        }
                    }
                }
                this.loglikelihood = (StrictMath.log(dArr[GISTrainer.this.outcomeList[i]]) * ((double) GISTrainer.this.numTimesEventsSeen[i])) + this.loglikelihood;
                this.numEvents += GISTrainer.this.numTimesEventsSeen[i];
                if (ArrayMath.argmax(dArr) == GISTrainer.this.outcomeList[i]) {
                    this.numCorrect += GISTrainer.this.numTimesEventsSeen[i];
                }
            }
            return this;
        }
    }

    private void findParameters(int i, double d) {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(this.modelExpects.length, new ThreadFactoryC13623a(1));
        ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(executorServiceNewFixedThreadPool);
        logger.info("Performing {} iterations.", Integer.valueOf(i));
        double d2 = 0.0d;
        int i2 = 1;
        while (true) {
            if (i2 > i) {
                break;
            }
            double dNextIteration = nextIteration(d, executorCompletionService, i2);
            if (i2 > 1) {
                if (d2 > dNextIteration) {
                    logger.warn("Model Diverging: loglikelihood decreased");
                    break;
                } else if (dNextIteration - d2 < this.llThreshold) {
                    break;
                }
            }
            i2++;
            d2 = dNextIteration;
        }
        this.observedExpects = null;
        this.modelExpects = null;
        this.numTimesEventsSeen = null;
        this.contexts = null;
        executorServiceNewFixedThreadPool.shutdown();
    }

    private double gaussianUpdate(int i, int i2, double d) {
        double d2 = this.params[i].getParameters()[i2];
        int i4 = 0;
        double d3 = this.modelExpects[0][i].getParameters()[i2];
        double d4 = this.observedExpects[i].getParameters()[i2];
        double d5 = 0.0d;
        while (i4 < 50) {
            double dExp = StrictMath.exp(d * d5) * d3;
            double d6 = this.sigma;
            double d7 = (((d2 + d5) / d6) + dExp) - d4;
            double d8 = (1.0d / d6) + (dExp * d);
            if (d8 == 0.0d) {
                break;
            }
            double d9 = d5 - (d7 / d8);
            if (StrictMath.abs(d9 - d5) < 1.0E-6d) {
                return d9;
            }
            i4++;
            d5 = d9;
        }
        return d5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$findParameters$0(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("opennlp.tools.ml.maxent.ModelExpectationComputeTask.nextIteration()");
        thread.setDaemon(true);
        return thread;
    }

    private double nextIteration(double d, CompletionService<ModelExpectationComputeTask> completionService, int i) {
        GISTrainer gISTrainer = this;
        int length = gISTrainer.modelExpects.length;
        int i2 = gISTrainer.numUniqueEvents;
        int i4 = i2 / length;
        int i5 = i2 % length;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            if (i7 < i5) {
                completionService.submit(gISTrainer.new ModelExpectationComputeTask(i7, (i7 * i4) + i7, i4 + 1));
            } else {
                completionService.submit(gISTrainer.new ModelExpectationComputeTask(i7, (i7 * i4) + i5, i4));
            }
        }
        int numEvents = 0;
        int numCorrect = 0;
        double loglikelihood = 0.0d;
        for (int i8 = 0; i8 < length; i8++) {
            try {
                ModelExpectationComputeTask modelExpectationComputeTask = completionService.take().get();
                numEvents += modelExpectationComputeTask.getNumEvents();
                numCorrect += modelExpectationComputeTask.getNumCorrect();
                loglikelihood += modelExpectationComputeTask.getLoglikelihood();
            } catch (InterruptedException e) {
                throw new IllegalStateException("Interruption is not supported!", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException(AbstractC0541b.m772n("Exception during training: ", e2.getMessage()), e2);
            }
        }
        for (int i9 = 0; i9 < gISTrainer.numPreds; i9++) {
            int[] outcomes = gISTrainer.params[i9].getOutcomes();
            for (int i10 = 0; i10 < outcomes.length; i10++) {
                int i11 = 1;
                while (true) {
                    MutableContext[][] mutableContextArr = gISTrainer.modelExpects;
                    if (i11 < mutableContextArr.length) {
                        mutableContextArr[0][i9].updateParameter(i10, mutableContextArr[i11][i9].getParameters()[i10]);
                        i11++;
                    }
                }
            }
        }
        int i12 = 0;
        while (i12 < gISTrainer.numPreds) {
            double[] parameters = gISTrainer.observedExpects[i12].getParameters();
            double[] parameters2 = gISTrainer.modelExpects[i6][i12].getParameters();
            int[] outcomes2 = gISTrainer.params[i12].getOutcomes();
            int i13 = i6;
            while (i13 < outcomes2.length) {
                if (gISTrainer.useGaussianSmoothing) {
                    gISTrainer.params[i12].updateParameter(i13, gISTrainer.gaussianUpdate(i12, i13, d));
                } else {
                    if (parameters2[i13] == 0.0d) {
                        logger.warn("Model expects == 0 for {} {}", gISTrainer.predLabels[i12], gISTrainer.outcomeLabels[i13]);
                    }
                    gISTrainer.params[i12].updateParameter(i13, (StrictMath.log(parameters[i13]) - StrictMath.log(parameters2[i13])) / d);
                }
                MutableContext[][] mutableContextArr2 = gISTrainer.modelExpects;
                int length2 = mutableContextArr2.length;
                int i14 = 0;
                while (i14 < length2) {
                    mutableContextArr2[i14][i12].setParameter(i13, 0.0d);
                    i14++;
                    i12 = i12;
                }
                i13++;
                i12 = i12;
                gISTrainer = this;
            }
            i12++;
            i6 = 0;
            gISTrainer = this;
        }
        logger.info("{} - loglikelihood={}\t{}", Integer.valueOf(i), Double.valueOf(loglikelihood), Double.valueOf(((double) numCorrect) / ((double) numEvents)));
        return loglikelihood;
    }

    @Override // opennlp.tools.p217ml.AbstractEventTrainer
    public MaxentModel doTrain(DataIndexer dataIndexer) {
        return trainModel(getIterations(), dataIndexer, this.trainingParameters.getIntParameter("Threads", 1));
    }

    @Override // opennlp.tools.p217ml.AbstractTrainer, opennlp.tools.commons.Trainer
    public void init(TrainingParameters trainingParameters, Map<String, String> map) {
        super.init(trainingParameters, map);
        this.llThreshold = trainingParameters.getDoubleParameter(LOG_LIKELIHOOD_THRESHOLD_PARAM, 1.0E-4d);
        boolean booleanParameter = trainingParameters.getBooleanParameter(SMOOTHING_PARAM, false);
        this.useSimpleSmoothing = booleanParameter;
        if (booleanParameter) {
            this._smoothingObservation = trainingParameters.getDoubleParameter(SMOOTHING_OBSERVATION_PARAM, 0.1d);
        }
        boolean booleanParameter2 = trainingParameters.getBooleanParameter(GAUSSIAN_SMOOTHING_PARAM, false);
        this.useGaussianSmoothing = booleanParameter2;
        if (booleanParameter2) {
            this.sigma = trainingParameters.getDoubleParameter(GAUSSIAN_SMOOTHING_SIGMA_PARAM, 2.0d);
        }
        if (this.useSimpleSmoothing && this.useGaussianSmoothing) {
            throw new RuntimeException("Cannot set both Gaussian smoothing and Simple smoothing");
        }
    }

    @Override // opennlp.tools.p217ml.AbstractEventTrainer
    public boolean isSortAndMerge() {
        return true;
    }

    public void setGaussianSigma(double d) {
        this.useGaussianSmoothing = true;
        this.sigma = d;
    }

    public void setSmoothing(boolean z) {
        this.useSimpleSmoothing = z;
    }

    public void setSmoothingObservation(double d) {
        this._smoothingObservation = d;
    }

    public GISModel trainModel(ObjectStream<Event> objectStream) {
        return trainModel(objectStream, 100, 0);
    }

    public GISModel trainModel(ObjectStream<Event> objectStream, int i, int i2) {
        OnePassDataIndexer onePassDataIndexer = new OnePassDataIndexer();
        TrainingParameters trainingParameters = new TrainingParameters();
        trainingParameters.put("Cutoff", i2);
        trainingParameters.put("Iterations", i);
        onePassDataIndexer.init(trainingParameters, new HashMap());
        onePassDataIndexer.index(objectStream);
        return trainModel(i, onePassDataIndexer);
    }

    public GISModel trainModel(int i, DataIndexer dataIndexer) {
        return trainModel(i, dataIndexer, new UniformPrior(), 1);
    }

    public GISModel trainModel(int i, DataIndexer dataIndexer, int i2) {
        return trainModel(i, dataIndexer, new UniformPrior(), i2);
    }

    public GISModel trainModel(int i, DataIndexer dataIndexer, Prior prior, int i2) {
        int i4;
        float f;
        int i5;
        int[] iArr;
        float[] fArr;
        float[] fArr2;
        if (i2 > 0) {
            this.modelExpects = new MutableContext[i2][];
            logger.info("Incorporating indexed data for training...");
            this.contexts = dataIndexer.getContexts();
            this.values = dataIndexer.getValues();
            dataIndexer.getPredCounts();
            this.numTimesEventsSeen = dataIndexer.getNumTimesEventsSeen();
            this.numUniqueEvents = this.contexts.length;
            this.prior = prior;
            int i6 = 0;
            int i7 = 0;
            double length = 0.0d;
            while (true) {
                int[][] iArr2 = this.contexts;
                int i8 = 1;
                if (i7 >= iArr2.length) {
                    break;
                }
                float[][] fArr3 = this.values;
                if (fArr3 != null && (fArr2 = fArr3[i7]) != null) {
                    float f4 = fArr2[0];
                    while (true) {
                        float[] fArr4 = this.values[i7];
                        if (i8 >= fArr4.length) {
                            break;
                        }
                        f4 += fArr4[i8];
                        i8++;
                    }
                    double d = f4;
                    if (d > length) {
                        length = d;
                    }
                } else {
                    int[] iArr3 = iArr2[i7];
                    if (iArr3.length > length) {
                        length = iArr3.length;
                    }
                }
                i7++;
            }
            Logger logger2 = logger;
            logger2.info("done.");
            this.outcomeLabels = dataIndexer.getOutcomeLabels();
            this.outcomeList = dataIndexer.getOutcomeList();
            this.numOutcomes = this.outcomeLabels.length;
            String[] predLabels = dataIndexer.getPredLabels();
            this.predLabels = predLabels;
            this.prior.setLabels(this.outcomeLabels, predLabels);
            this.numPreds = this.predLabels.length;
            logger2.info("\tNumber of Event Tokens: {} \n\t Number of Outcomes: {} \n\t Number of Predicates: {}", Integer.valueOf(this.numUniqueEvents), Integer.valueOf(this.numOutcomes), Integer.valueOf(this.numPreds));
            float[][] fArr5 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, this.numPreds, this.numOutcomes);
            for (int i9 = 0; i9 < this.numUniqueEvents; i9++) {
                int i10 = 0;
                while (true) {
                    int[] iArr4 = this.contexts[i9];
                    if (i10 < iArr4.length) {
                        float[][] fArr6 = this.values;
                        if (fArr6 != null && (fArr = fArr6[i9]) != null) {
                            float[] fArr7 = fArr5[iArr4[i10]];
                            int i11 = this.outcomeList[i9];
                            fArr7[i11] = (this.numTimesEventsSeen[i9] * fArr[i10]) + fArr7[i11];
                        } else {
                            float[] fArr8 = fArr5[iArr4[i10]];
                            int i12 = this.outcomeList[i9];
                            fArr8[i12] = fArr8[i12] + this.numTimesEventsSeen[i9];
                        }
                        i10++;
                    }
                }
            }
            double d2 = this._smoothingObservation;
            this.params = new MutableContext[this.numPreds];
            int i13 = 0;
            while (true) {
                MutableContext[][] mutableContextArr = this.modelExpects;
                if (i13 >= mutableContextArr.length) {
                    break;
                }
                mutableContextArr[i13] = new MutableContext[this.numPreds];
                i13++;
            }
            this.observedExpects = new MutableContext[this.numPreds];
            this.evalParams = new EvalParameters(this.params, this.numOutcomes);
            int i14 = this.numOutcomes;
            int[] iArr5 = new int[i14];
            int[] iArr6 = new int[i14];
            for (int i15 = 0; i15 < this.numOutcomes; i15++) {
                iArr6[i15] = i15;
            }
            int i16 = 0;
            while (i16 < this.numPreds) {
                if (this.useSimpleSmoothing) {
                    i4 = this.numOutcomes;
                    iArr = iArr6;
                    f = 0.0f;
                } else {
                    i4 = i6;
                    int i17 = i4;
                    f = 0.0f;
                    while (true) {
                        i5 = this.numOutcomes;
                        if (i17 >= i5) {
                            break;
                        }
                        if (fArr5[i16][i17] > 0.0f) {
                            iArr5[i4] = i17;
                            i4++;
                        }
                        i17++;
                    }
                    if (i4 == i5) {
                        iArr = iArr6;
                    } else {
                        iArr = new int[i4];
                        System.arraycopy(iArr5, i6, iArr, i6, i4);
                    }
                }
                this.params[i16] = new MutableContext(iArr, new double[i4]);
                int i18 = 0;
                while (true) {
                    MutableContext[][] mutableContextArr2 = this.modelExpects;
                    if (i18 >= mutableContextArr2.length) {
                        break;
                    }
                    mutableContextArr2[i18][i16] = new MutableContext(iArr, new double[i4]);
                    i18++;
                }
                this.observedExpects[i16] = new MutableContext(iArr, new double[i4]);
                int i19 = 0;
                while (i19 < i4) {
                    int i20 = iArr[i19];
                    int[] iArr7 = iArr;
                    int[] iArr8 = iArr6;
                    this.params[i16].setParameter(i19, 0.0d);
                    MutableContext[][] mutableContextArr3 = this.modelExpects;
                    int length2 = mutableContextArr3.length;
                    int i21 = 0;
                    while (i21 < length2) {
                        mutableContextArr3[i21][i16].setParameter(i19, 0.0d);
                        i21++;
                        fArr5 = fArr5;
                        i20 = i20;
                        mutableContextArr3 = mutableContextArr3;
                    }
                    float[][] fArr9 = fArr5;
                    float f5 = fArr9[i16][i20];
                    if (f5 > f) {
                        this.observedExpects[i16].setParameter(i19, f5);
                    } else if (this.useSimpleSmoothing) {
                        this.observedExpects[i16].setParameter(i19, d2);
                    }
                    i19++;
                    iArr6 = iArr8;
                    iArr = iArr7;
                    fArr5 = fArr9;
                }
                i16++;
                i6 = 0;
            }
            Logger logger3 = logger;
            logger3.info("...done.");
            if (i2 == 1) {
                logger3.info("Computing model parameters ...");
            } else {
                logger3.info("Computing model parameters in {} threads...", Integer.valueOf(i2));
            }
            findParameters(i, length);
            return new GISModel(this.params, this.predLabels, this.outcomeLabels);
        }
        throw new IllegalArgumentException(AbstractC0541b.m767i(i2, "threads must be at least one or greater but is ", "!"));
    }
}
