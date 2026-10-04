package androidx.core.graphics;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class Insets {

    @NonNull
    public static final Insets NONE = new Insets(0, 0, 0, 0);
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        /* JADX INFO: renamed from: of */
        public static android.graphics.Insets m1694of(int i, int i2, int i4, int i5) {
            return android.graphics.Insets.of(i, i2, i4, i5);
        }
    }

    private Insets(int i, int i2, int i4, int i5) {
        this.left = i;
        this.top = i2;
        this.right = i4;
        this.bottom = i5;
    }

    @NonNull
    public static Insets add(@NonNull Insets insets, @NonNull Insets insets2) {
        return m1692of(insets.left + insets2.left, insets.top + insets2.top, insets.right + insets2.right, insets.bottom + insets2.bottom);
    }

    @NonNull
    public static Insets max(@NonNull Insets insets, @NonNull Insets insets2) {
        return m1692of(Math.max(insets.left, insets2.left), Math.max(insets.top, insets2.top), Math.max(insets.right, insets2.right), Math.max(insets.bottom, insets2.bottom));
    }

    @NonNull
    public static Insets min(@NonNull Insets insets, @NonNull Insets insets2) {
        return m1692of(Math.min(insets.left, insets2.left), Math.min(insets.top, insets2.top), Math.min(insets.right, insets2.right), Math.min(insets.bottom, insets2.bottom));
    }

    @NonNull
    /* JADX INFO: renamed from: of */
    public static Insets m1692of(int i, int i2, int i4, int i5) {
        return (i == 0 && i2 == 0 && i4 == 0 && i5 == 0) ? NONE : new Insets(i, i2, i4, i5);
    }

    @NonNull
    public static Insets subtract(@NonNull Insets insets, @NonNull Insets insets2) {
        return m1692of(insets.left - insets2.left, insets.top - insets2.top, insets.right - insets2.right, insets.bottom - insets2.bottom);
    }

    @NonNull
    @RequiresApi(api = 29)
    public static Insets toCompatInsets(@NonNull android.graphics.Insets insets) {
        return m1692of(insets.left, insets.top, insets.right, insets.bottom);
    }

    @NonNull
    @Deprecated
    @RequiresApi(api = 29)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Insets wrap(@NonNull android.graphics.Insets insets) {
        return toCompatInsets(insets);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Insets.class != obj.getClass()) {
            return false;
        }
        Insets insets = (Insets) obj;
        return this.bottom == insets.bottom && this.left == insets.left && this.right == insets.right && this.top == insets.top;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    @NonNull
    @RequiresApi(29)
    public android.graphics.Insets toPlatformInsets() {
        return Api29Impl.m1694of(this.left, this.top, this.right, this.bottom);
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("Insets{left=");
        sb.append(this.left);
        sb.append(", top=");
        sb.append(this.top);
        sb.append(", right=");
        sb.append(this.right);
        sb.append(", bottom=");
        return AbstractC0000a.m13j(sb, this.bottom, '}');
    }

    @NonNull
    /* JADX INFO: renamed from: of */
    public static Insets m1693of(@NonNull Rect rect) {
        return m1692of(rect.left, rect.top, rect.right, rect.bottom);
    }
}
