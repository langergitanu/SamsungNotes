package com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type;

import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TipCardMeet extends TipCard {
    private final boolean mIsHost;

    public TipCardMeet(boolean z) {
        super(28, z ? C8003R.string.live_sharing_dialog_host_title : C8003R.string.live_sharing_dialog_guest_title, C8003R.string.live_sharing_dialog_body, z ? C8003R.string.live_sharing_tipcard_host_select_note : C8003R.string.base_string_join, 0, 2);
        this.mIsHost = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard
    public int getNeutralButtonResourceId() {
        if (this.mIsHost) {
            return C8003R.string.live_sharing_tipcard_host_create_note;
        }
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard
    public int hashCode() {
        return super.hashCode();
    }

    public boolean isHost() {
        return this.mIsHost;
    }
}
