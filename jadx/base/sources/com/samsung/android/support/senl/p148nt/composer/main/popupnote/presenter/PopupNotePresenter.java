package com.samsung.android.support.senl.p148nt.composer.main.popupnote.presenter;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.CompContract;
import com.samsung.android.support.senl.p148nt.composer.main.popupnote.presenter.PopupNoteContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0014J\b\u0010\u0019\u001a\u00020\nH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/popupnote/presenter/PopupNotePresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/BaseComposerPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/NoteManager$ObserverBackgroundColor;", "componentFactory", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/BaseComposerPresenter$ComponentFactory;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/BaseComposerPresenter$ComponentFactory;)V", "mPopupNoteView", "Lcom/samsung/android/support/senl/nt/composer/main/popupnote/presenter/PopupNoteContract$IView;", "setView", "", "view", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/CompContract$IView;", "onChangedBackgroundColor", "color", "", "invert", "", "hasBackgroundImage", "onDestroy", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "save", "closeDoc", "initBackgroundColor", "onInitFinished", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PopupNotePresenter extends BaseComposerPresenter implements NoteManager.ObserverBackgroundColor {

    @Nullable
    private PopupNoteContract.IView mPopupNoteView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupNotePresenter(@NotNull BaseComposerPresenter.ComponentFactory componentFactory) {
        super(componentFactory);
        Intrinsics.checkNotNullParameter(componentFactory, "componentFactory");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter
    public void initBackgroundColor() {
        super.initBackgroundColor();
        this.mSubManager.getCompViewPresenter().getNoteManager().addBackgroundColorObserver(this);
        PopupNoteContract.IView iView = this.mPopupNoteView;
        if (iView != null) {
            iView.setBackgroundColorOfCustomMenu(this.mSubManager.getCompViewPresenter().getBackgroundColor(), this.mSubManager.getCompViewPresenter().isBackgroundColorInverted(), this.mSubManager.getCompViewPresenter().hasBackgroundImage());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.NoteManager.ObserverBackgroundColor
    public void onChangedBackgroundColor(int color, boolean invert, boolean hasBackgroundImage) {
        PopupNoteContract.IView iView = this.mPopupNoteView;
        if (iView != null) {
            iView.setBackgroundColorOfCustomMenu(color, invert, hasBackgroundImage);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter
    public void onDestroy(@NotNull Activity activity, boolean save, boolean closeDoc) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onDestroy(activity, save, closeDoc);
        if (closeDoc) {
            return;
        }
        this.mSubManager.setCompViewPresenter(null);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewPresenter.OnInitFinishedListener
    public void onInitFinished() {
        super.onInitFinished();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter
    public void setView(@NotNull CompContract.IView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setView(view);
        if (view instanceof PopupNoteContract.IView) {
            this.mPopupNoteView = (PopupNoteContract.IView) view;
        }
    }
}
