package androidx.compose.p109ui.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;

/* JADX INFO: renamed from: androidx.compose.ui.graphics.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC2050b {
    /* JADX INFO: renamed from: e */
    public static /* synthetic */ BlendModeColorFilter m1414e(int i, BlendMode blendMode) {
        return new BlendModeColorFilter(i, blendMode);
    }

    /* JADX INFO: renamed from: f */
    public static /* bridge */ /* synthetic */ BlendModeColorFilter m1415f(ColorFilter colorFilter) {
        return (BlendModeColorFilter) colorFilter;
    }

    /* JADX INFO: renamed from: g */
    public static /* synthetic */ void m1416g() {
    }

    /* JADX INFO: renamed from: j */
    public static /* bridge */ /* synthetic */ boolean m1419j(ColorFilter colorFilter) {
        return colorFilter instanceof BlendModeColorFilter;
    }
}
