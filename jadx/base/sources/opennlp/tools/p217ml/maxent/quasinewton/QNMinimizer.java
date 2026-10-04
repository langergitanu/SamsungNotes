package opennlp.tools.p217ml.maxent.quasinewton;

import androidx.compose.runtime.AbstractC1974b;
import java.lang.reflect.Array;
import opennlp.tools.p217ml.ArrayMath;
import opennlp.tools.p217ml.maxent.quasinewton.LineSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class QNMinimizer {
    public static final double CONVERGE_TOLERANCE = 1.0E-4d;
    public static final double INITIAL_STEP_SIZE = 1.0d;
    public static final double L1COST_DEFAULT = 0.0d;
    public static final double L2COST_DEFAULT = 0.0d;
    public static final int MAX_FCT_EVAL_DEFAULT = 30000;
    public static final double MIN_STEP_SIZE = 1.0E-10d;
    public static final int M_DEFAULT = 15;
    public static final int NUM_ITERATIONS_DEFAULT = 100;
    public static final double REL_GRAD_NORM_TOL = 1.0E-4d;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) QNMinimizer.class);
    private int dimension;
    private Evaluator evaluator;
    private final int iterations;
    private final double l1Cost;
    private final double l2Cost;

    /* JADX INFO: renamed from: m */
    private final int f9672m;
    private final int maxFctEval;
    private UpdateInfo updateInfo;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Evaluator {
        double evaluate(double[] dArr);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class L2RegFunction implements Function {

        /* JADX INFO: renamed from: f */
        private final Function f9673f;
        private final double l2Cost;

        public L2RegFunction(Function function, double d) {
            this.f9673f = function;
            this.l2Cost = d;
        }

        private void checkDimension(double[] dArr) {
            if (dArr.length != getDimension()) {
                throw new IllegalArgumentException("x's dimension is not the same as function's dimension");
            }
        }

        @Override // opennlp.tools.p217ml.maxent.quasinewton.Function
        public int getDimension() {
            return this.f9673f.getDimension();
        }

        @Override // opennlp.tools.p217ml.maxent.quasinewton.Function
        public double[] gradientAt(double[] dArr) {
            checkDimension(dArr);
            double[] dArrGradientAt = this.f9673f.gradientAt(dArr);
            if (this.l2Cost > 0.0d) {
                for (int i = 0; i < dArr.length; i++) {
                    dArrGradientAt[i] = (this.l2Cost * 2.0d * dArr[i]) + dArrGradientAt[i];
                }
            }
            return dArrGradientAt;
        }

        @Override // opennlp.tools.p217ml.maxent.quasinewton.Function
        public double valueAt(double[] dArr) {
            checkDimension(dArr);
            double dValueAt = this.f9673f.valueAt(dArr);
            double d = this.l2Cost;
            return d > 0.0d ? (ArrayMath.innerProduct(dArr, dArr) * d) + dValueAt : dValueAt;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class UpdateInfo {

        /* JADX INFO: renamed from: S */
        private final double[][] f9674S;

        /* JADX INFO: renamed from: Y */
        private final double[][] f9675Y;
        private final double[] alpha;
        private int kCounter = 0;

        /* JADX INFO: renamed from: m */
        private final int f9676m;
        private final double[] rho;

        public UpdateInfo(int i, int i2) {
            this.f9676m = i;
            Class cls = Double.TYPE;
            this.f9674S = (double[][]) Array.newInstance((Class<?>) cls, i, i2);
            this.f9675Y = (double[][]) Array.newInstance((Class<?>) cls, i, i2);
            this.rho = new double[i];
            this.alpha = new double[i];
        }

        public void update(LineSearch.LineSearchResult lineSearchResult) {
            double[] currPoint = lineSearchResult.getCurrPoint();
            double[] gradAtCurr = lineSearchResult.getGradAtCurr();
            double[] nextPoint = lineSearchResult.getNextPoint();
            double[] gradAtNext = lineSearchResult.getGradAtNext();
            int i = 0;
            double d = 0.0d;
            if (this.kCounter < this.f9676m) {
                while (i < QNMinimizer.this.dimension) {
                    double[][] dArr = this.f9674S;
                    int i2 = this.kCounter;
                    double[] dArr2 = dArr[i2];
                    dArr2[i] = nextPoint[i] - currPoint[i];
                    double[] dArr3 = this.f9675Y[i2];
                    double d2 = gradAtNext[i] - gradAtCurr[i];
                    dArr3[i] = d2;
                    d += dArr2[i] * d2;
                    i++;
                }
                this.rho[this.kCounter] = 1.0d / d;
            } else {
                int i4 = 0;
                while (i4 < this.f9676m - 1) {
                    double[][] dArr4 = this.f9674S;
                    int i5 = i4 + 1;
                    dArr4[i4] = dArr4[i5];
                    double[][] dArr5 = this.f9675Y;
                    dArr5[i4] = dArr5[i5];
                    double[] dArr6 = this.rho;
                    dArr6[i4] = dArr6[i5];
                    i4 = i5;
                }
                while (i < QNMinimizer.this.dimension) {
                    double[][] dArr7 = this.f9674S;
                    int i6 = this.f9676m;
                    dArr7[i6 - 1][i] = nextPoint[i] - currPoint[i];
                    double[][] dArr8 = this.f9675Y;
                    dArr8[i6 - 1][i] = gradAtNext[i] - gradAtCurr[i];
                    d += dArr7[i6 - 1][i] * dArr8[i6 - 1][i];
                    i++;
                }
                this.rho[this.f9676m - 1] = 1.0d / d;
            }
            int i7 = this.kCounter;
            if (i7 < this.f9676m) {
                this.kCounter = i7 + 1;
            }
        }
    }

    public QNMinimizer() {
        this(0.0d, 0.0d);
    }

    private void computeDirection(double[] dArr) {
        int i;
        int i2 = this.updateInfo.kCounter;
        double[] dArr2 = this.updateInfo.rho;
        double[] dArr3 = this.updateInfo.alpha;
        double[][] dArr4 = this.updateInfo.f9674S;
        double[][] dArr5 = this.updateInfo.f9675Y;
        int i4 = i2 - 1;
        while (true) {
            i = 0;
            if (i4 < 0) {
                break;
            }
            dArr3[i4] = ArrayMath.innerProduct(dArr4[i4], dArr) * dArr2[i4];
            while (i < this.dimension) {
                dArr[i] = dArr[i] - (dArr3[i4] * dArr5[i4][i]);
                i++;
            }
            i4--;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            double dInnerProduct = ArrayMath.innerProduct(dArr5[i5], dArr) * dArr2[i5];
            for (int i6 = 0; i6 < this.dimension; i6++) {
                dArr[i6] = AbstractC1974b.m1306C(dArr3[i5], dInnerProduct, dArr4[i5][i6], dArr[i6]);
            }
        }
        while (i < this.dimension) {
            dArr[i] = -dArr[i];
            i++;
        }
    }

    private void computePseudoGrad(double[] dArr, double[] dArr2, double[] dArr3) {
        for (int i = 0; i < this.dimension; i++) {
            double d = dArr[i];
            if (d < 0.0d) {
                dArr3[i] = dArr2[i] - this.l1Cost;
            } else if (d > 0.0d) {
                dArr3[i] = dArr2[i] + this.l1Cost;
            } else {
                double d2 = dArr2[i];
                double d3 = this.l1Cost;
                if (d2 < (-d3)) {
                    dArr3[i] = d2 + d3;
                } else if (d2 > d3) {
                    dArr3[i] = d2 - d3;
                } else {
                    dArr3[i] = 0.0d;
                }
            }
        }
    }

    private boolean isConverged(LineSearch.LineSearchResult lineSearchResult) {
        double funcChangeRate = lineSearchResult.getFuncChangeRate();
        Double dValueOf = Double.valueOf(1.0E-4d);
        if (funcChangeRate < 1.0E-4d) {
            Logger logger2 = logger;
            if (logger2.isDebugEnabled()) {
                logger2.debug("Function change rate is smaller than the threshold {}. Training will stop.", dValueOf);
            }
            return true;
        }
        if ((this.l1Cost > 0.0d ? ArrayMath.l2norm(lineSearchResult.getPseudoGradAtNext()) : ArrayMath.l2norm(lineSearchResult.getGradAtNext())) / StrictMath.max(1.0d, ArrayMath.l2norm(lineSearchResult.getNextPoint())) < 1.0E-4d) {
            Logger logger3 = logger;
            if (logger3.isDebugEnabled()) {
                logger3.debug("Relative L2-norm of the gradient is smaller than the threshold {}. Training will stop.", dValueOf);
            }
            return true;
        }
        if (lineSearchResult.getStepSize() < 1.0E-10d) {
            Logger logger4 = logger;
            if (logger4.isDebugEnabled()) {
                logger4.debug("Step size is smaller than the minimum step size {}. Training will stop.", Double.valueOf(1.0E-10d));
            }
            return true;
        }
        if (lineSearchResult.getFctEvalCount() <= this.maxFctEval) {
            return false;
        }
        Logger logger5 = logger;
        if (logger5.isDebugEnabled()) {
            logger5.debug("Maximum number of function evaluations has exceeded the threshold {}. Training will stop.", Integer.valueOf(this.maxFctEval));
        }
        return true;
    }

    public Evaluator getEvaluator() {
        return this.evaluator;
    }

    public double[] minimize(Function function) {
        double[] dArr;
        double d;
        L2RegFunction l2RegFunction = new L2RegFunction(function, this.l2Cost);
        int dimension = l2RegFunction.getDimension();
        this.dimension = dimension;
        this.updateInfo = new UpdateInfo(this.f9672m, dimension);
        double[] dArr2 = new double[this.dimension];
        double dValueAt = l2RegFunction.valueAt(dArr2);
        double[] dArr3 = new double[this.dimension];
        System.arraycopy(l2RegFunction.gradientAt(dArr2), 0, dArr3, 0, this.dimension);
        double d2 = this.l1Cost;
        double d3 = 0.0d;
        if (d2 > 0.0d) {
            dValueAt += ArrayMath.l1norm(dArr2) * d2;
            dArr = new double[this.dimension];
            computePseudoGrad(dArr2, dArr3, dArr);
        } else {
            dArr = null;
        }
        LineSearch.LineSearchResult initialObjectForL1 = this.l1Cost > 0.0d ? LineSearch.LineSearchResult.getInitialObjectForL1(dValueAt, dArr3, dArr, dArr2) : LineSearch.LineSearchResult.getInitialObject(dValueAt, dArr3, dArr2);
        Logger logger2 = logger;
        if (logger2.isDebugEnabled()) {
            logger2.debug("Solving convex optimization problem.");
            logger2.debug("Objective function has {} variable(s).", Integer.valueOf(this.dimension));
            logger2.debug("Performing {} iterations with L1Cost={} and L2Cost={}", Integer.valueOf(this.iterations), Double.valueOf(this.l1Cost), Double.valueOf(this.l2Cost));
        }
        int i = this.dimension;
        double[] dArr4 = new double[i];
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i2 = 1;
        double dInvL2norm = this.l1Cost > 0.0d ? ArrayMath.invL2norm(initialObjectForL1.getPseudoGradAtNext()) : ArrayMath.invL2norm(initialObjectForL1.getGradAtNext());
        while (true) {
            if (i2 > this.iterations) {
                d = d3;
                break;
            }
            if (this.l1Cost > d3) {
                System.arraycopy(initialObjectForL1.getPseudoGradAtNext(), 0, dArr4, 0, i);
            } else {
                System.arraycopy(initialObjectForL1.getGradAtNext(), 0, dArr4, 0, i);
            }
            computeDirection(dArr4);
            if (this.l1Cost > d3) {
                double[] pseudoGradAtNext = initialObjectForL1.getPseudoGradAtNext();
                d = d3;
                for (int i4 = 0; i4 < this.dimension; i4++) {
                    if (dArr4[i4] * pseudoGradAtNext[i4] >= d) {
                        dArr4[i4] = d;
                    }
                }
                LineSearch.doConstrainedLineSearch(l2RegFunction, dArr4, initialObjectForL1, this.l1Cost, dInvL2norm);
                computePseudoGrad(initialObjectForL1.getNextPoint(), initialObjectForL1.getGradAtNext(), pseudoGradAtNext);
                initialObjectForL1.setPseudoGradAtNext(pseudoGradAtNext);
            } else {
                d = d3;
                LineSearch.doLineSearch(l2RegFunction, dArr4, initialObjectForL1, dInvL2norm);
            }
            this.updateInfo.update(initialObjectForL1);
            Logger logger3 = logger;
            if (logger3.isDebugEnabled()) {
                if (this.evaluator != null) {
                    logger3.debug("{}: \t{}\t{}\t{}", Integer.valueOf(i2), Double.valueOf(initialObjectForL1.getValueAtNext()), Double.valueOf(initialObjectForL1.getFuncChangeRate()), Double.valueOf(this.evaluator.evaluate(initialObjectForL1.getNextPoint())));
                } else {
                    logger3.debug("{}: \t {}\t{}\n", Integer.valueOf(i2), Double.valueOf(initialObjectForL1.getValueAtNext()), Double.valueOf(initialObjectForL1.getFuncChangeRate()));
                }
            }
            if (isConverged(initialObjectForL1)) {
                break;
            }
            i2++;
            dInvL2norm = 1.0d;
            d3 = d;
        }
        if (this.l1Cost > d && this.l2Cost > d) {
            double[] nextPoint = initialObjectForL1.getNextPoint();
            for (int i5 = 0; i5 < this.dimension; i5++) {
                nextPoint[i5] = StrictMath.sqrt(this.l2Cost + 1.0d) * nextPoint[i5];
            }
        }
        logger.info("Running time: {}s\n", Double.valueOf((System.currentTimeMillis() - jCurrentTimeMillis) / 1000.0d));
        this.updateInfo = null;
        System.gc();
        double[] dArr5 = new double[this.dimension];
        System.arraycopy(initialObjectForL1.getNextPoint(), 0, dArr5, 0, this.dimension);
        return dArr5;
    }

    public void setEvaluator(Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    public QNMinimizer(double d, double d2) {
        this(d, d2, 100);
    }

    public QNMinimizer(double d, double d2, int i) {
        this(d, d2, i, 15, 30000);
    }

    public QNMinimizer(double d, double d2, int i, int i2, int i4) {
        if (d < 0.0d || d2 < 0.0d) {
            throw new IllegalArgumentException("L1-cost and L2-cost must not be less than zero");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("Number of iterations must be larger than zero");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("Number of Hessian updates must be larger than zero");
        }
        if (i4 > 0) {
            this.l1Cost = d;
            this.l2Cost = d2;
            this.iterations = i;
            this.f9672m = i2;
            this.maxFctEval = i4;
            return;
        }
        throw new IllegalArgumentException("Maximum number of function evaluations must be larger than zero");
    }
}
