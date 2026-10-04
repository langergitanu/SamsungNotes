package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.HandleImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskPhotoEditor extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskPhotoEditor");

    private static void delete(File file, ContentResolver contentResolver, Uri uri) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        if (contentResolver.delete(uri, "_data=?", new String[]{canonicalPath}) == 0) {
            String absolutePath = file.getAbsolutePath();
            if (!absolutePath.equals(canonicalPath)) {
                contentResolver.delete(uri, "_data=?", new String[]{absolutePath});
            }
        }
        if (file.delete()) {
            return;
        }
        Logger.m11000e(TAG, "deleteFiles# file delete error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void deleteFiles(Context context, File file) {
        try {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                if (file.delete()) {
                    return;
                }
                Logger.m11000e(TAG, "deleteFiles# directory delete error");
                return;
            }
            ContentResolver contentResolver = context.getContentResolver();
            Uri contentUri = MediaStore.Files.getContentUri("external");
            for (File file2 : fileArrListFiles) {
                delete(file2, contentResolver, contentUri);
            }
            if (file.delete()) {
                return;
            }
            Logger.m11000e(TAG, "deleteFiles# directory delete error");
        } catch (Exception e) {
            AbstractC8014b.m7207i("deleteFiles# Exception:", e, TAG);
        }
    }

    private void handleImage(Context context, SpenObjectImage spenObjectImage) {
        File imageStorageDir = getImageStorageDir(context, true);
        if (imageStorageDir == null) {
            Logger.m11000e(TAG, "handleImage, failed to create imageStorageDir.");
            notifyCallback(false, null);
            return;
        }
        String strSaveAsImage = new HandleImage().saveAsImage(spenObjectImage, imageStorageDir.getAbsolutePath(), "", true);
        if (TextUtils.isEmpty(strSaveAsImage) || !AbstractC2322a.m1607A(strSaveAsImage)) {
            Logger.m11000e(TAG, "handleImage# failed to saveAsImage");
            notifyCallback(false, null);
            return;
        }
        Logger.m11003i(TAG, "handleImage, newPath: " + Logger.getEncode(strSaveAsImage));
        notifyCallback(true, new ResultValues(context, strSaveAsImage, imageStorageDir));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeTask$0(InputValues inputValues) {
        if (inputValues.mImageObject == null) {
            notifyCallback(true, new ResultValues(inputValues.mContext, getImageStorageDir(inputValues.mContext, false)));
        } else {
            handleImage(inputValues.mContext, inputValues.mImageObject);
        }
    }

    public Task.Callback<ResultValues> getDefaultCallback() {
        return new Task.Callback<ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskPhotoEditor.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(ResultValues resultValues) {
                resultValues.clearImageStorageDir();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(ResultValues resultValues) {
                resultValues.clearImageStorageDir();
            }
        };
    }

    public File getImageStorageDir(Context context, boolean z) {
        String string = context.getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C9086R.string.composer_save_to_image_dir_galaxy : C9086R.string.composer_save_to_image_dir);
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), string);
        if (!file.exists()) {
            if (!z) {
                return null;
            }
            if (!file.mkdir()) {
                AbstractC8014b.m7198D("getExternalImageStorageDir, can not create a albumName: ", string, TAG);
                return null;
            }
        }
        return file;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final Context mContext;
        private SpenObjectImage mImageObject;

        public InputValues(Context context) {
            this.mContext = context;
        }

        public InputValues(Context context, SpenObjectImage spenObjectImage) {
            this(context);
            this.mImageObject = spenObjectImage;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new RunnableC9844c(this, inputValues, 11));
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private final Context mContext;
        private String mImagePath;
        private final File mImageStorageDir;

        public ResultValues(Context context, File file) {
            this.mContext = context;
            this.mImageStorageDir = file;
        }

        public void clearImageStorageDir() {
            Logger.m11003i(TaskPhotoEditor.TAG, "clearImageStorageDir# ");
            File file = this.mImageStorageDir;
            if (file == null) {
                return;
            }
            TaskPhotoEditor.deleteFiles(this.mContext, file);
        }

        public String getImagePath() {
            return this.mImagePath;
        }

        public ResultValues(Context context, String str, File file) {
            this(context, file);
            this.mImagePath = str;
        }
    }
}
