package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.compose.runtime.AbstractC1974b;
import com.opencsv.bean.C6618c;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileExtensions;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.quicknote.ExtraDataHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.quicknote.LinkCardFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskWebClip;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.common.DownloadObjectHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.common.DownloadUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.common.TaskContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.WebCardUtil;
import com.samsung.android.support.senl.p148nt.model.assist.common.C2paHandler;
import com.samsung.android.support.senl.p148nt.model.base.utils.PositionUtil;
import com.samsung.android.support.senl.p148nt.model.base.utils.data.Content;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.MediaObjectSuggestionInfo;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.MessageSuggestionInfo;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfo;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.WebPageSuggestionInfo;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskQuickNote extends SingleThreadTask<InputValues, ResultValues> {
    public static final int ERROR_TYPE_CANCEL = 1;
    private static final String TAG = Logger.createTag("TaskQuickNote");
    private Future<?> mFuture;
    private QuickNoteAddHandler mHandler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GalleryContent extends SuggestedContent {
        public GalleryContent(int i) {
            super(i);
        }

        @SuppressLint({"DefaultLocale"})
        private String getFormattedSize(String str) {
            String str2;
            double d = Long.parseLong(str) / 1024.0d;
            double d2 = d / 1024.0d;
            if (((int) d2) > 0) {
                str2 = " MB";
                d = d2;
            } else {
                str2 = " KB";
            }
            return String.format("%4.2f", Double.valueOf(d)).concat(str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$makeImage$0(MediaObjectSuggestionInfo mediaObjectSuggestionInfo, String str) {
            ((Content.Image) this.mContent).setOriginalPath(mediaObjectSuggestionInfo.getPath());
        }

        private boolean makeImage(Context context, MediaObjectSuggestionInfo mediaObjectSuggestionInfo, String str) {
            String name = mediaObjectSuggestionInfo.getName();
            if (TextUtils.isEmpty(name)) {
                Logger.m11000e(TaskQuickNote.TAG, "makeImage# name is empty");
                this.mContent.setError(256);
                return false;
            }
            String fileExt = FileUtils.getFileExt(name);
            StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
            sbM1324q.append(FileExtensions.getFileNameByTime("quickNote_" + name, fileExt));
            Content.Image image = new Content.Image(mediaObjectSuggestionInfo.getUri(), sbM1324q.toString());
            this.mContent = image;
            image.setMimeType(UriFileUtils.getMimeType(context, mediaObjectSuggestionInfo.getUri()));
            C2paHandler.getInstance().executeForGenerativeImage(mediaObjectSuggestionInfo.getPath(), new C6618c(this, mediaObjectSuggestionInfo, 6));
            if (fileExt.equals(Constants.THUMBNAIL_GIF_EXTENSION)) {
                return new DownloadObjectHelper.DownloadGifTask(context, (Content.Image) this.mContent).call().booleanValue();
            }
            if (ImageUtil.isImageType(fileExt)) {
                return new DownloadObjectHelper.DownloadImageTask(context, (Content.Image) this.mContent).call().booleanValue();
            }
            Logger.m11000e(TaskQuickNote.TAG, "makeImage# not supported format");
            this.mContent.setError(256);
            return false;
        }

        private boolean makeLink(Context context, MediaObjectSuggestionInfo mediaObjectSuggestionInfo, String str) {
            String string = mediaObjectSuggestionInfo.getUri().toString();
            JSONObject jSONObject = new JSONObject();
            try {
                new ExtraDataHelper().createJson(jSONObject, "android.intent.action.VIEW", string, Constants.MIME_IMAGE);
                Content.LinkCard linkCard = new Content.LinkCard(mediaObjectSuggestionInfo.getName(), mediaObjectSuggestionInfo.getPath(), mediaObjectSuggestionInfo.getPackageName(), jSONObject.toString());
                StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
                sbM1324q.append(FileExtensions.getFileNameByTime(LinkCardFactory.FILE_PREFIX, "jpg"));
                String string2 = sbM1324q.toString();
                mediaObjectSuggestionInfo.downloadThumbnail(context);
                ImageUtil.saveBitmapToFileCache(mediaObjectSuggestionInfo.getThumbnail(), string2, Bitmap.CompressFormat.JPEG, 95);
                linkCard.setPath(string2);
                Pair<Integer, Integer> resolution = mediaObjectSuggestionInfo.getResolution();
                linkCard.setDescription(getFormattedSize(mediaObjectSuggestionInfo.getSize()) + "\t" + resolution.first + "x" + resolution.second);
                linkCard.setImageTypeId(1);
                this.mContent = linkCard;
                return true;
            } catch (JSONException e) {
                Logger.m11000e(TaskQuickNote.TAG, "GalleryContent.makeLink# " + e.getMessage());
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskQuickNote.SuggestedContent
        public void cancel() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskQuickNote.SuggestedContent
        public Content.Base getContent() {
            return this.mContent;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskQuickNote.SuggestedContent
        public boolean makeContent(Context context, InputValues inputValues, String str, StorageChecker storageChecker) {
            MediaObjectSuggestionInfo mediaObjectSuggestionInfo = (MediaObjectSuggestionInfo) this.mSuggestionInfo;
            int i = this.mInputType;
            if (i == 1) {
                return makeImage(context, mediaObjectSuggestionInfo, str);
            }
            if (i == 2) {
                return makeLink(context, mediaObjectSuggestionInfo, str);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final ComposerModel mComposerModel;
        private final SuggestedContent mContent;
        private final Context mContext;
        private final boolean mIsBodyTextSelected;
        private final boolean mIsLimitPdfFileSize;
        private final NoteManager mNoteManager;
        private final ObjectManager mObjectManager;
        private final PageManager mPageManager;
        private final TaskContract.IPageScroller mPageScroller;
        private final PdfManager mPdfManager;
        private final int mTargetPageIndex;
        private final TextManager mTextManager;

        public InputValues(Context context, NoteManager noteManager, PdfManager pdfManager, PageManager pageManager, TextManager textManager, ObjectManager objectManager, TaskContract.IPageScroller iPageScroller, SuggestedContent suggestedContent, int i, boolean z, boolean z2, ComposerModel composerModel) {
            this.mContext = context;
            this.mNoteManager = noteManager;
            this.mPdfManager = pdfManager;
            this.mPageManager = pageManager;
            this.mTextManager = textManager;
            this.mObjectManager = objectManager;
            this.mPageScroller = iPageScroller;
            this.mContent = suggestedContent;
            this.mTargetPageIndex = i;
            this.mIsBodyTextSelected = z;
            this.mIsLimitPdfFileSize = z2;
            this.mComposerModel = composerModel;
        }

        public synchronized SuggestedContent getContent() {
            return this.mContent;
        }

        public Context getContext() {
            return this.mContext;
        }

        public ObjectManager getObjectManager() {
            return this.mObjectManager;
        }

        public int getTargetPageIndex() {
            return this.mTargetPageIndex;
        }

        public boolean isBodyTextSelected() {
            return this.mIsBodyTextSelected;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MessageContent extends SuggestedContent {
        public MessageContent(int i) {
            super(i);
        }

        private boolean makeLink(MessageSuggestionInfo messageSuggestionInfo, String str) {
            try {
                this.mContent = LinkCardFactory.createMessageCard(messageSuggestionInfo, str);
                return true;
            } catch (JSONException e) {
                Logger.m11000e(TaskQuickNote.TAG, "MessageContent.makeLink# " + e.getMessage());
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskQuickNote.SuggestedContent
        public void cancel() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskQuickNote.SuggestedContent
        public Content.Base getContent() {
            return this.mContent;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskQuickNote.SuggestedContent
        public boolean makeContent(Context context, InputValues inputValues, String str, StorageChecker storageChecker) {
            MessageSuggestionInfo messageSuggestionInfo = (MessageSuggestionInfo) this.mSuggestionInfo;
            if (this.mInputType == 2) {
                return makeLink(messageSuggestionInfo, str);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class QuickNoteAddHandler extends Handler {
        static final int MESSAGE_EXECUTE = 1;
        private final Task.Callback<ResultValues> mCallback;
        private Context mContext;
        private final boolean mIsBodyTextSelected;
        private ObjectManager mObjectManager;
        private SuggestedContent mSuggestedContent;
        private final int mTargetPageIndex;

        public QuickNoteAddHandler(InputValues inputValues, Task.Callback<ResultValues> callback) {
            super(Looper.getMainLooper());
            this.mContext = inputValues.getContext();
            this.mObjectManager = inputValues.getObjectManager();
            this.mSuggestedContent = inputValues.getContent();
            this.mTargetPageIndex = inputValues.getTargetPageIndex();
            this.mIsBodyTextSelected = inputValues.isBodyTextSelected();
            this.mCallback = callback;
        }

        private boolean checkNoteSize(Content.Base base) {
            StorageChecker storageChecker = new StorageChecker();
            if (!(base instanceof Content.DownloadAble) || base.getType() == 3) {
                return true;
            }
            return storageChecker.checkAvailableStateToAdd(((Content.DownloadAble) base).getPath());
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            boolean z = true;
            if (message.what != 1) {
                return;
            }
            Content.Base content = this.mSuggestedContent.getContent();
            if (!checkNoteSize(content)) {
                this.mCallback.onError(new ResultValues(this.mContext, 1024));
                return;
            }
            PointF insertedPosition = !this.mIsBodyTextSelected ? PositionUtil.getInsertedPosition(this.mContext, this.mObjectManager.getNote(), this.mTargetPageIndex, false) : null;
            ArrayList arrayList = new ArrayList();
            arrayList.add(content);
            if (this.mObjectManager.getNote().isGroupingHistory()) {
                z = false;
            } else {
                this.mObjectManager.getNote().beginHistoryGroup();
            }
            Pair<SpenObjectBase, Boolean> pairAddContents = this.mObjectManager.addContents(this.mTargetPageIndex, arrayList, insertedPosition, false);
            if (z) {
                this.mObjectManager.getNote().endHistoryGroup();
            }
            if (((Boolean) pairAddContents.second).booleanValue()) {
                Object obj = pairAddContents.first;
                if (obj != null) {
                    this.mObjectManager.selectObject((SpenObjectBase) obj);
                }
                this.mCallback.onSuccess(new ResultValues(this.mContext, 0));
            } else {
                this.mCallback.onError(new ResultValues(this.mContext, 256));
            }
            release();
        }

        public void release() {
            this.mContext = null;
            this.mObjectManager = null;
            this.mSuggestedContent = null;
            removeCallbacksAndMessages(null);
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

        public int getErrorCode() {
            return this.mErrorCode;
        }

        public void showErrorToast() {
            if (this.mContext == null) {
                Logger.m11000e(TaskQuickNote.TAG, "showErrorToast# context is null. error code - " + this.mErrorCode);
                return;
            }
            AbstractC8014b.m7195A(new StringBuilder("showErrorToast#"), TaskQuickNote.TAG, this.mErrorCode);
            DownloadUtil.showErrorToast(this.mContext, this.mErrorCode);
            this.mContext = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SBrowserContent extends SuggestedContent {
        private Content.Base mContent;
        private TaskWebClip mTaskWebClip;

        public SBrowserContent(int i) {
            super(i);
        }

        private boolean makeWebCard(Context context, WebPageSuggestionInfo webPageSuggestionInfo, String str) {
            String url = webPageSuggestionInfo.getUrl();
            try {
                new ExtraDataHelper().createJson(new JSONObject(), "android.intent.action.VIEW", url, null);
                Content.WebCard webCard = new Content.WebCard(webPageSuggestionInfo.getTitle(), url);
                this.mContent = webCard;
                try {
                    return new DownloadObjectHelper.DownloadWebCardTask(context, webCard, str, WebCardUtil.isShowWebPreviewsEnabled()).call().booleanValue();
                } catch (Exception e) {
                    Logger.m11000e(TaskQuickNote.TAG, e.getMessage());
                    return false;
                }
            } catch (JSONException e2) {
                Logger.m11000e(TaskQuickNote.TAG, "SBrowserContent.makeWebCard# " + e2.getMessage());
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskQuickNote.SuggestedContent
        public void cancel() {
            TaskWebClip taskWebClip = this.mTaskWebClip;
            if (taskWebClip != null) {
                taskWebClip.clear();
                this.mTaskWebClip = null;
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskQuickNote.SuggestedContent
        public Content.Base getContent() {
            return this.mContent;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskQuickNote.SuggestedContent
        public boolean makeContent(Context context, InputValues inputValues, String str, StorageChecker storageChecker) {
            WebPageSuggestionInfo webPageSuggestionInfo = (WebPageSuggestionInfo) this.mSuggestionInfo;
            final boolean[] zArr = {false};
            int i = this.mInputType;
            if (i == 2) {
                zArr[0] = makeWebCard(context, webPageSuggestionInfo, str);
            } else if (i == 1) {
                this.mContent = new Content.WebClip(webPageSuggestionInfo.getUrl());
                TaskWebClip.InputValues inputValues2 = new TaskWebClip.InputValues(context, inputValues.mNoteManager, inputValues.mPdfManager, inputValues.mPageManager, inputValues.mTextManager, inputValues.mPageScroller, webPageSuggestionInfo.getUrl(), inputValues.mIsLimitPdfFileSize, inputValues.mObjectManager, inputValues.mComposerModel);
                TaskWebClip taskWebClip = new TaskWebClip();
                this.mTaskWebClip = taskWebClip;
                taskWebClip.setStorageChecker(storageChecker);
                this.mTaskWebClip.setTaskCallback(new Task.Callback<TaskWebClip.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskQuickNote.SBrowserContent.1
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                    public void onError(TaskWebClip.ResultValues resultValues) {
                        Logger.m10999d(TaskQuickNote.TAG, "add content error: " + resultValues.getErrorCode());
                        zArr[0] = false;
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                    public void onSuccess(TaskWebClip.ResultValues resultValues) {
                        Logger.m10999d(TaskQuickNote.TAG, "add content done");
                        zArr[0] = true;
                    }
                });
                this.mTaskWebClip.setInputValue(inputValues2);
                this.mTaskWebClip.setTimeStart(System.currentTimeMillis());
                this.mTaskWebClip.executeTask(inputValues2);
            }
            return zArr[0];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SuggestedContent {
        public static final int INPUT_TYPE_CONTENT = 1;
        public static final int INPUT_TYPE_LINK = 2;
        Content.Base mContent;
        int mInputType;
        private boolean mIsMaking = false;
        SuggestionInfo mSuggestionInfo;

        public SuggestedContent(int i) {
            this.mInputType = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean makeContentWrap(Context context, InputValues inputValues, String str, StorageChecker storageChecker) {
            this.mIsMaking = true;
            boolean zMakeContent = makeContent(context, inputValues, str, storageChecker);
            this.mIsMaking = false;
            return zMakeContent;
        }

        public abstract void cancel();

        public abstract Content.Base getContent();

        public int getError() {
            Content.Base base = this.mContent;
            if (base == null) {
                return 0;
            }
            return base.getError();
        }

        public SuggestionInfo getSuggestionInfo() {
            return this.mSuggestionInfo;
        }

        public boolean isMaking() {
            return this.mIsMaking;
        }

        public abstract boolean makeContent(Context context, InputValues inputValues, String str, StorageChecker storageChecker);

        public void setSuggestionInfo(SuggestionInfo suggestionInfo) {
            this.mSuggestionInfo = suggestionInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeTask$0(InputValues inputValues) {
        waitSuggestedResult(inputValues);
        if (inputValues.getContent().mSuggestionInfo == null) {
            Logger.m10999d(TAG, "run# fail to get SuggestedResult");
            notifyCallback(false, new ResultValues(inputValues.getContext(), 1));
            return;
        }
        Logger.m10999d(TAG, "run# " + inputValues.getContent().mSuggestionInfo);
        try {
            if (!inputValues.getContent().makeContentWrap(inputValues.getContext(), inputValues, inputValues.getObjectManager().getCachePath(), this.mStorageChecker)) {
                notifyCallback(false, new ResultValues(inputValues.getContext(), inputValues.getContent().getError()));
            } else if (inputValues.getContent().getContent() instanceof Content.WebClip) {
                notifyCallback(true, new ResultValues(inputValues.getContext(), inputValues.getContent().getError()));
            } else {
                QuickNoteAddHandler quickNoteAddHandler = this.mHandler;
                quickNoteAddHandler.sendMessage(quickNoteAddHandler.obtainMessage(1));
            }
        } catch (Exception e) {
            Logger.m11001e(TAG, "run#makeContent# " + e.getMessage(), e);
            notifyCallback(false, new ResultValues(inputValues.getContext(), 256));
        }
    }

    private void waitSuggestedResult(InputValues inputValues) {
        while (inputValues.getContent().mSuggestionInfo == null && this.mFuture != null) {
            try {
                Logger.m10999d(TAG, "waitSuggestedResult#");
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                Logger.m11000e(TAG, "waitSuggestedResult# interrupted msg: " + e.getMessage());
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
        super.cancel(iCancelCallback);
        String str = TAG;
        Logger.m11003i(str, "cancel#");
        Future<?> future = this.mFuture;
        if (future != null) {
            future.cancel(true);
        }
        if (((InputValues) getInputValue()).getContent() != null) {
            ((InputValues) getInputValue()).getContent().cancel();
            Logger.m11003i(str, "cancel# content is making: " + ((InputValues) getInputValue()).getContent().isMaking());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        super.clear();
        Logger.m11003i(TAG, "clear#");
        QuickNoteAddHandler quickNoteAddHandler = this.mHandler;
        if (quickNoteAddHandler != null) {
            quickNoteAddHandler.release();
            this.mHandler = null;
        }
        cancel(null);
        this.mFuture = null;
    }

    public Task.Callback<ResultValues> getDefaultCallback() {
        return new Task.Callback<ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskQuickNote.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(ResultValues resultValues) {
                resultValues.showErrorToast();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(ResultValues resultValues) {
                resultValues.showErrorToast();
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isKeepTaskDuringActivityRecreation() {
        return true;
    }

    public void wakeUp() {
        Logger.m10999d(TAG, "wakeUp# ");
        Future<?> future = this.mFuture;
        if (future != null) {
            future.cancel(true);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(InputValues inputValues) {
        this.mHandler = new QuickNoteAddHandler(inputValues, getTaskCallback());
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        this.mFuture = executorServiceNewSingleThreadExecutor.submit(new RunnableC9844c(this, inputValues, 12));
    }
}
