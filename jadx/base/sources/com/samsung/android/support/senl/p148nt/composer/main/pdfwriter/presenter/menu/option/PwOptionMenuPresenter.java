package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.menu.option;

import android.content.Intent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.EntryAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskMakePdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.ShareMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PdfFileInfo;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwDocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwFileManager;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.dialog.PwAddToNoteBottomView;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.task.PwTaskConvertToNote;
import com.samsung.android.support.senl.p148nt.model.repository.pdfwriter.PDFWriterRepositoryFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwOptionMenuPresenter extends OptionMenuPresenter implements PwComposerModel.ISaveDelegate {
    private static final String TAG = Logger.createTag("PwOptionMenuPresenter");
    private SpenPreTouchListenerImpl.PreTouchListener mPreTouchListener;
    private PwAddToNoteBottomView mPwAddToNoteBottomView;
    private Runnable mRunnableToShowBottomView;
    private RunnableToShowBottomViewForEdge mRunnableToShowBottomViewForEdge;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RunnableToShowBottomViewForEdge implements Runnable {
        private boolean mIsUpDirection;

        public /* synthetic */ RunnableToShowBottomViewForEdge(PwOptionMenuPresenter pwOptionMenuPresenter, int i) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!((OptionMenuPresenter) PwOptionMenuPresenter.this).mComposerViewPresenter.isEdgeState(this.mIsUpDirection) || PwOptionMenuPresenter.this.mPwAddToNoteBottomView == null || PwOptionMenuPresenter.this.mPwAddToNoteBottomView.isShowing()) {
                return;
            }
            PwOptionMenuPresenter.this.showBottomView();
        }

        public void setUpDirection(boolean z) {
            this.mIsUpDirection = z;
        }

        private RunnableToShowBottomViewForEdge() {
        }
    }

    public PwOptionMenuPresenter(@NonNull OptionMenuPresenter.ComponentFactory componentFactory) {
        super(componentFactory);
    }

    private void addPreTouchListener() {
        if (this.mPreTouchListener == null) {
            this.mRunnableToShowBottomView = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.menu.option.PwOptionMenuPresenter.3
                @Override // java.lang.Runnable
                public void run() {
                    if (PwOptionMenuPresenter.this.mPwAddToNoteBottomView == null) {
                        return;
                    }
                    if (PwOptionMenuPresenter.this.mPwAddToNoteBottomView.isShowing()) {
                        PwOptionMenuPresenter.this.mPwAddToNoteBottomView.hide(true);
                    } else {
                        PwOptionMenuPresenter.this.showBottomView();
                    }
                }
            };
            this.mRunnableToShowBottomViewForEdge = new RunnableToShowBottomViewForEdge(this, 0);
            final GestureDetector gestureDetector = new GestureDetector(this.mActivity, new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.menu.option.PwOptionMenuPresenter.4
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f, float f4) {
                    Logger.m10999d(PwOptionMenuPresenter.TAG, "onFling#  isEdgeState y  : / velocityY =" + f4);
                    if (PwOptionMenuPresenter.this.mPwAddToNoteBottomView != null && PwOptionMenuPresenter.this.mPwAddToNoteBottomView.isShowing()) {
                        PwOptionMenuPresenter.this.mPwAddToNoteBottomView.hide(true);
                    }
                    if (Math.abs(f) > Math.abs(f4)) {
                        return false;
                    }
                    if (((OptionMenuPresenter) PwOptionMenuPresenter.this).mComposerViewPresenter.isEdgeState(f4 >= 0.0f)) {
                        PwOptionMenuPresenter.this.showBottomView();
                        return false;
                    }
                    PwOptionMenuPresenter.this.mRunnableToShowBottomViewForEdge.setUpDirection(f4 >= 0.0f);
                    ((OptionMenuPresenter) PwOptionMenuPresenter.this).mComposerViewPresenter.setZoomRunnableAfterZoom(PwOptionMenuPresenter.this.mRunnableToShowBottomViewForEdge);
                    return false;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
                    if (PwOptionMenuPresenter.this.mPwAddToNoteBottomView != null && PwOptionMenuPresenter.this.mPwAddToNoteBottomView.isAnimationRunning()) {
                        return false;
                    }
                    ((OptionMenuPresenter) PwOptionMenuPresenter.this).mComposerViewPresenter.getHandler().postDelayed(PwOptionMenuPresenter.this.mRunnableToShowBottomView, (((OptionMenuPresenter) PwOptionMenuPresenter.this).mComposerViewPresenter.getPdfManager().hasSelectedText() || ((OptionMenuPresenter) PwOptionMenuPresenter.this).mComposerViewPresenter.getTextManager().isSelected()) ? 100L : 0L);
                    return false;
                }
            });
            this.mPreTouchListener = new SpenPreTouchListenerImpl.PreTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.menu.option.PwOptionMenuPresenter.5
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl.PreTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        ((OptionMenuPresenter) PwOptionMenuPresenter.this).mComposerViewPresenter.clearZoomRunnableAfterZoom();
                    }
                    gestureDetector.onTouchEvent(motionEvent);
                    return false;
                }
            };
        }
        this.mComposerViewPresenter.getListenerManager().addPreTouchListener(this.mPreTouchListener);
    }

    private void addToNoteWithTranslation() {
        saveAsNewNoteWithTranslation(new RunnableC9767a(this, 22));
    }

    private void insertPDFWriterRepository() {
        PdfFileInfo pdfFileInfo = ((PwDocInfo) this.mComposerModel.getDocInfo()).getPdfFileInfo();
        if (pdfFileInfo.getPath().isEmpty()) {
            return;
        }
        PDFWriterRepositoryFactory.createPDFWriterRepository().insert(this.mComposerModel.getDocState().getUuid(), pdfFileInfo.getPath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addToNoteWithTranslation$0() {
        this.mComposerModel.discard(true);
        new PwFileManager().deleteCache(this.mComposerModel.getDocInfo().getDocPath(), this.mComposerModel.getDocInfo().getUuid());
    }

    private void removeCallbacks() {
        this.mComposerViewPresenter.clearZoomRunnableAfterZoom();
        this.mComposerViewPresenter.getHandler().removeCallbacks(this.mRunnableToShowBottomView);
    }

    private void removePreTouchListener() {
        if (this.mPreTouchListener != null) {
            this.mComposerViewPresenter.getListenerManager().removePreTouchListener(this.mPreTouchListener);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter
    public void attachBottomView() {
        if (isNeedToShowConvertToNoteBtn() && this.mPwAddToNoteBottomView == null) {
            Logger.m10999d(TAG, "attachBottomView# ");
            this.mPwAddToNoteBottomView = new PwAddToNoteBottomView(this.mActivity, new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.menu.option.PwOptionMenuPresenter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PwOptionMenuPresenter.this.onClickConvertToNoteBtn();
                    ComposerSA.insertLog(((OptionMenuPresenter) PwOptionMenuPresenter.this).mComposerModel.getModeManager().isEditMode() ? ComposerSAConstants.SCREEN_PDF_VIEWER_EDIT : ComposerSAConstants.SCREEN_PDF_VIEWER, ComposerSAConstants.EVENT_PDF_VIEWER_ADD_TO_NOTE, "b");
                }
            });
        }
    }

    public void clearPwAddToNoteBottomView() {
        removePreTouchListener();
        hidePwAddToNoteBottomView(true);
        this.mPwAddToNoteBottomView = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter
    public void hideBottomMenu() {
        hidePwAddToNoteBottomView(true);
    }

    public void hidePwAddToNoteBottomView() {
        Logger.m11003i(TAG, "hidePwAddToNoteBottomView#");
        removeCallbacks();
        removePreTouchListener();
        hidePwAddToNoteBottomView(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter
    public boolean isNeedToShowBottomView() {
        return (EntryAction.isEditModeAction(this.mActivity.getIntent()) || this.mAiMenuManager.isShowingMenu()) ? false : true;
    }

    public boolean isNeedToShowConvertToNoteBtn() {
        return (!this.mComposerModel.isEditable() || this.mComposerModel.getComposerState().isSecured() || this.mComposerModel.isSimpleMode()) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter
    public void onClickConvertToNoteBtn() {
        boolean z = this.mComposerModel.isPDFReader() && isTranslationOverlayActivated();
        String str = TAG;
        AbstractC8014b.m7220v("onClickConvertToNoteBtn# PdfReaderWithTranslationOverlay : ", str, z);
        if (z && !this.mComposerViewPresenter.getPdfManager().isAvailableAddToNoteWithTranslation()) {
            this.mComposerViewPresenter.getDialogPresenterManager().showCanNotAddToNoteDialog();
            return;
        }
        if (!this.mComposerModel.isEditable() || this.mComposerModel.getComposerState().isSecured()) {
            Logger.m11000e(str, "onClickConvertToNoteBtn# skip");
            return;
        }
        hidePwAddToNoteBottomView(true);
        if (z && (this.mComposerViewPresenter.getPdfManager().hasOverlayImage() || !isSameLanguageForTranslationOverlay())) {
            if (NotificationUtils.checkedNotificationPermissions(this.mActivity, 135)) {
                addToNoteWithTranslation();
            }
        } else {
            final String strNewUUID = UUIDUtils.newUUID(this.mActivity);
            this.mControllerManager.getTaskController().execute(new PwTaskConvertToNote(), new PwTaskConvertToNote.InputValues(strNewUUID, this.mComposerViewPresenter.getComposerModel()), new Task.Callback<PwTaskConvertToNote.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.menu.option.PwOptionMenuPresenter.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onError(PwTaskConvertToNote.ResultValues resultValues) {
                    if (resultValues == null || !resultValues.isCanceled()) {
                        ToastHandler.show(((OptionMenuPresenter) PwOptionMenuPresenter.this).mActivity, C9086R.string.composer_failed_to_copy, 0);
                    }
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onSuccess(PwTaskConvertToNote.ResultValues resultValues) {
                    if (resultValues == null || !resultValues.isCanceled()) {
                        ((OptionMenuPresenter) PwOptionMenuPresenter.this).mComposerModel.discard(true);
                        new PwFileManager().deleteCache(((OptionMenuPresenter) PwOptionMenuPresenter.this).mComposerModel.getDocInfo().getDocPath(), ((OptionMenuPresenter) PwOptionMenuPresenter.this).mComposerModel.getDocInfo().getUuid());
                        Intent intent = new Intent(((OptionMenuPresenter) PwOptionMenuPresenter.this).mActivity, ComposerAccessHandler.getComposerActivityClass());
                        intent.addFlags(403177472);
                        intent.setAction(ComposerConstants.ACTION_OPEN_MEMO);
                        intent.putExtra("sdoc_uuid", strNewUUID);
                        intent.putExtra(ComposerConstants.ARG_USE_VIEW_MODE, false);
                        ((OptionMenuPresenter) PwOptionMenuPresenter.this).mActivity.startActivity(intent);
                        ((OptionMenuPresenter) PwOptionMenuPresenter.this).mComposerViewPresenter.getHandler().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.menu.option.PwOptionMenuPresenter.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (((OptionMenuPresenter) PwOptionMenuPresenter.this).mMenuManager != null) {
                                    ((OptionMenuPresenter) PwOptionMenuPresenter.this).mMenuManager.finish("onClickConvertToNoteBtn");
                                }
                            }
                        });
                    }
                }
            }, false, true);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter
    public void onClickEditBtn(int i) {
        StorageChecker storageChecker = new StorageChecker();
        storageChecker.setContext(this.mActivity);
        storageChecker.setNote(this.mComposerModel.getDoc());
        if (storageChecker.checkAvailableStateToEdit(true, true, false) != 0) {
            Logger.m11000e(TAG, "onClickEditBtn# over 1GB");
            return;
        }
        hidePwAddToNoteBottomView(true);
        this.mComposerModel.getModeManager().setMode(Mode.Writing, "onClickEditBtn", true);
        insertPDFWriterRepository();
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_PDF_VIEWER, ComposerSAConstants.EVENT_PDF_VIEWER_EDIT, i == 1 ? "1" : "2");
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_PDF_VIEWER, ComposerSAConstants.EVENT_PDF_VIEWER_EDIT_PAGE_COUNT, this.mComposerModel.isSingleMode() ? 1 : this.mComposerModel.getDoc().getPageCount() - 1);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter
    public void onClickSave() {
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_PDF_VIEWER_EDIT, ComposerSAConstants.EVENT_PDF_VIEWER_SAVE);
        this.mComposerViewPresenter.setContextMenu(false);
        save(null);
    }

    public void onClickSaveForOverlay() {
        Logger.m11003i(TAG, "onClickSaveForOverlay#");
        this.mComposerViewPresenter.setContextMenu(false);
        save(null);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter
    public void onDetachView() {
        clearPwAddToNoteBottomView();
        super.onDetachView();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter
    public void onPostInitialized() {
        super.onPostInitialized();
        ((PwComposerModel) this.mComposerModel).setSaveDelegate(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter
    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i != 135) {
            return super.onRequestPermissionsResult(i, strArr, iArr);
        }
        if (PermissionHelper.verifyRequestResult(this.mActivity, iArr, strArr)) {
            addToNoteWithTranslation();
            return true;
        }
        Logger.m10999d(TAG, "onRequestPermissionsResult# PERMISSION_REQUEST_FOR_TRANSLATION_NOTIFICATION_ON_PDF_READER not verified");
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter
    public void onTranslationStateUpdated(int i) {
        if (this.mComposerModel.getModeManager().isMode(Mode.Search) && i != 0) {
            this.mComposerModel.getModeManager().setMode(Mode.View, "translationState", true);
        }
        this.mMenuManager.invalidateOptionsMenu();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.pdfwriter.model.PwComposerModel.ISaveDelegate
    public void save(Runnable runnable) {
        clearSelectionForEachMode();
        if (isTranslationOverlayActivated()) {
            this.mComposerViewPresenter.getDialogPresenterManager().showTurnOffTranslationDialog(0);
            return;
        }
        if (!((PwComposerModel) this.mComposerModel).isChangedDocStateWithSnapSavedDataAndDirty()) {
            Logger.m11003i(TAG, "isChangedDocStateWithSnapSavedData#");
            this.mComposerModel.getModeManager().setMode(Mode.View, "save#notchanged", true);
            return;
        }
        PdfFileInfo pdfFileInfo = ((PwDocInfo) this.mComposerModel.getDocInfo()).getPdfFileInfo();
        ((PwOptionMenuSharePresenter) this.mOptionMenuSharePresenter).setSaveCallback(runnable);
        ((PwOptionMenuSharePresenter) this.mOptionMenuSharePresenter).setSaveFlag(true);
        this.mOptionMenuSharePresenter.setShareType(ShareMenuContract.ShareType.PDF);
        this.mOptionMenuSharePresenter.setPdfShareType(TaskMakePdf.PdfShareType.NOTES_COMPAT);
        if (pdfFileInfo.isSaveAs()) {
            this.mOptionMenuSharePresenter.executeSaveDirectoryPicker();
        } else {
            this.mOptionMenuSharePresenter.makeNotCorruptShareNote(pdfFileInfo.getPath(), this.mOptionMenuSharePresenter.getShareData());
        }
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_PDF_VIEWER_EDIT, ComposerSAConstants.EVENT_PDF_VIEWER_EDIT_PAGE_COUNT, this.mComposerModel.isSingleMode() ? 1 : this.mComposerModel.getDoc().getPageCount() - 1);
    }

    public void showBottomView() {
        PwAddToNoteBottomView pwAddToNoteBottomView;
        if (this.mComposerModel.isSupportedViewMode()) {
            addPreTouchListener();
        }
        if (!isNeedToShowBottomView() || (pwAddToNoteBottomView = this.mPwAddToNoteBottomView) == null) {
            return;
        }
        pwAddToNoteBottomView.show();
    }

    public void showPwAddToNoteBottomView() {
        if (isNeedToShowConvertToNoteBtn()) {
            if (this.mPwAddToNoteBottomView == null) {
                attachBottomView();
            } else {
                showBottomView();
            }
        }
    }

    public void hidePwAddToNoteBottomView(boolean z) {
        PwAddToNoteBottomView pwAddToNoteBottomView = this.mPwAddToNoteBottomView;
        if (pwAddToNoteBottomView == null) {
            return;
        }
        pwAddToNoteBottomView.hide(z);
    }
}
