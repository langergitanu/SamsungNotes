package opennlp.tools.p217ml.model;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ComparablePredicate implements Comparable<ComparablePredicate> {
    public final String name;
    public final int[] outcomes;
    public final double[] params;

    public ComparablePredicate(String str, int[] iArr, double[] dArr) {
        this.name = str;
        this.outcomes = iArr;
        this.params = dArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ComparablePredicate) {
            ComparablePredicate comparablePredicate = (ComparablePredicate) obj;
            if (Objects.equals(this.name, comparablePredicate.name) && Arrays.equals(this.outcomes, comparablePredicate.outcomes) && Arrays.equals(this.params, comparablePredicate.params)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.name, Integer.valueOf(Arrays.hashCode(this.outcomes)), Integer.valueOf(Arrays.hashCode(this.params)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : this.outcomes) {
            sb.append(" ");
            sb.append(i);
        }
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(ComparablePredicate comparablePredicate) {
        int iMin = StrictMath.min(this.outcomes.length, comparablePredicate.outcomes.length);
        for (int i = 0; i < iMin; i++) {
            int iCompare = Integer.compare(this.outcomes[i], comparablePredicate.outcomes[i]);
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(this.outcomes.length, comparablePredicate.outcomes.length);
    }
}
