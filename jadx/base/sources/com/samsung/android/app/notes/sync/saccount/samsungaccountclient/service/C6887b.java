package com.samsung.android.app.notes.sync.saccount.samsungaccountclient.service;

import android.util.Log;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.AbstractC6884k;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.service.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6887b extends AbstractC6884k {

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f4426b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C6887b(C6888c c6888c, int i) {
        super(c6888c);
        this.f4426b = i;
    }

    @Override // com.samsung.android.app.notes.sync.saccount.samsungaccountclient.AbstractC6884k
    /* JADX INFO: renamed from: a */
    public final String mo5081a() {
        switch (this.f4426b) {
            case 0:
                return "ConnectingState";
            default:
                return "DisconnectedState";
        }
    }

    @Override // com.samsung.android.app.notes.sync.saccount.samsungaccountclient.AbstractC6884k
    /* JADX INFO: renamed from: b */
    public boolean mo5082b() {
        switch (this.f4426b) {
            case 0:
                Debugger.m8615i("ConnectingState", "[SA] connect() : already connecting");
                return true;
            default:
                return super.mo5082b();
        }
    }

    @Override // com.samsung.android.app.notes.sync.saccount.samsungaccountclient.AbstractC6884k
    /* JADX INFO: renamed from: c */
    public void mo5083c() {
        switch (this.f4426b) {
            case 1:
                Log.i("DisconnectedState", "[SA] call disConnect() : already disconnected");
                break;
            default:
                super.mo5083c();
                break;
        }
    }

    public final String toString() {
        switch (this.f4426b) {
            case 0:
                return "ConnectingState";
            default:
                return "DisconnectedState";
        }
    }
}
