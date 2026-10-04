package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.ResultOperation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultBottomView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultTopView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewSTT;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.D */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9678D implements AiMenuResultBottomView.AddToListPopup.OnClickListener, AiMenuResultTopView.MorePopup.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Object f6914a;

    public /* synthetic */ C9678D(Object obj) {
        this.f6914a = obj;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultTopView.MorePopup.OnClickListener
    public void onItemClick(int i) {
        ((CreateImageResultViewManager) this.f6914a).lambda$initPopupMenu$0(i);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.AddToListPopup.OnClickListener
    public void onItemClick(ResultOperation.AddTo addTo) {
        ((AiMenuResultViewSTT.C961014) this.f6914a).lambda$onClickAddToNode$0(addTo);
    }
}
