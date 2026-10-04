package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.C5195bq;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.s */
/* JADX INFO: loaded from: classes5.dex */
public final class C5137s implements InterfaceC5219cn<Context> {

    /* JADX INFO: renamed from: a */
    private final C5132n f2910a;

    public C5137s(C5132n c5132n) {
        this.f2910a = c5132n;
    }

    /* JADX INFO: renamed from: a */
    public static Context m3850a(C5132n c5132n) {
        Context contextM3847a = c5132n.m3847a();
        C5195bq.m3949b(contextM3847a);
        return contextM3847a;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Context mo3591a() {
        return m3850a(this.f2910a);
    }
}
