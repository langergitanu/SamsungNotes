package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.image;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.image.FileOperationTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TEImageModel {
    private static final String TAG = CTLogger.createTag("TEImageModel");
    private Bitmap mBitmap;
    private FileOperationTask.ICallback mCallback;
    private FileOperationTask mFileOperationTask = null;
    private String mNewPath;
    private int mPageWidth;
    private int mPpageHeight;
    private String mResultImagePath;
    private String mTemplateName;

    public TEImageModel(Bitmap bitmap, String str, int i, int i2, String str2) {
        this.mBitmap = bitmap;
        this.mResultImagePath = str;
        this.mTemplateName = FileUtils.extractFileName(str);
        this.mPageWidth = i;
        this.mPpageHeight = i2;
        this.mNewPath = str2;
    }

    public void applyImage(Bitmap bitmap) {
        String str = this.mResultImagePath;
        if (!TextUtils.isEmpty(this.mNewPath)) {
            str = this.mNewPath;
        }
        FileOperationTask fileOperationTask = new FileOperationTask(bitmap, str, this.mCallback);
        this.mFileOperationTask = fileOperationTask;
        fileOperationTask.executeOnExecutor(Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG)), new Void[0]);
    }

    public void close() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mBitmap.recycle();
        }
        this.mBitmap = null;
        this.mFileOperationTask = null;
        this.mCallback = null;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public String getNewPath() {
        return this.mNewPath;
    }

    public int getPageHeight() {
        return this.mPpageHeight;
    }

    public int getPageWidth() {
        return this.mPageWidth;
    }

    public String getResultPath() {
        return this.mResultImagePath;
    }

    public String getTemplateName() {
        return this.mTemplateName;
    }

    public void setCallback(FileOperationTask.ICallback iCallback) {
        this.mCallback = iCallback;
    }

    public void setTemplateName(String str) {
        this.mTemplateName = str;
    }
}
