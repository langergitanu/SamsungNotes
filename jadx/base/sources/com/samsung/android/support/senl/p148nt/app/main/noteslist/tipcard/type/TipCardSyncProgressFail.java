package com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type;

import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TipCardSyncProgressFail extends TipCard {
    public TipCardSyncProgressFail(int i) {
        super(i, 0, 0, C8003R.string.base_string_settings, 0, 0);
        setBodyResource(getTipCardBodyResource(i));
    }

    private int getTipCardBodyResource(int i) {
        return i == 34 ? C8003R.string.tipcard_sync_progress_fail_to_auto_sync : i == 35 ? C8003R.string.tipcard_sync_progress_fail_to_wifi_only : i == 37 ? C8003R.string.tipcard_sync_progress_fail_to_sync_off : C8003R.string.base_string_could_not_sync_notes;
    }
}
