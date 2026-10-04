package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SsmProgressBarHolder extends CommonHolder {
    public SsmProgressBarHolder(@NonNull View view, int i) {
        super(view, i);
        setHolderType(32768);
        ((TextView) view.findViewById(C8003R.id.ssm_progress_message)).setText(DeviceUtils.isTabletModel() ? C8003R.string.ssm_tablet_message : C8003R.string.ssm_phone_message);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void decorate(Common common, StateInfo stateInfo) {
    }
}
