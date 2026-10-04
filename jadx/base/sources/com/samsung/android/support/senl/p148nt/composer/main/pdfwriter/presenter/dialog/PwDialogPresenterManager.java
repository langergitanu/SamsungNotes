package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.dialog;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SaveNoteConfirmDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.dialog.PwDialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.dialog.PwSaveBackupDialogPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwDialogPresenterManager extends DialogPresenterManager {
    private PwSaveBackupDialogPresenter mSaveBackupDialogPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract extends PwSaveBackupDialogPresenter.Contract {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PwSaveNoteConfirmDialogPresenter extends SaveNoteConfirmDialogPresenter {
        public PwSaveNoteConfirmDialogPresenter(DialogContract.IParent iParent, DialogContract.IDialogCreator iDialogCreator, ComposerModel composerModel, PageManager pageManager) {
            super(iParent, iDialogCreator, composerModel, pageManager);
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SaveNoteConfirmDialogPresenter
        public void discard() {
            super.discard();
            ((PwComposerModel) this.mComposerModel).trimCacheInfo();
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SaveNoteConfirmDialogPresenter
        public void save() {
            ((PwComposerModel) this.mComposerModel).save(this.mSavePostAction);
        }
    }

    public PwDialogPresenterManager(@NonNull BaseComponentFactory baseComponentFactory) {
        super(baseComponentFactory);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IFragmentPresenterContainer
    @Nullable
    public DialogContract.IFragmentPresenter getDialogFragmentPresenter(int i) {
        DialogContract.IFragmentPresenter dialogFragmentPresenter = super.getDialogFragmentPresenter(i);
        return (dialogFragmentPresenter == null && 500 == i) ? this.mSaveBackupDialogPresenter : dialogFragmentPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager
    public void init(DialogContract.IParent iParent, DialogContract.IDialogCreator iDialogCreator, ControllerManager controllerManager, ComposerViewPresenter composerViewPresenter, MenuPresenterManager menuPresenterManager, ComposerModel composerModel) {
        super.init(iParent, iDialogCreator, controllerManager, composerViewPresenter, menuPresenterManager, composerModel);
        this.mSaveBackupDialogPresenter = new PwSaveBackupDialogPresenter((PwDialogContract.IDialogCreator) iDialogCreator, controllerManager.getTaskController());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager
    public void onAttachView(Activity activity) {
        super.onAttachView(activity);
        this.mSaveBackupDialogPresenter.onAttachView(activity);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager
    public void onDetachView() {
        super.onDetachView();
        PwSaveBackupDialogPresenter pwSaveBackupDialogPresenter = this.mSaveBackupDialogPresenter;
        if (pwSaveBackupDialogPresenter != null) {
            pwSaveBackupDialogPresenter.onDetachView();
        }
    }

    public void setPwDialogContract(Contract contract) {
        this.mSaveBackupDialogPresenter.setContract(contract);
    }

    public void showSaveBackupDialog() {
        this.mSaveBackupDialogPresenter.show();
    }
}
