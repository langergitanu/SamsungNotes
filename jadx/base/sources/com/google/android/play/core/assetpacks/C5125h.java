package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnFailureListener;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.h */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class C5125h implements OnFailureListener {

    /* JADX INFO: renamed from: a */
    static final OnFailureListener f2877a = new C5125h();

    private C5125h() {
    }

    @Override // com.google.android.play.core.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        C5127j.f2880a.m3879d(String.format("Could not sync active asset packs. %s", exc), new Object[0]);
    }
}
