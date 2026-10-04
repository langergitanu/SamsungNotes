package androidx.compose.p109ui.platform;

import android.util.ArrayMap;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.contentcapture.ContentCaptureSession;

/* JADX INFO: renamed from: androidx.compose.ui.platform.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC2210j {
    /* JADX INFO: renamed from: d */
    public static /* synthetic */ WindowInsets.Builder m1566d() {
        return new WindowInsets.Builder();
    }

    /* JADX INFO: renamed from: e */
    public static /* synthetic */ WindowInsets.Builder m1567e(WindowInsets windowInsets) {
        return new WindowInsets.Builder(windowInsets);
    }

    /* JADX INFO: renamed from: g */
    public static /* synthetic */ AccessibilityNodeInfo.TouchDelegateInfo m1569g(ArrayMap arrayMap) {
        return new AccessibilityNodeInfo.TouchDelegateInfo(arrayMap);
    }

    /* JADX INFO: renamed from: h */
    public static /* bridge */ /* synthetic */ ContentCaptureSession m1570h(Object obj) {
        return (ContentCaptureSession) obj;
    }
}
