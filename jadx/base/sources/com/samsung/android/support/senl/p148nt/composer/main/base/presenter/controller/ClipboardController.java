package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller;

import android.app.Activity;
import android.content.ClipData;
import android.graphics.PointF;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.samsung.android.content.clipboard.SemClipboardManager;
import com.samsung.android.content.clipboard.data.SemClipData;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.AiMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskPaste;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.dex.DoPControlClipData;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ClipboardController implements View.OnFocusChangeListener {
    private static final boolean DEBUG = false;
    private static final String TAG = Logger.createTag("ClipboardController");
    private Activity mActivity;
    private AiMenuManager mAiMenuManager;
    private ComposerModel mComposerModel;
    private NoteManager mNoteManager;
    private ObjectManager mObjectManager;
    private PageManager mPageManager;
    private Object mPasteListener = null;
    private PdfManager mPdfManager;
    private SoftInputManager mSoftInputManager;
    private TaskController mTaskController;
    private TextManager mTextManager;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ClipboardController$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C92251 implements SemClipboardManager.OnPasteListener {
        public C92251() {
        }

        public void onPaste(@NonNull final SemClipData semClipData) {
            final View currentFocus = ClipboardController.this.mActivity.getCurrentFocus();
            ClipboardController.this.mActivity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ClipboardController.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ClipboardController.this.paste(currentFocus, ClipboardManagerCompat.INSTANCE.getInstance().getClipData(semClipData));
                }
            });
        }
    }

    private boolean isNeedPermission(ClipData clipData) {
        CharSequence label = clipData.getDescription().getLabel();
        if (DoPControlClipData.isDoPDrop(label == null ? null : label.toString())) {
            return !PermissionHelper.isPermissionGrantedWithoutNotice(this.mActivity, PermissionCompat.getStoragePermissions(3));
        }
        return false;
    }

    public void clearFilter(String str) {
        if (this.mActivity == null) {
            AbstractC8014b.m7197C("clearFilter# isNotAvailableActivity from : ", str, TAG);
            return;
        }
        AbstractC8014b.m7197C("clearFilter# from : ", str, TAG);
        ClipboardManagerCompat.Companion companion = ClipboardManagerCompat.INSTANCE;
        companion.getInstance().finishBind(this.mActivity);
        companion.getInstance().filterClip(this.mActivity, companion.getInstance().getTypeNone(), null, str);
    }

    public void closeClipboard() {
        ClipboardManagerCompat.INSTANCE.getInstance().dismissDialog(this.mActivity);
    }

    public void executeTaskPaste(ClipData clipData, TaskPaste.InputValues inputValues) {
        TaskPaste taskPaste = new TaskPaste();
        if (!isNeedPermission(clipData)) {
            this.mTaskController.execute(taskPaste, inputValues, taskPaste.getDefaultCallback(inputValues.getAiSuggestionAction()), false);
            return;
        }
        Logger.m10999d(TAG, "to get READ_EXTERNAL_STORAGE permission");
        Fragment fragmentFindFragmentByTag = ((AppCompatActivity) this.mActivity).getSupportFragmentManager().findFragmentByTag("Composer");
        if (fragmentFindFragmentByTag == null) {
            return;
        }
        PermissionHelper.requestPermissions(fragmentFindFragmentByTag, 124, PermissionCompat.getStoragePermissions(3));
        this.mTaskController.setPendingTask(taskPaste, inputValues, taskPaste.getDefaultCallback(inputValues.getAiSuggestionAction()), false);
    }

    @Nullable
    public PointF getPastePosition() {
        if (this.mComposerModel.getModeManager().isMode(Mode.Text) && this.mObjectManager.isFocusedTextBox()) {
            return null;
        }
        return this.mObjectManager.getPastePosition();
    }

    public ClipData getPrimaryClip() {
        return ClipboardManagerCompat.INSTANCE.getInstance().getPrimaryClip(this.mActivity);
    }

    public void init(TaskController taskController, ObjectManager objectManager, NoteManager noteManager, PageManager pageManager, TextManager textManager, PdfManager pdfManager, ComposerModel composerModel, SoftInputManager softInputManager, AiMenuManager aiMenuManager) {
        this.mTaskController = taskController;
        this.mObjectManager = objectManager;
        this.mPageManager = pageManager;
        this.mNoteManager = noteManager;
        this.mTextManager = textManager;
        this.mPdfManager = pdfManager;
        this.mComposerModel = composerModel;
        this.mSoftInputManager = softInputManager;
        this.mAiMenuManager = aiMenuManager;
    }

    public boolean isShowingClipboard() {
        return ClipboardManagerCompat.INSTANCE.getInstance().isShowing(this.mActivity);
    }

    public void onAttachView(Activity activity) {
        this.mActivity = activity;
        setClipboardFilter(ClipboardManagerCompat.INSTANCE.getInstance().getTypeAll(), "onAttachView");
    }

    public boolean onBackPressed() {
        if (!isShowingClipboard()) {
            return false;
        }
        Logger.m11003i(TAG, "onBackPressed# isShowingClipboard true");
        closeClipboard();
        return true;
    }

    public void onDetachView() {
        clearFilter("onDetachView");
        this.mActivity = null;
        this.mPasteListener = null;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z && view.isFocused()) {
            setClipboardFilter(ClipboardManagerCompat.INSTANCE.getInstance().getTypeAll(), "onFocusChange");
        } else {
            if (z || view.isFocused()) {
                return;
            }
            clearFilter("onFocusChange");
        }
    }

    public void paste(@Nullable View view, ClipData clipData) {
        if (clipData == null) {
            Logger.m11004w(TAG, "OnPasteListener$onPaste, view: " + view + ", null clipData.");
            return;
        }
        if (this.mActivity == null || this.mComposerModel.getDoc() == null || !this.mComposerModel.getModeManager().isEditMode()) {
            Logger.m11004w(TAG, "OnPasteListener$onPaste# " + this.mActivity + " " + this.mComposerModel.getDoc() + " " + this.mComposerModel.getModeManager().isEditMode());
            return;
        }
        Activity activity = this.mActivity;
        ComposerModel composerModel = this.mComposerModel;
        ObjectManager objectManager = this.mObjectManager;
        NoteManager noteManager = this.mNoteManager;
        PageManager pageManager = this.mPageManager;
        TaskPaste.InputValues inputValues = new TaskPaste.InputValues(activity, clipData, composerModel, objectManager, noteManager, pageManager, this.mTextManager, this.mPdfManager, pageManager.getDocPageInfo().getCurrentPageIndex(), getPastePosition(), new TaskPaste.ISoftInputController() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ClipboardController.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskPaste.ISoftInputController
            public void blockToShow(boolean z, String str) {
                ClipboardController.this.mSoftInputManager.blockToShow(z, str);
            }
        }, false);
        if (FeatureInfo.isAiFeatureEnabled() && this.mComposerModel.getDoc().getBodyText() != null) {
            inputValues.setAiSuggestionAction(this.mAiMenuManager.getRunnableAiSuggestionForAutoFormat());
        }
        executeTaskPaste(clipData, inputValues);
    }

    public void setClipboardFilter(int i, String str) {
        if (CommonUtils.isNotAvailableActivity(this.mActivity)) {
            AbstractC8014b.m7197C("setClipboardFilter# isNotAvailableActivity from : ", str, TAG);
            return;
        }
        if (this.mComposerModel.getModeManager().isSubModeEnabled()) {
            ClipboardManagerCompat.Companion companion = ClipboardManagerCompat.INSTANCE;
            if (i != companion.getInstance().getTypeText() && i != companion.getInstance().getTypeNone()) {
                setClipboardFilter(companion.getInstance().getTypeText(), "setClipboardFilter# skip by sub mode");
                return;
            }
        }
        Object obj = this.mPasteListener;
        ClipboardManagerCompat.INSTANCE.getInstance().filterClip(this.mActivity, i, this.mPasteListener, str);
    }

    public void showClipboard(int i) {
        ClipboardManagerCompat companion = ClipboardManagerCompat.INSTANCE.getInstance();
        Activity activity = this.mActivity;
        companion.showDialog(activity, activity.getCurrentFocus(), i, this.mPasteListener);
    }

    public void showClipboard(int i, View view, Object obj) {
        ClipboardManagerCompat.INSTANCE.getInstance().showDialog(this.mActivity, view, i, obj);
    }
}
