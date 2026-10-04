package com.samsung.android.app.notes.sync.saccount.samsungaccountclient.service;

import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.AbstractC6884k;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.service.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6886a extends AbstractC6884k {
    @Override // com.samsung.android.app.notes.sync.saccount.samsungaccountclient.AbstractC6884k
    /* JADX INFO: renamed from: a */
    public final String mo5081a() {
        return "ConnectedState";
    }

    @Override // com.samsung.android.app.notes.sync.saccount.samsungaccountclient.AbstractC6884k
    /* JADX INFO: renamed from: b */
    public final boolean mo5082b() {
        Debugger.m8615i("ConnectedState", "[SA] connect() : already connected");
        return true;
    }

    public final String toString() {
        return "ConnectedState";
    }
}
