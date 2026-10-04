package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.menu;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.menu.option.PwOptionMenuPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwMenuPresenterManager extends MenuPresenterManager {
    public PwMenuPresenterManager(@NonNull MenuPresenterContract.IMenuParent iMenuParent, @NonNull MenuPresenterManager.ComponentFactory componentFactory) {
        super(iMenuParent, componentFactory);
        this.mContextMenuManager.setBodyTextMenuEnabled(false);
        this.mContextMenuManager.setRecognitionMenuEnabled(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void attachBottomView() {
        super.attachBottomView();
        ((PwOptionMenuPresenter) this.mOptionMenuPresenter).showBottomView();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager
    public void onChangeLayoutBefore() {
        super.onChangeLayoutBefore();
        OptionMenuPresenter optionMenuPresenter = this.mOptionMenuPresenter;
        if (optionMenuPresenter instanceof PwOptionMenuPresenter) {
            ((PwOptionMenuPresenter) optionMenuPresenter).clearPwAddToNoteBottomView();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager
    public void onChangeMode(@NonNull Mode mode) {
        if (mode == Mode.View) {
            OptionMenuPresenter optionMenuPresenter = this.mOptionMenuPresenter;
            if (optionMenuPresenter instanceof PwOptionMenuPresenter) {
                ((PwOptionMenuPresenter) optionMenuPresenter).showPwAddToNoteBottomView();
                return;
            }
            return;
        }
        if (this.mComposerModel.getModeManager().isEditMode()) {
            OptionMenuPresenter optionMenuPresenter2 = this.mOptionMenuPresenter;
            if (optionMenuPresenter2 instanceof PwOptionMenuPresenter) {
                ((PwOptionMenuPresenter) optionMenuPresenter2).hidePwAddToNoteBottomView();
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager
    public void restoreState(Bundle bundle, boolean z) {
        super.restoreState(bundle, z);
        ((PwOptionMenuPresenter) this.mOptionMenuPresenter).showBottomView();
    }
}
