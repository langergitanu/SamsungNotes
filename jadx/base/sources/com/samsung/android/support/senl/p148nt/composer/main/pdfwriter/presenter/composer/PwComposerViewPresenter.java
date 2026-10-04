package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.composer;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerDocInitialization;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwComposerViewPresenter extends ComposerViewPresenter {
    public PwComposerViewPresenter(@NonNull ComposerViewPresenter.ComponentFactory componentFactory, @NonNull KeyguardPresenter keyguardPresenter) {
        super(componentFactory, keyguardPresenter);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter
    public ComposerDocInitialization createDocInitialization() {
        this.mSpenWNote.setPDFReaderMode(true);
        return new ComposerDocInitialization(this.mActivity, this.mSpenWNote, this.mModelManager, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public boolean isActionLinkEnabled() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public boolean isHyperTextEnabled() {
        return false;
    }
}
