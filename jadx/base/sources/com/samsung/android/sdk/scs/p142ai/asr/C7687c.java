package com.samsung.android.sdk.scs.p142ai.asr;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import com.samsung.android.sdk.scs.p142ai.asr_6_0.Environment;
import java.util.function.Function;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7687c implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5129a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Uri f5130b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f5131c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ String f5132d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Bundle f5133e;

    public /* synthetic */ C7687c(Uri uri, String str, String str2, Bundle bundle, int i) {
        this.f5129a = i;
        this.f5130b = uri;
        this.f5131c = str;
        this.f5132d = str2;
        this.f5133e = bundle;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f5129a) {
            case 0:
                return Environment.lambda$callContentProvider$25(this.f5130b, this.f5131c, this.f5132d, this.f5133e, (ContentResolver) obj);
            default:
                return Environment.lambda$callContentProvider$21(this.f5130b, this.f5131c, this.f5132d, this.f5133e, (ContentResolver) obj);
        }
    }
}
