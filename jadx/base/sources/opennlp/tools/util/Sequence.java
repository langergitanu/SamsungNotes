package opennlp.tools.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Sequence implements Comparable<Sequence> {
    private static final Double ONE = Double.valueOf(1.0d);
    private final List<String> outcomes;
    private final List<Double> probs;
    private double score;

    public Sequence() {
        this.outcomes = new ArrayList(1);
        this.probs = new ArrayList(1);
        this.score = 0.0d;
    }

    public void add(String str, double d) {
        this.outcomes.add(str);
        this.probs.add(Double.valueOf(d));
        this.score = StrictMath.log(d) + this.score;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Sequence) {
            Sequence sequence = (Sequence) obj;
            if (Objects.equals(this.outcomes, sequence.outcomes) && Objects.equals(this.probs, sequence.probs) && StrictMath.abs(this.score - sequence.score) < 1.0E-7d) {
                return true;
            }
        }
        return false;
    }

    public String getOutcome(int i) {
        return this.outcomes.get(i);
    }

    public List<String> getOutcomes() {
        List<String> list = this.outcomes;
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            Objects.requireNonNull(str);
            arrayList.add(str);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public double getProb(int i) {
        return this.probs.get(i).doubleValue();
    }

    public double[] getProbs() {
        double[] dArr = new double[this.probs.size()];
        getProbs(dArr);
        return dArr;
    }

    public double getScore() {
        return this.score;
    }

    public int getSize() {
        return this.outcomes.size();
    }

    public int hashCode() {
        return Objects.hash(this.outcomes, this.probs, Double.valueOf(this.score));
    }

    public String toString() {
        return this.score + " " + this.outcomes;
    }

    @Override // java.lang.Comparable
    public int compareTo(Sequence sequence) {
        return Double.compare(sequence.score, this.score);
    }

    public void getProbs(double[] dArr) {
        int size = this.probs.size();
        for (int i = 0; i < size; i++) {
            dArr[i] = this.probs.get(i).doubleValue();
        }
    }

    public Sequence(Sequence sequence) {
        ArrayList arrayList = new ArrayList(sequence.outcomes.size() + 1);
        this.outcomes = arrayList;
        arrayList.addAll(sequence.outcomes);
        ArrayList arrayList2 = new ArrayList(sequence.probs.size() + 1);
        this.probs = arrayList2;
        arrayList2.addAll(sequence.probs);
        this.score = sequence.score;
    }

    public Sequence(Sequence sequence, String str, double d) {
        ArrayList arrayList = new ArrayList(sequence.outcomes.size() + 1);
        this.outcomes = arrayList;
        arrayList.addAll(sequence.outcomes);
        arrayList.add(str);
        ArrayList arrayList2 = new ArrayList(sequence.probs.size() + 1);
        this.probs = arrayList2;
        arrayList2.addAll(sequence.probs);
        arrayList2.add(Double.valueOf(d));
        this.score = StrictMath.log(d) + sequence.score;
    }

    public Sequence(List<String> list) {
        this.outcomes = list;
        this.probs = Collections.nCopies(list.size(), ONE);
    }
}
