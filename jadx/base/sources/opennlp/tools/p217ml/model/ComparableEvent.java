package opennlp.tools.p217ml.model;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ComparableEvent implements Comparable<ComparableEvent> {
    public final int outcome;
    public final int[] predIndexes;
    public int seen;
    public final float[] values;

    public ComparableEvent(int i, int[] iArr, float[] fArr) {
        this.seen = 1;
        this.outcome = i;
        this.values = fArr;
        this.predIndexes = iArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ComparableEvent) {
            ComparableEvent comparableEvent = (ComparableEvent) obj;
            if (this.outcome == comparableEvent.outcome && Arrays.equals(this.predIndexes, comparableEvent.predIndexes) && this.seen == comparableEvent.seen && Arrays.equals(this.values, comparableEvent.values)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.outcome), Integer.valueOf(Arrays.hashCode(this.predIndexes)), Integer.valueOf(this.seen), Integer.valueOf(Arrays.hashCode(this.values)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.outcome);
        sb.append(":");
        for (int i = 0; i < this.predIndexes.length; i++) {
            sb.append(" ");
            sb.append(this.predIndexes[i]);
            if (this.values != null) {
                sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                sb.append(this.values[i]);
            }
        }
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(ComparableEvent comparableEvent) {
        float[] fArr;
        Float fValueOf = Float.valueOf(0.0f);
        int iCompare = Integer.compare(this.outcome, comparableEvent.outcome);
        if (iCompare != 0) {
            return iCompare;
        }
        int iMin = StrictMath.min(this.predIndexes.length, comparableEvent.predIndexes.length);
        for (int i = 0; i < iMin; i++) {
            int iCompare2 = Integer.compare(this.predIndexes[i], comparableEvent.predIndexes[i]);
            if (iCompare2 != 0) {
                return iCompare2;
            }
            float[] fArr2 = this.values;
            if (fArr2 != null && (fArr = comparableEvent.values) != null) {
                float fCompare = Float.compare(fArr2[i], fArr[i]);
                if (!Float.valueOf(fCompare).equals(fValueOf)) {
                    return (int) fCompare;
                }
            } else if (fArr2 != null) {
                float fCompare2 = Float.compare(fArr2[i], 1.0f);
                if (!Float.valueOf(fCompare2).equals(fValueOf)) {
                    return (int) fCompare2;
                }
            } else {
                float[] fArr3 = comparableEvent.values;
                if (fArr3 != null) {
                    float fCompare3 = Float.compare(1.0f, fArr3[i]);
                    if (!Float.valueOf(fCompare3).equals(fValueOf)) {
                        return (int) fCompare3;
                    }
                } else {
                    continue;
                }
            }
        }
        return Integer.compare(this.predIndexes.length, comparableEvent.predIndexes.length);
    }

    public ComparableEvent(int i, int[] iArr) {
        this(i, iArr, null);
    }
}
