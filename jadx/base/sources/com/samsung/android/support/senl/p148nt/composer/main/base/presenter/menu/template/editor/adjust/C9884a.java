package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.TEAdjustModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.editor.menu.TEMenuView;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.editor.adjust.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9884a implements TEAdjustModel.OpacityChangedListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7054a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7055b;

    public /* synthetic */ C9884a(Object obj, int i) {
        this.f7054a = i;
        this.f7055b = obj;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.template.editor.adjust.TEAdjustModel.OpacityChangedListener
    public final void notifyOpacityChanged() {
        switch (this.f7054a) {
            case 0:
                ((TEAdjustPresenter) this.f7055b).lambda$new$0();
                break;
            default:
                ((TEMenuView) this.f7055b).setPercentText();
                break;
        }
    }
}
