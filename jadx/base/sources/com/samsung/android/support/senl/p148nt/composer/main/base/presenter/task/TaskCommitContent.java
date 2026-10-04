package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.ClipDescription;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.BitmapInspector;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;
import com.samsung.android.support.senl.p148nt.model.assist.common.C2paHandler;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.DownloadBitmap;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskCommitContent extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskCommitContent");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final Context mContext;
        private final InputContentInfoCompat mInputContentInfo;
        private final ObjectManager mObjectManager;
        private String mOriginalPath;
        private final PageManager mPageManager;

        public InputValues(Context context, ObjectManager objectManager, PageManager pageManager, InputContentInfoCompat inputContentInfoCompat) {
            this.mContext = context;
            this.mObjectManager = objectManager;
            this.mPageManager = pageManager;
            this.mInputContentInfo = inputContentInfoCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$executeTask$0(InputValues inputValues, File file) {
        inputValues.mOriginalPath = file.getPath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$executeTask$1(InputValues inputValues) throws Throwable {
        InputValues inputValues2;
        String str;
        StringBuilder sb;
        Uri contentUri;
        String strSaveImageFromUri;
        String str2;
        boolean z = false;
        ResultValues resultValues = null;
        try {
            try {
                contentUri = inputValues.mInputContentInfo.getContentUri();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                try {
                    inputValues.mInputContentInfo.releasePermission();
                } catch (Exception e) {
                    AbstractC8014b.m7205g(e, new StringBuilder("InputContentInfoCompat releasePermission Exception - "), TAG);
                }
                notifyCallback(false, null);
                throw th2;
            }
        } catch (Exception e2) {
            e = e2;
            inputValues2 = inputValues;
        } catch (Throwable th3) {
            th = th3;
            Throwable th22 = th;
            inputValues.mInputContentInfo.releasePermission();
            notifyCallback(false, null);
            throw th22;
        }
        if (!BitmapInspector.isValid(inputValues.mContext, contentUri)) {
            Logger.m11000e(TAG, "Bitmap is not valid");
            try {
                inputValues.mInputContentInfo.releasePermission();
            } catch (Exception e3) {
                AbstractC8014b.m7205g(e3, new StringBuilder("InputContentInfoCompat releasePermission Exception - "), TAG);
            }
            notifyCallback(false, null);
            return;
        }
        String lastPathSegment = contentUri.getLastPathSegment();
        if (lastPathSegment != null && lastPathSegment.toLowerCase().endsWith(".dcf")) {
            Logger.m11000e(TAG, "File format is unsupported.");
            try {
                inputValues.mInputContentInfo.releasePermission();
            } catch (Exception e5) {
                AbstractC8014b.m7205g(e5, new StringBuilder("InputContentInfoCompat releasePermission Exception - "), TAG);
            }
            notifyCallback(false, null);
            return;
        }
        String mimeType = UriFileUtils.getMimeType(inputValues.mContext, contentUri);
        if (TextUtils.isEmpty(mimeType) || "application/octet-stream".equals(mimeType)) {
            ClipDescription description = inputValues.mInputContentInfo.getDescription();
            int mimeTypeCount = description.getMimeTypeCount();
            if (mimeTypeCount == 1) {
                mimeType = description.getMimeType(0);
                Logger.m11003i(TAG, "commit clipDescriptionMimeType : " + mimeType);
            } else {
                Logger.m11000e(TAG, "commit fail mimeTypeCount: " + mimeTypeCount);
            }
        }
        inputValues2 = inputValues;
        try {
            strSaveImageFromUri = DownloadBitmap.saveImageFromUri(inputValues.mContext, contentUri, mimeType, ((InputValues) getInputValue()).mObjectManager.getCachePath(), new C10050c(inputValues2, 2));
            str2 = TAG;
            Logger.m11003i(str2, "commit content image path : " + LoggerBase.getEncode(strSaveImageFromUri));
        } catch (Exception e6) {
            e = e6;
            Logger.m11001e(TAG, "Failed to save commit content - ", e);
            try {
                inputValues2.mInputContentInfo.releasePermission();
            } catch (Exception e7) {
                e = e7;
                str = TAG;
                sb = new StringBuilder("InputContentInfoCompat releasePermission Exception - ");
                AbstractC8014b.m7205g(e, sb, str);
            }
        }
        if (!TextUtils.isEmpty(strSaveImageFromUri) && new File(strSaveImageFromUri).exists()) {
            if (!this.mStorageChecker.checkAvailableStateToAdd(strSaveImageFromUri)) {
                ResultValues resultValues2 = new ResultValues(inputValues2.mContext);
                try {
                    inputValues2.mInputContentInfo.releasePermission();
                    resultValues = resultValues2;
                } catch (Exception e8) {
                    AbstractC8014b.m7205g(e8, new StringBuilder("InputContentInfoCompat releasePermission Exception - "), TAG);
                }
                notifyCallback(false, resultValues);
                return;
            }
            ResultValues resultValues3 = new ResultValues(inputValues2.mObjectManager, inputValues2.mPageManager.getDocPageInfo().getCurrentPageIndex(), strSaveImageFromUri, inputValues2.mOriginalPath, ImageUtil.isGenerativeEditImage(strSaveImageFromUri) || C2paHandler.getInstance().isC2paExist(strSaveImageFromUri));
            try {
                inputValues2.mInputContentInfo.releasePermission();
                z = true;
                resultValues = resultValues3;
            } catch (Exception e9) {
                e = e9;
                str = TAG;
                sb = new StringBuilder("InputContentInfoCompat releasePermission Exception - ");
                AbstractC8014b.m7205g(e, sb, str);
            }
            notifyCallback(z, resultValues);
            return;
        }
        Logger.m11000e(str2, "Failed to save commit content - not exists");
        try {
            inputValues2.mInputContentInfo.releasePermission();
        } catch (Exception e10) {
            AbstractC8014b.m7205g(e10, new StringBuilder("InputContentInfoCompat releasePermission Exception - "), TAG);
        }
        notifyCallback(false, null);
    }

    public Task.Callback<ResultValues> getDefaultCallback() {
        return new Task.Callback<ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskCommitContent.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(ResultValues resultValues) {
                if (resultValues != null) {
                    resultValues.showErrorDialog();
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(ResultValues resultValues) {
                try {
                    if (!resultValues.mObjectManager.isSelectedBodyText()) {
                        resultValues.mObjectManager.selectObject(resultValues.mObjectManager.getNote().getBodyText());
                    }
                    SpenObjectImage spenObjectImageInsertImage = resultValues.mObjectManager.insertImage(resultValues.mPageIndex, resultValues.mPath, true, false);
                    if (resultValues.mMarkGEFlag) {
                        resultValues.mObjectManager.addGenerativeEditExtraData(spenObjectImageInsertImage);
                    }
                } catch (Exception e) {
                    AbstractC8014b.m7205g(e, new StringBuilder("fail to insert image: "), TaskCommitContent.TAG);
                }
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToSave() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isNeedToCheckNoteSize() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(InputValues inputValues) {
        try {
            inputValues.mInputContentInfo.requestPermission();
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
            this.mExecutorService = executorServiceNewSingleThreadExecutor;
            executorServiceNewSingleThreadExecutor.execute(new RunnableC9844c(this, inputValues, 10));
        } catch (Exception e) {
            AbstractC8014b.m7205g(e, new StringBuilder("InputContentInfoCompat requestPermission Exception - "), TAG);
            notifyCallback(false, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private Context mContext;
        private boolean mMarkGEFlag;
        private ObjectManager mObjectManager;
        private String mOriginalPath;
        private boolean mOverSize;
        private int mPageIndex;
        private String mPath;

        public ResultValues(ObjectManager objectManager, int i, String str, String str2, boolean z) {
            this.mObjectManager = objectManager;
            this.mPageIndex = i;
            this.mPath = str;
            this.mOriginalPath = str2;
            this.mMarkGEFlag = z;
        }

        public void showErrorDialog() {
            Context context = this.mContext;
            if (context == null || !this.mOverSize) {
                return;
            }
            StorageChecker.showErrorDialog(context, 2);
        }

        public ResultValues(Context context) {
            this.mContext = context;
            this.mOverSize = true;
        }
    }
}
