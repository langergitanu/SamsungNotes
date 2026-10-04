package androidx.appsearch.platformstorage.converter;

import android.graphics.text.LineBreakConfig;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.inputmethod.EditorBoundsInfo;

/* JADX INFO: renamed from: androidx.appsearch.platformstorage.converter.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0564a {
    /* JADX INFO: renamed from: c */
    public static /* synthetic */ LineBreakConfig.Builder m899c() {
        return new LineBreakConfig.Builder();
    }

    /* JADX INFO: renamed from: h */
    public static /* synthetic */ BoringLayout m904h(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f4, BoringLayout.Metrics metrics, boolean z, boolean z2, TextUtils.TruncateAt truncateAt, int i2) {
        return new BoringLayout(charSequence, textPaint, i, alignment, f, f4, metrics, z, truncateAt, i2, z2);
    }

    /* JADX INFO: renamed from: j */
    public static /* synthetic */ EditorBoundsInfo.Builder m906j() {
        return new EditorBoundsInfo.Builder();
    }
}
