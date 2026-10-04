package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import android.content.Context;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sesdb.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6690d extends AbstractC6688b {

    /* JADX INFO: renamed from: f */
    public final String f3996f;

    public C6690d(Context context, String str) {
        super(context, SesCoeditGroupReadResolver.getInstance().getMemberContentUri(), true);
        this.f3996f = str;
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.AbstractC6688b
    /* JADX INFO: renamed from: a */
    public final Object mo4781a() {
        return SesCoeditGroupReadResolver.getInstance().getMemberInfoList(this.f3996f);
    }
}
