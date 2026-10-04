package com.samsung.android.support.senl.p148nt.coedit.control;

import android.app.Activity;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.coedit.control.common.CoeditControlCallback;
import com.samsung.android.support.senl.p148nt.coedit.control.common.ExternalControlCallback;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.coedit.control.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9051g implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6635a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CoeditHandlerManager.CoeditTask f6636b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ SpenWNote f6637c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ String f6638d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ String f6639e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f6640f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Object f6641g;

    public /* synthetic */ RunnableC9051g(CoeditHandlerManager.CoeditTask coeditTask, Activity activity, SpenWNote spenWNote, String str, String str2, CoeditControlCallback coeditControlCallback) {
        this.f6635a = 3;
        this.f6636b = coeditTask;
        this.f6640f = activity;
        this.f6637c = spenWNote;
        this.f6638d = str;
        this.f6639e = str2;
        this.f6641g = coeditControlCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6635a) {
            case 0:
                this.f6636b.lambda$externalSnapStart$7(this.f6637c, this.f6638d, this.f6639e, (String) this.f6640f, (ExternalControlCallback) this.f6641g);
                break;
            case 1:
                this.f6636b.lambda$externalSnapDownload$9(this.f6637c, this.f6638d, this.f6639e, (String) this.f6640f, (ExternalControlCallback) this.f6641g);
                break;
            case 2:
                this.f6636b.lambda$externalSnapUpload$8(this.f6637c, this.f6638d, this.f6639e, (String) this.f6640f, (ExternalControlCallback) this.f6641g);
                break;
            default:
                this.f6636b.lambda$internalChannelOpen$3((Activity) this.f6640f, this.f6637c, this.f6638d, this.f6639e, (CoeditControlCallback) this.f6641g);
                break;
        }
    }

    public /* synthetic */ RunnableC9051g(CoeditHandlerManager.CoeditTask coeditTask, SpenWNote spenWNote, String str, String str2, String str3, ExternalControlCallback externalControlCallback, int i) {
        this.f6635a = i;
        this.f6636b = coeditTask;
        this.f6637c = spenWNote;
        this.f6638d = str;
        this.f6639e = str2;
        this.f6640f = str3;
        this.f6641g = externalControlCallback;
    }
}
