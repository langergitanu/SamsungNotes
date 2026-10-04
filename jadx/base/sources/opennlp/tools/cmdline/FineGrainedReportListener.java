package opennlp.tools.cmdline;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.MarkdownDocument;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import opennlp.tools.util.Span;
import opennlp.tools.util.eval.FMeasure;
import opennlp.tools.util.eval.Mean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class FineGrainedReportListener {
    private static final char[] alpha = {'a', 'b', DeviceInfoUtil.FLAVOR_TYPE_C, 'd', 'e', 'f', DeviceInfoUtil.FLAVOR_TYPE_G, 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private final PrintStream printStream;
    private final Stats stats = new Stats();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ConfusionMatrixLine {
        private double acc;
        private int correct;
        private final Map<String, Counter> line;
        private final String ref;
        private int total;

        public /* synthetic */ ConfusionMatrixLine(String str, int i) {
            this(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void increment(String str) {
            this.total++;
            if (str.equals(this.ref)) {
                this.correct++;
            }
            if (!this.line.containsKey(str)) {
                this.line.put(str, new Counter());
            }
            this.line.get(str).increment();
        }

        public double getAccuracy() {
            if (StrictMath.abs(this.acc - 1.0d) < 1.0E-10d) {
                int i = this.total;
                if (i == 0) {
                    this.acc = 0.0d;
                }
                this.acc = ((double) this.correct) / ((double) i);
            }
            return this.acc;
        }

        public int getValue(String str) {
            Counter counter = this.line.get(str);
            if (counter == null) {
                return 0;
            }
            return counter.value();
        }

        private ConfusionMatrixLine(String str) {
            this.line = new HashMap();
            this.total = 0;
            this.correct = 0;
            this.acc = -1.0d;
            this.ref = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Counter {

        /* JADX INFO: renamed from: c */
        private int f9652c = 0;

        /* JADX INFO: Access modifiers changed from: private */
        public void increment() {
            this.f9652c++;
        }

        public int value() {
            return this.f9652c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GroupedLabelComparator implements Comparator<String> {
        private final HashMap<String, Integer> categoryCounter = new HashMap<>();
        private final Map<String, Counter> labelCounter;

        public GroupedLabelComparator(Map<String, Counter> map) {
            this.labelCounter = map;
            for (Map.Entry<String, Counter> entry : map.entrySet()) {
                String key = entry.getKey();
                Counter value = entry.getValue();
                if (key.contains(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) {
                    key = key.split(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)[0];
                }
                this.categoryCounter.put(key, Integer.valueOf(value.value() + this.categoryCounter.getOrDefault(key, 0).intValue()));
            }
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (str.equals(str2)) {
                return 0;
            }
            String str3 = str.contains(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR) ? str.split(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)[0] : str;
            String str4 = str2.contains(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR) ? str2.split(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)[0] : str2;
            if (!str3.equals(str4)) {
                Integer num = this.categoryCounter.get(str3);
                Integer num2 = this.categoryCounter.get(str4);
                return (num == null || num2 == null) ? num == null ? 1 : -1 : num.equals(num2) ? str.compareTo(str2) : num2.intValue() > num.intValue() ? 1 : -1;
            }
            Counter counter = this.labelCounter.get(str);
            Counter counter2 = this.labelCounter.get(str2);
            if (counter == null || counter2 == null) {
                return counter == null ? 1 : -1;
            }
            int iValue = counter.value();
            int iValue2 = counter2.value();
            return iValue == iValue2 ? str.compareTo(str2) : iValue2 > iValue ? 1 : -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GroupedMatrixLabelComparator implements Comparator<String> {
        private final HashMap<String, Double> categoryAccuracy = new HashMap<>();
        private final Map<String, ConfusionMatrixLine> confusionMatrix;

        public GroupedMatrixLabelComparator(Map<String, ConfusionMatrixLine> map) {
            this.confusionMatrix = map;
            for (Map.Entry<String, ConfusionMatrixLine> entry : map.entrySet()) {
                String key = entry.getKey();
                ConfusionMatrixLine value = entry.getValue();
                if (key.contains(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) {
                    key = key.split(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)[0];
                }
                this.categoryAccuracy.put(key, Double.valueOf(value.getAccuracy() + this.categoryAccuracy.getOrDefault(key, Double.valueOf(0.0d)).doubleValue()));
            }
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (str.equals(str2)) {
                return 0;
            }
            String str3 = str.contains(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR) ? str.split(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)[0] : str;
            String str4 = str2.contains(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR) ? str2.split(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)[0] : str2;
            if (!str3.equals(str4)) {
                Double d = this.categoryAccuracy.get(str3);
                Double d2 = this.categoryAccuracy.get(str4);
                return (d == null || d2 == null) ? d == null ? 1 : -1 : d.equals(d2) ? str.compareTo(str2) : d2.doubleValue() > d.doubleValue() ? 1 : -1;
            }
            ConfusionMatrixLine confusionMatrixLine = this.confusionMatrix.get(str);
            ConfusionMatrixLine confusionMatrixLine2 = this.confusionMatrix.get(str2);
            if (confusionMatrixLine == null || confusionMatrixLine2 == null) {
                return confusionMatrixLine == null ? 1 : -1;
            }
            double accuracy = confusionMatrixLine.getAccuracy();
            double accuracy2 = confusionMatrixLine2.getAccuracy();
            return accuracy == accuracy2 ? str.compareTo(str2) : accuracy2 > accuracy ? 1 : -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MatrixLabelComparator implements Comparator<String> {
        private final Map<String, ConfusionMatrixLine> confusionMatrix;

        public MatrixLabelComparator(Map<String, ConfusionMatrixLine> map) {
            this.confusionMatrix = map;
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (str.equals(str2)) {
                return 0;
            }
            ConfusionMatrixLine confusionMatrixLine = this.confusionMatrix.get(str);
            ConfusionMatrixLine confusionMatrixLine2 = this.confusionMatrix.get(str2);
            if (confusionMatrixLine == null || confusionMatrixLine2 == null) {
                return confusionMatrixLine == null ? 1 : -1;
            }
            double accuracy = confusionMatrixLine.getAccuracy();
            double accuracy2 = confusionMatrixLine2.getAccuracy();
            return accuracy == accuracy2 ? str.compareTo(str2) : accuracy2 > accuracy ? 1 : -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SimpleLabelComparator implements Comparator<String> {
        private final Map<String, Counter> map;

        public SimpleLabelComparator(Map<String, Counter> map) {
            this.map = map;
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (str.equals(str2)) {
                return 0;
            }
            int iValue = this.map.containsKey(str) ? this.map.get(str).value() : 0;
            int iValue2 = this.map.containsKey(str2) ? this.map.get(str2).value() : 0;
            return iValue == iValue2 ? str.compareTo(str2) : iValue2 - iValue;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Stats {
        private final Mean accuracy = new Mean();
        private final Mean averageSentenceLength = new Mean();
        private final Map<String, Mean> tokAccuracies = new HashMap();
        private final Map<String, Counter> tokOccurrences = new HashMap();
        private final Map<String, Counter> tokErrors = new HashMap();
        private final Map<String, Counter> tagOccurrences = new HashMap();
        private final Map<String, Counter> tagErrors = new HashMap();
        private final Map<String, FMeasure> tagFMeasure = new HashMap();
        private final Map<String, ConfusionMatrixLine> generalConfusionMatrix = new HashMap();
        private final Map<String, Map<String, ConfusionMatrixLine>> tokenConfusionMatrix = new HashMap();
        private int minimalSentenceLength = Integer.MAX_VALUE;
        private int maximumSentenceLength = Integer.MIN_VALUE;

        public Stats() {
        }

        private void commit(String str, String str2, String str3) {
            if (!this.tokAccuracies.containsKey(str)) {
                this.tokAccuracies.put(str, new Mean());
                this.tokOccurrences.put(str, new Counter());
                this.tokErrors.put(str, new Counter());
            }
            this.tokOccurrences.get(str).increment();
            if (!this.tagOccurrences.containsKey(str2)) {
                this.tagOccurrences.put(str2, new Counter());
                this.tagErrors.put(str2, new Counter());
            }
            this.tagOccurrences.get(str2).increment();
            if (str2.equals(str3)) {
                this.tokAccuracies.get(str).add(1.0d);
                this.accuracy.add(1.0d);
            } else {
                this.tokAccuracies.get(str).add(0.0d);
                this.tokErrors.get(str).increment();
                this.tagErrors.get(str2).increment();
                this.accuracy.add(0.0d);
            }
            int i = 0;
            if (!this.generalConfusionMatrix.containsKey(str2)) {
                this.generalConfusionMatrix.put(str2, new ConfusionMatrixLine(str2, i));
            }
            this.generalConfusionMatrix.get(str2).increment(str3);
            if (!this.tokenConfusionMatrix.containsKey(str)) {
                this.tokenConfusionMatrix.put(str, new HashMap());
            }
            if (!this.tokenConfusionMatrix.get(str).containsKey(str2)) {
                this.tokenConfusionMatrix.get(str).put(str2, new ConfusionMatrixLine(str2, i));
            }
            this.tokenConfusionMatrix.get(str).get(str2).increment(str3);
        }

        private double[][] createConfusionMatrix(SortedSet<String> sortedSet, Map<String, ConfusionMatrixLine> map) {
            double accuracy;
            int size = sortedSet.size();
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, size + 1);
            int i = 0;
            for (String str : sortedSet) {
                Iterator<String> it = sortedSet.iterator();
                int i2 = 0;
                while (true) {
                    accuracy = 0.0d;
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    double[] dArr2 = dArr[i];
                    if (map.get(str) != null) {
                        accuracy = map.get(str).getValue(next);
                    }
                    dArr2[i2] = accuracy;
                    i2++;
                }
                double[] dArr3 = dArr[i];
                if (map.get(str) != null) {
                    accuracy = map.get(str).getAccuracy();
                }
                dArr3[i2] = accuracy;
                i++;
            }
            return dArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public double getAccuracy() {
            return this.accuracy.mean();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public double getAverageSentenceSize() {
            return this.averageSentenceLength.mean();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public double[][] getConfusionMatrix() {
            return createConfusionMatrix(getConfusionMatrixTagset(), this.generalConfusionMatrix);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SortedSet<String> getConfusionMatrixTagset() {
            return getConfusionMatrixTagset(this.generalConfusionMatrix);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getMaxSentenceSize() {
            return this.maximumSentenceLength;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getMinSentenceSize() {
            return this.minimalSentenceLength;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getNumberOfSentences() {
            return this.averageSentenceLength.count();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getNumberOfTags() {
            return this.tagOccurrences.keySet().size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getTagErrors(String str) {
            return this.tagErrors.get(str).value();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public double getTagFMeasure(String str) {
            return this.tagFMeasure.get(str).getFMeasure();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getTagFrequency(String str) {
            return this.tagOccurrences.get(str).value();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public double getTagPrecision(String str) {
            return this.tagFMeasure.get(str).getPrecisionScore();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public double getTagRecall(String str) {
            return this.tagFMeasure.get(str).getRecallScore();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SortedSet<String> getTagsOrderedByErrors() {
            TreeSet treeSet = new TreeSet(FineGrainedReportListener.this.getLabelComparator(this.tagErrors));
            treeSet.addAll(this.tagErrors.keySet());
            return Collections.unmodifiableSortedSet(treeSet);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public double getTokenAccuracy(String str) {
            return this.tokAccuracies.get(str).mean();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getTokenErrors(String str) {
            return this.tokErrors.get(str).value();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getTokenFrequency(String str) {
            return this.tokOccurrences.get(str).value();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SortedSet<String> getTokensOrderedByFrequency() {
            TreeSet treeSet = new TreeSet(new SimpleLabelComparator(this.tokOccurrences));
            treeSet.addAll(this.tokOccurrences.keySet());
            return Collections.unmodifiableSortedSet(treeSet);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SortedSet<String> getTokensOrderedByNumberOfErrors() {
            TreeSet treeSet = new TreeSet(new SimpleLabelComparator(this.tokErrors));
            treeSet.addAll(this.tokErrors.keySet());
            return treeSet;
        }

        private void updateTagFMeasure(String[] strArr, String[] strArr2) {
            HashSet<String> hashSet = new HashSet(Arrays.asList(strArr));
            hashSet.addAll(Arrays.asList(strArr2));
            for (String str : hashSet) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < strArr.length; i++) {
                    if (strArr[i].equals(str)) {
                        arrayList.add(new Span(i, i + 1));
                    }
                    if (strArr2[i].equals(str)) {
                        arrayList2.add(new Span(i, i + 1));
                    }
                }
                if (!this.tagFMeasure.containsKey(str)) {
                    this.tagFMeasure.put(str, new FMeasure());
                }
                this.tagFMeasure.get(str).updateScores(arrayList.toArray(new Span[0]), arrayList2.toArray(new Span[0]));
            }
        }

        public void add(String[] strArr, String[] strArr2, String[] strArr3) {
            int length = strArr.length;
            this.averageSentenceLength.add(length);
            if (this.minimalSentenceLength > length) {
                this.minimalSentenceLength = length;
            }
            if (this.maximumSentenceLength < length) {
                this.maximumSentenceLength = length;
            }
            updateTagFMeasure(strArr2, strArr3);
            for (int i = 0; i < strArr.length; i++) {
                commit(strArr[i], strArr2[i], strArr3[i]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public double[][] getConfusionMatrix(String str) {
            return createConfusionMatrix(getConfusionMatrixTagset(str), this.tokenConfusionMatrix.get(str));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SortedSet<String> getConfusionMatrixTagset(String str) {
            return getConfusionMatrixTagset(this.tokenConfusionMatrix.get(str));
        }

        private SortedSet<String> getConfusionMatrixTagset(Map<String, ConfusionMatrixLine> map) {
            TreeSet treeSet = new TreeSet(FineGrainedReportListener.this.getMatrixLabelComparator(map));
            treeSet.addAll(map.keySet());
            LinkedList linkedList = new LinkedList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                linkedList.addAll(map.get((String) it.next()).line.keySet());
            }
            treeSet.addAll(linkedList);
            return Collections.unmodifiableSortedSet(treeSet);
        }

        public void add(int i, String str, String str2) {
            this.averageSentenceLength.add(i);
            if (this.minimalSentenceLength > i) {
                this.minimalSentenceLength = i;
            }
            if (this.maximumSentenceLength < i) {
                this.maximumSentenceLength = i;
            }
            updateTagFMeasure(new String[]{str}, new String[]{str2});
            commit("", str, str2);
        }

        public void add(String[] strArr, String str, String str2) {
            add(strArr.length, str, str2);
        }

        public void add(CharSequence charSequence, String str, String str2) {
            add(charSequence.length(), str, str2);
        }
    }

    public FineGrainedReportListener(PrintStream printStream) {
        this.printStream = printStream;
    }

    private static String generateAlphaLabel(int i) {
        char[] cArr = new char[3];
        for (int i2 = 2; i2 >= 0; i2--) {
            if (i >= 0) {
                char[] cArr2 = alpha;
                cArr[i2] = cArr2[i % cArr2.length];
                i = (i / cArr2.length) - 1;
            } else {
                cArr[i2] = ' ';
            }
        }
        return new String(cArr);
    }

    private double getAccuracy() {
        return this.stats.getAccuracy();
    }

    private double getAverageSentenceSize() {
        return this.stats.getAverageSentenceSize();
    }

    private double[][] getConfusionMatrix() {
        return this.stats.getConfusionMatrix();
    }

    private SortedSet<String> getConfusionMatrixTagset() {
        return this.stats.getConfusionMatrixTagset();
    }

    private int getMaxSentenceSize() {
        return this.stats.getMaxSentenceSize();
    }

    private int getMinSentenceSize() {
        return this.stats.getMinSentenceSize();
    }

    private long getNumberOfSentences() {
        return this.stats.getNumberOfSentences();
    }

    private int getNumberOfTags() {
        return this.stats.getNumberOfTags();
    }

    private int getTagErrors(String str) {
        return this.stats.getTagErrors(str);
    }

    private double getTagFMeasure(String str) {
        return this.stats.getTagFMeasure(str);
    }

    private int getTagFrequency(String str) {
        return this.stats.getTagFrequency(str);
    }

    private double getTagPrecision(String str) {
        return this.stats.getTagPrecision(str);
    }

    private double getTagRecall(String str) {
        return this.stats.getTagRecall(str);
    }

    private SortedSet<String> getTagsOrderedByErrors() {
        return this.stats.getTagsOrderedByErrors();
    }

    private double getTokenAccuracy(String str) {
        return this.stats.getTokenAccuracy(str);
    }

    private int getTokenErrors(String str) {
        return this.stats.getTokenErrors(str);
    }

    private int getTokenFrequency(String str) {
        return this.stats.getTokenFrequency(str);
    }

    private SortedSet<String> getTokensOrderedByFrequency() {
        return this.stats.getTokensOrderedByFrequency();
    }

    private SortedSet<String> getTokensOrderedByNumberOfErrors() {
        return this.stats.getTokensOrderedByNumberOfErrors();
    }

    private String matrixToString(SortedSet<String> sortedSet, double[][] dArr, boolean z) {
        double[] dArr2;
        String[] strArr = (String[]) sortedSet.toArray(new String[0]);
        StringBuilder sb = new StringBuilder();
        String[][] strArr2 = (String[][]) Array.newInstance((Class<?>) String.class, dArr.length, dArr[0].length);
        int length = Integer.MIN_VALUE;
        int i = 0;
        for (int i2 = 0; i2 < dArr.length; i2++) {
            int i4 = 0;
            while (true) {
                dArr2 = dArr[i2];
                if (i4 >= dArr2.length - 1) {
                    break;
                }
                String[] strArr3 = strArr2[i2];
                double d = dArr2[i4];
                strArr3[i4] = d > 0.0d ? Integer.toString((int) d) : Extension.DOT;
                if (length < strArr2[i2][i4].length()) {
                    length = strArr2[i2][i4].length();
                }
                i4++;
            }
            strArr2[i2][i4] = MessageFormat.format("{0,number,#.##%}", Double.valueOf(dArr2[i4]));
            if (dArr[i2][i4] == 1.0d && z) {
                i = i2 + 1;
            }
        }
        int i5 = length + 2;
        String strM767i = AbstractC0541b.m767i(i5, "%", "s ");
        String strM767i2 = AbstractC0541b.m767i(i5, "%", "s ");
        String strM767i3 = AbstractC0541b.m767i(i5, " %", "s");
        for (int i6 = i; i6 < sortedSet.size(); i6++) {
            sb.append(String.format(strM767i, generateAlphaLabel(i6 - i).trim()));
        }
        sb.append("| Accuracy | <-- classified as\n");
        for (int iM2213d = i; iM2213d < dArr.length; iM2213d = AbstractC2821a.m2213d(sb, iM2213d, 1, strArr[iM2213d], "\n")) {
            int i7 = i;
            while (i7 < dArr[iM2213d].length - 1) {
                if (iM2213d == i7) {
                    sb.append(String.format(strM767i3, AbstractC0541b.m773o("<", strArr2[iM2213d][i7], ">")));
                } else {
                    sb.append(String.format(strM767i2, strArr2[iM2213d][i7]));
                }
                i7++;
            }
            sb.append(String.format("|   %-6s |   %3s = ", strArr2[iM2213d][i7], generateAlphaLabel(iM2213d - i)));
        }
        return sb.toString();
    }

    private void printFooter(String str) {
        this.printStream.append((CharSequence) "\n<-end> ").append((CharSequence) str).append((CharSequence) MarkdownDocument.NEW_LINE);
    }

    private void printHeader(String str) {
        this.printStream.append((CharSequence) "=== ").append((CharSequence) str).append((CharSequence) " ===\n");
    }

    private void printLine(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.printStream.append((CharSequence) CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        }
        this.printStream.append((CharSequence) "\n");
    }

    public Comparator<String> getLabelComparator(Map<String, Counter> map) {
        return new SimpleLabelComparator(map);
    }

    public Comparator<String> getMatrixLabelComparator(Map<String, ConfusionMatrixLine> map) {
        return new MatrixLabelComparator(map);
    }

    public Stats getStats() {
        return this.stats;
    }

    public void printDetailedConfusionMatrix() {
        printHeader("Confusion matrix for tokens");
        this.printStream.append((CharSequence) "  sorted by number of errors\n");
        for (String str : getTokensOrderedByNumberOfErrors()) {
            double tokenAccuracy = getTokenAccuracy(str);
            if (tokenAccuracy < 1.0d) {
                this.printStream.append((CharSequence) "\n[").append((CharSequence) str).append((CharSequence) "]\n").append((CharSequence) String.format("%12s: %-8s", "Accuracy", MessageFormat.format("{0,number,#.##%}", Double.valueOf(tokenAccuracy)))).append((CharSequence) "\n");
                this.printStream.append((CharSequence) String.format("%12s: %-8s", "Ocurrencies", Integer.valueOf(getTokenFrequency(str)))).append((CharSequence) "\n");
                this.printStream.append((CharSequence) String.format("%12s: %-8s", "Errors", Integer.valueOf(getTokenErrors(str)))).append((CharSequence) "\n");
                this.printStream.append((CharSequence) matrixToString(getConfusionMatrixTagset(str), getConfusionMatrix(str), false));
            }
        }
        printFooter("Confusion matrix for tokens");
    }

    public void printGeneralConfusionTable() {
        printHeader("Confusion matrix");
        SortedSet<String> confusionMatrixTagset = getConfusionMatrixTagset();
        double[][] confusionMatrix = getConfusionMatrix();
        this.printStream.append((CharSequence) "\nTags with 100% accuracy: ");
        int i = 0;
        for (String str : confusionMatrixTagset) {
            if (confusionMatrix[i][confusionMatrix[0].length - 1] == 1.0d) {
                this.printStream.append((CharSequence) str).append((CharSequence) " (").append((CharSequence) Integer.toString((int) confusionMatrix[i][i])).append((CharSequence) ") ");
            }
            i++;
        }
        this.printStream.append((CharSequence) MarkdownDocument.NEW_LINE);
        this.printStream.append((CharSequence) matrixToString(confusionMatrixTagset, confusionMatrix, true));
        printFooter("Confusion matrix");
    }

    public void printGeneralStatistics() {
        printHeader("Evaluation summary");
        this.printStream.append((CharSequence) String.format("%21s: %6s", "Number of sentences", Long.valueOf(getNumberOfSentences()))).append((CharSequence) "\n");
        this.printStream.append((CharSequence) String.format("%21s: %6s", "Min sentence size", Integer.valueOf(getMinSentenceSize()))).append((CharSequence) "\n");
        this.printStream.append((CharSequence) String.format("%21s: %6s", "Max sentence size", Integer.valueOf(getMaxSentenceSize()))).append((CharSequence) "\n");
        this.printStream.append((CharSequence) String.format("%21s: %6s", "Average sentence size", MessageFormat.format("{0,number,#.##}", Double.valueOf(getAverageSentenceSize())))).append((CharSequence) "\n");
        this.printStream.append((CharSequence) String.format("%21s: %6s", "Tags count", Integer.valueOf(getNumberOfTags()))).append((CharSequence) "\n");
        this.printStream.append((CharSequence) String.format("%21s: %6s", "Accuracy", MessageFormat.format("{0,number,#.##%}", Double.valueOf(getAccuracy())))).append((CharSequence) "\n");
        printFooter("Evaluation Corpus Statistics");
    }

    public void printTagsErrorRank() {
        printHeader("Detailed Accuracy By Tag");
        SortedSet<String> tagsOrderedByErrors = getTagsOrderedByErrors();
        this.printStream.append((CharSequence) "\n");
        int length = 3;
        for (String str : tagsOrderedByErrors) {
            if (str.length() > length) {
                length = str.length();
            }
        }
        int i = length + 65;
        String strM767i = AbstractC0541b.m767i(length, "| %", "s | %6s | %6s | %7s | %9s | %6s | %9s |\n");
        String strM767i2 = AbstractC0541b.m767i(length, "| %", "s | %6s | %6s | %-7s | %-9s | %-6s | %-9s |\n");
        printLine(i);
        this.printStream.append((CharSequence) String.format(strM767i, FolderConstants.Tag.DISPLAY_NAME, "Errors", "Count", "% Err", "Precision", "Recall", "F-Measure"));
        printLine(i);
        for (String str2 : tagsOrderedByErrors) {
            int tagFrequency = getTagFrequency(str2);
            int tagErrors = getTagErrors(str2);
            String str3 = MessageFormat.format("{0,number,#.###}", Double.valueOf(((double) tagErrors) / ((double) tagFrequency)));
            double tagPrecision = getTagPrecision(str2);
            double tagRecall = getTagRecall(str2);
            double tagFMeasure = getTagFMeasure(str2);
            PrintStream printStream = this.printStream;
            Integer numValueOf = Integer.valueOf(tagErrors);
            Integer numValueOf2 = Integer.valueOf(tagFrequency);
            if (tagPrecision <= 0.0d) {
                tagPrecision = 0.0d;
            }
            String str4 = MessageFormat.format("{0,number,#.###}", Double.valueOf(tagPrecision));
            if (tagRecall <= 0.0d) {
                tagRecall = 0.0d;
            }
            String str5 = MessageFormat.format("{0,number,#.###}", Double.valueOf(tagRecall));
            if (tagFMeasure <= 0.0d) {
                tagFMeasure = 0.0d;
            }
            printStream.append((CharSequence) String.format(strM767i2, str2, numValueOf, numValueOf2, str3, str4, str5, MessageFormat.format("{0,number,#.###}", Double.valueOf(tagFMeasure))));
        }
        printLine(i);
        printFooter("Tags with the highest number of errors");
    }

    public void printTokenErrorRank() {
        printHeader("Tokens with the highest number of errors");
        this.printStream.append((CharSequence) "\n");
        SortedSet<String> tokensOrderedByNumberOfErrors = getTokensOrderedByNumberOfErrors();
        int length = 5;
        int i = 0;
        int i2 = 0;
        for (String str : tokensOrderedByNumberOfErrors) {
            int i4 = i2 + 1;
            if (i2 >= 20) {
                break;
            }
            if (str.length() > length) {
                length = str.length();
            }
            i2 = i4;
        }
        int i5 = length + 31;
        String strM767i = AbstractC0541b.m767i(length, "| %", "s | %6s | %5s | %7s |\n");
        printLine(i5);
        this.printStream.append((CharSequence) String.format(strM767i, "Token", "Errors", "Count", "% Err"));
        printLine(i5);
        for (String str2 : tokensOrderedByNumberOfErrors) {
            int i6 = i + 1;
            if (i >= 20) {
                break;
            }
            int tokenFrequency = getTokenFrequency(str2);
            int tokenErrors = getTokenErrors(str2);
            this.printStream.append((CharSequence) String.format(strM767i, str2, Integer.valueOf(tokenErrors), Integer.valueOf(tokenFrequency), MessageFormat.format("{0,number,#.##%}", Double.valueOf(((double) tokenErrors) / ((double) tokenFrequency)))));
            i = i6;
        }
        printLine(i5);
        printFooter("Tokens with the highest number of errors");
    }

    public void printTokenOccurrencesRank() {
        printHeader("Most frequent tokens");
        SortedSet<String> tokensOrderedByFrequency = getTokensOrderedByFrequency();
        int length = 5;
        int i = 0;
        int i2 = 0;
        for (String str : tokensOrderedByFrequency) {
            int i4 = i2 + 1;
            if (i2 >= 20) {
                break;
            }
            if (str.length() > length) {
                length = str.length();
            }
            i2 = i4;
        }
        int i5 = length + 19;
        String strM767i = AbstractC0541b.m767i(length, "| %3s | %6s | %", "s |");
        printLine(i5);
        this.printStream.append((CharSequence) String.format(strM767i, "Pos", "Count", "Token")).append((CharSequence) "\n");
        printLine(i5);
        for (String str2 : tokensOrderedByFrequency) {
            int i6 = i + 1;
            if (i >= 20) {
                break;
            }
            this.printStream.append((CharSequence) String.format(strM767i, Integer.valueOf(i6), Integer.valueOf(getTokenFrequency(str2)), str2)).append((CharSequence) "\n");
            i = i6;
        }
        printLine(i5);
        printFooter("Most frequent tokens");
    }

    public abstract void writeReport();

    private double[][] getConfusionMatrix(String str) {
        return this.stats.getConfusionMatrix(str);
    }

    private SortedSet<String> getConfusionMatrixTagset(String str) {
        return this.stats.getConfusionMatrixTagset(str);
    }

    public FineGrainedReportListener(OutputStream outputStream) {
        this.printStream = new PrintStream(outputStream);
    }
}
