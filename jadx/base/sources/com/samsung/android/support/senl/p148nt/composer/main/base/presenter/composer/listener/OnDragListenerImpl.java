package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.PointF;
import android.net.Uri;
import android.text.TextUtils;
import android.view.DragEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.AbstractC0622a;
import androidx.core.app.ActivityCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import androidx.fragment.app.Fragment;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.media.AudioManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DragAutoScroll;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DragEventDispatcher;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DragEventDispatcherToAiResultLayout;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DragInfo;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DragNDropConstant;
import com.samsung.android.support.senl.p148nt.base.composer.drag.InternalDropLogic;
import com.samsung.android.support.senl.p148nt.base.composer.focus.FocusManager;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTypeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DragAndDropInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ScrollController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskPaste;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import java.util.ArrayList;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OnDragListenerImpl implements View.OnDragListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = Logger.createTag("OnDragListenerImpl");
    FocusManager focusManager;
    AutoScroll mAutoScroll;
    DragEventDispatcher mDragEventDispatcher;
    DragEventDispatcherToAiResultLayout mDragEventDispatcherToAiResultLayout;
    DragInfo mDragInfo;
    private DragAndDropPermissionsCompat mDropPermissions;
    private AudioManagerCompat.SoundManager mHapticDetachSound;
    InternalDropLogic mInternalDropLogic;
    protected ModeManager mModeManager;
    private final NoteManager mNoteManager;
    private final ObjectManager mObjectManager;
    private final PageManager mPageManager;
    private final PdfManager mPdfManager;
    private final ListenerImplContract.IPresenter mPresenter;
    private final QuickSaveTimerController mQuickSaveTimerController;
    private final ScrollController mScrollController;
    private final SoftInputManager mSoftInputManager;
    private final TaskController mTaskController;
    private final TextManager mTextManager;
    private final SpenWNote mWNote;
    private final DragAndDropInfo mDragAndDropInfo = new DragAndDropInfo();
    private boolean mHasAudioContent = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AutoScroll extends DragAutoScroll {
        public AutoScroll(@NonNull String str) {
            super(str);
        }

        @Override // com.samsung.android.support.senl.p148nt.base.composer.drag.DragAutoScroll
        public boolean canScroll() {
            if (!OnDragListenerImpl.this.isCursorDragMode()) {
                return true;
            }
            SpenObjectTextBox bodyText = OnDragListenerImpl.this.mWNote.getBodyText();
            if (bodyText != null && !TextUtils.isEmpty(bodyText.getText())) {
                return true;
            }
            Logger.m11000e(OnDragListenerImpl.TAG, "autoScroll# bodyText is empty");
            return false;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.composer.drag.DragAutoScroll
        public void setPan(@NonNull PointF pointF) {
            OnDragListenerImpl.this.mPresenter.getComposerControllerManager().getScrollController().setPan(pointF);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DropLogicFunc extends InternalDropLogic.InjectedFunction {
        public DropLogicFunc() {
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.drag.InternalDropLogic.InjectedFunction
        public int getCursorIndex(@NonNull SpenObjectShape spenObjectShape, @NonNull PointF pointF) {
            return OnDragListenerImpl.this.mTextManager.getCursorIndex(spenObjectShape, pointF);
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.drag.InternalDropLogic.InjectedFunction
        public boolean isCursorDragMode() {
            return OnDragListenerImpl.this.isCursorDragMode();
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.drag.InternalDropLogic.InjectedFunction
        public boolean isObjectSpanOptionEnabled() {
            return OnDragListenerImpl.this.mObjectManager.isObjectSpanOptionEnabled();
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.drag.InternalDropLogic.InjectedFunction
        public void setTargetTextBoxFocus(@NonNull SpenObjectShape spenObjectShape, int i) {
            OnDragListenerImpl.this.mObjectManager.selectObject(spenObjectShape);
            OnDragListenerImpl.this.mTextManager.setFocusedTextBox(spenObjectShape);
            spenObjectShape.setCursorPosition(i);
            OnDragListenerImpl.this.mObjectManager.getSelectedObjectManager().setFocus(true);
        }
    }

    public OnDragListenerImpl(ListenerImplContract.IPresenter iPresenter, ControllerManager controllerManager) {
        String str = TAG;
        this.mDragInfo = new DragInfo(str);
        this.mAutoScroll = new AutoScroll(str);
        this.mPresenter = iPresenter;
        this.mObjectManager = iPresenter.getObjectManager();
        this.mNoteManager = iPresenter.getNoteManager();
        this.mPageManager = iPresenter.getPageManager();
        this.mModeManager = iPresenter.getComposerModel().getModeManager();
        this.mTextManager = iPresenter.getTextManager();
        this.mPdfManager = iPresenter.getPdfManager();
        this.mScrollController = iPresenter.getComposerControllerManager().getScrollController();
        this.mSoftInputManager = controllerManager.getSoftInputManager();
        this.mTaskController = controllerManager.getTaskController();
        this.mQuickSaveTimerController = controllerManager.getQuickSaveTimer();
        SpenWNote note = iPresenter.getNoteManager().getNote();
        this.mWNote = note;
        this.mHapticDetachSound = AudioManagerCompat.getInstance().createHapticDetachSound(iPresenter.getActivity());
        this.mInternalDropLogic = new InternalDropLogic(str, note, this.mDragInfo, new DropLogicFunc(), DocumentPageRatio.PAGE_RATIO.getPageRatio());
    }

    private void autoScroll(float f, float f4) {
        this.mAutoScroll.autoScroll(f, f4, this.mPresenter.getComposerControllerManager().getScrollController().getPan());
    }

    private boolean canDrop(ClipData clipData) {
        if (clipData == null || clipData.getDescription() == null) {
            Logger.m11000e(TAG, "canDrop#clip data is null");
            return false;
        }
        if (this.mDragInfo.getClipType() == 0) {
            this.mDragInfo.setClipType(getClipType(clipData.getDescription()));
        }
        if (this.mDragInfo.getClipType() == -1) {
            Logger.m11003i(TAG, "canDrop# ClipType is unsupported.");
            DragNDropConstant.showDropFailMessage(this.mPresenter.getActivity());
            return false;
        }
        if (this.mDragInfo.isIgnoredLabel(clipData.getDescription())) {
            Logger.m11003i(TAG, "canDrop# isIgnoredLabel.");
            return false;
        }
        if (!this.mModeManager.isEditMode()) {
            Logger.m11003i(TAG, "canDrop# isEditMode is false.");
            return false;
        }
        if (isEditableState()) {
            return true;
        }
        Logger.m11003i(TAG, "canDrop# isEditableState is false.");
        return false;
    }

    private void clearInfo() {
        this.mInternalDropLogic.clear();
        this.mDragAndDropInfo.clear();
        this.mDragInfo.clear();
    }

    private int getClipType(ClipDescription clipDescription) {
        if (clipDescription == null) {
            Logger.m11000e(TAG, "getClipType, description is null");
            return -1;
        }
        CharSequence label = clipDescription.getLabel();
        this.mDragInfo.parseLabel(label == null ? null : label.toString(), this.mPresenter.hashCode());
        if (this.mDragInfo.getIsInternalLabel()) {
            return getInternalCaseClipType();
        }
        int mimeTypeCount = clipDescription.getMimeTypeCount();
        AbstractC0000a.m3D(mimeTypeCount, "getClipType, mimeTypeCount: ", TAG);
        for (int i = 0; i < mimeTypeCount; i++) {
            String mimeType = clipDescription.getMimeType(i);
            Logger.m10999d(TAG, "getClipType, index: " + i + ", mimeType: " + mimeType);
            if (ImageUtil.isImageMimeType(mimeType) || isAudioType(mimeType) || mimeType.startsWith(Constants.MIME_PDF)) {
                return 1;
            }
            if (mimeType.contains("text/")) {
                return 2;
            }
        }
        return -1;
    }

    private int getInternalCaseClipType() {
        if (this.mPdfManager.hasSelectedText()) {
            return 2;
        }
        return (!this.mObjectManager.isFocusedTextBox() || TextUtils.isEmpty(this.mTextManager.getSelectedText())) ? 1 : 2;
    }

    private boolean internalDnD() {
        return this.mInternalDropLogic.internalDnD();
    }

    private boolean isAudioType(String str) {
        return str.startsWith(Constants.MIME_AUDIO_START) || str.contains("application/ogg");
    }

    private boolean isAvailableDrag(int i, int i2) {
        if (i2 == i || isVertical()) {
            return true;
        }
        if (isTwoPage()) {
            return i == 0 || i2 == 0 || i / 2 == i2 / 2;
        }
        return false;
    }

    private boolean isAvailableToAddMM(ClipData clipData) {
        String mimeType;
        int itemCount = clipData.getItemCount();
        boolean zIsMultiplePdf = isMultiplePdf();
        int i = 0;
        int i2 = 0;
        for (int i4 = 0; i4 < itemCount && i4 <= 210; i4++) {
            Uri uri = clipData.getItemAt(i4).getUri();
            if (uri != null && (mimeType = UriFileUtils.getMimeType(this.mPresenter.getActivity(), uri)) != null) {
                if (mimeType.startsWith(Constants.MIME_AUDIO_START)) {
                    i++;
                    this.mHasAudioContent = true;
                    if (i > 1) {
                        ToastHandler.show(this.mPresenter.getActivity(), this.mPresenter.getActivity().getResources().getQuantityString(C9086R.plurals.drag_and_drop_only_one_audio, 1, 1), 1);
                        return false;
                    }
                }
                if (mimeType.startsWith(Constants.MIME_PDF)) {
                    i2++;
                    if (!zIsMultiplePdf && i2 > 1) {
                        ToastHandler.show(this.mPresenter.getActivity(), this.mPresenter.getActivity().getResources().getQuantityString(C9086R.plurals.drag_and_drop_only_one_pdf, 1, 1), 0);
                        return false;
                    }
                } else {
                    continue;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCursorDragMode() {
        if (!this.mModeManager.isEditMode()) {
            this.mObjectManager.clearSelection();
            return false;
        }
        if (this.mModeManager.getMode() == Mode.Writing) {
            return false;
        }
        if (this.mDragInfo.getClipType() == 2) {
            return true;
        }
        return this.mInternalDropLogic.isDropContentObjectSpan();
    }

    private boolean isDisabled() {
        if (this.mModeManager.isDeleteOnlyMode()) {
            return true;
        }
        return (this.mModeManager.isComposerViewMode() && !this.mPresenter.getComposerModel().getCoeditAdapter().takeServerWritePermission()) || this.mPresenter.getComposerModel().isRunningDrawing();
    }

    private boolean isMultiplePdf() {
        return !this.mPresenter.getComposerModel().getCoeditAdapter().isCoeditNote();
    }

    private boolean isTwoPage() {
        return this.mPresenter.getComposerControllerManager().getCvPageSettingController().getPageLayoutState().isTwoPage();
    }

    private boolean isVertical() {
        return this.mPresenter.getComposerControllerManager().getCvPageSettingController().getPageLayoutState().isVertical();
    }

    private void onDragEnded() {
        smoothScrollToFitPage();
        this.mQuickSaveTimerController.unLock(QuickSaveTimerController.Tag.OnDragAndDrop);
        clearInfo();
    }

    private boolean onDragLocation(DragEvent dragEvent) {
        ClipDescription clipDescription = dragEvent.getClipDescription();
        if (clipDescription != null && this.mDragInfo.isIgnoredLabel(clipDescription)) {
            Logger.m11003i(TAG, "onDragLocation# isIgnoredLabel.");
            return false;
        }
        if (!isEditableStateOnly()) {
            Logger.m11003i(TAG, "onDragLocation# isEditableState is false.");
            return false;
        }
        if (!this.mPresenter.getView().hasFocus()) {
            Logger.m11003i(TAG, "onDragLocation# no focus");
            FocusManager focusManager = this.focusManager;
            if (focusManager == null || !focusManager.hasFocus(focusManager.mainTarget)) {
                return false;
            }
            this.focusManager.mainTarget.requestFocus();
        }
        if (this.mDragInfo.getStartPosition() == null) {
            DragInfo dragInfo = this.mDragInfo;
            dragInfo.setStartPosition(dragInfo.getDragPosition());
            setEditMode();
        }
        DragInfo dragInfo2 = this.mDragInfo;
        dragInfo2.setTargetObject(this.mInternalDropLogic.getPositionObject(dragInfo2.getDragPosition()));
        if (this.mModeManager.getMode() == Mode.Writing) {
            autoScroll(dragEvent.getX(), dragEvent.getY());
            return true;
        }
        if (!isCursorDragMode()) {
            return false;
        }
        SpenObjectBase targetObject = this.mDragInfo.getTargetObject();
        if (targetObject != null && !ObjectTypeUtil.isTextType(targetObject.getType())) {
            targetObject = this.mWNote.getBodyText();
        }
        this.mWNote.selectObject(targetObject);
        int currentPageIndex = this.mPageManager.getDocPageInfo().getCurrentPageIndex();
        int pageIndexByXY = this.mObjectManager.getPageIndexByXY(this.mDragInfo.getDragPosition().x, this.mDragInfo.getDragPosition().y);
        if (isAvailableDrag(currentPageIndex, pageIndexByXY)) {
            DragInfo dragInfo3 = this.mDragInfo;
            SpenObjectShape spenObjectShape = (SpenObjectShape) targetObject;
            dragInfo3.setTargetObjectCursor(this.mTextManager.getCursorIndex(spenObjectShape, dragInfo3.getDragPosition()));
            spenObjectShape.setCursorPosition(this.mDragInfo.getTargetObjectCursor());
        } else {
            String str = TAG;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(currentPageIndex, pageIndexByXY, "onDragLocation# drag position is wrong. currentPageIndex:", ", pageIndexDragPosition:", ", isTwoPage:");
            sbM1173s.append(isTwoPage());
            sbM1173s.append(", isVertical:");
            AbstractC8014b.m7222x(sbM1173s, isVertical(), str);
        }
        this.mObjectManager.getSelectedObjectManager().setFocus(true);
        this.mTextManager.setCursorBlink(true);
        autoScroll(dragEvent.getX(), dragEvent.getY());
        return true;
    }

    private void onDragStarted(View view, DragEvent dragEvent) {
        this.mQuickSaveTimerController.lock(QuickSaveTimerController.Tag.OnDragAndDrop);
        ClipDescription clipDescription = dragEvent.getClipDescription();
        if (this.mDragInfo.getClipType() == 0) {
            this.mDragInfo.setClipType(getClipType(clipDescription));
        }
        if (this.mDragInfo.getClipType() == -1) {
            Logger.m11000e(TAG, "dragStarted#clip data is not supported.");
            return;
        }
        if (this.mDragInfo.isIgnoredLabel(clipDescription)) {
            return;
        }
        this.mDragAndDropInfo.setEnable(true);
        if (this.mDragInfo.getIsInternalLabel()) {
            AudioManagerCompat.SoundManager soundManager = this.mHapticDetachSound;
            if (soundManager != null) {
                soundManager.play();
            }
            ViewCompat.getInstance().performHapticFeedback(view, 108);
            this.mInternalDropLogic.setBackupObjList(new ArrayList<>(this.mObjectManager.getSelectedObjectList()));
            if (this.mObjectManager.getSelectedObjectManager().getSelectedObjectPageList() != null) {
                this.mInternalDropLogic.setBackupPageList(new ArrayList(this.mObjectManager.getSelectedObjectManager().getSelectedObjectPageList()));
            }
        }
        this.mAutoScroll.onDragStarted(view);
        this.mDragInfo.setStartPosition(null);
    }

    private boolean onDrop(DragEvent dragEvent) {
        if (!isCursorDragMode()) {
            if (this.mDragInfo.getDragPosition().x < 0.0f || this.mDragInfo.getDragPosition().y < 0.0f) {
                Logger.m11000e(TAG, "onDrop# drop position is wrong : " + this.mDragInfo.getDragPosition());
                return true;
            }
            if (!this.mObjectManager.isValidPosition(this.mDragInfo.getDragPosition())) {
                Logger.m11000e(TAG, "onDrop# drop position is wrong : " + this.mDragInfo.getDragPosition() + ", maxWidth:" + this.mWNote.getPageLayoutWidth() + "maxHeight:" + this.mWNote.getPageLayoutHeight());
                return true;
            }
        }
        ClipData clipData = dragEvent.getClipData();
        boolean zPasteClip = false;
        if (!canDrop(clipData)) {
            return false;
        }
        String str = TAG;
        Logger.m11003i(str, "onDrop# clipType: " + this.mDragInfo.getClipType());
        if (this.mDragInfo.getClipType() != 1 || this.mDragInfo.getIsInternalLabel()) {
            if (this.mDragInfo.getClipType() == 2 || this.mDragInfo.getIsInternalLabel()) {
                if (this.mDragInfo.getIsInternalLabel() && !internalDnD()) {
                    return false;
                }
                zPasteClip = pasteClip(clipData, true);
            }
        } else {
            if (!isAvailableToAddMM(clipData)) {
                return false;
            }
            requestDNDPermissions(dragEvent);
            zPasteClip = pasteClip(clipData, false);
        }
        AbstractC8014b.m7224z("onDrop, result: ", str, zPasteClip);
        if (zPasteClip) {
            this.mObjectManager.clearSelection();
        } else {
            DragNDropConstant.showDropFailMessage(this.mPresenter.getActivity());
        }
        return true;
    }

    private boolean pasteClip(ClipData clipData, boolean z) {
        PointF pointF;
        int currentPageIndex;
        boolean zIsPermissionGrantedWithoutNotice;
        String[] storagePermissions;
        String str = TAG;
        Logger.m11003i(str, "pasteClip# " + clipData + ", mDropPosition : " + this.mDragInfo.getDragPosition());
        if (clipData == null || clipData.getItemCount() == 0) {
            Logger.m11000e(str, "pasteClip# clipData is null or itemCount is 0");
            return false;
        }
        this.mPresenter.clearWritingToolControl();
        this.mDragAndDropInfo.setEnable(false);
        if (isCursorDragMode() && this.mObjectManager.isFocusedTextBox()) {
            currentPageIndex = this.mPageManager.getDocPageInfo().getCurrentPageIndex();
            pointF = null;
        } else {
            PointF dragPosition = this.mDragInfo.getDragPosition();
            int pageIndexByXY = this.mObjectManager.getPageIndexByXY(dragPosition.x, dragPosition.y);
            if (pageIndexByXY < 0) {
                Logger.m11000e(str, "pasteClip# getPageIndexByXY is wrong : " + pageIndexByXY + SQLKeyword.COMMA + dragPosition);
                pageIndexByXY = this.mPageManager.getDocPageInfo().getCurrentPageIndex();
            }
            pointF = dragPosition;
            currentPageIndex = pageIndexByXY;
        }
        TaskPaste.InputValues inputValues = new TaskPaste.InputValues(this.mPresenter.getActivity(), clipData, this.mPresenter.getComposerModel(), this.mObjectManager, this.mNoteManager, this.mPageManager, this.mTextManager, this.mPdfManager, currentPageIndex, pointF, true, this.mPresenter.getDialogPresenterManager(), new TaskPaste.ISoftInputController() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.OnDragListenerImpl.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskPaste.ISoftInputController
            public void blockToShow(boolean z2, String str2) {
                OnDragListenerImpl.this.mSoftInputManager.blockToShow(z2, str2);
            }
        });
        TaskPaste taskPaste = new TaskPaste();
        Task.Callback<TaskPaste.ResultValues> callback = new Task.Callback<TaskPaste.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.OnDragListenerImpl.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskPaste.ResultValues resultValues) {
                OnDragListenerImpl.this.resultPaste(resultValues);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskPaste.ResultValues resultValues) {
                OnDragListenerImpl.this.resultPaste(resultValues);
            }
        };
        if (z) {
            zIsPermissionGrantedWithoutNotice = z;
            storagePermissions = null;
        } else {
            storagePermissions = PermissionCompat.getStoragePermissions(this.mHasAudioContent ? 2 : 1);
            zIsPermissionGrantedWithoutNotice = PermissionHelper.isPermissionGrantedWithoutNotice(this.mPresenter.getActivity(), storagePermissions);
            this.mHasAudioContent = false;
        }
        if (zIsPermissionGrantedWithoutNotice) {
            this.mTaskController.execute(taskPaste, inputValues, callback, false);
        } else {
            Logger.m10999d(str, "to get WRITE_EXTERNAL_STORAGE permission");
            Fragment fragmentFindFragmentByTag = ((AppCompatActivity) this.mPresenter.getActivity()).getSupportFragmentManager().findFragmentByTag("Composer");
            if (fragmentFindFragmentByTag == null) {
                return false;
            }
            PermissionHelper.requestPermissions(fragmentFindFragmentByTag, 123, storagePermissions);
            this.mTaskController.setPendingTask(taskPaste, inputValues, callback, false);
        }
        return true;
    }

    private void releaseDNDPermissions() {
        if (this.mDropPermissions != null) {
            Logger.m11003i(TAG, "releaseDNDPermissions# Permissions released.");
            this.mDropPermissions.release();
            this.mDropPermissions = null;
        }
    }

    private void requestDNDPermissions(DragEvent dragEvent) {
        DragAndDropPermissionsCompat dragAndDropPermissionsCompatRequestDragAndDropPermissions = ActivityCompat.requestDragAndDropPermissions(this.mPresenter.getActivity(), dragEvent);
        this.mDropPermissions = dragAndDropPermissionsCompatRequestDragAndDropPermissions;
        if (dragAndDropPermissionsCompatRequestDragAndDropPermissions == null) {
            Logger.m11000e(TAG, "requestDNDPermissions# Drop permission request failed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resultPaste(TaskPaste.ResultValues resultValues) {
        resultValues.showErrorToast();
        if (resultValues.isUpdateInvertBG()) {
            this.mNoteManager.updateInvertBackgroundColor();
        }
        if (this.mInternalDropLogic.getBeginHistory()) {
            this.mWNote.endHistoryGroup();
            this.mInternalDropLogic.setBeginHistory(false);
        }
        releaseDNDPermissions();
    }

    private void setDragPosition(DragEvent dragEvent) {
        this.mDragInfo.setDragPosition(dragEvent, this.mDragAndDropInfo.getShadowViewWidth(), this.mDragAndDropInfo.getShadowViewHeight(), this.mScrollController.getDelta(), this.mScrollController.getScale(), isCursorDragMode());
        Logger.m10999d(TAG, "event# " + dragEvent.getAction() + " =  event(" + dragEvent.getX() + "/" + dragEvent.getY() + ")  drop(" + this.mDragInfo.getDragPosition().x + "/" + this.mDragInfo.getDragPosition().y + ")  ShadowView(" + this.mDragAndDropInfo.getShadowViewWidth() + "/" + this.mDragAndDropInfo.getShadowViewHeight() + ")");
    }

    private void setEditMode() {
        if (this.mModeManager.isEditMode() || this.mDragInfo.getIsInternalLabel()) {
            return;
        }
        if (this.mModeManager.isMode(Mode.ReadOnly) || this.mModeManager.isMode(Mode.View)) {
            this.mModeManager.setMode(Mode.Writing, AbstractC0622a.m1170p(TAG, "#DragAndDrop", new StringBuilder()), true);
        }
    }

    private void smoothScrollToFitPage() {
        if (isVertical()) {
            return;
        }
        Logger.m11003i(TAG, "smoothScrollToFitPage# ");
        this.mPresenter.getComposerControllerManager().getScrollController().smoothScrollToFitPage();
    }

    public DragAndDropInfo getDragAndDropInfo() {
        return this.mDragAndDropInfo;
    }

    public boolean isEditableState() {
        return this.mPresenter.getView().hasFocus() && isEditableStateOnly();
    }

    public boolean isEditableStateOnly() {
        ComposerModel composerModel = this.mPresenter.getComposerModel();
        return composerModel.isEditable() && !this.mTaskController.isRunning() && composerModel.getMdeInfo().hasWritePermission();
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        DragEventDispatcherToAiResultLayout dragEventDispatcherToAiResultLayout;
        DragEventDispatcherToAiResultLayout dragEventDispatcherToAiResultLayout2;
        setDragPosition(dragEvent);
        int action = dragEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                DragEventDispatcher dragEventDispatcher = this.mDragEventDispatcher;
                if ((dragEventDispatcher == null || !dragEventDispatcher.dispatchDragEvent(view, dragEvent)) && ((dragEventDispatcherToAiResultLayout = this.mDragEventDispatcherToAiResultLayout) == null || !dragEventDispatcherToAiResultLayout.dispatchDragEvent(view, dragEvent))) {
                    return onDragLocation(dragEvent);
                }
                return true;
            }
            if (action == 3) {
                DragEventDispatcher dragEventDispatcher2 = this.mDragEventDispatcher;
                if ((dragEventDispatcher2 == null || !dragEventDispatcher2.dispatchDragEvent(view, dragEvent)) && ((dragEventDispatcherToAiResultLayout2 = this.mDragEventDispatcherToAiResultLayout) == null || !dragEventDispatcherToAiResultLayout2.dispatchDragEvent(view, dragEvent))) {
                    return onDrop(dragEvent);
                }
                return true;
            }
            if (action == 4) {
                DragEventDispatcherToAiResultLayout dragEventDispatcherToAiResultLayout3 = this.mDragEventDispatcherToAiResultLayout;
                if (dragEventDispatcherToAiResultLayout3 != null && dragEventDispatcherToAiResultLayout3.dispatchDragEvent(view, dragEvent)) {
                    return true;
                }
                DragEventDispatcher dragEventDispatcher3 = this.mDragEventDispatcher;
                if (dragEventDispatcher3 != null) {
                    dragEventDispatcher3.dispatchDragEvent(view, dragEvent);
                }
                onDragEnded();
                return true;
            }
            if (action != 5) {
                return false;
            }
        }
        if (isDisabled()) {
            return false;
        }
        onDragStarted(view, dragEvent);
        DragEventDispatcher dragEventDispatcher4 = this.mDragEventDispatcher;
        if (dragEventDispatcher4 != null) {
            dragEventDispatcher4.dispatchDragEvent(view, dragEvent);
        }
        return true;
    }

    public void release() {
        this.mInternalDropLogic.clear();
        AudioManagerCompat.SoundManager soundManager = this.mHapticDetachSound;
        if (soundManager != null) {
            soundManager.release();
            this.mHapticDetachSound = null;
        }
    }

    public void setDragEventAIResultViewDispatcher(DragEventDispatcherToAiResultLayout dragEventDispatcherToAiResultLayout) {
        this.mDragEventDispatcherToAiResultLayout = dragEventDispatcherToAiResultLayout;
    }

    public void setDragEventDispatcher(DragEventDispatcher dragEventDispatcher) {
        this.mDragEventDispatcher = dragEventDispatcher;
    }

    public void setFocusManager(FocusManager focusManager) {
        this.focusManager = focusManager;
    }
}
