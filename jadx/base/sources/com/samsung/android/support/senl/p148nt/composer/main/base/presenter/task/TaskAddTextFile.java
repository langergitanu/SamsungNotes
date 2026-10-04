package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.composer.html.HtmlConverter;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;
import com.samsung.android.support.senl.p148nt.model.base.utils.PositionUtil;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskAddTextFile extends SingleThreadTask<InputValues, ResultValues> {
    private static final int STATE_ATTACH = 3;
    private static final int STATE_CANCEL = 100;
    private static final int STATE_DOWNLOAD = 1;
    private static final int STATE_DOWNLOAD_DONE = 2;
    private static final int STATE_INIT = -1;
    private static final int STATE_START = 0;
    private static final String TAG = Logger.createTag("TaskAddTextFile");
    private List<String> mDownloadFileList;
    private Handler mHandler;
    private String mOriginalFileName;
    private Runnable mRunnableToBeginHistoryGroup;
    private Runnable mRunnableToEndHistoryGroup;
    private ErrorType mErrorType = ErrorType.ERROR_TYPE_SUCCESS;
    private final AtomicInteger mCurState = new AtomicInteger(-1);
    private boolean mIsAutoFocusEnabled = false;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddTextFile$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RunnableC99822 implements Runnable {
        final /* synthetic */ InputValues val$inputValues;
        final /* synthetic */ boolean val$needToBeginHistory;
        final /* synthetic */ SpenWNote val$note;
        final /* synthetic */ List val$stringBuilders;

        public RunnableC99822(InputValues inputValues, List list, boolean z, SpenWNote spenWNote) {
            this.val$inputValues = inputValues;
            this.val$stringBuilders = list;
            this.val$needToBeginHistory = z;
            this.val$note = spenWNote;
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddTextFile$2$1] */
        @Override // java.lang.Runnable
        public void run() {
            TaskAddTextFile.this.addMarkdown(this.val$inputValues, this.val$stringBuilders, new AddCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddTextFile.2.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddTextFile.AddCallback
                public void onEnd() {
                    Logger.m11003i(TaskAddTextFile.TAG, "addMarkdown# onEnd");
                    TaskAddTextFile.this.mExecutorService.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddTextFile.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AbstractC8014b.m7222x(new StringBuilder("addMarkdown#notifyCallback needToBeginHistory : "), RunnableC99822.this.val$needToBeginHistory, TaskAddTextFile.TAG);
                            RunnableC99822 runnableC99822 = RunnableC99822.this;
                            if (runnableC99822.val$needToBeginHistory) {
                                TaskAddTextFile.this.waitToEndCommitHistory(runnableC99822.val$note);
                            }
                            RunnableC99822 runnableC998222 = RunnableC99822.this;
                            TaskAddTextFile.this.notifyCallback(true, new ResultValues(runnableC998222.val$inputValues.mContext, RunnableC99822.this.val$inputValues.mObjectManager.getTextManager(), TaskAddTextFile.this.mOriginalFileName, TaskAddTextFile.this.mErrorType));
                        }
                    });
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddTextFile.AddCallback
                public void onStart() {
                    Logger.m11003i(TaskAddTextFile.TAG, "addMarkdown# onStart");
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AddCallback {
        void onEnd();

        void onStart();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ErrorType {
        ERROR_TYPE_SUCCESS,
        ERROR_TYPE_ERROR_MEMORY,
        ERROR_TYPE_OVER_NOTE_SIZE,
        ERROR_TYPE_CANCEL,
        ERROR_TYPE_ERROR_UNKNOWN
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final String mCacheDirPath;
        private final Context mContext;
        private final NoteManager mNoteManager;
        private final ObjectManager mObjectManager;
        private final boolean mToMarkdown;
        private final Integer mToPage;
        private final List<Uri> mUriList;

        public InputValues(Context context, NoteManager noteManager, ObjectManager objectManager, List<Uri> list, String str) {
            this(context, noteManager, objectManager, list, str, false, null);
        }

        public InputValues(Context context, NoteManager noteManager, ObjectManager objectManager, List<Uri> list, String str, boolean z, @Nullable Integer num) {
            this.mContext = context;
            this.mNoteManager = noteManager;
            this.mObjectManager = objectManager;
            this.mUriList = list;
            this.mCacheDirPath = str;
            this.mToMarkdown = z;
            this.mToPage = num;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMarkdown(InputValues inputValues, List<SpannableStringBuilder> list, AddCallback addCallback) {
        if (addCallback != null) {
            addCallback.onStart();
        }
        int iIntValue = inputValues.mToPage == null ? 0 : inputValues.mToPage.intValue();
        PointF insertedPosition = PositionUtil.getInsertedPosition(inputValues.mContext, inputValues.mObjectManager.getNote(), iIntValue);
        HtmlConverter htmlConverter = new HtmlConverter();
        List<Integer> listAsList = Arrays.asList(3, 21);
        ArrayList arrayList = new ArrayList();
        Iterator<SpannableStringBuilder> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(htmlConverter.makeSObjectListFromText(it.next().toString(), listAsList));
        }
        inputValues.mObjectManager.addObjectsFromHtml(iIntValue, arrayList, insertedPosition);
        if (addCallback != null) {
            addCallback.onEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attachTextFileList(InputValues inputValues) {
        boolean z;
        TaskAddTextFile taskAddTextFile;
        InputValues inputValues2;
        setState(3);
        SpenWNote note = inputValues.mObjectManager.getNote();
        if (note.isGroupingHistory()) {
            z = false;
        } else {
            waitToBeginCommitHistory(note);
            z = true;
        }
        if (checkCancelState(inputValues.mContext, false)) {
            if (z && note.isGroupingHistory()) {
                Logger.m11003i(TAG, "attachTextFile# clear beginHistory");
                waitToEndCommitHistory(note);
                return;
            }
            return;
        }
        if (checkCancelState(inputValues.mContext, false)) {
            taskAddTextFile = this;
            inputValues2 = inputValues;
        } else {
            Logger.m11003i(TAG, "attachTextFile# start");
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = this.mDownloadFileList.iterator();
            while (it.hasNext()) {
                SpannableStringBuilder spannableStringBuilderLoadTextFromFile = loadTextFromFile(it.next());
                Logger.m11003i(TAG, "attachTextFile# length = " + spannableStringBuilderLoadTextFromFile.length());
                if (spannableStringBuilderLoadTextFromFile.length() > 0) {
                    arrayList.add(spannableStringBuilderLoadTextFromFile);
                }
            }
            if (arrayList.isEmpty()) {
                this.mErrorType = ErrorType.ERROR_TYPE_ERROR_UNKNOWN;
                taskAddTextFile = this;
                inputValues2 = inputValues;
            } else {
                if (inputValues.mToMarkdown) {
                    new Handler(Looper.getMainLooper()).post(new RunnableC99822(inputValues, arrayList, z, note));
                    return;
                }
                taskAddTextFile = this;
                inputValues2 = inputValues;
                if (inputValues2.mNoteManager != null) {
                    inputValues2.mObjectManager.insertTextContents(arrayList, inputValues2.mNoteManager);
                    inputValues2.mNoteManager.updatePageLayout();
                }
            }
            Logger.m11003i(TAG, "attachTextFile# end");
        }
        if (z) {
            waitToEndCommitHistory(note);
        }
        notifyCallback(true, new ResultValues(inputValues2.mContext, inputValues2.mObjectManager.getTextManager(), taskAddTextFile.mOriginalFileName, taskAddTextFile.mErrorType));
    }

    private boolean checkCancelState(Context context) {
        return checkCancelState(context, true);
    }

    private String downloadTextFile(Context context, Uri uri, String str) {
        String str2;
        if (uri == null || TextUtils.isEmpty(uri.toString())) {
            Logger.m10999d(TAG, "downloadTextFile# uri is empty");
            this.mErrorType = ErrorType.ERROR_TYPE_ERROR_UNKNOWN;
            return null;
        }
        ContentPickerUtils.DownloadFileResult downloadFileResultDownloadText = ContentPickerUtils.downloadText(context, str, uri);
        int i = downloadFileResultDownloadText.mSaveResult;
        if (i == 0) {
            str2 = downloadFileResultDownloadText.mFilePath;
        } else {
            if (i == 1) {
                this.mErrorType = ErrorType.ERROR_TYPE_CANCEL;
                return null;
            }
            if (i == 2) {
                this.mErrorType = ErrorType.ERROR_TYPE_OVER_NOTE_SIZE;
                return null;
            }
            if (i == 3) {
                this.mErrorType = ErrorType.ERROR_TYPE_ERROR_MEMORY;
                return null;
            }
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        this.mErrorType = ErrorType.ERROR_TYPE_ERROR_UNKNOWN;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean downloadTextFileList(Context context, List<Uri> list, String str) {
        setState(1);
        this.mDownloadFileList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (checkCancelState(context)) {
                return false;
            }
            Uri uri = list.get(i);
            String strDownloadTextFile = downloadTextFile(context, uri, str);
            if (!TextUtils.isEmpty(strDownloadTextFile)) {
                this.mDownloadFileList.add(strDownloadTextFile);
                setFileName(context, uri);
            }
        }
        if (!this.mDownloadFileList.isEmpty()) {
            setState(2);
            return true;
        }
        Logger.m10999d(TAG, "downloadTextFileList mDownloadFileList is empty");
        notifyCallback(false, new ResultValues(context, this.mErrorType));
        return false;
    }

    private SpannableStringBuilder loadTextFromFile(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!AbstractC2322a.m1607A(str)) {
            Logger.m11000e(TAG, "loadTextFromFile# path not exist");
            return spannableStringBuilder;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                bufferedReader.close();
                                inputStreamReader.close();
                                fileInputStream.close();
                                return spannableStringBuilder;
                            }
                            spannableStringBuilder.append((CharSequence) line);
                            spannableStringBuilder.append('\n');
                        } finally {
                        }
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            AbstractC8014b.m7204f(e, new StringBuilder("loadTextFromFile# fail e: "), TAG);
            return spannableStringBuilder;
        }
    }

    private void setFileName(Context context, Uri uri) {
        if (uri == null || !TextUtils.isEmpty(this.mOriginalFileName)) {
            return;
        }
        String fileNameFromUri = FileUtils.getFileNameFromUri(context, uri);
        if (TextUtils.isEmpty(fileNameFromUri)) {
            Logger.m11003i(TAG, "setFileName# path is empty");
        } else if (fileNameFromUri.endsWith(Constants.TEXT_EXTENSION_WITH_DOT)) {
            this.mOriginalFileName = AbstractC2322a.m1614d(4, 0, fileNameFromUri);
        } else {
            this.mOriginalFileName = fileNameFromUri;
        }
    }

    private void setState(int i) {
        if (this.mCurState.get() == 100) {
            return;
        }
        AbstractC8014b.m7217s(i, "setState# ", TAG);
        this.mCurState.set(i);
    }

    private void waitToBeginCommitHistory(final SpenWNote spenWNote) {
        if (this.mRunnableToBeginHistoryGroup == null) {
            this.mRunnableToBeginHistoryGroup = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddTextFile.3
                @Override // java.lang.Runnable
                public void run() {
                    spenWNote.beginHistoryGroup();
                }
            };
        }
        waitToMainThread(this.mHandler, this.mRunnableToBeginHistoryGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitToEndCommitHistory(final SpenWNote spenWNote) {
        if (this.mRunnableToEndHistoryGroup == null) {
            this.mRunnableToEndHistoryGroup = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddTextFile.4
                @Override // java.lang.Runnable
                public void run() {
                    spenWNote.endHistoryGroup();
                }
            };
        }
        waitToMainThread(this.mHandler, this.mRunnableToEndHistoryGroup);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
        Logger.m11003i(TAG, "cancel# " + this.mCurState);
        if (iCancelCallback != null && this.mCurState.get() < 3) {
            iCancelCallback.onCancel(true);
        }
        setState(100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        Logger.m11003i(TAG, "clear#");
        cancel(null);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ((InputValues) getInputValue()).mObjectManager.getTextManager().setAutoScrollToCursorOnLayoutChanged(this.mIsAutoFocusEnabled);
        super.clear();
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

    private boolean checkCancelState(Context context, boolean z) {
        if (this.mCurState.get() != 100) {
            return false;
        }
        ErrorType errorType = ErrorType.ERROR_TYPE_CANCEL;
        this.mErrorType = errorType;
        if (!z) {
            return true;
        }
        notifyCallback(false, new ResultValues(context, errorType));
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        TextManager textManager = inputValues.mObjectManager.getTextManager();
        this.mIsAutoFocusEnabled = textManager.isAutoFocusEnabled();
        textManager.setAutoScrollToCursorOnLayoutChanged(false);
        this.mCurState.set(0);
        this.mHandler = new Handler();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddTextFile.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.m10999d(TaskAddTextFile.TAG, "executeTask");
                if (inputValues.mUriList == null || inputValues.mUriList.isEmpty()) {
                    TaskAddTextFile.this.notifyCallback(true, new ResultValues(inputValues.mContext, TaskAddTextFile.this.mErrorType));
                } else if (TaskAddTextFile.this.downloadTextFileList(inputValues.mContext, inputValues.mUriList, inputValues.mCacheDirPath)) {
                    try {
                        TaskAddTextFile.this.attachTextFileList(inputValues);
                    } catch (Exception e) {
                        Logger.m11001e(TaskAddTextFile.TAG, e.getMessage(), e);
                    }
                }
            }
        });
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        Context mContext;
        ErrorType mErrorType;
        String mOriginalFileName;
        TextManager mTextManager;

        public ResultValues(Context context, ErrorType errorType) {
            this.mContext = context;
            this.mErrorType = errorType;
        }

        public void showErrorToast(boolean z) {
            String string;
            Context context = this.mContext;
            if (context == null) {
                Logger.m11003i(TaskAddTextFile.TAG, "showErrorToast# context is null");
                return;
            }
            ErrorType errorType = this.mErrorType;
            if (errorType == ErrorType.ERROR_TYPE_ERROR_MEMORY) {
                if (z) {
                    string = DialogUtils.getNotEnoughStorageString(context);
                } else {
                    StorageChecker.showErrorDialog(context, 1);
                }
            } else if (errorType != ErrorType.ERROR_TYPE_OVER_NOTE_SIZE) {
                string = errorType == ErrorType.ERROR_TYPE_ERROR_UNKNOWN ? context.getResources().getString(C9086R.string.composer_can_not_open_file) : null;
            } else if (z) {
                string = DialogUtils.getOverSizeString(context);
            } else {
                StorageChecker.showErrorDialog(context, 2);
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            Logger.m11004w(TaskAddTextFile.TAG, string);
            ToastHandler.show(this.mContext, string, 0);
        }

        public void updateTitle() {
            if (TextUtils.isEmpty(this.mOriginalFileName) || !TextUtils.isEmpty(this.mTextManager.getTitle())) {
                return;
            }
            this.mTextManager.setTitle(this.mOriginalFileName);
        }

        public ResultValues(Context context, TextManager textManager, String str, ErrorType errorType) {
            this(context, errorType);
            this.mTextManager = textManager;
            this.mOriginalFileName = str;
        }
    }
}
