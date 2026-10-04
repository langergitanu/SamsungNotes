package com.samsung.android.support.senl.p148nt.composer.main.base.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import androidx.lifecycle.LifecycleOwner;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.support.BOOLEAN;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.StickyMemoSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.actionlink.ActionLinkModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common.TextOnlyModeState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.controller.search.SearchModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.ComposerSaveModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.NotesDocEntityManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.CoeditAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.MdeInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.MdeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.BookmarkModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.p153ai.drawing.AiDrawingState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.DirectWriteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.collector.CollectController;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import java.util.Objects;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerModel {
    public static final int STATE_SIMPLE_MODE_FOLDED = 2;
    public static final int STATE_SIMPLE_MODE_NONE = 0;
    public static final int STATE_SIMPLE_MODE_UNFOLDING = 1;
    public static final int STATE_TO_SAVE_IN_VIEW_MODE_DIMMED = 2;
    public static final int STATE_TO_SAVE_IN_VIEW_MODE_HIDDEN = 0;
    public static final int STATE_TO_SAVE_IN_VIEW_MODE_SHOWN = 1;
    private static final String TAG = Logger.createTag("ComposerModel");
    private boolean mCanShowRecoveredOnCorrupted;
    private final ComposerSaveModel mComposerSaveModel;
    private DocInfo mDocInfo;
    private NotesDocument<SpenWordDocument> mDocState;
    private final EntityManager mEntityManager;
    private boolean mIsDoingCoEditWorkThread;
    private boolean mIsInitLayoutFinishedOneSecond;
    private boolean mIsLastSpenOnlyMode;
    protected boolean mIsPDFReader;
    private boolean mIsRecoveredOnCorrupted;
    private boolean mIsRecoveringNote;
    private boolean mIsReloading;
    private boolean mIsTabletLayout;
    private String mLastMenuDirty;
    private SpenSettingUIPenInfo mLastPenInfoInNote;
    private final MdeManager mMdeManager;
    private final ModeManager mModeManager;
    private SearchModel mSearchModel;
    protected int mSimpleModeState;
    private final VoiceModel mVoiceModel;
    private final ComposerState mState = new ComposerState();
    private final TextOnlyModeState mTextOnlyModeState = new TextOnlyModeState();
    private final ComposerSpenDocModel mComposerSpenDocModel = new ComposerSpenDocModel();
    private final ActionLinkModel mActionLinkModel = new ActionLinkModel();
    private final DirectWriteManager mDirectWriteManager = new DirectWriteManager();

    public ComposerModel(Activity activity, @NonNull Config config) {
        ComposerSaveModel composerSaveModel = new ComposerSaveModel();
        this.mComposerSaveModel = composerSaveModel;
        this.mIsTabletLayout = false;
        this.mIsPDFReader = false;
        this.mIsRecoveredOnCorrupted = false;
        this.mCanShowRecoveredOnCorrupted = false;
        this.mIsRecoveringNote = false;
        this.mIsReloading = false;
        this.mIsDoingCoEditWorkThread = false;
        this.mLastMenuDirty = "";
        this.mIsInitLayoutFinishedOneSecond = false;
        this.mSimpleModeState = 0;
        composerSaveModel.setAutoSaveOptionEnabled(config.isAutoSaveOptionEnabled());
        this.mModeManager = createModeManager();
        this.mVoiceModel = new VoiceModel(activity);
        this.mEntityManager = new EntityManager(activity, new C8886c(this, 5));
        this.mMdeManager = new MdeManager(activity.getIntent(), getNotesDocEntityManager().getNotesDocumentRepository());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NotesDocument lambda$new$0() {
        return this.mDocState;
    }

    private void setAiFeatureSet() {
        boolean zIsAiFeatureEnabled = FeatureInfo.isAiFeatureEnabled();
        if (this.mMdeManager.getMdeInfo().isMde()) {
            if (zIsAiFeatureEnabled) {
                this.mState.setIsSupportedAiMenu(false);
            }
            this.mState.setIsSupportedAiCover(false);
        } else if (isPDFReader()) {
            if (zIsAiFeatureEnabled) {
                this.mState.setIsSupportedAiMenu(true);
            }
            this.mState.setIsSupportedAiCover(false);
        } else {
            if (zIsAiFeatureEnabled) {
                this.mState.setIsSupportedAiMenu(true);
            }
            this.mState.setIsSupportedAiCover(true);
        }
    }

    private void setSolveMathFeatureSet() {
        if (this.mMdeManager.getCoeditAdapter().isCoeditNote() || this.mMdeManager.getMdeInfo().isMde() || isPDFReader()) {
            this.mState.setIsSupportedSolveMath(false);
        } else {
            this.mState.setIsSupportedSolveMath(FeatureInfo.isSolveMathEnabled());
        }
    }

    public boolean canShowRecoveredOnCorrupted() {
        return this.mCanShowRecoveredOnCorrupted;
    }

    public void changeDocState(LifecycleOwner lifecycleOwner, NotesDocument<SpenWordDocument> notesDocument) {
        setDocState(notesDocument);
        this.mEntityManager.changeDocState(lifecycleOwner, notesDocument);
    }

    public boolean checkSimpleModeStateAndReset() {
        if (this.mSimpleModeState != 1) {
            return false;
        }
        this.mSimpleModeState = 0;
        return true;
    }

    public void clearLastPenInfoInNote() {
        this.mLastPenInfoInNote = null;
    }

    public ModeManager createModeManager() {
        return new ModeManager();
    }

    public void discard(boolean z) {
        this.mComposerSaveModel.discard(z);
        this.mState.setIsSaved(false);
    }

    public void finish() {
        this.mEntityManager.release();
        this.mMdeManager.release();
    }

    public ActionLinkModel getActionLinkModel() {
        return this.mActionLinkModel;
    }

    public AiDrawingState getAiDrawingState() {
        return getComposerState().getAiDrawingState();
    }

    public BookmarkModel getBookmarkModel() {
        return this.mEntityManager.getBookmarkModel();
    }

    public CoeditAdapter getCoeditAdapter() {
        return this.mMdeManager.getCoeditAdapter();
    }

    public ComposerSaveModel getComposerSaveModel() {
        return this.mComposerSaveModel;
    }

    public ComposerSpenDocModel getComposerSpenDocModel() {
        return this.mComposerSpenDocModel;
    }

    public ComposerState getComposerState() {
        return this.mState;
    }

    public String getDeviceNameForSyncConflicted() {
        return this.mEntityManager.getNotesDocEntityManager().getSyncConflictManager().getDeviceName();
    }

    public DirectWriteManager getDirectWriteManager() {
        return this.mDirectWriteManager;
    }

    public SpenWNote getDoc() {
        return this.mComposerSpenDocModel.getDoc();
    }

    public DocInfo getDocInfo() {
        return this.mDocInfo;
    }

    public NotesDocument<SpenWordDocument> getDocState() {
        return this.mDocState;
    }

    public EntityManager getEntityManager() {
        return this.mEntityManager;
    }

    public SpenSettingUIPenInfo getLastPenInfoInNote() {
        return this.mLastPenInfoInNote;
    }

    public void getLastPenInfoOnlyOnce() {
        Logger.m10999d(TAG, "getLastPenInfo#");
        DocInfo docInfo = this.mDocInfo;
        if (docInfo == null || docInfo.isOpenType(DocInfo.OpenType.New)) {
            return;
        }
        try {
            this.mLastPenInfoInNote = ((SpenWordDocument) this.mDocState.getDoc()).getLastPenInfo();
        } catch (Exception e) {
            AbstractC8014b.m7205g(e, new StringBuilder("getLastPenInfo# "), TAG);
            this.mLastPenInfoInNote = null;
        }
    }

    public MdeInfo getMdeInfo() {
        return this.mMdeManager.getMdeInfo();
    }

    public MdeManager getMdeManager() {
        return this.mMdeManager;
    }

    public String getMenuDirty() {
        return this.mLastMenuDirty;
    }

    public ModeManager getModeManager() {
        return this.mModeManager;
    }

    public NotesDocEntityManager getNotesDocEntityManager() {
        return this.mEntityManager.getNotesDocEntityManager();
    }

    public SearchModel getSearchData() {
        return this.mSearchModel;
    }

    public String getSearchKeyword() {
        SearchModel searchModel = this.mSearchModel;
        return searchModel != null ? searchModel.getKeyword() : "";
    }

    public String getState(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mComposerSpenDocModel.getSpenDocInfo(z));
        if (this.mDocInfo != null) {
            sb.append(", uuid: ");
            sb.append(this.mDocInfo.getUuid());
            sb.append(", openType: ");
            sb.append(this.mDocInfo.getOpenType());
        }
        if (this.mEntityManager.getNotesDocEntityManager() != null) {
            sb.append(", isDel: ");
            sb.append(this.mEntityManager.getNotesDocEntityManager().isDeleted());
            sb.append(", isLock: ");
            sb.append(this.mEntityManager.getNotesDocEntityManager().isLocked());
        }
        sb.append(", mde: ");
        sb.append(this.mMdeManager.getMdeInfo().isMde());
        return sb.toString();
    }

    public TextOnlyModeState getTextOnlyModeState() {
        return this.mTextOnlyModeState;
    }

    public VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public void initFirstBackgroundColorInverted() {
        NotesDocument<SpenWordDocument> notesDocument = this.mDocState;
        if (notesDocument == null || notesDocument.isNew()) {
            return;
        }
        this.mState.setBackgroundColorInverted(((SpenWordDocument) this.mDocState.getDoc()).isBackgroundColorInverted());
    }

    public void initMdeInfo() {
        this.mMdeManager.updateMdeEntity(this.mDocState.getDocumentEntityContainer().getEntity());
        if (this.mMdeManager.getCoeditAdapter().isCoeditNote()) {
            this.mComposerSaveModel.setAutoSaveOptionEnabled(Boolean.TRUE);
        }
        if (this.mMdeManager.getMdeInfo().isMde()) {
            setIsSupportedViewMode(true);
        }
    }

    public boolean insertSALogForDocument() {
        if (isPDFReader() || !this.mState.isSaved()) {
            return false;
        }
        ComposerSA.insertLog("401", "9923", Integer.toString(this.mComposerSpenDocModel.getPageCountForLog()));
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_SAVED_NOTE_CONTENTS_TEXT_COUNT, ComposerSA.getDetailBodyTextLength(this.mComposerSpenDocModel.getLogBodyTextLength()));
        ComposerSA.insertLog(StickyMemoSAConstants.SCREEN_STICKY_NOTE, "413", Integer.toString(this.mComposerSpenDocModel.getStickyMemoCountForLog()));
        this.mState.setIsSaved(false);
        return true;
    }

    public boolean isChangedDocState() {
        return this.mComposerSaveModel.isChangedDocState(this.mDocState);
    }

    public boolean isChangedDocStateOrRecording() {
        return this.mComposerSaveModel.isChangedDocState(this.mDocState) || getVoiceModel().isRecordingVoiceState();
    }

    public boolean isChangedDocStateWithSnapSavedData() {
        return isChangedDocState() || this.mComposerSaveModel.hasSnapSavedData(this.mDocState);
    }

    public boolean isChangedRealContent() {
        return this.mComposerSaveModel.isChangedRealContent(this.mDocState);
    }

    public boolean isDoingCoeditWorkThread() {
        return this.mIsDoingCoEditWorkThread;
    }

    public boolean isEditable() {
        return this.mState.isEditable();
    }

    public boolean isEmpty() {
        return this.mComposerSaveModel.isEmpty(this.mDocState);
    }

    public boolean isEmptyOnNewNote() {
        return this.mComposerSaveModel.isEmptyOnNewNote(this.mDocState);
    }

    public boolean isExistInDB(Activity activity) {
        return !TextUtils.isEmpty(NotesDataRepositoryFactory.newInstance(activity).createMainListDocumentDataRepository().getPath(this.mDocInfo.getUuid()));
    }

    public boolean isExistSdocxFile() {
        NotesDocument<SpenWordDocument> notesDocument = this.mDocState;
        if (notesDocument == null) {
            return false;
        }
        String path = notesDocument.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return FileUtils.exists(path);
    }

    public boolean isFirstBackgroundColorInverted() {
        return this.mState.isBackgroundColorInverted();
    }

    public boolean isInitLayoutFinishedOneSecond() {
        return this.mIsInitLayoutFinishedOneSecond;
    }

    public boolean isLastSpenOnlyMode() {
        return this.mIsLastSpenOnlyMode;
    }

    public boolean isLastStateLockCanvas() {
        return this.mState.isLastStateLockCanvas();
    }

    public boolean isLockStateMismatched() {
        return !this.mEntityManager.getNotesDocEntityManager().isLocked() && this.mComposerSpenDocModel.isLocked();
    }

    public boolean isPDFReader() {
        return this.mIsPDFReader;
    }

    public boolean isRecoveredOnCorrupted() {
        return this.mIsRecoveredOnCorrupted;
    }

    public boolean isRecoveringNote() {
        return this.mIsRecoveringNote;
    }

    public boolean isReloading() {
        return this.mIsReloading;
    }

    public boolean isRunningCoverEditor() {
        return this.mState.isRunningCoverEditor();
    }

    public boolean isRunningDrawing() {
        return this.mState.isRunningDrawing();
    }

    public boolean isSimpleMode() {
        AbstractC8014b.m7221w(new StringBuilder("isSimpleMode# state : "), TAG, this.mSimpleModeState);
        return this.mSimpleModeState == 2;
    }

    public boolean isSingleMode() {
        return this.mComposerSpenDocModel.isSingleMode();
    }

    public boolean isSupportedViewMode() {
        return this.mState.isUsingViewMode();
    }

    public boolean isTabletLayout() {
        return this.mIsTabletLayout;
    }

    public boolean isTranslatedPDFNote() {
        NotesDocument<SpenWordDocument> notesDocument = this.mDocState;
        if (notesDocument == null) {
            return false;
        }
        return UUIDUtils.isGenUuid(notesDocument.getUuid());
    }

    public boolean isUnsupportedHandoff() {
        return this.mMdeManager.getMdeInfo().isMde() || !isEditable() || isTranslatedPDFNote() || !this.mComposerSaveModel.isAutoSaveOptionEnabled();
    }

    public boolean needToConflictSyncForComposerEdit(String str) {
        NotesDocument<SpenWordDocument> notesDocument = this.mDocState;
        if (notesDocument == null || !notesDocument.getUuid().equals(str)) {
            Logger.m11000e(TAG, "needToConflictSyncForComposerEdit, mDocState is null or uuid is not matched.");
            return false;
        }
        if (this.mVoiceModel.isRecordingVoiceState()) {
            Logger.m11003i(TAG, "needToConflictSyncForComposerEdit isRecordingVoiceState true");
            return true;
        }
        if (!isChangedDocStateWithSnapSavedData()) {
            return false;
        }
        Logger.m11003i(TAG, "needToConflictSyncForComposerEdit isChangedDocStateWithSnapSavedData");
        return true;
    }

    public boolean needToPendingSyncForComposerBusy(String str) {
        DocInfo docInfo = this.mDocInfo;
        if (docInfo != null && str.equals(docInfo.getUuid())) {
            if (this.mDocState == null && getModeManager().isEditMode()) {
                Logger.m10999d(TAG, "needToPendingSyncForComposerBusy recreation");
                return true;
            }
            if (this.mState.getLastRequestCode() != -1) {
                Logger.m11004w(TAG, "needToPendingSyncForComposerBusy mRequestCode : " + this.mState.getLastRequestCode());
                return true;
            }
            if (this.mState.getAiDrawingState() != AiDrawingState.NONE) {
                Logger.m11004w(TAG, "needToPendingSyncForComposerBusy by create image, state: " + this.mState.getAiDrawingState());
                return true;
            }
            if (isReloading()) {
                Logger.m11004w(TAG, "needToPendingSyncForComposerBusy reloading");
                return true;
            }
        }
        return false;
    }

    public void onDestroy(boolean z, BOOLEAN r9) {
        if (z) {
            r9.setValue(this.mComposerSaveModel.save(this.mDocState, this.mState.isFinishAfterSave(), true, false, 0, false));
            if (r9.isFalse() && !isChangedDocState() && this.mComposerSaveModel.isHyperLinkChanged()) {
                this.mComposerSaveModel.saveForOnlyHyperLink(this.mDocState);
            }
        }
        this.mActionLinkModel.onDestroy();
        this.mVoiceModel.onDestroy();
    }

    public void onSaveInstanceState(Activity activity, @NonNull Bundle bundle, boolean z) {
        this.mComposerSaveModel.onSaveInstanceState(bundle);
        this.mState.setMode(this.mModeManager.getMode().name());
        this.mState.setPrevMode(this.mModeManager.getPrevMode().name());
        this.mState.blockSip(z);
        this.mState.setDeleteOnlyMode(this.mModeManager.isDeleteOnlyMode());
        this.mState.setMoveOnlyMode(this.mModeManager.isMoveOnlyMode());
        bundle.putParcelable(ComposerState.KEY_STATE, this.mState);
        this.mVoiceModel.onSaveInstanceState(bundle);
        this.mActionLinkModel.onSaveInstanceState(bundle);
        this.mDirectWriteManager.onSaveInstanceState(bundle);
        Intent intent = activity.getIntent();
        bundle.putString("sdoc_uuid", intent.getStringExtra("sdoc_uuid"));
        bundle.putString("doc_path", intent.getStringExtra("doc_path"));
        bundle.putBoolean("new_doc", intent.getBooleanExtra("new_doc", false));
        this.mDocInfo.onSaveInstanceState(bundle);
        this.mEntityManager.onSaveInstanceState(bundle);
        this.mMdeManager.onSaveInstanceState(bundle);
        this.mTextOnlyModeState.onSaveInstanceState(bundle);
    }

    public void requestCollect() {
        Logger.m10999d(TAG, "requestCollect#");
        CollectParam.CollectParamBuilder collectParamBuilder = new CollectParam.CollectParamBuilder();
        collectParamBuilder.setUuid(getDocInfo().getUuid()).setLastModifiedAt(this.mEntityManager.getNotesDocEntityManager().getLastModifiedTime()).setTriggerType(ICollectParam.TriggerType.SAVE.getValue()).setActionType(ICollectParam.ActionType.START.getValue()).setPriority(ICollectParam.Priority.FOREGROUND.getValue()).setLinkWith(ICollectParam.LinkWith.DEFAULT.getValue());
        if (getDocInfo().isOpenType(DocInfo.OpenType.New)) {
            getDocState().setAllPageIdList();
        }
        collectParamBuilder.setChangedPageIdList(getDocState().getChangedPageIdList());
        CollectController.getInstance().postCollectorTask(collectParamBuilder.build());
    }

    public void restoreState(Bundle bundle, boolean z, ModeManager.SoftInputManagerContract softInputManagerContract) {
        this.mVoiceModel.restoreState(bundle);
        this.mModeManager.restoreMode(this.mState.getMode(), this.mState.getPrevMode(), z, this.mState.isBlockedSip(), softInputManagerContract, this.mState.isDeleteOnlyMode(), this.mState.isMoveOnlyMode());
    }

    public void restoreStateOnlyData(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mState.restoreState(bundle);
        this.mComposerSaveModel.setEditable(this.mState.isEditable());
        this.mComposerSaveModel.restoreState(bundle);
        this.mActionLinkModel.restoreState(bundle);
        this.mDirectWriteManager.restoreState(bundle);
        this.mMdeManager.restoreState(bundle);
        this.mTextOnlyModeState.restoreState(bundle);
    }

    public boolean save(boolean z, boolean z2) {
        return save(this.mState.isFinishAfterSave(), z, z2, 0, false);
    }

    public void saveAndExecute(Runnable runnable) {
        if (saveAsync(true, true)) {
            ComposerSaveModel composerSaveModel = getComposerSaveModel();
            Objects.requireNonNull(runnable);
            composerSaveModel.addSaveListener(new C9123b(runnable));
        }
    }

    public boolean saveAsync(boolean z, boolean z2) {
        return save(false, z, z2, 0, false);
    }

    public boolean saveCache(boolean z) {
        if (this.mComposerSaveModel.isAutoSaveOptionEnabled() || this.mModeManager.isComposerViewMode()) {
            if (this.mComposerSaveModel.saveCache(this.mDocState, z, 0, false)) {
                this.mMdeManager.getCoeditAdapter().checkDeleteOnlyMode();
                this.mMdeManager.getCoeditAdapter().saveCoeditCache();
                this.mState.setIsSaved(true);
                return true;
            }
        } else if (this.mComposerSaveModel.snapSave(this.mDocState, z, 0)) {
            this.mState.setIsSaved(true);
            return true;
        }
        return false;
    }

    public void saveCacheAndRequestCollect() {
        if (isPDFReader()) {
            return;
        }
        if (saveCache(false)) {
            this.mComposerSaveModel.setRunnableAfterCompletedSave(new RunnableC9121a(this, 0));
        } else {
            requestCollect();
        }
    }

    public boolean saveCacheForced(boolean z) {
        if (!this.mComposerSaveModel.saveCacheForced(this.mDocState, z)) {
            return false;
        }
        this.mMdeManager.getCoeditAdapter().checkDeleteOnlyMode();
        this.mMdeManager.getCoeditAdapter().saveCoeditCache();
        this.mState.setIsSaved(true);
        return true;
    }

    public void setAiDrawingState(AiDrawingState aiDrawingState) {
        getComposerState().setAiDrawingState(aiDrawingState);
    }

    public void setCanShowRecoveredOnCorrupted(boolean z) {
        this.mCanShowRecoveredOnCorrupted = z;
    }

    public void setCoverData(String str, String str2, String str3, String str4, String str5, int i, int i2, int i4, int i5, boolean z) {
        String str6 = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "setCoverData# enable : ", ", state : ", ", bg : ");
        AbstractC2821a.m2207B(sbM1173s, str5, ", category : ", str4, ", isChanged : ");
        AbstractC8014b.m7215q(sbM1173s, z, str6);
        this.mDocState.getCoverDataSource().setCoverData(str, str2, str3, str4, str5, i, i2, i4, i5, z);
    }

    public void setDocInfo(DocInfo docInfo) {
        this.mDocInfo = docInfo;
    }

    public void setDocState(NotesDocument<SpenWordDocument> notesDocument) {
        this.mComposerSaveModel.setBlockedSave(false);
        getNotesDocEntityManager().setOnRemovedListener(null);
        this.mDocState = notesDocument;
        this.mComposerSpenDocModel.setDoc(notesDocument != null ? (SpenWordDocument) notesDocument.getDoc() : null);
        NotesDocument<SpenWordDocument> notesDocument2 = this.mDocState;
        if (notesDocument2 != null) {
            this.mEntityManager.setDocState(notesDocument2);
            this.mVoiceModel.init(this.mComposerSpenDocModel.getDoc());
            this.mActionLinkModel.setDoc(this.mComposerSpenDocModel.getDoc());
        }
        this.mIsReloading = false;
        if (notesDocument == null) {
            return;
        }
        setAiFeatureSet();
        setSolveMathFeatureSet();
        if (isPDFReader() || !isEditable()) {
            setIsSupportedViewMode(true);
        }
    }

    public void setDoingCoeditWorkThread(boolean z) {
        this.mIsDoingCoEditWorkThread = z;
    }

    public void setIsInitLayoutFinishedOneSecond(boolean z) {
        this.mIsInitLayoutFinishedOneSecond = z;
    }

    public void setIsRecoveredOnCorrupted(boolean z) {
        this.mIsRecoveredOnCorrupted = z;
    }

    public void setIsRecoveringNote(boolean z) {
        this.mIsRecoveringNote = z;
    }

    public void setIsSupportedViewMode(boolean z) {
        this.mState.setIsUsingViewMode(z);
    }

    public void setLastSpenOnlyMode(boolean z) {
        this.mIsLastSpenOnlyMode = z;
    }

    public void setLastStateLockCanvas(boolean z) {
        this.mState.setLastStateLockCanvas(z);
    }

    public void setMenuDirty(String str) {
        this.mLastMenuDirty = str;
    }

    public void setNotSave() {
        this.mComposerSaveModel.setNotSave(this.mDocState);
    }

    public void setObserverIsConflicted(LifecycleOwner lifecycleOwner, Runnable runnable) {
        this.mEntityManager.getNotesDocEntityManager().getSyncConflictManager().clearReplaceConflictStrategy();
        this.mEntityManager.getNotesDocEntityManager().getSyncConflictManager().setObserverIsConflicted(this.mDocState.getUuid(), lifecycleOwner, runnable);
    }

    public void setOpenedTime() {
        Logger.m10999d(TAG, "setOpenedTime#");
        DocInfo docInfo = this.mDocInfo;
        if (docInfo == null || docInfo.isOpenType(DocInfo.OpenType.OpenByView) || this.mDocInfo.isOpenType(DocInfo.OpenType.New)) {
            return;
        }
        this.mEntityManager.getNotesDocEntityManager().setOpenedTime(this.mDocInfo.getUuid());
    }

    public void setReloadingState(boolean z) {
        this.mIsReloading = z;
    }

    public void setRunningCoverEditor(boolean z) {
        this.mState.setRunningCoverEditor(z);
    }

    public void setRunningDrawing(boolean z) {
        AbstractC8014b.m7220v("setRunningDrawing# ", TAG, z);
        this.mState.setRunningDrawing(z);
        if (z) {
            this.mState.setLastRequestCode(ComposerRequestCode.BrushDrawing.getId());
        }
    }

    public void setSaveModelDiscard(boolean z) {
        this.mComposerSaveModel.setDiscard(z);
    }

    public void setSearchData(SearchModel searchModel) {
        this.mSearchModel = searchModel;
    }

    public void setSimpleModeState(int i) {
        AbstractC0000a.m3D(i, "setSimpleModeState# ", TAG);
        this.mSimpleModeState = i;
    }

    public void setTabletLayout(boolean z) {
        this.mIsTabletLayout = z;
    }

    public void setUpToFinishWithoutSave() {
        getComposerSaveModel().setBlockedSave(true);
        DocumentRepository<SpenDocument, ? extends DocumentEntityContainer> documentRepository = getDocState().getDocumentRepository();
        if (documentRepository != 0) {
            documentRepository.removeSaveStrategy(128);
        }
    }

    public void setWidgetId(int i) {
        this.mDocState.getDocumentEntityContainer().getEntity().setWidgetId(i);
    }

    public void setWidgetUpdateSaveStrategy(boolean z) {
        NotesDocument<SpenWordDocument> notesDocument = this.mDocState;
        if (notesDocument == null) {
            return;
        }
        if (z) {
            notesDocument.getDocumentRepository().removeSaveStrategy(32768);
        } else {
            notesDocument.getDocumentRepository().addSaveStrategy(32768);
        }
    }

    public void updateActionLinkData() {
        this.mActionLinkModel.updateActionLinkData();
    }

    public void updateBackgroundData() {
        NotesDocument<SpenWordDocument> notesDocument = this.mDocState;
        if (notesDocument == null || !notesDocument.isSaveCache()) {
            return;
        }
        this.mActionLinkModel.updateActionLinkData();
        requestCollect();
    }

    public void updateConflictStrategy(int i) {
        this.mEntityManager.getNotesDocEntityManager().getSyncConflictManager().updateConflictStrategy(this.mDocState.getUuid(), i);
    }

    public DocInfo getDocInfo(Bundle bundle) {
        if (this.mDocInfo == null && bundle != null) {
            this.mDocInfo = DocInfo.restoreFromSavedInstance(bundle);
        }
        return this.mDocInfo;
    }

    public boolean save(boolean z, boolean z2, boolean z3, int i, boolean z4) {
        if (!this.mComposerSaveModel.save(this.mDocState, z, z2, z3, i, z4)) {
            return false;
        }
        if (!this.mComposerSaveModel.isChangedRealContent(this.mDocState)) {
            updateBackgroundData();
        }
        this.mMdeManager.getCoeditAdapter().checkDeleteOnlyMode();
        this.mMdeManager.getCoeditAdapter().saveCoeditCache();
        this.mState.setIsSaved(true);
        return true;
    }

    public boolean saveCache(boolean z, int i) {
        if (!this.mComposerSaveModel.saveCache(this.mDocState, z, i, true)) {
            return false;
        }
        this.mMdeManager.getCoeditAdapter().checkDeleteOnlyMode();
        this.mMdeManager.getCoeditAdapter().saveCoeditCache();
        this.mState.setIsSaved(true);
        return true;
    }
}
