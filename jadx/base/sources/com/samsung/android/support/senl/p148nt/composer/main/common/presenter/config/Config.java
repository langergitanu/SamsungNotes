package com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface Config {
    GlobalShareData getGlobalShareData();

    long getMaxDocumentSize();

    boolean isActionBarEnabled();

    boolean isAudioFileAttachable();

    @Nullable
    Boolean isAutoSaveOptionEnabled();

    boolean isBackKeyBlockingSupported();

    boolean isBookmarkMenuEnabled();

    boolean isClosableByAction();

    boolean isDocumentScanEnabled();

    boolean isEditableByAction();

    boolean isHandOffEnabled();

    boolean isHandWritingHelpEnabled();

    boolean isHashTagEnabled();

    boolean isInAppCollaborationEnabled();

    boolean isInitialLoadingProgressEnabled();

    boolean isIrremovableTableDeleteBlocked();

    boolean isLiveSharingEnabled();

    boolean isNaviUpEnabled();

    boolean isOnlyDeletableInPageList();

    boolean isPostLaunchEnabled();

    boolean isQuickNoteEnabled();

    boolean isRestoreEnabled();

    boolean isShortCutEnabled();

    boolean isStatusBarEnabled();

    boolean isStickyMemoEnabled();

    boolean isTableEnabled();

    boolean isTitleEditable();

    boolean isToolbarChangeable();

    boolean isVoiceRecordingEnabled();

    boolean isWritingOnlyType();
}
