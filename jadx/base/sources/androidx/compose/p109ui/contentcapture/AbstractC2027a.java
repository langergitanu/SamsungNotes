package androidx.compose.p109ui.contentcapture;

import android.graphics.Point;
import android.graphics.Rect;
import android.location.LocationRequest;
import android.p108os.OutcomeReceiver;
import android.view.ContentInfo;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import android.view.ScrollCaptureTarget;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.translation.ViewTranslationCallback;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;

/* JADX INFO: renamed from: androidx.compose.ui.contentcapture.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC2027a {
    /* JADX INFO: renamed from: g */
    public static /* bridge */ /* synthetic */ LocationRequest m1350g(Object obj) {
        return (LocationRequest) obj;
    }

    /* JADX INFO: renamed from: h */
    public static /* bridge */ /* synthetic */ OutcomeReceiver m1351h(Object obj) {
        return (OutcomeReceiver) obj;
    }

    /* JADX INFO: renamed from: i */
    public static /* bridge */ /* synthetic */ ContentInfo m1352i(Object obj) {
        return (ContentInfo) obj;
    }

    /* JADX INFO: renamed from: j */
    public static /* bridge */ /* synthetic */ ScrollCaptureSession m1353j(Object obj) {
        return (ScrollCaptureSession) obj;
    }

    /* JADX INFO: renamed from: k */
    public static /* synthetic */ ScrollCaptureTarget m1354k(View view, Rect rect, Point point, ScrollCaptureCallback scrollCaptureCallback) {
        return new ScrollCaptureTarget(view, rect, point, scrollCaptureCallback);
    }

    /* JADX INFO: renamed from: o */
    public static /* bridge */ /* synthetic */ ViewTranslationCallback m1358o(Object obj) {
        return (ViewTranslationCallback) obj;
    }

    /* JADX INFO: renamed from: p */
    public static /* synthetic */ ViewTranslationRequest.Builder m1359p(AutofillId autofillId, long j) {
        return new ViewTranslationRequest.Builder(autofillId, j);
    }

    /* JADX INFO: renamed from: r */
    public static /* bridge */ /* synthetic */ ViewTranslationResponse m1361r(Object obj) {
        return (ViewTranslationResponse) obj;
    }

    /* JADX INFO: renamed from: t */
    public static /* synthetic */ void m1363t() {
    }
}
