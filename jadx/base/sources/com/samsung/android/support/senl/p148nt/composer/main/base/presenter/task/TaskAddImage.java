package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Restriction;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;
import com.samsung.android.support.senl.p148nt.model.assist.common.C2paHandler;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.DownloadBitmap;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskAddImage extends SingleThreadTask<InputValues, ResultValues> {
    private static final int ERROR_COEDIT_OVER_MAX_COUNT_LARGE_ITEMS = 16;
    private static final int ERROR_EXCEED_ATTACH_COUNT = 8;
    private static final int ERROR_OVER_SIZE_NOTE = 4;
    private static final int ERROR_UNSUPPORTED_FILE = 1;
    private static final int ERROR_VIDEO = 2;
    private static final String TAG = Logger.createTag("TaskAddImage");
    ExecutorService mDownExecutorService;
    private TaskAddImageHandler mHandler;
    private List<ResultItem> mPathList;
    private int mError = 0;
    private boolean mIsCanceled = false;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddImage$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CallableC99693 implements Callable<Void> {
        final /* synthetic */ int val$index;
        final /* synthetic */ InputValues val$inputValues;
        final /* synthetic */ Uri val$uri;

        public CallableC99693(InputValues inputValues, Uri uri, int i) {
            this.val$inputValues = inputValues;
            this.val$uri = uri;
            this.val$index = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$call$0(ResultItem resultItem, File file) {
            try {
                resultItem.mOriginalPath = file.getPath();
            } catch (Exception e) {
                AbstractC8014b.m7207i("checkImageWithFile: e ", e, TaskAddImage.TAG);
            }
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            if (TaskAddImage.this.mIsCanceled) {
                return null;
            }
            String mimeType = UriFileUtils.getMimeType(this.val$inputValues.mContext, this.val$uri);
            Logger.m11003i(TaskAddImage.TAG, "download image# index : " + this.val$index + ", mimeType : " + mimeType);
            boolean z = true;
            if (TextUtils.isEmpty(mimeType)) {
                TaskAddImage.this.mError |= 1;
                return null;
            }
            if (mimeType.startsWith(Constants.MIME_VIDEO_START)) {
                TaskAddImage.this.mError |= 2;
                return null;
            }
            ResultItem resultItem = new ResultItem(null, this.val$index);
            String strSaveImageFromUri = DownloadBitmap.saveImageFromUri(this.val$inputValues.mContext, this.val$uri, mimeType, this.val$inputValues.mCachePath, new C10050c(resultItem, 0));
            if (TextUtils.isEmpty(strSaveImageFromUri) || !AbstractC2322a.m1607A(strSaveImageFromUri)) {
                TaskAddImage.this.mError |= 1;
                return null;
            }
            resultItem.mPath = strSaveImageFromUri;
            if (!TextUtils.isEmpty(resultItem.mOriginalPath)) {
                if (!ImageUtil.isGenerativeEditImage(resultItem.mOriginalPath) && !C2paHandler.getInstance().isC2paExist(resultItem.mOriginalPath)) {
                    z = false;
                }
                resultItem.mAIImage = z;
            }
            TaskAddImage.this.mPathList.add(resultItem);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultItem {
        public boolean mAIImage;
        private final int mIndex;
        public String mOriginalPath;
        protected String mPath;

        public ResultItem(String str, int i) {
            this.mPath = str;
            this.mIndex = i;
        }
    }

    /* JADX INFO: renamed from: g */
    public static /* bridge */ /* synthetic */ Callable m10602g(TaskAddImage taskAddImage, InputValues inputValues, Uri uri, int i) {
        return taskAddImage.getCallable(uri, i, inputValues);
    }

    @NonNull
    private Callable<Void> getCallable(Uri uri, int i, InputValues inputValues) {
        return new CallableC99693(inputValues, uri, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public List<ObjectManager.ImageData> getErrorCheckedList() {
        ArrayList arrayList = new ArrayList();
        Iterator<ResultItem> it = this.mPathList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ResultItem next = it.next();
            if (arrayList.size() >= 100) {
                this.mError |= 8;
                break;
            }
            if (next != null && !TextUtils.isEmpty(next.mPath)) {
                arrayList.add(next.mPath);
            }
        }
        List<String> listCheckAvailableStateToAdd = this.mStorageChecker.checkAvailableStateToAdd(arrayList);
        if (listCheckAvailableStateToAdd.size() != arrayList.size()) {
            this.mError |= 4;
        }
        ArrayList arrayList2 = new ArrayList();
        for (ResultItem resultItem : this.mPathList) {
            if (listCheckAvailableStateToAdd.contains(resultItem.mPath)) {
                arrayList2.add(new ObjectManager.ImageData(resultItem.mPath, resultItem.mAIImage));
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(final InputValues inputValues, List<ObjectManager.ImageData> list) {
        TaskAddImageHandler taskAddImageHandler = this.mHandler;
        if (taskAddImageHandler == null) {
            return;
        }
        taskAddImageHandler.init(inputValues.mObjectManager, inputValues.mTargetPageIndex, list, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddImage.2
            @Override // java.lang.Runnable
            public void run() {
                TaskAddImage.this.getTaskCallback().onSuccess(new ResultValues(inputValues.mContext, TaskAddImage.this.mError));
            }
        });
        TaskAddImageHandler taskAddImageHandler2 = this.mHandler;
        taskAddImageHandler2.sendMessage(taskAddImageHandler2.obtainMessage(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sortPathList() {
        Collections.sort(this.mPathList, new Comparator<ResultItem>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddImage.4
            @Override // java.util.Comparator
            public int compare(ResultItem resultItem, ResultItem resultItem2) {
                if (resultItem != null && resultItem2 != null) {
                    return Integer.compare(resultItem.mIndex, resultItem2.mIndex);
                }
                Logger.m11000e(TaskAddImage.TAG, "sortPathList# download image compare fail path1 : " + resultItem + ", path2 : " + resultItem2);
                return 0;
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
        Logger.m11003i(TAG, "cancel ");
        clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        Logger.m11003i(TAG, "clear ");
        this.mIsCanceled = true;
        TaskAddImageHandler taskAddImageHandler = this.mHandler;
        if (taskAddImageHandler != null) {
            taskAddImageHandler.release();
            this.mHandler = null;
        }
        ExecutorService executorService = this.mDownExecutorService;
        if (executorService != null) {
            executorService.shutdownNow();
        }
        super.clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToReload() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isNeedToCheckNoteSize() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        this.mHandler = new TaskAddImageHandler();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddImage.1
            private int getAvailableUriSize(int i) {
                if (i > 100) {
                    TaskAddImage.this.mError |= 8;
                    Logger.m11003i(TaskAddImage.TAG, "getAvailableUriSize# uriSize 100 /  max: 100");
                    i = 100;
                }
                if (inputValues.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote()) {
                    int largeSizeItemsCount = 100 - inputValues.mComposerModel.getComposerSpenDocModel().getLargeSizeItemsCount();
                    if (largeSizeItemsCount < 0) {
                        largeSizeItemsCount = 0;
                    }
                    if (i > largeSizeItemsCount) {
                        AbstractC14516b.m15114b(i, largeSizeItemsCount, "getAvailableUriSize# uriSize ", " /  availableCount: ", TaskAddImage.TAG);
                        TaskAddImage.this.mError |= 16;
                        return largeSizeItemsCount;
                    }
                }
                return i;
            }

            @Override // java.lang.Runnable
            public void run() {
                int size = inputValues.mUriList.size();
                AbstractC8014b.m7217s(size, "download image start : ", TaskAddImage.TAG);
                int availableUriSize = getAvailableUriSize(size);
                TaskAddImage.this.mPathList = Collections.synchronizedList(new ArrayList(availableUriSize));
                ArrayList arrayList = new ArrayList();
                Logger.startTime(String.valueOf(hashCode()), TaskAddImage.TAG, "download image start size = " + availableUriSize);
                for (int i = 0; i < availableUriSize; i++) {
                    arrayList.add(TaskAddImage.m10602g(TaskAddImage.this, inputValues, (Uri) inputValues.mUriList.get(i), i));
                }
                if (TaskAddImage.this.mIsCanceled) {
                    TaskAddImage.this.getTaskCallback().onError(new ResultValues(inputValues.mContext, TaskAddImage.this.mError));
                    return;
                }
                try {
                    TaskAddImage.this.mDownExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), new SenlThreadFactory(TaskAddImage.TAG));
                    TaskAddImage.this.mDownExecutorService.invokeAll(arrayList);
                    TaskAddImage.this.mDownExecutorService.shutdown();
                    TaskAddImage.this.mDownExecutorService.awaitTermination(1L, TimeUnit.SECONDS);
                    Logger.m11003i(TaskAddImage.TAG, "download image pathList : " + TaskAddImage.this.mPathList.size());
                    if (TaskAddImage.this.mIsCanceled) {
                        TaskAddImage.this.getTaskCallback().onError(new ResultValues(inputValues.mContext, TaskAddImage.this.mError));
                        return;
                    }
                    TaskAddImage.this.sortPathList();
                    Logger.endTime(String.valueOf(hashCode()), TaskAddImage.TAG, "download image end");
                    List errorCheckedList = TaskAddImage.this.getErrorCheckedList();
                    if (errorCheckedList.isEmpty()) {
                        Logger.m11000e(TaskAddImage.TAG, "download isEmpty ");
                        TaskAddImage.this.getTaskCallback().onError(new ResultValues(inputValues.mContext, TaskAddImage.this.mError));
                    } else if (!inputValues.mIsDownloadOnly) {
                        TaskAddImage.this.sendMessage(inputValues, errorCheckedList);
                    } else {
                        Logger.m10999d(TaskAddImage.TAG, "download only");
                        TaskAddImage.this.notifyCallback(true, new ResultValues(inputValues.mContext, TaskAddImage.this.mError, errorCheckedList));
                    }
                } catch (Exception e) {
                    Logger.m11000e(TaskAddImage.TAG, "download image fail : " + e.toString());
                    TaskAddImage.this.getTaskCallback().onError(new ResultValues(inputValues.mContext, TaskAddImage.this.mError));
                }
            }
        });
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private final Context mContext;
        private final int mErrorCode;
        private final List<ObjectManager.ImageData> mImageDataList;

        public ResultValues(Context context, int i) {
            this.mContext = context;
            this.mErrorCode = i;
            this.mImageDataList = null;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }

        public List<ObjectManager.ImageData> getImageDataList() {
            return this.mImageDataList;
        }

        public void showErrorToast() {
            AbstractC8014b.m7221w(new StringBuilder("showErrorToast#"), TaskAddImage.TAG, this.mErrorCode);
            int i = this.mErrorCode;
            if ((i & 1) != 0) {
                ToastHandler.show(this.mContext, C9086R.string.composer_failed_to_load_image, 0);
                return;
            }
            if ((i & 2) != 0) {
                ToastHandler.show(this.mContext, C9086R.string.composer_video_format_not_supported, 0);
                return;
            }
            if ((i & 4) != 0) {
                StorageChecker.showErrorDialog(this.mContext, 2);
                return;
            }
            if ((i & 8) != 0) {
                Context context = this.mContext;
                ToastHandler.show(context, context.getResources().getString(C9086R.string.composer_unable_to_insert_more_than, 100), 0);
            } else if ((i & 16) != 0) {
                Restriction.showToastCoeditErrorOverLargeMaxCount(this.mContext);
            }
        }

        public ResultValues(Context context, int i, List<ObjectManager.ImageData> list) {
            this.mContext = context;
            this.mErrorCode = i;
            this.mImageDataList = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final String mCachePath;
        private final ComposerModel mComposerModel;
        private final Context mContext;
        private boolean mIsDownloadOnly;
        private final ObjectManager mObjectManager;
        private final int mTargetPageIndex;
        private final List<Uri> mUriList;

        public InputValues(Context context, int i, List<Uri> list, ObjectManager objectManager, ComposerModel composerModel) {
            this.mContext = context;
            this.mTargetPageIndex = i;
            this.mUriList = list;
            this.mObjectManager = objectManager;
            this.mCachePath = objectManager.getCachePath();
            this.mComposerModel = composerModel;
        }

        public InputValues(Context context, List<Uri> list, boolean z, ObjectManager objectManager, ComposerModel composerModel) {
            this(context, 0, list, objectManager, composerModel);
            this.mIsDownloadOnly = z;
        }
    }
}
