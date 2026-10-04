package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SyncProgressBarHolder extends CommonHolder {
    public SyncProgressBarHolder(@NonNull View view, int i) {
        super(view, i);
        setHolderType(524288);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void decorate(Common common, StateInfo stateInfo) {
        if (common.type != 524288) {
            return;
        }
        Common.SyncProgressBar syncProgressBar = (Common.SyncProgressBar) common;
        long j = common.f6179id;
        if (j == -20) {
            int i = syncProgressBar.syncNoteCount;
            ((TextView) this.itemView.findViewById(C8003R.id.sync_progress_message)).setText(this.itemView.getResources().getQuantityString(C8003R.plurals.sync_now_syncing_notes, i, Integer.valueOf(i)));
        } else if (j == -21) {
            ((TextView) this.itemView.findViewById(C8003R.id.sync_progress_message)).setText(C8003R.string.sync_now_network_error);
        }
    }
}
