package androidx.core.view;

import android.content.ClipData;
import android.util.ArrayMap;
import android.view.ContentInfo;
import android.widget.RemoteViews;

/* JADX INFO: renamed from: androidx.core.view.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC2448b {
    /* JADX INFO: renamed from: i */
    public static /* synthetic */ ContentInfo.Builder m1842i(ClipData clipData, int i) {
        return new ContentInfo.Builder(clipData, i);
    }

    /* JADX INFO: renamed from: j */
    public static /* synthetic */ ContentInfo.Builder m1843j(ContentInfo contentInfo) {
        return new ContentInfo.Builder(contentInfo);
    }

    /* JADX INFO: renamed from: m */
    public static /* synthetic */ RemoteViews m1846m(ArrayMap arrayMap) {
        return new RemoteViews(arrayMap);
    }

    /* JADX INFO: renamed from: o */
    public static /* synthetic */ void m1848o() {
    }
}
