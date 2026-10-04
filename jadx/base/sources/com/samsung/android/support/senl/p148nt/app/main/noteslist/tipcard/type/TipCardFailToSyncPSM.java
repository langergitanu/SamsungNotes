package com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type;

import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TipCardFailToSyncPSM extends TipCard {
    public TipCardFailToSyncPSM() {
        super(32, 0, C8003R.string.tipcard_sync_fail_psm, 0, C8003R.string.f6004OK, 1);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard
    public int getNeutralButtonResourceId() {
        return 0;
    }
}
