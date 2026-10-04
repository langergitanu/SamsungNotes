package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.WorkerThread;
import androidx.appcompat.util.SeslKoreanGeneralizer;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.ntnl.coedit.CoeditDeviceInfo;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.common.Callback;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.NotesDocEntityManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.CoeditAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.MdeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ProgressController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ComposerSubContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class CoeditStarter {
    private static final int DELAY_SET_FIXED_READ_PERMISSION = 3000;
    private static final String TAG = Logger.createTag("CoeditStarter");
    private final ComposerCloser mComposerCloser;
    private final Contract mContract;
    private boolean mIsReopening;
    private Bundle mSaveInstance;
    private final BaseSubManager mSubManager;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter$11 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C992511 implements CoeditAdapter.ConnectionCallback {
        final /* synthetic */ CoeditAdapter val$coedit;
        final /* synthetic */ NotesDocument val$docState;
        final /* synthetic */ Runnable val$initData;

        /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter$11$ChangeNoteSnapCallback */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class ChangeNoteSnapCallback implements CoeditAdapter.ActionCallback {
            boolean mIsReady = false;
            final Handler mHandler = new Handler(Looper.getMainLooper());

            public ChangeNoteSnapCallback() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void handleError(boolean z) {
                this.mHandler.removeCallbacksAndMessages(null);
                DocumentWriteResolver.delete(CoeditStarter.this.mSubManager.getComposerLifeState().getActivity(), C992511.this.val$docState.getUuid(), 1, CoeditStarter.TAG);
                CoeditStarter.this.mContract.clearStateForChangeDoc(false, true);
                if (z) {
                    ToastHandler.show(CoeditStarter.this.mSubManager.getComposerLifeState().getActivity(), C9086R.string.coedit_create_unknown_fail, 0);
                }
                CoeditStarter.this.mComposerCloser.finish("startCoeditWithChangedNote#");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void openChannel() {
                CoeditStarter.this.mSubManager.getComposerModel().getCoeditAdapter().openCoeditChannel((SpenWNote) C992511.this.val$docState.getDoc(), CoeditStarter.this.new OpenChannelCallback(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.11.ChangeNoteSnapCallback.2
                    @Override // java.lang.Runnable
                    public void run() {
                        CoeditStarter.this.sharePublicLink();
                    }
                }));
            }

            private void readyComposer() {
                this.mIsReady = true;
                C992511.this.val$initData.run();
                this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.11.ChangeNoteSnapCallback.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CoeditStarter.this.mContract.attachLoadedDoc(C992511.this.val$docState);
                        CoeditStarter.this.setOnRemoveNoteListener();
                        ChangeNoteSnapCallback.this.restore();
                        CoeditStarter.this.showInitProgress(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.11.ChangeNoteSnapCallback.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ChangeNoteSnapCallback.this.handleError(false);
                            }
                        });
                        ChangeNoteSnapCallback.this.openChannel();
                        CoeditStarter.this.mContract.clearStateForChangeDoc(true, false);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void restore() {
                MdeManager.SavedState savedState = CoeditStarter.this.mSubManager.getComposerModel().getMdeManager().getSavedState();
                if (savedState == null) {
                    return;
                }
                CoeditStarter.this.mSubManager.getCompViewPresenter().getComposerControllerManager().getCvPageSettingController().setPageLayout(savedState.mPageLayoutColumn, savedState.mPageLayoutRow, savedState.mScrollVertical);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallback
            public void onCompleted() {
                Logger.m10999d(CoeditStarter.TAG, "ChangeNoteSnapCallback#onCompleted# ");
                if (this.mIsReady) {
                    openChannel();
                } else {
                    readyComposer();
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallback
            public void onError(String str) {
                handleError(true);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallback
            public void onStartOfflineMode(String str) {
                AbstractC8014b.m7196B("ChangeNoteSnapCallback#onStartOfflineMode# ", str, CoeditStarter.TAG);
                readyComposer();
            }
        }

        public C992511(NotesDocument notesDocument, CoeditAdapter coeditAdapter, Runnable runnable) {
            this.val$docState = notesDocument;
            this.val$coedit = coeditAdapter;
            this.val$initData = runnable;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ConnectionCallback
        public void onConnected() {
            NotesDocumentEntity notesDocumentEntity = CoeditStarter.this.mSubManager.getComposerModel().getNotesDocEntityManager().getNotesDocumentRepository().get(this.val$docState.getUuid());
            this.val$coedit.snapCoedit((SpenWNote) this.val$docState.getDoc(), this.val$docState.getPath(), notesDocumentEntity.getMdeGroupId(), notesDocumentEntity.getMdeSpaceId(), new ChangeNoteSnapCallback(), CoeditStarter.this.new CoeditHandlerContractImpl());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CoeditHandlerContractImpl implements CoeditHandlerManager.Contract {
        Handler mHandler = new Handler(Looper.getMainLooper());
        Runnable mSetFixedReadPermissionAction;

        public CoeditHandlerContractImpl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showToast(String str) {
            Activity activity = CoeditStarter.this.mSubManager.getComposerLifeState().getActivity();
            if (activity != null) {
                ToastHandler.show(activity, str, 1);
            }
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.Contract
        public boolean canShowProgress() {
            String str;
            boolean zIsRunning = CoeditStarter.this.mSubManager.getControllerManager().getTaskController().isRunning(false);
            if (zIsRunning) {
                str = "true(" + CoeditStarter.this.mSubManager.getControllerManager().getTaskController().getLastTask() + ")";
            } else {
                str = "false";
            }
            boolean zIsIdleWorkingState = CoeditStarter.this.mSubManager.getComposerModel().getComposerSaveModel().isIdleWorkingState();
            boolean zIsWorkingThread = CoeditStarter.this.mSubManager.getCompViewPresenter().getThumbnailUpdateHandler().isWorkingThread();
            AbstractC8014b.m7222x(AbstractC2821a.m2229t("canShowProgress# isTaskRunning = ", str, " / isIdleWorkingState= ", zIsIdleWorkingState, " / isMakingThumbnail= "), zIsWorkingThread, CoeditStarter.TAG);
            return (zIsRunning || !zIsIdleWorkingState || zIsWorkingThread) ? false : true;
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.Contract
        public String getWorkspaceId() {
            return CoeditStarter.this.mSubManager.getComposerModel().getCoeditAdapter().getWorkspaceId();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.Contract
        public int getXmlDataWeight() {
            return CoeditStarter.this.mSubManager.getComposerModel().getComposerSpenDocModel().getXmlDataWeight();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.Contract
        public void hideInitProgress(String str) {
            AbstractC8014b.m7197C("hideInitProgress# ", str, CoeditStarter.TAG);
            CoeditStarter.this.hideInitProgress();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.Contract
        public boolean hideProgress(String str) {
            CoeditStarter.this.mSubManager.getCompViewPresenter().executeWorkThreadFromCoedit(false);
            CoeditStarter.this.mSubManager.getControllerManager().getProgressController().hideProgress(6, true);
            CoeditStarter.this.mSubManager.executePendingAction();
            AbstractC8014b.m7197C("hideProgress# ", str, CoeditStarter.TAG);
            return true;
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.Contract
        public boolean isDeleteOnlyMode() {
            return CoeditStarter.this.mSubManager.getComposerModel().getModeManager().isDeleteOnlyMode();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.Contract
        public boolean isEditMode() {
            return CoeditStarter.this.mSubManager.getComposerModel().getModeManager().isEditMode();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.Contract
        public boolean isEditModeWithReadOnly() {
            return CoeditStarter.this.mSubManager.getComposerModel().getModeManager().isEditModeWithReadOnly();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.Contract
        public boolean isFixedReadPermission() {
            return CoeditStarter.this.mSubManager.getComposerModel().getMdeInfo().isFixedReadPermission();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.Contract
        public void onClickCloseComposer() {
            CoeditStarter.this.mComposerCloser.finish("onClickCloseComposer");
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.Contract
        public void onEditorUpdate(String str, String str2) {
            Logger.m11003i(CoeditStarter.TAG, "notifyEditMember# dvcId : " + str + " uid : " + str2);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.Contract
        public void onListUpdate(List<CoeditDeviceInfo> list) {
            CoeditStarter.this.onCoeditDeviceListChanged(list);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.Contract
        public void requestReopen(String str, boolean z, String str2) {
            String str3 = CoeditStarter.TAG;
            StringBuilder sbM2229t = AbstractC2821a.m2229t("requestReopen# msg: ", str, ", isDelayed: ", z, ", caller: ");
            sbM2229t.append(str2);
            Logger.m11003i(str3, sbM2229t.toString());
            CoeditStarter.this.onRequestReopenCoedit(str, z);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.Contract
        public void requestSaveToDevice(@StringRes int i) {
            CoeditStarter.this.mSubManager.getComposerModel().saveCache(true);
            CoeditStarter.this.mSubManager.getMenuPresenterManager().getOptionMenuPresenter().onClickSaveToDeviceBtn(i);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.Contract
        public void setDeleteOnlyMode(boolean z) {
            CoeditStarter.this.mSubManager.getComposerModel().getModeManager().setDeleteOnlyMode(z);
            if (!z || CoeditStarter.this.mSubManager.getComposerLifeState().getActivity() == null) {
                return;
            }
            Activity activity = CoeditStarter.this.mSubManager.getComposerLifeState().getActivity();
            ToastHandler.show(activity, activity.getString(C9086R.string.coedit_change_delete_only_mode), 1);
            NotesSamsungAnalytics.insertLog(null, "7651");
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.Contract
        @WorkerThread
        public void setFixedReadPermission(final boolean z, final String str) {
            Runnable runnable = this.mSetFixedReadPermissionAction;
            if (runnable != null) {
                this.mHandler.removeCallbacks(runnable);
            }
            Logger.m11003i(CoeditStarter.TAG, "setFixedReadPermission# " + z + " " + str);
            int i = z ? 0 : 3000;
            Runnable runnable2 = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.CoeditHandlerContractImpl.1
                private boolean canSetFixedReadPermissionAction() {
                    return (CommonUtil.isNotAvailableActivity(CoeditStarter.this.mSubManager.getComposerLifeState().getActivity()) || !CoeditStarter.this.mSubManager.getComposerLifeState().isInitialized() || z == CoeditStarter.this.mSubManager.getComposerModel().getMdeInfo().isFixedReadPermission()) ? false : true;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (canSetFixedReadPermissionAction()) {
                        if (!z) {
                            CoeditStarter.this.mSubManager.getComposerModel().getMdeInfo().setFixedReadPermission(z);
                            return;
                        }
                        if (CoeditStarter.this.mSubManager.getControllerManager().getTaskController().isRunning()) {
                            CoeditStarter.this.mSubManager.getControllerManager().getTaskController().addPendingJob(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.CoeditHandlerContractImpl.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    CoeditStarter.this.mSubManager.getComposerModel().getMdeInfo().setFixedReadPermission(z);
                                    RunnableC99351 runnableC99351 = RunnableC99351.this;
                                    if (z) {
                                        CoeditHandlerContractImpl.this.showToast(str);
                                    }
                                }
                            }, 2);
                            CoeditStarter.this.mSubManager.getControllerManager().getTaskController().cancel();
                        } else {
                            CoeditStarter.this.mSubManager.getComposerModel().getMdeInfo().setFixedReadPermission(z);
                            if (z) {
                                CoeditHandlerContractImpl.this.showToast(str);
                            }
                        }
                    }
                }
            };
            this.mSetFixedReadPermissionAction = runnable2;
            this.mHandler.postDelayed(runnable2, i);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.Contract
        public void setRequestUpdate(boolean z) {
            CoeditStarter.this.mSubManager.getCompViewPresenter().getThumbnailUpdateHandler().setBlockToUpdate(z, true);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.Contract
        public boolean showProgress(String str) {
            CoeditStarter.this.mSubManager.getCompViewPresenter().executeWorkThreadFromCoedit(true);
            CoeditStarter.this.mSubManager.getControllerManager().getProgressController().showProgress(0, 6);
            AbstractC8014b.m7197C("showProgress# ", str, CoeditStarter.TAG);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void attachLoadedDoc(Activity activity, NotesDocument<SpenWordDocument> notesDocument);

        void attachLoadedDoc(NotesDocument<SpenWordDocument> notesDocument);

        void clearStateForChangeDoc(boolean z, boolean z2);

        void connectCoeditService(boolean z);

        ComposerSubContract.IView getView();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OpenChannelCallback implements CoeditAdapter.ActionCallback {
        Runnable mPostCompletedAction;

        public OpenChannelCallback() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallback
        public void onCompleted() {
            Logger.m11003i(CoeditStarter.TAG, "OpenChannelCallback# onCompleted");
            CoeditStarter.this.hideInitProgress();
            Runnable runnable = this.mPostCompletedAction;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallback
        public void onError(String str) {
            CoeditStarter.this.hideInitProgress();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallback
        public void onStartOfflineMode(String str) {
        }

        public OpenChannelCallback(Runnable runnable) {
            this.mPostCompletedAction = runnable;
        }
    }

    public CoeditStarter(BaseSubManager baseSubManager, ComposerCloser composerCloser, Contract contract) {
        this.mSubManager = baseSubManager;
        this.mComposerCloser = composerCloser;
        this.mContract = contract;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attachCoeditNote(final Activity activity, final NotesDocument<SpenWordDocument> notesDocument) {
        if (((SpenWordDocument) notesDocument.getDoc()).getPageCount() == 0 && notesDocument.isNew()) {
            attachNewNoteForCoedit(activity, notesDocument);
            return;
        }
        showInitProgress();
        ComposerManager.getInstance().clearCoeditMemberManagerLeaveResult(this.mSubManager.getComposerModel().getMdeInfo().getGroupId());
        this.mSubManager.getComposerModel().getCoeditAdapter().snapCoedit((SpenWNote) notesDocument.getDoc(), notesDocument.getPath(), this.mSubManager.getComposerModel().getMdeInfo().getGroupId(), this.mSubManager.getComposerModel().getMdeInfo().getSpaceId(), new CoeditAdapter.ActionCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.2
            boolean mIsReady = false;

            private boolean canOpenChannel(String str) {
                return (CoeditServiceConstants.SnapError.SET_XML_FAIL.equals(str) || CoeditServiceConstants.SnapError.EMPTY_XML_FAIL.equals(str) || CoeditServiceConstants.ServerError.UPDATE_XML_VERSION.equals(str) || CoeditServiceConstants.ServerError.UPDATE_APP_VERSION.equals(str) || CoeditServiceConstants.ServerError.MAINTENANCE.equals(str) || CoeditServiceConstants.ServerError.AUTH_TOKEN_EXPIRED.equals(str) || CoeditServiceConstants.ServerError.UNKNOWN.equals(str)) ? false : true;
            }

            private void readyComposer(boolean z) {
                CoeditStarter.this.mSubManager.getComposerModel().getMdeManager().refreshMyId();
                if (this.mIsReady) {
                    return;
                }
                this.mIsReady = true;
                CoeditStarter.this.mContract.attachLoadedDoc(activity, notesDocument);
                CoeditStarter.this.setOnRemoveNoteListener();
                if (z) {
                    CoeditStarter.this.showInitProgress();
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallback
            public void onCompleted() {
                readyComposer(true);
                CoeditStarter.this.mSubManager.getComposerModel().getCoeditAdapter().checkDeleteOnlyMode();
                CoeditStarter.this.mSubManager.getComposerModel().getCoeditAdapter().openCoeditChannel((SpenWNote) notesDocument.getDoc(), CoeditStarter.this.new OpenChannelCallback());
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallback
            public void onError(String str) {
                readyComposer(false);
                CoeditStarter.this.mSubManager.getComposerModel().getCoeditAdapter().checkDeleteOnlyMode();
                if (canOpenChannel(str)) {
                    CoeditStarter.this.mSubManager.getComposerModel().getCoeditAdapter().openCoeditChannel((SpenWNote) notesDocument.getDoc(), CoeditStarter.this.new OpenChannelCallback());
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallback
            public void onStartOfflineMode(String str) {
                readyComposer(true);
                CoeditStarter.this.mSubManager.getComposerModel().getCoeditAdapter().openCoeditChannel((SpenWNote) notesDocument.getDoc(), CoeditStarter.this.new OpenChannelCallback());
            }
        }, new CoeditHandlerContractImpl());
    }

    private void attachNewNoteForCoedit(Activity activity, final NotesDocument<SpenWordDocument> notesDocument) {
        Logger.m10999d(TAG, "attachNewNoteForCoedit#");
        boolean zIsDefaultTemplatePdf = new EntryAction().isDefaultTemplatePdf(activity.getIntent());
        this.mContract.attachLoadedDoc(activity, notesDocument);
        showInitProgress(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.3
            @Override // java.lang.Runnable
            public void run() {
                CoeditHandlerManager.getInstance().cancel(notesDocument.getUuid());
                boolean zIsSnapEndState = CoeditHandlerManager.getInstance().isSnapEndState(notesDocument.getUuid());
                AbstractC8014b.m7220v("attachNewNoteForCoedit# showInitProgress cancel, isSnapEndState: ", CoeditStarter.TAG, zIsSnapEndState);
                if (zIsSnapEndState) {
                    return;
                }
                CoeditStarter.this.deleteFailedNote(notesDocument.getUuid(), "cancel");
            }
        });
        if (zIsDefaultTemplatePdf) {
            this.mSubManager.getControllerManager().getTaskController().addPendingJob(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.4
                @Override // java.lang.Runnable
                public void run() {
                    CoeditStarter.this.saveEmptyNoteAndStartCoedit(notesDocument);
                }
            }, 3);
        } else {
            saveEmptyNoteAndStartCoedit(notesDocument);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteFailedNote(String str, String str2) {
        String str3 = TAG;
        AbstractC8014b.m7196B("deleteFailedNote# ", str2, str3);
        this.mSubManager.getCompViewPresenter().getPageManager().setSkipToSaveCache(true);
        DocumentWriteResolver.delete(this.mSubManager.getComposerLifeState().getActivity(), str, 1, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideInitProgress() {
        if (this.mSubManager.getControllerManager().getTaskController() != null) {
            this.mSubManager.getControllerManager().getTaskController().resetOnCancelListener();
        }
        this.mSubManager.getControllerManager().getProgressController().hideProgress(5, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCoeditDeviceListChanged(List<CoeditDeviceInfo> list) {
        this.mSubManager.getMenuPresenterManager().getTitleEditorPresenter().onCoeditDeviceListChanged(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRequestReopenCoedit(final String str, final boolean z) {
        String str2 = TAG;
        AbstractC8014b.m7215q(new StringBuilder("onRequestReopenCoedit# "), this.mIsReopening, str2);
        if (this.mIsReopening) {
            return;
        }
        if (this.mSubManager.getCompViewPresenter().getView() == null) {
            Logger.m11000e(str2, "onRequestReopenCoedit# composer view is null");
            return;
        }
        this.mIsReopening = true;
        if (this.mSubManager.getControllerManager().getTaskController().isAvailableToReload()) {
            reopenCoedit(str, z);
        } else {
            this.mSubManager.getControllerManager().getTaskController().addPendingJob(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.7
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m11003i(CoeditStarter.TAG, "onRequestReopenCoedit# pending");
                    CoeditStarter.this.reopenCoedit(str, z);
                }
            }, 1);
        }
    }

    private void readyReopen() {
        this.mSubManager.getControllerManager().getSoftInputManager().hide((View) null);
        this.mSubManager.getMenuPresenterManager().onReadyReload();
        this.mSubManager.getCompViewPresenter().getPageManager().clearData(this.mSubManager.getComposerModel().getDoc());
        this.mSubManager.getControllerManager().getQuickSaveTimer().pause("reopenCoedit");
        this.mSubManager.getComposerModel().getVoiceModel().stopPlaying();
        this.mSubManager.getCompViewPresenter().getThumbnailUpdateHandler().setBlockToUpdate(true, true);
        this.mSubManager.getMenuPresenterManager().invalidateOptionsMenu();
        this.mSubManager.getComposerModel().getActionLinkModel().release();
        this.mSubManager.getCompViewPresenter().getListenerManager().onDestroy();
        this.mSubManager.getComposerModel().getMdeManager().release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reopenCoedit(final String str, boolean z) {
        this.mSubManager.getComposerModel().getMdeManager().setReopening(true);
        showInitProgress();
        if (z) {
            this.mSubManager.getCompViewPresenter().getView().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.8
                @Override // java.lang.Runnable
                public void run() {
                    if (CommonUtil.isNotAvailableActivity(CoeditStarter.this.mSubManager.getComposerLifeState().getActivity())) {
                        Logger.m11000e(CoeditStarter.TAG, "reopenCoedit#delay# isNotAvailableActivity");
                    } else {
                        CoeditStarter.this.reopenCoedit(str);
                    }
                }
            }, 500L);
        } else {
            reopenCoedit(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestReopen(String str) {
        Logger.m11002f(TAG, "requestReopen#" + str);
        CoeditCacheUtils.setForceReopenState(this.mSubManager.getComposerModel().getDocState().getUuid());
        final NotesDocument<SpenWordDocument> docState = this.mSubManager.getComposerModel().getDocState();
        this.mSubManager.getComposerModel().getCoeditAdapter().snapCoedit((SpenWNote) docState.getDoc(), docState.getPath(), this.mSubManager.getComposerModel().getMdeInfo().getGroupId(), this.mSubManager.getComposerModel().getMdeInfo().getSpaceId(), new CoeditAdapter.ActionCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.10
            private void attachComposer() {
                NotesDocument<SpenWordDocument> docState2 = CoeditStarter.this.mSubManager.getComposerModel().getDocState();
                CoeditStarter.this.mSubManager.getComposerLifeState().setSavedInstanceState(CoeditStarter.this.mSaveInstance);
                CoeditStarter.this.mSubManager.getComposerLifeState().setChangingDocState(true);
                CoeditStarter.this.mSubManager.getComposerModel().setDocInfo(new DocInfo(DocInfo.OpenType.Open, docState2.getPath(), docState2.getUuid()));
                CoeditStarter.this.mSubManager.getComposerLifeState().getActivity().getIntent().putExtra("new_doc", false);
                CoeditStarter.this.mContract.attachLoadedDoc(docState2);
                CoeditStarter.this.mSubManager.getMenuPresenterManager().getVoiceRecordMenuPresenter().reloadVoiceMenu();
                CoeditStarter.this.mSubManager.getControllerManager().getQuickSaveTimer().reset("reopenCoedit");
                CoeditStarter.this.mContract.getView().removeCaptureComposerView();
                CoeditStarter.this.mIsReopening = false;
                CoeditStarter.this.mSubManager.getComposerModel().getMdeManager().setReopening(false);
                CoeditStarter.this.mSaveInstance = null;
                CoeditStarter.this.setOnRemoveNoteListener();
            }

            private void startOpenChannel(boolean z) {
                if (z) {
                    CoeditStarter.this.showInitProgress();
                }
                CoeditStarter.this.mSubManager.getComposerModel().getCoeditAdapter().openCoeditChannel((SpenWNote) docState.getDoc(), CoeditStarter.this.new OpenChannelCallback());
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallback
            public void onCompleted() {
                Logger.m11003i(CoeditStarter.TAG, "requestReopen#Snap# onCompleted#");
                attachComposer();
                startOpenChannel(true);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallback
            public void onError(String str2) {
                AbstractC8014b.m7197C("requestReopen#Snap# Error# ", str2, CoeditStarter.TAG);
                attachComposer();
                startOpenChannel(false);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallback
            public void onStartOfflineMode(String str2) {
                AbstractC8014b.m7197C("requestReopen#Snap# onDelayedError# ", str2, CoeditStarter.TAG);
                onCompleted();
            }
        }, new CoeditHandlerContractImpl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveEmptyNoteAndStartCoedit(final NotesDocument<SpenWordDocument> notesDocument) {
        Logger.m10999d(TAG, "saveEmptyNoteAndStartCoedit#");
        notesDocument.setDirty(true);
        this.mSubManager.getComposerModel().save(true, false, false, 0, true);
        this.mSubManager.getComposerModel().getCoeditAdapter().snapCoedit((SpenWNote) notesDocument.getDoc(), notesDocument.getPath(), this.mSubManager.getComposerModel().getMdeInfo().getGroupId(), this.mSubManager.getComposerModel().getMdeInfo().getSpaceId(), new CoeditAdapter.ActionCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.5
            /* JADX INFO: Access modifiers changed from: private */
            public void finish(String str) {
                if (CoeditServiceConstants.ServerError.AUTH_TOKEN_EXPIRED.equals(str)) {
                    ToastHandler.show(CoeditStarter.this.mSubManager.getComposerLifeState().getActivity(), C9086R.string.ai_drawing_to_continue_using_services_securely_sign_in_again, 0);
                } else {
                    ToastHandler.show(CoeditStarter.this.mSubManager.getComposerLifeState().getActivity(), C9086R.string.coedit_create_unknown_fail, 0);
                }
                CoeditStarter.this.mComposerCloser.finish("saveEmptyNoteAndStartCoedit# " + str);
                CoeditStarter.this.hideInitProgress();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallback
            public void onCompleted() {
                CoeditStarter.this.setOnRemoveNoteListener();
                CoeditStarter.this.mSubManager.getComposerModel().getCoeditAdapter().openCoeditChannel((SpenWNote) notesDocument.getDoc(), CoeditStarter.this.new OpenChannelCallback(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CoeditStarter.this.sharePublicLink();
                    }
                }));
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallback
            public void onError(final String str) {
                AbstractC8014b.m7198D("onError# ", str, CoeditStarter.TAG);
                CoeditStarter.this.deleteFailedNote(notesDocument.getUuid(), "onError");
                if (CoeditStarter.this.mSubManager.getComposerModel().getMdeInfo().isStandAlone()) {
                    CoeditStarter.this.mSubManager.getComposerModel().getMdeManager().deleteSpace(CoeditStarter.this.mSubManager.getComposerModel().getMdeInfo().getGroupId(), CoeditStarter.this.mSubManager.getComposerLifeState().getActivity().getString(C9086R.string.base_string_no_title));
                }
                if (!CoeditStarter.this.mSubManager.getComposerModel().getModeManager().isMode(Mode.Text)) {
                    finish(str);
                } else {
                    CoeditStarter.this.mSubManager.getControllerManager().getSoftInputManager().hide((View) null);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.5.2
                        @Override // java.lang.Runnable
                        public void run() {
                            finish(str);
                        }
                    }, 500L);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallback
            public void onStartOfflineMode(String str) {
                CoeditStarter.this.mSubManager.getComposerModel().getCoeditAdapter().openCoeditChannel((SpenWNote) notesDocument.getDoc(), CoeditStarter.this.new OpenChannelCallback());
            }
        }, new CoeditHandlerContractImpl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOnRemoveNoteListener() {
        Logger.m10999d(TAG, "setOnRemoveNoteListener#");
        this.mSubManager.getComposerModel().getNotesDocEntityManager().setOnRemovedListener(new NotesDocEntityManager.OnRemovedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.12
            private void showMessage() {
                Activity activity = CoeditStarter.this.mSubManager.getComposerLifeState().getActivity();
                SpenObjectTextBox title = CoeditStarter.this.mSubManager.getComposerModel().getDoc().getTitle();
                String string = (title == null || TextUtils.isEmpty(title.getText())) ? !TextUtils.isEmpty(CoeditStarter.this.mSubManager.getComposerModel().getMdeInfo().getCreatorName()) ? activity.getString(C9086R.string.coedit_note_auto_title, CoeditStarter.this.mSubManager.getComposerModel().getMdeInfo().getCreatorName(), "") : "" : title.getText();
                if (ComposerManager.getInstance().getCoeditMemberManagerLeaveResult(CoeditStarter.this.mSubManager.getComposerModel().getMdeInfo().getGroupId())) {
                    Logger.m10999d(CoeditStarter.TAG, "getCoeditMemberManagerLeaveResult true groupId : " + CoeditStarter.this.mSubManager.getComposerModel().getMdeInfo().getGroupId());
                    return;
                }
                if (TextUtils.isEmpty(string)) {
                    ToastHandler.show(activity, activity.getString(C9086R.string.composer_sync_delete_note), 1);
                } else {
                    ToastHandler.show(activity, new SeslKoreanGeneralizer().naturalizeText(activity.getString(C9086R.string.composer_delete_note_by_person, string)), 1);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.data.NotesDocEntityManager.OnRemovedListener
            public void onRemoved() {
                if (CommonUtil.isNotAvailableActivity(CoeditStarter.this.mSubManager.getComposerLifeState().getActivity())) {
                    return;
                }
                showMessage();
                CoeditStarter.this.mSubManager.getComposerModel().setUpToFinishWithoutSave();
                CoeditStarter.this.mComposerCloser.finish("removed in DB of CoeditNote");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sharePublicLink() {
        String spaceName;
        Activity activity = this.mSubManager.getComposerLifeState().getActivity();
        String stringExtra = activity.getIntent().getStringExtra(ComposerConstants.ARG_MDE_COEDIT_INVITE_URL);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        String str = TAG;
        Logger.m11003i(str, "sharePublicLink#");
        activity.getIntent().removeExtra(ComposerConstants.ARG_MDE_COEDIT_INVITE_URL);
        if (this.mSubManager.getComposerModel().getMdeManager().getMdeInfo().isStandAlone()) {
            spaceName = "Group://Standalone " + this.mSubManager.getComposerModel().getMdeManager().getMdeInfo().getSpaceName();
        } else {
            spaceName = this.mSubManager.getComposerModel().getMdeManager().getMdeInfo().getSpaceName();
        }
        Intent intentForShareViaInvitationLink = new OpenSessionApi().getIntentForShareViaInvitationLink(activity, 501, spaceName, stringExtra);
        if (intentForShareViaInvitationLink == null) {
            Logger.m11004w(str, "sharePublicLink# intent is null");
        } else {
            activity.startActivity(intentForShareViaInvitationLink);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInitProgress() {
        showInitProgress(null);
    }

    public boolean startCoedit(final Activity activity, final NotesDocument<SpenWordDocument> notesDocument) {
        return this.mSubManager.getComposerModel().getCoeditAdapter().waitConnection(new CoeditAdapter.ConnectionCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ConnectionCallback
            public void onConnected() {
                CoeditStarter.this.attachCoeditNote(activity, notesDocument);
            }
        });
    }

    public void startCoeditWithChangedNote(NotesDocument<SpenWordDocument> notesDocument, Runnable runnable) {
        Logger.m10999d(TAG, "startCoeditWithChangedNote# ");
        CoeditAdapter coeditAdapter = this.mSubManager.getComposerModel().getCoeditAdapter();
        this.mSubManager.getComposerModel().getMdeManager().initMdeInfoResolver(true);
        if (coeditAdapter.waitConnection(new C992511(notesDocument, coeditAdapter, runnable))) {
            return;
        }
        this.mComposerCloser.finish("startCoeditWithChangedNote# fail waiting");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInitProgress(final Runnable runnable) {
        final String uuid = this.mSubManager.getComposerModel().getDocInfo().getUuid();
        this.mSubManager.getControllerManager().getProgressController().showProgress(0, 5);
        this.mSubManager.getControllerManager().getProgressController().setOnCancelListener(new ProgressController.OnCancelListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.6
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ProgressController.OnCancelListener
            public void onCancel(Task.ICancelCallback iCancelCallback) {
                if (CoeditHandlerManager.getInstance().isCoeditInitializing(uuid)) {
                    Logger.m11003i(CoeditStarter.TAG, "onCancel# ignore");
                    return;
                }
                CoeditStarter.this.hideInitProgress();
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
                CoeditStarter.this.mSubManager.getMenuPresenterManager().finish("CoeditStarter cancel");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reopenCoedit(final String str) {
        int i;
        if (this.mSubManager.getControllerManager().getSoftInputManager().isInputMethodShown() || this.mSubManager.getMenuPresenterManager().getListPresenter().isShowing()) {
            Logger.m11003i(TAG, "reopenCoedit# delay");
            i = 500;
        } else {
            i = 0;
        }
        showInitProgress();
        readyReopen();
        this.mSubManager.getCompViewPresenter().getView().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.9
            @Override // java.lang.Runnable
            public void run() {
                if (CommonUtil.isNotAvailableActivity(CoeditStarter.this.mSubManager.getComposerLifeState().getActivity())) {
                    Logger.m11000e(CoeditStarter.TAG, "reopenCoedit# isNotAvailableActivity");
                    return;
                }
                CoeditStarter.this.mSaveInstance = new Bundle();
                CoeditStarter.this.mSubManager.onSaveInstanceState(CoeditStarter.this.mSaveInstance, false, false);
                CoeditStarter.this.mContract.getView().releaseComposerView(new Callback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.CoeditStarter.9.1
                    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.common.Callback
                    public void onDone(@Nullable Object obj) {
                        CoeditStarter.this.mSubManager.getComposerModel().getDoc().selectObject((SpenObjectBase) null);
                        RunnableC99349 runnableC99349 = RunnableC99349.this;
                        CoeditStarter.this.requestReopen(str);
                    }
                });
            }
        }, i);
    }
}
