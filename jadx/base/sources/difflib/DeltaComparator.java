package difflib;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DeltaComparator implements Comparator<Delta>, Serializable {
    public static final Comparator<Delta> INSTANCE = new DeltaComparator();
    private static final long serialVersionUID = 1;

    private DeltaComparator() {
    }

    @Override // java.util.Comparator
    public int compare(Delta delta, Delta delta2) {
        int position = delta.getOriginal().getPosition();
        int position2 = delta2.getOriginal().getPosition();
        if (position > position2) {
            return 1;
        }
        return position < position2 ? -1 : 0;
    }
}
