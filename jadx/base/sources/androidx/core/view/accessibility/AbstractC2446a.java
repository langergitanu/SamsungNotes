package androidx.core.view.accessibility;

import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.app.slice.SliceSpec;
import android.net.Uri;

/* JADX INFO: renamed from: androidx.core.view.accessibility.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC2446a {
    /* JADX INFO: renamed from: b */
    public static /* synthetic */ Slice.Builder m1801b(Slice.Builder builder) {
        return new Slice.Builder(builder);
    }

    /* JADX INFO: renamed from: f */
    public static /* synthetic */ Slice.Builder m1805f(SliceSpec sliceSpec) {
        return new Slice.Builder(Uri.EMPTY, sliceSpec);
    }

    /* JADX INFO: renamed from: h */
    public static /* bridge */ /* synthetic */ SliceItem m1807h(Object obj) {
        return (SliceItem) obj;
    }

    /* JADX INFO: renamed from: i */
    public static /* synthetic */ SliceSpec m1808i() {
        return new SliceSpec("Action", 0);
    }

    /* JADX INFO: renamed from: n */
    public static /* synthetic */ void m1813n() {
    }

    /* JADX INFO: renamed from: w */
    public static /* synthetic */ void m1822w() {
    }
}
