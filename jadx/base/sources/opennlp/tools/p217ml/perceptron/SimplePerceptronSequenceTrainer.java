package opennlp.tools.p217ml.perceptron;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import opennlp.tools.p217ml.AbstractEventModelSequenceTrainer;
import opennlp.tools.p217ml.model.AbstractDataIndexer;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.Event;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.p217ml.model.MutableContext;
import opennlp.tools.p217ml.model.OnePassDataIndexer;
import opennlp.tools.p217ml.model.Sequence;
import opennlp.tools.p217ml.model.SequenceStream;
import opennlp.tools.p217ml.model.SequenceStreamEventStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SimplePerceptronSequenceTrainer extends AbstractEventModelSequenceTrainer {
    private static final int EVENT = 2;
    private static final int ITER = 1;
    public static final String PERCEPTRON_SEQUENCE_VALUE = "PERCEPTRON_SEQUENCE";
    private static final int VALUE = 0;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) SimplePerceptronSequenceTrainer.class);
    private MutableContext[] averageParams;
    private int iterations;
    private int numEvents;
    private int numOutcomes;
    private int numPreds;
    private int numSequences;
    private Map<String, Integer> omap;
    private String[] outcomeLabels;
    private int[] outcomeList;
    private MutableContext[] params;
    private Map<String, Integer> pmap;
    private String[] predLabels;
    private SequenceStream<Event> sequenceStream;
    private int[][][] updates;
    private boolean useAverage;

    private void findParameters(int i) {
        logger.info("Performing {} iterations.\n", Integer.valueOf(i));
        for (int i2 = 1; i2 <= i; i2++) {
            nextIteration(i2);
        }
        if (this.useAverage) {
            trainingStats(this.averageParams);
        } else {
            trainingStats(this.params);
        }
    }

    private void trainingStats(MutableContext[] mutableContextArr) {
        this.sequenceStream.reset();
        int i = 0;
        int i2 = 0;
        while (true) {
            Sequence sequence = this.sequenceStream.read();
            if (sequence == null) {
                logger.info(". ({}/{}) {}", Integer.valueOf(i), Integer.valueOf(this.numEvents), Double.valueOf(((double) i) / ((double) this.numEvents)));
                return;
            }
            Event[] eventArrUpdateContext = this.sequenceStream.updateContext(sequence, new PerceptronModel(mutableContextArr, this.predLabels, this.outcomeLabels));
            int i4 = 0;
            while (i4 < eventArrUpdateContext.length) {
                if (this.omap.get(eventArrUpdateContext[i4].getOutcome()).intValue() == this.outcomeList[i2]) {
                    i++;
                }
                i4++;
                i2++;
            }
        }
    }

    @Override // opennlp.tools.p217ml.AbstractEventModelSequenceTrainer
    public /* bridge */ /* synthetic */ MaxentModel doTrain(SequenceStream sequenceStream) {
        return doTrain((SequenceStream<Event>) sequenceStream);
    }

    public void nextIteration(int i) {
        Logger logger2;
        int i2 = -1;
        int i4 = i - 1;
        ArrayList arrayList = new ArrayList(this.numOutcomes);
        for (int i5 = 0; i5 < this.numOutcomes; i5++) {
            arrayList.add(new HashMap());
        }
        PerceptronModel perceptronModel = new PerceptronModel(this.params, this.predLabels, this.outcomeLabels);
        this.sequenceStream.reset();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            Sequence sequence = this.sequenceStream.read();
            if (sequence == null) {
                break;
            }
            Event[] eventArrUpdateContext = this.sequenceStream.updateContext(sequence, perceptronModel);
            Event[] events = sequence.getEvents();
            int i9 = 0;
            boolean z = false;
            while (i9 < events.length) {
                if (eventArrUpdateContext[i9].getOutcome().equals(events[i9].getOutcome())) {
                    i7++;
                } else {
                    z = true;
                }
                i9++;
                i8++;
            }
            if (z) {
                for (int i10 = 0; i10 < this.numOutcomes; i10++) {
                    ((Map) arrayList.get(i10)).clear();
                }
                if (logger.isTraceEnabled()) {
                    StringBuilder sb = new StringBuilder();
                    for (Event event : events) {
                        sb.append(" ");
                        sb.append(event.getOutcome());
                    }
                    logger.trace("train: {}", sb);
                }
                int i11 = 0;
                while (i11 < events.length) {
                    String[] context = events[i11].getContext();
                    float[] values = events[i11].getValues();
                    int iIntValue = this.omap.get(events[i11].getOutcome()).intValue();
                    int i12 = 0;
                    while (i12 < context.length) {
                        float f = values != null ? values[i12] : 1.0f;
                        int i13 = i2;
                        int i14 = i11;
                        Float f4 = (Float) ((Map) arrayList.get(iIntValue)).get(context[i12]);
                        ((Map) arrayList.get(iIntValue)).put(context[i12], f4 == null ? Float.valueOf(f) : Float.valueOf(f4.floatValue() + f));
                        i12++;
                        i11 = i14;
                        i2 = i13;
                    }
                    i11++;
                    i8++;
                }
                int i15 = i2;
                if (logger.isTraceEnabled()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (Event event2 : eventArrUpdateContext) {
                        sb2.append(" ");
                        sb2.append(event2.getOutcome());
                    }
                    logger.trace("test: {}", sb2);
                }
                for (Event event3 : eventArrUpdateContext) {
                    String[] context2 = event3.getContext();
                    float[] values2 = event3.getValues();
                    int iIntValue2 = this.omap.get(event3.getOutcome()).intValue();
                    for (int i16 = 0; i16 < context2.length; i16++) {
                        float f5 = values2 != null ? values2[i16] : 1.0f;
                        Float f6 = (Float) ((Map) arrayList.get(iIntValue2)).get(context2[i16]);
                        Float fValueOf = f6 == null ? Float.valueOf(f5 * (-1.0f)) : Float.valueOf(f6.floatValue() - f5);
                        if (fValueOf.floatValue() == 0.0f) {
                            ((Map) arrayList.get(iIntValue2)).remove(context2[i16]);
                        } else {
                            ((Map) arrayList.get(iIntValue2)).put(context2[i16], fValueOf);
                        }
                    }
                }
                int i17 = 0;
                while (i17 < this.numOutcomes) {
                    for (String str : ((Map) arrayList.get(i17)).keySet()) {
                        Integer orDefault = this.pmap.getOrDefault(str, Integer.valueOf(i15));
                        int iIntValue3 = orDefault.intValue();
                        if (iIntValue3 != i15) {
                            Logger logger3 = logger;
                            if (logger3.isTraceEnabled()) {
                                logger3.trace("{} {} {} {}", Integer.valueOf(i6), this.outcomeLabels[i17], str, ((Map) arrayList.get(i17)).get(str));
                            }
                            this.params[iIntValue3].updateParameter(i17, ((Float) ((Map) arrayList.get(i17)).get(str)).floatValue());
                            if (this.useAverage) {
                                int[] iArr = this.updates[iIntValue3][i17];
                                int i18 = iArr[0];
                                if (i18 != 0) {
                                    MutableContext mutableContext = this.averageParams[iIntValue3];
                                    int i19 = ((i6 - iArr[2]) + ((i4 - iArr[1]) * this.numSequences)) * i18;
                                    logger2 = logger3;
                                    mutableContext.updateParameter(i17, i19);
                                    if (logger2.isTraceEnabled()) {
                                        logger2.trace("p avp[{}].{}={}", orDefault, Integer.valueOf(i17), Double.valueOf(this.averageParams[iIntValue3].getParameters()[i17]));
                                    }
                                } else {
                                    logger2 = logger3;
                                }
                                if (logger2.isTraceEnabled()) {
                                    logger2.trace("p updates[{}]{{}]=({},{},{})({},{},{}) -> {}", orDefault, Integer.valueOf(i17), Integer.valueOf(this.updates[iIntValue3][i17][1]), Integer.valueOf(this.updates[iIntValue3][i17][2]), Integer.valueOf(this.updates[iIntValue3][i17][0]), Integer.valueOf(i4), Integer.valueOf(i8), Double.valueOf(this.params[iIntValue3].getParameters()[i17]), Double.valueOf(this.averageParams[iIntValue3].getParameters()[i17]));
                                }
                                this.updates[iIntValue3][i17][0] = (int) this.params[iIntValue3].getParameters()[i17];
                                int[] iArr2 = this.updates[iIntValue3][i17];
                                iArr2[1] = i4;
                                iArr2[2] = i6;
                            }
                        }
                        i15 = -1;
                    }
                    i17++;
                    i15 = -1;
                }
                perceptronModel = new PerceptronModel(this.params, this.predLabels, this.outcomeLabels);
            }
            i6++;
            i2 = -1;
        }
        int i20 = this.iterations;
        double d = ((double) i20) * ((double) i6);
        if (this.useAverage && i4 == i20 - 1) {
            for (int i21 = 0; i21 < this.numPreds; i21++) {
                double[] parameters = this.averageParams[i21].getParameters();
                for (int i22 = 0; i22 < this.numOutcomes; i22++) {
                    int[] iArr3 = this.updates[i21][i22];
                    int i23 = iArr3[0];
                    if (i23 != 0) {
                        parameters[i22] = parameters[i22] + ((double) ((((this.iterations - iArr3[1]) * this.numSequences) - iArr3[2]) * i23));
                    }
                    double d2 = parameters[i22];
                    if (d2 != 0.0d) {
                        double d3 = d2 / d;
                        parameters[i22] = d3;
                        this.averageParams[i21].setParameter(i22, d3);
                        Logger logger4 = logger;
                        if (logger4.isTraceEnabled()) {
                            logger4.trace("updates[{}][{}]=({},{},{})({},{},{}) -> {}", Integer.valueOf(i21), Integer.valueOf(i22), Integer.valueOf(this.updates[i21][i22][1]), Integer.valueOf(this.updates[i21][i22][2]), Integer.valueOf(this.updates[i21][i22][0]), Integer.valueOf(this.iterations), 0, Double.valueOf(this.params[i21].getParameters()[i22]), Double.valueOf(this.averageParams[i21].getParameters()[i22]));
                        }
                    }
                }
            }
        }
        logger.info("{}. ({}/{}) {}", Integer.valueOf(i4), Integer.valueOf(i7), Integer.valueOf(this.numEvents), Double.valueOf(((double) i7) / ((double) this.numEvents)));
    }

    public AbstractModel trainModel(int i, SequenceStream<Event> sequenceStream, int i2, boolean z) {
        this.iterations = i;
        this.sequenceStream = sequenceStream;
        this.trainingParameters.put("Cutoff", i2);
        this.trainingParameters.put(AbstractDataIndexer.SORT_PARAM, false);
        OnePassDataIndexer onePassDataIndexer = new OnePassDataIndexer();
        onePassDataIndexer.init(this.trainingParameters, this.reportMap);
        onePassDataIndexer.index(new SequenceStreamEventStream(sequenceStream));
        this.numSequences = 0;
        sequenceStream.reset();
        while (sequenceStream.read() != null) {
            this.numSequences++;
        }
        this.outcomeList = onePassDataIndexer.getOutcomeList();
        this.predLabels = onePassDataIndexer.getPredLabels();
        this.pmap = new HashMap();
        int i4 = 0;
        while (true) {
            String[] strArr = this.predLabels;
            if (i4 >= strArr.length) {
                break;
            }
            this.pmap.put(strArr[i4], Integer.valueOf(i4));
            i4++;
        }
        logger.info("Incorporating indexed data for training... ");
        this.useAverage = z;
        this.numEvents = onePassDataIndexer.getNumEvents();
        this.iterations = i;
        this.outcomeLabels = onePassDataIndexer.getOutcomeLabels();
        this.omap = new HashMap();
        int i5 = 0;
        while (true) {
            String[] strArr2 = this.outcomeLabels;
            if (i5 >= strArr2.length) {
                break;
            }
            this.omap.put(strArr2[i5], Integer.valueOf(i5));
            i5++;
        }
        this.outcomeList = onePassDataIndexer.getOutcomeList();
        int length = this.predLabels.length;
        this.numPreds = length;
        int length2 = this.outcomeLabels.length;
        this.numOutcomes = length2;
        if (z) {
            this.updates = (int[][][]) Array.newInstance((Class<?>) Integer.TYPE, length, length2, 3);
        }
        Logger logger2 = logger;
        logger2.info("done.");
        logger2.info("\tNumber of Event Tokens: {} \n\t Number of Outcomes: {} \n\t Number of Predicates: {}", Integer.valueOf(this.numEvents), Integer.valueOf(this.numOutcomes), Integer.valueOf(this.numPreds));
        int i6 = this.numPreds;
        this.params = new MutableContext[i6];
        if (z) {
            this.averageParams = new MutableContext[i6];
        }
        int[] iArr = new int[this.numOutcomes];
        for (int i7 = 0; i7 < this.numOutcomes; i7++) {
            iArr[i7] = i7;
        }
        for (int i8 = 0; i8 < this.numPreds; i8++) {
            this.params[i8] = new MutableContext(iArr, new double[this.numOutcomes]);
            if (z) {
                this.averageParams[i8] = new MutableContext(iArr, new double[this.numOutcomes]);
            }
            for (int i9 = 0; i9 < this.numOutcomes; i9++) {
                this.params[i8].setParameter(i9, 0.0d);
                if (z) {
                    this.averageParams[i8].setParameter(i9, 0.0d);
                }
            }
        }
        Logger logger3 = logger;
        logger3.info("Computing model parameters...");
        findParameters(i);
        logger3.info("...done.");
        String[] strArr3 = this.predLabels;
        return z ? new PerceptronModel(this.averageParams, strArr3, this.outcomeLabels) : new PerceptronModel(this.params, strArr3, this.outcomeLabels);
    }

    @Override // opennlp.tools.p217ml.AbstractTrainer
    public void validate() {
        super.validate();
        String algorithm = getAlgorithm();
        if (algorithm != null && !PERCEPTRON_SEQUENCE_VALUE.equals(algorithm)) {
            throw new IllegalArgumentException("algorithmName must be PERCEPTRON_SEQUENCE");
        }
    }

    @Override // opennlp.tools.p217ml.AbstractEventModelSequenceTrainer
    public AbstractModel doTrain(SequenceStream<Event> sequenceStream) {
        return trainModel(getIterations(), sequenceStream, getCutoff(), this.trainingParameters.getBooleanParameter("UseAverage", true));
    }
}
