package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerDocInitialization;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0014¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/ScreenOffViewPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "componentFactory", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter$ComponentFactory;", "keyguardPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/common/presenter/keyguard/KeyguardPresenter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter$ComponentFactory;Lcom/samsung/android/support/senl/nt/composer/main/common/presenter/keyguard/KeyguardPresenter;)V", "isHyperTextEnabled", "", "isActionLinkEnabled", "createDocInitialization", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerDocInitialization;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScreenOffViewPresenter extends ComposerViewPresenter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenOffViewPresenter(@NotNull ComposerViewPresenter.ComponentFactory componentFactory, @NotNull KeyguardPresenter keyguardPresenter) {
        super(componentFactory, keyguardPresenter);
        Intrinsics.checkNotNullParameter(componentFactory, "componentFactory");
        Intrinsics.checkNotNullParameter(keyguardPresenter, "keyguardPresenter");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter
    @NotNull
    public ComposerDocInitialization createDocInitialization() {
        return new ComposerDocInitialization(this.mActivity, this.mSpenWNote, this.mModelManager, 100, false, false);
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
