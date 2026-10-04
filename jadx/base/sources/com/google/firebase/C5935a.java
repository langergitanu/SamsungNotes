package com.google.firebase;

import android.content.Context;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.inject.Provider;

/* JADX INFO: renamed from: com.google.firebase.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5935a implements Provider {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3454a = 1;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Context f3455b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f3456c;

    public /* synthetic */ C5935a(Context context, String str) {
        this.f3455b = context;
        this.f3456c = str;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.f3454a) {
            case 0:
                return ((FirebaseApp) this.f3456c).lambda$new$0(this.f3455b);
            default:
                return DefaultHeartBeatController.lambda$new$2(this.f3455b, (String) this.f3456c);
        }
    }

    public /* synthetic */ C5935a(FirebaseApp firebaseApp, Context context) {
        this.f3456c = firebaseApp;
        this.f3455b = context;
    }
}
