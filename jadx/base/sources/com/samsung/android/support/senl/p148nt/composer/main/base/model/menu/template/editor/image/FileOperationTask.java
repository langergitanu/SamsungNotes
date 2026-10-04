package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.image;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FileOperationTask extends AsyncTask<Void, Void, Bitmap> {
    private static final String TAG = CTLogger.createTag("FileOperationTask");
    private Bitmap mBitmap;
    private ICallback mCallback;
    private String mFilePath;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ICallback {
        void onEnd(boolean z);

        void onStarted();
    }

    public FileOperationTask(Bitmap bitmap, String str, ICallback iCallback) {
        this.mBitmap = bitmap;
        this.mFilePath = str;
        this.mCallback = iCallback;
    }

    private Bitmap saveResultBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.mFilePath);
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.close();
                    return bitmap;
                } finally {
                }
            } catch (Exception e) {
                AbstractC8014b.m7205g(e, new StringBuilder("saveResultBitmap, e : "), TAG);
            }
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        ICallback iCallback = this.mCallback;
        if (iCallback != null) {
            iCallback.onStarted();
        }
    }

    @Override // android.os.AsyncTask
    public Bitmap doInBackground(Void... voidArr) {
        return saveResultBitmap(this.mBitmap);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        Logger.m11003i(TAG, "onPostExecute, result : " + bitmap);
        boolean z = bitmap != null;
        ICallback iCallback = this.mCallback;
        if (iCallback != null) {
            iCallback.onEnd(z);
            this.mCallback = null;
        }
        this.mBitmap = null;
    }
}
