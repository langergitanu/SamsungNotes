package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¨\u0006\u0006"}, m13886d2 = {"calculateCellsCrossAxisSizeImpl", "", "gridSize", "", "slotCount", "spacing", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class LazyStaggeredGridCellsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int[] calculateCellsCrossAxisSizeImpl(int i, int i2, int i4) {
        int i5;
        int i6 = i - ((i2 - 1) * i4);
        int i7 = i6 / i2;
        int i8 = i6 % i2;
        int[] iArr = new int[i2];
        int i9 = 0;
        while (i9 < i2) {
            if (i7 < 0) {
                i5 = 0;
            } else {
                i5 = (i9 < i8 ? 1 : 0) + i7;
            }
            iArr[i9] = i5;
            i9++;
        }
        return iArr;
    }
}
