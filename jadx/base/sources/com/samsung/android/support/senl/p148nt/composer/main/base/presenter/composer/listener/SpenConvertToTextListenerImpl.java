package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.app.Activity;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenConvertToTextListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ProgressController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskCopy;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpenConvertToTextListenerImpl extends SpenConvertToTextListener {
    private static final String TAG = Logger.createTag("SpenConvertToTextListenerImpl");
    private final Activity mActivity;
    private final ListenerImplContract.IDialogPresenter mDialogPresenterManager;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mIsRunningSpenConvertToText;
    private final ObjectManager mObjectManager;
    private final PageManager mPageManager;
    protected final ListenerImplContract.IPresenter mPresenter;
    private final ProgressHandler mProgressHandler;
    private final SoftInputManager mSoftInputManager;
    private final SpenWNote mSpenWNote;
    private final TaskController mTaskController;

    public SpenConvertToTextListenerImpl(ListenerImplContract.IPresenter iPresenter, TaskController taskController, ProgressController progressController, SoftInputManager softInputManager) {
        this.mActivity = iPresenter.getActivity();
        this.mPresenter = iPresenter;
        this.mObjectManager = iPresenter.getObjectManager();
        this.mPageManager = iPresenter.getPageManager();
        this.mDialogPresenterManager = iPresenter.getDialogPresenterManager();
        this.mSpenWNote = iPresenter.getDoc();
        this.mTaskController = taskController;
        this.mProgressHandler = new ProgressHandler(progressController);
        this.mSoftInputManager = softInputManager;
    }

    private void addBodyTextBox(SpannableStringBuilder spannableStringBuilder, RectF rectF) {
        SpenObjectTextBox newBodyText = this.mObjectManager.getNewBodyText();
        newBodyText.insertText(spannableStringBuilder.toString(), 0);
        CharUtils.convertSpannablerToSpen(spannableStringBuilder, newBodyText);
        SpenWPage page = this.mSpenWNote.getPage(this.mPageManager.getDocPageInfo().getCurrentPageIndex());
        RectF lineRectOfBodyText = this.mObjectManager.getTextManager().getLineRectOfBodyText(page, rectF.top);
        if (!lineRectOfBodyText.isEmpty()) {
            float f = lineRectOfBodyText.bottom;
            if (rectF.top > (lineRectOfBodyText.top + f) / 2.0f) {
                rectF.top = f + 1.0f;
            }
        }
        Logger.m11003i(TAG, "addBodyTextBox# page:" + this.mPageManager.getDocPageInfo().getCurrentPageIndex() + ", rect:" + rectF + ", lineRect:" + lineRectOfBodyText);
        if (this.mObjectManager.insertBodyText(newBodyText, page, new PointF(rectF.left, rectF.top), false)) {
            SpenObjectTextBox bodyText = this.mSpenWNote.getBodyText();
            this.mSpenWNote.selectObject(bodyText);
            bodyText.setCursorPosition(this.mObjectManager.getTextManager().getCursorIndex(bodyText, new PointF(rectF.left, rectF.top)));
        }
    }

    private void addNewTextBox(SpannableStringBuilder spannableStringBuilder, RectF rectF) {
        SpenObjectTextBox newTextBox = this.mObjectManager.getNewTextBox();
        newTextBox.insertText(spannableStringBuilder.toString(), 0);
        CharUtils.convertSpannablerToSpen(spannableStringBuilder, newTextBox);
        this.mObjectManager.addTextBoxFromCTT(newTextBox, new PointF(rectF.left, rectF.top));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConvertToTextFailed$0(boolean z) {
        if (z) {
            ToastHandler.show(this.mActivity, C9086R.string.composer_could_not_find_any_handwriting, 1);
        } else {
            ToastHandler.show(this.mActivity, C9086R.string.composer_unable_to_extract_text, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateConvertToTextRunning$1(boolean z) {
        this.mPresenter.onConvertToTextRunning(z);
        setRunningStateForCoEdit(z);
    }

    private void setRunningStateForCoEdit(boolean z) {
        if (this.mPresenter.getComposerModel().getCoeditAdapter().isCoeditNote()) {
            if (!z) {
                this.mPresenter.resumeCoEdit(TAG);
                return;
            }
            ListenerImplContract.IPresenter iPresenter = this.mPresenter;
            String str = TAG;
            Objects.requireNonNull(iPresenter);
            iPresenter.pauseCoEdit(str, new RunnableC8669a(iPresenter, 25));
        }
    }

    private void updateConvertToTextRunning(boolean z) {
        Logger.m11003i(TAG, "updateConvertToTextRunning :" + this.mIsRunningSpenConvertToText + " / " + z);
        if (this.mIsRunningSpenConvertToText == z) {
            return;
        }
        this.mIsRunningSpenConvertToText = z;
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.post(new RunnableC9222a(this, z, 1));
    }

    public int getInsertType() {
        return SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_INSERT_TYPE, 0);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenConvertToTextListener
    public void onClose() {
        Logger.m11003i(TAG, "onClose");
        this.mDialogPresenterManager.dismissConvertSettingDialog();
        this.mSoftInputManager.hide(this.mPresenter.getView());
        updateConvertToTextRunning(false);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenConvertToTextListener
    public void onConvertToText(SpannableStringBuilder spannableStringBuilder, RectF rectF) {
        if (TextUtils.isEmpty(spannableStringBuilder)) {
            Logger.m11003i(TAG, "onConvertToText# spannableSB is empty. return");
            return;
        }
        float dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.composer_text_box_margin);
        if (rectF.left < dimensionPixelSize) {
            rectF.left = dimensionPixelSize;
        }
        int insertType = getInsertType();
        Logger.m11003i(TAG, "onConvertToText#" + rectF.left + ":" + rectF.top + ", insertType:" + insertType);
        if (insertType == 1) {
            addBodyTextBox(spannableStringBuilder, rectF);
        } else {
            addNewTextBox(spannableStringBuilder, rectF);
        }
        this.mObjectManager.clearSelectObject();
        this.mSoftInputManager.hide(this.mPresenter.getView());
        ComposerSA.insertLog("412", HWToolbarSAConstants.EVENT_CONVERT_TO_TEXT_CONVERT);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenConvertToTextListener
    public void onConvertToTextFailed(boolean z) {
        this.mActivity.runOnUiThread(new RunnableC9222a(this, z, 0));
        updateConvertToTextRunning(false);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenConvertToTextListener
    public void onConvertToTextRunning(boolean z) {
        updateConvertToTextRunning(z);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenConvertToTextListener
    public void onCopySelected(CharSequence charSequence) {
        if (charSequence == null) {
            return;
        }
        Logger.m11003i(TAG, "onCopySelected# " + Logger.getEncode(charSequence.toString()));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        SpenObjectTextBox newBodyText = getInsertType() == 1 ? this.mObjectManager.getNewBodyText() : this.mObjectManager.getNewTextBox();
        newBodyText.insertText(spannableStringBuilder.toString(), 0);
        CharUtils.convertSpannablerToSpen(spannableStringBuilder, newBodyText);
        TaskCopy.InputValues inputValues = new TaskCopy.InputValues(this.mActivity, this.mObjectManager, newBodyText, 0, charSequence.length());
        TaskCopy taskCopy = new TaskCopy();
        this.mTaskController.execute(taskCopy, inputValues, taskCopy.getDefaultCallback(), false);
        ComposerSA.insertLog("412", HWToolbarSAConstants.EVENT_CONVERT_TO_TEXT_COPY_TO_CLIPBOARD);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenConvertToTextListener
    public void onEditLineOverflow(int i) {
        ToastHandler.show(this.mActivity, this.mActivity.getResources().getString(C9086R.string.maximum_number_of_lines_exceeded, Integer.valueOf(i)), 0);
        updateConvertToTextRunning(false);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenConvertToTextListener
    public void onEditTextOverflow(int i) {
        ToastHandler.show(this.mActivity, this.mActivity.getResources().getString(C9086R.string.maximum_number_of_characters_exceeded, Integer.valueOf(i)), 0);
        updateConvertToTextRunning(false);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenConvertToTextListener
    public void onFinished() {
        Logger.m11003i(TAG, "onFinished");
        this.mPresenter.getView().requestFocus();
        updateConvertToTextRunning(false);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenConvertToTextListener
    public void onProgressStart() {
        Logger.m11003i(TAG, "onProgressStart");
        this.mProgressHandler.onProgressStart();
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenConvertToTextListener
    public void onProgressStop() {
        Logger.m11003i(TAG, "onProgressStop");
        this.mProgressHandler.onProgressStop();
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenConvertToTextListener
    public void onSetting() {
        this.mDialogPresenterManager.showConvertSettingDialog(true, false);
    }

    public void release() {
        this.mProgressHandler.release();
    }
}
