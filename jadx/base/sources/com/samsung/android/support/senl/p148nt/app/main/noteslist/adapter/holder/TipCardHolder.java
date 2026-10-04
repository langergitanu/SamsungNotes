package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder;

import android.view.View;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TipCardHolder extends CommonHolder {
    private CommonHolderInfo mTipCardHolderInfo;

    public TipCardHolder(@NonNull View view, int i) {
        super(view, i);
        setHolderType(16384);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void decorate(Common common, StateInfo stateInfo) {
        if (this.mTipCardHolderInfo == null) {
            this.mTipCardHolderInfo = new CommonHolderInfo().setRootCardView(this.itemView.findViewById(C8003R.id.tipcard_layout));
        }
    }

    public CommonHolderInfo getTipCardHolderInfo() {
        return this.mTipCardHolderInfo;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void onBindViewHolder(int i) {
        getMAdapterContract().onTipCardBindViewHolder(this.mTipCardHolderInfo);
    }
}
