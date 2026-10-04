package com.samsung.android.support.senl.p148nt.app.labs;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import java.net.HttpURLConnection;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.labs.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class CallableC8098c implements Callable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6115a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f6116b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f6117c;

    public /* synthetic */ CallableC8098c(int i, Activity activity) {
        this.f6116b = i;
        this.f6117c = activity;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f6115a) {
            case 0:
                return DocumentTest.lambda$createDummy$2(this.f6116b, (Activity) this.f6117c);
            default:
                return UriFileUtils.getInputStreamFromHttpConn$lambda$4((HttpURLConnection) this.f6117c, this.f6116b);
        }
    }

    public /* synthetic */ CallableC8098c(int i, HttpURLConnection httpURLConnection) {
        this.f6117c = httpURLConnection;
        this.f6116b = i;
    }
}
