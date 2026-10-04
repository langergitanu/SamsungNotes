package opennlp.tools.p217ml.maxent.quasinewton;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.AbstractC12991c;
import opennlp.tools.p217ml.AbstractEventTrainer;
import opennlp.tools.p217ml.ArrayMath;
import opennlp.tools.p217ml.maxent.quasinewton.QNMinimizer;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.Context;
import opennlp.tools.p217ml.model.DataIndexer;
import opennlp.tools.util.TrainingParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class QNTrainer extends AbstractEventTrainer {
    public static final double L1COST_DEFAULT = 0.1d;
    public static final String L1COST_PARAM = "L1Cost";
    public static final double L2COST_DEFAULT = 0.1d;
    public static final String L2COST_PARAM = "L2Cost";
    public static final String MAXENT_QN_VALUE = "MAXENT_QN";
    public static final int MAX_FCT_EVAL_DEFAULT = 30000;
    public static final String MAX_FCT_EVAL_PARAM = "MaxFctEval";
    public static final int M_DEFAULT = 15;
    public static final String M_PARAM = "NumOfUpdates";
    public static final int THREADS_DEFAULT = 1;
    public static final String THREADS_PARAM = "Threads";
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) QNTrainer.class);
    private double l1Cost;
    private double l2Cost;

    /* JADX INFO: renamed from: m */
    private int f9677m;
    private int maxFctEval;
    private int threads;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ModelEvaluator extends AbstractC12991c implements QNMinimizer.Evaluator {
        private final DataIndexer indexer;

        public /* synthetic */ ModelEvaluator(DataIndexer dataIndexer, int i) {
            this(dataIndexer);
        }

        public final boolean equals(Object obj) {
            return (obj instanceof ModelEvaluator) && Objects.equals(this.indexer, ((ModelEvaluator) obj).indexer);
        }

        @Override // opennlp.tools.ml.maxent.quasinewton.QNMinimizer.Evaluator
        public double evaluate(double[] dArr) {
            int[][] contexts = this.indexer.getContexts();
            float[][] values = this.indexer.getValues();
            int[] numTimesEventsSeen = this.indexer.getNumTimesEventsSeen();
            int[] outcomeList = this.indexer.getOutcomeList();
            int length = this.indexer.getOutcomeLabels().length;
            int length2 = this.indexer.getPredLabels().length;
            int i = 0;
            int i2 = 0;
            int i4 = 0;
            while (i < contexts.length) {
                double[] dArr2 = new double[length];
                double[] dArr3 = dArr;
                QNModel.eval(contexts[i], values == null ? null : values[i], dArr2, length, length2, dArr3);
                if (ArrayMath.argmax(dArr2) == outcomeList[i]) {
                    i2 += numTimesEventsSeen[i];
                }
                i4 += numTimesEventsSeen[i];
                i++;
                dArr = dArr3;
            }
            return ((double) i2) / ((double) i4);
        }

        public final int hashCode() {
            return Objects.hashCode(this.indexer);
        }

        public DataIndexer indexer() {
            return this.indexer;
        }

        public final String toString() {
            Object[] objArr = {this.indexer};
            String[] strArrSplit = "indexer".length() == 0 ? new String[0] : "indexer".split(";");
            StringBuilder sb = new StringBuilder();
            sb.append(ModelEvaluator.class.getSimpleName());
            sb.append("[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(SQLKeyword.COMMA);
                }
            }
            sb.append("]");
            return sb.toString();
        }

        private ModelEvaluator(DataIndexer dataIndexer) {
            this.indexer = dataIndexer;
        }
    }

    public QNTrainer() {
        this(15);
    }

    @Override // opennlp.tools.p217ml.AbstractTrainer, opennlp.tools.commons.Trainer
    public void init(TrainingParameters trainingParameters, Map<String, String> map) {
        super.init(trainingParameters, map);
        this.f9677m = trainingParameters.getIntParameter(M_PARAM, 15);
        this.maxFctEval = trainingParameters.getIntParameter(MAX_FCT_EVAL_PARAM, 30000);
        this.threads = trainingParameters.getIntParameter("Threads", 1);
        this.l1Cost = trainingParameters.getDoubleParameter(L1COST_PARAM, 0.1d);
        this.l2Cost = trainingParameters.getDoubleParameter(L2COST_PARAM, 0.1d);
    }

    @Override // opennlp.tools.p217ml.AbstractEventTrainer
    public boolean isSortAndMerge() {
        return true;
    }

    public QNModel trainModel(int i, DataIndexer dataIndexer) {
        Function parallelNegLogLikelihood;
        int i2 = this.threads;
        if (i2 == 1) {
            logger.info("Computing model parameters ...");
            parallelNegLogLikelihood = new NegLogLikelihood(dataIndexer);
        } else {
            logger.info("Computing model parameters with {} threads...", Integer.valueOf(i2));
            parallelNegLogLikelihood = new ParallelNegLogLikelihood(dataIndexer, this.threads);
        }
        QNMinimizer qNMinimizer = new QNMinimizer(this.l1Cost, this.l2Cost, i, this.f9677m, this.maxFctEval);
        qNMinimizer.setEvaluator(new ModelEvaluator(dataIndexer, 0));
        double[] dArrMinimize = qNMinimizer.minimize(parallelNegLogLikelihood);
        String[] predLabels = dataIndexer.getPredLabels();
        int length = predLabels.length;
        String[] outcomeLabels = dataIndexer.getOutcomeLabels();
        int length2 = outcomeLabels.length;
        Context[] contextArr = new Context[length];
        for (int i4 = 0; i4 < length; i4++) {
            ArrayList arrayList = new ArrayList(length2);
            ArrayList arrayList2 = new ArrayList(length2);
            for (int i5 = 0; i5 < length2; i5++) {
                double d = dArrMinimize[(i5 * length) + i4];
                arrayList.add(Integer.valueOf(i5));
                arrayList2.add(Double.valueOf(d));
            }
            contextArr[i4] = new Context(ArrayMath.toIntArray(arrayList), ArrayMath.toDoubleArray(arrayList2));
        }
        return new QNModel(contextArr, predLabels, outcomeLabels);
    }

    @Override // opennlp.tools.p217ml.AbstractEventTrainer, opennlp.tools.p217ml.AbstractTrainer
    public void validate() {
        super.validate();
        String algorithm = getAlgorithm();
        if (algorithm != null && !MAXENT_QN_VALUE.equals(algorithm)) {
            throw new IllegalArgumentException("algorithmName must be MAXENT_QN");
        }
        if (this.f9677m < 0) {
            throw new IllegalArgumentException("Number of Hessian updates to remember must be >= 0");
        }
        if (this.maxFctEval < 0) {
            throw new IllegalArgumentException("Maximum number of function evaluations must be >= 0");
        }
        if (this.threads < 1) {
            throw new IllegalArgumentException("Number of threads must be >= 1");
        }
        if (this.l1Cost < 0.0d) {
            throw new IllegalArgumentException("Regularization costs must be >= 0");
        }
        if (this.l2Cost < 0.0d) {
            throw new IllegalArgumentException("Regularization costs must be >= 0");
        }
    }

    public QNTrainer(TrainingParameters trainingParameters) {
        super(trainingParameters);
    }

    @Override // opennlp.tools.p217ml.AbstractEventTrainer
    public AbstractModel doTrain(DataIndexer dataIndexer) {
        return trainModel(getIterations(), dataIndexer);
    }

    public QNTrainer(int i) {
        this(i, 30000);
    }

    public QNTrainer(int i, int i2) {
        this.f9677m = i < 0 ? 15 : i;
        this.maxFctEval = i2 < 0 ? 30000 : i2;
        this.threads = 1;
        this.l1Cost = 0.1d;
        this.l2Cost = 0.1d;
    }
}
