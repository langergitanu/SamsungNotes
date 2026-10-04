package com.samsung.android.support.senl.p148nt.app.sync.contractimpl;

import android.content.Context;
import com.samsung.android.app.notes.sync.infos.ModelType;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.tipcard.TipCardModelHelper;
import p105a0.InterfaceC0353a;
import p260z0.AbstractC14519b;
import p260z0.C14518a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TipCardModelContractImpl implements InterfaceC0353a {
    @Override // p105a0.InterfaceC0353a
    public void addErrorTipCard(Context context, C14518a c14518a) {
        new TipCardModelHelper().addErrorTipCard(context, c14518a);
    }

    public void addInfoTipCard(Context context, AbstractC14519b abstractC14519b) {
        new TipCardModelHelper().addInfoTipCard(context, abstractC14519b);
    }

    @Override // p105a0.InterfaceC0353a
    public void removeTipCard(Context context, ModelType modelType, int i) {
        new TipCardModelHelper().removeTipCard(context, modelType, i);
    }
}
