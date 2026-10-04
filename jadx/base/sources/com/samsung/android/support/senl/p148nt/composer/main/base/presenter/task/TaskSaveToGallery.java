package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.opencsv.bean.C6618c;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.FileExtensions;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.HandleImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.UriHelper;
import com.samsung.android.support.senl.p148nt.model.assist.common.C2paHandler;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskSaveToGallery extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskSaveToGallery");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final Context mContext;
        private final ObjectManager mObjectManager;
        private final ArrayList<SpenObjectBase> mSelectedObjectList;

        public InputValues(Context context, ObjectManager objectManager) {
            this.mContext = context;
            this.mObjectManager = objectManager;
            this.mSelectedObjectList = objectManager.getSelectedSafeObjectList();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
    }

    private File getExternalImageStorageDir(String str) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), str);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        AbstractC8014b.m7198D("getExternalImageStorageDir, can not create a albumName: ", str, TAG);
        return null;
    }

    private boolean handleHWContent(Context context, ObjectManager objectManager) {
        Bitmap selectedObjectBitmap = objectManager.getSelectedObjectBitmap();
        if (selectedObjectBitmap != null) {
            File externalImageStorageDir = getExternalImageStorageDir(context.getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C9086R.string.composer_save_to_image_dir_galaxy : C9086R.string.composer_save_to_image_dir));
            if (externalImageStorageDir == null) {
                Logger.m11000e(TAG, "handleHWContent# failed to create path.");
                return false;
            }
            String fileNameByTime = FileExtensions.getFileNameByTime("", "jpg");
            StringBuilder sb = new StringBuilder();
            sb.append(externalImageStorageDir.getAbsolutePath());
            String strM1170p = AbstractC0622a.m1170p(File.separator, fileNameByTime, sb);
            if (ImageUtil.saveBitmapToFileCache(selectedObjectBitmap, strM1170p, Bitmap.CompressFormat.JPEG, 95, objectManager.getNote().getPage(0).getBackgroundColor()) && AbstractC2322a.m1607A(strM1170p)) {
                List<SpenObjectBase> selectedObjectList = objectManager.getSelectedObjectList();
                SpenObjectImage spenObjectImage = (SpenObjectImage) selectedObjectList.get(0);
                if (selectedObjectList.size() == 1) {
                    C2paHandler.getInstance().executeForGenerativeImage(strM1170p, new C6618c(strM1170p, spenObjectImage, 7));
                }
                Uri mediaUri = UriHelper.getMediaUri(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strM1170p, "image/jpeg", false);
                Logger.m10999d(TAG, "handleHWContent# bitmap saved, uri: " + mediaUri);
                return true;
            }
        }
        return false;
    }

    private boolean handleImageContent(Context context, SpenObjectBase spenObjectBase) {
        String str = TAG;
        Logger.m10999d(str, "handleImageContent#");
        File externalImageStorageDir = getExternalImageStorageDir(context.getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C9086R.string.composer_save_to_image_dir_galaxy : C9086R.string.composer_save_to_image_dir));
        if (externalImageStorageDir == null) {
            Logger.m11000e(str, "handleImageContent, failed to create externalPath.");
            return false;
        }
        String strSaveAsImage = new HandleImage().saveAsImage(spenObjectBase, externalImageStorageDir.getAbsolutePath(), "", true);
        if (TextUtils.isEmpty(strSaveAsImage)) {
            Logger.m10999d(str, "handleImageContent, newPath is null");
            return false;
        }
        Logger.m10999d(str, "handleImageContent, newPath: " + Logger.getEncode(strSaveAsImage));
        if (!new File(strSaveAsImage).exists()) {
            return false;
        }
        Logger.m10999d(str, "handleImageContent, uri: " + UriHelper.getMediaUri(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strSaveAsImage, null, false));
        return true;
    }

    private boolean isSpiImage(SpenObjectBase spenObjectBase) {
        if (spenObjectBase.getType() != 3) {
            return false;
        }
        SpenObjectImage spenObjectImage = (SpenObjectImage) spenObjectBase;
        if (TextUtils.isEmpty(spenObjectImage.getImagePath())) {
            return false;
        }
        return spenObjectImage.getImagePath().toLowerCase().endsWith(".spi");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeTask$0(InputValues inputValues) {
        notifyCallback(handleHWContent(inputValues.mContext, inputValues.mObjectManager), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeTask$1(InputValues inputValues, SpenObjectBase spenObjectBase) {
        notifyCallback(handleImageContent(inputValues.mContext, spenObjectBase), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleHWContent$2(String str, SpenObjectImage spenObjectImage, String str2) {
        ImageUtil.addGenerativeEditData(str);
        C2paHandler.getInstance().copyAndAppendC2paManifestTargetImage(str, spenObjectImage.getImagePath(), spenObjectImage.getOriginalImagePath(), spenObjectImage.getCropRect());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(InputValues inputValues) {
        Runnable runnableC9844c = null;
        if (inputValues.mSelectedObjectList == null || inputValues.mSelectedObjectList.isEmpty()) {
            Logger.m11000e(TAG, "executeTask# selectedObjectList is empty");
            notifyCallback(false, null);
            return;
        }
        SpenObjectBase spenObjectBase = (SpenObjectBase) inputValues.mSelectedObjectList.get(0);
        if (inputValues.mSelectedObjectList.size() > 1 || spenObjectBase.getType() == 1 || isSpiImage(spenObjectBase)) {
            runnableC9844c = new RunnableC9844c(this, inputValues, 13);
        } else if (spenObjectBase.getType() == 3 || spenObjectBase.getType() == 14) {
            runnableC9844c = new RunnableC8928b(this, 14, inputValues, spenObjectBase);
        }
        if (runnableC9844c != null) {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
            this.mExecutorService = executorServiceNewSingleThreadExecutor;
            executorServiceNewSingleThreadExecutor.execute(runnableC9844c);
        }
    }
}
