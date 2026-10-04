package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class GravityCompat {
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    private GravityCompat() {
    }

    public static void apply(int i, int i2, int i4, Rect rect, Rect rect2, int i5) {
        Gravity.apply(i, i2, i4, rect, rect2, i5);
    }

    public static void applyDisplay(int i, Rect rect, Rect rect2, int i2) {
        Gravity.applyDisplay(i, rect, rect2, i2);
    }

    public static int getAbsoluteGravity(int i, int i2) {
        return Gravity.getAbsoluteGravity(i, i2);
    }

    public static void apply(int i, int i2, int i4, Rect rect, int i5, int i6, Rect rect2, int i7) {
        Gravity.apply(i, i2, i4, rect, i5, i6, rect2, i7);
    }
}
