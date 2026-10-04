package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.BroadcastCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.common.DownloadUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.dex.DoPControlClipData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.dex.DoPFileTransmitReceiver;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Restriction;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.WebCardUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskPaste extends Task<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskPaste");
    private TaskPasteHandler mHandler = null;
    private DoPFileTransmitReceiver mDoPFileTransmitReceiver = null;
    private boolean mBeginHistory = false;
    private boolean mIsCleared = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ISoftInputController {
        void blockToShow(boolean z, String str);
    }

    private void beginHistoryGroup(NoteManager noteManager) {
        if (noteManager.getNote().isGroupingHistory()) {
            return;
        }
        this.mBeginHistory = true;
        noteManager.getNote().beginHistoryGroup();
    }

    private void callDownloadFailCallback(Context context) {
        if (getTaskCallback() != null) {
            getTaskCallback().onError(new ResultValues(context, 256, false, false));
        }
    }

    private String getClipLabel(ClipData clipData) {
        ClipDescription description;
        CharSequence label;
        if (clipData == null || (description = clipData.getDescription()) == null || (label = description.getLabel()) == null) {
            return null;
        }
        return label.toString();
    }

    private void runBroadcastReceiver(Context context, ClipData clipData) {
        int eventIdInClipData = DoPControlClipData.getEventIdInClipData(clipData);
        Logger.m10999d(TAG, "runBroadcastReceiver id= " + eventIdInClipData);
        DoPControlClipData.getDoPDataFromClipData(clipData);
        DoPFileTransmitReceiver doPFileTransmitReceiver = new DoPFileTransmitReceiver(eventIdInClipData, new DoPFileTransmitReceiver.Callback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskPaste.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.dex.DoPFileTransmitReceiver.Callback
            public void onTransitCanceled(Context context2, Intent intent) {
                Logger.m10999d(TaskPaste.TAG, "onTransitCanceled");
                context2.unregisterReceiver(TaskPaste.this.mDoPFileTransmitReceiver);
                TaskPaste.this.mDoPFileTransmitReceiver = null;
                if (TaskPaste.this.getTaskCallback() != null) {
                    TaskPaste.this.getTaskCallback().onError(new ResultValues());
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.dex.DoPFileTransmitReceiver.Callback
            public void onTransitCompleted(Context context2, Intent intent) {
                AbstractC8014b.m7196B("onTransitCompleted# ", intent.getStringExtra("fileUri"), TaskPaste.TAG);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.dex.DoPFileTransmitReceiver.Callback
            public void onTransitFailed(Context context2, Intent intent) {
                Logger.m10999d(TaskPaste.TAG, "onTransitFailed");
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.dex.DoPFileTransmitReceiver.Callback
            public void onTransitFinished(Context context2, Intent intent) {
                Logger.m10999d(TaskPaste.TAG, "onTransitFinished");
                ClipData clipDataConvertUriToClipItem = DoPControlClipData.convertUriToClipItem(intent);
                InputValues inputValue = TaskPaste.this.getInputValue();
                inputValue.mClipData = clipDataConvertUriToClipItem;
                TaskPaste.this.startPasteHandler(inputValue);
                context2.unregisterReceiver(TaskPaste.this.mDoPFileTransmitReceiver);
                TaskPaste.this.mDoPFileTransmitReceiver = null;
            }
        });
        this.mDoPFileTransmitReceiver = doPFileTransmitReceiver;
        BroadcastCompat.registerReceiver(context, doPFileTransmitReceiver, doPFileTransmitReceiver.getIntentFilterForDoPFileTransmitReceiver(), DoPControlClipData.PERMISSION_NAME_DEXONPC, null, 2);
    }

    private void startFileTransmission(Context context, ClipData clipData) {
        if (DoPControlClipData.getEventIdInClipData(clipData) >= 0) {
            DoPControlClipData.sendResponseBroadcast(context, clipData);
            runBroadcastReceiver(context, clipData);
            return;
        }
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager == null) {
            Logger.m11000e(TAG, "startFileTransmission# clipboard is null");
            callDownloadFailCallback(context);
            return;
        }
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        if (primaryClip == null) {
            Logger.m11000e(TAG, "startFileTransmission# getPrimaryClip is null");
            callDownloadFailCallback(context);
            return;
        }
        if (DoPControlClipData.isDoPDrop(getClipLabel(primaryClip)) && clipData.getDescription().getMimeTypeCount() == primaryClip.getDescription().getMimeTypeCount()) {
            int i = 0;
            if (clipData.getDescription().getMimeType(0).equals(primaryClip.getDescription().getMimeType(0)) && clipData.getItemCount() == primaryClip.getItemCount()) {
                int itemCount = clipData.getItemCount();
                while (true) {
                    if (i < itemCount) {
                        if (!clipData.getItemAt(i).getUri().equals(primaryClip.getItemAt(i).getUri())) {
                            break;
                        } else {
                            i++;
                        }
                    } else if (DoPControlClipData.getEventIdInClipData(primaryClip) >= 0) {
                        DoPControlClipData.sendResponseBroadcast(context, primaryClip);
                        runBroadcastReceiver(context, primaryClip);
                        return;
                    }
                }
            }
        }
        callDownloadFailCallback(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPasteHandler(InputValues inputValues) {
        beginHistoryGroup(inputValues.mNoteManager);
        if (inputValues.mIsPagePaste) {
            this.mHandler = new TaskPasteHandler(inputValues.mContext, inputValues.mClipData, getTaskCallback(), inputValues.mComposerModel, inputValues.mObjectManager, inputValues.mNoteManager, inputValues.mPageManager, inputValues.mTextManager, inputValues.mTargetPageIndex);
        } else {
            this.mHandler = new TaskPasteHandler(inputValues.mContext, inputValues.mClipData, getTaskCallback(), inputValues.mComposerModel, inputValues.mObjectManager, inputValues.mNoteManager, inputValues.mPageManager, inputValues.mTextManager, inputValues.mPdfManager, inputValues.mTargetPageIndex, inputValues.mPastePosition, inputValues.mEnableWebCard, inputValues.mDialogPresenterManager, inputValues.mPlainTextFlags);
            if (inputValues.mObjectManager.isFocusedTextBox()) {
                inputValues.mObjectManager.getTextManager().removeSelectedText();
            } else if (inputValues.mSoftInputManager != null) {
                inputValues.mSoftInputManager.blockToShow(true, TAG);
            }
        }
        this.mHandler.setStorageChecker(this.mStorageChecker);
        TaskPasteHandler taskPasteHandler = this.mHandler;
        taskPasteHandler.sendMessage(taskPasteHandler.obtainMessage(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInvertBackgroundColor(ResultValues resultValues) {
        if (resultValues.mUpdateInvertBG) {
            getInputValue().mNoteManager.updateInvertBackgroundColor();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        if (this.mBeginHistory) {
            getInputValue().mNoteManager.getNote().endHistoryGroup();
        }
        TaskPasteHandler taskPasteHandler = this.mHandler;
        if (taskPasteHandler != null && taskPasteHandler.getExecutorService() != null) {
            this.mHandler.release();
            this.mHandler = null;
        }
        if (this.mDoPFileTransmitReceiver != null) {
            getInputValue().mContext.unregisterReceiver(this.mDoPFileTransmitReceiver);
        }
        DoPControlClipData.clearDownloadDir();
        if (getInputValue().mSoftInputManager != null) {
            getInputValue().mSoftInputManager.blockToShow(false, TAG);
        }
        this.mIsCleared = true;
        AbstractC8014b.m7215q(new StringBuilder("clear: "), this.mIsCleared, TAG);
    }

    public Task.Callback<ResultValues> getDefaultCallback(final Runnable runnable) {
        return new Task.Callback<ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskPaste.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(ResultValues resultValues) {
                resultValues.showErrorToast();
                TaskPaste.this.updateInvertBackgroundColor(resultValues);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(ResultValues resultValues) {
                resultValues.showErrorToast();
                TaskPaste.this.updateInvertBackgroundColor(resultValues);
                if (runnable == null || resultValues.isSkipAiSuggestion()) {
                    return;
                }
                runnable.run();
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task, com.samsung.android.support.senl.nt.composer.main.base.presenter.task.coedit.CoeditPauseController.Contract
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToSave() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task, com.samsung.android.support.senl.nt.composer.main.base.presenter.task.coedit.CoeditPauseController.Contract
    public boolean isCoeditNoTimeoutPause() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isNeedToCheckNoteSize() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(InputValues inputValues) {
        ClipData clipData = inputValues.mClipData;
        if (clipData == null) {
            if (getTaskCallback() != null) {
                getTaskCallback().onError(new ResultValues(inputValues.mContext, 256, false, false));
            }
        } else if (!DoPControlClipData.isDoPDrop(getClipLabel(clipData))) {
            startPasteHandler(inputValues);
        } else if (DesktopModeCompat.INSTANCE.getInstance().isConnectedDoP(inputValues.mContext)) {
            startFileTransmission(inputValues.mContext, clipData);
        } else if (getTaskCallback() != null) {
            getTaskCallback().onError(new ResultValues(inputValues.mContext, 256, false, false));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private Context mContext;
        private final int mErrorCode;
        private int mErrorCodeSubType;
        private boolean mSkipAiSuggestion;
        private boolean mUpdateInvertBG;

        public ResultValues() {
            this.mErrorCodeSubType = 0;
            this.mErrorCode = 0;
        }

        public Context getContext() {
            return this.mContext;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }

        public boolean isSkipAiSuggestion() {
            return this.mSkipAiSuggestion;
        }

        public boolean isUpdateInvertBG() {
            return this.mUpdateInvertBG;
        }

        public void showErrorToast() {
            if (this.mContext == null) {
                Logger.m11000e(TaskPaste.TAG, "showErrorToast# context is null. error code - " + this.mErrorCode);
                return;
            }
            AbstractC8014b.m7195A(new StringBuilder("showErrorToast#"), TaskPaste.TAG, this.mErrorCode);
            AddPdfUtil.showErrorToast(this.mContext, this.mErrorCode, true);
            DownloadUtil.showErrorToast(this.mContext, this.mErrorCode);
            int i = this.mErrorCode;
            if ((i & 32) != 0) {
                ToastHandler.show(this.mContext, this.mContext.getResources().getQuantityString(C9086R.plurals.can_not_paste_item_at_one_time, 100, 100), 0);
            } else if ((i & 2) != 0) {
                ToastHandler.show(this.mContext, this.mContext.getResources().getQuantityString(C9086R.plurals.drag_and_drop_only_one_audio, 1, 1), 1);
            } else if ((i & 1) != 0) {
                ToastHandler.show(this.mContext, C9086R.string.f6722x44e69633, 0);
            } else if ((i & 8) != 0 || (i & 64) != 0) {
                ToastHandler.show(this.mContext, C9086R.string.composer_content_not_supported, 0);
            } else if ((i & 16) != 0) {
                Context context = this.mContext;
                ToastHandler.show(context, context.getResources().getString(C9086R.string.ss_maximum_number_of_characters_exceeded, 350000), 0);
            } else if ((i & 128) != 0) {
                Restriction.showToastCoeditErrorOverLargeMaxCount(this.mContext);
            } else if ((i & 4096) != 0) {
                ToastHandler.show(this.mContext, C9086R.string.composer_fail_to_paste_hear, 0);
            } else if ((i & 8192) != 0) {
                int i2 = this.mErrorCodeSubType;
                if (i2 == 1) {
                    ToastHandler.show(this.mContext, C9086R.string.composer_could_not_add_any_page_to_note_to_infinite, 0);
                } else if (i2 == 3) {
                    ToastHandler.show(this.mContext, C9086R.string.composer_could_not_add_any_page_to_note_to_landscape, 0);
                } else {
                    ToastHandler.show(this.mContext, C9086R.string.composer_could_not_add_any_page_to_note_to_portrait, 0);
                }
            } else if ((i & 16384) != 0) {
                ToastHandler.show(this.mContext, C9086R.string.composer_content_not_supported, 0);
            }
            this.mContext = null;
        }

        public ResultValues(Context context, int i, boolean z, boolean z2) {
            this.mErrorCodeSubType = 0;
            this.mContext = context;
            this.mErrorCode = i;
            this.mUpdateInvertBG = z;
            this.mSkipAiSuggestion = z2;
        }

        public ResultValues(Context context, int i, int i2, boolean z) {
            this.mContext = context;
            this.mErrorCode = i;
            this.mErrorCodeSubType = i2;
            this.mUpdateInvertBG = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private Runnable mAiSuggestionAction;
        private ClipData mClipData;
        private final ComposerModel mComposerModel;
        private final Context mContext;
        private WebCardUtil.IDialogManager mDialogPresenterManager;
        private boolean mEnableWebCard;
        private boolean mIsPagePaste;
        private final NoteManager mNoteManager;
        private final ObjectManager mObjectManager;
        private final PageManager mPageManager;
        private PointF mPastePosition;
        private PdfManager mPdfManager;
        private boolean mPlainTextFlags;
        private ISoftInputController mSoftInputManager;
        private final int mTargetPageIndex;
        private final TextManager mTextManager;

        public InputValues(Context context, ClipData clipData, ComposerModel composerModel, ObjectManager objectManager, NoteManager noteManager, PageManager pageManager, TextManager textManager, PdfManager pdfManager, int i, PointF pointF, ISoftInputController iSoftInputController, boolean z) {
            this(context, clipData, composerModel, objectManager, noteManager, pageManager, textManager, i);
            this.mPdfManager = pdfManager;
            this.mSoftInputManager = iSoftInputController;
            if (pointF != null) {
                this.mPastePosition = new PointF(pointF.x, pointF.y);
            }
            this.mIsPagePaste = false;
            this.mPlainTextFlags = z;
        }

        public Runnable getAiSuggestionAction() {
            return this.mAiSuggestionAction;
        }

        public void setAiSuggestionAction(Runnable runnable) {
            this.mAiSuggestionAction = runnable;
        }

        public InputValues(Context context, ClipData clipData, ComposerModel composerModel, ObjectManager objectManager, NoteManager noteManager, PageManager pageManager, TextManager textManager, PdfManager pdfManager, int i, PointF pointF, boolean z, WebCardUtil.IDialogManager iDialogManager, ISoftInputController iSoftInputController) {
            this(context, clipData, composerModel, objectManager, noteManager, pageManager, textManager, pdfManager, i, pointF, iSoftInputController, false);
            this.mEnableWebCard = z;
            this.mDialogPresenterManager = iDialogManager;
        }

        public InputValues(Context context, ClipData clipData, ComposerModel composerModel, ObjectManager objectManager, NoteManager noteManager, PageManager pageManager, TextManager textManager, int i) {
            this.mPlainTextFlags = false;
            this.mAiSuggestionAction = null;
            this.mContext = context;
            this.mClipData = clipData;
            this.mComposerModel = composerModel;
            this.mObjectManager = objectManager;
            this.mNoteManager = noteManager;
            this.mPageManager = pageManager;
            this.mTextManager = textManager;
            this.mTargetPageIndex = i;
            this.mIsPagePaste = true;
        }
    }
}
