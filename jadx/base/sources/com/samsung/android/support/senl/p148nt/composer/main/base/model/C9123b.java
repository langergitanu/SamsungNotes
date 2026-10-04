package com.samsung.android.support.senl.p148nt.composer.main.base.model;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.DocContract;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.model.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9123b implements DocContract.SavedListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Runnable f6770a;

    public /* synthetic */ C9123b(Runnable runnable) {
        this.f6770a = runnable;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.data.DocContract.SavedListener
    public final void onSuccess() {
        this.f6770a.run();
    }
}
