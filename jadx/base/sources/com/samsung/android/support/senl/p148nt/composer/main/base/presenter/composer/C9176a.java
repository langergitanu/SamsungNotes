package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerManager;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentBackgroundUtils;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9176a implements HandoffManager.IComposerPresenter, NoteManager.ObserverInvertBackgroundColor, ListenerManager.ViewGetter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ComposerViewPresenter f6777a;

    public /* synthetic */ C9176a(ComposerViewPresenter composerViewPresenter) {
        this.f6777a = composerViewPresenter;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerManager.ViewGetter
    public ListenerImplContract.IView getView() {
        return this.f6777a.lambda$new$0();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.NoteManager.ObserverInvertBackgroundColor
    public void onUpdateInvertBackgroundColor(DocumentBackgroundUtils.InvertBackgroundColorType invertBackgroundColorType) {
        this.f6777a.toastDarkModeNotApplied(invertBackgroundColorType);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.handoff.HandoffManager.IComposerPresenter
    public void updatedLastPenInfo() {
        this.f6777a.lambda$createHandoffManager$1();
    }
}
