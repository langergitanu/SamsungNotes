package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerCacheFileUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.document.save.CoverThumbnailCreator;
import cz.msebera.android.httpclient.cookie.ClientCookie;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SaveNoteConfirmDialogPresenter extends AbsDialogFragmentPresenter {
    private static final String TAG = Logger.createTag("SaveNoteConfirmDialogPresenter");
    protected final ComposerModel mComposerModel;
    private final DialogContract.IDialogCreator mCreator;
    private final PageManager mPageManager;
    private final DialogContract.IParent mParent;
    protected Runnable mSavePostAction;

    public SaveNoteConfirmDialogPresenter(DialogContract.IParent iParent, DialogContract.IDialogCreator iDialogCreator, ComposerModel composerModel, PageManager pageManager) {
        this.mParent = iParent;
        this.mCreator = iDialogCreator;
        this.mComposerModel = composerModel;
        this.mPageManager = pageManager;
    }

    public void discard() {
        String str = TAG;
        Logger.m11004w(str, "selected discard");
        Logger.addFileLog(str, ClientCookie.DISCARD_ATTR, 0);
        this.mComposerModel.getVoiceModel().cancelRecording();
        this.mComposerModel.getDocState().getDocumentRepository().addSaveStrategy(1024);
        this.mComposerModel.setUpToFinishWithoutSave();
        this.mComposerModel.discard(true);
        this.mPageManager.setSkipToSaveCache(true);
        ComposerCacheFileUtil.deleteNoteAppAttachFolder(this.mActivity, this.mComposerModel.getDocState().getUuid());
        CoverThumbnailCreator.deleteCoverFileByUuid(this.mActivity, this.mComposerModel.getDocState().getUuid());
        this.mParent.finish("note discard");
        this.mSavePostAction = null;
    }

    public void dismiss() {
        this.mSavePostAction = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public DialogFragment findFragmentByTag(Activity activity) {
        return findFragmentByTag(activity, TAG);
    }

    public void save() {
        if (this.mComposerModel.isSupportedViewMode()) {
            this.mComposerModel.getModeManager().setMode(Mode.View, "back", true);
        }
        boolean zIsChangedRealContent = this.mComposerModel.isChangedRealContent();
        if (this.mComposerModel.saveAsync(true, true) && zIsChangedRealContent) {
            this.mComposerModel.updateActionLinkData();
        }
        Runnable runnable = this.mSavePostAction;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void show(Runnable runnable) {
        Activity activity = this.mActivity;
        String str = TAG;
        if (canShow(activity, str)) {
            show(this.mActivity, str, this.mCreator.createSaveNoteConfirmDialogFragment());
            this.mSavePostAction = runnable;
        }
    }
}
