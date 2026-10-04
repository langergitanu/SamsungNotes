package androidx.compose.foundation.text.input.internal;

import android.text.GraphemeClusterSegmentFinder;
import android.text.SegmentFinder;
import android.text.TextPaint;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.SelectGesture;

/* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1347e {
    /* JADX INFO: renamed from: A */
    public static /* bridge */ /* synthetic */ boolean m1265A(Object obj) {
        return obj instanceof SelectGesture;
    }

    /* JADX INFO: renamed from: o */
    public static /* synthetic */ GraphemeClusterSegmentFinder m1283o(CharSequence charSequence, TextPaint textPaint) {
        return new GraphemeClusterSegmentFinder(charSequence, textPaint);
    }

    /* JADX INFO: renamed from: p */
    public static /* bridge */ /* synthetic */ SegmentFinder m1284p(Object obj) {
        return (SegmentFinder) obj;
    }

    /* JADX INFO: renamed from: q */
    public static /* bridge */ /* synthetic */ HandwritingGesture m1285q(Object obj) {
        return (HandwritingGesture) obj;
    }

    /* JADX INFO: renamed from: r */
    public static /* bridge */ /* synthetic */ SelectGesture m1286r(Object obj) {
        return (SelectGesture) obj;
    }

    /* JADX INFO: renamed from: u */
    public static /* synthetic */ void m1289u() {
    }
}
