package opennlp.tools.util.eval;

import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class FMeasure {
    private long selected;
    private long target;
    private long truePositive;

    public static int countTruePositives(Object[] objArr, Object[] objArr2) {
        ArrayList arrayList = new ArrayList(objArr2.length);
        Collections.addAll(arrayList, objArr2);
        Object obj = null;
        int i = 0;
        for (Object obj2 : objArr) {
            for (Object obj3 : arrayList) {
                if (obj2.equals(obj3)) {
                    i++;
                    obj = obj3;
                }
            }
            if (obj != null) {
                arrayList.remove(obj);
            }
        }
        return i;
    }

    public static double precision(Object[] objArr, Object[] objArr2) {
        if (objArr2.length > 0) {
            return ((double) countTruePositives(objArr, objArr2)) / ((double) objArr2.length);
        }
        return Double.NaN;
    }

    public static double recall(Object[] objArr, Object[] objArr2) {
        if (objArr.length > 0) {
            return ((double) countTruePositives(objArr, objArr2)) / ((double) objArr.length);
        }
        return Double.NaN;
    }

    public double getFMeasure() {
        if (getRecallScore() + getPrecisionScore() <= 0.0d) {
            return -1.0d;
        }
        return ((getRecallScore() * getPrecisionScore()) * 2.0d) / (getRecallScore() + getPrecisionScore());
    }

    public double getPrecisionScore() {
        long j = this.selected;
        if (j > 0) {
            return this.truePositive / j;
        }
        return 0.0d;
    }

    public double getRecallScore() {
        long j = this.target;
        if (j > 0) {
            return this.truePositive / j;
        }
        return 0.0d;
    }

    public void mergeInto(FMeasure fMeasure) {
        this.selected += fMeasure.selected;
        this.target += fMeasure.target;
        this.truePositive += fMeasure.truePositive;
    }

    public String toString() {
        return "Precision: " + getPrecisionScore() + "\nRecall: " + getRecallScore() + "\nF-Measure: " + getFMeasure();
    }

    public void updateScores(Object[] objArr, Object[] objArr2) {
        this.truePositive += (long) countTruePositives(objArr, objArr2);
        this.selected += (long) objArr2.length;
        this.target += (long) objArr.length;
    }
}
