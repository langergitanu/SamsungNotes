package com.google.android.play.core.assetpacks;

import android.content.ComponentName;
import android.content.Context;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.internal.C5195bq;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.q */
/* JADX INFO: loaded from: classes5.dex */
public final class C5135q implements InterfaceC5219cn<AssetPackManager> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<C5127j> f2905a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5219cn<Context> f2906b;

    public C5135q(InterfaceC5219cn<C5127j> interfaceC5219cn, InterfaceC5219cn<Context> interfaceC5219cn2) {
        this.f2905a = interfaceC5219cn;
        this.f2906b = interfaceC5219cn2;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ AssetPackManager mo3591a() {
        C5127j c5127jMo3591a = this.f2905a.mo3591a();
        Context contextMo3591a = ((C5137s) this.f2906b).mo3591a();
        C5127j c5127j = c5127jMo3591a;
        C5195bq.m3942a(contextMo3591a.getPackageManager(), new ComponentName(contextMo3591a.getPackageName(), "com.google.android.play.core.assetpacks.AssetPackExtractionService"), 4);
        PlayCoreDialogWrapperActivity.m3854a(contextMo3591a);
        C5195bq.m3949b(c5127j);
        return c5127j;
    }
}
