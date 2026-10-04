package com.samsung.android.support.senl.p148nt.composer.main.popupnote.presenter.sub;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.BaseSubManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ComposerSubContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.MenuAttachManager;
import com.samsung.android.support.senl.p148nt.composer.main.popupnote.presenter.PopupNoteContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/popupnote/presenter/sub/PopupNoteMenuAttachManager;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/sub/MenuAttachManager;", "subManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/sub/BaseSubManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/sub/BaseSubManager;)V", "attachViews", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PopupNoteMenuAttachManager extends MenuAttachManager {
    public PopupNoteMenuAttachManager(@Nullable BaseSubManager baseSubManager) {
        super(baseSubManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.MenuAttachManager
    public void attachViews() {
        super.attachViews();
        ComposerSubContract.IView iView = this.mView;
        if (iView instanceof PopupNoteContract.IView) {
            Intrinsics.checkNotNull(iView, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.composer.main.popupnote.presenter.PopupNoteContract.IView");
            ((PopupNoteContract.IView) iView).setCustomMenu();
        }
    }
}
