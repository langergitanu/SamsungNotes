package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.fragment.app.Fragment;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.composer.html.HtmlConverter;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.quicknote.MsgPermissionAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.web.Utils;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskAddPdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskAddTextFile;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskWebClip;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.actionsend.ActionSendHelperAppFunction;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.actionsend.ActionSendHelperCommon;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.actionsend.ActionSendHelperMultiple;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.actionsend.ActionSendHelperText;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.common.DownloadUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.common.TaskContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;
import com.samsung.android.support.senl.p148nt.model.base.utils.PositionUtil;
import com.samsung.android.support.senl.p148nt.model.base.utils.data.Content;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.ContextAwarenessFeature;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskActionSend extends Task<InputValues, ResultValues> {
    private static final int TEXT_DEFAULT_FONT_SIZE = 15;
    private ActionSendHelperCommon mActionSendHelperCommon;
    private ExecutorService mExecutorService;
    private ActionSendHandler mHandler;
    private TaskAddPdf mTaskAddPdf;
    private TaskAddTextFile mTaskAddText;
    private TaskWebClip mTaskWebClip;
    private boolean mUpdateInvertBG;
    private static final String TAG = Logger.createTag("TaskActionSend");
    public static String DESIGNATED_CASE_AI = "designated_case_ai";
    private int mError = 0;
    private boolean mIsCanceled = false;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskActionSend$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C99631 implements Task.Callback<TaskAddPdf.ResultValues> {
        final /* synthetic */ InputValues val$inputValues;
        final /* synthetic */ int val$targetPageIndex;

        public C99631(InputValues inputValues, int i) {
            this.val$inputValues = inputValues;
            this.val$targetPageIndex = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$notifyViewUpdate$0(TaskAddPdf.ResultValues resultValues, int i, InputValues inputValues) {
            resultValues.notifyPageUpdate();
            if (i != resultValues.getFirstPageIndex().intValue()) {
                inputValues.mPageScroller.goToPage(resultValues.getFirstPageIndex().intValue());
            }
        }

        private void notifyViewUpdate(TaskAddPdf.ResultValues resultValues) {
            if (this.val$inputValues.mNoteManager.getNote().getPageMode() != SpenWNote.PageMode.LIST) {
                return;
            }
            TaskActionSend.this.mHandler.post(new RunnableC10049b(resultValues, this.val$targetPageIndex, this.val$inputValues));
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
        public void onError(TaskAddPdf.ResultValues resultValues) {
            TaskActionSend taskActionSend = TaskActionSend.this;
            taskActionSend.mError = resultValues.mErrorCode | taskActionSend.mError;
            TaskActionSend.this.mUpdateInvertBG = false;
            TaskActionSend.this.sendMessage(this.val$inputValues);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
        public void onSuccess(TaskAddPdf.ResultValues resultValues) {
            TaskActionSend.this.mError |= resultValues.mErrorCode;
            TaskActionSend.this.mUpdateInvertBG = true;
            notifyViewUpdate(resultValues);
            TaskActionSend.this.sendMessage(this.val$inputValues);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ActionSendHandler extends Handler {
        private static final int MESSAGE_INSERT_CONTENT = 100;
        private Task.Callback<ResultValues> mCallback;
        private List<Content.Base> mContentList;
        private Context mContext;
        private List<Content.Base> mDownloadObjList;
        private int mErrorCode;
        private ObjectManager mObjectManager;
        private StorageChecker mStorageChecker;
        private String mSubject;
        private int mTargetPageIndex;
        private TextManager mTextManager;
        private boolean mUseExtraTextWithoutModification;

        public /* synthetic */ ActionSendHandler(int i) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void addContents(int i, List<Content.Base> list) {
            boolean zAddMarkdown;
            PointF insertedPosition = PositionUtil.getInsertedPosition(this.mContext, this.mObjectManager.getNote(), i);
            if (list.size() == 1) {
                Content.Base base = list.get(0);
                if (base instanceof Content.Text) {
                    Content.Text text = (Content.Text) base;
                    if (this.mUseExtraTextWithoutModification) {
                        Pair<SpenObjectBase, Boolean> pairAddContents = this.mObjectManager.addContents(i, list, insertedPosition, false);
                        boolean z = pairAddContents == null || ((Boolean) pairAddContents.second).booleanValue();
                        changeLastFontSizeToDefault(list);
                        zAddMarkdown = z;
                    } else {
                        zAddMarkdown = addMarkdown(text, i, insertedPosition);
                    }
                }
            }
            if (zAddMarkdown) {
                return;
            }
            this.mErrorCode |= 256;
        }

        private boolean addMarkdown(Content.Text text, int i, PointF pointF) {
            return this.mObjectManager.addObjectsFromHtml(i, new HtmlConverter().makeSObjectListFromText(text.getString(), Arrays.asList(3, 21)), pointF);
        }

        private void changeLastFontSizeToDefault(List<Content.Base> list) {
            if (list.size() == 1 && list.get(0).getType() == 0) {
                try {
                    SpenObjectShape textBox = this.mTextManager.getTextBox();
                    if (textBox != null && !TextUtils.isEmpty(textBox.getText())) {
                        if (textBox.getText().equals(((Content.Text) list.get(0)).getString())) {
                            textBox.appendTextSpan(new SpenFontSizeSpan(0, textBox.getText().length(), 3, 15.0f));
                            return;
                        }
                        return;
                    }
                    Logger.m11003i(TaskActionSend.TAG, "addContents# currentTextBox is emtpy");
                } catch (Exception e) {
                    Logger.m11003i(TaskActionSend.TAG, "addContents# Exception e" + e);
                }
            }
        }

        private void deleteContentExceedNoteLimit(List<Content.Base> list, List<Content.Base> list2) {
            ArrayList arrayList = new ArrayList(list2.size());
            ArrayList arrayList2 = new ArrayList(list2.size());
            for (Content.Base base : list2) {
                if (base.getType() != 3) {
                    arrayList.add(base);
                    arrayList2.add(((Content.DownloadAble) base).getPath());
                }
            }
            int size = this.mStorageChecker.checkAvailableStateToAdd(arrayList2).size();
            if (size != arrayList2.size()) {
                this.mErrorCode |= 1024;
            }
            for (int size2 = arrayList2.size() - 1; size2 >= size; size2--) {
                list.remove(arrayList.get(size2));
            }
        }

        private void deleteInvalidContent(List<Content.Base> list) {
            Iterator<Content.Base> it = list.iterator();
            while (it.hasNext()) {
                Content.Base next = it.next();
                if (next.getError() != 0) {
                    it.remove();
                    this.mErrorCode = next.getError() | this.mErrorCode;
                }
            }
        }

        private String messageToString(int i) {
            return i == 100 ? "MESSAGE_INSERT_CONTENT" : AbstractC0000a.m11h(i, "message: ");
        }

        private void setCursorToLast() {
            SpenObjectShape textBox;
            int length;
            if (this.mObjectManager.isFocusedTextBox() && (textBox = this.mObjectManager.getTextManager().getTextBox()) != null && textBox.getText() != null && (length = textBox.getText().length()) > 0) {
                Logger.m11003i(TaskActionSend.TAG, "setCursorPosition# " + length);
                textBox.setCursorPosition(length);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Logger.m11003i(TaskActionSend.TAG, "ActionSendHandler#handleMessage, what: " + messageToString(message.what));
            if (message.what == 100 && this.mObjectManager.isValidDoc()) {
                if (!TextUtils.isEmpty(this.mSubject) && TextUtils.isEmpty(this.mTextManager.getTitle())) {
                    this.mTextManager.setTitle(Utils.extendedTrim(this.mSubject));
                }
                List<Content.Base> list = this.mContentList;
                if (list != null && !list.isEmpty()) {
                    deleteContentExceedNoteLimit(this.mContentList, this.mDownloadObjList);
                    deleteInvalidContent(this.mContentList);
                    setCursorToLast();
                    if (!this.mObjectManager.getNote().isGroupingHistory()) {
                        this.mObjectManager.getNote().beginHistoryGroup();
                    }
                    addContents(this.mTargetPageIndex, this.mContentList);
                    if (this.mObjectManager.getNote().isGroupingHistory()) {
                        this.mObjectManager.getNote().endHistoryGroup();
                    }
                }
            }
            release();
        }

        public void init(Task.Callback<ResultValues> callback, Context context, List<Content.Base> list, List<Content.Base> list2, ObjectManager objectManager, TextManager textManager, StorageChecker storageChecker, String str, int i, int i2, boolean z) {
            this.mCallback = callback;
            this.mContext = context;
            this.mContentList = list;
            this.mDownloadObjList = list2;
            this.mObjectManager = objectManager;
            this.mTextManager = textManager;
            this.mStorageChecker = storageChecker;
            this.mSubject = str;
            this.mErrorCode = i;
            this.mTargetPageIndex = i2;
            this.mUseExtraTextWithoutModification = z;
        }

        public void release() {
            Logger.m10999d(TaskActionSend.TAG, "ActionSendHandler#release");
            List<Content.Base> list = this.mContentList;
            if (list != null) {
                list.clear();
            }
            Task.Callback<ResultValues> callback = this.mCallback;
            if (callback != null) {
                int i = this.mErrorCode;
                if (i != 0) {
                    callback.onError(new ResultValues(this.mContext, i));
                } else {
                    callback.onSuccess(new ResultValues(this.mContext, i));
                }
            }
            removeCallbacksAndMessages(null);
        }

        private ActionSendHandler() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final ComposerModel mComposerModel;
        private final Context mContext;
        private Fragment mFragment;
        private final Intent mIntent;
        private final boolean mNewWithPdfTemplate;
        private final NoteManager mNoteManager;
        private final ObjectManager mObjectManager;
        private final PageManager mPageManager;
        private final TaskContract.IPageScroller mPageScroller;
        private final PdfManager mPdfManager;
        private final TextManager mTextManager;
        private final boolean mUseExtraTextWithoutModification;

        public InputValues(Context context, Intent intent, ObjectManager objectManager, TextManager textManager, NoteManager noteManager, PdfManager pdfManager, PageManager pageManager, TaskContract.IPageScroller iPageScroller, boolean z, ComposerModel composerModel) {
            this.mContext = context;
            this.mIntent = intent;
            this.mObjectManager = objectManager;
            this.mTextManager = textManager;
            this.mNoteManager = noteManager;
            this.mPdfManager = pdfManager;
            this.mPageManager = pageManager;
            this.mPageScroller = iPageScroller;
            this.mNewWithPdfTemplate = z;
            this.mComposerModel = composerModel;
            boolean booleanExtra = intent.getBooleanExtra(ComposerConstants.INTENT_EXTRA_USE_EXTRA_TEXT_WITHOUT_MODIFICATION, false);
            this.mUseExtraTextWithoutModification = booleanExtra;
            if (booleanExtra) {
                Logger.m11003i(TaskActionSend.TAG, "InputValues# do not modification EXTRA_TEXT");
            }
        }

        public Fragment getFragment() {
            return this.mFragment;
        }

        public void setFragment(Fragment fragment) {
            this.mFragment = fragment;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private Context mContext;
        private final int mErrorCode;

        public ResultValues(Context context, int i) {
            this.mContext = context;
            this.mErrorCode = i;
        }

        public void showErrorToast() {
            if (this.mContext == null) {
                Logger.m11000e(TaskActionSend.TAG, "showErrorToast# context is null. error code - " + this.mErrorCode);
                return;
            }
            AbstractC8014b.m7195A(new StringBuilder("showErrorToast#"), TaskActionSend.TAG, this.mErrorCode);
            AddPdfUtil.showErrorToast(this.mContext, this.mErrorCode, true);
            DownloadUtil.showErrorToast(this.mContext, this.mErrorCode);
            if ((this.mErrorCode & 1) != 0) {
                ToastHandler.show(this.mContext, C9086R.string.composer_video_format_not_supported, 0);
            }
            this.mContext = null;
        }
    }

    private void addPdf(InputValues inputValues, List<Uri> list) {
        Logger.m10999d(TAG, "addPdf#");
        int targetPageIndex = getTargetPageIndex(inputValues);
        TaskAddPdf.InputValues inputValues2 = new TaskAddPdf.InputValues(inputValues.mContext, inputValues.mNoteManager, inputValues.mPdfManager, inputValues.mPageManager, inputValues.mTextManager, null, list, null, targetPageIndex, false);
        TaskAddPdf taskAddPdf = new TaskAddPdf();
        this.mTaskAddPdf = taskAddPdf;
        taskAddPdf.setStorageChecker(this.mStorageChecker);
        this.mTaskAddPdf.setTaskCallback(new C99631(inputValues, targetPageIndex));
        this.mTaskAddPdf.setInputValue(inputValues2);
        this.mTaskAddPdf.executeTask(inputValues2);
    }

    private void addText(Context context, final InputValues inputValues, List<Uri> list) {
        TaskAddTextFile.InputValues inputValues2 = new TaskAddTextFile.InputValues(context, inputValues.mNoteManager, inputValues.mObjectManager, list, inputValues.mObjectManager.getCachePath(), true, Integer.valueOf(getTargetPageIndex(inputValues)));
        TaskAddTextFile taskAddTextFile = new TaskAddTextFile();
        this.mTaskAddText = taskAddTextFile;
        taskAddTextFile.setStorageChecker(this.mStorageChecker);
        this.mTaskAddText.setTaskCallback(new Task.Callback<TaskAddTextFile.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskActionSend.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskAddTextFile.ResultValues resultValues) {
                resultValues.showErrorToast(true);
                TaskActionSend.this.sendMessage(inputValues);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskAddTextFile.ResultValues resultValues) {
                TaskActionSend.this.sendMessage(inputValues);
            }
        });
        this.mTaskAddText.executeTask(inputValues2);
    }

    private void addWebClip(final Context context, InputValues inputValues, String str) {
        Logger.m10999d(TAG, "addWebClip#");
        TaskWebClip.InputValues inputValues2 = new TaskWebClip.InputValues(context, inputValues.mNoteManager, inputValues.mPdfManager, inputValues.mPageManager, inputValues.mTextManager, inputValues.mPageScroller, str, false, inputValues.mObjectManager, inputValues.mComposerModel);
        TaskWebClip taskWebClip = new TaskWebClip();
        this.mTaskWebClip = taskWebClip;
        taskWebClip.setTaskCallback(new Task.Callback<TaskWebClip.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskActionSend.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskWebClip.ResultValues resultValues) {
                TaskActionSend.this.mError |= resultValues.mErrorCode;
                TaskActionSend.this.mUpdateInvertBG = false;
                TaskActionSend taskActionSend = TaskActionSend.this;
                taskActionSend.notifyResultError(context, taskActionSend.mError);
                Logger.m10999d(TaskActionSend.TAG, "add content error: " + resultValues.getErrorCode());
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskWebClip.ResultValues resultValues) {
                TaskActionSend taskActionSend = TaskActionSend.this;
                taskActionSend.mError = resultValues.mErrorCode | taskActionSend.mError;
                TaskActionSend.this.mUpdateInvertBG = true;
                TaskActionSend taskActionSend2 = TaskActionSend.this;
                taskActionSend2.notifyResultError(context, taskActionSend2.mError);
                Logger.m10999d(TaskActionSend.TAG, "add content done");
            }
        });
        this.mTaskWebClip.setInputValue(inputValues2);
        this.mTaskWebClip.setStorageChecker(this.mStorageChecker);
        this.mTaskWebClip.setTimeStart(System.currentTimeMillis());
        this.mTaskWebClip.executeTask(inputValues2);
    }

    private void downloadData() {
        if (this.mIsCanceled) {
            return;
        }
        Logger.startTime(String.valueOf(hashCode()));
        try {
            List listInvokeAll = this.mExecutorService.invokeAll(this.mActionSendHelperCommon.getCallableList());
            ArrayList arrayList = new ArrayList(this.mActionSendHelperCommon.getDownloadObjList());
            for (int i = 0; i < arrayList.size(); i++) {
                Content.Base base = (Content.Base) arrayList.get(i);
                try {
                    if (!((Boolean) ((Future) listInvokeAll.get(i)).get()).booleanValue()) {
                        this.mError |= base.getError();
                        this.mActionSendHelperCommon.removeContentInList(base);
                    }
                } catch (Exception e) {
                    String str = TAG;
                    StringBuilder sbM778t = AbstractC0541b.m778t(i, "downloadData# ", " ");
                    sbM778t.append(e.getMessage());
                    Logger.m11001e(str, sbM778t.toString(), e);
                    this.mActionSendHelperCommon.removeContentInList((Content.Base) arrayList.get(i));
                }
            }
            Logger.endTime(String.valueOf(hashCode()), TAG, "downloadData# " + arrayList.size());
        } catch (Exception e2) {
            Logger.m11001e(TAG, "downloadData#Exception: " + e2.getMessage(), e2);
        }
    }

    private int getTargetPageIndex(InputValues inputValues) {
        if (inputValues.mNewWithPdfTemplate) {
            return 0;
        }
        return Math.max(inputValues.mNoteManager.getNote().getPageCount() - 2, 0);
    }

    public static boolean hasAiResult(Intent intent) {
        if ("text/plain".equals(intent.getType())) {
            return !TextUtils.isEmpty(intent.getStringExtra(DESIGNATED_CASE_AI));
        }
        return false;
    }

    private boolean isMessageAppCard(InputValues inputValues) {
        Intent intent = inputValues.mIntent;
        String type = intent.getType();
        return "android.intent.action.SEND".equals(intent.getAction()) && type != null && type.startsWith("text/plain") && ContextAwarenessFeature.MESSAGE_PACKAGE_NAME.equals(intent.getStringExtra(ComposerConstants.ACTION_SEND_ADDITION)) && !TextUtils.isEmpty(intent.getStringExtra(ComposerConstants.ACTION_SEND_ADDITION_URI));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeTask$0(InputValues inputValues) {
        takeAiCase(inputValues.mContext, inputValues.mIntent, inputValues.mObjectManager);
        getTaskCallback().onSuccess(new ResultValues(inputValues.mContext, this.mError));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeTask$1(InputValues inputValues, Context context) {
        if (((ActionSendHelperMultiple) this.mActionSendHelperCommon).hasPdfUriList()) {
            addPdf(inputValues, ((ActionSendHelperMultiple) this.mActionSendHelperCommon).getPdfUriList());
        }
        if (((ActionSendHelperMultiple) this.mActionSendHelperCommon).hasTextUriList()) {
            addText(context, inputValues, ((ActionSendHelperMultiple) this.mActionSendHelperCommon).getTextUriList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeTask$2(InputValues inputValues) {
        String str = TAG;
        Logger.m10999d(str, "executeTask#");
        Context context = inputValues.mContext;
        try {
            if (hasAiResult(inputValues.mIntent)) {
                this.mHandler.post(new RunnableC10048a(this, inputValues, 0));
                return;
            }
            Intent intent = inputValues.mIntent;
            String action = intent.getAction();
            String type = intent.getType();
            String cachePath = inputValues.mObjectManager.getCachePath();
            if (type != null) {
                if (type.startsWith(Constants.MIME_IMAGE_START) || type.startsWith(Constants.MIME_APPLICATION_START) || type.startsWith(Constants.MIME_AUDIO_START)) {
                    this.mActionSendHelperCommon = new ActionSendHelperMultiple(cachePath);
                } else if ("android.intent.action.SEND".equals(action) && type.startsWith("text/plain")) {
                    this.mActionSendHelperCommon = new ActionSendHelperText(cachePath);
                } else if (type.startsWith(Constants.MIME_MULTI_START)) {
                    this.mActionSendHelperCommon = new ActionSendHelperMultiple(cachePath);
                }
            } else if ("android.intent.action.SEND".equals(action) && intent.getBooleanExtra(ActionSendHelperAppFunction.AI_ACTION_UPDATE_EDITING_NOTE, false)) {
                this.mActionSendHelperCommon = new ActionSendHelperAppFunction(cachePath, inputValues.mTextManager, inputValues.mComposerModel.getNotesDocEntityManager());
            }
            Logger.addFileLog(str, "ASend " + type, 0);
            ActionSendHelperCommon actionSendHelperCommon = this.mActionSendHelperCommon;
            if (actionSendHelperCommon == null) {
                Logger.m11003i(str, "onLoadSendAction, Handle other intents.");
                notifyResultError(context, this.mError);
                return;
            }
            this.mError = actionSendHelperCommon.handleIntent(context, intent) | this.mError;
            downloadData();
            if (this.mIsCanceled) {
                notifyResultError(context, this.mError);
                return;
            }
            ActionSendHelperCommon actionSendHelperCommon2 = this.mActionSendHelperCommon;
            if ((actionSendHelperCommon2 instanceof ActionSendHelperText) && ((ActionSendHelperText) actionSendHelperCommon2).hasWebClip()) {
                addWebClip(context, inputValues, ((ActionSendHelperText) this.mActionSendHelperCommon).getUrlForWebClip());
                return;
            }
            ActionSendHelperCommon actionSendHelperCommon3 = this.mActionSendHelperCommon;
            if ((actionSendHelperCommon3 instanceof ActionSendHelperMultiple) && ((ActionSendHelperMultiple) actionSendHelperCommon3).hasUriList()) {
                this.mHandler.post(new RunnableC8928b(this, 12, inputValues, context));
            } else {
                sendMessage(inputValues);
            }
        } catch (Exception e) {
            Logger.m11001e(TAG, "onLoadSendAction" + e.getMessage(), e);
            notifyResultError(context, this.mError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyResultError(Context context, int i) {
        if (getTaskCallback() != null) {
            if (this.mIsCanceled) {
                getTaskCallback().onSuccess(new ResultValues(context, i));
            } else {
                getTaskCallback().onError(new ResultValues(context, i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResult(ResultValues resultValues) {
        resultValues.showErrorToast();
        if (this.mUpdateInvertBG) {
            getInputValue().mNoteManager.updateInvertBackgroundColor();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(InputValues inputValues) {
        if (this.mIsCanceled) {
            notifyResultError(inputValues.mContext, this.mError);
            return;
        }
        this.mHandler.init(getTaskCallback(), inputValues.mContext, this.mActionSendHelperCommon.getContentList(), this.mActionSendHelperCommon.getDownloadObjList(), inputValues.mObjectManager, inputValues.mTextManager, this.mStorageChecker, this.mActionSendHelperCommon.getSubject(inputValues.mIntent), this.mError, getTargetPageIndex(inputValues), inputValues.mUseExtraTextWithoutModification);
        ActionSendHandler actionSendHandler = this.mHandler;
        actionSendHandler.sendMessage(actionSendHandler.obtainMessage(100));
    }

    private void takeAiCase(Context context, Intent intent, ObjectManager objectManager) {
        String str = TAG;
        Logger.m10999d(str, "takeAiCase#");
        String stringExtra = intent.getStringExtra(DESIGNATED_CASE_AI);
        if (stringExtra == null) {
            Logger.m11004w(str, "takeAiCase, tempPath is null");
            return;
        }
        objectManager.addObjects(0, objectManager.getNote().restoreObjectList(stringExtra), new PointF(0.0f, 0.0f));
        try {
            SpenWNoteFile.removeClosedCache(context, stringExtra);
            FileUtils.deleteFile(stringExtra);
        } catch (IOException unused) {
            Logger.m11000e(TAG, "takeAiCase# fail to remove cache.");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
        Logger.m11003i(TAG, "cancel ");
        this.mIsCanceled = true;
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null) {
            executorService.shutdownNow();
            this.mExecutorService = null;
        }
        ActionSendHandler actionSendHandler = this.mHandler;
        if (actionSendHandler != null && actionSendHandler.hasMessages(100)) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler.release();
        }
        TaskAddPdf taskAddPdf = this.mTaskAddPdf;
        if (taskAddPdf != null) {
            taskAddPdf.cancel(iCancelCallback);
        }
        TaskWebClip taskWebClip = this.mTaskWebClip;
        if (taskWebClip != null) {
            taskWebClip.cancel(iCancelCallback);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        Logger.m11003i(TAG, "clear ");
        cancel(null);
        TaskAddPdf taskAddPdf = this.mTaskAddPdf;
        if (taskAddPdf != null) {
            taskAddPdf.clear();
            this.mTaskAddPdf = null;
        }
        TaskWebClip taskWebClip = this.mTaskWebClip;
        if (taskWebClip != null) {
            taskWebClip.clear();
            this.mTaskWebClip = null;
        }
        ActionSendHelperCommon actionSendHelperCommon = this.mActionSendHelperCommon;
        if (actionSendHelperCommon != null) {
            actionSendHelperCommon.clear();
        }
    }

    public Task.Callback<ResultValues> getDefaultCallback() {
        return new Task.Callback<ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskActionSend.4
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(ResultValues resultValues) {
                TaskActionSend.this.onResult(resultValues);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(ResultValues resultValues) {
                TaskActionSend.this.onResult(resultValues);
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToSave() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isKeepTaskDuringActivityRecreation() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isNeedToCheckNoteSize() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isNeededToWaitPermission() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean checkPermission(InputValues inputValues) {
        MsgPermissionAction msgPermissionAction = new MsgPermissionAction();
        if (!msgPermissionAction.hasAndroidId() && isMessageAppCard(inputValues)) {
            if (inputValues.getFragment() == null) {
                return false;
            }
            if (!msgPermissionAction.hasPermission(inputValues.mContext)) {
                msgPermissionAction.requestPermissions(inputValues.getFragment(), 201, null);
                return false;
            }
            msgPermissionAction.saveAndroidId(inputValues.mContext);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(InputValues inputValues) {
        this.mHandler = new ActionSendHandler(0);
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewFixedThreadPool;
        executorServiceNewFixedThreadPool.execute(new RunnableC10048a(this, inputValues, 1));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean onRequestPermissionsResult(int i, InputValues inputValues) {
        if (201 != i) {
            return false;
        }
        new MsgPermissionAction().saveAndroidId(inputValues.mContext);
        return true;
    }
}
