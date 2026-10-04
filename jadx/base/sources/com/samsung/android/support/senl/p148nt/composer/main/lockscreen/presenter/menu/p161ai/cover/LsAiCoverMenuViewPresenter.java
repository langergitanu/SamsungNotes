package com.samsung.android.support.senl.p148nt.composer.main.lockscreen.presenter.menu.p161ai.cover;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverMenuViewPresenter;
import kotlin.Metadata;
import p019D3.RunnableC0072a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/lockscreen/presenter/menu/ai/cover/LsAiCoverMenuViewPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/cover/AiCoverMenuViewPresenter;", "<init>", "()V", "onClickButton", "", "onClickOptionMenu", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LsAiCoverMenuViewPresenter extends AiCoverMenuViewPresenter {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverMenuViewPresenter
    public void onClickButton() {
        this.mKeyguardPresenter.dismissKeyguard(getActivity(), new RunnableC0072a(this, 1));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverMenuViewPresenter
    public void onClickOptionMenu() {
        this.mKeyguardPresenter.dismissKeyguard(getActivity(), new RunnableC0072a(this, 0));
    }
}
