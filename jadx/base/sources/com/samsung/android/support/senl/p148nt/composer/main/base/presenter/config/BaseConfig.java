package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.config;

import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.GlobalShareData;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BaseConfig implements Config {
    protected boolean mIsEditableByAction;
    protected boolean mIsHandOffEnabled;
    protected boolean mIsInAppCollaborationEnabled;
    protected boolean mIsLiveSharingEnabled;
    protected boolean mIsQuickNoteEnabled;
    protected boolean mIsRestoreEnabled;
    protected boolean mIsToolbarChangeable;
    protected boolean mIsWritingOnlyType;
    protected boolean mIsShortCutEnabled = true;
    protected boolean mIsVoiceRecordingEnabled = true;
    protected boolean mIsTitleEditable = true;
    protected boolean mIsBookmarkMenuEnabled = true;
    protected boolean mIsAudioFileAttachable = true;
    protected boolean mIsDocumentScanEnabled = true;
    protected boolean mIsHandWritingHelpEnabled = true;
    protected boolean mIsClosableByAction = true;
    protected boolean mIsStatusBarEnabled = true;
    protected boolean mIsActionBarEnabled = true;
    protected boolean mIsHashTagEnabled = true;
    protected boolean mIsPostLaunchEnabled = true;
    protected boolean mIsInitialLoadingProgressEnabled = true;
    protected boolean mIsStickyMemoEnabled = true;
    protected boolean mIsTableEnabled = true;
    protected boolean mIsNaviUpEnabled = true;
    protected boolean mIsBackKeyBlockingSupported = true;
    protected Boolean mIsAutoSaveOptionEnabled = null;
    protected long mMaxDocumentSize = 1073741824;
    protected GlobalShareData mGlobalShareData = new GlobalShareData();

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public GlobalShareData getGlobalShareData() {
        return this.mGlobalShareData;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public long getMaxDocumentSize() {
        return this.mMaxDocumentSize;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isActionBarEnabled() {
        return this.mIsActionBarEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isAudioFileAttachable() {
        return this.mIsAudioFileAttachable;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    @Nullable
    public Boolean isAutoSaveOptionEnabled() {
        return this.mIsAutoSaveOptionEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isBackKeyBlockingSupported() {
        return this.mIsBackKeyBlockingSupported;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isBookmarkMenuEnabled() {
        return this.mIsBookmarkMenuEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isClosableByAction() {
        return this.mIsClosableByAction;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isDocumentScanEnabled() {
        return this.mIsDocumentScanEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isEditableByAction() {
        return this.mIsEditableByAction;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isHandOffEnabled() {
        return this.mIsHandOffEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isHandWritingHelpEnabled() {
        return this.mIsHandWritingHelpEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isHashTagEnabled() {
        return this.mIsHashTagEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isInAppCollaborationEnabled() {
        return this.mIsInAppCollaborationEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isInitialLoadingProgressEnabled() {
        return this.mIsInitialLoadingProgressEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isIrremovableTableDeleteBlocked() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isLiveSharingEnabled() {
        return this.mIsLiveSharingEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isNaviUpEnabled() {
        return this.mIsNaviUpEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isOnlyDeletableInPageList() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isPostLaunchEnabled() {
        return this.mIsPostLaunchEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isQuickNoteEnabled() {
        return this.mIsQuickNoteEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isRestoreEnabled() {
        return this.mIsRestoreEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isShortCutEnabled() {
        return this.mIsShortCutEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isStatusBarEnabled() {
        return this.mIsStatusBarEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isStickyMemoEnabled() {
        return this.mIsStickyMemoEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isTableEnabled() {
        return this.mIsTableEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isTitleEditable() {
        return this.mIsTitleEditable;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isToolbarChangeable() {
        return this.mIsToolbarChangeable;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isVoiceRecordingEnabled() {
        return this.mIsVoiceRecordingEnabled;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config
    public boolean isWritingOnlyType() {
        return this.mIsWritingOnlyType;
    }
}
