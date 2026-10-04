package opennlp.tools.p217ml;

import java.util.Arrays;
import java.util.PriorityQueue;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.p217ml.model.SequenceClassificationModel;
import opennlp.tools.util.BeamSearchContextGenerator;
import opennlp.tools.util.Cache;
import opennlp.tools.util.Sequence;
import opennlp.tools.util.SequenceValidator;
import p092W3.C0332a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BeamSearch implements SequenceClassificationModel {
    public static final String BEAM_SIZE_PARAMETER = "BeamSize";
    private static final Object[] EMPTY_ADDITIONAL_CONTEXT = new Object[0];
    private static final int zeroLog = -100000;
    private Cache<String[], double[]> contextsCache;
    protected final MaxentModel model;
    private final double[] probs;
    protected final int size;

    public BeamSearch(int i, MaxentModel maxentModel) {
        this(i, maxentModel, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ double[] lambda$bestSequences$0(String[] strArr) {
        return this.model.eval(strArr, this.probs);
    }

    @Override // opennlp.tools.p217ml.model.SequenceClassificationModel
    public <T> Sequence bestSequence(T[] tArr, Object[] objArr, BeamSearchContextGenerator<T> beamSearchContextGenerator, SequenceValidator<T> sequenceValidator) {
        Sequence[] sequenceArrBestSequences = bestSequences(1, tArr, objArr, beamSearchContextGenerator, sequenceValidator);
        if (sequenceArrBestSequences.length > 0) {
            return sequenceArrBestSequences[0];
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b1  */
    @Override // opennlp.tools.p217ml.model.SequenceClassificationModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Sequence[] bestSequences(int i, T[] tArr, Object[] objArr, double d, BeamSearchContextGenerator<T> beamSearchContextGenerator, SequenceValidator<T> sequenceValidator) {
        int i2;
        int i4;
        PriorityQueue priorityQueue = new PriorityQueue(this.size);
        PriorityQueue priorityQueue2 = new PriorityQueue(this.size);
        priorityQueue.add(new Sequence());
        Object[] objArr2 = objArr == null ? EMPTY_ADDITIONAL_CONTEXT : objArr;
        int i5 = 0;
        int i6 = 0;
        while (i6 < tArr.length) {
            int iMin = StrictMath.min(this.size, priorityQueue.size());
            int i7 = i5;
            while (priorityQueue.size() > 0 && i7 < iMin) {
                Sequence sequence = (Sequence) priorityQueue.remove();
                String[] strArr = (String[]) sequence.getOutcomes().toArray(new String[i5]);
                String[] context = beamSearchContextGenerator.getContext(i6, tArr, strArr, objArr2);
                Cache<String[], double[]> cache = this.contextsCache;
                double[] dArrComputeIfAbsent = cache != null ? cache.computeIfAbsent(context, new C0332a(this, 11)) : this.model.eval(context, this.probs);
                double[] dArr = new double[dArrComputeIfAbsent.length];
                System.arraycopy(dArrComputeIfAbsent, 0, dArr, 0, dArrComputeIfAbsent.length);
                Arrays.sort(dArr);
                PriorityQueue priorityQueue3 = priorityQueue;
                double d2 = dArr[StrictMath.max(0, dArrComputeIfAbsent.length - this.size)];
                int i8 = 0;
                while (i8 < dArrComputeIfAbsent.length) {
                    if (dArrComputeIfAbsent[i8] >= d2) {
                        String outcome = this.model.getOutcome(i8);
                        if (sequenceValidator.validSequence(i6, tArr, strArr, outcome)) {
                            i2 = iMin;
                            i4 = i7;
                            Sequence sequence2 = new Sequence(sequence, outcome, dArrComputeIfAbsent[i8]);
                            if (sequence2.getScore() > d) {
                                priorityQueue2.add(sequence2);
                            }
                        } else {
                            i2 = iMin;
                            i4 = i7;
                        }
                    }
                    i8++;
                    iMin = i2;
                    i7 = i4;
                }
                int i9 = iMin;
                int i10 = i7;
                if (priorityQueue2.size() == 0) {
                    for (int i11 = 0; i11 < dArrComputeIfAbsent.length; i11++) {
                        String outcome2 = this.model.getOutcome(i11);
                        if (sequenceValidator.validSequence(i6, tArr, strArr, outcome2)) {
                            Sequence sequence3 = new Sequence(sequence, outcome2, dArrComputeIfAbsent[i11]);
                            if (sequence3.getScore() > d) {
                                priorityQueue2.add(sequence3);
                            }
                        }
                    }
                }
                i7 = i10 + 1;
                priorityQueue = priorityQueue3;
                i5 = 0;
                iMin = i9;
            }
            PriorityQueue priorityQueue4 = priorityQueue;
            priorityQueue4.clear();
            i6++;
            priorityQueue = priorityQueue2;
            i5 = i5;
            priorityQueue2 = priorityQueue4;
        }
        PriorityQueue priorityQueue5 = priorityQueue;
        int iMin2 = StrictMath.min(i, priorityQueue5.size());
        Sequence[] sequenceArr = new Sequence[iMin2];
        while (i5 < iMin2) {
            sequenceArr[i5] = (Sequence) priorityQueue5.remove();
            i5++;
        }
        return sequenceArr;
    }

    @Override // opennlp.tools.p217ml.model.SequenceClassificationModel
    public String[] getOutcomes() {
        String[] strArr = new String[this.model.getNumOutcomes()];
        for (int i = 0; i < this.model.getNumOutcomes(); i++) {
            strArr[i] = this.model.getOutcome(i);
        }
        return strArr;
    }

    public BeamSearch(int i, MaxentModel maxentModel, int i2) {
        this.size = i;
        this.model = maxentModel;
        if (i2 > 0) {
            this.contextsCache = new Cache<>(i2);
        }
        this.probs = new double[maxentModel.getNumOutcomes()];
    }

    @Override // opennlp.tools.p217ml.model.SequenceClassificationModel
    public <T> Sequence[] bestSequences(int i, T[] tArr, Object[] objArr, BeamSearchContextGenerator<T> beamSearchContextGenerator, SequenceValidator<T> sequenceValidator) {
        return bestSequences(i, tArr, objArr, -100000.0d, beamSearchContextGenerator, sequenceValidator);
    }
}
