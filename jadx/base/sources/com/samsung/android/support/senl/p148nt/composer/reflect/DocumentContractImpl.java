package com.samsung.android.support.senl.p148nt.composer.reflect;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Environment;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentWeb;
import com.samsung.android.support.senl.document.contract.DocumentContract;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import com.samsung.android.support.senl.p148nt.base.common.constants.LockConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.web.LinkSourceContent;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.web.TextCrawler;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentContractImpl implements DocumentContract {
    private static final String TAG = Logger.createTag("DocumentContractImpl");

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f7348a = 0;

    private static Bitmap getCropBitmap(Bitmap bitmap, int i, int i2, int i4, int i5, boolean z) {
        String str = TAG;
        Logger.m10999d(str, "getCropBitmap w:" + bitmap.getWidth() + " h:" + bitmap.getHeight());
        StringBuilder sb = new StringBuilder("getCropBitmap ");
        AbstractC2821a.m2235z(sb, i, i2, " ", " ");
        sb.append(i4);
        sb.append(" ");
        sb.append(i5);
        Logger.m10999d(str, sb.toString());
        if (i + i4 > bitmap.getWidth()) {
            Logger.m11000e(str, "left + width must be <= bitmap.width()");
            return bitmap;
        }
        if (i2 + i5 > bitmap.getHeight()) {
            Logger.m11000e(str, "y + height must be <= bitmap.height()");
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i, i2, i4, i5, new Matrix(), false);
        if (z) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    private static File saveToCache(Context context, Bitmap bitmap, int i, int i2, int i4, int i5) {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            return saveToCacheDL(context, bitmap, i, i2, i4, i5);
        }
        return null;
    }

    private static File saveToCacheDL(Context context, Bitmap bitmap, int i, int i2, int i4, int i5) {
        Bitmap cropBitmap = getCropBitmap(bitmap, i, i2, i4, i5);
        if (cropBitmap == null) {
            return null;
        }
        String string = Long.toString(new Date().getTime());
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            File file = new File(externalFilesDir, AbstractC0541b.m756B(string, ".jpg"));
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    if (!cropBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)) {
                        Logger.m10999d(TAG, "image not saved");
                    }
                    cropBitmap.recycle();
                    fileOutputStream.close();
                    return file;
                } finally {
                }
            } catch (IOException unused) {
                Logger.m10999d(TAG, "Can't save image");
            }
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public Spanned charUtils_fromHtml(String str) {
        return CharUtils.fromHtml(str);
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public boolean detourUtils_commitEditor(SharedPreferences.Editor editor) {
        return false;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public String fileUtils_logPath(String str) {
        return FileUtils.logPath(str);
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public int getDocInitModeAppWidget() {
        return 2;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public String getExtraValueLockConfirmed() {
        return LockConstants.EXTRA_VALUE_LOCK_CONFIRMED;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public int getLockTypeSNB() {
        return 3;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public int getLockTypeSPD() {
        return 2;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public int getLockTypeTMEMO() {
        return 4;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public int getMaxTextureSize() {
        return ImageUtils.getMaxTextureSize();
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public String getNoteFilePath(Context context) {
        return WDocUtils.getNoteFilePath(context);
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public File getPrivateFile(Context context, String str) {
        return new File(PageCacheUtils.getThumbnailImagePath(context.getApplicationContext(), str));
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public Rect getScreenDimension(Context context) {
        return DisplayUtils.getScreenDimension(context);
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public int getThumbnailCompressQuality() {
        return 95;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public File imageUtils_saveToCache(Context context, Bitmap bitmap, int i, int i2, int i4, int i5) {
        return saveToCache(context, bitmap, i, i2, i4, i5);
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public boolean isAllActivityFinished() {
        return true;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public void logger_d(String str, String str2) {
        Logger.m10999d(str, str2);
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public void logger_e(String str, String str2) {
        Logger.m11000e(str, str2);
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public String logger_getEncode(String str) {
        return Logger.getEncode(str);
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public String logger_getLogFilePath(Context context) {
        return Logger.getLogFilePath(context);
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public void logger_i(String str, String str2) {
        Logger.m11003i(str, str2);
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public void makeWebCardData(SpenContentWeb spenContentWeb, MemoMetaDataItem memoMetaDataItem) {
        LinkSourceContent linkSourceContentMakePreview = new TextCrawler().makePreview(memoMetaDataItem.getURL());
        String title = linkSourceContentMakePreview.getTitle();
        String description = linkSourceContentMakePreview.getDescription();
        if (TextUtils.isEmpty(description)) {
            description = "";
        }
        spenContentWeb.setBody(CharUtils.fromHtml(description).toString());
        spenContentWeb.setTitle(title);
        spenContentWeb.setThumbnailPath(memoMetaDataItem.getImageFile().curFullPath);
        spenContentWeb.setState(4);
        spenContentWeb.setImageTypeId(1);
        spenContentWeb.setUri(memoMetaDataItem.getURL());
        String scrapBookHTMLPath = memoMetaDataItem.getScrapBookHTMLPath();
        if (scrapBookHTMLPath != null) {
            spenContentWeb.attachHTMLFile(scrapBookHTMLPath);
        }
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public String newUUID(Context context) {
        return UUIDUtils.newUUID(context.getApplicationContext());
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentContract
    public void logger_e(String str, String str2, Throwable th) {
        Logger.m11001e(str, str2, th);
    }

    private static Bitmap getCropBitmap(Bitmap bitmap, int i, int i2, int i4, int i5) {
        return getCropBitmap(bitmap, i, i2, i4, i5, true);
    }
}
