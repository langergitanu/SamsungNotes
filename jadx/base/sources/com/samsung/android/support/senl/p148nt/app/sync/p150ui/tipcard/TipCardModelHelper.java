package com.samsung.android.support.senl.p148nt.app.sync.p150ui.tipcard;

import android.content.Context;
import com.samsung.android.app.notes.sync.infos.ModelType;
import p105a0.InterfaceC0353a;
import p260z0.AbstractC14519b;
import p260z0.C14518a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TipCardModelHelper implements InterfaceC0353a {
    @Override // p105a0.InterfaceC0353a
    public void addErrorTipCard(Context context, C14518a c14518a) {
        IModelTipCard iModelTipCardCreate = TipCardModelFactory.create(c14518a.f10349a);
        if (iModelTipCardCreate != null) {
            iModelTipCardCreate.addErrorTipCard(context, c14518a);
        }
    }

    public void addInfoTipCard(Context context, AbstractC14519b abstractC14519b) {
        IModelTipCard iModelTipCardCreate = TipCardModelFactory.create(abstractC14519b.f10349a);
        if (iModelTipCardCreate != null) {
            iModelTipCardCreate.addInfoTipCard(context, abstractC14519b);
        }
    }

    @Override // p105a0.InterfaceC0353a
    public void removeTipCard(Context context, ModelType modelType, int i) {
        IModelTipCard iModelTipCardCreate = TipCardModelFactory.create(modelType);
        if (iModelTipCardCreate != null) {
            iModelTipCardCreate.removeTipCard(context, i);
        }
    }
}
