package opennlp.tools.cmdline;

import androidx.glance.AbstractC2821a;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import opennlp.tools.commons.Internal;
import opennlp.tools.util.Span;
import opennlp.tools.util.eval.EvaluationMonitor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public abstract class DetailedFMeasureListener<T> implements EvaluationMonitor<T> {
    private static final String FORMAT = "%12s: precision: % 7.2f%%;  recall: % 7.2f%%; F1: % 7.2f%%.";
    private static final String FORMAT_EXTRA = "%12s: precision: % 7.2f%%;  recall: % 7.2f%%; F1: % 7.2f%%. [target: %3d; tp: %3d; fp: %3d]";
    private static final String PERCENT = "% 7.2f%%";
    private int samples = 0;
    private final Stats generalStats = new Stats(0);
    private final Map<String, Stats> statsForOutcome = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class F1Comparator implements Comparator<String> {
        public /* synthetic */ F1Comparator(DetailedFMeasureListener detailedFMeasureListener, int i) {
            this();
        }

        private F1Comparator() {
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (str.equals(str2)) {
                return 0;
            }
            double fMeasure = DetailedFMeasureListener.this.statsForOutcome.containsKey(str) ? ((Stats) DetailedFMeasureListener.this.statsForOutcome.get(str)).getFMeasure() + 0.0d : 0.0d;
            double fMeasure2 = DetailedFMeasureListener.this.statsForOutcome.containsKey(str2) ? ((Stats) DetailedFMeasureListener.this.statsForOutcome.get(str2)).getFMeasure() + 0.0d : 0.0d;
            double dZeroOrPositive = DetailedFMeasureListener.this.zeroOrPositive(fMeasure);
            double dZeroOrPositive2 = DetailedFMeasureListener.this.zeroOrPositive(fMeasure2);
            return dZeroOrPositive + dZeroOrPositive2 > 0.0d ? dZeroOrPositive > dZeroOrPositive2 ? -1 : 1 : str.compareTo(str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Stats {
        private int falsePositiveCounter;
        private int targetCounter;
        private int truePositiveCounter;

        public /* synthetic */ Stats(int i) {
            this();
        }

        public double getFMeasure() {
            if (getPrecisionScore() + getRecallScore() > 0.0d) {
                return ((getPrecisionScore() * getRecallScore()) * 2.0d) / (getPrecisionScore() + getRecallScore());
            }
            return -1.0d;
        }

        public int getFalsePositives() {
            return this.falsePositiveCounter;
        }

        public double getPrecisionScore() {
            int truePositives = getTruePositives();
            int falsePositives = getFalsePositives() + truePositives;
            if (falsePositives > 0) {
                return ((double) truePositives) / ((double) falsePositives);
            }
            return 0.0d;
        }

        public double getRecallScore() {
            int target = getTarget();
            int truePositives = getTruePositives();
            if (target > 0) {
                return ((double) truePositives) / ((double) target);
            }
            return 0.0d;
        }

        public int getTarget() {
            return this.targetCounter;
        }

        public int getTruePositives() {
            return this.truePositiveCounter;
        }

        public void incrementFalsePositive() {
            this.falsePositiveCounter++;
        }

        public void incrementTarget() {
            this.targetCounter++;
        }

        public void incrementTruePositive() {
            this.truePositiveCounter++;
        }

        private Stats() {
            this.falsePositiveCounter = 0;
            this.truePositiveCounter = 0;
            this.targetCounter = 0;
        }
    }

    private void addFalseNegative(String str) {
        initStatsForOutcomeAndGet(str).incrementTarget();
        this.generalStats.incrementTarget();
    }

    private void addFalsePositive(String str) {
        initStatsForOutcomeAndGet(str).incrementFalsePositive();
        this.generalStats.incrementFalsePositive();
    }

    private void addTruePositive(String str) {
        Stats statsInitStatsForOutcomeAndGet = initStatsForOutcomeAndGet(str);
        statsInitStatsForOutcomeAndGet.incrementTruePositive();
        statsInitStatsForOutcomeAndGet.incrementTarget();
        this.generalStats.incrementTruePositive();
        this.generalStats.incrementTarget();
    }

    private Stats initStatsForOutcomeAndGet(String str) {
        if (!this.statsForOutcome.containsKey(str)) {
            this.statsForOutcome.put(str, new Stats(0));
        }
        return this.statsForOutcome.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double zeroOrPositive(double d) {
        if (d < 0.0d) {
            return 0.0d;
        }
        return d;
    }

    public abstract Span[] asSpanArray(T t);

    @Override // opennlp.tools.util.eval.EvaluationMonitor
    public void correctlyClassified(T t, T t2) {
        this.samples++;
        for (Span span : asSpanArray(t)) {
            addTruePositive(span.getType());
        }
    }

    public String createReport() {
        return createReport(Locale.getDefault());
    }

    @Override // opennlp.tools.util.eval.EvaluationMonitor
    public void misclassified(T t, T t2) {
        this.samples++;
        Span[] spanArrAsSpanArray = asSpanArray(t);
        Span[] spanArrAsSpanArray2 = asSpanArray(t2);
        HashSet<Span> hashSet = new HashSet(Arrays.asList(spanArrAsSpanArray));
        HashSet<Span> hashSet2 = new HashSet(Arrays.asList(spanArrAsSpanArray2));
        for (Span span : hashSet) {
            if (hashSet2.contains(span)) {
                addTruePositive(span.getType());
            } else {
                addFalseNegative(span.getType());
            }
        }
        for (Span span2 : hashSet2) {
            if (!hashSet.contains(span2)) {
                addFalsePositive(span2.getType());
            }
        }
    }

    public String toString() {
        return createReport();
    }

    public String createReport(Locale locale) {
        StringBuilder sb = new StringBuilder("Evaluated ");
        int truePositives = this.generalStats.getTruePositives();
        int falsePositives = this.generalStats.getFalsePositives() + truePositives;
        sb.append(this.samples);
        sb.append(" samples with ");
        AbstractC2821a.m2235z(sb, this.generalStats.getTarget(), falsePositives, " entities; found: ", " entities; correct: ");
        sb.append(truePositives);
        sb.append(".\n");
        sb.append(String.format(locale, FORMAT, "TOTAL", Double.valueOf(zeroOrPositive(this.generalStats.getPrecisionScore() * 100.0d)), Double.valueOf(zeroOrPositive(this.generalStats.getRecallScore() * 100.0d)), Double.valueOf(zeroOrPositive(this.generalStats.getFMeasure() * 100.0d))));
        sb.append("\n");
        TreeSet<String> treeSet = new TreeSet(new F1Comparator(this, 0));
        treeSet.addAll(this.statsForOutcome.keySet());
        for (String str : treeSet) {
            sb.append(String.format(locale, FORMAT_EXTRA, str, Double.valueOf(zeroOrPositive(this.statsForOutcome.get(str).getPrecisionScore() * 100.0d)), Double.valueOf(zeroOrPositive(this.statsForOutcome.get(str).getRecallScore() * 100.0d)), Double.valueOf(zeroOrPositive(this.statsForOutcome.get(str).getFMeasure() * 100.0d)), Integer.valueOf(this.statsForOutcome.get(str).getTarget()), Integer.valueOf(this.statsForOutcome.get(str).getTruePositives()), Integer.valueOf(this.statsForOutcome.get(str).getFalsePositives())));
            sb.append("\n");
        }
        return sb.toString();
    }
}
