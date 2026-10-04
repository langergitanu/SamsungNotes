package opennlp.tools.p217ml.maxent.quasinewton;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import opennlp.tools.cmdline.ThreadFactoryC13623a;
import opennlp.tools.p217ml.ArrayMath;
import opennlp.tools.p217ml.model.DataIndexer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ParallelNegLogLikelihood extends NegLogLikelihood {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) ParallelNegLogLikelihood.class);
    private final double[][] gradientThread;
    private final double[] negLogLikelihoodThread;
    private final int threads;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ComputeTask implements Callable<ComputeTask> {
        final int length;
        final int startIndex;
        final int threadIndex;

        /* JADX INFO: renamed from: x */
        final double[] f9671x;

        public ComputeTask(int i, int i2, int i4, double[] dArr) {
            this.threadIndex = i;
            this.startIndex = i2;
            this.length = i4;
            this.f9671x = dArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class GradientComputeTask extends ComputeTask {
        final double[] expectation;

        public GradientComputeTask(int i, int i2, int i4, double[] dArr) {
            super(i, i2, i4, dArr);
            this.expectation = new double[ParallelNegLogLikelihood.this.numOutcomes];
        }

        @Override // java.util.concurrent.Callable
        public ComputeTask call() {
            double d = 0.0d;
            Arrays.fill(ParallelNegLogLikelihood.this.gradientThread[this.threadIndex], 0.0d);
            int i = this.startIndex;
            while (i < this.startIndex + this.length) {
                for (int i2 = 0; i2 < ParallelNegLogLikelihood.this.numOutcomes; i2++) {
                    this.expectation[i2] = d;
                    int i4 = 0;
                    while (true) {
                        ParallelNegLogLikelihood parallelNegLogLikelihood = ParallelNegLogLikelihood.this;
                        int[] iArr = parallelNegLogLikelihood.contexts[i];
                        if (i4 < iArr.length) {
                            int iIndexOf = parallelNegLogLikelihood.indexOf(i2, iArr[i4]);
                            double d2 = ParallelNegLogLikelihood.this.values != null ? r10[i][i4] : 1.0d;
                            double[] dArr = this.expectation;
                            dArr[i2] = (d2 * this.f9671x[iIndexOf]) + dArr[i2];
                            i4++;
                        }
                    }
                }
                double dLogSumOfExps = ArrayMath.logSumOfExps(this.expectation);
                for (int i5 = 0; i5 < ParallelNegLogLikelihood.this.numOutcomes; i5++) {
                    double[] dArr2 = this.expectation;
                    dArr2[i5] = StrictMath.exp(dArr2[i5] - dLogSumOfExps);
                }
                int i6 = 0;
                while (true) {
                    ParallelNegLogLikelihood parallelNegLogLikelihood2 = ParallelNegLogLikelihood.this;
                    if (i6 < parallelNegLogLikelihood2.numOutcomes) {
                        int i7 = parallelNegLogLikelihood2.outcomeList[i] == i6 ? 1 : 0;
                        int i8 = 0;
                        while (true) {
                            ParallelNegLogLikelihood parallelNegLogLikelihood3 = ParallelNegLogLikelihood.this;
                            int[] iArr2 = parallelNegLogLikelihood3.contexts[i];
                            if (i8 < iArr2.length) {
                                int iIndexOf2 = parallelNegLogLikelihood3.indexOf(i6, iArr2[i8]);
                                ParallelNegLogLikelihood parallelNegLogLikelihood4 = ParallelNegLogLikelihood.this;
                                double d3 = parallelNegLogLikelihood4.values != null ? r12[i][i8] : 1.0d;
                                double[] dArr3 = parallelNegLogLikelihood4.gradientThread[this.threadIndex];
                                dArr3[iIndexOf2] = ((this.expectation[i6] - ((double) i7)) * d3 * ((double) ParallelNegLogLikelihood.this.numTimesEventsSeen[i])) + dArr3[iIndexOf2];
                                i8++;
                            }
                        }
                        i6++;
                    }
                }
                i++;
                d = 0.0d;
            }
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class NegLLComputeTask extends ComputeTask {
        final double[] tempSums;

        public NegLLComputeTask(int i, int i2, int i4, double[] dArr) {
            super(i, i2, i4, dArr);
            this.tempSums = new double[ParallelNegLogLikelihood.this.numOutcomes];
        }

        @Override // java.util.concurrent.Callable
        public ComputeTask call() {
            ParallelNegLogLikelihood.this.negLogLikelihoodThread[this.threadIndex] = 0.0d;
            for (int i = this.startIndex; i < this.startIndex + this.length; i++) {
                for (int i2 = 0; i2 < ParallelNegLogLikelihood.this.numOutcomes; i2++) {
                    this.tempSums[i2] = 0.0d;
                    int i4 = 0;
                    while (true) {
                        ParallelNegLogLikelihood parallelNegLogLikelihood = ParallelNegLogLikelihood.this;
                        int[] iArr = parallelNegLogLikelihood.contexts[i];
                        if (i4 < iArr.length) {
                            int iIndexOf = parallelNegLogLikelihood.indexOf(i2, iArr[i4]);
                            double d = ParallelNegLogLikelihood.this.values != null ? r7[i][i4] : 1.0d;
                            double[] dArr = this.tempSums;
                            dArr[i2] = (d * this.f9671x[iIndexOf]) + dArr[i2];
                            i4++;
                        }
                    }
                }
                double dLogSumOfExps = ArrayMath.logSumOfExps(this.tempSums);
                ParallelNegLogLikelihood parallelNegLogLikelihood2 = ParallelNegLogLikelihood.this;
                int i5 = parallelNegLogLikelihood2.outcomeList[i];
                double[] dArr2 = parallelNegLogLikelihood2.negLogLikelihoodThread;
                int i6 = this.threadIndex;
                dArr2[i6] = dArr2[i6] - ((this.tempSums[i5] - dLogSumOfExps) * ((double) ParallelNegLogLikelihood.this.numTimesEventsSeen[i]));
            }
            return this;
        }
    }

    public ParallelNegLogLikelihood(DataIndexer dataIndexer, int i) {
        super(dataIndexer);
        if (i <= 0) {
            throw new IllegalArgumentException("Number of threads must 1 or larger");
        }
        this.threads = i;
        this.negLogLikelihoodThread = new double[i];
        this.gradientThread = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i, this.dimension);
    }

    private void computeInParallel(double[] dArr, Class<? extends ComputeTask> cls) {
        Constructor<? extends ComputeTask> constructor;
        ArrayList arrayList;
        int i;
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(this.threads, new ThreadFactoryC13623a(2));
        int i2 = this.numContexts;
        int i4 = this.threads;
        int i5 = i2 / i4;
        int i6 = i2 % i4;
        try {
            Class cls2 = Integer.TYPE;
            constructor = cls.getConstructor(ParallelNegLogLikelihood.class, cls2, cls2, cls2, double[].class);
            arrayList = new ArrayList();
            i = 0;
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), (Throwable) e);
        }
        while (true) {
            int i7 = this.threads;
            if (i >= i7) {
                break;
            }
            if (i != i7 - 1) {
                arrayList.add(executorServiceNewFixedThreadPool.submit(constructor.newInstance(this, Integer.valueOf(i), Integer.valueOf(i * i5), Integer.valueOf(i5), dArr)));
            } else {
                arrayList.add(executorServiceNewFixedThreadPool.submit(constructor.newInstance(this, Integer.valueOf(i), Integer.valueOf(i * i5), Integer.valueOf(i5 + i6), dArr)));
            }
            i++;
            executorServiceNewFixedThreadPool.shutdown();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).get();
        }
        executorServiceNewFixedThreadPool.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$computeInParallel$0(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("opennlp.tools.ml.maxent.quasinewton.ParallelNegLogLikelihood.computeInParallel()");
        thread.setDaemon(true);
        return thread;
    }

    @Override // opennlp.tools.p217ml.maxent.quasinewton.NegLogLikelihood, opennlp.tools.p217ml.maxent.quasinewton.Function
    public double[] gradientAt(double[] dArr) {
        if (dArr.length != this.dimension) {
            throw new IllegalArgumentException("x is invalid, its dimension is not equal to the function.");
        }
        computeInParallel(dArr, GradientComputeTask.class);
        for (int i = 0; i < this.dimension; i++) {
            this.gradient[i] = 0.0d;
            for (int i2 = 0; i2 < this.threads; i2++) {
                double[] dArr2 = this.gradient;
                dArr2[i] = dArr2[i] + this.gradientThread[i2][i];
            }
        }
        return this.gradient;
    }

    @Override // opennlp.tools.p217ml.maxent.quasinewton.NegLogLikelihood, opennlp.tools.p217ml.maxent.quasinewton.Function
    public double valueAt(double[] dArr) {
        if (dArr.length != this.dimension) {
            throw new IllegalArgumentException("x is invalid, its dimension is not equal to domain dimension.");
        }
        computeInParallel(dArr, NegLLComputeTask.class);
        double d = 0.0d;
        for (int i = 0; i < this.threads; i++) {
            d += this.negLogLikelihoodThread[i];
        }
        return d;
    }
}
