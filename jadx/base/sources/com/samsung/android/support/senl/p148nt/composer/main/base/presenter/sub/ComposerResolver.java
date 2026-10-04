package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerResolver implements ComposerManager.IComposerResolver {
    private static final String TAG = Logger.createTag("ComposerResolver");
    private final ComposerCloser mComposerCloser;
    private final Contract mContract;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final boolean mIsClosableByAction;
    private final boolean mIsEditableByAction;
    private final BaseSubManager mSubManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void callOnBackPressed();

        DocInfo getDocInfo();

        void setShouldCallRequestSyncFirst(boolean z);
    }

    public ComposerResolver(BaseSubManager baseSubManager, ComposerCloser composerCloser, Contract contract, @NonNull Config config) {
        this.mSubManager = baseSubManager;
        this.mComposerCloser = composerCloser;
        this.mContract = contract;
        this.mIsEditableByAction = config.isEditableByAction();
        this.mIsClosableByAction = config.isClosableByAction();
    }

    private boolean isStateToWaitRequestSyncFirst() {
        return this.mSubManager.getComposerModel().isChangedDocStateOrRecording() || this.mSubManager.getComposerModel().getComposerSaveModel().isSavingWorkingState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewModeByBack() {
        Logger.m10999d(TAG, "setViewMode# back");
        this.mSubManager.getCompViewPresenter().getComponentFactory().getConfig().getGlobalShareData().getFlagBoolMap().put(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING, Boolean.TRUE);
        int i = 0;
        while (i < 10 && !this.mSubManager.getComposerModel().getModeManager().isMode(Mode.View)) {
            this.mContract.callOnBackPressed();
            i++;
        }
        if (i >= 10) {
            Logger.m11004w(TAG, "setViewModeByBack# callOnBackPressed is called over 10");
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IComposerResolver
    public boolean close(String str, Runnable runnable) {
        if (!this.mIsClosableByAction) {
            return true;
        }
        if (str != null && (this.mContract.getDocInfo() == null || !str.equals(this.mContract.getDocInfo().getUuid()))) {
            return true;
        }
        this.mComposerCloser.closeComposer(this.mSubManager.getComposerLifeState().getActivity(), str, runnable);
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IComposerResolver
    public void closeCoeditComposer(Runnable runnable) {
        ComposerModel composerModel = this.mSubManager.getComposerModel();
        if (composerModel != null && composerModel.getCoeditAdapter().isCoeditNote()) {
            Logger.m10999d(TAG, "closeCoeditComposer# cur: " + getUuid());
            composerModel.getCoeditAdapter().clearCoeditCallback();
            this.mComposerCloser.closeComposer(this.mSubManager.getComposerLifeState().getActivity(), null, runnable);
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IComposerResolver
    public int getCurrentScreen() {
        if (this.mSubManager.getCompViewPresenter() == null || this.mSubManager.getCompViewPresenter().getView() == null || this.mSubManager.getMenuPresenterManager() == null || this.mSubManager.getMenuPresenterManager().getAiMenuManager() == null) {
            return 9000;
        }
        return this.mSubManager.getMenuPresenterManager().getAiMenuManager().getCurrentScreen();
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IComposerResolver
    @NonNull
    public String getFolderId() {
        String stringExtra;
        NotesDocumentEntity notesDocumentEntity;
        String folderUuid = this.mSubManager.getComposerModel().getNotesDocEntityManager().getFolderUuid();
        return (!TextUtils.isEmpty(folderUuid) || this.mSubManager.getComposerLifeState().getActivity() == null || (stringExtra = this.mSubManager.getComposerLifeState().getActivity().getIntent().getStringExtra("sdoc_uuid")) == null || (notesDocumentEntity = this.mSubManager.getComposerModel().getNotesDocEntityManager().getNotesDocumentRepository().get(stringExtra)) == null) ? folderUuid : notesDocumentEntity.getCategoryUuid();
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IComposerResolver
    @NonNull
    public String getUuid() {
        return this.mContract.getDocInfo() == null ? "" : this.mContract.getDocInfo().getUuid();
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IComposerResolver
    public boolean hasNotification(@NonNull String str) {
        Intent intent;
        Activity activity = this.mSubManager.getComposerLifeState().getActivity();
        return (activity == null || (intent = activity.getIntent()) == null || !hasNotification(intent, str)) ? false : true;
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IComposerResolver
    public boolean isCoeditMode() {
        if (this.mSubManager.getComposerModel() == null) {
            return false;
        }
        Logger.m11003i(TAG, "isCoeditModeComposer : " + this.mSubManager.getComposerModel().getModeManager().getMode());
        return this.mSubManager.getComposerModel().getCoeditAdapter().isCoeditMode();
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IComposerResolver
    public boolean isCoeditNote() {
        if (this.mSubManager.getComposerModel() != null) {
            return this.mSubManager.getComposerModel().getCoeditAdapter().isCoeditNote();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IComposerResolver
    public boolean isEditMode() {
        if (!this.mIsEditableByAction || this.mSubManager.getComposerModel() == null) {
            return false;
        }
        Logger.m11003i(TAG, "isEditModeComposer : " + this.mSubManager.getComposerModel().getModeManager().getMode());
        return this.mSubManager.getComposerModel().getModeManager().isEditModeWithReadOnly();
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IComposerResolver
    public boolean isEditable() {
        return this.mIsEditableByAction && this.mSubManager.getComposerLifeState().isInitialized() && this.mSubManager.isEditableState();
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IComposerResolver
    public boolean isInitialLockDismissed() {
        if (this.mSubManager.getMenuPresenterManager().getTitleEditorPresenter() == null) {
            return false;
        }
        return this.mSubManager.getMenuPresenterManager().getTitleEditorPresenter().getKeyguardPresenter().isInitialLockDismissed();
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IComposerResolver
    public boolean isSearchMode() {
        if (!this.mIsEditableByAction || this.mSubManager.getComposerModel() == null) {
            return false;
        }
        Logger.m11003i(TAG, "isEditModeComposer : " + this.mSubManager.getComposerModel().getModeManager().getMode());
        return this.mSubManager.getComposerModel().getModeManager().isMode(Mode.Search);
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IComposerResolver
    public void requestViewMode() {
        if (this.mSubManager.getCompViewPresenter() == null || this.mSubManager.getCompViewPresenter().getView() == null) {
            return;
        }
        if (isStateToWaitRequestSyncFirst()) {
            this.mContract.setShouldCallRequestSyncFirst(true);
        } else {
            RequestToSyncManager.INSTANCE.requestSyncUpFirst(this.mSubManager.getComposerModel().getDocState().getUuid());
        }
        if (this.mSubManager.getComposerModel().getModeManager().isMode(Mode.View)) {
            Logger.m11003i(TAG, "requestViewMode# already view mode");
        } else {
            this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerResolver.1
                @Override // java.lang.Runnable
                public void run() {
                    ComposerResolver.this.mComposerCloser.closeTopWindow(ComposerResolver.this.mSubManager.getComposerLifeState().getActivity(), new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerResolver.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ComposerResolver.this.setViewModeByBack();
                        }
                    });
                }
            });
        }
    }

    private boolean hasNotification(@NonNull Intent intent, @NonNull String str) {
        boolean booleanExtra = intent.getBooleanExtra(str, false);
        Logger.m11003i(TAG, "hasNotification, name: " + str + ", / " + booleanExtra);
        return booleanExtra;
    }
}
