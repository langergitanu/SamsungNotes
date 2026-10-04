package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0004"}, m13886d2 = {"binarySearch", "", "", "value", "runtime_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SnapshotIdSetKt {
    public static final int binarySearch(@NotNull int[] iArr, int i) {
        int length = iArr.length - 1;
        int i2 = 0;
        while (i2 <= length) {
            int i4 = (i2 + length) >>> 1;
            int i5 = iArr[i4];
            if (i > i5) {
                i2 = i4 + 1;
            } else {
                if (i >= i5) {
                    return i4;
                }
                length = i4 - 1;
            }
        }
        return -(i2 + 1);
    }
}
